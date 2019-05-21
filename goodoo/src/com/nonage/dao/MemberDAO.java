package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.MemberVO;

import db.DBAction;

public class MemberDAO {

	   Connection conn;
	   PreparedStatement pstmt;

	   private MemberDAO() {

	   }

	   private static MemberDAO instance = new MemberDAO();

	   public static MemberDAO getInstance() {
	      return instance;
	   }

	   // 저장하기
	   public int insertMember(MemberVO memberVO) throws Exception{
	      
	      conn = null;
	      pstmt = null;
	      int result = -1;
	      String sql = "insert into member(id, pwd, name, email, zip_num, address, phone)" 
	      + " values(?, ?, ?, ?, ?, ?, ?)";

	      conn = DBAction.getInstance().getConnection();
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, memberVO.getId());
	         pstmt.setString(2, memberVO.getPwd());
	         pstmt.setString(3, memberVO.getName());
	         pstmt.setString(4, memberVO.getEmail());
	         pstmt.setString(5, memberVO.getZip_num());
	         pstmt.setString(6, memberVO.getAddress());
	         pstmt.setString(7, memberVO.getPhone());
	         
	         result = pstmt.executeUpdate();
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {if (pstmt != null)pstmt.close();} catch (Exception e) {}
	         try {if (conn != null)conn.close();} catch (Exception e) {}
	      }
	      return result;
	      
	   }

	public int confirmID(String userid) throws Exception{
		int result = -1;
		String sql = "select * from member where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  userid);
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
	
	public MemberVO getMember(String id) throws Exception{
		MemberVO memberVO =null;
		String sql = "select * from member where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs=pstmt.executeQuery(); //실행
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setZip_num(rs.getString("zip_num"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return memberVO;
	}
	
	public ArrayList<MemberVO> memberList() throws Exception{
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberVO memberVO =null;
		String sql = "select * from member order by id desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);			
			rs=pstmt.executeQuery(); 
			while(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setZip_num(rs.getString("zip_num"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
				memberList.add(memberVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return memberList;
	}

	   public int updateMemberUseyn(String id){
	       Connection conn = null;
	       PreparedStatement pstmt = null;
	      int res = -1;
	      String sql = "update member set useyn='n' where id=? ";

	      conn = DBAction.getInstance().getConnection();
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         res = pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            try {if (pstmt != null)pstmt.close();} catch (Exception e) {}
	            try {if (conn != null)conn.close();} catch (Exception e) {}
	         } catch (Exception e) {
	         }
	      }
	      return res;   
	   }
}

