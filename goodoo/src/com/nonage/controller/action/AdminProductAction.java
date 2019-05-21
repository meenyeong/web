package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
import com.nonage.dto.WorkerVO;

public class AdminProductAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminProduct.jsp";
		String key = request.getParameter("key");//검색기능을 위해 지정
		String tpage = request.getParameter("tpage");
		
		if(key == null) {key="";}
		if(tpage == null) {tpage="1";}
		else if (tpage.equals("")) {tpage="1";}
		
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);
		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> productList = productDAO.listProduct(Integer.parseInt(tpage),key);
		String paging = productDAO.pageNumber(Integer.parseInt(tpage),key);
		
		HttpSession session = request.getSession();
		WorkerVO loginAdmin = (WorkerVO) session.getAttribute("loginAdmin");
		ProductVO productVO = (ProductVO) session.getAttribute("productVO");
		request.setAttribute("productList", productList);
		
		int n = productList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
