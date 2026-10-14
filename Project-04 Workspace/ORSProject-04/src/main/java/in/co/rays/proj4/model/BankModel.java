package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.BankBean;
import in.co.rays.proj4.bean.RestaurantBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class BankModel extends BaseModel<BankBean>{

	@Override
	public long add(BankBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		BankBean existbean = findByBankId(bean.getBankId());

		if (existbean != null) {
			throw new DuplicateRecordException("Bank Id already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getBankId());
			pstmt.setString(3, bean.getBankName());
			pstmt.setString(4, bean.getBranchName());
			pstmt.setString(5, bean.getIfscCode());
			pstmt.setString(6, bean.getBranchName());
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
	public void update(BankBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set bank_id = ?,bank_name = ?,branch_name = ?,ifsc_code = ?,address = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getBankId());
			pstmt.setString(2, bean.getBankName());
			pstmt.setString(3, bean.getBranchName());
			pstmt.setString(4, bean.getIfscCode());
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
	
	public BankBean findByBankId(String bankId) {

		BankBean bean = findByUniqueColumn("bank_id", bankId);

		return bean;

	}

	@Override
	public String getWhereClause(BankBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getBankId() != null && bean.getBankId().length() > 0) {
				sql.append(" and bank_id = '" + bean.getBankId() + "'");
			}

			if (bean.getBankName() != null && bean.getBankName().length() > 0) {
				sql.append(" and bank_name like '" + bean.getBankName() + "%'");
			}

			if (bean.getBranchName() != null && bean.getBranchName().length() > 0) {
				sql.append(" and branch_name like '" + bean.getBranchName() + "%'");
			}

			if (bean.getIfscCode() != null && bean.getIfscCode().length() > 0) {
				sql.append(" and ifsc_code like '" + bean.getIfscCode() + "%'");
			}
			
			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				sql.append(" and address like '" + bean.getAddress() + "%'");
			}

			

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_bank";
	}

	@Override
	public BankBean getBean() {
		return new BankBean();
	}

}
