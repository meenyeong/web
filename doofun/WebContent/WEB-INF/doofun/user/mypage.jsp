
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/header.jsp"%> 

<!DOCTYPE html>
<html>
<head>
<style>
.mypage_grid {
	text-align:center;
	color: #fe2e1b;
	font-weight: bold;
	font-size: 13px;
	padding-top: 5%;
}
#mypage{
	text-align:center;
	justify-content: center;
	margin: auto;
	border-collapse: collapse;
}
table td{
	border : 1px dotted gray;
	padding:45px; 
	width:250px; 
	line-height:30px;
}
img{
	cursor: pointer;
}
.layer1{

text-align: center;
 padding-top:100px;

}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="layer1" style="padding-bottom:50px;">
<div class="mypage_grid">
	<table id="mypage">
		<tr>
			<td>
				<table>
					<tr>
						<td style="border:none; padding:0; border-right: 1px solid gray;"><img src="images/mypage1.png" onclick="location='infoModi2'"><br>회원정보 수정</td>
						<td style="border:none; padding:0;"><img src="images/mypage2.png" onclick="location='changePwdForm'"><br>비밀번호 변경</td>
					</tr>
				</table>
			</td>
			<td><img src="images/mypage5.png" onclick="location='mypick'"><br>내가 찜한 프로젝트</td>
		</tr>
		<tr>
			<td><img src="images/mypage3.png" onclick="location='lookmine'"><br>내가 펀딩한 프로젝트</td>
			<td><img src="images/mypage4.png" onclick="location='myproject'"><br>내가 시작한 프로젝트</td>
		</tr>
	</table>
</div>
</div>
<br>
<br>
<br>
<br>
<br>
</body>
</html>

<%@ include file="/footer.jsp"%>