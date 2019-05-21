package vo;

public class LikeReq {

	public LikeReq() {
		
	}
	private int pnum;
	private int useq;
	private int like_yn;

	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public int getLike_yn() {
		return like_yn;
	}
	public void setLike_yn(int like_yn) {
		this.like_yn = like_yn;
	}
	public LikeReq(int pnum, int useq, int like_yn) {
		super();
		this.pnum = pnum;
		this.useq = useq;
		this.like_yn = like_yn;
	}
	

	
	
	
	
	
	
}
