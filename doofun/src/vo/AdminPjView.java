package vo;

import java.sql.Timestamp;
import java.util.Date;

public class AdminPjView {
	private int pnum;
	private String id;
	private String subject;
	private String contents;
	private String category;
	private int goal;
	private String date_start;
	private String date_fin;
	private String image;
	private Date date_req;
	private String feedback;
	private Timestamp date_feedback;
	private int status;
	private int useq;
	private int c_status;
	private int pick;
	
	
	public int getPick() {
		return pick;
	}

	public void setPick(int pick) {
		this.pick = pick;
	}

	public AdminPjView(int pnum, String id, String subject, String contents, String category, int goal,
			String date_start, String date_fin, String image, Date date_req, String feedback, Timestamp date_feedback,
			int status, int useq, int c_status,int pick) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.contents = contents;
		this.category = category;
		this.goal = goal;
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.image = image;
		this.date_req = date_req;
		this.feedback = feedback;
		this.date_feedback = date_feedback;
		this.status = status;
		this.useq = useq;
		this.c_status = c_status;
		this.pick = pick;
	}
	public AdminPjView(int pnum, String id, String subject, String contents, String category, int goal,
			String date_start, String date_fin, String image, Date date_req, String feedback, Timestamp date_feedback,
			int status, int useq, int c_status) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.contents = contents;
		this.category = category;
		this.goal = goal;
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.image = image;
		this.date_req = date_req;
		this.feedback = feedback;
		this.date_feedback = date_feedback;
		this.status = status;
		this.useq = useq;
		this.c_status = c_status;	
	}

	public int getC_status() {
		return c_status;
	}

	public void setC_status(int c_status) {
		this.c_status = c_status;
	}

	public AdminPjView(int pnum, String id, String subject, String contents, String category, int goal,
			String date_start, String date_fin, String image, Date date_req, String feedback, Timestamp date_feedback,
			int status, int useq) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.contents = contents;
		this.category = category;
		this.goal = goal;
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.image = image;
		this.date_req = date_req;
		this.feedback = feedback;
		this.date_feedback = date_feedback;
		this.status = status;
		this.useq = useq;
	}

	public int getUseq() {
		return useq;
	}

	public void setUseq(int useq) {
		this.useq = useq;
	}

	public AdminPjView(int pnum, String id, String subject, String contents, String category, int goal, String date_start,
			String date_fin, String image, Date date_req, String feedback, Timestamp date_feedback, int status
			) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.contents = contents;
		this.category = category;
		this.goal = goal;
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.image = image;
		this.date_req = date_req;
		this.feedback = feedback;
		this.date_feedback = date_feedback;
		this.status = status;
		
	}
	public AdminPjView(int pnum, String id, String subject, String category,int useq
			) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;		
		this.category = category;
		this.useq=useq;
	}
	public AdminPjView(int pnum, String id, String subject, String category
			) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;		
		this.category = category;
		
	}
	public AdminPjView(int pnum, String id, int useq
			) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.useq = useq;		
		
		
	}
	public AdminPjView() {
		
	}
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDate_req() {
		return date_req;
	}
	public void setDate_req(Date date_req) {
		this.date_req = date_req;
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

	
	
}
