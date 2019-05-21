<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script>
	function category_submit() {
		var category_hidden = document.form.cate.options[document.form.cate.selectedIndex].value;
		document.form.pj_cate.value = category_hidden;
	}

</script>
<link href="css/cal.css" rel="stylesheet">
<meta charset="UTF-8">
<title>프로젝트 등록하기</title>
</head>
<body>
	<form name="form" id="newproject" action="newProject" method="post"
		enctype="multipart/form-data">
		<div class="preview" id="preview" style="visibility: hidden;">
			<p>
				<input type="text" id="view_btn" value="미리보기 버튼을 클릭하세요." disabled
					style="visibility: visible; width: 200px; text-align: center; border: none; font-size: 12px; color: #fe6f61; background-color: white;">
			</p>
			<a id="category">카테고리</a>
			<p id="input_pjimg">
				<img src="images/project_basic.png" width="620px" alt="project_img">
			</p>
			<input type="button" class="funding" value="프로젝트 펀딩하기"><input type="button" class="share" value="공유하기" onclick="share()"><br>
			<h1 id="input_subject"></h1>
			<p id="input_planner"></p>
			<div id="input_plinfo"
				style="font-size:12px; line-height: 150%; width: 500px; float: center; text-align: center; display: inline-block; padding: 10px 10px 10px 10px; color: dimgray; border: 1px dotted gray;"></div>
			<p>
				<span id="label">목표 금액 <label id="value1">0원</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span id="label">후원자 <label id="value2">0명</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span id="label">남은 기간 <label id="input_dday">0일</label><span><label id="input_fin"></label></span></span>
			</p>
			<p>
				모인 금액 <label style="font-weight: border; color: black; font-size: 30px"></label>
				<label id="sum">0원</label>
			</p>
			<span><a id="percent_value">(0%)</a></span>
			<div class="Graph">
				<p id="Bar">
					<span id="Percent" style="float: left;"></span>
				</p>
			</div>
			<div class="plinfo">
				목표 금액이 달성되어야만 펀딩 성공입니다.<br> 목표금액이 모이지 않으면 마감일 다음날 자동 환불됩니다.
			</div>
			<br> <br>

			<div class="previewtab">
				<input type="radio" name="previewtab" id="tab3"> 
				<input type="radio" name="previewtab" id="tab4"> 
				<input type="radio" name="previewtab" id="tab5"> 
				<label for="tab3">스토리보드</label>
				<label for="tab4">선물보기</label>
				<label for="tab5">커뮤니티</label>
				
				<div class="tab3_content" style="text-align: left;">
					<div id="input_contents"></div>
				</div>
				<div class="tab4_content">
					<div id="gift1" style="visibility: hidden;">
						<ul
							style="list-style-image: url(images/giftcount.png); line-height: 3px;">
							<li id="gift_count">0명이 선택</li>
						</ul>
						<br>
						<p id="input_gift1_price">
							<fmt:formatNumber value="" pattern="#,###" />원+
						</p>
						<p id="input_gift1_name"></p>
						<input type="button" class="selfunding" value="펀딩하기"
							onclick="go_funding()">
					</div>
					<br> <br> <br>
					<div id="gift2" style="visibility: hidden;">
						<ul
							style="list-style-image: url(images/giftcount.png); line-height: 3px;">
							<li id="gift_count">0명이 선택</li>
						</ul>
						<br>
						<p id="input_gift2_price">
							<fmt:formatNumber value="" pattern="#,###" />원+
						</p>
						<p id="input_gift2_price"></p>
						<input type="button" class="selfunding" value="펀딩하기"
							onclick="go_funding()">
					</div>
					<br> <br> <br>
					<div id="gift3" style="visibility: hidden;">
						<ul
							style="list-style-image: url(images/giftcount.png); line-height: 3px;">
							<li id="gift_count" style="float: left;">0명이 선택</li>
						</ul>
						<br>
						<p id="input_gift3_price">
							<fmt:formatNumber value="" pattern="#,###" />원+
						</p>
						<p id="input_gift3_price"></p>
						<input type="button" class="selfunding" value="펀딩하기"
							onclick="go_funding()">
					</div>
					<br> <br>
					<p style="font-size: 13px; color: dimgray;">예상 전달일은 프로젝트 마감일
						30일 이내입니다. 30일이 넘을 경우 자동 환불됩니다.</p>
					<br> <br>
				</div>
				<div class="tab5_content">
					<div class="community" style="background-color:white;">
						<a id="commu_null" style="font-size:14px; color:black;">작성된 글이 없습니다.</a>
					</div>
				</div>
			</div>
		</div>
		<div id="input">
			<div class="tabmenu">
				<input type="radio" name="tab" id="tab1" checked> <input
					type="radio" name="tab" id="tab2"> <label for="tab1">프로젝트
					개요 및 펀딩</label> <label for="tab2">선물구성과 스토리텔링</label>

				<div class="tab1_content">
					<fieldset id="content">
						<h1>&lt;PROJECT&gt;</h1>
						<table id="overview">
							<tr>
								<th>프로젝트 제목</th>
								<td><input type="text" id="subject" name="pj_sub"
									maxlength="60" value="${projectRequest.pj_sub}" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="subjectnull" name="subjectnull"
									value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
							<tr>
								<th>대표이미지</th>
								<td><input type="file" id="pjimg" name="pj_img" size="5" value="${projectRequest.pj_img}" /></td>
								<td style="width: 10px; text-align: left;"><span class="tooltip">?<span class="text">이미지 사이즈는 <br>가로 620px, 세로 465px 입니다.	</span></span></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="pjimgnull" name="pjimgnull"
									value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
							<tr>
								<th>카테고리</th>
								<td><select id="cate" name="cate"
									onchange="category_submit()">
										<option id="category" value="영화·영상">영화·영상</option>
										<option id="category" value="패션">패션</option>
										<option id="category" value="공연">공연</option>
										<option id="category" value="생활">생활</option>
										<option id="category" value="음악">음악</option>
										<option id="category" value="미술">미술</option>
										<option id="category" value="푸드">푸드</option>
										<option id="category" value="게임">게임</option>
										<option id="category" value="캠페인">캠페인</option>
										<option id="category" value="기타" selected>기타</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="hidden" name="pj_cate" id="pj_cate"
									value="기타"></td>
							</tr>
						</table>
						<br />

						<h1>&lt;PLANNER&gt;</h1>
						<table id="overview">
							<tr>
								<th>프로필 이미지</th>
								<td><input type="file" id="plimg" name="pl_img" size="5"
									value="${plannerRequest.pl_img}" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="plimgnull" name="plimgnull"
									value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
							<tr>
								<th>진행자 이름</th>
								<td><input type="text" id="plname" name="pl_name"
									maxlength="30" value="${plannerRequest.pl_name}" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="plnamenull" name="plnamenull"
									value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
							<tr>
								<th>진행자 소개</th>
								<td><textarea id="plinfo" name="pl_info" rows="2" cols="25"
										maxlength="200">${plannerRequest.pl_info}</textarea></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="plinfnull" name="plinfonull"
									value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
						</table>
						<br />

						<h1>&lt;FUNDING&gt;</h1>
						<table id="overview">
							<tr>
								<th>목표금액</th>
								<td><input type="text" id="goal" name="pj_goal" size="13"
									maxlength="9" value="${projectRequest.pj_goal}" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">원</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="goalnull" name="goalnull"
									value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
							<tr>
								<td colspan="2" height="50px" style="color: red; font-weight:normal;">시작일은 프로젝트 승인일입니다(최대 7일)<!-- <input type="text" id="date_start" name="pj_start"
									size="10" maxlength="8"
									style="text-align: center; border: none; font-size: 12px; border-bottom: 1px solid gray; color: black; background-color: white;">
									<input type="button" id="cal1" class="upload" value="검색"
									onclick="fnPopUpCalendar(date_start,date_start,'yyyymmdd')"> --></td>
							</tr>
							<tr>
								<td></td>
								<td><!-- <input type="text" id="date_startnull"
									name="date_startnull" value="" disabled
									style="width: 250px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"> --></td>
							</tr>
							<tr>
								<th>마감일</th>
								<td>&nbsp;&nbsp;<input type="text" id="date_fin" name="pj_fin" size="10" maxlength="8" style="text-align: center; border: none; font-size: 12px; border-bottom: 1px solid gray; color: black; background-color: white;">
									<input type="button" id="cal2" class="upload" value="검색" onclick="fnPopUpCalendar(date_fin,date_fin,'yyyymmdd')"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="text" id="date_finnull"
									name="date_finnull" value="" disabled
									style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"></td>
							</tr>
						</table>
						<br />
					</fieldset>
				</div>
				<div class="tab2_content">
					<fieldset id="content">
						<h1>&lt;GIFT&gt;</h1>
						<fieldset id="gift">
							<input type="text" placeholder="0" id="min_price"
								name="min_price" maxlength="9" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">원 이상 펀딩해주시는 분들께<br>
							<input type="text" id="min_pricenull" name="min_pricenull"
								value="" disabled
								style="text-align: center; border: none; font-size: 12px; color: red; background-color: white;"><br>
							<input type="text" placeholder="선물이름" id="gift_name" name="gift_name">을(를) 선물합니다! 
							<input type="button"
								id="giftupload" class="upload" value="등록"
								onclick="gift_upload()"><br> <input type="text"
								id="gift_namenull" name="gift_namenull" value="" disabled
								style="text-align: center; border: none; font-size: 12px; color: red; background-color: white;"><br>

						</fieldset>
						<fieldset id="giftlist">
							<input type="text" id="giftlist1_price" name="min_price1"
								value="${giftRequest.min_price1}"
								style="text-align: right; visibility: hidden;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> <span
								id="gift1_text"
								style="font-size: 11px; color: DimGray; visibility: hidden;">원
								이상</span> <input type="text" id="giftlist1_name" name="gift_name1"
								value="${giftRequest.gift_name1}" style="visibility: hidden;">
							<input type="button" class="upload" id="giftdel1" value="삭제"
								onclick="delgift1()" style="visibility: hidden"><br>
							<input type="text" id="giftlist2_price" name="min_price2"
								value="${giftRequest.min_price2}"
								style="text-align: right; visibility: hidden;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> <span
								id="gift2_text"
								style="font-size: 11px; color: DimGray; visibility: hidden;">원
								이상</span> <input type="text" id="giftlist2_name" name="gift_name2"
								value="${giftRequest.gift_name2}" style="visibility: hidden;">
							<input type="button" class="upload" id="giftdel2" value="삭제"
								onclick="delgift2()" style="visibility: hidden"><br>
							<input type="text" id="giftlist3_price" name="min_price3"
								value="${giftRequest.min_price2}"
								style="text-align: right; visibility: hidden;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> <span
								id="gift3_text"
								style="font-size: 11px; color: DimGray; visibility: hidden;">원
								이상</span> <input type="text" id="giftlist3_name" name="gift_name3"
								value="${giftRequest.gift_name3}" style="visibility: hidden;">
							<input type="button" class="upload" id="giftdel3" value="삭제"
								onclick="delgift3()" style="visibility: hidden"><br>
							<input type="text" id="gift_listnull" name="gift_listnull"
								value="" disabled
								style="width: 200px; text-align: center; border: none; font-size: 12px; color: red; background-color: white;"><br>
						</fieldset>
						<h1>&lt;STORY&gt;</h1>
						<br> <br>
						<fieldset id="story" style="border: none;">
							<textarea id="contents" name="story"></textarea>
							<script>
								CKEDITOR.replace('contents', {
									filebrowserUploadUrl : '/upload'
								});
							</script>
							<input type="text" id="contents_null" name="contents_null"
								value="" disabled
								style="text-align: center; border: none; font-size: 12px; color: red; background-color: white;">
							<input type="hidden" name="contents_hidden" id="contents_hidden" value="${projectRequest.story}"> <br />
						</fieldset>
					</fieldset>
				</div>
			</div>
			<br> <br>
			<div id="btn">
				<input type="button" class="cancel" value="미리보기" onclick="preview()">
				<input type="button" class="projectsave" value="등록하기" onclick="save()"> 
				<input type="reset" class="newreset" value="다시작성">
				<input type="button" class="cancel" value="취소"	onclick='location.href="main"'>
			</div>
		</div>
	</form>
</body>
</html>