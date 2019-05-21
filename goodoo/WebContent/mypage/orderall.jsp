<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
a{
    color:red;
    text-decoration:none;
}
</style>
<article>
   <h2>MyPage(총 주문 내역)</h2>
   <form method="post" name="form">
         <table id="cartList">
            <tr>
               <th>주문일자</th><th>주문번호</th><th>상품명</th><th>결제금액</th><th>주문 상세</th>
            </tr>
            <c:forEach items="${orderList}" var="orderVO">
            <tr>
               <td><fmt:formatDate value="${orderVO.indate}" type="date" /></td>
            <td>${orderVO.oseq}</td>
            <td>${orderVO.pname}</td>
            <td><fmt:formatNumber value="${orderVO.price2}" type="currency"/></td>
               <td><a href="NonageServlet?command=order_detail&oseq=${orderVO.oseq}"> 조회 </a></td>
            </tr>
            </c:forEach>
         </table>
      <div class="clear"></div>
      <div id=buttons style="float : right">
         <input type="button" value="쇼핑계속하기" class="cancel" onclick="location='NonageServlet?command=index'">
      </div>
   </form>
</article>

<%@ include file="../footer.jsp"%>