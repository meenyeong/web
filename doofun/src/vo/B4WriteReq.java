package vo;

public class B4WriteReq {// before write
	
	int cseq;

	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	String id;
	String pnum;
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	String name;
	String csub; // subject
	String ccon; //content
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCsub() {
		return csub;
	}
	public String getCcon() {
		return ccon;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCsub(String csub) {
		this.csub = csub;
	}
	public void setCcon(String ccon) {
		this.ccon = ccon;
	}

}
