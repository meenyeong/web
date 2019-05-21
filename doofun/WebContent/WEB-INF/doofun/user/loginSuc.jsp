<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 성공~ <br>이름,${userSubmit.id})님,  <br>
현재 로그인중인 아이디 정보(id, name)로
게시판에 글 작성시 자동으로 들어가게 됩니다.

수정, 삭제권한도 id값이 같을때만 가능합니다. (master 제외.)

<p><a href='/doofun/commu'/>[게시판으로 돌아가기]</a></p>
</body>
</html>