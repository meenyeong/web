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
				doc.action = "adminUserSid=" + keyValue;
				doc.submit();
			}
			if (selected == "name") {
				doc.action = "adminUserSname="+ keyValue;
				doc.submit();
			}
		}
	}
	function userdrop(useq) {
		var doc = document.form;
		doc.action = "adminUserdrop=" + useq;
		doc.submit();
	}
	function usersave(useq) {
		var doc = document.form;
		doc.action = "adminUsersave=" + useq;
		doc.submit();
	}
</script>
<meta charset="UTF-8">
<title>회원 관리</title>
</head>
<body>
<div>
	<article>
		<form name=form id="adminUser" action="adminUser" method="post">

			<div id=lb>
			<h1>#회원 관리</h1>
			</div>
			<br>
			<div id=select>
			 <select name=opt id=opt>
				<option value="id" selected="selected">아이디</option>
				<option value="name">이름</option>
			</select> <input type="search" name="key" required /> <input type="button"
				value="검색" onclick="search()" /> <br>
				</div>
			<br>
			<table id=List1 border=1>
				<tr>
					<th id=user>아이디</th>
					<th id=user>이름</th>
					<th id=status>플래너여부</th>
					<th id=date>가입일</th>
					<th id=status>탈퇴여부</th>
				</tr>
				<c:forEach var="user" items="${user}">

					<tr>
						<td id=userblue><a href="<c:url value="adminUserDetail=${user.useq}" />">${user.id}</a></td>

						<td>${user.name}</td>

						<td><c:choose>
							<c:when test='${user.planner_yn == "0"}'>해당 없음
                        </c:when>
						<c:otherwise>
							<b id=planner>플래너</b>
						</c:otherwise>
							</c:choose></td>

						<td>${user.date_reg}</td>

						<td><c:choose>
						<c:when test='${user.userdrop == "true"}'>
							<b id=userdrop>	탈퇴 &nbsp; &nbsp; </b>
							<input type=button class=btn_usersave
							value="복구" onclick="usersave(${user.useq})" >

						</c:when>
						<c:otherwise>
						<input type=button class=btn_userdrop value="탈퇴" onclick="userdrop(${user.useq})" >
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						</c:otherwise>
						</c:choose></td>
					</tr>
				</c:forEach>
			</table>
			<div id=paging>
			${paging}
			</div>
		</form>
	</article>
	</div>
</body>
</html>
