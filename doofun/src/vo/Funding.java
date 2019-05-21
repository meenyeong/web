package vo;

public class Funding {
	int pnum;
	int fseq;
	int funded;
	int number;
	String id;
	int payment; // 미결제 결제 취소

	public Funding(){
		
	}
	
	public Funding(int pnum, int fseq, int funded, int number, String id, int payment) {
		super();
		this.pnum = pnum;
		this.fseq = fseq;
		this.funded = funded;
		this.number = number;
		this.id = id;
		this.payment = payment;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
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


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
