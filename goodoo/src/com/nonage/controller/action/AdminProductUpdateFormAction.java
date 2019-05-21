package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class AdminProductUpdateFormAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "admin/adminProductUpdateForm.jsp";

      String pseq = request.getParameter("pseq");
      ProductDAO productDAO = ProductDAO.getInstance();
      ProductVO productVO = null;

      try {
         productVO = productDAO.getProduct(pseq);
      } catch (Exception e) {
         e.printStackTrace();
      }
      request.setAttribute("productVO", productVO);
      
      // 페이지 기억하기
      String tpage = "1";
      if(request.getParameter("tpage") != null) {
         tpage = request.getParameter("tpage");
      }
      request.setAttribute("tpage", tpage);
      
      String kindList[] = { "Heels", "Boots", "Sandals", "Sneakers", "Sale" };
      request.setAttribute("kindList", kindList);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }

}