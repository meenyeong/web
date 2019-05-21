<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>
function apply_this(){
alert("현재 닉네임을 사용합니다.");
window.opener.document.getElementById("newname").value= '${temp_name}';

 window.opener.document.getElementById("namecheck").value= "다른닉네임변경" 
 window.opener.document.getElementById("newnameok").value= '${temp_name}';
window.close();

}

function reject(){
	alert("다른 닉네임을 사용합니다.");
	//window.opener.document.getElementById("name").value= '';
	window.opener.document.getElementById("namecheck").value= "닉네임중복확인";
	window.opener.document.getElementById("newnameok").value= "${userSubmit.name}"; 			
	window.opener.document.getElementById("newname").value= '${userSubmit.name}';
	window.opener.document.getElementById("newname").focus();		
	window.close();
	}
	


</script>

<meta charset="UTF-8">

<title>id체크</title>
${temp_name}은 ${able}${disable}합니다.<br>


<c:if test="${ (disable==null)}">
<input type="button"  value="이 닉네임 사용하기" onclick="apply_this()"></c:if>
<input type="button" value="다른 닉네임 사용하기" onclick="reject()">
<p>왜 닉네임이 사용 불가능할까요? <br>1. 올바르지 않은 닉네임이라(닉네임 내에 한글, 불필요한 특수문자, 또는 공백이  포함되어있을때)
<br>2. 이미 가입된 닉네임(중복이라서)</p>
</head>
<body>

</body>
</html>