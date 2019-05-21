<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../admin/sub_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {width:800px; border:1;}
</style>
<script type="text/javascript">
	function go_list() {
		/* document.frm.action = "/doofun/adminCommu";
		document.frm.submit(); */
		history.go(-1);
	}
</script>
<style>
#comm_area {
	border: 2px solid #4e9ca9;
	width: 79%;
	float:left;
	margin-left: 100px;
	margin-right: auto;
	margin-bottom: 15px;
	padding: 10px 10px;
}
</style>
<meta charset="UTF-8">
<title>커뮤니티 상세</title>
</head>
<body>
<div>
	<article>

		<div id=lb>
		<h1>#커뮤니티 관리</h1>
		</div>
		<br>
		<form name="frm">

			<table id=Detail border=1>
				<tr>
					<th>글 번호</th>
					<td>${commu.cseq}</td>
					<th>플젝 번호</th>
					<td>${commu.pnum}</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${commu.id}</td>
					<th>이름</th>
					<td>${commu.name}</td>
				</tr>
				<tr>
					<th>업로드일</th>
					<td>${commu.cdate}</td>
					<th>수정일</th>
					<td>${commu.cdate2}</td>
					<%-- <td><fmt:formatDate value="${commu.cdate2}"
							pattern="yyyy-MM-dd" /></td> --%>
				</tr>
				</table>
				<br>
				<table id=Detail border=1>
				<tr>
					<th>글 제목</th>
					<td>${commu.csub}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${commu.ccon}</td>
				</tr>
			</table>
			<br>

		 	<div id=btn>

				<input type=button class=btn_list value="목록" onclick="go_list()">
			</div> 		
		</form>
	</article>
	</div>

	<c:forEach var="cm" items="${CommentVO}">
			<h3>댓글</h3><br>
				<div id="comm_area">
				
					<%-- ${cm.cseq}/${cm.bcseq}/${cm.id}/--%>
					${cm.name} <span id="comm_time">남긴시각 : ${cm.bcdate}
						(수정시각:${cm.bcdate2}) </span>
					<div>${cm.bccon}</div>
	
	</div>
	</c:forEach>

	<br>
	
</body>
</html>