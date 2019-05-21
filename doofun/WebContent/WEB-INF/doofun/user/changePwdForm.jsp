<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript">
function CheckPwd2()
{
	
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
	document.getElementById('bt_scan_pw').value = "완료(통과)"
	 return true;
	/*  return join_check(); */
 }
 
 }
 
 function ChangePwd(){
	 if  (CheckPwd2() == "false") { alert("새 비밀번호를 확인해주세요")}
	 var prepwd = "${userSubmit.pw}";
	 
	 if (prepwd == document.getElementById('oldpwd').value) {
		document.changePwdFrm.submit();}
	 else {alert("비밀번호를 확인해주세요.")}
	 
 }

</script>
<style>

.layer1{
text-align: center;
padding-top: 100px;
}

table.joinform{
 display: table; margin-left: auto; margin-right: auto;
 border-radius: 10px;
border: 1px solid lightgray;
/* border-collapse: collapse; */
    border-spacing: 1px;
 margin-top : 10px;
    margin-bottom: 10px;
    width:500px;
    
 }
 
.joinform td{
text-align: left;
border-bottom: 1px dashed lightgray;
padding: 10px 5px;

}
.joinform td:nth-child(1) {width:25%;  background:lightgray; }
.joinform td:nth-child(2) {width:55%;  }
.joinform td:nth-child(3) {width:20%; }

input[type="button"].scan {
	font-family: "nanumsquareround"; 
	background-color: #022528;
	padding-right: 30%;
	float: center;
	width: 120px;
	height: 30px;
	border: none;
	color: white;
	padding: 6px 12px;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}
</style>

</head>
<body>
<div class="layer1">
	<h2>모두펀딩: 비밀번호 변경</h2>
	<form name="changePwdFrm" action="changePwd" method="post">
	<input type="hidden" name="id" value="${userSubmit.id}" />
		<table class ="joinform">
		<tr><td>이메일</td><td colspan="2">${userSubmit.id}</td></tr>
		<tr><td>이전 비밀번호</td><td colspan="2"><input type="password" id="oldpwd" /></td></tr>
		<tr><td>새 비밀번호</td><td colspan="2"><input type="password" id="newpwd" name="pwd"/></td></tr>
		<tr><td></td><td colspan="2">비밀번호는 숫자와 영문자 조합으로 5~12자리</tr>
		<tr><td>새 비밀번호 확인</td><td colspan="2"><input type="password" id="newpwd2" />
		&nbsp;&nbsp;&nbsp; <input type="button" class="scan" id="bt_scan_pw" value="비밀번호 검사" onclick="CheckPwd2()">
		</td></tr>
	

			
			
			</table>
				 <input type="button" class="scan" value="비밀번호 변경" onclick="ChangePwd()">
	</form>
</div>
</body>
</html>
<%@ include file="/short_footer.jsp"%>