package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.BookBean;
import in.co.rays.proj4.bean.HostelBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class HostelModel extends BaseModel<HostelBean> {

	@Override
	public long add(HostelBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		HostelBean existbean = findByContactNo(bean.getContactNo());

		if (existbean != null) {
			throw new DuplicateRecordException("Contact No already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getHostelName());
			pstmt.setString(3, bean.getHostelType());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setString(5, bean.getWardenName());
			pstmt.setString(6, bean.getAddress());
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
	public void update(HostelBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set hostel_name = ?,hostel_type = ?,contact_no = ?,warden_name = ?,address = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getHostelName());
			pstmt.setString(2, bean.getHostelType());
			pstmt.setString(3, bean.getContactNo());
			pstmt.setString(4, bean.getWardenName());
			pstmt.setString(5, bean.getAddress());
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

	public HostelBean findByContactNo(String contactNo) {

		HostelBean bean = findByUniqueColumn("contact_no", contactNo);

		return bean;

	}

	@Override
	public String getWhereClause(HostelBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getHostelName() != null && bean.getHostelName().length() > 0) {
				sql.append(" and hostel_name like '" + bean.getHostelName() + "%'");
			}

			if (bean.getHostelType() != null && bean.getHostelType().length() > 0) {
				sql.append(" and hostel_type like '" + bean.getHostelType() + "%'");
			}

			if (bean.getContactNo() != null && bean.getContactNo().length() > 0) {
				sql.append(" and contact_no like '" + bean.getContactNo() + "%'");
			}

			if (bean.getWardenName() != null && bean.getWardenName().length() > 0) {
				sql.append(" and warden_name like '" + bean.getWardenName() + "%'");
			}

			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				sql.append(" and address like '" + bean.getAddress() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_hostel";
	}

	@Override
	public HostelBean getBean() {
		return new HostelBean();
	}

}
