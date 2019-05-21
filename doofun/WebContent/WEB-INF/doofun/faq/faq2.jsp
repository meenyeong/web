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
<div id= q>
<h1>펀딩 수수료는 얼마인가요?</h1>
펀딩 성공 후 발생하는 수수료에는 플랫폼 수수료와 후원금액의 집금 대행으로 발생하는 결제 및 송금 처리 수수료가 있습니다.
<br>
<h3>모두의 펀딩 플랫폼 이용 수수료</h3>
먼저 모두의 펀딩은 모집이 성사된 프로젝트에 한해 모금액의 5%를 유지비용으로 수수하고 있습니다. 

모두의 펀딩 플랫폼 수수료는 총 모금액의 5%(VAT 별도)입니다. 
펀딩에 실패한 프로젝트는 애당초 결제가 발생하지 않으므로 수수료 또한 없습니다.

<h3>모두의 펀딩 결제 수수료</h3>
모두의 펀딩 결제 수수료 정책이 개정되었습니다. 개정된 정책은 프로젝트의 시작일을 기준으로 적용되며 2018년 10월 1일부터 시행됩니다.

이전에는 결제·송금 처리 수수료는 후원자가 선택한 결제수단에 따라 총 모집 금액의 3~4% 정도가 발생하였으나, 10월 1일 이후 펀딩을 시작하는 프로젝트부터는 후원자의 결제 수단과 무관하게 결제 성공금액의 3%로 고정 수수료율을 적용받습니다. 또한, 모금액 정산 시 발생하던 송금 수수료가 별도로 청구되지 않습니다. 

결제 수수료는 결제 성공 금액의 3%(VAT 별도)입니다.

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