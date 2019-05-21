<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
   <h2>1:1 고객 게시판</h2>
   <h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
   <form method="post" name="form" action="NonageServlet?command=qna_write">
  	<fieldset>
  		<legend>Board Info</legend>
    	<label>Title</label>
    	<input type="text" name=subject size=73 ><br>
        <label>Content</label>
        <textarea rows=8 cols=55 name=content></textarea><br>
        </fieldset>
           

      <div class="clear"></div>
      <div id=buttons style="float : right">
      <input type="submit" value="글쓰기" class="submit" >
      <input type="reset" value="취소" class="cancel" >    
         <input type="button" value="쇼핑계속하기" class="cancel" 
         onclick="location='NonageServlet?command=index'"> 

      </div>
   </form>
</article>

<%@ include file="../footer.jsp"%>