package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.CartVO;
import com.nonage.dto.OrderVO;

import db.DBAction;

public class OrderDAO {
	private OrderDAO() {

	}

	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}

	public ArrayList<OrderVO> listOrderById(String id, String result, int oseq) {

		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from order_view where id =? and result like '%" + result + "%' and oseq=?";

		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, oseq);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderVO order = new OrderVO();

				order.setOdseq(rs.getInt(1));
				order.setOseq(rs.getInt(2));
				order.setId(rs.getString(3));
				order.setIndate(rs.getTimestamp(4));
				order.setPseq(rs.getInt(5));
				order.setQuantity(rs.getInt(6));
				order.setMname(rs.getString(7));
				order.setZip_num(rs.getString(8));
				order.setAddress(rs.getString(9));
				order.setPhone(rs.getString(10));
				order.setPname(rs.getString(11));
				order.setPrice2(rs.getInt(12));
				order.setResult(rs.getString(13));

				orderList.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return orderList;

	}

	public int insertOrder(ArrayList<CartVO> cartList, String id) {
		int maxOseq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBAction.getInstance().getConnection();
			String insertOrder = "insert into orders(id) values(?)";
			pstmt = conn.prepareStatement(insertOrder);

			pstmt.setString(1, id);
			maxOseq = pstmt.executeUpdate();
			pstmt.close();
			String selectMaxOseq = "select max(oseq) from orders";
			pstmt = conn.prepareStatement(selectMaxOseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxOseq = rs.getInt(1);
			}
			for (CartVO cartVO : cartList) {
				insertOrderDetail(cartVO, maxOseq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return maxOseq;
	}

	public void insertOrderDetail(CartVO cartVO, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			String insertOrderDetail = "insert into order_detail(oseq,pseq,quantity) values(?,?,?)";
			pstmt = conn.prepareStatement(insertOrderDetail);

			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cartVO.getPseq());
			pstmt.setInt(3, cartVO.getQuantity());
			pstmt.executeUpdate();
			pstmt.close();
			String updateCartResult = "update cart set result=2 where cseq=?";
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cartVO.getCseq());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 순번만 가져오기
	public ArrayList<Integer> selectedSeqOrdering(String id) {
		ArrayList<Integer> oseqList = new ArrayList<Integer>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// distinct (중복제거) - ~외 00건
		String sql = "Select distinct oseq from order_view where id=? and result='1' order by oseq desc";

		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				oseqList.add(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return oseqList;
	}

	public ArrayList<OrderVO> listOrderAll(String member_name) {

		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from order_view where mname like '%" + member_name + "%' order by result, oseq desc";

		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderVO order = new OrderVO();

				order.setOdseq(rs.getInt(1));
				order.setOseq(rs.getInt(2));
				order.setId(rs.getString(3));
				order.setIndate(rs.getTimestamp(4));
				order.setPseq(rs.getInt(5));
				order.setQuantity(rs.getInt(6));
				order.setMname(rs.getString(7));
				order.setZip_num(rs.getString(8));
				order.setAddress(rs.getString(9));
				order.setPhone(rs.getString(10));
				order.setPname(rs.getString(11));
				order.setPrice2(rs.getInt(12));
				order.setResult(rs.getString(13));

				orderList.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return orderList;

	}

	public void updateOrderResult(String odseq) {
		String sql = "update order_detail set result='2' where odseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, odseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

}
