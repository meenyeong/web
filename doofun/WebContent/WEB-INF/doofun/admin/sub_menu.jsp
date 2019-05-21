<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modoo Funding - Administer</title>
<link href="css/admin.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
<link href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">	
         <div id="logo">
            <a href="adminProject" id="logo"> Administer</a>
         </div>
<nav id="sub_menu">
	<ul>
		<li><a href="<c:url value="/adminProject" />">프로젝트 관리</a></li>
		<li><a href="<c:url value="/adminCommu" />">커뮤니티 관리</a></li>
		<li><a href="<c:url value="/adminUser" />">회원 관리</a></li>			
		<li><a href="<c:url value="/adminLogout"/>">로그아웃</a></li>		

		</ul>
	</nav>
    <div class="clear"></div>   

</div>