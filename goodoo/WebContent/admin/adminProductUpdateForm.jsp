<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/admin/adminheader.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">

function go_save(){
var theForm = document.frm;
if(theForm.kind.value ==''){
   alert('상품분류를 선택하세요.');
   theForm.kind.focus();
   }else if (theForm.name.value ==''){
   alert('상품명을 입력하세요.');
   theForm.name.focus();
   }else if(theForm.price1.value ==''){
      alert('원가를 입력하세요.');
      theForm.price1.focus();
   }else if(theForm.price2.value ==''){
      alert('판매가를 입력하세요.');
      theForm.price2.focus();
   }else if(theForm.content.value ==''){
      alert('상품상세를 입력하세요.');
      theForm.content.focus();
   }else if(theForm.image.value ==''){
      alert('상품이미지를 입력하세요.');
      theForm.image.focus();
   }else{
      theForm.encoding=multipart/form-data;
      theForm.action="NonageServlet?command=admin_product_write";
      theForm.submit();
   }      
}
function go_mod_save(tpage, pseq){
	   var theForm = document.frm;
	   theForm.action = "NonageServlet?command=admin_product_update&tpage=" + tpage + "&pseq=" + pseq;
	   theForm.submit();
	}

</script> 
<article>
   <h1>상품 수정</h1>
   <form name=frm method=post enctype=multipart/form-data>
   <input type="hidden" name="pseq" value="${productVO.pseq}">
   <input type="hidden" name="code">
   <!-- 새로운 이미지를 추가하지 않았을 때 기본 이미지 사용하기 -->
   <input type="hidden" name="nonmakeImg" value="${productVO.image}">
      <table id=list>
         <tr>
            <th>상품분류</th>
            <td colspan=5>
            <select name=kind>
               <c:forEach items="${kindList}" var="kind" varStatus="status">
                 <!-- 해당 상품분류로 지정 -->
                 <c:choose>
                  <c:when test="${productVO.kind==status.count}">
                     <option value="${status.count}" selected="selected">${kind}</option>
                  </c:when>
                  <c:otherwise>
                     <option value="${status.count}">${kind}</option>
                  </c:otherwise>
                 </c:choose>
               </c:forEach>
            </select>
         <tr>
            <th>상품명</th>
            <td width=343 colspan=5><input type=text name=name size=47 maxlength=100 value="${productVO.name}"></td>
         </tr>
         <tr>
            <th>원가[A]</th>
            <td width=70><input type=text name=price1 size=11 value="${productVO.price1}">
            </td>
            <th>판매가[B]</th>
            <td width=70><input type=text name=price2 size=11 value="${productVO.price2}">
            <th>[B-A]</th>
            <td width=72><input type=text name=price3 size=11 value="${productVO.price3}">
            </td>
         </tr>
         <tr>
            <th>베스트상품</th>
            <td>
         <c:choose>
            <c:when test='${productVO.bestyn=="y"}'>
               <input type="checkbox" name="bestyn" value="y" checked="checked">
            </c:when>
            <c:otherwise>
               <input type="checkbox" name="bestyn" value="n">
            </c:otherwise>
         </c:choose>
         </td>
            <th>사용유무</th>
            <td>
            <c:choose>
            <c:when test='${productVO.useyn=="y"}'>
               <input type="checkbox" name="useyn" value="n" checked="checked">
            </c:when>
            <c:otherwise>
               <input type="checkbox" name="useyn" value="n">
            </c:otherwise>
         </c:choose>
            </td>
         </tr>
         <tr>
            <th>상세설명</th>
            <td colspan=5><textarea name=content rows=8 cols=70>${productVO.content}</textarea>
            </td>
         </tr>
         <tr>
            <th>상품이미지</th>
            <td colspan=5>
            <img src="product_images/${productVO.image}" width="200px" />
            <br>
            <input type=file name=image>
            </td>
         </tr>
      </table>
      <input class=btn type=submit value=수정 onclick="go_mod_save('${tpage}', '${productVO.pseq}')"> 
      <input class=btn type=button value=취소 onclick="go_move()">
   </form>
</article>