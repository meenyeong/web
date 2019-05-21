package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.WorkerVO;
import com.nonage.dto.WorkerVO;

import db.DBAction;

public class WorkerDAO {

	   Connection conn;
	   PreparedStatement pstmt;

	   private WorkerDAO() {

	   }

	   private static WorkerDAO instance = new WorkerDAO();

	   public static WorkerDAO getInstance() {
	      return instance;
	   }

	

	public int confirmID(String adminid) throws Exception{
		int result = -1;
		String sql = "select * from worker where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  adminid);
			rs=pstmt.executeQuery(); 
			if(rs.next()) {
				result =1; 
				
			}else {
				result=-1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return result;
	}
	
	
	public WorkerVO getWorker(String id) throws Exception{
		WorkerVO workerVO =null;
		String sql = "select * from worker where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs=pstmt.executeQuery(); //½ÇÇà
			if(rs.next()) {
				workerVO = new WorkerVO();
				workerVO.setId(rs.getString("id"));
				workerVO.setPwd(rs.getString("pwd"));
				workerVO.setName(rs.getString("name"));	
				workerVO.setPhone(rs.getString("phone"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return workerVO;
	}
	
}

