package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.OrderDAO;

public class AdminOrderSavedAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminOrderList.jsp";
	
		String resultArr[] = request.getParameterValues("result");
		for(String odseq:resultArr) {
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.updateOrderResult(odseq);
		}
				


		request.getRequestDispatcher(url).forward(request, response);
	}
}
