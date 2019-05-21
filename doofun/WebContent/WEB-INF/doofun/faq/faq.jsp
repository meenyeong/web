<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/faq.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.css">
<title></title>
<script type="text/javascript">
function share(){
	document.getElementById('share_content').style.display='block';
	document.getElementById('fade').style.display='block';
}
function exit(){
	document.getElementById('share_content').style.display='none';
	document.getElementById('fade').style.display='none';
}
</script>
<style>
.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 1500px;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}
.share_content {
	display: none;
	position: absolute;
	top: 35%;
	left: 40%;
	width: 20%;
	height: 20%;
	padding: 16px;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>
<meta charset="UTF-8">
<title>FAQ</title>
</head>
<body>
<div id=dfaq>
<form name="form" action="faq" id="faq" method="post">
<article>
<div id=q>
<h2>자주 묻는 질문들</h2>
<table id= faq>
<tr>
<td><a href="<c:url value="faq1" />">크라우드펀딩과 후원이란 무엇인가요?</a></td>
<td><a href="<c:url value="faq2" />">펀딩 수수료는 얼마인가요?</a></td>
</tr>
<tr>
<td><a href="<c:url value="faq7" />">프로젝트 밀어주기가 무엇인가요? </a></td>
<td><a href="<c:url value="faq8" />">하나의 프로젝트에서 여러 번 밀어주는 것도 가능한가요?(다중 후원)</a></td>
</tr>
<tr>
<td><a href="<c:url value="faq3" />">모두의 펀딩에서 프로젝트를 진행하려면 어떻게 해야 하나요?</a></td>
<td><a href="<c:url value="faq4" />">모금액 정산 일정을 알고 싶어요.</a></td>
</tr>
<tr>
<td><a href="<c:url value="faq5" />">프로젝트 홍보 기준은 무엇인가요?</a></td>
<td><a href="<c:url value="faq6" />">주말이나 휴일에 제공되지 않는 서비스는 무엇인가요?</a></td>
</tr>
</table>
</div>
<br>
<br>
<div id= moreq>
<h2>질문에 대한 답을 찾지 못하셨나요?</h2>
<input type="button" class=btn_email value="문의하기" onclick="share()" />
</div>
 <div id="fade" class="black_overlay"></div>   
<div id="share_content" class="share_content">
         <a onclick="exit()" style="float:right;">X</a><br><br><br>
         <a>문의메일</a><br><br>
         <div>modoofunding@gmail.com</div> 
</div>
</article>
</form>
</div>

</body>
</html>
<%@ include file="/short_footer.jsp"%>
