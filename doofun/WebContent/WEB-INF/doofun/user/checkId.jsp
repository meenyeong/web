<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>
function apply_this(){
alert("현재 이메일을 사용합니다.");
window.opener.document.getElementById("email").value= '${temp_email}';

window.opener.document.getElementById("emailcheck").value= "아이디 변경"
window.opener.document.getElementById("emailok").value= "true";
window.close();
/* 
window.opener.document.getElementById("email"). */
}

function reject(){
	alert("다른 이메일을 사용합니다.");
	window.opener.document.getElementById("email").value= '';
	window.opener.document.getElementById("email").disabled = false;
	window.opener.document.getElementById("emailcheck").value= "중복 확인";
	window.opener.document.getElementById("emailok").value= "false";
			
			
	window.opener.document.getElementById("email").focus();
	
	
	window.close();
	/* 
	window.opener.document.getElementById("email"). */
	}
	
/* window.onload=function(){
	
	
		alert("${sysmsg}");
		var a = "${sysmsg}";
		alert(a);
	
	
} */

</script>

<meta charset="UTF-8">

<title>id체크</title>
${temp_email}은 ${sysmsg}합니다.<br>


<c:if test="${ (status==null)}">
<input type="button"  value="이메일 사용하기" onclick="apply_this()"></c:if>
<input type="button" value="다른 이메일 사용하기" onclick="reject()">
<p>왜 이메일이 사용 불가능할까요? <br>1. 올바르지 않은 이메일인 경우(이메일 내에 한글, 불필요한 특수문자, 또는 공백이  포함되어있을때)
<br>2. 이미 누군가 사용하고 있는 이메일인 경우(중복이라서)</p>
</head>
<body>

</body>
</html>