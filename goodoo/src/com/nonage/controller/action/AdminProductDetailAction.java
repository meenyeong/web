package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
import com.nonage.dto.WorkerVO;

public class AdminProductDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminProductDetail.jsp";
		HttpSession session = request.getSession();
		WorkerVO loginAdmin = (WorkerVO) session.getAttribute("loginAdmin");

		if (loginAdmin == null) {
			url = "NonageServlet?command=admin_login_form";
		} else {
			String pseq = request.getParameter("pseq");
			ProductDAO productDAO = ProductDAO.getInstance();
			ProductVO productDetail = productDAO.getProduct(pseq);
			request.setAttribute("productDetail", productDetail);
			String tpage = "1";
			if (request.getParameter("tpage") != null) {
				tpage = request.getParameter("tpage");
			}
			String kindList[] = { "0", "Heels", "Boots", "Sandals", "Sneakers", "Sale" };
			request.setAttribute("tpage", tpage);
			int index = Integer.parseInt(productDetail.getKind().trim());
			request.setAttribute("kind", kindList[index]);

			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}