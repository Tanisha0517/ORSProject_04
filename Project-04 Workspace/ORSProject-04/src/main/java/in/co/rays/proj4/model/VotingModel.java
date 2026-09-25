package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.VotingBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class VotingModel extends BaseModel<VotingBean> {

	@Override
	public long add(VotingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		VotingBean existbean = findByVoterId(bean.getVoterId());

		if (existbean != null) {
			throw new DuplicateRecordException("Voter Id already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getVoterId());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getAge());
			pstmt.setString(5, bean.getConstituency());
			pstmt.setBoolean(6, bean.isHasVoted());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDateTime());
			pstmt.setTimestamp(10, bean.getModifiedDateTime());

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
	public void update(VotingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set voter_id = ?,name = ?,age = ?,constituency = ?, hasVoted = ?, modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getVoterId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAge());
			pstmt.setString(4, bean.getConstituency());
			pstmt.setBoolean(5, bean.isHasVoted());

//			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
//			pstmt.setTimestamp(8, bean.getCreatedDateTime());
			pstmt.setTimestamp(7, bean.getModifiedDateTime());
			pstmt.setLong(8, bean.getId());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public VotingBean findByVoterId(String voterId) {

		VotingBean bean = findByUniqueColumn("voter_Id", voterId);

		return bean;

	}

	@Override
	public String getWhereClause(VotingBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getVoterId() != null && bean.getVoterId().length() > 0) {
				sql.append(" and voter_id = '" + bean.getVoterId() + "'");
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getAge() != null && bean.getAge().length() > 0) {
				sql.append(" and age like '" + bean.getAge() + "%'");
			}

			if (bean.getConstituency() != null && bean.getConstituency().length() > 0) {
				sql.append(" and constituency like '" + bean.getConstituency() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_voter";
	}

	@Override
	public VotingBean getBean() {
		return new VotingBean();
	}

}
