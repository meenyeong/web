package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

public class MemberOutAction implements Action{

	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "mypage/memberOut.jsp";
	      HttpSession session = request.getSession();
	      MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
	         
	      if(loginUser == null) {
	            url = "NonageServlet?command=login_form";
	      } else {      
	
	      MemberDAO memberDAO = MemberDAO.getInstance();
	      memberDAO.updateMemberUseyn(loginUser.getId());
	     
	      response.sendRedirect(url);
	         }
	   }

}
