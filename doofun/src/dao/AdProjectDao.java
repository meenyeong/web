package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import vo.AdC_statusReq;
import vo.AdC_statusView;
import vo.AdConfirmedView;
import vo.AdSum;
import vo.AdminPjView;
import vo.AdminRequest;
import vo.PjComment;
import vo.PjCommentReq;

public class AdProjectDao {
	DataSource dataSource;
	private String c_status;

	@Autowired
	public AdProjectDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	static int view_rows = 5; 
	static int counts = 20;

public int totalRecord() {
		int total_pages = 0;
		String sql = "select count(*) from admin_pj_view";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet pageset = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pageset = pstmt.executeQuery(); 
			if (pageset.next()) {
				total_pages = pageset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (pageset != null)
					pageset.close();
			} catch (Exception e) {
			}
		}
		return total_pages;
	}
public int totalRecord2() {
	int total_pages = 0;
	String sql = "select count(*) from admin_confirmed_view";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet pageset = null;
	try {
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pageset = pstmt.executeQuery(); 
		if (pageset.next()) {
			total_pages = pageset.getInt(1);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			if (pageset != null)
				pageset.close();
		} catch (Exception e) {
		}
	}
	return total_pages;
}
	public String adminPage(int tpage) {
		String str = "";
		int total_page = totalRecord();
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
			str += "<a href='/doofun/adminProject=1'>'>&lt;&lt;</a>&nbsp;&nbsp;";

		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color = red> [" + i + "] &nbsp;&nbsp;</font>";
			} else {
				str += "<a href='/doofun/adminProject=" + i +  "'>[" + i + "]</a> &nbsp; &nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='/doofun/adminProject=" + (end_page + 1) +  "'> &gt; </a> &nbsp;";

		}
		return str;
	}
	public String adminPage2(int tpage) {
		String str = "";
		int total_page = totalRecord2();
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
			str += "<a href='/doofun/adminProject=1'>'>&lt;&lt;</a>&nbsp;&nbsp;";

		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color = red> [" + i + "] &nbsp;&nbsp;</font>";
			} else {
				str += "<a href='/doofun/adminProject=" + i +  "'>[" + i + "]</a> &nbsp; &nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='/doofun/adminProject=" + (end_page + 1) +  "'> &gt; </a> &nbsp;";

		}
		return str;
	}
	public List<AdminPjView> selectAll(int tpage) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminPjView> projects = new ArrayList<AdminPjView>();
		String sql = "select * from admin_pj_view order by date_req desc";

		int absolutepage = 1;
		absolutepage = (tpage - 1) * counts + 1;
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();

			if (rs.next()) {

				rs.absolute(absolutepage);
				int count = 0;

				while (count < counts) {
				AdminPjView pjAdmin = new AdminPjView();
				pjAdmin.setPnum(rs.getInt("pnum"));
				pjAdmin.setId(rs.getString("id"));
				pjAdmin.setSubject(rs.getString("subject"));
				pjAdmin.setContents(rs.getString("contents"));
				pjAdmin.setCategory(rs.getString("category"));
				pjAdmin.setGoal(rs.getInt("goal"));
				pjAdmin.setDate_start(rs.getString("date_start"));
				pjAdmin.setDate_fin(rs.getString("date_fin"));
				pjAdmin.setDate_req(rs.getDate("date_req"));				
				pjAdmin.setFeedback(rs.getString("feedback"));
				pjAdmin.setDate_feedback(rs.getTimestamp("date_feedback"));
				pjAdmin.setStatus(rs.getInt("status"));
				pjAdmin.setUseq(rs.getInt("useq"));
				projects.add(pjAdmin);
				if (rs.isLast()) {
					break;
				} 
				rs.next();
				count++;
			}
		}
	}  catch (Exception e) {
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
		return projects;
	}
	public List<AdConfirmedView> CselectAll(int tpage) throws Exception {
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdConfirmedView> views = new ArrayList<AdConfirmedView>();
		String sql = "select * from admin_confirmed_view order by date_fin desc";

		int absolutepage = 1;
		absolutepage = (tpage - 1) * counts + 1;
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();

			if (rs.next()) {

				rs.absolute(absolutepage);
				int count = 0;

				while (count < counts) {
				AdConfirmedView view = new AdConfirmedView(
						rs.getInt("pnum"), 
						rs.getString("id"), 
						rs.getString("subject"),
						rs.getString("image"),	
						rs.getString("category"), 
						rs.getString("pl_img"),
						rs.getString("name"),
						rs.getString("pl_info"),
						rs.getString("goal"), 
						rs.getInt("date_start"),
						rs.getInt("date_fin"), 
						rs.getString("date_req"), 
						rs.getInt("min_price1"),
						rs.getString("gift_name1"),
						rs.getInt("min_price2"),
						rs.getString("gift_name2"),
						rs.getInt("min_price3"),
						rs.getString("gift_name3"),
						rs.getString("contents"),
						rs.getInt("useq"),
						rs.getInt("c_status"),
						rs.getInt("req_status"),
						rs.getString("req_comm")
						);		
				views.add(view);
				if (rs.isLast()) {
					break;
				} 
				rs.next();
				count++;
			}
				
		}
	}  catch (Exception e) {
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
		return views;
	}
	public AdminPjView readbyPnum(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdminPjView project = null;
		try {
			stmt = conn.prepareStatement("select * from admin_pj_view where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				project = new AdminPjView(rs.getInt("pnum"), rs.getString("id"), rs.getString("subject"),
						rs.getString("contents"), rs.getString("category"), rs.getInt("goal"), rs.getString("date_start"),
						rs.getString("date_fin"), rs.getString("image"), rs.getDate("date_req"), rs.getString("feedback"),
						rs.getTimestamp("date_feedback"), rs.getInt("status"),rs.getInt("useq"),rs.getInt("c_status"),
						rs.getInt("pick"));
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
		return project;
	}
	public AdminRequest adminRequest(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdminRequest req = null;
		try {
			stmt = conn.prepareStatement("select * from request where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				req = new AdminRequest(
						rs.getInt("pnum"),
						rs.getString("req_content"),
						rs.getInt("req_status"),
						rs.getString("req_comm"));
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
		return req;
	}
	



	public List<AdminPjView> readbyUseq(int useq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminPjView> projects = new ArrayList<AdminPjView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_pj_view where useq=?");
			stmt.setInt(1, useq);
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdminPjView project = new AdminPjView(rs.getInt("pnum"), rs.getString("id"), rs.getString("subject"),
						rs.getString("contents"), rs.getString("category"), rs.getInt("goal"), rs.getString("date_start"),
						rs.getString("date_fin"), rs.getString("image"), rs.getDate("date_req"), rs.getString("feedback"),
						rs.getTimestamp("date_feedback"), rs.getInt("status"),rs.getInt("useq"),rs.getInt("c_status"));
				projects.add(project);
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
		return projects;
	}
	
	public List<AdminPjView> searchbyId(String id) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminPjView> projects = new ArrayList<AdminPjView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_pj_view where id like '%" + id.trim() + "%'");
			/*stmt.setString(1, id);*/
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdminPjView project = new AdminPjView(rs.getInt("pnum"), rs.getString("id"), rs.getString("subject"),
						rs.getString("contents"), rs.getString("category"), rs.getInt("goal"), rs.getString("date_start"),
						rs.getString("date_fin"), rs.getString("image"), rs.getDate("date_req"), rs.getString("feedback"),
						rs.getTimestamp("date_feedback"), rs.getInt("status"));
				projects.add(project);
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
		return projects;
	}
	public List<AdminPjView> searchbySub(String subject) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminPjView> projects = new ArrayList<AdminPjView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_pj_view where subject like '%"
		+ subject.trim() + "%'");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdminPjView project = new AdminPjView(rs.getInt("pnum"), rs.getString("id"), rs.getString("subject"),
						rs.getString("contents"), rs.getString("category"), rs.getInt("goal"), rs.getString("date_start"),
						rs.getString("date_fin"), rs.getString("image"), rs.getDate("date_req"), rs.getString("feedback"),
						rs.getTimestamp("date_feedback"), rs.getInt("status"));
				projects.add(project);
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
		return projects;
	}
	public List<AdminPjView> searchbyCate(String category) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminPjView> projects = new ArrayList<AdminPjView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_pj_view where category like '%"
		+ category.trim() + "%'");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdminPjView project = new AdminPjView(rs.getInt("pnum"), rs.getString("id"), rs.getString("subject"),
						rs.getString("contents"), rs.getString("category"), rs.getInt("goal"), rs.getString("date_start"),
						rs.getString("date_fin"), rs.getString("image"), rs.getDate("date_req"), rs.getString("feedback"),
						rs.getTimestamp("date_feedback"), rs.getInt("status"));
				projects.add(project);
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
		return projects;
	}
	public List<AdminPjView> searchbyPnum(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminPjView> projects = new ArrayList<AdminPjView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_pj_view where pnum =?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdminPjView project = new AdminPjView(rs.getInt("pnum"), rs.getString("id"), rs.getString("subject"),
						rs.getString("contents"), rs.getString("category"), rs.getInt("goal"), rs.getString("date_start"),
						rs.getString("date_fin"), rs.getString("image"), rs.getDate("date_req"), rs.getString("feedback"),
						rs.getTimestamp("date_feedback"), rs.getInt("status"),rs.getInt("useq"));
				projects.add(project);
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
		return projects;
	}
	public List<AdConfirmedView> searchbyCId(String id) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdConfirmedView> projects = new ArrayList<AdConfirmedView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_confirmed_view where id like '%" + id.trim() + "%'");			
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdConfirmedView project = new AdConfirmedView(
						rs.getInt("pnum"), 
						rs.getString("id"), 
						rs.getString("subject"),
						rs.getString("image"),	
						rs.getString("category"), 
						rs.getString("pl_img"),
						rs.getString("name"),
						rs.getString("pl_info"),
						rs.getString("goal"), 
						rs.getInt("date_start"),
						rs.getInt("date_fin"), 
						rs.getString("date_req"), 
						rs.getInt("min_price1"),
						rs.getString("gift_name1"),
						rs.getInt("min_price2"),
						rs.getString("gift_name2"),
						rs.getInt("min_price3"),
						rs.getString("gift_name3"),
						rs.getString("contents"),
						rs.getInt("useq"),
						rs.getInt("c_status")
						);		
				
				projects.add(project);
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
		return projects;
	}
	public List<AdConfirmedView> searchbyCSub(String subject) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdConfirmedView> projects = new ArrayList<AdConfirmedView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_confirmed_view where subject like '%"
		+ subject.trim() + "%'");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdConfirmedView project = new AdConfirmedView(
						rs.getInt("pnum"), 
						rs.getString("id"), 
						rs.getString("subject"),
						rs.getString("image"),	
						rs.getString("category"), 
						rs.getString("pl_img"),
						rs.getString("name"),
						rs.getString("pl_info"),
						rs.getString("goal"), 
						rs.getInt("date_start"),
						rs.getInt("date_fin"), 
						rs.getString("date_req"), 
						rs.getInt("min_price1"),
						rs.getString("gift_name1"),
						rs.getInt("min_price2"),
						rs.getString("gift_name2"),
						rs.getInt("min_price3"),
						rs.getString("gift_name3"),
						rs.getString("contents"),
						rs.getInt("useq"),
						rs.getInt("c_status")
						);		
				
				projects.add(project);
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
		return projects;
	}
	public List<AdConfirmedView> searchbyCCate(String category) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdConfirmedView> projects = new ArrayList<AdConfirmedView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_confirmed_view where category like '%"
		+ category.trim() + "%'");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdConfirmedView project = new AdConfirmedView(
						rs.getInt("pnum"), 
						rs.getString("id"), 
						rs.getString("subject"),
						rs.getString("image"),	
						rs.getString("category"), 
						rs.getString("pl_img"),
						rs.getString("name"),
						rs.getString("pl_info"),
						rs.getString("goal"), 
						rs.getInt("date_start"),
						rs.getInt("date_fin"), 
						rs.getString("date_req"), 
						rs.getInt("min_price1"),
						rs.getString("gift_name1"),
						rs.getInt("min_price2"),
						rs.getString("gift_name2"),
						rs.getInt("min_price3"),
						rs.getString("gift_name3"),
						rs.getString("contents"),
						rs.getInt("useq"),
						rs.getInt("c_status")
						);		
				
				projects.add(project);
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
		return projects;
	}
	public List<AdConfirmedView> searchbyCPnum(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdConfirmedView> projects = new ArrayList<AdConfirmedView>();
		;
		try {
			stmt = conn.prepareStatement("select * from admin_confirmed_view where pnum =?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				AdConfirmedView project = new AdConfirmedView(
						rs.getInt("pnum"), 
						rs.getString("id"), 
						rs.getString("subject"),
						rs.getString("image"),	
						rs.getString("category"), 
						rs.getString("pl_img"),
						rs.getString("name"),
						rs.getString("pl_info"),
						rs.getString("goal"), 
						rs.getInt("date_start"),
						rs.getInt("date_fin"), 
						rs.getString("date_req"), 
						rs.getInt("min_price1"),
						rs.getString("gift_name1"),
						rs.getInt("min_price2"),
						rs.getString("gift_name2"),
						rs.getInt("min_price3"),
						rs.getString("gift_name3"),
						rs.getString("contents"),
						rs.getInt("useq"),
						rs.getInt("c_status")
						);		
				
				projects.add(project);
				
				
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
		return projects;
	}
	public int confirm(String feedback, int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;

		try {
			pstmt = conn.prepareStatement("update pj_comment set status='2', date_feedback=now(), feedback=? where pnum=?");
			pstmt.setString(1, feedback);
			pstmt.setInt(2, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement("insert into request values(?,0,'')");			
			pstmt.setInt(1, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {
			Date now = new Date();
			SimpleDateFormat nowTime = new SimpleDateFormat("yyyyMMdd");
			String strNow = nowTime.format(now);
			System.out.println("strNow: "+strNow);
			pstmt = conn.prepareStatement("update project set date_start="+Integer.parseInt(strNow)+" where pnum=?");			
			pstmt.setInt(1, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {
			pstmt = conn.prepareStatement("update project set c_status=1 where pnum=?");
			pstmt.setInt(1, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return res;
	}
	
	public int reject(String feedback, int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;

		try {
			pstmt = conn.prepareStatement("update pj_comment set status='3', date_feedback=now(), feedback=? where pnum=?");
			pstmt.setString(1, feedback);
			pstmt.setInt(2, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return res;
	}
	
	
	public PjComment read(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PjComment comment = null;
		try {
			stmt = conn.prepareStatement("select * from pj_comment where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				comment = new PjComment(
						rs.getInt("pnum"), 
						rs.getString("feedback"), 
						rs.getTimestamp("date_feedback"),
						rs.getInt("status")
						);
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
		return comment;
	}
	public PjCommentReq readreq(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PjCommentReq comment = null;
		try {
			stmt = conn.prepareStatement("select * from pj_comment where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				comment = new PjCommentReq(
						rs.getInt("pnum"), 
						rs.getString("feedback"), 
						rs.getTimestamp("date_feedback"),
						rs.getInt("status")
						);
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
		return comment;
	}	
	public int deadline(int today) throws Exception{
		
		Connection conn;
		conn= dataSource.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement("update project set c_status=5 where (date_fin -" + today + ")<=0 and c_status=1");
		
			result= pstmt.executeUpdate();
			}
		catch(Exception e){
			e.printStackTrace();
					
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {				
			}
		}
		return result;
	}

	public List<AdC_statusReq> selC_status() throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdC_statusReq> pnumlist = new ArrayList<AdC_statusReq>();
		AdC_statusReq pnum = null;
		try {
			stmt = conn.prepareStatement("select pnum, goal from project where c_status='5' order by pnum desc");
			rs = stmt.executeQuery();

			while (rs.next()) {
				pnum = new AdC_statusReq();
				pnum.setPnum(rs.getInt("pnum"));
				pnum.setGoal(rs.getInt("goal"));
				
				pnumlist.add(pnum);
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
		return pnumlist;
	}
	
	public AdSum selSum(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdSum sum = null;
		try {
			stmt = conn.prepareStatement("select fundingsum from pj_funding_view where pnum=" + pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				sum = new AdSum();
				sum.setSum(rs.getInt("fundingsum"));
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
		return sum;
	}
	public int changeCstatus(int c_status, int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;

		try {
			pstmt = conn.prepareStatement("update project set c_status=? where pnum=?");
			pstmt.setInt(1, c_status);
			pstmt.setInt(2, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return res;
	}
	public int changeCstatus2(String key, int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;

		try {
			if(key == "suc")pstmt = conn.prepareStatement("update project set c_status=2 where pnum=?");
			else if(key == "fail")pstmt = conn.prepareStatement("update project set c_status=4 where pnum=?");
			pstmt.setInt(1, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return res;
	}
	public AdConfirmedView selectedone(int pnum) throws Exception{
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdConfirmedView view = null;
		try {
			stmt = conn.prepareStatement("select * from admin_confirmed_view where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				view = new AdConfirmedView(
						rs.getInt("pnum"), 
						rs.getInt("c_status")
						);
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
		return view;
		
	}
	public int request(String comment, int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;

		try {
			pstmt = conn.prepareStatement("update request set req_status='2', req_comm=? where pnum=?");
			pstmt.setString(1, comment);
			pstmt.setInt(2, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return res;
	}
	public int pick(int pick,int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;
		try {
			pstmt = conn.prepareStatement("update project set pick=? where pnum=?");
			pstmt.setInt(1, pick);
			pstmt.setInt(2, pnum);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return res;
	}
}
