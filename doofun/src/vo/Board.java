package vo;

import java.sql.Date;

public class Board {
	int cseq;
	int pnum;
	String id;
	String name;
	String csub; // subject
	String ccon; //content
	Date cdate;
	Date cdate2;
	int useq;
	String pjsub;
	
	public Board(int cseq, int pnum, String id, String name, String csub,  Date cdate, Date cdate2,
			int useq, String pjsub) {
		super();
		this.cseq = cseq;
		this.pnum = pnum;
		this.id = id;
		this.name = name;
		this.csub = csub;
		this.ccon = ccon;
		this.cdate = cdate;
		this.cdate2 = cdate2;
		this.useq = useq;
		this.pjsub = pjsub;
	}

	public String getPjsub() {
		return pjsub;
	}

	public void setPjsub(String pjsub) {
		this.pjsub = pjsub;
	}

	public Board() {
		
	}
	
	public Board(int cseq, int pnum, String id, String name, String csub, String ccon, Date cdate, Date cdate2, int useq) {
		super();
		this.cseq = cseq;
		this.pnum = pnum;
		this.id = id;
		this.name = name;
		this.csub = csub;
		this.ccon = ccon;
		this.cdate = cdate;
		this.cdate2 = cdate2;
		this.useq = useq;
	}
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public int getCseq() {
		return cseq;
	}
	public int getPnum() {
		return pnum;
	}
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
	public Date getCdate() {
		return cdate;
	}
	public Date getCdate2() {
		return cdate2;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
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
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public void setCdate2(Date cdate2) {
		this.cdate2 = cdate2;
	}
	public Board(String id, String name, String csub, String ccon, String pnum) {
		super();
		if (pnum.equals(""))  new Board(id,name,csub,ccon);
		
		else {this.id = id;
		this.name = name;
		this.csub = csub;
		this.ccon = ccon;
		this.pnum = Integer.parseInt(pnum);}
	}
	public Board(String id, String name, String csub, String ccon) {
		super();
		this.id = id;
		this.name = name;
		this.csub = csub;
		this.ccon = ccon;
		this.pnum = 0;
	}
	public Board(int cseq, int pnum, String id, String name, String csub, String ccon, Date cdate, Date cdate2) {
		super();
		this.cseq = cseq;
		this.pnum = pnum;
		this.id = id;
		this.name = name;
		this.csub = csub;
		this.ccon = ccon;
		this.cdate = cdate;
		this.cdate2 = cdate2;
	}
	
	public Board(int cseq, int pnum, String id, String name, String csub, String ccon, Date cdate, Date cdate2, String pjsub) {
		super();
		this.cseq = cseq;
		this.pnum = pnum;
		this.id = id;
		this.name = name;
		this.csub = csub;
		this.ccon = ccon;
		this.cdate = cdate;
		this.cdate2 = cdate2;
		this.pjsub = pjsub;
	}
	public Board(String name, int cseq, String csub, String ccon) {
		super();
		this.name = name;
		this.cseq = cseq;
		this.csub = csub;
		this.ccon = ccon;
	}

	

	
	
}
