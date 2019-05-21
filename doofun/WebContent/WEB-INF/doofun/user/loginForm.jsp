<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script>

window.onload=function(){
	/* var f="${boardVO.id}";
	f= f[0] + "*" + f.substring(2);
	document.getElementById("email2").innerHTML=f;
	 */
	 
	 var f= ${printCookie};
	 if (f!=""){
		 alert(f);
/* 		 document.getElementById("id").value=f; */
	 }
}
</script>

<style>
table#loginform{
 display: table; margin-left: auto; margin-right: auto;
 background-color: lightgray;
 border-radius: 10px;
 padding : 10px 10px;
 margin-top:10px;
    margin-bottom: 10px;
 }
 
#loginform td{
text-align: center;
padding: 5px ;
}

.layer1{

text-align: center;
 padding-top:100px;

}

input[type="submit"]{
	font-family: "nanumsquareround"; 
	background-color: #022528;
	padding-right: 30%;
	float: right;
	width: 100px;
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

<%-- <a style="font-size:16pt; font-weight:bolder; color:#fe6f61;"	href="<c:url value='join'/>">[모두펀딩 가입하기]</a>
			 --%>
input[type="button"]#joinbt{
	font-family: "nanumsquareround"; 
	background-color: #fe6f61;
	padding-right: 30%;

	width: 140px;
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
<article>
	<div id="con">
		<div class = "layer1">
		
		<form action="userLogin" method="post">
			<label id="loginLabel" style="font-weight:bold; font-size:30px;">모두펀딩: 로그인 </label>
			<table id="loginform">
			<tr><td>이메일</td><td><input type="text" name="id" value="${printCookie}"/></td>
			</tr>
			<tr><td>비밀번호</td><td> <input type="password" name="pw" 	/></td>
			<tr><td colspan="2"><input type="checkbox" name="saveId" checked>이메일 저장<input type="submit" value="로그인" class=".login"></td></tr>
			</table> 아직 계정이 없으신가요?
			
<input type="button" id="joinbt" value="모두펀딩 가입하기" onclick = "location.href='join'">
<br>비밀번호를 잊으셨나요?
			
<input type="button" id="joinbt" value="비밀번호 찾기" onclick = "location.href='findMyPwd1'">
			


			
		</form>
		</div>
	</div>
</article>
</body>
</html>
<%@ include file="/short_footer.jsp"%>