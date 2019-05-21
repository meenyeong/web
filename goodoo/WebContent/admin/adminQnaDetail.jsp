<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/admin/adminheader.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
function go_save(){
	var theForm = document.frm;
	if(theForm.reply.value ==''){
	   alert('답변을 작성하세요.');
	   theForm.reply.focus();
	}else{
	      theForm.action="NonageServlet?command=admin_qna_save";
	      theForm.submit();
	   }      
	}
/* function go_rep(qseq){
	var theForm = document.frm;
	theForm.qseq.value=qseq;
	  theForm.action="NonageServlet?command=admin_qna_save";
      theForm.submit();
} */

</script> 
<article>
 <div id=logout style="float: right">
         <input type=button class=btn name=btn_logout  value="logout" onclick="location='NonageServlet?command=index'">
      </div>
      <br>
   <h1>Q&A 게시판</h1>
     <form name=frm method=post>
      <input type="hidden" name="qseq" value="${qnaVO.qseq}">
      <table id=orderList style="width:700px">
         <tr>
            <th align="center" style="width:100px">제목</th>
            <td>${qnaVO.subject}${qnaVO.rep}</td>
         </tr>
         <tr>
            <th align="center" style="width:100px">등록일</th>
            <td><fmt:formatDate value="${qnaVO.indate}"/></td>
         </tr>
         <tr>
            <th align="center" style="width:100px">내용</th>
            <td>${qnaVO.content}</td>
         </tr>
         <tr>
         
      </table>
      <table id=orderList style="width:700px">
         <c:choose>
         <c:when test='${qnaVO.rep=="1"}'>
            <tr>
           <td colspan="2"><img src="images/admin/opinionimg01.gif"></td>
           </tr>
           <tr>
            <td><textarea name=reply rows=3 cols=50></textarea>
            <input class=btn type=button value=저장 onclick="go_save()">
            <!-- <input class=btn type=button value=저장 onclick="go_rep('${qnaVO.qseq}')"> -->
            </td>
            </tr>
         </c:when>
         <c:otherwise>
         <tr>
            <th align="center" style="width:200px">댓글</th>
            <td>${qnaVO.reply}</td>
         </tr>
         </c:otherwise>
         </c:choose>
      </table>
      <input class=btn type=button value=목록 onclick="location='NonageServlet?command=admin_qna_list'">
   </form>
</article>

