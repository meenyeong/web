<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../header.jsp"%>

<!--  메인 이미지 들어가는 곳 시작 -->
<div class="clear"></div>
<div id="main_img">
	<img src="images/main_img.jpg">
</div>
<!--  메인 이미지 들어가는 곳 끝 -->
<div class="clear"></div>


	<div id="front">
		<h2>NEW ARRIVAL</h2>
		<center>
		<div id="bestProduct">
			<c:forEach items="${newProductList}" var="productVO">
				<div id="item">
					<a
						href="NonageServlet?command=product_detail&pseq=${productVO.pseq}">
						<img src="product_images/${productVO.image}" />
						<h3>${productVO.name}</h3>
						<p>${productVO.price2}</p>
					</a>
				</div>
			</c:forEach>
		</div>
	</center>		
		<div class="clear"></div>

		<h2>WEEKLY BEST</h2>
		<center>
		<div id="bestProduct">
			<c:forEach items="${bestProductList}" var="productVO">
				<div id="item">
					<a
						href="NonageServlet?command=product_detail&pseq=${productVO.pseq}">
						<img src="product_images/${productVO.image}" />
						<h3>${productVO.name}</h3>
						<p>${productVO.price2}</p>
					</a>
				</div>
			</c:forEach>
		</div>
		</center>
		<div class="clear"></div>
	</div>

<%@ include file="../footer.jsp"%>