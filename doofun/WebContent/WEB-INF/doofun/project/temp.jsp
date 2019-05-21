<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
/* var a = document.getElementById("pnum").value;
alert(a); */
window.opener.document.getElementById("start").value= '${project}';
window.close();
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

선택한 주문번호 ${project} 

<input type="hidden" id="pnum" value="${project} " />

</body>
</html>