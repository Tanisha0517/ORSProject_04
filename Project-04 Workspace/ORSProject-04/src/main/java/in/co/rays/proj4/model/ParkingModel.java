package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import in.co.rays.proj4.bean.ParkingBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class ParkingModel extends BaseModel<ParkingBean> {

	@Override
	public long add(ParkingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		ParkingBean existbean = findByVehicleNumber(bean.getVehicleNumber());

		if (existbean != null) {
			throw new DuplicateRecordException("Member Id already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getVehicleNumber());
			pstmt.setString(3, bean.getVehicleType());
			pstmt.setString(4, bean.getEntryTime());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDateTime());
			pstmt.setTimestamp(8, bean.getModifiedDateTime());

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
	public void update(ParkingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set vehicle_number = ?,vehicle_type = ?,entry_time = ?, modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getVehicleNumber());
			pstmt.setString(2, bean.getVehicleType());
			pstmt.setString(3, bean.getEntryTime());
//			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(4, bean.getModifiedBy());
//			pstmt.setTimestamp(8, bean.getCreatedDateTime());
			pstmt.setTimestamp(5, bean.getModifiedDateTime());
			pstmt.setLong(6, bean.getId());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public ParkingBean findByVehicleNumber(String vehicleNumber) {

		ParkingBean bean = findByUniqueColumn("vehicle_number", vehicleNumber);

		return bean;

	}

	@Override
	public String getWhereClause(ParkingBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getVehicleNumber() != null && bean.getVehicleNumber().length() > 0) {
				sql.append(" and vehicle_number = '" + bean.getVehicleNumber() + "'");			}

			if (bean.getVehicleType() != null && bean.getVehicleType().length() > 0) {
				sql.append(" and vehicle_type like '" + bean.getVehicleType() + "%'");
			}

			if (bean.getEntryTime() != null && bean.getEntryTime().length() > 0) {
				sql.append(" and entry_time like '" + bean.getEntryTime() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_parking";
	}

	@Override
	public ParkingBean getBean() {
		return new ParkingBean();
	}

}
