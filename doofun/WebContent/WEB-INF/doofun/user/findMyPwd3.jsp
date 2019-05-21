<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/header.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.layer1{
text-align: center;
padding-top: 100px;
}</style>
<body>
<div class="layer1">
이메일 ${email}의 비밀번호를 새 비밀번호로 변경하였습니다.<br>
다시 로그인해주세요! <input type="button" value="로그인 하러가기" onclick="location.href='userLogin'">
</div>
</body>
</html>
<%@ include file="/short_footer.jsp"%>