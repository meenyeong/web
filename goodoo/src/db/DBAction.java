package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAction {

	public static DBAction instance;
	private Connection conn;
	private DataSource ds;
	private Context ctx;

	public DBAction() {
		/*
		 * String driver = "com.mysql.jdbc.Driver"; String url =
		 * "jdbc:mysql://192.168.0.21:3306/app_user3"; try { Class.forName(driver); conn
		 * = DriverManager.getConnection(url, "user3", "oracle");
		 * System.out.println("Database Connection successfully"); } catch (Exception e)
		 * { e.printStackTrace(); } }
		 */
 
		try {
			InitialContext initctx = new InitialContext();
			// connection pool 에 접근 -> 주소는 고정값!
			ctx = (Context) initctx.lookup("java:/comp/env");
			// connection pool 에서 데이터 꺼내기 
			ds = (DataSource) ctx.lookup("jdbc/oracle");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DBAction getInstance() {
		if (instance == null)
			instance = new DBAction();

		return instance;

	}

	// connection pool 이용하기
	public Connection getConnection(){
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}

	public void destroy(ResultSet rs, Statement stmt, Connection conn) {
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

}
