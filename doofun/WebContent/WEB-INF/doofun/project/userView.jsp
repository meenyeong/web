<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$(function() {
			$('#homeup').click(function() {
				$('body,html').animate({ scrollTop : 0 }, 800);
				return false;
			});
			
		var scrollHeight = $(document).height();
			$('#homedown').click(function() {
				$('body,html').animate({ scrollTop : scrollHeight }, 800);
				return false;
			});
		});

	});
</script>
<script type="text/javascript">
function funding_search() {
	if (document.frmpj.key.value == "") {
		alert("검색 할 펀딩 이름을 입력해주세요");
		document.frmpj.key.focus(); //안썼을때 그 텍스트필드에 포커스 맞춰서 깜빡임
	} else {
		//document.frmpj.action = "/doofun/commu/1/" //get 접근시(적용 실패)
		document.frmpj.action = "lookaround=1&key=" + document.frmpj.key.value;
		document.frmpj.submit();
	}
}
function next(){	
	var num = ${num};
	var look = ${look};
	num = Number(num);
	num = num +1;	
	var key = document.form.hidden.value;
	if(look == 0){
		if(document.form.hidden.value == undefined){
	document.form.action = "lookaround="+num+"&";
	}else{
		document.form.action = "lookaround="+num+"&key="+key;
		}
	}if(look == 1){
	document.form.action = "lookaround="+num+"&pick";	
	}if(look == 2){
	document.form.action = "lookaround="+num+"&like";	
	}if(look == 3){
	document.form.action = "lookaround="+num+"&soon";	
	}if(look == 4){
	document.form.action = "lookaround="+num+"&recent";	
	}if(look == 5){
	document.form.action = "lookaround="+num+"&cate="+key;	
	} 
	document.form.submit();	
}

</script>
<title>Insert title here</title>

</head>
<body>
 
	<article id="lookpj">
		<a href="#homedown" id="homedown" style="margin-left:10px; float:left;">
			<img src="images/down.png" onmouseover="this.src='images/downh.png'" onmouseout="this.src='images/down.png'" width="40px">
		</a>
		<div class="pj_section">
			<p id="category_pick">	
			<c:choose>	
						
				<c:when test="${!(key2 == null)}">
				<h1>모두의 펀딩 둘러보기 : "모두" 보기</h1>	
						
				</c:when>
				<c:otherwise>
				<h1>모두의 펀딩 둘러보기 : "${key}" 보기</h1>	
							
				</c:otherwise>
				</c:choose>	
				<a href="lookaround=1&cate=영화·영상">영화·영상 | </a> <a
					href="lookaround=1&cate=패션">패션 | </a> <a
					href="lookaround=1&cate=공연 "> 공연 | </a> <a
					href="lookaround=1&cate=생활">생활 | </a> <a
					href="lookaround=1&cate=음악">음악 | </a> <a
					href="lookaround=1&cate=미술">미술 | </a> <a
					href="lookaround=1&cate=푸드">푸드 | </a> <a
					href="lookaround=1&cate=게임">게임 | </a> <a
					href="lookaround=1&cate=캠페인">캠페인 | </a> <a
					href="lookaround=1&cate=기타">기타 </a></p> 
			<!-- 	<p><a id="look" href="lookaround=1&">모두</a> &nbsp;&nbsp; <a id="look" href="lookaround=1&pick">추천순</a> &nbsp;&nbsp; 
				<a id="look" href="lookaround=1&soon" >마감순</a> &nbsp;&nbsp; <a id="look" href="lookaround=1&like">인기순</a> &nbsp;&nbsp; 
				<a id="look" href="lookaround=1&recent">최신순</a>
			</p> -->
			<div id="pj_search">
				<form name="frmpj" method="post">
					펀딩 검색하기 : <input type="search" name="key">&nbsp;<input
						type="button" class="scan" value="검색" onclick="funding_search()">
				</form>
			</div>
			
			<div id=orderchange><a id="look" href="lookaround=1&">  모두</a> &nbsp;&nbsp;  <a id="look" href="lookaround=1&soon" >마감순</a> &nbsp;&nbsp; <a id="look" href="lookaround=1&like">인기순</a> &nbsp;&nbsp; 
				<a id="look" href="lookaround=1&recent">최신순</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="look" href="lookaround=1&pick">에디터pick</a><br>
			</div><br>
			
			<!-- 그리드 레이아웃 -->
			<div class="gridmain" style="padding-top:10px;">
			${no_result}
				<c:forEach var="p" items="${projectRequest}">				
					<div>
						<table class="a_pj" >
							<tr>
								<td id="category_css">${p.pj_cate}</td>
								<td id="heartimg_css"><img src="images/giftcount.png">
									<span id="heart_css">${p.heartcount}</span>
								</td>
							</tr>
							<tr>
								<td colspan="2"><a href="<c:url value="project${p.pnum}"/>">
									<img id="pj_mainimg" src="upload/${p.pj_img}" width="300px" height="225px"></a></td>
							</tr>
							<tr style="height: 50px;">
								<td colspan="2" height="30px" id="sub_css" style="min-height:40px;"><a href="<c:url value="project${p.pnum}"/>">${p.pj_sub}</a></td>
							<tr>
							<tr>
								<td></td>
								<td id="name_css"><a style="color:DimGray; font-size:13px; vertical-align:4.5px;">${p.pl_name}</a></td>
							
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
		<div>
		<form name="form" method="post">	
		<input type="hidden" id=hidden name=hidden value="${key}">	
		</form>
		</div></div>		
		<a href="#homeup" id="homeup" style="margin-left:10px;">
			<img src="images/up.png" onmouseover="this.src='images/uph.png'" onmouseout="this.src='images/up.png'" width="40px">
		</a>			
		
		<input type="button" id="btn_next" value="+더보기" onclick="next()">	
		
	</article>
<c:if test="${!(no_result==null)}"><%@ include file="/short_footer.jsp"%>	</c:if>
<c:if test="${(no_result==null)}"><%@ include file="/footer.jsp"%> </c:if>
</body>


</html>