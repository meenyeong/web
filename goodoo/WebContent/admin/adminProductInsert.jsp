<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<h3>상품 등록</h3>
	<form method="post" name="frm" enctype="Multipart/form-data">
		<table id="list">
			<tr>
				<th>상품분류</th>
				<td colspan="5">
					<select name="kind">
							<c:forEach items="${kindList }" var="kind" varStatus="status">
								<option value="${status.count}">${kind }</option>
							</c:forEach>
					</select>
			</tr>
			<tr>
				<th>상품명</th>
				<td width="343" colspan="5">
					<input type="text" name="name" size="47" maxlength="100" value="킬 힐"/>
				</td>
			</tr>
			<tr>
				<th>원가 [A]</th>
				<td width="70">
					<input type="text" name="price1" size="11" onkeyup="sum(this)" value="10000">
				</td>
				<th>판매가 [B]</th>
				<td width="70">
					<input type="text" name="price2" size="11" onblur="go_ab()" onkeyup="sum(this)" value="20000">
				</td>
				<th>수익([B]-[A])</th>
				<td width="70">
					<input type="text" name="price3" size="11" readonly="readonly" onkeyup="sum(this)">
				</td>
			</tr>
			<tr>
				<th>상세설명</th>
				<td colspan="5">
					<textarea name="content" rows="8" cols="70">이쁘다</textarea>
				</td>
			</tr>
			<tr>
				<th>상품이미지</th>
				<td width="343" colspan="5">
					<input type="file" name="image"/>
				</td>
			</tr>
		</table>
		<input type="button" class="btn" value="등록" onclick="go_save()">
		<input type="button" class="btn" value="취소" onclick="go_mov()">
	</form>
</article>

<%@ include file="/admin/footer.jsp" %>