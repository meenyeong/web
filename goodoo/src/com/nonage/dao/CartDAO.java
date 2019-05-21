package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.CartVO;

import db.DBAction;

public class CartDAO {
	private CartDAO() {

	}

	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	public int insertCart(CartVO cartVO) throws Exception {
		
		String sql = "insert into cart(id, pseq, quantity) values(?,?,?)";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		int result = -1;
		conn=DBAction.getInstance().getConnection();
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  cartVO.getId());
			pstmt.setInt(2,  cartVO.getPseq());
			pstmt.setInt(3, cartVO.getQuantity());
			result = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			
		}
		return result; 
	}
	public int deleteCart(int cseq) throws Exception {
		
		String sql = "delete from cart where cseq='"+cseq+"'";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		int result = -1;
		conn=DBAction.getInstance().getConnection();
		try {
			
			pstmt=conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			
		}
		return result; 
	}
	
	/*	public void deleteCart(int cseq) {
		
		String sql = "delete from cart where cseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn=DBAction.getInstance().getConnection();
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();
			if (conn != null)conn.close();
			} catch(Exception e) {}
			e.printStackTrace();
			}
		}
		 
	}*/
public ArrayList<CartVO> listCart(String userId) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		String sql = "select * from cart_view where id = ? order by cseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  userId);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			CartVO cartVO = new CartVO();
			cartVO.setCseq(rs.getInt(1));
			cartVO.setId(rs.getString(2));
			cartVO.setPseq(rs.getInt(3));			
			cartVO.setMname(rs.getString(4));
			cartVO.setPname(rs.getString(5));
			cartVO.setQuantity(rs.getInt(6));
			cartVO.setIndate(rs.getTimestamp(7));
			cartVO.setPrice2(rs.getInt(8));

			cartList.add(cartVO);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if (pstmt != null)pstmt.close();
			if (conn != null)conn.close();
			if (rs != null)rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		return cartList;
	}

}
