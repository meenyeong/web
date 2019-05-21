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
<h1>모두의 펀딩에서 프로젝트를 진행하려면 어떻게 해야 하나요?</h1>
모두의 펀딩은 후원형 크라우드 펀딩 플랫폼으로 창작자가 제작/생산에 앞서 자신의 아이디어, 프로토타입을 프로젝트를 통해 소개하고, 이에 반응하는 후원자를 모아 창작물을 완성할 수 있게 합니다.

프로젝트 진행을 원하신다면 아래 가이드에 따라 프로젝트 페이지를 작성하신 후 검토 요청하기 버튼을 눌러주세요. 검토 결과를 메일로 안내드리겠습니다. 

창작자님과 창작물을 소개하는 프로젝트 페이지를 만드는 방법은 매우 간단합니다. 만들고자 하는 것을 하나씩 소개해주시면 됩니다. 프로젝트 에디터를 사용해 프로젝트를 만들고 올리는 자세한 방법은 프로젝트 에디터 이용 가이드를 참고해주세요. 

<br>
<h3>1. 프로젝트 올리기</h3>

모두의 펀딩 메인 페이지의 우측 상단 로그인/회원가입을 눌러주세요.
로그인 후, 모두의 펀딩 메인 페이지의 프로젝트 만들기를 눌러주세요.
내용을 모두 확인하셨다면 프로젝트 만들기 버튼을 눌러 프로젝트 작성을 시작합니다.
프로젝트 개요 및 펀딩 / 선물구성과 스토리텔링 등 모든 항목을 작성해주신 후에  하단의 등록하기를 눌러주시면 됩니다. 
 

<h3>2. 프로젝트 공개 검토</h3>

프로젝트 공개 승인 검토는 요청주신 프로젝트가 모두의 펀딩에서 펀딩이 가능한지에 대한 여부를 확인하는 과정으로, 검토 요청을 주신 날로부터 피드백 메일을 받아보시기까지 주말·휴일 제외 최대 2일이 소요됩니다. 프로젝트의 승인까지는 최소 2일에서 최대 7일까지 걸릴 수 있습니다.

공개 승인이 반려되는 경우에는 보다 성공적으로 펀딩이 진행될 수 있도록 피드백을 드리기도 합니다. 검토 반려 시 저희가 보내드린 피드백을 반영하여 재검토 요청하기를 눌러주세요. 모두의 펀딩 에디터가 재검토 후 결과를 안내드릴 것입니다.

피드백을 반영해주시면 공개 검토가 승인되고, 프로젝트가 공개되어 펀딩이 시작됩니다.

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