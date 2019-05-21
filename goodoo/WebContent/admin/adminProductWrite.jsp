<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin/adminheader.jsp"%>

<%@ include file="sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
//data유효성검사
function go_save(){
var theForm = document.frm;
if(theForm.kind.value ==''){
	alert('상품분류를 선택하세요.');
	theForm.kind.focus();
	}else if (theForm.name.value ==''){
	alert('상품명을 입력하세요.');
	theForm.name.focus();
	}else if(theForm.price1.value ==''){
		alert('원가를 입력하세요.');
		theForm.price1.focus();
	}else if(theForm.price2.value ==''){
		alert('판매가를 입력하세요.');
		theForm.price2.focus();
	}else if(theForm.content.value ==''){
		alert('상품상세를 입력하세요.');
		theForm.content.focus();
	}else if(theForm.image.value ==''){
		alert('상품이미지를 입력하세요.');
		theForm.image.focus();
	}else{
		theForm.encoding=multipart/form-data;
		theForm.action="NonageServlet?command=admin_product_write";
		theForm.submit();
	}		
}

</script> 
<article>
	<h1>상품등록</h1>
	<form name=frm method=post action="NonageServlet?command=admin_product_write" enctype=multipart/form-data>
		<table id=list>
			<tr>
				<th>상품분류</th>
				<td colspan=5><select name=kind>
						<c:forEach items="${kindList}" var="kind" varStatus="status">
							<option value="${status.count}">${kind}</option>
						</c:forEach>
				</select>
			<tr>
				<th>상품명</th>
				<td width=343 colspan=5><input type=text name=name size=47
					maxlength=100 value="킬힐"></td>
			</tr>
			<tr>
				<th>원가[A]</th>
				<td width=70><input type=text name=price1 size=11 value="0">
				</td>
				<th>판매가[B]</th>
				<td width=70><input type=text name=price2 size=11 value="0">
				<th>[B-A]</th>
				<td width=72><input type=text name=price3 size=11 value="0">
				</td>
			</tr>
			<tr>
				<th>상세설명</th>
				<td colspan=5><textarea name=content rows=8 cols=70>이뻐요</textarea>
				</td>
			</tr>
			<tr>
				<th>상품이미지</th>
				<td width=343 colspan=5><input type=file name=image></td>
			</tr>
		</table>
		<input class=btn type=submit value=등록 onclick="go_save()"> 
		<input class=btn type=button value=취소 onclick="go_move()">
	</form>
</article>
