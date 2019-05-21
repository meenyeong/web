package vo;

import java.sql.Timestamp;

public class PjComment {
	private int pnum;
	private String feedback;
	private Timestamp date_feedback;
	private int status;

	
	public PjComment( String feedback, Timestamp date_feedback, int status) {
		super();
		this.feedback = feedback;
		this.date_feedback = date_feedback;
		this.status = status;
	}
	
	public PjComment(int pnum, String feedback, Timestamp date_feedback, int status) {
		super();
		this.pnum = pnum;
		this.feedback = feedback;
		this.date_feedback = date_feedback;
		this.status = status;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Timestamp getDate_feedback() {
		return date_feedback;
	}

	public void setDate_feedback(Timestamp date_feedback) {
		this.date_feedback = date_feedback;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public PjComment() {}
	

	
}
