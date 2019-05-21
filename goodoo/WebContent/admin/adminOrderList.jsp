<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/admin/adminheader.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
      <div id=logout style="float: right">
         <input type=button class=btn name=btn_logout  value="logout" onclick="location='NonageServlet?command=index'">
      </div>
  <br>
      <h1>주문리스트</h1>
      <br>
      <form method="post" name="frm">
      <table style="float: right;">
         <tr>
            <td>주문자 이름   <input type=text name=key> 
            <input type=button class=btn name=btn_search value=검색 onclick="go_search_order()">
            </td>
         </tr>
      </table>
      <table id=orderList style=width:800px;>
         <tr>
            <th>주문번호(처리여부)</th>
            <th>주문자</th>
            <th>상품명</th>
            <th>수량</th>
            <th>우편번호</th>
            <th>배송지</th>
            <th>전화</th>
            <th>주문일</th>
         </tr>
         <c:choose>
            <c:when test="${orderListSize<=0}">
               <tr>
                  <td width=100% colspan=7 align=center height=23>주문리스트가 없습니다.</td>
               </tr>
            </c:when>
            <c:otherwise>
               <c:forEach items="${orderList}" var="orderVO">
                  <tr>
                     <td>
                     <c:choose>
                        <c:when test='${orderVO.result=="1"}'>
                        <span style="color:blue; font-weight:bold;">${orderVO.odseq}</span> 
                        (<input type="checkbox" name="result" value="${orderVO.odseq}"> 미처리)
                        </c:when>
                        <c:otherwise>
                        <span style="color:red; font-weight:bold;">${orderVO.odseq}</span> 
                        (<input type="checkbox" checked=checked disabled=disabled> 처리완료)
                        </c:otherwise>
                     </c:choose>
                     <td>${orderVO.mname}</td>
                     <td>${orderVO.pname}</td>
                     <td>${orderVO.quantity}</td>
                     <td>${orderVO.zip_num}</td>
                     <td>${orderVO.address}</td>
                     <td>${orderVO.phone}</td>
                     <td><fmt:formatDate value="${orderVO.indate}"/></td>
                  </tr>
               </c:forEach>
            </c:otherwise>
         </c:choose>
      </table>
            <input type=button class=btn style="width:200px" value=주문처리(입금확인) onclick="go_order_save()">
   </form>
</article>
