package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.QnaVO;

public class AdminQnaDetailAction implements Action{

	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String url = "admin/adminQnaDetail.jsp";		
		  QnaVO qnaDetail =new QnaVO();		
		  		  
		  QnaDAO qnaDAO = QnaDAO.getInstance();
		  try {
			
			  qnaDetail=qnaDAO.listQna(request.getParameter("qseq"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	      request.setAttribute("qnaVO", qnaDetail);
	  	RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	   }
	   
	   }
