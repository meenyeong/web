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
 function go_list() {
	document.frm.action = "/doofun/faq";
	document.frm.submit();
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id= dfaq>
<form name=frm>
<div id = q>
<h1>크라우드펀딩과 후원이란 무엇인가요?</h1>

<br>

<h3>크라우드펀딩이란 무엇이죠?</h3>
크라우드펀딩은 아이디어는 있지만 실행을 위한 자금이 부족한 개인 또는 팀이 다수의 사람들(Crowd)로부터 돈을 모금(Funding)하는 것을 말합니다. 

<h3>모두의 펀딩에서의 펀딩은 어떤 방식으로 진행되나요?</h3>
창작자는 만들고자 하는 창작물에 대한 이야기와 아이디어, 구체적인 계획, 선물의 스펙 등을 담은 프로젝트 페이지를 생성하여 플랫폼에 게시합니다. 게시된 프로젝트는 플랫폼을 통해 불특정 다수에게 노출되고, 이용자들은 원하는 프로젝트에 밀어주기(후원)을 통해 펀딩에 참여하여 후원자가 됩니다. 결제는 즉시 진행되지 않고 사전에 설정한 마감일 기준 목표 금액을 달성한 경우에만 진행됩니다. 후원금이 프로젝트 설계 당시 설정한 목표 금액에 도달하지 못할 경우 예약된 결제는 취소되며 창작자에게 전달되는 금액은 없습니다.

결제된 금액은 창작자에게 전달되어 후원자와 약속한 프로젝트를 진행하고 선물을 만드는 데에 쓰이게 됩니다. 이를 통해 만들어진 창작의 결과물은 펀딩에 참여한 후원자에게 선물로 제공됩니다.

창작자는 전달받은 금액을 반드시 프로젝트를 통해 후원자와 약속한 창작물을 만드는 데에 사용하고, 선물이 약속한대로 전달될 수 있도록 최선의 노력을 다해야 합니다. 단, 불가피한 선물의 변경 및 지연 등이 발생할 경우 창작자는 후원자에게 이를 성실히 설명하고 합의해야 할 의무가 있습니다. 지연 및 실패를 비롯한 프로젝트의 예상과 다른 진행 사항이 발생한 경우 그 책임은 창작자에게 있습니다.

 
<h3>밀어주기(후원)란 무엇인가요?</h3>
프로젝트 밀어주기는 창작자들이 구상하는 프로젝트가 실제로 구현될 수 있도록 일정한 금액을 지불하여 돕는 것입니다. 여러분은 창작자를 향한 지지와 도움을 더하고, 프로젝트를 통해 만들어지는 선물을 받아보시게 됩니다.

다만 모두의 펀딩에서 이루어지는 펀딩은 아직 구현되지 않은 아이디어를 후원을 통해 함께 완성해나가는 일입니다. 이 때문에 플랫폼 특성상 밀어주기(후원)는 완성된 제품을 주문받아 즉시 배송하는 구매와는 맥락이 다릅니다. 아이디어와 시제품 단계에서 후원을 받는 것이기에 계획한 프로젝트 및 선물이 예상과 달리 진행될 가능성이 존재하는 것이 사실입니다. 그러나 모두의 펀딩의 후원이 일반적인 구매와 맥락은 살짝 다를지라도 진행자는 창작을 위해 받은 후원에 상응하는 보상을 성실하게 제공할 책임이 있습니다.

 
<h3>모두의 펀딩은 이 과정에서 무엇을 하나요?</h3>
모두의 펀딩은 창작을 위한 새로운 시도를 소개하고 아이디어가 후원자를 만나 세상에 나올 수 있게 하는 플랫폼 서비스를 제공합니다.

만약 프로젝트의 후원 과정 및 진행에 있어 문제가 생길 경우 모두의 펀딩은 창작자와 후원자가 원만하게 문제를 해결할 수 있도록 커뮤니케이션을 돕습니다. 다만 여러 차례의 중재에도 불구하고 창작자의 의무와 책임을 다하지 않는 등의 문제가 계속되는 경우 모두의 펀딩은 해당 프로젝트를 장기 미실행 프로젝트로 분류하고 법적 대응을 원하는 당사자에게 이에 필요한 정보를 제공할 수 있습니다. 

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