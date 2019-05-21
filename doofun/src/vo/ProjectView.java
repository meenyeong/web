package vo;

public class ProjectView {

	private int pnum;
	private String pj_id;
	private String pj_sub;
	private String pj_img;
	private String pj_cate;
	private String pl_img;
	private String pl_name;
	private String pl_info;
	private String pj_goal;
	private int pj_start;
	private int pj_fin;
	private String pj_req;
	private int min_price1;
	private String gift_name1;
	private int min_price2;
	private String gift_name2;
	private int min_price3;
	private String gift_name3;
	private String story;
	private int req_status;
	private String req_comm;
	private String req_content;
	private int heartcount;	
	private long dday;
	private long sum;
	private int percent;
	private int status;
	private String feedback;
	private String giftname;
	private int c_status;
	private int num;
	


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getC_status() {
		return c_status;
	}


	public void setC_status(int c_status) {
		this.c_status = c_status;
	}


	public String getGiftname() {
		return giftname;
	}


	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public long getSum() {
		return sum;
	}


	public void setSum(long sum) {
		this.sum = sum;
	}


	public int getPercent() {
		return percent;
	}


	public void setPercent(int percent) {
		this.percent = percent;
	}


	public long getDday() {
		return dday;
	}


	public void setDday(long dday) {
		this.dday = dday;
	}


	public int getHeartcount() {
		return heartcount;
	}


	public void setHeartcount(int heartcount) {
		this.heartcount = heartcount;
	}


	public ProjectView() {
		
	}
	

	public String getPj_id() {
		return pj_id;
	}


	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}


	public String getPj_req() {
		return pj_req;
	}


	public void setPj_req(String pj_req) {
		this.pj_req = pj_req;
	}


	public ProjectView(int pnum) {
		this.pnum = pnum;
	}

	public ProjectView(String pj_sub) {
		this.pj_sub = pj_sub;
	}
	
	public ProjectView(String pj_sub, String pj_img, String pj_cate, String pj_goal, int pj_start, int pj_fin, String story) {
		this.pj_sub = pj_sub;
		this.pj_img = pj_img;
		this.pj_cate = pj_cate;
		this.pj_goal = pj_goal;
		this.pj_start = pj_start;
		this.pj_fin = pj_fin;
		this.story = story;
	}

	public ProjectView(int pnum, String pl_img, String pl_name, String pl_info) {
		this.pnum = pnum;
		this.pl_img = pl_img;
		this.pl_name = pl_name;
		this.pl_info = pl_info;
	}

	public ProjectView(int pnum, int min_price1, String gift_name1, int min_price2, String gift_name2, int min_price3, String gift_name3) {
		this.pnum = pnum;
		this.min_price1 = min_price1;
		this.gift_name2 = gift_name2;
		this.min_price3 = min_price3;
		this.gift_name1 = gift_name1;
		this.min_price2 = min_price2;
		this.gift_name3 = gift_name3;
	}


	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getPj_start() {
		return pj_start;
	}

	public void setPj_start(int pj_start) {
		this.pj_start = pj_start;
	}

	public String getPj_sub() {
		return pj_sub;
	}

	public void setPj_sub(String pj_sub) {
		this.pj_sub = pj_sub;
	}

	public String getPj_img() {
		return pj_img;
	}

	public void setPj_img(String pj_img) {
		this.pj_img = pj_img;
	}

	public String getPj_cate() {
		return pj_cate;
	}

	public void setPj_cate(String pj_cate) {
		this.pj_cate = pj_cate;
	}

	public String getPl_img() {
		return pl_img;
	}

	public void setPl_img(String pl_img) {
		this.pl_img = pl_img;
	}

	public String getPl_name() {
		return pl_name;
	}

	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}

	public String getPl_info() {
		return pl_info;
	}

	public void setPl_info(String pl_info) {
		this.pl_info = pl_info;
	}

	public String getPj_goal() {
		return pj_goal;
	}

	public void setPj_goal(String pj_goal) {
		this.pj_goal = pj_goal;
	}

	public int getPj_fin() {
		return pj_fin;
	}

	public void setPj_fin(int pj_fin) {
		this.pj_fin = pj_fin;
	}


	public String getGift_name1() {
		return gift_name1;
	}

	public void setGift_name1(String gift_name1) {
		this.gift_name1 = gift_name1;
	}

	public String getGift_name2() {
		return gift_name2;
	}

	public void setGift_name2(String gift_name2) {
		this.gift_name2 = gift_name2;
	}


	public int getMin_price1() {
		return min_price1;
	}

	public void setMin_price1(int min_price1) {
		this.min_price1 = min_price1;
	}

	public int getMin_price2() {
		return min_price2;
	}

	public void setMin_price2(int min_price2) {
		this.min_price2 = min_price2;
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

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
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


	public String getReq_content() {
		return req_content;
	}


	public void setReq_content(String req_content) {
		this.req_content = req_content;
	}


	
	public ProjectView(int pnum, String pj_sub, String pj_id, String pj_img, String pj_cate, String pl_name, String pj_goal, int req_status, int pj_fin) { 
		super();
		this.pnum = pnum;
		this.pj_sub = pj_sub;
		this.pj_id = pj_id;
		this.pj_img = pj_img;
		this.pj_cate = pj_cate;
		this.pl_name = pl_name;
		this.pj_goal = pj_goal;
		this.req_status = req_status;
		this.pj_fin = pj_fin;
		
	}
	public ProjectView(int pnum, String pj_sub, String pj_id, String pj_img, String pj_cate, String pl_name, String pj_goal, int req_status, int pj_fin, int status, int c_status) { 
		super();
		this.pnum = pnum;
		this.pj_sub = pj_sub;
		this.pj_id = pj_id;
		this.pj_img = pj_img;
		this.pj_cate = pj_cate;
		this.pl_name = pl_name;
		this.pj_goal = pj_goal;
		this.req_status = req_status;
		this.pj_fin = pj_fin;
		this.status = status;
		this.c_status = c_status;
	}
	
	
	
	public ProjectView(int pnum, String pj_sub, String pj_id, String pj_img, String pj_cate, String pl_name, String pj_goal, int pj_fin, long sum) { //둘러보기용
		super();
		this.pnum = pnum;
		this.pj_sub = pj_sub;
		this.pj_id = pj_id;
		this.pj_img = pj_img;
		this.pj_cate = pj_cate;
		this.pl_name = pl_name;
		this.pj_goal = pj_goal;
		this.pj_fin = pj_fin;
		this.sum = sum;
	}

}
