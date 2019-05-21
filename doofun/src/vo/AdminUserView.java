package vo;



public class AdminUserView {
	private int pnum;	
	private String subject;	
	private String id;	
	private int fseq;
	private int funded;
	private int payment;
	private int useq;
	
	
	public AdminUserView(int pnum, String subject, String id, int fseq, int funded, int payment, int useq) {
		super();
		this.pnum = pnum;
		this.subject = subject;
		this.id = id;
		this.fseq = fseq;
		this.funded = funded;
		this.payment = payment;
		this.useq = useq;
	}

	public int getUseq() {
		return useq;
	}

	public void setUseq(int useq) {
		this.useq = useq;
	}

	public AdminUserView() {
		
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFseq() {
		return fseq;
	}

	public void setFseq(int fseq) {
		this.fseq = fseq;
	}

	public int getFunded() {
		return funded;
	}

	public void setFunded(int funded) {
		this.funded = funded;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public AdminUserView(int pnum, String subject, String id, int fseq, int funded, int payment) {
		super();
		this.pnum = pnum;
		this.subject = subject;
		this.id = id;
		this.fseq = fseq;
		this.funded = funded;
		this.payment = payment;
	}


	
	
	
}
