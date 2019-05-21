<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link href="../css/admin.css" rel="stylesheet">
</head>
<body>
	<form action="NonageServlet?command=admin_login" method="post">
		<div class="container">
			<div class="main">
				<fieldset>
					<label for="">ID</label> <input type="text" name="id" /> <br /> <label
						for="">PW</label> <input type="password" name="password" /> <br /> <input
						type="submit" value="업무로그인" class="submit" />
				</fieldset>
			</div>
		</div>
		<div id=clear></div>

	</form>
</body>
</html>