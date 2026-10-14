package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.EventBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class EventModel extends BaseModel<EventBean> {

	@Override
	public long add(EventBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		EventBean existbean = findByEventName(bean.getEventName());

		if (existbean != null) {
			throw new DuplicateRecordException("Event Name already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getEventName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getVenue());
			pstmt.setString(5, bean.getOrganizer());
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
	public void update(EventBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set event_name = ?,description = ?,venue = ?,organizer = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getEventName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setString(3, bean.getVenue());
			pstmt.setString(4, bean.getOrganizer());
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

	public EventBean findByEventName(String eventName) {

		EventBean bean = findByUniqueColumn("event_name", eventName);

		return bean;

	}

	@Override
	public String getWhereClause(EventBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getEventName() != null && bean.getEventName().length() > 0) {
				sql.append(" and event_name like '" + bean.getEventName() + "%'");
			}

			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append(" and description like '" + bean.getDescription() + "%'");
			}

			if (bean.getVenue() != null && bean.getVenue().length() > 0) {
				sql.append(" and venue like '" + bean.getVenue() + "%'");
			}

			if (bean.getOrganizer() != null && bean.getOrganizer().length() > 0) {
				sql.append(" and organizer like '" + bean.getOrganizer() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_event";
	}

	@Override
	public EventBean getBean() {
		return new EventBean();
	}

}
