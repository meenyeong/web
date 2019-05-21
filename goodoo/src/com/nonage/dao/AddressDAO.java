package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.AddressVO;

import db.DBAction;

public class AddressDAO {
	private static AddressDAO instance = new AddressDAO();

	public static AddressDAO getInstance() {
		return instance;
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) throws Exception {
		ArrayList<AddressVO> list= new ArrayList<AddressVO>(); 
		String sql = "select * from address where dong like '%"+dong+"%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); 
			while(rs.next()) {
				AddressVO addressVO = new AddressVO();
				addressVO.setZipNum(rs.getString("zip_num"));
				addressVO.setSido(rs.getString("sido"));
				addressVO.setGugun(rs.getString("gugun"));
				addressVO.setDong(rs.getString("dong"));
				addressVO.setZipCode(rs.getString("zip_code"));
				addressVO.setBunji(rs.getString("bunji"));
				list.add(addressVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try{if (rs != null)rs.close();} catch(Exception e) {}
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
		}
		return list;
	}
}