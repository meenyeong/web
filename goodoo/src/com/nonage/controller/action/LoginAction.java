package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

public class LoginAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url="member/login_fail.jsp";
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = null;
		try {
			memberVO = memberDAO.getMember(id);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}if(memberVO !=null) {
			if(memberVO.getPwd().equals(pwd)) {
				if(memberVO.getUseyn().equals("n")) {
					url="member/login_fail.jsp";
				}else {
				session.setAttribute("loginUser",memberVO);
				url="NonageServlet?command=index";
				}
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
