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
<h1>모금액 정산 일정을 알고 싶어요.</h1>

<br>

<h3>후원자님들의 결제는 언제, 어떻게 이루어지나요?</h3>
마감일 기준 모금액이 목표를 달성하여 펀딩에 성공한 다음 날 결제가 진행되고, 결제에 실패한 후원에 대해서는 7일간의 유예기간동안 24시간 간격으로 매일 출금을 시도합니다. 이 기간이 모두 지나도록 결제에 실패한 후원건의 경우 결제 누락으로 처리되고, 선물을 받아볼 수 없게 됩니다. 

후원 결제 일정 : 펀딩 마감 다음 날 오전(결제 실패자에 한해 마감일로부터 7일간 매일 오전 재결제)
정산일 : 결제 종료일로부터 7영업일 후


<h3>펀딩에 성공했습니다! 정산은 언제인가요?</h3>
모두의 펀딩의 모금액 정산은 결제 성공한 후원자님의 후원금액을 모아, 창작자님께서 등록하신 정산계좌로 입금됩니다.
모금액 정산 입금은 프로젝트의 결제 종료일로부터 은행 영업일 기준 7일(공휴일 및 주말 제외) 후에 진행됩니다. 


<h3>결제 일정 및 정산일은 어떻게 계산할 수 있나요?</h3>
펀딩 마감일이 2018년 7월 1일 일요일인 프로젝트의 결제 및 정산 일정을 살펴보겠습니다.

후원 결제는 펀딩 마감 다음날인 7월 2일 오전부터 시작됩니다. 1회 이상 결제 실패자에 한하여 7월 8일까지 24시간 간격으로 7일간 재결제를 시도합니다. 

모금액은 결제 종료일인 7월 8일로부터 은행 영업일 기준 7일(공휴일 및 주말 제외) 뒤인 7월 17일 오후에 등록하신 계좌로 정산됩니다.
 

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
<%@ include file="/footer.jsp"%>