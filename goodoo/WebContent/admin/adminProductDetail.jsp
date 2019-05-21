<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin/adminheader.jsp"%>

<%@ include file="sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
function go_mod(tpage, pseq){
	   var theForm = document.frm;
	   theForm.action = "NonageServlet?command=admin_product_update_form&tpage=" + tpage + "&pseq=" + pseq;
	   theForm.submit();
	}
function go_list(tpage){
	var theFrom=document.frm;
	theForm.action="NonageServlet?command=admin_product_list&tpage="+tpage;
	theForm.submit();
}
</script>
<article>
	
	<form method="post" name="frm">

	     <div id=logout style="float: right">
         <input type=button class=btn name=btn_logout  value="logout" onclick="location='NonageServlet?command=index'">
      </div>
  <br>
		<h3 style="text-align: center; font: bold;">상품상세보기</h3>
		<br>

		<table id=productDetail>
			<tr>
				<th>상품분류 </th>
				<td colspan="5">       
				${kind}     
				<%-- <c:choose>
               <c:when test='${productDetail.kind == "1"}'>Heels</c:when>
               <c:when test='${productDetail.kind == "2"}'>Boots</c:when>
               <c:when test= '${productDetail.kind == "3"}'>Sandals</c:when>
               <c:when test= '${productDetail.kind == "4"}'>Sneakers</c:when>
               <c:when test= '${productDetail.kind == "5"}'>On Sale</c:when>
            </c:choose> --%>
            </td>
			</tr>	
			<tr>
				<th align=center>상품 명</th>
				<td colspan=5>${productDetail.name}</td>
				</tr>	
			<tr>
				<th>원가[A]</th>
				<td width=60>${productDetail.price1}</td>
				<th>판매가[B]</th>
				<td width=60>${productDetail.price2}</td>
				<th>[B-A]</th>
				<td>${productDetail.price3}</td>				
				</tr>	
			<tr>
				<th>상세설명</th>
				<td colspan=5>${productDetail.content}</td>
				</tr>	
			<tr>
				<th>상품이미지</th>
				<td colspan=5 align=center>
				<img src="product_images/${productDetail.image}" width=200 /></td>
			</tr>	
						
				<%-- 	<tr><td colspan=6 style=text-align:center;>${paging}</td></tr> --%>
				
		</table>
		<div class="clear"></div>
   
   <div id=buttons>
		<input type=button class=btn value="수정" onclick="go_mod('${tpage}','${productDetail.pseq}')">
		<input type=button class=btn value="목록" onclick="go_list('${tpage}')">
		</div>
	</form>
</article>

