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
<h1>주말이나 휴일에 제공되지 않는 서비스는 무엇인가요?</h1>

<br>

모두의 펀딩에서 프로젝트를 밀어주거나 새로운 프로젝트를 만들고 편집하는 대부분의 기능은 휴일 구분 없이 24시간 제공되고 있습니다.<br>
다만, 모두의 펀딩 고객지원 팀의 휴무인 주말 또는 법정공휴일에는 다음 서비스가 제공되지 않습니다.

<h3>창작자님의 프로젝트 공개 검토</h3>
접수된 공개 검토는 모두 다음 영업일에 순차적으로 진행됩니다.

<h3>전화 및 문의하기를 통한 문의의 답변</h3>
문의하기로 접수하신 문의는 모두 다음 영업일에 순차적으로 답변을 드리겠습니다.
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