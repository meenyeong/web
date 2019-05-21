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

import vo.AdminUserView;
import vo.ProjectView;
import vo.User;

public class UserDao {

	DataSource dataSource;

	@Autowired
	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User adminSelectById(String id) throws Exception {
		User user = null;
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM admin" + " WHERE id='" + id + "'");

			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pw"));
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
				e.printStackTrace();
			}
		}
		return user;

	}

	public User userSelectById(String id) throws Exception {
		User user = null;
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user" + " WHERE id='" + id + "' and userdrop = 0");

			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setUseq(rs.getInt("useq"));
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
				e.printStackTrace();
			}
		}
		return user;

	}

	public User search(String key) throws Exception {// ?占쏙옙占�? ?占쏙옙 愿쒖갖占�? ?占쏙옙?占쏙옙 ?占쏙옙 占�??占쏙옙?占쏙옙?占쏙옙占�?
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		User userinfo = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where id='" + key + "'");

			while (rs.next()) {
				userinfo = new User(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("intro"), rs.getString("tel"), rs.getString("zip"), rs.getString("address"), rs.getString("address2"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null) conn.close();
		}
		return userinfo;
	}

	public List<AdminUserView> userSelectAll() throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<AdminUserView> users = new ArrayList<AdminUserView>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from admin_user_view order by id asc;");

			while (rs.next()) {
				AdminUserView user = new AdminUserView();
				user.setId(rs.getString("id"));
				user.setPnum(rs.getInt("pnum"));
				user.setSubject(rs.getString("subject"));
				user.setFseq(rs.getInt("fseq"));
				user.setFunded(rs.getInt("funded"));
				user.setPayment(rs.getInt("payment"));

				users.add(user);
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
		return users;
	}

	public List<User> selectAll() throws Exception { //페이징 넣으면서 쓸모없어짐..?!
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user order by id asc;");

			while (rs.next()) {

				User user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setUserdrop(rs.getBoolean("userdrop"));
				user.setUser_img(rs.getString("user_img"));
				user.setIntro(rs.getString("intro"));
				user.setTel(rs.getString("tel"));
				user.setDate_reg(rs.getDate("date_reg"));
				user.setPlanner_yn(rs.getBoolean("planner_yn"));
				user.setFunder_yn(rs.getBoolean("funder_yn"));
				user.setUseq(rs.getInt("useq"));
				users.add(user);
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
		return users;
	}

	public int userInsert(User user) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "insert into user( name, id, pwd, intro, tel, date_reg, zip, address, address2) values(  ?, ?, ?, ?, ?, now(), ?, ?, ? );";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getId());
			stmt.setString(3, user.getPwd());
			stmt.setString(4, user.getIntro());
			stmt.setString(5, user.getTel());
			stmt.setString(6, user.getZip());
			stmt.setString(7, user.getAddress());
			stmt.setString(8, user.getAddress2());

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

	public User read(int useq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User detail = null;
		try {
			stmt = conn.prepareStatement("select * from user where useq=?");
			stmt.setInt(1, useq);
			rs = stmt.executeQuery();

			while (rs.next()) {
				detail = new User(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getBoolean("userdrop"), rs.getString("user_img"), rs.getString("intro"), rs.getString("tel"),
						rs.getDate("date_reg"), rs.getBoolean("planner_yn"), rs.getBoolean("funder_yn"),rs.getInt("useq"));

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
		return detail;
	}

	public List<User> searchbyId(String id) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			stmt = conn.prepareStatement("select * from user where id like '%" + id.trim() + "%'");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getBoolean("userdrop"), rs.getString("user_img"), rs.getString("intro"), rs.getString("tel"),
						rs.getDate("date_reg"), rs.getBoolean("planner_yn"), rs.getBoolean("funder_yn"));
				users.add(user);
				

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
		return users;
	}
	public List<User> searchbyName(String name) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		;
		try {
			stmt = conn.prepareStatement("select * from user where name like '%" + name.trim() + "%'");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getBoolean("userdrop"), rs.getString("user_img"), rs.getString("intro"), rs.getString("tel"),
						rs.getDate("date_reg"), rs.getBoolean("planner_yn"), rs.getBoolean("funder_yn"));
				users.add(user);
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
		return users;
	}

	public List<AdminUserView> readView(int useq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdminUserView> users = new ArrayList<AdminUserView>();
		try {
			stmt = conn.prepareStatement("select * from admin_user_view where useq=?");
			stmt.setInt(1, useq);
			rs = stmt.executeQuery();

			while (rs.next()) {
				AdminUserView user = new AdminUserView(rs.getInt("pnum"), rs.getString("subject"), rs.getString("id"),
						rs.getInt("fseq"), rs.getInt("funded"), rs.getInt("payment"), rs.getInt("useq"));
				users.add(user);

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
		return users;
	}

	public void userUpdate(User userinfo) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("update user set name=?, intro=?, tel=?, zip=?, address=?, address2=? where id=?");
			stmt.setString(1, userinfo.getName());
			stmt.setString(2, userinfo.getIntro());
			stmt.setString(3, userinfo.getTel());
			stmt.setString(4, userinfo.getZip());
			stmt.setString(5, userinfo.getAddress());
			stmt.setString(6, userinfo.getAddress2());
			stmt.setString(7, userinfo.getId());
			stmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		}
	}

	public void userUpdatePw(User userinfo) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("update user set pwd =? where id=?");
			stmt.setString(1, userinfo.getPwd());

			stmt.setString(2, userinfo.getId());
			stmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		}
	}

	public void userdrop(int useq) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement("update user set userdrop=true where useq=?");
			
			stmt.setInt(1, useq);
			stmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		}
	}
	public void usersave(int useq) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement("update user set userdrop=false where useq=?");
			
			stmt.setInt(1, useq);
			stmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		}
	}
	static int view_rows = 5; 
	static int counts = 10;
	
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
			str += "<a href='/doofun/adminUser=1'>'>&lt;&lt;</a>&nbsp;&nbsp;";

		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color = red> [" + i + "] &nbsp;&nbsp;</font>";
			} else {
				str += "<a href='/doofun/adminUser=" + i + "'>[" + i + "]</a> &nbsp; &nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='/doofun/adminUser=" + (end_page + 1) + "'> &gt; </a> &nbsp;";

		}
		return str;
	}
	

	public List<User> selected(int tpage) throws Exception {
		List<User> users = new ArrayList<User>();

		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select * from user order by id asc";

		int absolutepage = 1;
		absolutepage = (tpage - 1) * counts + 1;
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();

			if (rs.next()) {

				rs.absolute(absolutepage);
				int count = 0;

				while (count < counts) {
					User user = new User();
					user.setName(rs.getString("name"));
					user.setId(rs.getString("id"));
					user.setPwd(rs.getString("pwd"));
					user.setUserdrop(rs.getBoolean("userdrop"));
					user.setUser_img(rs.getString("user_img"));
					user.setIntro(rs.getString("intro"));
					user.setTel(rs.getString("tel"));
					user.setDate_reg(rs.getDate("date_reg"));
					user.setPlanner_yn(rs.getBoolean("planner_yn"));
					user.setFunder_yn(rs.getBoolean("funder_yn"));
					user.setUseq(rs.getInt("useq"));
					users.add(user);
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
		return users;
	}
	public int totalRecord() {
		int total_pages = 0;
		String sql = "select count(*) from user ";
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
				if (conn != null)
					conn.close();
				if (pageset != null)
					pageset.close();
			} catch (Exception e) {
			}
		}
		return total_pages;
	}

	public String checkByName(String temp_name) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String temp = "";
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user WHERE name='" + temp_name + "'");

			if (rs.next()) {
				temp = (rs.getString("name"));
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
				e.printStackTrace();
			}
		}
		return temp;
	}
}
