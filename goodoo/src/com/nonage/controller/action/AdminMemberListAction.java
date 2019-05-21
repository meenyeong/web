package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminMemberList.jsp";
		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<MemberVO> memberList = null;
		try {
			memberList = memberDAO.memberList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
