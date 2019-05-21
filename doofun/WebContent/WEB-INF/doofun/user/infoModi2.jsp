<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
table.joinform{
 display: table; margin-left: auto; margin-right: auto;
 border-radius: 10px;
border: 1px solid lightgray;
/* border-collapse: collapse; */
    border-spacing: 1px;
 margin-top : 10px;
    margin-bottom: 10px;
    width:500px;
    
 }
 
.joinform td{
text-align: left;
border-bottom: 1px dashed lightgray;
padding: 10px 5px;

}
.joinform td:nth-child(1) {width:25%;  background:lightgray; }
.joinform td:nth-child(2) {width:55%;  }
.joinform td:nth-child(3) {width:20%; }

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

.layer1{
text-align: center;
padding-top: 100px;
}

</style>
<script>
function pwdmatch(){
//id 중복검사
var prename="${userSubmit.name}";	
	
if (document.getElementById("newname").value == prename) {
	document.getElementById("newnameok").value= prename;

} 


if (document.getElementById('tel1').value == "" || document.getElementById('tel2').value == "" || document.getElementById('tel3').value == ""){
	alert("연락처를 입력하세요.");
	return false;
}else if (document.getElementById('sample4_postcode').value == ""){
	alert("주소를 입력하세요.");
	return false;
}else if (document.getElementById('sample4_roadAddress').value == ""){
	alert("주소를 입력하세요.");
	return false;
}else if (document.getElementById('sample4_detailAddress').value == ""){
	alert("상세 주소를 입력하세요.");
	return false;
}
if (document.getElementById("newname").value == "") {document.getElementById("newname").value = "noname";}
//닉네임이 비어있으면 noname으로 지정

if (document.getElementById("newname").value == "noname") {alert("닉네임이 noname으로 설정됩니다.")}
//noname일때 통과
else if (document.getElementById("newname").value != "noname") { //1.새닉네임이 noname이 아니고
	if (document.getElementById("newnameok").value != document.getElementById("newname").value)
		//2. newname과 newnameok값이 같지 않을때....
{alert("닉네임 중복확인을 해주세요!"); return false;} }

//연락처 수정
var newtel =	document.getElementById("tel1").value +
"-" + document.getElementById("tel2").value +
"-" + document.getElementById("tel3").value ;

document.getElementById("tel").value = newtel;	


//pwd 매칭
	var prepwd = "${userSubmit.pw}";
	
	if (document.infoModi3.password.value == document.infoModi3.confirmpassword.value) {
		
		if( prepwd == document.infoModi3.password.value) {document.infoModi3.submit();}
		else {alert("비밀번호를 확인해주세요");}
	}
	 else {alert("비밀번호를 확인해주세요");}

	
}

function namematch(){
	var temp2=document.getElementById("newname").value;
//공백검사
	if (temp2[0] == " ") {alert("공백( )은 닉네임으로 사용하실 수 없습니다."); return false;}
	temp2=temp2.trim();
	if (temp2.length > 10) {alert("닉네임은 10글자를 초과하실수 없습니다."); return false;}
	
	else { var temp= "checkNick=" + temp2;
	
	window.open(temp, "nick check"); 
	}


}
//////////////////////////////////////////
window.onload=function(){
	
var temp23 = '${userinfo.tel}';
	
	var telArr = temp23.split("-");
	for (i=1; i<(telArr.length+1); i++){
	
		document.getElementById("tel" + i).value=telArr[(i-1)];
	}
	
}

</script>
<meta charset="UTF-8">
<script src="//cdn.ckeditor.com/4.11.2/basic/ckeditor.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="layer1">

<article><h1>모두펀딩: 회원정보 변경</h1>
		<h4>기본정보 확인</h4>

   <form name="infoModi3" action="infoModi3" method="post">
   <input type="hidden" name="id" value="${userSubmit.id}" />
	<table class ="joinform" >
		
		
		<tr><td>이메일 </td><td colspan="2">${userinfo.id}</td>
		
		<tr><td>비밀번호</td><td><input type="password" size="20" id="password" name="password"></td></tr>
		<tr><td >비밀번호 확인</td><td colspan="2"><input type="password" size="20" name="confirmpassword"></td></tr>
		<tr><td>연락처 </td>
				<td colspan="2"> <input type="text" id="tel1" size="3%" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
		-<input type="text" id="tel2" size="3%" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
		-<input type="text" id="tel3" size="3%" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"></td>
		
		</tr>
		<tr><td >주소입력</td>
			<td colspan="2">
				<input type="text" id="sample4_postcode" name="zip" value="${userinfo.zip}" style="padding:2px; margin-bottom:10px;">
				<input type="button" class="scan" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample4_roadAddress" name="address" size="40" placeholder="도로명주소" value="${userinfo.address}" style="padding:2px; margin-bottom:10px;"><br>
				<span id="guide" style="color:#999;display:none"></span>
				<input type="text" id="sample4_detailAddress" name="address2" size="40" placeholder="상세주소" value="${userinfo.address2}"  style="padding:2px; margin-bottom:10px;"><br>
				<a style="font-size:12px; color:red;">선물 전달을 위해 연락처 및 주소 입력은 필수입니다.</a>
				<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
				<script>
				    function sample4_execDaumPostcode() {
				        new daum.Postcode({
				            oncomplete: function(data) {
				                var roadAddr = data.roadAddress; // 도로명 주소 변수
				                var extraRoadAddr = ''; // 참고 항목 변수
				
				                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				                    extraRoadAddr += data.bname;
				                }
				                if(data.buildingName !== '' && data.apartment === 'Y'){
				                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				                }
				                if(extraRoadAddr !== ''){
				                    extraRoadAddr = ' (' + extraRoadAddr + ')';
				                }
				                document.getElementById('sample4_postcode').value = data.zonecode;
				                document.getElementById("sample4_roadAddress").value = roadAddr;
				                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
				                
				                if(roadAddr !== ''){
				                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
				                } else {
				                    document.getElementById("sample4_extraAddress").value = '';
				                }
				
				                var guideTextBox = document.getElementById("guide");
				                if(data.autoRoadAddress) {
				                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
				                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
				                    guideTextBox.style.display = 'block';
				
				                } else if(data.autoJibunAddress) {
				                    var expJibunAddr = data.autoJibunAddress;
				                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
				                    guideTextBox.style.display = 'block';
				                } else {
				                    guideTextBox.innerHTML = '';
				                    guideTextBox.style.display = 'none';
				                }
				            }
				        }).open();
				    }
				</script>
			</td></tr>
		</table>	
		
		<h4>선택정보 입력</h4> 
		<table class ="joinform">
				<tr><td>사용할 닉네임</td><td> <input type="text" id="newname" name="name" value="${userinfo.name}">
				<input type="button" id="namecheck" class ="scan" value="닉네임중복확인" onclick="namematch()"><br>
				<a style="font-size:12px; color:black;">닉네임은 최대 10글자까지 가능합니다. <br>미입력시, 기본값은 <b>"noname"</b>입니다.</a></td></tr>
		
		<tr><td>자기 소개 </td><td colspan="2"> <textarea 	name="intro" >${userinfo.intro}</textarea><script>
							CKEDITOR.replace('intro');
						</script></td></tr>
		</table> 
		<input type="hidden" id=newnameok
				value="true">
		<input type="hidden" id=tel
				name="tel" value="${userinfo.tel}">
		
		
		<input type="button" class ="scan" value="회원정보 수정" onclick="pwdmatch()">
        
        
 </form>
 </article>
  </div>

</body>
</html>
<%@ include file="/footer.jsp"%>