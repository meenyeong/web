<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	window.onresize = resize;
	function resize() {
		if (document.body.offsetWidth < 1300) {
			document.getElementById('menu').style.visibility = "hidden";
			document.getElementById('menu_info').style.visibility = "visible";
		} else {
			document.getElementById('menu').style.visibility = "visible";
			document.getElementById('menu_info').style.visibility = "hidden";
		}
	}
</script>
<style>
 </style>
<meta charset="UTF-8">
<title>Modoo Funding</title>
<!-- css -->
<link href="css/header.css" rel="stylesheet">
<link href="css/lookaround.css" rel="stylesheet">
<link href="css/newproject.css" rel="stylesheet">

<!-- javascript -->
<script type="text/javascript" src="javascript/newProject.js"></script>
<script type="text/javascript" src="javascript/pjpreview.js"></script>
<script type="text/javascript" src="javascript/detailProject.js"></script>

<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.css">
<script src="javascript/cal.js"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="main" id="logo">modoo funding</a>
			</div>
			<nav id="category_menu">
				<ul id="menu" style="visibility: visible">
					<li><a href="lookaround">FUNDING</a></li>
					<li><a href="commu">COMMU</a></li>
					<li><a href="faq">FAQ</a></li>
					<li><a href="mypage">MY PAGE</a></li>
					<c:choose>
						<c:when test="${empty userSubmit}">
							<li><a></a></li>
							<li><a></a></li>
							<li><a href="userLogin">LOGIN / JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li><a></a></li>
							<li><a></a></li>
							<li style="color:white;">${userSubmit.name}님(${userSubmit.id})
								<a href="<c:url value="userLogout"/>"> / logout</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
    		<div id="menu_info" style="visibility: hidden; color:white;">   
    			<ul id="menu3">
					<li><a></a></li>
					<li><a href="lookaround">FUNDING</a></li>
					<li><a href="commu">COMMU</a></li>
					<li><a href="faq">FAQ</a></li>
					<li><a href="mypage">MY PAGE</a></li>
					<c:choose>
						<c:when test="${empty userSubmit}">
							<li><a></a></li>
							<li><a></a></li>
							<li><a href="userLogin">LOGIN / JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="userLogout">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
    		</div>
		</header>
	</div>
<div class="clear"></div>