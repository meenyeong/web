<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
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
-moz-border-radius: 0 0 0 0 ;
	-webkit-border-radius: 0 0 0 0 ;	
	background-color: #4F6573;	
	color: white;
	/* margin-left:45%; */
	margin-top:20px;
	font-weight:bold;
	font-size:15px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id=funlist>
<form name="choice2" method=post>
<h3 id=h>내가 펀딩한 프로젝트 리스트</h3>
<table id = tb>
<tr>
<th>선택</th>
<th>프로젝트 이름</th>
<!-- <th>펀딩번호</th> -->
<th>펀딩금액</th>
<th>펀딩물품</th>
</tr>
<c:forEach var="p" items="${projectRequest}">
<tr>
<td><input type="radio" name="project" value="${p.pnum}"></td>
<td>${p.subject}</td>
<%-- <td>${p.fseq}</td> --%>
<td><fmt:formatNumber value="${p.funded}" pattern="#,###"/></td>
<td>${p.giftname}</td>
</tr>
<%-- 플젝번호: ${p.pnum} /펀딩번호: ${p.fseq} /펀딩한사람 ${p.id} / 펀딩금액${p.funded}<br> --%>
</c:forEach>
</table>
 <input type=submit id=btn_submit value=전송>
</form>
</div>
</body>
</html>