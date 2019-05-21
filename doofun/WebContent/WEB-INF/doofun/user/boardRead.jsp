<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/board.css" rel="stylesheet">

<script>



window.onload=function(){
	var f="${boardVO.id}";
	f= f[0] + "*" + f.substring(2);
	document.getElementById("email2").innerHTML=f;
	
}
	function f1(a) {
		/* alert(a); */

		/* alert(document.getElementById(a).value); */
		/* alert(document.getElementById(a).innerHTML); */
		document.getElementById(a).style.visibility = 'visible'; //'hidden';

	}

	function f2(a) {
		document.getElementById(a).style.visibility = 'hidden';

	}

	function del(a) {
		msg = "정말 댓글을 삭제할까요?";
		
		if (confirm(msg) != 0) {
			document.getElementById('delComm'+a).submit();

		} else {
			// no click
		}
	}

	function delBoard() {
		msg = "정말 게시글을 삭제할까요?";
		if (confirm(msg) != 0) {
			document.getElementById('delBoardFrm').submit();

		} else {
			// no click
		}
	}

	function commWrite(){
		//댓글 400자 제한
		var contents = CKEDITOR.instances.bcconid.getData();
		
		if (contents.trim() == 0) {
			alert("덧글 내용을 입력해주세요."); 
			return false;}
		
		if (contents.length >= 408) {
			alert("덧글은 400자까지 남기실 수 있습니다."); 
			
			return false;}
		
		document.getElementById("bcInsert").submit();

	}
	
	function commModi(a){
		//댓글 400자 제한
		//alert(a);
		var commArea = CKEDITOR.instances[a];//'a'란 이름의 객체 찾아서 저장 -> CKEDITOR.instances['id값'];
		 newComm= commArea.getData();
		
	
		if (newComm.trim() == 0) {
			alert("덧글 내용을 입력해주세요."); 
			return false;}
		
		else if (newComm.length >= 408) {
			alert("덧글은 400자까지 남기실 수 있습니다."); 
			
			return false;}
		
		
			//CKEDITOR.instances[a].setData(newComm);
			document.getElementById("modComm"+a).submit();
		
		
	}
	
	
	
</script>
<script src="//cdn.ckeditor.com/4.11.2/basic/ckeditor.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#mainform {
	width: 80%;
	display: table;
	margin-left: auto;
	margin-right: auto;
	padding-top: 70px;
}

#readBoard {
	width: 90%;
	border: 3px double #4e9ca9;
	display: table;
	margin-left: auto;
	margin-right: auto;
	padding: 10px;
	border-collapse: collapse;
	margin-bottom: 10px;
}

#readBoard td {
	border: 1px dashed gray;
	border-bottom: 1px solid gray;
	text-align: center;
	padding: 10px 10px;
}

#readBoard td:nth-child(1) {
	width: 20%;
	  background:LightGray;
  color:#022528;
}

#readBoard td:nth-child(2) {
	width: 30%
}

#readBoard td:nth-child(3) {
	width: 20%;
	  background:LightGray;
  color:#022528;
}

#readBoard td:nth-child(4) {
	width: 30%
}

#comm_area {
	border: 2px dashed lightgray;
	width: 87%;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 15px;
	padding: 10px 10px;
}

#comm_time {
	text_align: right;
	font-size: 8px;
	color: gray;
}

#newComm {
	margin-left: auto;
	margin-right: auto;
	width: 90%;
}

.read_st {
	width: 95%;
	padding: 10px 0;
	padding-bottom: 20px;
	text-align: right;
}

.inlineFrm {
	display: inline-block;
}

.modComm {
	display: inline;
}

#newComm {
	margin-top: 40px;
	padding-top: 10px;
	border-top: 4px double lightgray;
}

h3 {
	display: inline;
	margin-bottom: 5px;
}


input[type="submit"].scan2 {
	font-family: "nanumsquareround"; 
	background-color: #022528;
	padding-right: 30%;
	float: center;
	width: 120px;
	height: 30px;
	border: none;
	color: white;
	padding: 6px 12px;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}
input[type="button"].scan {
	font-family: "nanumsquareround"; 
	background-color: #022528;
	padding-right: 30%;
	float: center;
	width: 120px;
	height: 30px;
	border: none;
	color: white;
	padding: 6px 12px;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}

td#BoardMainContent{

text-align:left;
}
</style>


</head>


