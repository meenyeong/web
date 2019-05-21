package vo;

public class ProjectReq {
	

	private String pj_sub;
	private String pj_cate;
	private String pj_goal;
	private int pj_start;
	private int pj_fin;
	private String story;
	
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

	public String getPj_cate() {
		return pj_cate;
	}

	public void setPj_cate(String pj_cate) {
		this.pj_cate = pj_cate;
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

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

}
