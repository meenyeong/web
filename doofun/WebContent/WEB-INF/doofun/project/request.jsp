<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.css">
<meta charset="UTF-8">
<title>modoo funding</title>
<style>
form{
	font-family:nanumsquareround;
	justify-content: center;
	float: center; 
	text-align: center; 
	padding: 50px;
}
input[type="button"].btn{
	margin: auto;
    background-color: Gainsboro;
    padding-right: 30%;
    font-weight:bold;
    border: none;
    color: black;
    padding: 6px 12px;
    text-decoration: none;
    font-size: 12px;
    cursor: pointer;
    border-radius: 5px;
}
</style>
<script>
function textareaMaxlenth(){
	var frm = document.form.message;
	
		if (frm.value.length > 99) {
			alert("글자수는 100자로 제한됩니다.");
			frm.value = frm.value.substring(0, 99);
			frm.focus();
		}else if(frm.value.length < 10){
			alert("10자 이상으로 입력하세요.");
			frm.focus();
		}else{
			var content = document.form.message.value;
			document.form.content_hidden.value = content;
			document.form.action = "requestToadmin=" + ${pnum};
			document.form.method = "Post";
			document.form.submit();
		}
}
</script>
</head>
<body style="font-family:nanumsquareround;">
<form name="form">

    <a style="font-size:12px;">프로젝트 번호 : ${pnum}</a><br>
  <textarea id="message" cols="40" rows="11"></textarea><br><br>
  <input type="button" class="btn" value="전송하기" style="background-color:DimGray; color:white;" onclick="textareaMaxlenth()">
  <input type="button" class="btn" value="뒤로가기" onclick="history.go(-1)"><br>
  
  <input type="hidden" id="content_hidden" name="req_content" value="${request.req_content}">
  
</form>
</body>
</html>