package dao;

import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import vo.Board;

public class BoardDao {

	DataSource dataSource;

	@Autowired
	public BoardDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	static int view_rows = 5;  //페이지의 개수
	static int counts = 10;//한 페이지에 나타낼 상품의 갯수


	public String pageNumber(int tpage, String name) {
		String str = "";
		int total_page = totalRecord(name);
		int page_count = total_page / counts + 1;
		if (total_page % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}
		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);
		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='/doofun/commu=1&'>" + name + "'>&lt;&lt;</a>&nbsp;&nbsp;";

		}
		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color = red> [" + i + "] &nbsp;&nbsp;</font>";
			} else {
				str += "<a href='/doofun/commu=" + i + "&" + name + "'>[" + i + "]</a> &nbsp; &nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='/doofun/commu=" + (end_page + 1) + "&" + name + "'> &gt; </a> &nbsp;";
			// str += "<a href='../commu/"
			// + (page_count) + "/" + name + "'> &gt; </a> &nbsp;";
		}
		return str;
	}

	public int totalRecord(String csub) {
		int total_pages = 0;
		String sql = "select count(*) from board where csub like '%" + csub + "%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet pageset = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pageset = pstmt.executeQuery(); // �떎�뻾
			if (pageset.next()) {
				total_pages = pageset.getInt(1);
			}
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

			try {
				if (pageset != null)
					pageset.close();
			} catch (Exception e) {
			}
		}
		return total_pages;
	}
	public int totalRecordadmin() {
		int total_pages = 0;
		String sql = "select count(*) from board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet pageset = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pageset = pstmt.executeQuery(); // �떎�뻾
			if (pageset.next()) {
				total_pages = pageset.getInt(1);
			}
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

			try {
				if (pageset != null)
					pageset.close();
			} catch (Exception e) {
			}
		}
		return total_pages;
	}
	public List<Board> selectAll(int tpage, String key) throws Exception {
		List<Board> results = new ArrayList<Board>();

		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String event = "";
		String sql=null;
		
		
		if (key!="") {event=key.substring(0,4);
		key=key.substring(4, (key.length()));}

		
		if(event.equals("sub="))  sql = "select * from board_view where csub like '%" + key.trim() + "%' order by cseq desc";
		if(event.equals("who="))  sql = "select * from board_view where name like '%" + key.trim() + "%' order by cseq desc";
		
		if(event=="")  sql = "select * from board_view where csub like '%" + key.trim() + "%' order by cseq desc";
		int absolutepage = 1;
		absolutepage = (tpage - 1) * counts + 1;// �럹�씠吏� �뿰�궛�븯�뒗諛⑸쾿
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();

			if (rs.next()) {

				rs.absolute(absolutepage);
				int count = 0;

				while (count < counts) {
					Board board = new Board(rs.getInt("cseq"), rs.getInt("pnum"), rs.getString("id"),
							rs.getString("name"), rs.getString("csub"), rs.getString("ccon"), rs.getDate("cdate"),
							rs.getDate("cdate2"), rs.getString("pjsub"));
					if (board.getPjsub() != null){String temp = board.getPjsub();
					if (temp.length() >= 30)
					{
						temp = board.getPjsub().substring(0, 30).trim() + "..";
						board.setPjsub(temp);
					}else {temp = board.getPjsub();
					}
					}
						
					results.add(board);

					if (rs.isLast()) {
						break;
					} // �븞�쟾�옣移�
					rs.next();
					count++;

				}

			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null)rs.close();} catch (Exception e) {}
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
		}
		try {
			if (conn != null)conn.close();} catch (Exception e) {
		}

		return results;
	}

	public Board read(int cseq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Board article = null;
		// List<Board results = new ArrayList<Board>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board_view where cseq=" + cseq);

			while (rs.next()) {
				article = new Board(rs.getInt("cseq"), rs.getInt("pnum"), rs.getString("id"), rs.getString("name"),
						rs.getString("csub"), rs.getString("ccon"), rs.getDate("cdate"), rs.getDate("cdate2"), rs.getString("pjsub"));
				if(article.getPjsub() != null) {
					if( article.getPjsub().length() >=16) {
						article.setPjsub(article.getPjsub().substring(0, 15).trim() + "..");
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return article;
	}

	public int insert(Board boardVO) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		String sql;
		try {
			
			if (boardVO.getPnum() != 0) sql = "insert into board( id, name, csub, ccon, pnum, cdate) values(  ?, ?, ?, ?, ?, now() );";
			else sql = "insert into board( id, name, csub, ccon,  cdate) values(  ?, ?,  ?, ?, now() );"; 
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, boardVO.getId());
			stmt.setString(2, boardVO.getName());
			stmt.setString(3, boardVO.getCsub());
			stmt.setString(4, boardVO.getCcon());
			if (boardVO.getPnum() != 0) stmt.setInt(5, boardVO.getPnum());

			return stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {

			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

	}

	public int delete(int cseq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;

		try {
			
			pstmt = conn.prepareStatement("DELETE FROM board_comment WHERE cseq='" + cseq + "'");
					pstmt.executeUpdate();//연관되어있는 댓글 먼저 삭제
			pstmt = conn.prepareStatement("DELETE FROM board WHERE cseq='" + cseq + "'");
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null) conn.close();
		}
	}

	   public void update(String name, String csub, String ccon, int cseq, int pnum) throws Exception {

		      Connection conn;
		      conn = dataSource.getConnection();
		      PreparedStatement stmt = null;

		      try {
		    	  
		    	 if (pnum!=0) {
		         stmt = conn.prepareStatement("update board set name=?, csub=?, ccon=?, pnum=? ,cdate2=now() where cseq=?");
		         stmt.setString(1, name);
		         stmt.setString(2, csub);
		         stmt.setString(3, ccon);
		         stmt.setInt(4, pnum);
		         stmt.setInt(5, cseq);}
		    	 
		    	 else if (pnum==0) {
			         stmt = conn.prepareStatement("update board set name=?, csub=?, ccon=?, pnum=null ,cdate2=now() where cseq=?");
			         stmt.setString(1, name);
			         stmt.setString(2, csub);
			         stmt.setString(3, ccon);
			         stmt.setInt(4, cseq);}
			    	 	    	 
		         
		         stmt.executeUpdate();

		      } catch (Exception e) {
		         throw e;
		      } finally {
		         try {
		            if (stmt != null)
		               stmt.close();
		            if (conn != null)
		               conn.close();
		         } catch (Exception e) {
		         }
		      }
		   }

	public List<Board> searchbyId(String id) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Board> commu = new ArrayList<Board>();
		;
		try {
			stmt = conn.prepareStatement("select * from board where id like '%" + id.trim() + "%'");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt("cseq"), rs.getInt("pnum"), rs.getString("id"), rs.getString("name"),
						rs.getString("csub"), rs.getString("ccon"), rs.getDate("cdate"), rs.getDate("cdate2"));
				commu.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return commu;
	}

	public List<Board> searchbyPnum(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Board> commu = new ArrayList<Board>();
		;
		try {
			stmt = conn.prepareStatement("select * from board where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt("cseq"), rs.getInt("pnum"), rs.getString("id"), rs.getString("name"),
						rs.getString("csub"), rs.getString("ccon"), rs.getDate("cdate"), rs.getDate("cdate2"));
				commu.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return commu;
	}

	public List<Board> searchbyCsub(String csub) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Board> commu = new ArrayList<Board>();
		;
		try {
			stmt = conn.prepareStatement("select * from board where csub like '%" + csub.trim() + "%'");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt("cseq"), rs.getInt("pnum"), rs.getString("id"), rs.getString("name"),
						rs.getString("csub"), rs.getString("ccon"), rs.getDate("cdate"), rs.getDate("cdate2"));
				commu.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return commu;
	}

	public String adminPage(int tpage) {
		String str = "";
		int total_page = totalRecordadmin();
		int page_count = total_page / counts + 1;
		if (total_page % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}
		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);
		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='/doofun/adminCommu=1'>'>&lt;&lt;</a>&nbsp;&nbsp;";

		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color = red> [" + i + "] &nbsp;&nbsp;</font>";
			} else {
				str += "<a href='/doofun/adminCommu=" + i  + "'>[" + i + "]</a> &nbsp; &nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='/doofun/adminCommu=" + (end_page + 1)  + "'> &gt; </a> &nbsp;";

		}
		return str;
	}

	public List<Board> selected(int tpage) throws Exception {
		List<Board> results = new ArrayList<Board>();

		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select * from admin_bd_view order by cseq desc";

		int absolutepage = 1;
		absolutepage = (tpage - 1) * counts + 1;
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();

			if (rs.next()) {

				rs.absolute(absolutepage);
				int count = 0;

				while (count < counts) {
					Board board = new Board(rs.getInt("cseq"), rs.getInt("pnum"), rs.getString("id"),
							rs.getString("name"), rs.getString("csub"), rs.getString("ccon"), rs.getDate("cdate"),
							rs.getDate("cdate2"), rs.getInt("useq"));
					results.add(board);
					if (rs.isLast()) {
						break;
					} 
					rs.next();
					count++;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return results;
	}
}
