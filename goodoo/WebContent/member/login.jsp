<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>
<title>로그인</title>
<style type="text/css">
fieldset legend{font-weight:bold; font-size:18px; color:white;}
label.login{font-weight:bold; width:80px; height:auto;float:left;}
fieldset {width:100%; height:auto; margin-right:auto; margin-left:100px; padding:10px; overflow:hidden;}
form{ weight:60%; margin-right:auto;margin-left:auto;}
</style>
</head>
<body>
	<form method="post" id="join" action="NonageServlet?command=login">
		<fieldset>
			<legend>Login</legend>
			<label for="id" class="login">User ID</label> 
			<input name="id" type="text" value="${id}"><br>
			<label for="pw" class="login">Password</label> 
			<input name="pwd" type="password" value="${pwd}"><br>
		</fieldset>
		
		<div class="clear"></div>
		<div id="buttons">
			<input type="submit" value="로그인" class="submit"> 
			<input type="button" value="회원가입" class="cancel" 
						onclick="location='NonageServlet?command=join_form'">
		</div>
	</form>
</body>
</html>
<%@ include file="../footer.jsp" %>