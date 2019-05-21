package vo;

public class AdminRequestReq  {
	private int pnum;
	private String req_content;
	private int req_status;
	private String req_comm;
	
	
	public AdminRequestReq() {
		
	}


	public int getPnum() {
		return pnum;
	}


	public void setPnum(int pnum) {
		this.pnum = pnum;
	}


	public String getReq_content() {
		return req_content;
	}


	public void setReq_content(String req_content) {
		this.req_content = req_content;
	}


	public int getReq_status() {
		return req_status;
	}


	public void setReq_status(int req_status) {
		this.req_status = req_status;
	}


	public String getReq_comm() {
		return req_comm;
	}


	public void setReq_comm(String req_comm) {
		this.req_comm = req_comm;
	}


	public AdminRequestReq(int pnum, String req_content, int req_status, String req_comm) {
		super();
		this.pnum = pnum;
		this.req_content = req_content;
		this.req_status = req_status;
		this.req_comm = req_comm;
	}
	
	
	
	

}

