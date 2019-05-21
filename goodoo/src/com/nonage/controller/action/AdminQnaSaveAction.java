package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.QnaVO;

public class AdminQnaSaveAction implements Action{

	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String qseq=request.getParameter("qseq").trim();
		  String reply = request.getParameter("reply").trim();
		  String url = "NonageServlet?command=admin_qna_detail&qseq="+qseq;		
/*		  QnaVO qnaVO = new QnaVO();
		  qnaVO.setQseq(Integer.parseInt(qseq));
		  qnaVO.setReply(reply);*/
		  QnaDAO qnaDAO = QnaDAO.getInstance();
		  try {
			 /* qnaDAO.updateQna(qnaVO);*/
			qnaDAO.updateQna(qseq,reply);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  	RequestDispatcher dispatcher =request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		   }
	   }
	   
	 