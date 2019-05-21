package vo;

public class UserFundingView {

	private int pnum;
	private String name;
	private String subject;
	private String category;
	private int c_status;
	private String image;
	private String gift_name1;
	private String gift_name2;
	private String gift_name3;
	private String id;
	private int payment;
	private int number;
	private int funded;
	private int heart_quantity;
	private String giftname;
	private String tel;
	private String zip;
	private String address;
	private String address2;
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
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
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getC_status() {
		return c_status;
	}
	public void setC_status(int c_status) {
		this.c_status = c_status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getGift_name3() {
		return gift_name3;
	}
	public void setGift_name3(String gift_name3) {
		this.gift_name3 = gift_name3;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFunded() {
		return funded;
	}
	public void setFunded(int funded) {
		this.funded = funded;
	}
	public int getHeart_quantity() {
		return heart_quantity;
	}
	public void setHeart_quantity(int heart_quantity) {
		this.heart_quantity = heart_quantity;
	}
	public String getGiftname() {
		return giftname;
	}
	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}
	public UserFundingView(int pnum, String name, String subject, String category, int c_status, String image,
			String gift_name1, String gift_name2, String gift_name3, String id, int payment, int number, int funded,
			int heart_quantity) {
		super();
		this.pnum = pnum;
		this.name = name;
		this.subject = subject;
		this.category = category;
		this.c_status = c_status;
		this.image = image;
		this.gift_name1 = gift_name1;
		this.gift_name2 = gift_name2;
		this.gift_name3 = gift_name3;
		this.id = id;
		this.payment = payment;
		this.number = number;
		this.funded = funded;
		this.heart_quantity = heart_quantity;
	}
	public UserFundingView() {}
	
	
}
