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
		}  else {
			if (selected == "id") {
				doc.action = "adminProjectSid=" + keyValue;
				doc.submit();
			}
			if (selected == "subject") {
				doc.action = "adminProjectSsub=" + keyValue;
				doc.submit();
			}
			if (selected == "category") {
				doc.action = "adminProjectScat=" + keyValue;
				doc.submit();
			}
			if (selected == "pnum") {
				doc.action = "adminProjectSpnum=" + keyValue;
				doc.submit();
			} 
		}
	}
</script>
<meta charset="UTF-8">
<title>프로젝트 관리</title>
</head>
<body>
	<div>
		<article>
			<form id="adminProject" name=form action="adminProject" method="post">
				<div id=lb>
					<h1>#프로젝트 관리</h1>
					<br>
				</div>
					<div id=select>
							<br> <select name=opt id=opt>
								<option value="id" selected="selected">게시자</option>
								<option value="subject">프로젝트명</option>
								<option value="category">카테고리</option>
								<option value="pnum">번호</option>
							</select> 
							<input type="search" name="key" id="key" required /> 
							<input type="button" value="검색" onclick="search()" /> 
							<br> <br>
						</div>
				<div class="projecttab">
					<input type="radio" name="projecttab" id="req" checked> 
					<input type="radio" name="projecttab" id="confirmed"> 
					<label for="req">요청된 프로젝트</label>
					<label for="confirmed">승인한 프로젝트</label>

					<div class="req_content" style="text-align: left;">
						<h3 style="padding-left: 30%;">검토 요청된 프로젝트 목록</h3>
						
						<%-- 	<c:if test="${! empty projects}"> --%>
						<table id=List border=1>
							<tr>
								<th id=num>번호</th>
								<th id=cate>카테고리</th>
								<th id=subject>제목</th>
								<th id=user>게시자</th>
								<th id=date>검토요청일</th>
								<th id=date>승인일</th>
								<th id=status>승인상태</th>
							</tr>

							<c:forEach var="project" items="${project}">
								<tr>
									<td>${project.pnum}</td>

									<td>${project.category}</td>
									<td id=subj><a
										href="<c:url value="adminProjectDetail=${project.pnum}" />">${project.subject}</a></td>
									<td id=userblue><a
										href="<c:url value="adminUserDetail=${project.useq}" />">${project.id}</a></td>
									<td>${project.date_req}</td>
									<td><c:choose>
											<c:when test='${project.status == "1"}'>
											</c:when>
											<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${project.date_feedback}" /></c:otherwise>
										</c:choose></td>
									<td><c:choose>
											<c:when test='${project.status == "1"}'>
												<b id=review>검토요청</b>
											</c:when>
											<c:when test='${project.status == "2"}'>컨펌완료 </c:when>
											<c:when test='${project.status == "3"}'>반려 </c:when>
										</c:choose></td>
								</tr>
							</c:forEach>
						</table>
						<div id=paging>${paging}</div>
					</div>

					<div class="confirmed_content">
						<h3 style="padding-left: 30%;">승인한 프로젝트 목록</h3>
			
						<table id=List border=1>
							<tr>
								<th id=num>번호</th>
								<th id=cate>카테고리</th>
								<th id=subject>제목</th>
								<th id=user>게시자</th>
								<th id=date>시작일(승인일)</th>
								<th id=date>마감일</th>
								<th id=status>진행상태</th>
							</tr>
							<c:forEach var="view" items="${view}">
								<tr>
									<td>${view.pnum}</td>

									<td>${view.category}</td>
									<td id=subj><a
										href="<c:url value="adminProjectDetail=${view.pnum}" />">${view.subject}</a></td>
									<td id=userblue><a
										href="<c:url value="adminUserDetail=${view.useq}" />">${view.id}</a></td>
									<td>${view.date_start}</td>
									<td>${view.date_fin}</td>
									<td><c:choose>
											<c:when test='${view.c_status == "1" && view.req_status == "1"}'>
												<b id=reviewreq>진행중(요청사항)</b>
											</c:when>
											<c:when test='${view.c_status == "1" && view.req_status == "2"}'>
												<b id=review>진행중(피드백완료)</b>
											</c:when>
											<c:when test='${view.c_status == "1" && view.req_status == "0"}'>
												<b id=review>진행중</b>
											</c:when>
											<c:when test='${view.c_status == "2"}'><b id=over>펀딩성공</b></c:when>
											<c:when test='${view.c_status == "3"}'><b id=stop>중단</b></c:when>
											<c:when test='${view.c_status =="4"}'><b id=over>펀딩실패</b></c:when>
										</c:choose></td>
								</tr>
							</c:forEach>
						</table>
						 <div id=paging>${paging2}</div> 
					</div>
				</div>
			</form>
		</article>
	</div>