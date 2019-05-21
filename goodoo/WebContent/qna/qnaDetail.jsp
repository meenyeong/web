<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<article>
	<h1>1:1 고객 게시판</h1>
	<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
	<div id="qnadetail">
		<form method="post" name="form">
			<table id=notice>
				<tr>
					<th>제목</th>
					<td>${QnaVO.subject}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><fmt:formatDate value="${QnaVO.indate}" type="date" /></td>
				</tr>
				<tr>
					<th>질문내용</th>
					<td>${QnaVO.content}</td>
				</tr>
				<tr>
					<th>답변내용</th>
					<td>${QnaVO.reply}</td>
				</tr>
				</table>
				
				<div class="clear"></div>

				<div id=buttons>
					<input type="button" value="목록보기" class="submit"
						onclick="location='NonageServlet?command=qna_list'"> <input
						type="button" value="쇼핑 계속하기" class="submit"
						onclick="location='NonageServlet?command=index'">

				</div>
				</form>
				</div>
				</article>

				<%@ include file="../footer.jsp"%>