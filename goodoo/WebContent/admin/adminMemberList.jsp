<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/admin/adminheader.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
      <div id=logout style="float: right">
         <input type=button class=btn name=btn_logout  value="logout" onclick="location='NonageServlet?command=index'">
      </div>
  <br>
      <h1>회원리스트</h1>
      <br>
      <form method="post" name="frm">
 
      <table id=memberList style=width:800px;>
         <tr>
            <th>아이디(탈퇴여부)</th>
            <th>이름</th>
            <th>이메일</th>
            <th>우편번호</th>
            <th>주소</th>
            <th>전화</th>
            <th>가입일</th>
         </tr>

               <c:forEach items="${memberList}" var="memberVO">
                  <tr>
                     <td>
                     <c:choose>
                        <c:when test='${memberVO.useyn == "n"}'>
                        <span style="color:gray; font-weight:bold;" >${memberVO.id}</span> 
                         (<input type="checkbox" checked=checked disabled=disabled>탈퇴)
                        </c:when>
                        <c:otherwise>
                        <span style="color:blue; font-weight:bold;">${memberVO.id}</span> 
                        (<input type="checkbox"  disabled=disabled>)
                        </c:otherwise>
                     </c:choose>
                     <td>${memberVO.name}</td>
                     <td>${memberVO.email}</td>
                     <td>${memberVO.zip_num}</td>
                     <td>${memberVO.address}</td>
                     <td>${memberVO.phone}</td>
                     <td><fmt:formatDate value="${memberVO.indate}"/></td>
                  </tr>
               </c:forEach>
        
      </table>

   </form>
</article>
