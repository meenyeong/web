package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exception.IdPasswordNotMatchingException;
import service.LoginService;
import vo.LoginInfo;
import vo.LoginSubmit;


@Controller
public class LoginController {
   private LoginService loginService;
   
   public void setLoginService(LoginService loginService) {
      this.loginService = loginService;
   }
   
   @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
   public String login(LoginInfo userCommand) {
      return "admin/adminLogin";
   }

   @RequestMapping(value="/adminLogin", method = RequestMethod.POST)
   public String submit2(LoginInfo userCommand, HttpSession session, HttpServletResponse response) throws Exception{

      try {
         LoginSubmit userSubmit = loginService.adminLogin(userCommand.getId(), userCommand.getPw());
         session.setAttribute("userSubmit", userSubmit);
         return "admin/adminMain";

      } catch (IdPasswordNotMatchingException e) {
         return "admin/loginFail";
      }
      
   }
   @RequestMapping("/adminLogout") 
   public String adminlogout( HttpSession session ) {
 	  session.invalidate();
 	  return "redirect:/main";
   }
   
   //일반유저 로그인
   //일반유저 로그인//////////////////////////////////////////
   
   
   @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
   public String temp( Model model, @CookieValue(value="id", defaultValue="") String id) { //HttpServletRequest request, ,
	   
       /*Cookie cks[] = request.getCookies();
       
       for (Cookie c : cks) {
           System.out.println("이름:" + c.getName() + ", 값:" + c.getValue());
       }*/
	  // System.out.println("id=" + id);
	   
	   if (id!=null) {
		 //  model.addAttribute("yes",1);
		   model.addAttribute("printCookie", id);
	   }

	   
      return "user/loginForm";
   }

   @RequestMapping(value="/userLogin", method = RequestMethod.POST)
   public String uLogin(LoginInfo userCommand, HttpSession session, HttpServletResponse response, Model model) throws Exception{
	
	   /*Cookie cookie1 = new Cookie("id","abc");	
	   Cookie cookie2 = new Cookie("num","123");
	   
	   response.addCookie(cookie1);
       response.addCookie(cookie2);
       */
       //System.out.println("체크박스 내용물 체크: " + userCommand.getSaveId()); //on or null
       try {if (userCommand.getSaveId().equals("on") ) {
    	   String emailcookie= userCommand.getId();
    	   Cookie cookie1 = new Cookie("id",emailcookie);
    	   response.addCookie(cookie1);}
		
       } catch (Exception e) {//if (userCommand.getSaveId()==null )
		   Cookie cookie1 = new Cookie("id",null); //반응없을시 쿠키 덮어쓰기
    	   response.addCookie(cookie1);
       }
       //쿠키검사끝
       
    	
      
      try {
    	 
         LoginSubmit userSubmit = loginService.userLogin(userCommand.getId(), userCommand.getPw());
     //    System.out.println("로그인시 세션에 저장 : "+ userCommand.getPw());
         //model.addAttribute("userCommand", userCommand.getPw());
         userSubmit.setpw(userCommand.getPw());
         session.setAttribute("userSubmit", userSubmit);
/*         response.addCookie("",userCommand.getId());
         */

      } catch (IdPasswordNotMatchingException e) {
    	  
    	
 /*   	 model.addAttribute("fail", 1);*/
    	 
         return "admin/loginFail";
      }
         
      return  "redirect:/main";
   }
   
   
   //세션 재연결
      @RequestMapping("/reload={key}")
      public String reload( HttpSession session, @PathVariable String key, Model model, String temp) {
    	 
    	  LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
    	 // session.invalidate(); //세션 끊으면 에러나서 그냥 세션 덮어쓰기가 나음
    	  try {
    		  String temp_command= userSubmit2.getpw();
			
    		 if ((key.equals("changedPwd"))&&temp!="") {
  				temp_command= temp;
  			}
    		  userSubmit2 = loginService.LoginReload(userSubmit2.getId());
			userSubmit2.setpw(temp_command);
			
			
			
		    	  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	 
    	  session.setAttribute("userSubmit",userSubmit2);
       
    	  if (key.equals("myinfo")) { return "user/infoModied";}
    	  else if (key.equals("changedPwd")) {return "user/changedPwd";}
    	  else {return "redirect:/main";}
      }
      
      @RequestMapping("/userLogout") 
      public String logout( HttpSession session ) {
    	  session.invalidate();
    	  return "redirect:/main";
      }
     //

      
   
/*   @ExceptionHandler(TypeMismatchException.class)
   public String handleTypeMismatchException(TypeMismatchException ex) {
      return "admin/LoginFail";
   }*/
}