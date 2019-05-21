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

import vo.Fseq;
import vo.Funding;
import vo.GiftCount;
import vo.Payment;
import vo.ProjectView;
import vo.Request;
import vo.Useq;
import vo.UserFundingView;

public class FundingDao {

	DataSource dataSource;

	@Autowired
	public FundingDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Funding> selectbyId(String key) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Funding> results = new ArrayList<Funding>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from funding where id='" +key+ "'  order by fseq desc;");

			while (rs.next()) {
				Funding funding = new Funding(rs.getInt("pnum"),rs.getInt("fseq"), rs.getInt("funded"), rs.getInt("number"),
						rs.getString("id"), rs.getInt("payment"));
				results.add(funding);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null) stmt.close();
			} catch (Exception e) {
			}
			if(conn != null) conn.close();
		}
		return results;
	}

	// 펀딩하기 위한 프로젝트 정보 가져오기
	public ProjectView selectbyPnum(int pnum) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ProjectView project = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pj_detail_view where pnum=" + pnum);

			while (rs.next()) {
				project = new ProjectView();
				project.setPnum(pnum);
				project.setPj_sub(rs.getString("subject"));
				project.setPj_id(rs.getString("id"));
				project.setPj_img(rs.getString("image"));
				project.setPj_cate(rs.getString("category"));
				project.setPj_goal(String.valueOf(rs.getInt("goal")));
				project.setPj_start(rs.getInt("date_start"));
				project.setPj_fin(rs.getInt("date_fin"));
				project.setStory(rs.getString("contents"));
				project.setPl_img(rs.getString("pl_img"));
				project.setPl_name(rs.getString("name"));
				project.setPl_info(rs.getString("pl_info"));
				project.setGift_name1(rs.getString("gift_name1"));
				project.setGift_name2(rs.getString("gift_name2"));
				project.setGift_name3(rs.getString("gift_name3"));
				project.setMin_price1(rs.getInt("min_price1"));
				project.setMin_price2(rs.getInt("min_price2"));
				project.setMin_price3(rs.getInt("min_price3"));
				
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

	// project detail에 펀딩을 몇명이 했는지 보여주기 위한 정보 가져오기
	public GiftCount selGiftCount(int pnum) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		GiftCount gift = new GiftCount();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pj_gift_view where pnum=" + pnum + " and payment=1 and number=1");
			while (rs.next()) {
				gift.setCount1(rs.getInt("count(f.number)"));
			}
		} catch (Exception e) {throw e;} 
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pj_gift_view where pnum=" + pnum + " and payment=1 and number=2");
			while (rs.next()) {
				gift.setCount2(rs.getInt("count(f.number)"));
			}
		} catch (Exception e) {throw e;} 		

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pj_gift_view where pnum=" + pnum + " and payment=1 and number=3");
			while (rs.next()) {
				gift.setCount3(rs.getInt("count(f.number)"));
			}
		} catch (Exception e) {throw e;} 	
		
		finally {
			if (rs != null)	rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		return gift;
	}
	

	// funding 테이블에 펀딩내용 추가하기(payment는 0이다 - 결제전)
	public int fundingInsert(Payment payment) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "insert into funding(pnum, funded, number, id, payment) values(?,?,?,?,'0');";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, payment.getPnum());
			stmt.setInt(2, payment.getFunded());
			stmt.setInt(3, payment.getNumber());
			stmt.setString(4, payment.getId());
			
			return stmt.executeUpdate();			
		} catch (Exception e) {
			throw e;
		}
		finally {
			if (stmt != null) stmt.close(); if (conn != null) conn.close();
		}
	}

	// 결제완료를 위한 fseq 불러오기(주문번호)
	public Fseq selectFseq(String id) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Fseq fseq = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select fseq from funding where id='"+ id + "' ORDER BY FSEQ DESC LIMIT 1;");

			while (rs.next()) {
				fseq = new Fseq();
				fseq.setFseq(rs.getInt("fseq"));
			}

		} catch (Exception e) {
			throw e;
		} finally { 
			if (rs != null)	rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		return fseq;
	}

	// 결제 완료 후 funding테이블의 payment 1로 바꾸기(결제완료)
	public int paymentUpdate(int fseq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE funding set payment = '1'  where fseq =" + fseq + ";";
			stmt = conn.prepareStatement(sql);
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close(); if (conn != null) conn.close();
		}
	}

	
	// 결제 완료 후 user테이블의 funder_yn 1로 바꾸기(결제완료)
	public int userUpdate(String id) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE user set funder_yn = '1'  where id ='" + id + "';";
			stmt = conn.prepareStatement(sql);
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close(); if (conn != null) conn.close();
		}
	}
	
	// 기획자가 프로젝트에 대해 요청한 사항 update
	public int requestUpdate(int pnum, String content) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE request set req_status = '1', req_content = '" + content + "' where pnum =" + pnum + ";";
			stmt = conn.prepareStatement(sql);
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close(); if (conn != null) conn.close();
		}
	}

	// 요청사항에 대한 피드백
	public Request selRequest(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Request request = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from request where pnum=" + pnum);

			while (rs.next()) {
				request = new Request();
				request.setPnum(pnum);
				request.setReq_status(rs.getInt("req_status"));
				request.setReq_comm(rs.getString("req_comm"));
				request.setReq_content(rs.getString("req_content"));
			}

		} catch (Exception e) {
			throw e;
		} finally {	
			if (rs != null)	rs.close();
			if (stmt != null)stmt.close();
			if (conn != null)conn.close();
		}
		return request;
	}
	public List<UserFundingView> myfunding(String id) throws Exception{
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<UserFundingView> results = new ArrayList<UserFundingView>();

		try {
			stmt = conn.prepareStatement("select * from u_funding_view where id=? and payment=1 order by pnum");
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserFundingView funding = new UserFundingView(
						rs.getInt("pnum"), rs.getString("name"), rs.getString("subject"), 
						rs.getString("category"), rs.getInt("c_status"), rs.getString("image"),
						rs.getString("gift_name1"), rs.getString("gift_name2"), 
						rs.getString("gift_name3"), rs.getString("id"), rs.getInt("payment"), 
						rs.getInt("number"), rs.getInt("funded"),rs.getInt("heart_quantity"));
				int pnum = funding.getPnum();				
				funding.setGiftname(findGiftname(rs.getInt("number"),pnum));
				results.add(funding);
			}

		} catch (Exception e) {
			throw e;
		} finally {	
			if (rs != null)	rs.close();
			if (stmt != null)stmt.close();
			if (conn != null)conn.close();
		}
		return results;
	}
	public String findGiftname(int gift_num,int pnum) throws Exception{
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String giftname = null;
		try {
			stmt = conn.prepareStatement("select gift_name"+gift_num+" from pj_detail_view where pnum="+pnum);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				ProjectView view = new ProjectView();
				view.setGiftname(rs.getString("gift_name"+gift_num));
				giftname = view.getGiftname();				
			}

		} catch (Exception e) {
			
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		}
		return giftname;

	}
	
	
}
