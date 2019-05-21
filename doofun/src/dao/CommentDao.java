package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import vo.CommReq;
import vo.CommentVO;

public class CommentDao {
	DataSource dataSource;

	@Autowired
	public CommentDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public List<CommentVO> read(int cseq) throws SQLException  {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		CommentVO article = null;
		List<CommentVO> results = new ArrayList<CommentVO>();
		
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board_comment where cseq=" + cseq + " order by bcseq");

			while (rs.next()) {
				try {	article = new CommentVO(rs.getInt("cseq"), rs.getInt("bcseq"), rs.getString("id"), rs.getString("name"),
						 rs.getString("bccon"), rs.getTimestamp("bcdate").toString().substring(0, 19), rs.getTimestamp("bcdate2").toString().substring(0, 19));
				
			
		} catch (SQLException e) {
			article = new CommentVO(rs.getInt("cseq"), rs.getInt("bcseq"), rs.getString("id"), rs.getString("name"),
					 rs.getString("bccon"), rs.getTimestamp("bcdate").toString().substring(0, 19), "");}
				//id**처리를 하려고했는데 삭제가안됨 ㅎ
				
/*			String temp= article.getId();
			temp=temp.substring(1, article.getId().length());
			temp="*" +temp;
			article.setId(temp);
			*/
			results.add(article);
			}
		 
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			
		
		return results;
	}


	public void insert(CommentVO commentVO2) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		String sql;
		try {
			
			sql = "insert into board_comment( cseq, id, name, bccon,  bcdate) values(  ?, ?,  ?, ?, now() );"; 
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, commentVO2.getCseq());
			stmt.setString(2, commentVO2.getId());
			stmt.setString(3, commentVO2.getName());
			stmt.setString(4, commentVO2.getBccon());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {

			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}


	public int delete(int bcseq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("DELETE FROM board_comment WHERE bcseq='" + bcseq + "'");
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null) conn.close();
		}
	}


	public void update(CommReq commReq) throws SQLException {
	    Connection conn;
	      conn = dataSource.getConnection();
	      PreparedStatement stmt = null;

	      try {
  	 
	         stmt = conn.prepareStatement("update board_comment set name=?, bccon=?, bcdate2=now() where bcseq=?;");
	         stmt.setString(1, commReq.getName());
	         stmt.setString(2, commReq.getNewComm());
	         stmt.setInt(3, commReq.getBcseq());
	         
         
	         stmt.executeUpdate();

	      } catch (Exception e) {
	         throw e;
	      } finally {
	       
	            if (stmt != null)
	               stmt.close();
	            if (conn != null)
	               conn.close();}
	}
	
}
	
		
