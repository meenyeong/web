package vo;

public class CommentVO {
	int cseq;
	int bcseq;
	String id;
	String name;
	String bccon;
	String bcdate;
	String bcdate2;
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public int getBcseq() {
		return bcseq;
	}
	public void setBcseq(int bcseq) {
		this.bcseq = bcseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBccon() {
		return bccon;
	}
	public void setBccon(String bccon) {
		this.bccon = bccon;
	}
	public String getBcdate() {
		return bcdate;
	}
	public void setBcdate(String bcdate) {
		this.bcdate = bcdate;
	}
	public String getBcdate2() {
		return bcdate2;
	}
	public void setBcdate2(String bcdate2) {
		this.bcdate2 = bcdate2;
	}
	public CommentVO() {
		super();
	}
	public CommentVO(int cseq, int bcseq, String id, String name, String bccon, String bcdate, String bcdate2) {
		super();
		this.cseq = cseq;
		this.bcseq = bcseq;
		this.id = id;
		this.name = name;
		this.bccon = bccon;
		this.bcdate = bcdate;
		this.bcdate2 = bcdate2;
	}
	

}
