<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modoo funding</title>
</head>
<body>
<div id="con" class="fundinglistcon">
<div style="text-align: left;">
	<br>
	<div id="ing" class="project">	
		<span><a id="lab">진행중인 프로젝트</a><a href="more=ing" style="float:right;">더보기</a></span><br><br>		
		<div class="grid">	
	<c:if test ="${empty ingProject}"> 
			<div class="community" style="background-color:white;">
                <a id="commu_null" style="font-size:14px; color:black;">진행중인 프로젝트가 없습니다.</a>
            </div>
	</c:if>
	<c:if test = "${!empty ingProject}">
		 <c:forEach var="p" items="${ingProject}" varStatus="status"> 
		<div>	
			<table class="a_pj" id="fundinglisttable">
					<tr>
						<td>					
						<a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<div class="entry">
							<img id="pj_mainimg1" src="upload/${p.pj_img}" width="300px" height="225px">
						</div>
						<div>
							<c:choose>
							<c:when test="${p.req_status == 0}">
								<a id="request" style="color: black;" href="<c:url value="requestToadmin=${p.pnum}" />">요청하기</a>
							</c:when>
							<c:when test="${p.req_status == 1}">
								<a id="request" style="color: DimGray;"> 요청중</a>
							</c:when>
							<c:when test="${p.req_status == 2}">
								<a id="request" style="color: red;" href="<c:url value="answer=${p.pnum}" />"> 답변보기</a>
							</c:when>
							</c:choose>
						</div>
						
						</td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">${p.pl_name}</td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
						<c:if test="${p.percent > 99}">
							<svg id="svg">
							<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
							<rect x="0" y="0" height="2" width="100%" fill="#fe6f61"></rect>
							</svg>
						</c:if>
						<c:if test="${p.percent < 100}" >
							<svg id="svg">
							<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
							<rect x="0" y="0" height="2" width="${p.percent}%" fill="#fe6f61"></rect>
							</svg>
						</c:if>
						</td>
					</tr>
					<tr>
						<td id="dday_css">
						<img src="images/calendar.png">
						<b>${p.dday}</b>일 남음
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css"> ${p.percent}%</span></td>
					</tr>
				</table>
				</div>		
			 </c:forEach> 
			 </c:if>
			 </div></div>
	
 	<br><br>
	<div id="review" class="project">
		<span><a id="lab">검토중인 프로젝트</a><a href="more=review" style="float:right;">더보기</a></span><br><br>	
		<div class="grid">
			<c:if test ="${empty reviewProject}"> 
			<div class="community" style="background-color:white;">
                <a id="commu_null" style="font-size:14px; color:black;">검토중인 프로젝트가 없습니다.</a>
            </div>
	</c:if>
	<c:if test = "${! empty reviewProject}">
		 <c:forEach var="p" items="${reviewProject}" varStatus="status"> 
			<div>	
			<table class="a_pj" id="fundinglisttable">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<div class="entry">
							<img id="pj_mainimg1" src="upload/${p.pj_img}" width="300px" height="225px">
						</div>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">${p.pl_name}</td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
						<c:if test="${p.percent > 100}">
							<svg id="svg">
							<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
							<rect x="0" y="0" height="2" width="100%" fill="#fe6f61"></rect>
							</svg>
						</c:if>
						<c:if test="${p.percent < 100}" >
							<svg id="svg">
							<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
							<rect x="0" y="0" height="2" width="${p.percent}%" fill="#fe6f61"></rect>
							</svg>
						</c:if>
						</td>
					</tr>
					<tr>
						<td id="dday_css">
						<img src="images/calendar.png">
						<b>${p.dday}</b>일 남음
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css"> ${p.percent}%</span></td>
					</tr>
				</table>
				</div>	
			 </c:forEach> 
			 </c:if>
			 </div></div>
	
 	<br><br>
	<div id="fin" class="project">
		<span><a id="lab">마감된 프로젝트</a><a href="more=fin" style="float:right;">더보기</a></span><br><br>
		<div class="grid">
				<c:if test ="${empty finProject}"> 
			<div class="community" style="background-color:white;">
                <a id="commu_null" style="font-size:14px; color:black;">마감된 프로젝트가 없습니다.</a>
            </div>
	</c:if>
	<c:if test = "${! empty finProject}">
		 <c:forEach var="p" items="${finProject}" varStatus="status"> 
		<div>	
			<table class="a_pj" id="fundinglisttable">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>	
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<div class="entry">
							<img id="pj_mainimg1" src="upload/${p.pj_img}" width="300px" height="225px">
						</div>
						<div>
							<c:choose>
							<c:when test="${p.req_status == 1}">
								<a id="request" style="color: DimGray;"> 요청중</a>
							</c:when>
							<c:when test="${p.req_status == 2}">
								<a id="request" style="color: red;" href="<c:url value="answer=${p.pnum}" />"> 답변보기</a>
							</c:when>
							</c:choose>
						</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">${p.pl_name}</td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
						<c:if test="${p.percent > 100}">
							<svg id="svg">
							<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
							<rect x="0" y="0" height="2" width="100%" fill="#fe6f61"></rect>
							</svg>
						</c:if>
						<c:if test="${p.percent < 100}" >
							<svg id="svg">
							<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
							<rect x="0" y="0" height="2" width="${p.percent}%" fill="#fe6f61"></rect>
							</svg>
						</c:if>
						</td>
					</tr>
					<tr>
						<td id="dday_css">
						<c:if test="${p.c_status == 2}"><img src="images/suc.png"><b style="color: Teal; vertical-align:4.5px;"> 펀딩성공</b></c:if>
						<c:if test="${p.c_status == 3}"><img src="images/stop.png"><b style="color: gray; vertical-align:4.5px;"> 중단</b></c:if>
						<c:if test="${p.c_status == 4}"><img src="images/fail.png"><b style="color: red; vertical-align:4.5px;"> 펀딩실패</b></c:if>
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css"> ${p.percent}%</span></td>
					</tr>
				</table>
				</div>
			 </c:forEach> 
			 </c:if>
			 </div></div>	
 	<br><br>
	<div id="reject" class="project">
		<span><a id="lab">반려된 프로젝트</a><a href="more=reject" style="float:right;">더보기</a></span><br><br>
		<div class="grid">
					<c:if test ="${empty rejectProject}"> 
			<div class="community" style="background-color:white;">
                <a id="commu_null" style="font-size:14px; color:black;">반려된 프로젝트가 없습니다.</a>
            </div>
	</c:if>
	<c:if test = "${! empty rejectProject}">
		 <c:forEach var="p" items="${rejectProject}" varStatus="status"> 
			<div>	
			<table class="a_pj" id="fundinglisttable">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<div class="entry">
							<img id="pj_mainimg1" src="upload/${p.pj_img}" width="300px" height="225px">
						</div>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">${p.pl_name}</td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
						</td>
					</tr>
					<tr>
						<td id="dday_css"></td>
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
