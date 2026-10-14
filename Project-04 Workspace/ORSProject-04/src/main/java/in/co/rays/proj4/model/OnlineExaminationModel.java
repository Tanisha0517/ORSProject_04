package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.OnlineExaminationBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class OnlineExaminationModel extends BaseModel<OnlineExaminationBean> {

	@Override
	public long add(OnlineExaminationBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		OnlineExaminationBean existbean = findBySubject(bean.getSubject());

		if (existbean != null) {
			throw new DuplicateRecordException("Subject already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getSubject());
			pstmt.setInt(3, bean.getTotalQuestions());
			pstmt.setInt(4, bean.getDuration());
			pstmt.setInt(5, bean.getTotalMarks());

			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDateTime());
			pstmt.setTimestamp(9, bean.getModifiedDateTime());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean.getId();
	}

	@Override
	public void update(OnlineExaminationBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set subject = ?,total_questions = ?,duration = ?,total_marks = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getSubject());
			pstmt.setInt(2, bean.getTotalQuestions());
			pstmt.setInt(3, bean.getDuration());
			pstmt.setInt(4, bean.getTotalMarks());

//			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
//			pstmt.setTimestamp(8, bean.getCreatedDateTime());
			pstmt.setTimestamp(6, bean.getModifiedDateTime());
			pstmt.setLong(7, bean.getId());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public OnlineExaminationBean findBySubject(String subject) {

		OnlineExaminationBean bean = findByUniqueColumn("subject", subject);

		return bean;

	}

	@Override
	public String getWhereClause(OnlineExaminationBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getSubject() != null && bean.getSubject().length() > 0) {
				sql.append(" and subject = '" + bean.getSubject() + "'");
			}

			if (bean.getTotalQuestions() > 0) {
				sql.append(" and total_questions = " + bean.getTotalQuestions());
			}

			if (bean.getDuration() > 0) {
				sql.append(" and duration = " + bean.getDuration());
			}

			if (bean.getTotalMarks() > 0) {
				sql.append(" and total_marks = " + bean.getTotalMarks());
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_onlineexam";
	}

	@Override
	public OnlineExaminationBean getBean() {
		return new OnlineExaminationBean();
	}

}
