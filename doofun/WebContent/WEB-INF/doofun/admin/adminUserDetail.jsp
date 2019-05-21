<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../admin/sub_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
#userDetail th {width:13%;}
#userDetail td {width:20%;}
table {width:800px;}
</style>
<script type="text/javascript">

	function go_list() {
		document.frm.action = "adminUser";
		document.frm.submit();

	}
	

</script>
<meta charset="UTF-8">
<title>회원 정보 상세</title>
</head>
<body>
<div>
	<form name=frm>
		<article>
			<div id=lb>
			<h1>#회원 관리</h1>
			</div>
			<br>
			<h3>회원 정보</h3>
			<table id=Detail border=1>
				<tr>
					<th>이름</th>
					<td>${user.name}</td>
					<th>아이디</th>
					<td>${user.id}</td>
					<th>암호</th>
					<td>${user.pwd}</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>${user.user_img}</td>
					<th>전화번호</th>
					<td>${user.tel}</td>
					<th>탈퇴여부</th>
					<td><c:choose>
							<c:when test='${user.userdrop == "true"}'>탈퇴
                        </c:when>
							<c:when test='${user.userdrop == "false"}'>해당없음
                        </c:when>
						</c:choose></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${user.date_reg}</td>
					<th>소개</th>
					<td>${user.intro}</td>
					<th>플래너 여부</th>
					<td><c:choose>
							<c:when test='${user.planner_yn == "false"}'>해당 없음
                        </c:when>
							<c:when test='${user.planner_yn == "true"}'>플래너
                        </c:when>
						</c:choose></td>
				</tr>
			</table>
			<br>
			<h3>진행한 프로젝트 목록</h3>			
			<c:choose>
				<c:when test='${user.planner_yn == "0"}'><p id=not>해당 없음</p>
			</c:when>

				<c:otherwise>
					<table id=Detail  border=1>
						<tr>
							<th style=width:5%;>번호</th>
							<th style=width:25%;>제목</th>
							<th style=width:10%;>시작일</th>
							<th style=width:10%;>마감일</th>
							<th style=width:10%;>검토결과</th>
							<th style=width:10%;>진행상태</th>
							
						</tr>
						<c:forEach var="project" items="${project}">

							<tr>
								<td>${project.pnum}</td>
								<td><a href="<c:url value="adminProjectDetail=${project.pnum}" />">
									${project.subject}</a></td>
								<td>${project.date_start}</td>
								<td>${project.date_fin}</td>
								<td>
								<c:choose>
								<c:when test='${project.status == "1"}'><b style="color:LightCoral;">검토요청</b>
                       			 </c:when>
								<c:when test='${project.status == "2"}'>컨펌완료
                        		</c:when>
								<c:when test='${project.status == "3"}'>반려
                       			 </c:when>									
									</c:choose></td>
									<td> 
								<c:choose>
								<c:when test='${project.status == "2" && project.c_status == "1"}'><b style="color:LightCoral;">진행중</b>
                       			 </c:when>
								<c:when test='${project.status == "2" && project.c_status == "2"}'>펀딩성공
                        		</c:when>
								<c:when test='${project.status == "2" && project.c_status == "3"}'>중단
                       			 </c:when>		
                       			 <c:when test='${project.status == "2" && project.c_status == "4"}'>펀딩실패
                        		</c:when>
                       			 <c:otherwise>   
                       			 </c:otherwise>							
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>

				</c:otherwise>
			</c:choose>
			<br>
			<h3>펀딩 참여 목록</h3>
			<c:choose>
				<c:when test='${user.funder_yn == "0"}'><p id=not>해당 없음</p>
			</c:when>
				<c:otherwise>
					<table id=Detail border=1>
						<tr>
							<th>프로젝트 제목</th>
							<th>펀딩 금액</th>
							<th>결제여부</th>
						</tr>
						<c:forEach var="view" items="${view}">

							<tr>
								<td><a
									href="<c:url value="adminProjectDetail=${view.pnum}" />">
										${view.subject}</a></td>
								<td>${view.funded}원</td>
								<td><c:choose>
										<c:when test="${view.payment == '0'}">미결제
								</c:when>
										<c:otherwise>결제완료
								</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>

				</c:otherwise>
			</c:choose>

		</article>
		<br>

		<div id=btn>
			<input type=button class=btn_list value="목록" onclick="go_list()" >
		</div>
<br><br><br><br><br>

	</form>
	</div>
</body>
</html>