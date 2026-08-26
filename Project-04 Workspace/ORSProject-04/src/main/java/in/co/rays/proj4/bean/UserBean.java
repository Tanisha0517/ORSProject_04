package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserBean extends BaseBean {

	public String firstName;
	public String lastName;
	public String login;
	public String password;
	public Date dob;
	public String mobileNo;
	public long roleId;
	public int unsuccessfulLogin;
	public String gender;
	public Date lastLogin;
	public String userLock;
	public String registeredIp;
	public String lastLoginIp;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public int getUnsuccessfulLogin() {
		return unsuccessfulLogin;
	}

	public void setUnsuccessfulLogin(int unsuccessfulLogin) {
		this.unsuccessfulLogin = unsuccessfulLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getUserLock() {
		return userLock;
	}

	public void setUserLock(String userLock) {
		this.userLock = userLock;
	}

	public String getRegisteredIp() {
		return registeredIp;
	}

	public void setRegisteredIp(String registeredIp) {
		this.registeredIp = registeredIp;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setFirstName(rs.getString("first_name"));
			this.setLastName(rs.getString("last_name"));
			this.setLogin(rs.getString("login"));
			this.setPassword(rs.getString("password"));
			this.setDob(rs.getDate("dob"));
			this.setMobileNo(rs.getString("mobile_no"));
			this.setRoleId(rs.getLong("role_id"));
			this.setUnsuccessfulLogin(rs.getInt("unsuccessful_login"));
			this.setGender(rs.getString("gender"));
			this.setLastLogin(rs.getTimestamp("last_login"));
			this.setUserLock(rs.getString("user_lock"));
			this.setRegisteredIp(rs.getString("registered_ip"));
			this.setLastLoginIp(rs.getString("last_login_ip"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
