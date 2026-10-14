package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OnlineExaminationBean extends BaseBean {

	private String subject;
	private int totalQuestions;
	private int duration;
	private int totalMarks;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setSubject(rs.getString("subject"));
			this.setTotalQuestions(rs.getInt("total_questions"));
			this.setDuration(rs.getInt("duration"));
			this.setTotalMarks(rs.getInt("total_marks"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
