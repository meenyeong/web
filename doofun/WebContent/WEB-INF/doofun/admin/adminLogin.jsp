<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div>
	<form action="adminLogin" method="post">
		<p>
			<label>아이디 : </label> <input type="text" name="id"
				value="${userCommand.id}" />
		</p>
		<p>
			<label>비밀번호 : </label> <input type="password" name="pw"
				value="${userCommand.pw}" />
		</p>
		<input type="submit" value="로그인">
	</form>
	</div>
</body>
</html>