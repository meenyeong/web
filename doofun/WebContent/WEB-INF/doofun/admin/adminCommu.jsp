<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../admin/sub_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	width: 800px;
}
</style>
<script type="text/javascript">
	function search() {
		var doc = document.form;
		var selected = doc.opt.value;
		var keyValue = doc.key.value;

		if (keyValue == "") {
			alert("입력값 필요");
			doc.key.focus();
		} else {
			if (selected == "id") {
				doc.action = "adminCommuSid=" + keyValue;
				doc.submit();
			}
			if (selected == "pnum") {
				doc.action = "adminCommuSpnum=" + keyValue;
				doc.submit();
			}
			if (selected == "csub") {
				doc.action = "adminCommuScsub="+ keyValue;
				doc.submit();
			}
		}
	}
</script>
<meta charset="UTF-8">
<title>커뮤니티 관리</title>
</head>
<body>
<div>
	<article>
		<form id="adminCommu" name=form action="adminCommu" method="post">
			<div id=lb>
			<h1>#커뮤니티 관리</h1>
			</div>
			<br>
			<div id=select>
			<select name=opt id=opt>
				<option value="id" selected="selected">게시자</option>
				<option value="pnum">프로젝트 번호</option>
				<option value="csub">글 제목</option>
			</select>
			<input type="search" name="key" required />
			<input type="button" value="검색" onclick="search()" />
			<br>
			</div>
			 <br>
			<table id=List1 border=1>
				<tr>
					<th id=num>글 번호</th>
					<th id=num>플젝 번호</th>
					<th id=user>게시자</th>
					<th id=subject>글 제목</th>
					<th id=date>업로드일</th>
				</tr>

				<c:forEach var="commu" items="${commu}">
					<tr>
						<td>${commu.cseq}</td>
						<td><a
							href="<c:url value="adminProjectDetail=${commu.pnum}" />">${commu.pnum}</a></td>
						<td id=userblue><a href="<c:url value="adminUserDetail=${commu.useq}" />">${commu.id}</a></td>
						<td id=subj><a
							href="<c:url value="adminCommuDetail=${commu.cseq}" />">${commu.csub}</a></td>
						<td><fmt:formatDate value="${commu.cdate}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>

			</table>
			<div id=paging>
			${paging}
			</div>

		</form>
	</article>
	</div>
