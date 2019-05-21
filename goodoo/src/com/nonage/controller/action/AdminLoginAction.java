package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.WorkerDAO;
import com.nonage.dto.WorkerVO;

public class AdminLoginAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url="admin/adminLogin_fail.jsp";
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		WorkerDAO workerDAO = WorkerDAO.getInstance();
		WorkerVO workerVO = null;
		try {
			workerVO = workerDAO.getWorker(id);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}if(workerVO !=null) {
			if(workerVO.getPwd().equals(pwd)) {
//				session.removeAttribute("id");
				session.setAttribute("loginAdmin",workerVO);
				url="NonageServlet?command=admin_product_list";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
