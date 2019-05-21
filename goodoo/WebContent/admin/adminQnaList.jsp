<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/admin/adminheader.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script type="text/javascript">
function go_view(qseq){
var theForm = document.frm;
theForm.qseq.value = qseq;
theForm.action = "NonageServlet?command=admin_qna_detail&qseq=" + qseq;
theForm.submit();
}
</script>


<article>
      <div id=logout style="float: right">
         <input type=button class=btn name=btn_logout  value="logout" onclick="location='NonageServlet?command=index'">
      </div>
  <br>
      <h1>Q&A 게시글 리스트</h1>
      <br>
      <form method="post" name="frm">
 
      <table id=qnaList style=width:800px;>
         <tr>
            <th>번호(답변여부)</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
         </tr>
         <c:forEach items="${qnaList}" var="qnaVO">
         <tr>
			<td>
			${qnaVO.qseq}
			 <c:choose>
                        <c:when test='${qnaVO.rep=="1"}'><span style="color:orange; font-weight:bold;">(미처리)</span></c:when>
                        <c:otherwise><span style="color:gray">(답변처리완료)</span></c:otherwise>
                        </c:choose>
                        </td>
                        <td>
                        <a href="NonageServlet?command=admin_qna_detail&qseq=${qnaVO.qseq}">
                       <%--  
                         onclick="javascript:go_view('${qnaVO.qseq}')"> --%>
                        ${qnaVO.subject}
                        </a>
                        </td>
                       
             <%--   <c:forEach items="${qnaList}" var="qnaVO">
                  <tr>
                     <td>
                     <c:choose>
                        <c:when test='${qnaVO.rep=="1"}'>
                        <span style="color:blue; font-weight:bold;">${qnaVO.qseq}</span> 
                        <input type="checkbox" name="result" disabled=disabled> (미처리)
                        </c:when>
                        <c:otherwise>
                        <span style="color:red; font-weight:bold;">${qnaVO.qseq}</span> 
                        <input type="checkbox" checked=checked  disabled=disabled> (답변처리완료)
                        </c:otherwise>
                     </c:choose>
                     
                     <td>
                      <c:choose>
                      <c:when test='${qnaVO.rep=="1"}'>
                      <span>
                     <!-- <a href="NonageServlet?command=admin_qna_reply"> -->
                     <
                     ${qnaVO.subject}</a></span>
                     </c:when>
                     <c:otherwise>
                     <span>
                      <a href="NonageServlet?command=admin_qna_reply_completed">${qnaVO.subject}</a></span>
                     </c:otherwise>
                     </c:choose>
                     </td> --%>
                     
                     <td>${qnaVO.id}</td>
                     <td><fmt:formatDate value="${qnaVO.indate}"/></td>
                  </tr>
               </c:forEach>
        
      </table>
   </form>
</article>
