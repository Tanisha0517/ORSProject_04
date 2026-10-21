package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HostelBean extends BaseBean {

	private String hostelName;
	private String hostelType;
	private String contactNo;
	private String wardenName;
	private String address;

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public String getHostelType() {
		return hostelType;
	}

	public void setHostelType(String hostelType) {
		this.hostelType = hostelType;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getWardenName() {
		return wardenName;
	}

	public void setWardenName(String wardenName) {
		this.wardenName = wardenName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setHostelName(rs.getString("hostel_name"));
			this.setHostelType(rs.getString("hostel_type"));
			this.setContactNo(rs.getString("contact_no"));
			this.setWardenName(rs.getString("warden_name"));
			this.setAddress(rs.getString("address"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValue() {
		return null;
	}

}
