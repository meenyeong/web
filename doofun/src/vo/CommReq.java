package vo;

public class CommReq {
	String name;
	int cseq;
	int bcseq;
	String newComm;
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
	public String getNewComm() {
		return newComm;
	}
	public void setNewComm(String newComm) {
		this.newComm = newComm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
