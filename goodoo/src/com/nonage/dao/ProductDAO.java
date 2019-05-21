package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nonage.dto.ProductVO;

import db.DBAction;

	public class ProductDAO {
	   private ProductDAO() {

	   }

	   private static ProductDAO instance = new ProductDAO();

	   public static ProductDAO getInstance() {
	      return instance;
	   }

	   public ArrayList<ProductVO> listNewProduct() {
	      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "select * from new_pro_view";
	      try {
	         conn = DBAction.getInstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery(sql);

	         while (rs.next()) {
	            ProductVO product = new ProductVO();
	            product.setPseq(rs.getInt("PSEQ"));
	            product.setName(rs.getString("NAME"));
	            product.setPrice2(rs.getInt("PRICE2"));
	            product.setImage(rs.getString("IMAGE"));
	            productList.add(product);
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
	      return productList;
	   }

	   public ArrayList<ProductVO> listBestProduct() {
	      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "select * from best_pro_view";
	      try {
	         conn = DBAction.getInstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery(sql);

	         while (rs.next()) {
	            ProductVO product = new ProductVO();

	            product.setPseq(rs.getInt("PSEQ"));
	            product.setName(rs.getString("NAME"));
	            product.setPrice2(rs.getInt("PRICE2"));
	            product.setImage(rs.getString("IMAGE"));

	            productList.add(product);
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

	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return productList;
	   }

	   public ArrayList<ProductVO> SelectedProduct(String kind) {
	      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	      String sql = "select * from product where kind=?";
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = DBAction.getInstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, kind);
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	            ProductVO product = new ProductVO();

	            product.setPseq(rs.getInt("PSEQ"));
	            product.setName(rs.getString("NAME"));
	            product.setPrice2(rs.getInt("PRICE2"));
	            product.setImage(rs.getString("IMAGE"));

	            productList.add(product);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
//	         JDBC Instance close();
	         try {
	            if (rs != null)
	               rs.close();
	            if (pstmt != null)
	               pstmt.close();
	            if (conn != null)
	               conn.close();

	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return productList;
	   }


	   public ProductVO getProduct(String pseq) {
	      ProductVO product = new ProductVO();
	      String sql = "select * from product where pseq =?";
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         conn = DBAction.getInstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pseq);
	         rs = pstmt.executeQuery(); // 실행
	         if (rs.next()) {

	            product.setKind(rs.getString("kind"));
	            product.setPseq(rs.getInt("PSEQ"));
	            product.setName(rs.getString("NAME"));
	            product.setPrice1(rs.getInt("PRICE1"));
	            product.setPrice2(rs.getInt("PRICE2"));
	            product.setPrice3(rs.getInt("PRICE3"));
	            product.setContent(rs.getString("Content"));
	            product.setImage(rs.getString("IMAGE"));
	            product.setUseyn(rs.getString("useyn"));
	            product.setBestyn(rs.getString("bestyn"));
	            product.setIndate(rs.getTimestamp("indate"));

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
	            if (rs != null)
	               rs.close();
	         } catch (Exception e) {
	         }
	      }
	      return product;
	   }

	   // 관리자페이지-상품리스트의 네비게이션에서 사용될 변수 설정..액션에서 메소드호출하여 설정할 예정
	   static int view_rows = 5; // 관리자페이지-상품리스트 페이지의 개수
	   static int counts = 5; // 관리자페이지-상품리스트의 한 페이지에 나태날 상품의 개수

	   public String pageNumber(int tpage, String name) {
	      String str = "";
	      int total_pages = totalRecord(name);//아래 totalrecord() 메소드 따로 있음
	      int page_count = total_pages / counts + 1;       
	      
	      if (total_pages % counts == 0) {
	         page_count--;
	      }
	      if (tpage < 1) {
	         tpage = 1;
	      }
	      int start_page = tpage - (tpage % view_rows) + 1;
	      //상품리스트 페이지의 개수는 5단위(view_rows)로 끊어진다. 
	      //ex)tpage=<5일때 시작페이지(start_page)는 1, 5<tpage=<10일때 6, 10<tpage=<15일때 11...      
	   
	      int end_page = start_page + (counts - 1);      
	      
	      // 마지막페이지로 왔는지 확인하는 분기문
	      if (end_page > page_count) {
	         end_page = page_count;
	      }
	      
	      if (start_page > view_rows) {
	         str += "<a href='NonageServlet?command=admin_product_list&tpage=1&key=" + name
	               + "'>&lt;&lt;</a>&nbsp;&nbsp;";
	         str += "<a href='NonageServlet?command=admin_product_list&tpage=" + (start_page - 1);
	         str += "&key=<%product_name%>'>&lt;</a>&nbsp;&nbsp;";
	      }
	      for (int i = start_page; i <= end_page; i++) {
	         if (i == tpage) {
	            str += "<font color=red>[" + i + "]&nbsp&nbsp;</font>";
	         } else {
	            str += "<a href='NonageServlet?command=admin_product_list&tpage=" + i + "&key=" + name + "'>[" + i
	                  + "]</a>&nbsp;&nbsp;";
	         }
	      }
	      if (page_count > end_page) {
	         str += "<a href='NonageServlet?command=admin_product_list&tpage=" + (end_page + 1) + "&key=" + name
	               + "'>&gt; </a>&nbsp;&nbsp;";
	         str += "<a href='NonageServlet?command=admin_product_list&tpage=" + page_count + "&key=" + name
	               + "'>&gt; </a>&nbsp;&nbsp;";
	      }
	      return str;
	   }

	   // 위 메소드의 total_pages를 얻어낼수있는 메소드
	   public int totalRecord(String product_name) {
	      int total_pages = 0;   
	      String sql = "select count(*) from product where name like '%" + product_name + "%'";
	            
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet pageset = null;
	      try {
	         conn = DBAction.getInstance().getConnection();
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
	            e.printStackTrace();
	         }
	      }
	      return total_pages;
	   }
	   public ArrayList<ProductVO> listProduct(int tpage, String product_name){

	       ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

	       Connection conn = null;
	       PreparedStatement pstmt = null;
	       ResultSet rs = null;
	       String str = "select * from product where name like '%" + product_name + "%' order by pseq desc";


	       int absolutepage = 1; //커서의 위치를 설정. 어디서부터...
	       
	       try {
	          conn = DBAction.getInstance().getConnection();
	          absolutepage = (tpage-1)*counts +1;
	          pstmt = conn.prepareStatement(str, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);          
	          rs = pstmt.executeQuery();

	          if(rs.next()) {
	               rs.absolute(absolutepage);
	               int count = 0;
	               while(count < counts) {
	                  ProductVO productVO = new ProductVO();
	                  productVO.setPseq(rs.getInt("pseq"));
	                  productVO.setName(rs.getString("name"));
	                  productVO.setKind(rs.getString("kind"));
	                  productVO.setPrice1(rs.getInt("price1"));
	                  productVO.setPrice2(rs.getInt("price2"));
	                  productVO.setPrice3(rs.getInt("price3"));
	                  productVO.setContent(rs.getString("content"));
	                  productVO.setImage(rs.getString("image"));
	                  productVO.setUseyn(rs.getString("useyn"));
	                  productVO.setBestyn(rs.getString("bestyn"));
	                  productVO.setIndate(rs.getTimestamp("indate"));
	                  productList.add(productVO);
	                  if(rs.isLast()) {
	                     break;
	                  }
	                  rs.next();
	                  count++;
	               }
	            }
	       } catch (Exception e) {
	          e.printStackTrace();
	       } finally {   
	          try {if (rs != null)rs.close();} catch (Exception e) {e.printStackTrace();}
	          try {if (pstmt != null)pstmt.close();} catch (Exception e) {e.printStackTrace();}
	          try {if (conn != null)conn.close();} catch (Exception e) {
	             e.printStackTrace();
	          }
	       }
	       return productList;

	    }
	   
	   public int insertProduct(ProductVO product) {
	      int result = 0;
	      String sql = "insert into product (kind, name, price1, price2, price3, content, image) values(?, ?, ?, ?, ?, ?, ?)";
	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      try {
	         conn = DBAction.getInstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, product.getKind());
	         pstmt.setString(2, product.getName());
	         pstmt.setInt(3, product.getPrice1());
	         pstmt.setInt(4, product.getPrice2());
	         pstmt.setInt(5, product.getPrice3());
	         pstmt.setString(6, product.getContent());
	         pstmt.setString(7, product.getImage());
	         result = pstmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	         if (pstmt != null) pstmt.close();
	         if (conn != null) conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      }
	      return result;
	   }
	   

	   public int updateProduct(ProductVO product) {
	      int result = -1;
	      String sql = "update product set kind=?, useyn=?, name=?, price1=?, price2=?, price3=?, content=?, image=?, bestyn=? where pseq=?";
	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      try {
	         conn = DBAction.getInstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, product.getKind());
	         pstmt.setString(2, product.getUseyn());
	         pstmt.setString(3, product.getName());
	         pstmt.setInt(4, product.getPrice1());
	         pstmt.setInt(5, product.getPrice2());
	         pstmt.setInt(6, product.getPrice3());
	         pstmt.setString(7, product.getContent());
	         pstmt.setString(8, product.getImage());
	         pstmt.setString(9, product.getBestyn());
	         pstmt.setInt(10, product.getPseq());
	         result = pstmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	         if (pstmt != null) pstmt.close();
	         if (conn != null) conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      }
	      return result;
	   }
	
}
