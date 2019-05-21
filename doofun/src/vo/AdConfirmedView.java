package vo;

public class AdConfirmedView {
	private int pnum;
	private String id;
	private String subject;
	private String image;
	private String category;
	private String pl_img;
	private String name;
	private String pl_info;
	private String goal;
	private int date_start;
	private int date_fin;
	private String date_req;
	private int min_price1;
	private String gift_name1;
	private int min_price2;
	private String gift_name2;
	private int min_price3;
	private String gift_name3;
	private String contents;
	private int useq;
	private int c_status;
	private int req_status;
	private String req_comm;
	
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

	public AdConfirmedView() {
		
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPl_img() {
		return pl_img;
	}

	public void setPl_img(String pl_img) {
		this.pl_img = pl_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPl_info() {
		return pl_info;
	}

	public void setPl_info(String pl_info) {
		this.pl_info = pl_info;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public int getDate_start() {
		return date_start;
	}

	public void setDate_start(int date_start) {
		this.date_start = date_start;
	}

	public int getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(int date_fin) {
		this.date_fin = date_fin;
	}

	public String getDate_req() {
		return date_req;
	}

	public void setDate_req(String date_req) {
		this.date_req = date_req;
	}

	public int getMin_price1() {
		return min_price1;
	}

	public void setMin_price1(int min_price1) {
		this.min_price1 = min_price1;
	}

	public String getGift_name1() {
		return gift_name1;
	}

	public void setGift_name1(String gift_name1) {
		this.gift_name1 = gift_name1;
	}

	public int getMin_price2() {
		return min_price2;
	}

	public void setMin_price2(int min_price2) {
		this.min_price2 = min_price2;
	}

	public String getGift_name2() {
		return gift_name2;
	}

	public void setGift_name2(String gift_name2) {
		this.gift_name2 = gift_name2;
	}

	public int getMin_price3() {
		return min_price3;
	}

	public void setMin_price3(int min_price3) {
		this.min_price3 = min_price3;
	}

	public String getGift_name3() {
		return gift_name3;
	}

	public void setGift_name3(String gift_name3) {
		this.gift_name3 = gift_name3;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getUseq() {
		return useq;
	}

	public void setUseq(int useq) {
		this.useq = useq;
	}

	public int getC_status() {
		return c_status;
	}

	public void setC_status(int c_status) {
		this.c_status = c_status;
	}
	public AdConfirmedView(int pnum, int c_status) {
		super();
		this.pnum = pnum;
		this.c_status = c_status;
	}
	public AdConfirmedView(int pnum, String id, String subject, String image, String category, String pl_img,
			String name, String pl_info, String goal, int date_start, int date_fin, String date_req, int min_price1,
			String gift_name1, int min_price2, String gift_name2, int min_price3, String gift_name3, String contents,
			int useq, int c_status) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.image = image;
		this.category = category;
		this.pl_img = pl_img;
		this.name = name;
		this.pl_info = pl_info;
		this.goal = goal;
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.date_req = date_req;
		this.min_price1 = min_price1;
		this.gift_name1 = gift_name1;
		this.min_price2 = min_price2;
		this.gift_name2 = gift_name2;
		this.min_price3 = min_price3;
		this.gift_name3 = gift_name3;
		this.contents = contents;
		this.useq = useq;
		this.c_status = c_status;
	}

	public AdConfirmedView(int pnum, String id, String subject, String image, String category, String pl_img,
			String name, String pl_info, String goal, int date_start, int date_fin, String date_req, int min_price1,
			String gift_name1, int min_price2, String gift_name2, int min_price3, String gift_name3, String contents,
			int useq, int c_status, int req_status, String req_comm) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.image = image;
		this.category = category;
		this.pl_img = pl_img;
		this.name = name;
		this.pl_info = pl_info;
		this.goal = goal;
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.date_req = date_req;
		this.min_price1 = min_price1;
		this.gift_name1 = gift_name1;
		this.min_price2 = min_price2;
		this.gift_name2 = gift_name2;
		this.min_price3 = min_price3;
		this.gift_name3 = gift_name3;
		this.contents = contents;
		this.useq = useq;
		this.c_status = c_status;
		this.req_status = req_status;
		this.req_comm = req_comm;
	}
	
	public AdConfirmedView(int pnum, String id, String subject, String category, 
			int date_start, int date_fin, String date_req, 
			int useq, int c_status, int req_status) {
		super();
		this.pnum = pnum;
		this.id = id;
		this.subject = subject;
		this.category = category;		
		this.date_start = date_start;
		this.date_fin = date_fin;
		this.date_req = date_req;		
		this.useq = useq;
		this.c_status = c_status;
		this.req_status = req_status;		
	}

}
