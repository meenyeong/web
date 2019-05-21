<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<style>
#ing{
color:LightCoral;
}
#fin{
color:Gray;
}
#stop{
color:Red;
}
</style>
<meta charset="UTF-8">
<title>modoo funding</title>
</head>
<body>
<div id="con" class="fundinglistcon">
<div style="text-align: left;">
	<br>
	<div id="ing" class="mypickproject">
		<span><a id="lab">내가 찜한 프로젝트</a></span><br><br><br><br>
		<div class="grid">
		<c:if test="${empty mypickProject}">
				<div class="community" style="background-color:white;">
                     <a id="commu_null" style="font-size:14px; color:black;">내가 찜한 프로젝트가 없습니다.</a>
                  </div>
		</c:if>
		<c:if test ="${! empty mypickProject}">
		 <c:forEach var="p" items="${mypickProject}" varStatus="status"> 
			<div>	
			<table class="a_pj">
					<tr>
						<td>					
						<a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>				
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="<c:url value="project${p.pnum}"/>" >
						<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px"></a></td>
					</tr>
					<tr style="height: 50px;">
						<td colspan="2" height="30px" id="sub_css" style="min-height:50px;"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">${p.pl_name}</td>
					</tr>
					<tr><td id=cstatus>
						<c:choose>
						<c:when test="${p.c_status == 1}"><b id=ing>진행중</b>
						</c:when>
						<c:when test="${p.c_status == 2}"><b id=fin>펀딩성공</b>
						</c:when>
						<c:when test="${p.c_status == 3}"><b id=stop>중단</b>
						</c:when>
						<c:when test="${p.c_status == 4}"><b id=fin>펀딩실패</b>
						</c:when>
						</c:choose>	</td>				
					</tr>
				</table>
				</div>		
			 </c:forEach> 
			 </c:if>
			 </div></div>
 	<br><br>
</div>
</div>
</body>
</html>
