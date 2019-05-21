package vo;

import java.util.Date;

public class User {
	private String id;
	private String pwd;
	private String name;
	private Boolean userdrop;
	private String user_img;
	private String intro;
	private String tel;
	private Date date_reg;
	private Boolean planner_yn;
	private Boolean funder_yn;
	private int useq;
	private String tpage;
	private String zip;
	private String address;
	private String address2;
	
	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getTpage() {
		return tpage;
	}

	public void setTpage(String tpage) {
		this.tpage = tpage;
	}

	public User(String id, String pwd, String name, Boolean userdrop, String user_img, String intro, String tel,
			Date date_reg, Boolean planner_yn, Boolean funder_yn, int useq) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.userdrop = userdrop;
		this.user_img = user_img;
		this.intro = intro;
		this.tel = tel;
		this.date_reg = date_reg;
		this.planner_yn = planner_yn;
		this.funder_yn = funder_yn;
		this.useq = useq;
	}

	public int getUseq() {
		return useq;
	}

	public void setUseq(int useq) {
		this.useq = useq;
	}
	public User(String id, String pwd, String name, String intro, String tel) {

		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.intro = intro;
		this.tel = tel;
	}

	public User(String id, String pwd, String name, String intro, String tel, String zip, String address, String address2) {

		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.intro = intro;
		this.tel = tel;
		this.zip = zip;
		this.address = address;
		this.address2 = address2;
	}

	public Boolean getFunder_yn() {
		return funder_yn;
	}

	public void setFunder_yn(Boolean funder_yn) {
		this.funder_yn = funder_yn;
	}

	public User(String id, String pwd, String name) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public User() {
	}

	public User(String id, String pwd, String name, Boolean userdrop, String user_img, String intro, String tel,
			Date date_reg, Boolean planner_yn,Boolean funder_yn) {

		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.userdrop = userdrop;
		this.user_img = user_img;
		this.intro = intro;
		this.tel = tel;
		this.date_reg = date_reg;
		this.planner_yn = planner_yn;
		this.funder_yn = funder_yn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean matchPassword(String pwd) {
		return this.pwd.equals(pwd);
	}

	public String getName() {
		return name;
	}

	public User(String id, String pwd) {

		this.id = id;
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getUserdrop() {
		return userdrop;
	}

	public void setUserdrop(Boolean userdrop) {
		this.userdrop = userdrop;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDate_reg() {
		return date_reg;
	}

	public void setDate_reg(Date date_reg) {
		this.date_reg = date_reg;
	}

	public Boolean getPlanner_yn() {
		return planner_yn;
	}

	public void setPlanner_yn(Boolean planner_yn) {
		this.planner_yn = planner_yn;
	}

}