<body>
	<article>
		<div id="mainform">


			<table id="readBoard">
				<tr>
					<td>글번호</td>
					<td>${boardVO.cseq}</td>
					<td>이메일</td>
					<td><span id="email2">${boardVO.id}</span></td>
				</tr>
				<tr>
					<td>프로젝트명
					<td><c:if test="${ (boardVO.pnum!=0)}"><a href="<c:url value="/project${boardVO.pnum}"/>">${boardVO.pjsub} &nbsp;<input type="button" class="scan" value="구경가기" style="width:80px;"></button></a></c:if></td>
					<td>닉네임
					<td>${boardVO.name}</td>
				</tr>
				<tr>
					<td>제목
					<td colspan="3">${boardVO.csub}</td>
				</tr>
				<tr>

				</tr>

				<tr>
					<td>등록일자</td>
					<td><fmt:formatDate value="${boardVO.cdate}"
							pattern="yyyy-MM-dd" /></td>

					<td>최근수정</td>
					<td><fmt:formatDate value="${boardVO.cdate2}"
							pattern="yyyy-MM-dd" /></td>

				</tr>

				<tr>
					<td>내용</td>
					<td colspan="3" id="BoardMainContent">${boardVO.ccon}</td>
				</tr>



			</table>

			<div class="read_st">
				<c:if test="${boardVO.id == userSubmit.id}">
					<!--  본인일때만  -->

					<form class="inlineFrm" action="mod=${cseq}" method="post">
						<input type="submit" value="글 수정하기" class="scan2">
					</form>
					
					
					<form id="delBoardFrm" class="inlineFrm" action="user/delete/${cseq}" method="post"
						style='display: inline;' >
					<input type="hidden" name="bcseq" value="${cseq}">
					<input	type="button" value="글 삭제하기" onclick="delBoard()" class="scan">
					</form>
					
					
				</c:if>
			</div>






			<c:forEach var="cm" items="${CommentVO}">
			
				<div id="comm_area">
					<%-- ${cm.cseq}/${cm.bcseq}/${cm.id}/--%>
					${cm.name} <span id="comm_time">남긴시각 : ${cm.bcdate}
						(수정시각:${cm.bcdate2}) </span>
					<div>${cm.bccon}</div>




					<div class="read_st">
						<c:if test="${cm.id == userSubmit.id}">

							<form action="modComm" method="post" id="modComm${cm.bcseq}" class="modComm">
									<input type="hidden" name="name" value="${userSubmit.name}"> 

								<div id="div${cm.bcseq}" class="cmdiv"
									style="visibility: hidden;">
									<textarea id="${cm.bcseq}" name="newComm" rows='1' cols='1'>${cm.bccon}</textarea>
									<input type="button" value="수정 완료" class="scan" onclick="commModi(${cm.bcseq})">
								</div>

								<input type="hidden" name="cseq" value="${boardVO.cseq}" /> <input
									type="hidden" name="bcseq" value="${cm.bcseq}" /> <input
									type="button" id="bt${cm.bcseq}" value="댓글 수정하기" class="scan"
									onclick="CKEDITOR.replace('${cm.bcseq}'),f1('div${cm.bcseq}'), f2('bt${cm.bcseq}')">

							</form>

							<form id="delComm${cm.bcseq}" class="inlineFrm" action="delComm=${cm.cseq}&${cm.bcseq}"
								method="post" id="delfrm">
								<input type="hidden" name="bcseq" value="${cm.bcseq}"> <input
									type="button" value="댓글 삭제" onclick="del(${cm.bcseq})" class="scan">
							</form>


						</c:if>

					</div>
				</div>

			</c:forEach>





			<div id="newComm">
				<h3>[댓글 남기기]</h3>(댓글은 400자까지 남기실 수 있습니다.)
				<br>
				<br>
				<c:if test="${ (userSubmit.id==null)}">
댓글을 남기시려면 로그인이 필요합니다.</c:if>
				<c:if test="${! (userSubmit.id==null)}">
					<form id="bcInsert" action="bcInsert" method="post">


						<textarea name="bccon" id="bcconid"></textarea>
						<script>
							CKEDITOR.replace('bccon');
						</script>
						<div class="read_st">
							<input type="hidden" name="id" value="${userSubmit.id}" /> <input
								type="hidden" name="name" value="${userSubmit.name}" /> <input
								type="hidden" name="cseq" value="${boardVO.cseq}" /> 
								<input	type="button" value="댓글 등록" onclick="commWrite()" class="scan"><!-- onclick="writeComm()" -->
						</div>

					</form>
				</c:if>

				<div class = "read_st">
<form action="write2" method="post">
<input type="button" value="글 목록으로" onclick="location.href='commu'" class="scan">



<c:if test="${! (userSubmit.id==null)}">

<input type="submit" value="새 글쓰기" class="scan2">
</form>
</c:if>

<c:if test="${ (userSubmit.id==null)}">
<br><br> 로그인을 하셔야 새 글을 작성할 수 있습니다
<a href="<c:url value="userLogin"/>"/>[로그인 하러가기]</a><br>
</c:if>
</div>
				
			</div>


		</div>
	</article>

</body>
</html>
<%@ include file="/footer.jsp"%>