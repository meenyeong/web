<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/fundingproject.css" rel="stylesheet">
<script type="text/javascript" src="javascript/fundingProject.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.css">
<title>${project.pj_sub}</title>
<script>
window.onload=function(){
	if (document.form.gift1_price.value == '0') {
		document.getElementById('gift1_funding').style.visibility = 'hidden';
	}
	if (document.form.gift2_price.value == '0') {
		document.getElementById('gift2_funding').style.visibility = 'hidden';
	}
	if (document.form.gift3_price.value == '0') {
		document.getElementById('gift3_funding').style.visibility = 'hidden';
	}
}
</script>
</head>
<body>
	<form name="form" method="Post">
		<header>
			<div id="head">
				<a id="subject">${project.pj_sub}</a>
			</div>
		</header>
		<div id="contents">
			
			<div id="only_funding" onclick="only_funding()">
				<a>선물을 선택하지 않고</a><br><br><br>
				<input type="text" id="only" placeholder="1000" value="1000원 이상 펀딩합니다." maxlength="7" disabled onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
				<label id="onlylabel" style="visibility: hidden;"> 원 펀딩하기</label><br><br>
				<a id="comment1" style="visibility: hidden;">더 많이 입력하실 수 있습니다.</a><br>
				<div class="go_funding" id="go1" style="float:right; padding-right: 100px; visibility: hidden;">
					<a id="btn"><img src="images/funding-button.png" onclick="go_only()"></a>
				</div>
			</div>
			
			<div id="gift1_funding" onclick="gift1_funding()" style="visibility:visible;">
				<input type="text" id="gift1" placeholder="${project.min_price1}" value="${project.min_price1}원 이상 펀딩해주시는 분께" maxlength="7" disabled onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
				<label id="gift1label" style="visibility: hidden;"> 원 펀딩하기</label><br>
				<a id="comment2" style="visibility: hidden;">더 많이 입력하실 수 있습니다.</a><br><br>
				<a>${project.gift_name1}</a><br><br>
				<ul style="list-style-image: url(images/giftcount.png); line-height: 3px; margin-left: -18px;">
					<li id="gift_count" style="float:left; font-size: 13px;"><a style="color:#fe6f61;">${gift.count1}</a>명이 선택하였습니다.</li>
				</ul>
				<div class="go_funding" id="go2" style="float:right; padding-right: 100px; visibility: hidden;">
					<a id="btn"><img src="images/funding-button.png" onclick="go_gift1()"></a>
				</div>
			</div>

			<div id="gift2_funding" onclick="gift2_funding()" style="visibility:visible;">
				<input type="text" id="gift2" placeholder="${project.min_price2}" value="${project.min_price2}원 이상 펀딩해주시는 분께" maxlength="7" disabled onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
				<label id="gift2label" style="visibility: hidden;"> 원 펀딩하기</label><br>
				<a id="comment3" style="visibility: hidden;">더 많이 입력하실 수 있습니다.</a><br><br>
				<a>${project.gift_name2}</a><br><br>
				<ul style="list-style-image: url(images/giftcount.png); line-height: 3px; margin-left: -18px;">
					<li id="gift_count" style="float:left; font-size: 13px;"><a style="color:#fe6f61;">${gift.count2}</a>명이 선택하였습니다.</li>
				</ul>
				<div class="go_funding" id="go3" style="float:right; padding-right: 100px; visibility: hidden;">
					<a id="btn"><img src="images/funding-button.png" onclick="go_gift2()"></a>
				</div>
			</div>
			
			<div id="gift3_funding" onclick="gift3_funding()" style="visibility:visible;">
				<input type="text" id="gift3" placeholder="${project.min_price3}" value="${project.min_price3}원 이상 펀딩해주시는 분께" maxlength="7" disabled onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
				<label id="gift3label" style="visibility: hidden;"> 원 펀딩하기</label><br>
				<a id="comment4" style="visibility: hidden;">더 많이 입력하실 수 있습니다.</a><br><br>
				<a>${project.gift_name3}</a><br><br>
				<ul style="list-style-image: url(images/giftcount.png); line-height: 3px; margin-left: -18px;">
					<li id="gift_count" style="float:left; font-size: 13px;"><a style="color:#fe6f61;">${gift.count3}</a>명이 선택하였습니다.</li>
				</ul>
				<div class="go_funding" id="go4" style="float:right; padding-right: 100px; visibility: hidden;">
					<a id="btn"><img src="images/funding-button.png" onclick="go_gift3()"></a>
				</div>
			</div>
			
			<input type="hidden" id="gift1_price" value="${project.min_price1}">
			<input type="hidden" id="gift2_price" value="${project.min_price2}">
			<input type="hidden" id="gift3_price" value="${project.min_price3}">
			<input type="hidden" id="number" name="number" value="">
			<input type="hidden" id="funded" name="funded" value="">
		</div>
	</form>
</body>
</html>