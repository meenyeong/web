package service;



import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import vo.RegisterReq;
import vo.User;

public class UserRegisterService {

	private UserDao userDao;

	@Autowired
	public UserRegisterService(UserDao userDao) {
		this.userDao = userDao;
	}

	public void register(RegisterReq req) throws Exception {
		//
			// 가입 전에 존재하는 이메일인지 확인하기
//int result = userDao.confirmEmail(req.getEmail());
			
/*			if(result != -1) {
				throw new AlreadyExistingUserException("dup email " + req.getEmail());
			}else {*/
			req.setPassword(encSHA256(req.getPassword()));
		
			User user = new User(
					req.getEmail(), req.getPassword(), req.getName(), req.getIntro(), req.getTel(), req.getZip(), req.getAddress(), req.getAddress2());
			userDao.userInsert(user);
			/*}*/
	}


	
	public User read(String key) throws Exception {
		User user= userDao.search(key);
		return user;
	}

	public void update(User userinfo) throws SQLException {
		userDao.userUpdate(userinfo);
		
	}

	public void updatePw(User userinfo) throws Exception {
		userinfo.setPwd(encSHA256(userinfo.getPwd()));
		userDao.userUpdatePw(userinfo);
		
	}

	public int checkNickname(String temp_name)  {
		String temp="";
		//글자검사 : 조건 temp_name에 한글 숫자 영문 이외의 글자가 들어가있으면안됨
		int status=1; //가능상태에서 검사를 시작한다.
		
		
		//2) 첫번째 배열에 대해서 글자수대로 쪼갠다
		String[] id_scan = temp_name.split("");
		for (int i=0; i<temp_name.length(); i++) {
		
				
			//3)잘쪼개짐 ->앞에 
			//4)그댐에 영어인지 숫자인지 검사하자 -> 그외 out

			   if (Pattern.matches("[0-9]", id_scan[i])) {}
			
			   else if (Pattern.matches("[A-Z]",id_scan[i])) {}

			   else if (Pattern.matches("[a-z]", id_scan[i])) {}

			   else if (Pattern.matches("[가-힣]", id_scan[i])){}
			   else
			    {System.out.println("기타:d"); status=0; break;} //불가능하므로 상태변경후 탈출
		}
		
		if (status== 1) { //가능한 닉네임일때 db내 중복검사 시작
		try {
			temp = userDao.checkByName(temp_name); //결과가 있다면 찾아서 저장
		} catch (SQLException e) {
			e.printStackTrace();} 	}
		
		if (temp!="") status=0; //안비어있는 모든경우에 대해 불가능;
		
		return status;
	}

    public String encSHA256 (String password) throws Exception {
    	  MessageDigest md = MessageDigest.getInstance("SHA-256");
    	  byte[] mdResult = md.digest(password.getBytes());
  		  @SuppressWarnings("restriction")
  		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();

  		  @SuppressWarnings("restriction")
  		String str = encoder.encode(mdResult);
    	  
    	  return str;  
      }
	
	}