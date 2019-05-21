package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
import com.nonage.dto.WorkerVO;

public class AdminProductWriteFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String url = "admin/adminProductWrite.jsp";
		String kindList[] = { "Heels", " Boots", "Sandals","Sneakers","Sale"};
		request.setAttribute("kindList",kindList);
		request.getRequestDispatcher(url).forward(request, response);
	
		}
	}
	
	