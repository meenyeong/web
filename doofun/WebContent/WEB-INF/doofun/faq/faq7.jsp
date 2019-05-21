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
</head>
<body>
<div id=dfaq>
<form name=frm>
<div id=q>
<h1>프로젝트 펀딩하기가 무엇인가요?</h1><br>

<h3>프로젝트 펀딩하기란?</h3>
프로젝트 펀딩하기는 기획자들이 구상하는 프로젝트가 실제로 현실이 될 수 있도록 일정한 금액을 지불하여 돕는 것입니다. <br>
기획자를 향한 지지와 도움은 물론, 프로젝트를 통해 만들어지는 선물을 받아보시게 됩니다.<br>
펀딩하기는 간단합니다. 응원을 보내고 싶은 프로젝트 페이지 중앙의 프로젝트 펀딩하기 버튼을 누르시면 됩니다. <br>
금액별로 준비된 선물을 고르신 다음, 해당 금액에 대한 지불 수단을 선택해주세요. <br><br>

<h3>좋아하는 프로젝트들을 펀딩한 다음, 펀딩이 실패하면요?</h3>
결제한 금액은 각 프로젝트의 목표 금액 달성 여부에 따라 해당 프로젝트의 마감 익일에 자동으로 결제되거나 취소됩니다. <br><br>

<h3>프로젝트를 펀딩할 때 발생하는 수수료가 있나요?</h3>
없습니다. 설령 프로젝트가 실패한다 해도 결제한 금액 그대로 환불됩니다.<br><br>

<h3>제가 펀딩한 금액이 공개적으로 표시되나요?</h3>
아닙니다. 공개적으로 표시되지 않습니다. <br>
금액별 후원 현황은 오직 해당 프로젝트의 후원자 본인만 확인할 수 있습니다.<br><br>

<h3>제 이름을 익명으로 보여줄 수 있을까요?</h3>
원하신다면 닉네임을 쓰셔도 됩니다.<br><br>

<h3>꼭 재정적으로만 펀딩해야 하나요? 저는 돈 말고 다른 도움을 줄 수 있는데요.</h3>
현재로서는 그렇습니다. 가능하다면 비물질적인 도움과 제안도 시스템에 녹아들 수 있는 방법을 고민해보겠습니다. <br>
다른 방법으로 기획자에게 도움을 주고 싶다면, FAQ페이지  하단 문의하기를 눌러 메일을 전송하세요. 직접 답변을 받아보실 수 있습니다.<br><br>

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