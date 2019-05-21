package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.QnaVO;

public class QnaDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "/qna/qnaDetail.jsp";
		String qseq = request.getParameter("qseq").trim();
		QnaDAO qnaDAO = QnaDAO.getInstance();

		QnaVO qnaDetail = qnaDAO.getQna(qseq);
	
		request.setAttribute("QnaVO", qnaDetail);
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}