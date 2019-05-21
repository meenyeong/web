<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>9doo</title>
  <link href="css/shopping.css" rel="stylesheet">
  <script type="text/javascript" src="member/member.js"></script>
  <script type="text/javascript" src="mypage/mypage.js"></script>

</head>

<body>
<div id="wrap">
<!--헤더파일 들어가는 곳 시작 -->
  <header>
    <!--로고 들어가는 곳 시작--->  
    <div id="logo">
      <a href="NonageServlet?command=index">
        <img src="images/logo.png" width="180" height="100" alt="nonageshop">
      </a>  
    </div>
    <!--로고 들어가는 곳 끝-->     
    <nav id="category_menu">
     <ul>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       <li>         
         <a href="NonageServlet?command=login_form" style="width:110px;">LOGIN(CUSTOMER</a>   
	     <a href="NonageServlet?command=admin_login_form" style="width:100px;">| ADMIN)</a>
	   </li>		       
       <li>/</li>
       <li><a href="NonageServlet?command=contract">JOIN</a></li>
       </c:when>
       
       <c:otherwise>
       <li style="color:orange">
         ${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
       </li>
       <li><a href="NonageServlet?command=logout">LOGOUT</a></li>
       </c:otherwise>       
       </c:choose>
       <li>/</li>
       <li>
         <a href="NonageServlet?command=cart_list">CART</a>
       </li><li>/</li>
       <li>
         <a href="NonageServlet?command=mypage">MY PAGE</a>
       </li><li>/</li>
       <li>
         <a href="NonageServlet?command=qna_list">Q&amp;A(1:1)</a>
       </li>
     </ul>
    </nav>
    <nav id="top_menu">
      <ul>
        <li>
          <a href="NonageServlet?command=category&kind=1">HEEL</a>
        </li>  
        <li>
          <a href="NonageServlet?command=category&kind=2">BOOTS</a>
        </li>  
        <li>
          <a href="NonageServlet?command=category&kind=3">SANDAL</a>
        </li> 
        <li>
          <a href="NonageServlet?command=category&kind=4">FLAT & LOAFER</a>
        </li> 
        <li>
          <a href="NonageServlet?command=category&kind=5">SALE</a>
        </li>  
      </ul>
    </nav>
    <div class="clear"></div>
    <hr>
  </header>
  <!--헤더파일 들어가는 곳 끝 -->