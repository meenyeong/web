<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin/adminheader.jsp"%>

<title>관리자 로그인</title>
<!-- <style type="text/css">
fieldset legend{font-weight:bold; font-size:18px; color:white;}
label.login{font-weight:bold; width:80px; height:auto;float:left;}
fieldset {width:100%; height:auto; margin-right:auto; margin-left:100px; padding:10px; overflow:hidden;}
form{ weight:60%; margin-right:auto;margin-left:auto;}
</style> -->
</head>

<body style=text-align:center;>
<center>
	<form method="post"  action="NonageServlet?command=admin_login">
		<fieldset style=width:40%>
			<legend>Login</legend>
			<label for="id" class="login">아  이  디</label> 
			<input name="id" type="text" value="${id}"><br><br>
			<label for="pw" class="login" >비 밀 번 호</label> 
			<input name="pwd" type="password" value=""><br>
		</fieldset>
		<br><br>
		<div class="clear"></div>
		<div id="buttons">
			<input type="submit" value="업무 로그인" class="submit"> 

		</div>
	</form>

</body>
</html>
<%@ include file="../footer.jsp" %>