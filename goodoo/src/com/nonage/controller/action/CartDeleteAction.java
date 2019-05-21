package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.CartDAO;

public class CartDeleteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	String url = "NonageServlet?command=cart_list";
	
	String cseqArr[] =request.getParameterValues("cseq"); 

	for(String cseq : cseqArr) {
		
		CartDAO cartDAO = CartDAO.getInstance();
		try {
			cartDAO.deleteCart(Integer.parseInt(cseq));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	request.getRequestDispatcher(url).forward(request, response);
	}

}
