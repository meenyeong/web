<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/write_table.css" rel="stylesheet">
<style>
</style>
<script type="text/javascript">

function pnum_search() {	//alert("검색 할 상품명을 입력해주세요");
	document.writeform.pnum.focus();
window.open("choice","search" )

}

function pnum_search2() {
	document.writeform.pnum.focus();
window.open("choice2","search" )
}

function write1(){
	
	var subscan =document.getElementById('csub').value;
	
	if ( subscan == "" ) {
		alert("제목없이 글을 작성 할 수 없습니다!")
	}
	else if ( subscan.length > 24 ){
		alert ("제목은 24글자 까지 입니다.")
	}
	else {
		
		document.getElementById('csub').value = subscan.replace(/</gi,"&lt;");
			document.getElementById('writeform').submit(); }
}
</script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>


<meta charset="UTF-8">
<title>Insert title here</title>
<style>


#mainform{
  
  width: 80%;
    display: table; margin-left: auto; margin-right: auto;
    padding-top: 100px;
}

.write_section {
padding : 10px 10px;
text-align: center;
}

.write_table {
  border: 1px dashed #4e9ca9;
  display: table;
  margin-left: auto; margin-right: auto;
  padding:10px;
  border-collapse: collapse;
}
.write_table td{
  border: 1px dashed gray;
  text-align:center;

  padding: 10px 10px;
}
.write_table td:nth-child(1) {width:20%; background:lightgray;}

.write_table td:nth-child(2) {width:80% }

.btn_pj{
-moz-border-radius: 0 0 0 0 ;
	-webkit-border-radius: 0 0 0 0 ;	
	background-color: #4F6573;	
	color: white;	
	font-size:13px;

}

#start, #csub{
float:left;
}

</style>
</head>
<body>
<article>


<div id = "mainform">



   <form id="writeform" name="writeform" action="write3" method="post">
     <input type="hidden" name="id" value="${userSubmit.id}" />
     <input type="hidden" name="name"  value="${userSubmit.name}" />



<div class = "write_section">
<h1>새 글 쓰기</h1>

펀딩선택은 필수 사항이 아닙니다. 제목없이 글을 작성하실 수 없습니다. 제목은 최대 24글자까지입니다. 제목에 html태그를 사용하실 수 없습니다.<br>

</div>



            <table class="write_table">
            <tr>
              <td>
                id
                </td>
              <td style="text-align:left;"> ${userSubmit.id}
                </td>
              </tr>
            <tr>
              <td>
                닉네임 </td><td style="text-align:left;">
                  ${userSubmit.name}

                  </td>
              </tr>
            <tr>
              <td>
                   프로젝트 번호
                </td>
                <td>
                  <input type="text" id="start" name="pnum" size="20%">
           <input type="button" class="btn_pj" value ="내가 시작한 프로젝트"  onclick="pnum_search()">
               <input type="button" class="btn_pj" value ="내가 펀딩한 프로젝트"  onclick="pnum_search2()">
                  </td>
              </tr>
            <tr>
              <td>
                제목
                </td>
                <td>
                  <input type="text" id="csub" name="csub" size="80%"  /><br>
                  </td>
              </tr>
              <tr>

              <td>
                내용
                </td>
                <td>

                 <textarea name="ccon" id="ccon" rows="8" cols="40"  ></textarea>
                 <script>
                                 CKEDITOR.replace("ccon",  {
                                       filebrowserUploadUrl: '/upload',
                                     });
                             </script>
                  </td>
                </tr>
              </table>



      <div class = "write_section">
        <input type="button" value="등록" onclick="write1()">
        <input type="reset" value="취소">
        </div>
   </form>
</div>


   </article>

</body>
</html>
