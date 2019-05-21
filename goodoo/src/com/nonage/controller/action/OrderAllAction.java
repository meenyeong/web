package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.OrderDAO;
import com.nonage.dto.MemberVO;
import com.nonage.dto.OrderVO;

public class OrderAllAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "mypage/orderall.jsp";
      HttpSession session = request.getSession();
      MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
      if(loginUser == null) {
         url = "NonageServlet?command=login_form";
      }else {
         
         OrderDAO orderDAO = OrderDAO.getInstance();
         ArrayList<Integer> oseqList = orderDAO.selectedSeqOrdering(loginUser.getId());
         ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
         
         for(int oseq : oseqList) {
            ArrayList<OrderVO> orderListing = orderDAO.listOrderById(loginUser.getId(), "%", oseq);
            int ordersize = orderListing.size() - 1;
         
            OrderVO orderVO = orderListing.get(0);
            
            if(ordersize < 1) {
               orderVO.setPname(orderVO.getPname());
            }else {
               orderVO.setPname(orderVO.getPname() + " 외 " + ordersize + "건");
            }
            
            int totalPrice = 0;
            for(OrderVO ovo : orderListing) {
               totalPrice += ovo.getPrice2()*ovo.getQuantity();
            }
            
            orderVO.setPrice2(totalPrice);
            orderList.add(orderVO);
         }
         
         request.setAttribute("title", "총 주문 내역");
         request.setAttribute("orderList", orderList);
      }
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
      
   }

}