<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

function pnum_search() {	document.mod3.pnum.focus();
window.open("choice","search" )
}

function pnum_search2() {	
	document.mod3.pnum.focus();
window.open("choice2","search" )

}

function mod1(){
	
	var subscan =document.getElementById('csub').value;
	
	if ( subscan == "" ) {
		alert("제목없이 글을 작성 할 수 없습니다!")
	}
	else if ( subscan.length > 24 ){
		alert ("제목은 24글자 까지 입니다.")
	}
	else {
		document.getElementById('csub').value = subscan.replace(/</gi,"&lt;");
			document.getElementById('mod3').submit(); }
}
</script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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


.write_section {
padding : 10px 10px;
text-align: center;
}

.btn_pj{
-moz-border-radius: 0 0 0 0 ;
	-webkit-border-radius: 0 0 0 0 ;	
	background-color: #4F6573;	
	color: white;
	font-weight:bold;
	font-size:15px;
}
#start{
float:left;
}
</style>
</head>
<body>
<div class = "write_section">
<h1>글 수정하기</h1>

펀딩선택은 필수 사항이 아닙니다. 현재 글 수정시, 닉네임 수정은 지원하지 않습니다.<br>
</div>
   <form action="mod3" name="mod3" id="mod3" method="post">
   
   
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
                  <input type="text" id="start" name="pnum"  size="20%" value="${boardVO.pnum}" >
           <input type="button" class="btn_pj" value ="내가 시작한 프로젝트"  onclick="pnum_search()">
               <input type="button" class="btn_pj" value ="내가 펀딩한 프로젝트"  onclick="pnum_search2()">
                  </td>
              </tr>
            <tr>
              <td>
                제목
                </td>
                <td>
                  <input type="text" name="csub" id="csub" value="${boardVO.csub}" size="75%"   /><br>
                  </td>
              </tr>
              <tr>

              <td>
                내용
                </td>
                <td>

                 <textarea name="ccon" id="ccon" rows="8" cols="50"  >${boardVO.ccon}</textarea>
                 <script>
                                 CKEDITOR.replace("ccon",  {
                                       filebrowserUploadUrl: '/upload',
                                     });
                             </script>
                  </td>
                </tr>
              </table>
   
      <input type="hidden" name="cseq" value="${boardVO.cseq}" />
      <input type="hidden" name="name" value="${userSubmit.name}" />   
         
           <div class = "write_section">
        <input type="button" value="수정 완료" onclick="mod1()">
        <input type="button" value="취소" onclick="history.go(-1)">
        </div>    
   </form>
</body>
</html>
<%@ include file="/footer.jsp"%>