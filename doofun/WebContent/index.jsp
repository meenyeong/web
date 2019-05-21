<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
#main {
	 display: flex;
	 justify-content: center;
	 align-items: center;
	 text-align: center;
}
a{
	color: Brown;
	text-decoration: none;
	text-weight: bold;
}
a:hover {
	color: DimGray;
}
</style>
<meta charset="UTF-8">
<title>모두의 펀딩</title>
</head>
<body>
	<div id="main">
		<form>
			<img src="images/yakdol.jpg" alt="yakdol"><br>
			<a href="main" style="font-size:30px; color:black;">들어가기</a>
		</form>
	</div>
</body>
</html>

<%@ include file="/footer.jsp"%>