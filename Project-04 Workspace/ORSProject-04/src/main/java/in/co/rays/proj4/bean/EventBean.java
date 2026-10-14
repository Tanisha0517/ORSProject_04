package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventBean extends BaseBean {

	private String eventName;
	private String description;
	private String venue;
	private String organizer;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setEventName(rs.getString("event_name"));
			this.setDescription(rs.getString("description"));
			this.setVenue(rs.getString("venue"));
			this.setOrganizer(rs.getString("organizer"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
