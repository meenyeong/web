package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.CartDAO;
import com.nonage.dao.OrderDAO;
import com.nonage.dto.CartVO;
import com.nonage.dto.MemberVO;

public class OrderInsertAction implements Action {

	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "NonageServlet?command=order_list";

	      // 사용자의 정보 유지
	      HttpSession session = request.getSession();
	      // 로그인했을 때 loginUser로 저장했으므로 불러오기.
	      MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
	      if (loginUser == null) {
	         url = "NonageServlet?command=login_form";
	      } else {
	         // 카트의 데이터 가져오기.
	         CartDAO cartDAO = CartDAO.getInstance();
	         ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getId());

	         OrderDAO orderDAO = OrderDAO.getInstance();
	         // 해당 아이디의 cartlist를 insert
	         // maxOseq -> 가장 높은 주문번호를 가져오기 (view에서 주문자의 정보를 출력하기 위해서)
	         int maxOseq;
	         try {
	            maxOseq = orderDAO.insertOrder(cartList, loginUser.getId());
	            url = "NonageServlet?command=order_list&oseq=" + maxOseq;
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         
	      }
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	   }

	}
