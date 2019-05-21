package vo;

public class LoginSubmit {
	private String id;
	private String pw;
	private String name;
	
	public LoginSubmit(String id, String pw, String name) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LoginSubmit(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpw() {
		return pw;
	}

	public void setpw(String pw) {
		this.pw = pw;
	}
}
