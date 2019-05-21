<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<style>
.layer1{
text-align: center;
padding-top: 100px;
}</style>
<body>

<div class="layer1">
[비밀번호 찾기]를 할때 본인 확인후, 
회원가입시 설정한 이메일로 재설정 링크를 보내드리고 있습니다.
<div style="color:red;">(※현재 SMTP(메일 서버) 미지원으로 이메일 확인후 "바로" 패스워드를 재설정할수 있습니다.)</div>

<br>
<br>비밀번호를 찾으실 계정의 이메일을 입력해주세요.

<form action="findMyPwd2" method="post">
찾을 이메일: <input type="text" name="email">
<input type="submit" value="찾기">
</form>


모두펀딩에서는 회원님들의 개인정보 보호와 보안성을 위해 패스워드를 암호화하여 DB에 저장하고 있습니다. 
<br>관리자도 정확한 비밀번호를 알 수 없는 점 양해 부탁드립니다
</div>
</body>
</html>
<%@ include file="/short_footer.jsp"%>