package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VotingBean extends BaseBean {

	private String voterId;
	private String name;
	private String age;
	private String constituency;
	private boolean hasVoted;

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setVoterId(rs.getString("voter_id"));
			this.setName(rs.getString("name"));
			this.setAge(rs.getString("age"));
			this.setAge(rs.getString("age"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.setResultset(rs);
	}

}
