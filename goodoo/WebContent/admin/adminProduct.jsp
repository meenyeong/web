<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin/adminheader.jsp"%>

<%@ include file="sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">

function go_detail(tpage,pseq){
	document.frm.action = "NonageServlet?command=admin_product_detail&tpage="+tpage+"&pseq="+pseq;
	document.frm.submit();
}
function go_wrt(){
	
	document.frm.action= "NonageServlet?command=admin_product_write_form";
	document.frm.submit();
}
</script>
<article>
		     <div id=logout style="float: right">
         <input type=button class=btn name=btn_logout  value="logout" onclick="location='NonageServlet?command=index'">
      </div>
  <br>
      <h1>상품리스트</h1>
		<br>
      <form method="post" name="frm">
		<table style="float: right;">
			<tr>
				<td width=642>상품명 <input type=text name=key> 
				<input type=button class=btn name=btn_search value=검색 onclick="go_search()">
				<input type=button class=btn name=btn_total value=전체보기 onclick="go_total()"> 
				 <input	type=button class=btn name=btn_write value=상품등록 onclick="go_wrt()">
				</td>
			</tr>
		</table>
		<table id=productList>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>원가</th>
				<th>판매가</th>
				<th>등록일</th>
				<th>사용유무</th>
			</tr>
			<c:choose>
				<c:when test="${productListSize<=0}">
					<tr>
						<td width=100% colspan=7 align=center height=23>등록된 상품이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${productList}" var="productVO">
						<tr>
							<td height=23 align=center>${productVO.pseq}</td>
							<td style="text-align:left; padding-left:50px; padding-right:0px">
							<a href="#" onclick="go_detail('${tpage}', '${productVO.pseq}')"> 
							<%-- <a href="NonageServlet?command=admin_product_detail&pseq=${productVO.pseq}"> --%>
							${productVO.name}</a></td>
							<td><fmt:formatNumber value="${productVO.price1}"/></td>
							<td><fmt:formatNumber value="${productVO.price2}"/></td>
							<td><fmt:formatDate value="${productVO.indate}"/></td>
							<td>
							<c:choose>
							<c:when test='${productVO.useyn=="1"}'>미사용</c:when>
							<c:otherwise>사용</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
					<tr><td colspan=6 style=text-align:center;>${paging}</td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
</article>

