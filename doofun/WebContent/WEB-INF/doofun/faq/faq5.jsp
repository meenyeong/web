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
<title>${project.pj_sub}</title>
<script type="text/javascript">
 function go_list() {
	document.frm.action = "/doofun/faq";
	document.frm.submit();
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id=dfaq>
<form name=frm>
<div id=q>
<h1>프로젝트 홍보 기준은 무엇인가요?</h1>

<br>

<h3> 메인에 소개되는 프로젝트의 선정 기준은 무엇인가요?</h3>

모두의 펀딩 메인 화면은 상단의 히어로와 하단의 4개 컬렉션(에디터픽 프로젝트, 하트픽 프로젝트, 마감 앞둔 프로젝트, 새로운 프로젝트)으로 이루어집니다.<br>

히어로와 에디터 추천 프로젝트는 모두의 펀딩 홍보팀의 내부 회의를 통해 선정된 프로젝트를 게시합니다.

 <br> 선정 기준은 <b>모두의 펀딩 가이드라인에 충실한 지, 프로젝트 스토리텔링, 시각적 자료, 재미있는 선물 구성, 시의성, 장르별 다양성 </b>등 입니다.

<p>모두의 펀딩 메인 화면 하단부의 프로젝트 콜렉션의 경우 아래 기준에 따라 자동으로 프로젝트가 게시됩니다.</p>

하트픽 프로젝트 콜렉션에 게시되는 프로젝트는 '좋아요'가 가장 많은 프로젝트가 게시됩니다. 

 <br>새로운 프로젝트 콜렉션은 '펀딩 시작일'을 기준으로  자동으로 게시합니다.

 <br>마감 앞둔 프로젝트 콜렉션은 펀딩 마감이 임박한 프로젝트를 대상으로 '펀딩 마감일이 가까운 순서'대로 게시합니다.
 

<p>성공적인 펀딩을 기원드립니다.</p>

</div>
<div id=btn>
<input type=button class=btn_list value="목록" onclick="go_list()">
<br>
</div>
<br>
</form>
</div>
</body>
</html>
<%@ include file="/short_footer.jsp"%>