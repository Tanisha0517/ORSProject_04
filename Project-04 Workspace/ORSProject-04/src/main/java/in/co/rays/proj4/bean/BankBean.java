package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankBean extends BaseBean {

	private String bankId;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String address;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setBankId(rs.getString("bank_id"));
			this.setBankName(rs.getString("bank_name"));
			this.setBranchName(rs.getString("branch_name"));
			this.setIfscCode(rs.getString("ifsc_code"));
			this.setAddress(rs.getString("address"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
