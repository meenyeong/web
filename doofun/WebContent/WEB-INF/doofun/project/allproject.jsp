<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<script>
window.onload=function(){
	var f= "${id}";
	
	f = f[0] + "*" + f.substring(2) + "님의 프로젝트";
	document.getElementById("email2").innerHTML=f;
	
}
</script>
<style>
#con{
	width:90%;
	justify-content: center;
	text-align: left;
	margin: auto;
}
.project{		
	padding: 20px;
	height: 450px;
}
#lab{
	font-size:25px;
	font-weight: bold;
	color:black;
}

table {
margin:auto;
height:50px;
}

.grid > * {
  float: left;  
  width: 25%;
}
.a_pj {
	width: 270px;
	border: 1px solid lightgray;
	margin-bottom: 30px;
}
.entry{
	position: relative;
}
#pj_mainimg1:hover{
	opacity: 0.5;
    filter: alpha(opacity=100);
}
#pj_mainimg1{
	opacity: 0.5;
    filter: alpha(opacity=100);
}
#request{
 	position: absolute;
	margin: auto;
    background-color: white;
    border: 3px solid #d9d9d9;
    font-weight:bold;
    color: black;
    padding: 12px 18px;
    text-decoration: none;
    font-size: 14px;
    border-radius: 5px;
    cursor:hand;
    margin-top: -125px;
    margin-left: 110px;
    z-index: 2;
}
#nocontents{
	width:75%; 
	justify-content: center;
	text-align: left;
	margin-left: 35%;
}
</style>
<meta charset="UTF-8">
<title>modoo funding</title>
</head>
<body>
<div id="con" class="fundinglistcon">
<div style="text-align: left;">
	<br><br>
		<h1 id="email2" style="text-align:center;">${id}님의 프로젝트</h1>
	<c:if test ="${empty project}"> 
			<div class="community" style="background-color:white;">
                <a id="commu_null" style="font-size:14px; color:black;">해당 프로젝트가 없습니다.</a>
            </div>
	</c:if>
	<div id="ing" class="moreproject">
		<a id="lab">
		</a>
		<br><br>
			<c:if test = "${!empty project}">
		 <c:forEach var="p" items="${project}" varStatus="status"> 	
		<div class="grid">
			<div>	
			<table class="a_pj" style="min-height:400px;">
					<tr>
						<td>					
						<a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}
							</span>					
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<div class="entry">
							<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px">
						</div>
						
						</td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css" style="min-height:40px;"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
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
						<c:choose>
						<c:when  test="${p.c_status == 2}">
						<img src="images/suc.png"><b style="color: Teal; vertical-align:4.5px;"> 펀딩성공</b></c:when>
						<c:when  test="${p.c_status == 3}"><img src="images/stop.png"><b style="color: gray; vertical-align:4.5px;"> 중단</b></c:when>
						<c:when  test="${p.c_status == 4}"><img src="images/fail.png"><b style="color: red; vertical-align:4.5px;"> 펀딩실패</b></c:when>
						<c:when  test="${p.c_status == 1}">	
						<img src="images/calendar.png">
							<c:if test="${p.dday < 1}"><b>마감</b></c:if>
							<c:if test="${p.dday > 1}"><b>${p.dday}</b>일 남음</c:if>
						</c:when>
						</c:choose>
						</td>
							<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
							<span id="percent_css"> ${p.percent}%</span></td>
									
					</tr>
				</table>
				</div>	
				</div>	
			 </c:forEach> 
			 </c:if>
			 </div>	
 	<br><br>
</div>

</div>
</body>
</html>
