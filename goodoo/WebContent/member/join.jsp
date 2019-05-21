<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style type="text/css">
fieldset legend {font-weight:bold; font-size:18px; color:white;}
label.add {font-weight : bold; width:80px; height:auto; float:left;}
fieldset {width:100%; height : auto ; margin-right: auto; margin-left: 100px; padding:10px; overflow:hidden;}
form { weight:60%; margin-right: auto; margin-left: auto; }
</style>
</head>
<body>
	<form id="join" action="NonageServlet?command=join" method="post" name="form" onsubmit="go_save()" >
			<fieldset>
			<legend>Basic Info</legend>
			
			<label for="id" class="add" >ID</label>
			<input type=text name=id size=12 maxlength=12>
			<input type=hidden id=reid>
			<input type=button value="중복확인" class="dup" onclick="idcheck()"><br>
			
			<label for="pw" class="add" >Password</label>
			<input type=password name=pwd size=12 maxlength=12><br>
			
			<label for="pw_confirm" class="add" >Retype PW</label>
			<input type=password name=pwdCheck size=12 maxlength=12><br>
			
			<label for="name" class="add" >Name</label>
			<input type=text id=name size=12 maxlength=12><br>
			
			<label for="email" class="add" >E-Mail</label> 
			<input type=text name=email1 size=12 maxlength=12>@
				<select	name=email2><option SELECTED value="">선택</option>
									<option value="gmail.com">gmail.com</option>
									<option value="daum.net">daum.net</option>
									<option value="naver.com">naver.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="직접입력">직접입력</option>
				</select>
			
			</fieldset>
			<fieldset>
			
			<legend>Optional</legend>
			
			<label for="post" class="add" >Zip Code</label>
			<input type=text name=zipnum size=12 maxlength=12>
			<input type=button value="우편번호검색" class="dup" onclick="post_zip()"><br>

			<label for="add" class="add" >Address</label>
			<input type=text name=addr1 size=40 maxlength=50><br>
			<label for="name" class="add" > </label>
			<input type=text name=addr2 size=40 maxlength=50><br>
			
			<label for="phone" class="add" >Phone</label>
			<input type=text name=phone1 size=3 maxlength=3>-
			<input type=text name=phone2 size=4 maxlength=4>-
			<input type=text name=phone3 size=4 maxlength=4><br><br><br>
			
			<center>
			<input type=submit value="추가" class="dup" >
			<input type='reset' value='다시작성' class="dup" >
			<input type='button' value='취소' class="dup"	 onclick='location.href="/shop/NonageServlet?command=contract"'>
			</center>
			</fieldset>
	</form>
</body>
</html>
<%@ include file="../footer.jsp"%>