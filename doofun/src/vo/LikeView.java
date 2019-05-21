package vo;

public class LikeView {

	public LikeView() {
		
	}
	private int pnum;
	private String subject;
	private int count;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LikeView(int pnum, String subject, int count) {
		super();
		this.pnum = pnum;
		this.subject = subject;
		this.count = count;
	}

	
	
}
