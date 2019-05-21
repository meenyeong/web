<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div#funlist{
margin: auto;
}
table#tb th,td{
border:1px solid black;
padding:5px;
margin:5px;
}
th{
background-color:#4F6573;
color:white;
}

#btn_submit{

	background-color: #4F6573;	
	color: white;	
	margin-top:20px;
	font-weight:bold;
	font-size:15px;
}

</style>
<title>Insert title here</title>
</head>
<body>
<div id=funlist>
<form name="choice" method=post>
<h3>내가 시작한 프로젝트 리스트</h3>
<table id = tb>
<tr>
<th>선택</th>
<th>프로젝트 번호</th>
<th>프로젝트 이름</th>
<th>진행상황</th>
</tr>
<c:forEach var="p" items="${projectRequest}">
<tr>
<td><input type="radio" name="project" value="${p.pnum}"></td>
<td>${p.pnum}</td>
<td>${p.pj_sub}</td>
<td>
<c:choose>
<c:when test="${p.c_status == 1}"><b>진행중</b>
</c:when>
<c:when test="${p.c_status == 2}"><b>펀딩성공</b>
</c:when>
<c:when test="${p.c_status == 3}"><b>중단</b>
</c:when>
<c:when test="${p.c_status == 4}"><b>펀딩실패</b>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</td></tr>

</c:forEach>
</table>
 <input type=submit id=btn_submit value=전송>
</form>
</div>

</body>
</html>
