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

import controller.U_ProjectController;
import vo.Board;
import vo.Funder;
import vo.FundingSum;
import vo.GiftCount;
import vo.LikeReq;
import vo.LikeView;
import vo.PjComment;
import vo.Pnum;
import vo.ProjectView;
import vo.UserFundingView;

public class ProjectDao {
   
   DataSource dataSource;

	@Autowired
	public ProjectDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
   public int projectInsert(ProjectView projectview, String id) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      try {
         String sql = "insert into project(id, subject, contents, category, goal, date_start, date_fin, image, date_req) values(?, ?, ?, ?, ?, ?, ?, ?, now());";
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         stmt.setString(2, projectview.getPj_sub());
         stmt.setString(3, projectview.getStory());
         stmt.setString(4, projectview.getPj_cate());
         stmt.setString(5, projectview.getPj_goal());
         stmt.setInt(6, projectview.getPj_start());
         stmt.setInt(7, projectview.getPj_fin());
         stmt.setString(8, projectview.getPj_img());

         return stmt.executeUpdate();
         
      } catch (Exception e) {
         throw e;
      } finally {
         if (stmt != null) stmt.close(); if (conn != null) conn.close();
      }
   }

   public int giftInsert(ProjectView projectview) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      try {
         String sql = "insert into pj_gift(pnum, min_price1, min_price2, min_price3, gift_name1, gift_name2, gift_name3) values(?,?,?,?,?,?,?);";
         stmt = conn.prepareStatement(sql);

         stmt.setInt(1, projectview.getPnum());
         stmt.setInt(2, projectview.getMin_price1());
         stmt.setInt(3, projectview.getMin_price2());
         stmt.setInt(4, projectview.getMin_price3());
         stmt.setString(5, projectview.getGift_name1());
         stmt.setString(6, projectview.getGift_name2());
         stmt.setString(7, projectview.getGift_name3());

         return stmt.executeUpdate();
         
      } catch (Exception e) {
         throw e;
      } finally {
         if (stmt != null) stmt.close(); if (conn != null) conn.close();
      }
   }
   
   public int plannerInsert(ProjectView projectview, String id) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      try {
         
         String sql = "insert into pj_planner(pnum, name, pl_img, pl_info, id) values(?,?,?,?,?);";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, projectview.getPnum());
         stmt.setString(2, projectview.getPl_name());
         stmt.setString(3, projectview.getPl_img());
         stmt.setString(4, projectview.getPl_info());
         stmt.setString(5, id);
         return stmt.executeUpdate();
         
      } catch (Exception e) {
         throw e;
      } 
      
      finally {
         if (stmt != null) stmt.close(); if (conn != null) conn.close();
      }
   }
   
   public int fundingInsert(int pnum) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      try {
         
         String sql = "insert into funding(pnum, funded, payment) values(?,0,1);";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, pnum);
         return stmt.executeUpdate();
         
      } catch (Exception e) {
         throw e;
      } 
      
      finally {
         if (stmt != null) stmt.close(); if (conn != null) conn.close();
      }
   }
   
   public int selectPnum(ProjectView projectview, String id) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      Pnum pnum = null;
      try {
         stmt = conn.prepareStatement("select pnum from project where subject=? and id=?");
         stmt.setString(1, projectview.getPj_sub());
         stmt.setString(2, id);
         rs = stmt.executeQuery();

         while (rs.next()) {
            pnum = new Pnum();
            pnum.setPnum(rs.getInt("pnum"));
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
      return pnum.getPnum();
   }

   public int commentInsert(int pnum) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      try {
         String sql = "insert into pj_comment(pnum, status) values(?, '1');";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, pnum);

         return stmt.executeUpdate();
         
      } catch (Exception e) {
         throw e;
      } finally {
         if (stmt != null) stmt.close(); if (conn != null) conn.close();
      }
   }

   public int requestInsert(int pnum) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      try {
         String sql = "insert into request(pnum, req_status) values(?, '0');";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, pnum);

         return stmt.executeUpdate();
         
      } catch (Exception e) {
         throw e;
      } finally {
         if (stmt != null) stmt.close(); if (conn != null) conn.close();
      }
   }

   public int heartInsert(int pnum) throws Exception {
	      Connection conn;
	      conn = dataSource.getConnection();
	      PreparedStatement stmt = null;
	      try {
	         String sql = "insert into likelike(pnum, useq, like_yn) values(?, '36', 1);";
	         stmt = conn.prepareStatement(sql);
	         stmt.setInt(1, pnum);

	         return stmt.executeUpdate();
	         
	      } catch (Exception e) {
	         throw e;
	      } finally {
	         if (stmt != null) stmt.close(); if (conn != null) conn.close();
	      }
	   }

   public int userInsert(String id) throws Exception {
	      Connection conn;
	      conn = dataSource.getConnection();
	      PreparedStatement stmt = null;
	      try {
	         String sql = "update user set planner_yn = 1 where id = ?;";
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, id);

	         return stmt.executeUpdate();
	         
	      } catch (Exception e) {
	         throw e;
	      } finally {
	         if (stmt != null) stmt.close(); if (conn != null) conn.close();
	      }
	   }
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
            project.setFeedback(getfeedback(pnum));
            project.setC_status(rs.getInt("c_status"));
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

   public FundingSum selfromFunding(int pnum) throws SQLException {
      Connection conn;
      conn = dataSource.getConnection();
      Statement stmt = null;
      ResultSet rs = null;
      FundingSum funding = null;
      
      try {
         stmt = conn.createStatement();
         rs = stmt.executeQuery("select * from pj_funding_view where pnum=" + pnum);

         while (rs.next()) {
            funding = new FundingSum();
            funding.setPnum(pnum);
            funding.setSubject(rs.getString("subject"));
            funding.setSum(rs.getInt("fundingsum"));
            funding.setDate_fin(rs.getInt("date_fin"));
            funding.setCount(rs.getInt("count(f.fseq)"));
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
      return funding;

   }
   public Funder selfromFunder(int pnum, String id) throws SQLException {
	      Connection conn;
	      conn = dataSource.getConnection();
	      Statement stmt = null;
	      ResultSet rs = null;
	      Funder funder = null;
	      
	      try {
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery("select * from pj_funder_view where pnum=" + pnum + " and id='" + id + "';");

	         while (rs.next()) {
	        	 funder = new Funder();
	        	 funder.setPnum(pnum);
	        	 funder.setId(id);
	        	 funder.setFunded(rs.getInt("funded"));
	        	 funder.setPayment(rs.getInt("payment"));
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
	      return funder;

	   }
   public Funder adminselfromFunder(int pnum) throws SQLException {
	      Connection conn;
	      conn = dataSource.getConnection();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      Funder funder = null;
	      
	      try {
	    	  stmt = conn.prepareStatement("select * from pj_funder_view where pnum=?");
	    	  stmt.setInt(1, pnum);
	    	  rs = stmt.executeQuery();
	         while (rs.next()) {
	        	 funder = new Funder();
	        	 funder.setPnum(pnum);
	        	 funder.setId(rs.getString("id"));
	        	 funder.setFunded(rs.getInt("funded"));
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
	      return funder;

	   }
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
         if (rs != null)   rs.close();
         if (stmt != null) stmt.close();
         if (conn != null) conn.close();
      }
      return gift;
   }
   
   
   public List<ProjectView> selectbyId(String id) throws SQLException {
      Connection conn;
      conn = dataSource.getConnection();
      Statement stmt = null;
      ResultSet rs = null;
      
      List<ProjectView> results = new ArrayList<ProjectView>();
      try {
         stmt = conn.createStatement();
         if (id.equals("")) { rs = stmt.executeQuery("select * from pj_detail_view order by pnum desc;") ;}
         else {rs = stmt.executeQuery("select * from pj_detail_view where id = '" + id + "' order by pnum desc;");}

         while (rs.next()) {
            ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
                  rs.getString("image"),   rs.getString("category"),
                  rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"));
            results.add(project);
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
      return results;
   }
   
   public List<ProjectView> selectingbyId(String id) throws SQLException {
	      Connection conn;
	      conn = dataSource.getConnection();
	      Statement stmt = null;
	      ResultSet rs = null;
	      ProjectView project= null;
	      List<ProjectView> results = new ArrayList<ProjectView>();
	      try {
	         stmt = conn.createStatement();
	         if (id.equals("")) { rs = stmt.executeQuery("select * from pj_detail_view where status=2 order by pnum desc;") ;}
	         else {rs = stmt.executeQuery("select * from pj_detail_view where id = '" + id + "' and status=2 order by pnum desc;");}

	         while (rs.next()) {
	            project = new ProjectView();
	            project.setPnum(rs.getInt("pnum"));
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
	            project.setC_status(rs.getInt("c_status"));
	            project.setStatus(rs.getInt("status"));
	            results.add(project);
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
	      return results;
	   }
   public List<Board> searchbyPnum(int pnum) throws Exception {
      Connection conn;
      conn = dataSource.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      List<Board> commu = new ArrayList<Board>();
      ;
      try {
         stmt = conn.prepareStatement("select * from board where pnum=? order by cseq desc");
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

   
   ///////////////////////////////////////////////////
   
   
   static int view_rows = 5;  //�럹�씠吏��쓽 媛쒖닔
   static int counts = 8;//�븳 �럹�씠吏��뿉 �굹���궪 �긽�뭹�쓽 媛��닔
   

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
         str += "<a href='/doofun/lookaround=1&'>" + name + "'>&lt;&lt;</a>&nbsp;&nbsp;";

      }
      for (int i = start_page; i <= end_page; i++) {
         if (i == tpage) {
            str += "<font color = red> [" + i + "] &nbsp;&nbsp;</font>";
         } else {
            str += "<a href='/doofun/lookaround=" + i + "&" + name + "'>[" + i + "]</a> &nbsp; &nbsp;";
         }
      }

      if (page_count > end_page) {
         str += "<a href='/doofun/lookaround=" + (end_page + 1) + "&" + name + "'> &gt; </a> &nbsp;";
         // str += "<a href='../commu/"
         // + (page_count) + "/" + name + "'> &gt; </a> &nbsp;";
      }
      return str;
   }

   public int totalRecord(String csub) {
      int total_pages = 0;
      String sql = "select count(*) from pj_detail_view where subject like '%" + csub + "%'";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet pageset = null;
      try {
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(sql);
         pageset = pstmt.executeQuery(); // 占쎈뼄占쎈뻬
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
      String sql = "select count(*) from pj_detail_view ";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet pageset = null;
      try {
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(sql);
         pageset = pstmt.executeQuery(); // 占쎈뼄占쎈뻬
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
   
   
   public List<ProjectView> selectbyKey(int num, String key) throws SQLException {
      Connection conn;
      conn = dataSource.getConnection();
      Statement stmt = null;
      ResultSet rs = null;      
      if (num==0) {num=1;}
      int counts = num*8;
            
      List<ProjectView> results = new ArrayList<ProjectView>();
      try {
         stmt = conn.createStatement();
         if (key.equals("")) { rs = stmt.executeQuery("select * from pj_detail_view where c_status=1 order by pnum desc;") ;}
         else {rs = stmt.executeQuery("select * from pj_detail_view where subject like '%" + key + "%' and c_status=1 order by pnum desc;");}
         
         if (rs.next()) { 
           
            int count = 0;

            while (count < counts) {
         
            ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
                  rs.getString("image"),   rs.getString("category"),
                  rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"));
            
         
            if (project.getPj_sub().length() >= 38) {//36byte limit
               String temp = project.getPj_sub().substring(0, 38);
               temp += "..";              
               project.setPj_sub(temp);
            }
            
               results.add(project);
            
            if (rs.isLast()) {
               break;
            } 
            rs.next();
            count++;
         }
         } else {
        	 if (key.equals("")){}
        	 else {System.out.println("검색결과 없음");
        	 U_ProjectController.scantemp =1;}
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
      return results;
   }   
   
   
   
   public List<ProjectView> selectbyCategory(int num, String key) throws SQLException {
      Connection conn;
      conn = dataSource.getConnection();
      Statement stmt = null;
      ResultSet rs = null;
      int counts = 8*num;
      
      if (num==0) {num=1;}      
      
      
      List<ProjectView> results = new ArrayList<ProjectView>();
      try {
         stmt = conn.createStatement();
         if (key.equals("")) { rs = stmt.executeQuery("select * from pj_detail_view where c_status=1 order by pnum desc;") ;}
         else {rs = stmt.executeQuery("select * from pj_detail_view where category = '" + key + "' and c_status=1 order by pnum desc;");}
         
         if (rs.next()) {

            int count = 0;

            while (count < counts) {
         
            ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
                  rs.getString("image"),   rs.getString("category"),
                  rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"));
            
            if (project.getPj_sub().length() >= 38) {//36byte limit
               String temp = project.getPj_sub().substring(0, 38);
               temp += "..";
              
               project.setPj_sub(temp);
            }
            
               results.add(project);
            
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
         if (rs != null)
            rs.close();
         if (stmt != null)
            stmt.close();
         if (conn != null)
            conn.close();
      
      }
      return results;
   }
 
	public List<ProjectView> read4(String key,int limit) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		String sql=null;
		if (key.equals("recent")) sql = "select * from pj_detail_view where c_status=1 order by pnum desc LIMIT "+limit;
		if (key.equals("soon")) sql = "select * from pj_detail_view where c_status=1 order by date_fin LIMIT "+limit;
		if (key.equals("heart")) sql ="select like_view.heart_quantity , pj_detail_view.*  from like_view inner join pj_detail_view\r\n" + 
				"          on like_view.pnum = pj_detail_view.pnum and pj_detail_view.c_status=1 order by heart_quantity desc limit "+limit;
		if (key.equals("editor")) sql = "select * from pj_detail_view where c_status=1 and pick='1' order by pnum desc LIMIT "+limit;
		List<ProjectView> results = new ArrayList<ProjectView>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql) ;
		
				while (rs.next()) {
			
				ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
						rs.getString("image"),	rs.getString("category"),
						rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"));
				
				if (key.equals("heart")) project.setHeartcount(rs.getInt("heart_quantity"));
				
				if (project.getPj_sub().length() >= 38) {//36byte limit
					String temp = project.getPj_sub().substring(0, 38);
					temp += "..";
					
					project.setPj_sub(temp);
				}
					results.add(project);
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
		return results;
	}	
	
	public List<Pnum> mypick(int useq) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		String sql=null;
		sql = "select * from likelike where like_yn=1 and useq=" + useq + ";";
		
		List<Pnum> results = new ArrayList<Pnum>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql) ;
		
				while (rs.next()) {
					Pnum pnum = new Pnum();
					pnum.setPnum(rs.getInt("pnum"));
					results.add(pnum);
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
		return results;
	}	

	public ProjectView readMypick(int pnum) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
	    ProjectView project = null;
	    
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pj_detail_view where pnum='" + pnum + "'");
			
				while (rs.next()) {
	            project = new ProjectView();
	            project.setPnum(pnum);
	            project.setPj_sub(rs.getString("subject"));
	            project.setPj_id(rs.getString("id"));
	            project.setPj_img(rs.getString("image"));
	            project.setPj_cate(rs.getString("category"));
	            project.setPl_name(rs.getString("name"));
	            project.setC_status(rs.getInt("c_status"));
	            project.setPj_goal(String.valueOf(rs.getInt("goal")));
	            project.setReq_status(rs.getInt("req_status"));
	            project.setPj_fin(rs.getInt("date_fin"));
	            project.setHeartcount(heartCount2(pnum));
	            
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
	
   public LikeReq heartSelect(int pnum, int useq) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LikeReq like = null;

		try {
			stmt = conn.prepareStatement("select * from likelike where pnum=? and useq=?");
			stmt.setInt(1, pnum);
			stmt.setInt(2, useq);
			rs = stmt.executeQuery();

			while (rs.next()) {
				like = new LikeReq(rs.getInt("pnum"), rs.getInt("useq"), rs.getInt("like_yn"));
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
		return like;

	}

   public List<UserFundingView> funderList(int pnum) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<UserFundingView> results = new ArrayList<UserFundingView>();

		try {
			stmt = conn.prepareStatement("select * from u_funding_view where pnum=? and payment=1");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				UserFundingView view = new UserFundingView();
				view.setPnum(pnum);
				view.setId(rs.getString("id"));
				view.setTel(rs.getString("tel"));
				view.setZip(rs.getString("zip"));
				view.setAddress(rs.getString("address"));
				view.setAddress2(rs.getString("address2"));
				view.setNumber(rs.getInt("number"));
				view.setFunded(rs.getInt("funded"));
				
				results.add(view);
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
		return results;

	}

	public int heartUpdate(int pnum, int useq, int like_yn) throws Exception {

		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement(
					"update likelike set like_yn=" + like_yn + " where pnum=" + pnum + " and useq=" + useq);

			result = pstmt.executeUpdate();
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
		return result;
	}

	public int heartInsert(int pnum, int useq) throws Exception {

		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;
		try {
			pstmt = conn.prepareStatement("insert into likelike values(?,?,1)");
			pstmt.setInt(1, pnum);
			pstmt.setInt(2, useq);
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
	public LikeView heartCount(int pnum) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LikeView like = null;
		try {
			stmt = conn.prepareStatement("select * from like_view where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				like = new LikeView(rs.getInt("pnum"), rs.getString("subject"), rs.getInt("heart_quantity"));
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
		return like;

	}

	public int heartCount2(int pnum) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int like = 0;
		try {
			stmt = conn.prepareStatement("select heart_quantity from like_view where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				like = rs.getInt("heart_quantity");
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
		return like;

	}
	public String getfeedback(int pnum) throws SQLException {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;	
		String feedback = null;
		
		try {
			stmt = conn.prepareStatement("select feedback from pj_comment where pnum=?");
			stmt.setInt(1, pnum);
			rs = stmt.executeQuery();

			while (rs.next()) {
				PjComment comment = new PjComment();
				comment.setFeedback(rs.getString("feedback"));
				feedback = comment.getFeedback();
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
		return feedback;
	}
	public int storyUpdate(int pnum, String story) throws Exception {

		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement("update project set contents='" + story + "' where pnum=" + pnum);

			result = pstmt.executeUpdate();
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
		return result;
	}
	public List<ProjectView> selectMine(int c_status,String id,int limit) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectView> results = new ArrayList<ProjectView>();
		try {
		if(c_status == 5){stmt = conn.prepareStatement("select * from pj_detail_view where (c_status=2 or c_status=4 or c_status=3) and id='" + id + "' order by pnum desc LIMIT ?");}
		else{stmt = conn.prepareStatement("select * from pj_detail_view where c_status='" + c_status + "' and id='" + id + "' order by pnum desc LIMIT ?");};
		stmt.setInt(1, limit);
		rs = stmt.executeQuery() ;
		while (rs.next()) {
				ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
						rs.getString("image"),	rs.getString("category"),
						rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"),
						rs.getInt("status"), rs.getInt("c_status"));
				int pnum = project.getPnum();
				project.setHeartcount(heartCount2(pnum));
				project.setFeedback(getfeedback(pnum));
				results.add(project);
			
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
		return results;
	}	

	public List<ProjectView> selectMine2(int status,String id,int limit) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectView> results = new ArrayList<ProjectView>();
		try {
		stmt = conn.prepareStatement("select * from pj_detail_view where status=? and id=? order by pnum desc LIMIT ?");
		stmt.setInt(1, status);
		stmt.setString(2, id);
		stmt.setInt(3, limit);
		rs = stmt.executeQuery() ;
		while (rs.next()) {
			
				ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
						rs.getString("image"),	rs.getString("category"),
						rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"),
						rs.getInt("status"), rs.getInt("c_status"));
				int pnum = project.getPnum();
				project.setHeartcount(heartCount2(pnum));
				project.setFeedback(getfeedback(pnum));
				results.add(project);
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
		return results;
	}
	public List<ProjectView> selectAll(String id) throws Exception {
		Connection conn;
		conn = dataSource.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectView> results = new ArrayList<ProjectView>();
		try {
		stmt = conn.prepareStatement("select * from pj_detail_view where id=? and c_status!= 0 order by pnum desc");		
		stmt.setString(1, id);
		
		rs = stmt.executeQuery() ;
		while (rs.next()) {
			
				ProjectView project = new ProjectView(rs.getInt("pnum"),rs.getString("subject"), rs.getString("id"),
						rs.getString("image"),	rs.getString("category"),
						rs.getString("name"), rs.getString("goal"), rs.getInt("req_status"), rs.getInt("date_fin"),
						rs.getInt("status"), rs.getInt("c_status"));
				int pnum = project.getPnum();
				project.setHeartcount(heartCount2(pnum));
				project.setFeedback(getfeedback(pnum));
				results.add(project);
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
		return results;
	}
}
