<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/header.jsp"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.layer1{
text-align: center;
padding-top: 100px;
}</style>
<script>

function findpwCheck(){
	alert("새 비밀번호로 변경합니다.")
	if (document.getElementById('newpwd').value != document.getElementById('newpwd2').value) { //타입상관있을때 === ,없을때는 ==
		alert("[새 비밀번호]와 [새 비밀번호 확인]이 같지 않습니다. 확인해주세요");
	return false;	}
 var upw =document.getElementById('newpwd').value;

 if(!/^[a-zA-Z0-9]{5,12}$/.test(upw) || upw.indexOf(' ') > -1) //이줄에 추가적인 조건을 넣었습니다.
 {
  alert('비밀번호는 숫자와 영문자 조합으로 5~12자리를 사용해야 합니다.');
 return false;
 }

 var chk_num = upw.search(/[0-9]/g);
 var chk_eng = upw.search(/[a-z]/ig);
 
 if(chk_num < 0 || chk_eng < 0)
 {
  alert('비밀번호는 숫자와 영문자를 혼용하여야 합니다.');
  return false;
 }
   
 else  if(/(\w)\1\1\1/.test(upw))
    {
        alert('비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.');  
    return false;
    }
 else {
	 document.findpw.submit();
	 }
}
</script>

</head>
<body>
<div class="layer1">
이메일 ${email} 는 가입 ${able} 이메일입니다.


<c:choose>
<c:when test = "${ok == 1}" >
<br>
비밀번호는 숫자와 영문자 조합으로 5~12자리를 사용해야 합니다.<br>
<form name="findpw" action="findMyPwd3" method=post style="padding-top:20px;">
<input type="hidden" name="email" value="${email}">
<table style="    margin-left: auto;
    margin-right: auto; text-align: left;" >
<tr><td>새 비밀번호</td><td> <input type="password" name="newpw" id="newpwd"></td></tr>
<tr><td>새 비밀번호 확인</td><td><input type="password" id="newpwd2"></td></tr>
</table>
<input type="button" value="새 비밀번호 사용하기" onclick="findpwCheck()">
</form>
</c:when>
<c:otherwise><input type="button" value="새로 가입하기" onclick="location.href='join'">
</c:otherwise>

</c:choose>
</div>
</body>
</html>
<%@ include file="/short_footer.jsp"%>