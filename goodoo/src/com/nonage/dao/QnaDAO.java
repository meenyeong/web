package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.QnaVO;

import db.DBAction;

public class QnaDAO {
	private QnaDAO() {

	}

	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	public ArrayList<QnaVO> listOrderById(String id) {

		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from qna where id =? order by qseq desc ";

		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QnaVO qna = new QnaVO();

				qna.setQseq(rs.getInt(1));
				qna.setSubject(rs.getString(2));
				qna.setContent(rs.getString(3));
				qna.setReply(rs.getString(4));
				qna.setId(rs.getString(5));
				qna.setRep(rs.getString(6));
				qna.setIndate(rs.getTimestamp(7));

				qnaList.add(qna);
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
		return qnaList;

	}

	public void insertqna(QnaVO qnaVO, String session_id) {
		String sql = "insert into qna (subject, content, id) values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qnaVO.getSubject());
			pstmt.setString(2, qnaVO.getContent());
			pstmt.setString(3, session_id);
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
	public QnaVO getQna(String qseq) {
		 QnaVO qna =new  QnaVO();
		String sql = "select subject,indate,content,reply from qna where qseq =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  qseq);
			rs=pstmt.executeQuery(); //½ÇÇà
			if(rs.next()) {
				
				qna.setSubject(rs.getString("subject"));
				qna.setIndate(rs.getTimestamp("indate"));
				qna.setContent(rs.getString("content"));
				qna.setReply(rs.getString("reply"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return qna;
	}
	public ArrayList<QnaVO> qnaList() throws Exception{
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		QnaVO qnaVO =null;
		String sql = "select * from qna order by qseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);			
			rs=pstmt.executeQuery(); 
			while(rs.next()) {
				qnaVO = new QnaVO();
				qnaVO.setId(rs.getString("id"));
				qnaVO.setQseq(rs.getInt("qseq"));
				qnaVO.setSubject(rs.getString("subject"));
				qnaVO.setContent(rs.getString("content"));
				qnaVO.setReply(rs.getString("reply"));
				qnaVO.setId(rs.getString("id"));
				qnaVO.setRep(rs.getString("rep"));
				qnaVO.setIndate(rs.getTimestamp("indate"));
				qnaList.add(qnaVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return qnaList;
	}
	
	public int updateQna(String qseq, String reply) throws Exception{
		//public void updateQna(QnaVO qnaVO) {
	     Connection conn = null;
	       PreparedStatement pstmt = null;
	      int res = -1;
	      String sql = "update qna set reply=?, rep=2 where qseq=? ";

	      conn = DBAction.getInstance().getConnection();
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, reply);
	         pstmt.setString(2, qseq);
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

	public QnaVO listQna(String qseq) throws Exception{
		
		QnaVO qnaVO =null;
		String sql = "select * from qna where qseq=? order by qseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, qseq);
			rs=pstmt.executeQuery(); 
			while(rs.next()) {
				qnaVO = new QnaVO();
				qnaVO.setId(rs.getString("id"));
				qnaVO.setQseq(rs.getInt("qseq"));
				qnaVO.setSubject(rs.getString("subject"));
				qnaVO.setContent(rs.getString("content"));
				qnaVO.setReply(rs.getString("reply"));
				qnaVO.setId(rs.getString("id"));
				qnaVO.setRep(rs.getString("rep"));
				qnaVO.setIndate(rs.getTimestamp("indate"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt != null)pstmt.close();} catch(Exception e) {}
			try{if (conn != null)conn.close();} catch(Exception e) {}
			try{if (rs != null)rs.close();} catch(Exception e) {}
		}
		return qnaVO;
	}
}