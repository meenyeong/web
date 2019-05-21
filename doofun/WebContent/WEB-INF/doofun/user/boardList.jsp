
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/header.jsp"%>
 <!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script type="text/javascript">

function product_search() {

	if (document.frm23.key.value == "") {

		alert("검색할 펀딩 이름을 입력해주세요");

		document.frm23.key.focus(); //안썼을때 그 텍스트필드에 포커스 맞춰서 깜빡임
return false;}
	
	if (document.getElementById("key1").checked == true)
	{document.frm23.action = "commu=1&sub=" + document.frm23.key.value;
	}
	else if(document.getElementById("key2").checked == true)
	{
		document.frm23.action = "commu=1&who=" + document.frm23.key.value;}
	
	document.frm23.submit();
}

</script>

<link href="css/board.css" rel="stylesheet">
<title>회원제 게시판</title>
<style>

table#board {
  border : 3px double #4e9ca9;
  border-collapse: collapse;
  width: 70%;
  margin:  20px ;
  display: table; margin-left: auto; margin-right: auto;
text-align:left;
}

#board th {
  padding: 5px;
  border-bottom: 1px solid gray;
  text-align: center;
  background:LightGray;
  color:#022528;
}
#board td {
  border-bottom: 1px dashed gray;
  padding: 5px;
  td: nth-child(1) {width : 100px;}
  td: nth-child(2) {width : 100px;}
  td: nth-child(3) {width : 100px;}
  td: nth-child(4) {width : 100px;}
}
#board td:nth-child(1) {width:15%; text-align: center; padding-left:10px; font-weight:bold; }

#board td:nth-child(2) {width:20% ; padding-left:10px;}

#board td:nth-child(3) {width:8%; text-align: center; padding-left:5px;  }
#board td:nth-child(4) {width:8%; text-align: center; padding-left:5px;  }

article{
   text-align: center;

}

.boardfrm{
  width: 70%;
  text-align: right;
   margin-left: auto; margin-right: auto;
}

input[type="button"].scan {
	font-family: "nanumsquareround"; 
	background-color: #022528;
	padding-right: 30%;
	float: center;
	width: 120px;
	height: 30px;
	border: none;
	color: white;
	padding: 6px 12px;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}

input[type="submit"].scan2 {
	font-family: "nanumsquareround"; 
	background-color: #022528;
	padding-right: 30%;
	float: center;
	width: 120px;
	height: 30px;
	border: none;
	color: white;
	padding: 6px 12px;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}
#test:hover{
	color:gray;
}
#test{
font-size:12px;  
text-decoration:underline;
}
</style>
</head>
<body>
<article>

<div>
<div class = "boardfrm">
  <form method="post" name ="frm23">
  
  <input type="radio" id="key1" name="search" value="sub=" checked>글제목
  <input type="radio" id="key2" name="search" value="who=">닉네임: &nbsp; 
  
  <input type="search" name="key">
  <input type="button" class="scan"  value="검색" onclick="product_search()">
  </form>
  </div>
  
<c:if test="${ empty articles }">작성된 글이 없습니다.</c:if>
<c:if test="${! empty articles }">
<table id="board" >
<tr class="hb">
<!-- <th>글번호</th>--><th>관련 프로젝트명</th><th>글제목</th><th>닉네임</th><th>등록일자</th>
</tr>
<c:forEach var="p" items="${articles}">
<tr>
<!-- <td>${p.cseq}</td>-->
<td><c:if test="${ (p.pnum!=0)}"><a id="test"  href="<c:url value="/project${p.pnum}"/>">${p.pjsub}</a></c:if></td>
<td><a  href="<c:url value="/read=${p.cseq}"/>">${p.csub}</a></td>
<td>${p.name}</td>
<td><fmt:formatDate value="${p.cdate}" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</table>
</c:if>
  </div>

<div id="page">
  ${paging}
  </div>

<div class = "boardfrm">


<c:if test="${ (userSubmit.id==null)}">
<br> 로그인을 하셔야 글을 작성할 수 있습니다
<input type="button" class="scan" value="로그인" onclick="location.href='userLogin'">

</c:if>

<c:if test="${! (userSubmit.id==null)}">
<form action="write2" method="post">
<input type="submit" class="scan2" value="글쓰기">
</form>
</c:if>
</div>
<br>

</article>


</body>
<%@ include file="/short_footer.jsp"%>

</html>
