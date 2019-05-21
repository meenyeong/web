<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.layer1{
text-align: center;
padding-top: 100px;
}</style>
</head>
<body>

<div class="layer1">
<h1>가입을 환영합니다!</h1>

				<h2>
				${registerRequest.name}님 (${registerRequest.email})
				회원 가입을 완료했습니다.<br>이제 모두펀딩의 모든 기능을 이용하실 수 있습니다.</h2>
	<a href='/doofun/userLogin'/>[로그인하러가기]</a>
</div>
</body>
</html>
<%@ include file="/short_footer.jsp"%>