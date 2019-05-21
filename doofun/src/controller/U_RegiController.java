package controller;

import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.UserDao;
import service.UserRegisterService;
import vo.LoginSubmit;
import vo.RegisterReq;
import vo.User;
	
@Controller
public class U_RegiController {
	


	// 의존성 객체 주입
	private UserRegisterService userRegisterService;
	User userinfo= null;

	public void setUserRegisterService(UserRegisterService userRegisterService) {
		this.userRegisterService = userRegisterService;
	}

	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//1.회원가입폼 post step2
	@RequestMapping(value = "/join")
	public String handleStep2(Model model) {
			// 약관 동의를 했다면 RegisterRequest(VO)를 저장하기
		model.addAttribute("registerRequest", new RegisterReq());
		return "user/joinForm";
	}
	
	//1-2. id체크
	
	@RequestMapping(value = "/idcheck={temp_email}.{temp2}")
	public String checkId(Model model, @PathVariable String temp_email, @PathVariable String temp2) throws Exception {
		
			String yes ="사용가능";
			String no = "불가능";
			User userinfo=null;//아이디검사용 임시객체
			int status=0;
			
			{temp_email += "."; //.분리 이메일 재조합
			temp_email += temp2;}
			System.out.println(temp_email);
			model.addAttribute("temp_email", temp_email);
			
			//이메일 검사
			
			StringTokenizer scan_st = new StringTokenizer(temp_email,"@");
			
			//이렇게 하면 2개로 분리됨.
			if (scan_st.countTokens() >= 3) {
				status=-1 ;
			model.addAttribute("sysmsg", no);
			model.addAttribute("status", no);}
			
			else {
			
			String[] arr = new String[scan_st.countTokens()];
			
			int j=0;
			while(scan_st.hasMoreElements()) {
				arr[j] = scan_st.nextToken();//토큰 1차 쪼개기
				j++;  //arr[0]:기본 아이디 [1]:뒷주소
			}
			
			//2) 첫번째 배열에 대해서 글자수대로 쪼갠다
			String[] id_scan = arr[0].split("");
			for (int i=0; i<arr[0].length(); i++) {
				System.out.println(id_scan[i]);
					
				//3)잘쪼개짐 ->앞에 
				//4)그댐에 영어인지 숫자인지 검사하자 -> 그외 out

				   if (Pattern.matches("[0-9]", id_scan[i])) {}
				
				   else if (Pattern.matches("[A-Z]",id_scan[i])) {}

				   else if (Pattern.matches("[a-z]", id_scan[i])) {}

				   else if (Pattern.matches("[가-힣]", id_scan[i]))
				    {System.out.println("한글"); status=-1;model.addAttribute("sysmsg", no);model.addAttribute("status", no); break;}
				   else
				    {System.out.println("기타:d"); status=-1; model.addAttribute("sysmsg", no);model.addAttribute("status", no); break;}
			
			}
			
			//이메일 구성검사 끝 (뒷주소 검사 따로 없음....)
			//중복검사 시작
			userinfo= userRegisterService.read(temp_email);
			
			if (status != -1) {
				
			try {
				if (userinfo.getId()!=null) {
					model.addAttribute("sysmsg", no);
					model.addAttribute("status", no);
				}
			} catch (Exception e) {
				
				model.addAttribute("sysmsg", yes);
					//yes여야 사용가능
			}
			
			}
			}
		
			model.addAttribute("registerRequest", new RegisterReq());
			
		
		return "user/checkId";
	}

	// 가입완료 버튼 후 - step3(가입완료 메세지)
	@RequestMapping(value = "/joined", method = RequestMethod.POST)
	public String handleStep3(Model model, RegisterReq registerRequest) throws Exception {
			
			userRegisterService.register(registerRequest);
			model.addAttribute("registerRequest", registerRequest);
			
			return "user/joined";		
	}
	
	//1.마이페이지 접근	
	@RequestMapping(value ="/mypage")
	public String step(HttpSession session, Model model) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) return "redirect:/userLogin"; //return "user/loginForm";
		
		else return "user/mypage";
	}
	//1-1. 회원정보 수정
	@RequestMapping(value ="/infoModi2" )
	public String  step2(HttpSession session ,Model model   ) throws Exception {
	//step2(@RequestParam(value = "id", defaultValue = "") String id ,Model model   ) throws Exception {
		
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
				String key =  userSubmit2.getId().trim();
				User userVO= userRegisterService.read(key);
				
				model.addAttribute("userinfo", userVO);
		return "user/infoModi2";
	}
	
	//1-2. 닉네임체크
	@RequestMapping(value ="/checkNick={temp_name}" )
	public String checkNick(Model model, @PathVariable String temp_name) throws SQLException {
		
		
		String able="가능";
		String disable="불가능";
		
		int ok=0; //0 불가능, 1가능 
		
		if(temp_name.equals("noname")) {model.addAttribute("status", able);} //기본 닉네임에 대한 처리
		
		else {
			ok = userRegisterService.checkNickname(temp_name.trim());
		
			if (ok==1) model.addAttribute("able", able);
			else model.addAttribute("disable", disable);
			}
	
		model.addAttribute("temp_name", temp_name.trim());
		return "user/checkNick";
	}
	
	//1-3. 회원정보 수정완료
	@RequestMapping(value ="/infoModi3" ,method = RequestMethod.POST)
	public String step3(User userinfo, HttpSession session) throws Exception 	{
	
		userRegisterService.update(userinfo);
		
		
		return "redirect:/reload=myinfo";
	}
	
	
	
	
	//1-2. 비밀번호 수정
	
	@RequestMapping(value="/changePwdForm")
	public String pw_step(HttpSession session, Model model) {
		
/*		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		String key =  userSubmit2.getId().trim();*/
		model.addAttribute("userinfo", new User() );
		return "user/changePwdForm";
	}
	@RequestMapping(value="/changePwd")
	public String pw_step2(User userinfo, Model model) throws Exception {

		model.addAttribute("temp", userinfo.getPwd());
		userRegisterService.updatePw(userinfo);
		
		
		return "redirect:/reload=changedPwd";
		
	}
	
	
	//3.비밀번호 찾기
	@RequestMapping(value="/findMyPwd1")
	public String findpw1(Model model) {
		
		return "user/findMyPwd1";
	}
	
	@RequestMapping(value="/findMyPwd2", method = RequestMethod.GET)//get접근시 예외처리
	public String findpwexception(Model model) {
		return "user/findMyPwd1";
	}
	
	@RequestMapping(value="/findMyPwd2", method = RequestMethod.POST)
	public String findpw2(Model model, String email)  {
		
		email=email.trim();
		model.addAttribute("email", email);
		
		User userinfo=null;
		try {
			userinfo = userRegisterService.read(email);
		} catch (Exception e) {
			 { model.addAttribute("able", "되지 않은");
		}
		
		}
		
		try { if (userinfo.getId() != null) {
			model.addAttribute("able", "된"); model.addAttribute("ok", "1");}

		}catch  (Exception e)
			 { model.addAttribute("able", "되지 않은");
	
			 }
				return "user/findMyPwd2";				
		}
	@RequestMapping(value="/findMyPwd3", method = RequestMethod.POST)
	public String findpw3(Model model, String email, String newpw) throws Exception {
		
		User userinfo=new User(email, newpw);
		userRegisterService.updatePw(userinfo);
		model.addAttribute("email", email);
		
		return "user/findMyPwd3";
	}


}


