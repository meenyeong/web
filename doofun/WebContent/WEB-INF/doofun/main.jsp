<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<script>
function go_newProject(){
	document.form.action = "newProject";
	document.form.submit();
}
</script>
</head>
<body>
<form name="form">
<article>
	<div id="start_funding">
		<img src="images/coralreef1.PNG" alt="main">
			<div class="btn_start">
				<label id="modoo_label1">지금 시작하세요!</label><br> <label id="modoo_label2">MODOO FUNDING</label><br>
				<br> <input type="button" class="new_project" value="프로젝트 만들기"
				onclick="go_newProject()">
			</div>
	</div>
	<div>
	<div class="pj_section">
	<div class ="pj_part" style="min-height: 550px;">
	<div class = "intropj" >
		<a id="pick"><img src="images/pick1.png" style="vertical-align: -20px;"> 하트PICK!</a><br><br><br>
		<a id="intro"><br /><br />하트PICK! 인기있는 펀딩을 소개합니다.</a>&nbsp;&nbsp;<a id="more" href="lookaround=1&like">더 구경하기</a>
	</div>
	<div class="gridmain">
		 <c:forEach var="p" items="${heartProject}" varStatus="status"> 
			<div>	
			<table class="a_pj">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="<c:url value="project${p.pnum}"/>" >
						<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px"></a></td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">
						<a style="color:DimGray; font-size:13px; vertical-align:4.5px;" >${p.pl_name}</a></td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
							<c:if test="${p.percent > 99}">
								<svg id="svg">
									<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
									<rect x="0" y="0" height="2" width="100%" fill="#fe6f61"></rect>
								</svg>
							</c:if>
							<c:if test="${p.percent < 100}">
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
						<c:if test="${p.dday < 1}"><b>마감</b></c:if>
						<c:if test="${p.dday > 1}"><b>${p.dday}</b>일 남음</c:if>
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css">${p.percent}%</span></td>
					</tr>
				</table>
				</div>
			 </c:forEach> 
			 </div></div>
	
	<div class ="pj_part" style="min-height: 550px;">
	<div class = "intropj" >
		<a id="pick"><img src="images/pick2.png" style="vertical-align: -20px;"> 새로운 프로젝트 </a><br><br><br>
		<a id="intro"><br /><br />새로 올라온 펀딩들을 둘러보세요! 당신도 얼리어답터!</a>&nbsp;&nbsp;<a id="more" href="lookaround=1&recent">더 구경하기</a>
	</div>
	<div class="gridmain">
		 <c:forEach var="p" items="${recentProject}" varStatus="status"> 
			<div>	
			<table class="a_pj">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="<c:url value="project${p.pnum}"/>" >
						<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px"></a></td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">
						<a style="color:DimGray; font-size:13px; vertical-align:4.5px;" >${p.pl_name}</a></td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
							<c:if test="${p.percent > 99}">
								<svg id="svg">
									<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
									<rect x="0" y="0" height="2" width="100%" fill="#fe6f61"></rect>
								</svg>
							</c:if>
							<c:if test="${p.percent < 100}">
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
						<c:if test="${p.dday < 1}"><b>마감</b></c:if>
						<c:if test="${p.dday > 1}"><b>${p.dday}</b>일 남음</c:if>
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css"> ${p.percent}%</span></td>
					</tr>
				</table>
				</div>
			 </c:forEach> 
	</div>
	</div>
	
	<div class ="pj_part" style="min-height: 550px;">
	<div class = "intropj" >
		<a id="pick"><img src="images/pick3.png" style="vertical-align: -20px;"> 마감 직전!</a><br><br><br>
		<a id="intro"><br /><br />마감 직전인 펀딩들을 둘러보세요! 운좋게 힙스터가 되실 수도 있습니다!</a>&nbsp;&nbsp;<a id="more" href="lookaround=1&soon">더 구경하기</a>
	</div>
	<div class="gridmain">
		 <c:forEach var="p" items="${soonProject}" varStatus="status"> 
			<div>	
			<table class="a_pj">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="<c:url value="project${p.pnum}"/>" >
						<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px"></a></td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">
						<a style="color:DimGray; font-size:13px; vertical-align:4.5px;" >${p.pl_name}</a></td>
					</tr>
					<tr>
						<td colspan="2" id="bar_td">
							<c:if test="${p.percent > 99}">
								<svg id="svg">
									<rect x="0" y="0" fill="#efefef" height="2" width="100%"></rect>
									<rect x="0" y="0" height="2" width="100%" fill="#fe6f61"></rect>
								</svg>
							</c:if>
							<c:if test="${p.percent < 100}">
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
						<c:if test="${p.dday < 1}"><b>마감</b></c:if>
						<c:if test="${p.dday > 1}"><b>${p.dday}</b>일 남음</c:if>
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css"> ${p.percent}%</span></td>
					</tr>
				</table>
				</div>
			 </c:forEach> 
			 </div>
			 </div>
			 
	<div class ="pj_part" style="min-height: 550px;">
	<div class = "intropj" >
		<a id="pick"><img src="images/pick4.png" style="vertical-align: -20px;"> 에디터 추천!</a><br><br><br>
		<a id="intro"><br /><br />모두펀딩의 분야별 에디터들이 매주 주목할 만한 프로젝트들을 추천해 드립니다.</a>&nbsp;&nbsp;<a id="more" href="lookaround=1&pick">더 구경하기</a>
	</div>
	<div class="gridmain">
		 <c:forEach var="p" items="${editorProject}" varStatus="status"> 
			<div>	
			<table class="a_pj">
					<tr>
						<td><a id="category_css">${p.pj_cate}</a></td>
						<td id="heartimg_css"><img src="images/giftcount.png">
							<span id="heart_css">${p.heartcount}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="<c:url value="project${p.pnum}"/>" >
						<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px"></a></td>
					</tr>
					<tr>
						<td colspan="2" height="30px" id="sub_css"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
					<tr>
					<tr>
						<td></td>
						<td id="name_css">
						<a style="color:DimGray; font-size:13px; vertical-align:4.5px;" >${p.pl_name}</a></td>
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
						<c:if test="${p.dday < 1}"><b>마감</b></c:if>
						<c:if test="${p.dday > 1}"><b>${p.dday}</b>일 남음</c:if>
						</td>
						<td id="sum_css"><b><fmt:formatNumber value="${p.sum}" pattern="#,###"/>원</b>
						<span id="percent_css"> ${p.percent}%</span></td>
					</tr>
				</table>
				</div>
			 </c:forEach> 
			 </div>
			 </div> 	
	</div>
	</div>

</article>
</form>
</body>
<%@ include file="/footer.jsp"%>