<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.css">
<meta charset="UTF-8">
<title>modoo funding</title>
<style>
form {
	font-family: nanumsquareround;
	padding: 50px;
	text-aling:center; 
}
input[type="button"].btn {
	margin: auto;
	background-color: Gainsboro;
	padding-right: 30%;
	font-weight: bold;
	border: none;
	color: black;
	padding: 6px 12px;
	text-decoration: none;
	font-size: 12px;
	cursor: pointer;
	border-radius: 5px;
}
#con {
	justify-content: center;
	float: center;
	text-align: center;
}
#content {
	vertical-align: middle;
	margin: auto;
	padding-top: 20px;
	width: 30%;
	height: 300px;
	color: black;
	font-size:13px;
}

#comm {
	vertical-align: middle;
	margin: auto;
	padding-top: 20px;
	width: 30%;
	height: 300px;
	color: black;
	font-size:13px;
}
</style>
</head>
<body>
<form name="form">

<div id="con">
<a style="text-align:center; font-size:14px; color: black;">&lt;${request.pnum}번 프로젝트&gt;</a>
			<fieldset id="content">
				<legend style="color: gray; font-size: 12px;">요청사항</legend>
				${request.req_content}
			</fieldset>
			<br> <br>


			<fieldset id="comm">
				<legend style="color: gray; font-size: 12px;">요청 피드백</legend>
				${request.req_comm}
			</fieldset>
			<br> <br> <input type="button" class="btn" value="뒤로가기" onclick="history.go(-1)"><br><br>
</div>
</form>
</body>
</html>