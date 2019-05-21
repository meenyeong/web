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
	<div id="funding" class="funding">
		<a id="lab">
		내가 펀딩한 프로젝트
		</a>
		<br><br><br><br>
		<div class="grid">
	<c:if test ="${empty fundings}"> <div class="community" style="background-color:white;">
                     <a id="commu_null" style="font-size:14px; color:black;">후원한 프로젝트가 없습니다.</a>
                  </div>
	</c:if>
	<c:if test = "${! empty fundings}">
		 <c:forEach var="p" items="${fundings}" varStatus="status"> 
			<div>	
			<table class="a_pj" style="min-height:450px;">
					<tr>
						<td>					
						<a id="category_css">${p.category}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heart_quantity}
							</span>				
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="<c:url value="project${p.pnum}"/>" >
						<img id="pj_mainimg" src="upload/${p.image}" width="300px" height="225px"></a></td>
					</tr>
					<tr>
						<td colspan="2" height="50px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.subject}</a></td>
					<tr>
					<tr>
						<td colspan="2" id="name_css">${p.name}</td>
					</tr>
					<tr><td id=cstatus>
						<c:choose>
						<c:when test="${p.c_status == 1}"><b id=ing>진행중</b>
						</c:when>
						<c:when test="${p.c_status == 2}"><b id=fin>펀딩성공</b>
						</c:when>
						<c:when test="${p.c_status == 3}"><b id=stop>중단</b>
						</c:when>
						<c:when test="${p.c_status == 4}"><b id=stop>펀딩실패</b>
						</c:when>
						</c:choose>	</td>				
					</tr>
					<tr>
					<td style="min-height:50px;">
					<c:choose>
					<c:when test ="${p.giftname == null }">후원만 진행
					</c:when>
					<c:otherwise>
			 		${p.giftname}
			 		</c:otherwise>
			 		</c:choose>
					 : <fmt:formatNumber value="${p.funded}" pattern="#,###"/>원		 			
					</td>
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
