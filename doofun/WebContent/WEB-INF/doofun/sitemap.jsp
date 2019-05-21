<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="con">
		사이트맵
		<p>
			<a href="<c:url value='/main'/>">[첫 화면 이동]</a>
		</p>
		<p>
			<a href="<c:url value='adminLogin'/>">[관리자로그인]</a>
		</p>
		<p>
			<a href="<c:url value='commu'/>">[게시판]</a>
		</p>
		<p>
			<a href="<c:url value='newProject'/>">[프로젝트생성]</a>
		</p>
		<p>
			<a href="<c:url value="userLogin"/>">[회원 로그인/가입]</a>
		</p>
	</div>

</body>
</html>