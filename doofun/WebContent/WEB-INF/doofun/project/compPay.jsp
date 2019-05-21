<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/fundingproject.css" rel="stylesheet">
<script type="text/javascript" src="javascript/fundingProject.js"></script>
<title>Modoo Funding</title>
</head>
<body>
<form name="form" method="post" action="pay_complete">
		<div id="header2">
			<div id="head2">
				<a id="subject" style="">${name}</a><br><br>
				<a style="font-size: 14px;">＊${payment.funded}원 펀딩하기</a><br>
			</div>
		</div><br><br>
	
	<div id="pay_content">
		<p style="font-weight:bold;">결제 수단을 선택해주세요</p><br>
		
			<div id="pay" onclick="pay_complete()">
				<div id="pay2">
				<img src="images/pay1.png"> 신용/체크카드
				</div>
			</div><br>
			
			<div id="pay" onclick="pay_complete()">
				<div id="pay2">
				<img src="images/pay2.png"> 무통장입금
				</div>
			</div>
	</div>
	
</form>
</body>
</html>