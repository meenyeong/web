<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원가입창</title>
<script>
function email_check() {
	var dotPoint= 0;
	var atPoint = 0;
	
	
	if (document.frm23.email.value == "") {

		alert("사용할 이메일을 입력하세요");

		document.frm23.email.focus();}
	
	
	
	else {
		//문자열검사 .이랑 @
		var temp2=document.frm23.email.value;
		
		var i=0;

		while (i< temp2.length){
			if (temp2[i] == ".") dotPoint++;
			if (temp2[i] == "@") atPoint++;
			i++;
		}
		
		
		if ( (dotPoint == 1) && (atPoint == 1)  ) {var temp ="idcheck=" + document.frm23.email.value;
		/* alert(temp); */
		window.open(temp, "id check"); }
		else {alert("올바른 이메일이 아닙니다."); document.frm23.email.focus();}
		
		/* document.frm23.action = "idcheck=" + document.frm23.email.value;
		document.frm23.submit(); */	
	}	
}



function CheckPwd()
{
 var upw =document.getElementById('password').value;

 if(!/^[a-zA-Z0-9]{5,12}$/.test(upw) || upw.indexOf(' ') > -1) //이줄에 추가적인 조건을 넣었습니다.
 {
  alert('비밀번호는 숫자와 영문자 조합으로 5~12자리를 사용해야 합니다.');
 return false;
 }

 var chk_num = upw.search(/[0-9]/g);
 var chk_eng = upw.search(/[a-z]/ig);
 
 if(chk_num < 0 || chk_eng < 0)
 {
  alert('비밀번호는 숫자와 영문자를 혼용하여야 합니다.');
  return false;
 }
   
 else  if(/(\w)\1\1\1/.test(upw))
    {
        alert('비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.');  
    return false;
    }
 
 else if (document.frm23.password.value != document.frm23.confirmpassword.value) { //타입상관있을때 === ,없을때는 ==
		alert("비밀번호가 같지 않습니다. 비밀번호를 확인해주세요");
		}
 else {
	document.getElementById('bt_scan_pw').value = "완료(통과)"
	 return true;

 }
 
 
}

//
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
///
function join_check(){
	if (document.frm23.name.value == "") { alert("기본 닉네임 noname으로 가입됩니다.");
			document.frm23.name.value="noname";
	}
	
	else if (document.getElementById("newname").value != "noname") { //1.새닉네임이 noname이 아니고
		if (document.getElementById("newnameok").value != document.getElementById("newname").value)
			//2. newname과 newnameok값이 같지 않을때....
	{alert("닉네임 중복확인을 해주세요!(중복검사x)"); return false;} }
			
	
	var tel1=document.getElementById('tel1').value;
	var tel2=document.getElementById('tel2').value;
	var tel3=document.getElementById('tel3').value;
	var tel4=tel1 + "-" + tel2 + "-" + tel3;
	
	
	document.getElementById('tel').value = tel4 ;
	
	if (document.frm23.email.value == "") {
		alert("사용하실 이메일을 입력하세요!")
	}
	
	else if (document.frm23.password.value != document.frm23.confirmpassword.value) { //타입상관있을때 === ,없을때는 ==
	alert("비밀번호가 같지 않습니다. 비밀번호를 확인해주세요");
	}
	
	else if  (CheckPwd() == "false") { alert("비밀번호를 확인해주세요")}
	
	else if (tel1 == "" || tel2 == "" || tel3 == ""){
		alert("연락처를 입력하세요.");
		return false;
	}
	else if (document.frm23.sample4_postcode.value == ""){
		alert("주소를 입력하세요.");
		return false;
	}
	else if (document.frm23.sample4_roadAddress.value == ""){
		alert("주소를 입력하세요.");
		return false;
	}
	else if (document.frm23.sample4_detailAddress.value == ""){
		alert("상세 주소를 입력하세요.");
		return false;
	}
	
	else if (document.frm23.emailok.value == "false")
	{
		alert("이메일 중복 확인을 해주세요")
	}
	

	else 
	{
	document.getElementById('jform').submit();}
	}
///////////////////////////////	



</script>
<script src="//cdn.ckeditor.com/4.11.2/basic/ckeditor.js"></script>
<style>
.layer1{
text-align: center;
padding-top: 100px;
}

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

</style>
</head>

<body>

<article>
<div class="layer1">
	<h1>모두펀딩: 회원가입</h1>
	<form id="jform" name="frm23" action="joined" method="post">
	<input type="hidden" id="emailok" value="false"/>
		<h4>필수 정보 입력</h4>
		<table class ="joinform">
		

		<tr><td>이메일 </td><td colspan="2"><input type="text"  size="25" name="email" id="email" >
		&nbsp; <input type="button" id="emailcheck" class="scan" name="emailcheck" value="중복 확인하기" onclick="email_check()"><br>
		<a style="font-size:12px; color:black;">이메일로 "모두의 펀딩" 알림 정보를 받아보실수 있습니다.</a></td></tr>
		<tr><td>비밀번호</td><td><input type="password" size="20" id="password" name="password"><br>
		<a style="font-size:12px; color:black;">숫자와 영문자 조합으로 5~12자리</a></td></tr>
		<tr><td >비밀번호 확인</td><td colspan="2"><input type="password" size="20" name="confirmpassword">
			&nbsp;<input type="button" class="scan" id="bt_scan_pw" value="비밀번호 검사" onclick="CheckPwd()"></td></tr>
		<tr><td>연락처 </td>
		<td colspan="2"> <input type="text" id="tel1" size="3%" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
		-<input type="text" id="tel2" size="3%" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
		-<input type="text" id="tel3" size="3%" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"></td>
		</tr>
		<tr><td >주소입력</td>
			<td colspan="2">
				<input type="text" id="sample4_postcode" name="zip" placeholder="우편번호" style="padding:2px; margin-bottom:10px;">
				<input type="button" class="scan" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample4_roadAddress" name="address" size="40" placeholder="도로명주소" style="padding:2px; margin-bottom:10px;"><br>
				<span id="guide" style="color:#999;display:none"></span>
				<input type="text" id="sample4_detailAddress" name="address2" size="40" placeholder="상세주소" style="padding:2px; margin-bottom:10px;"><br>
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
		<br>
				<h4>선택정보 입력</h4> 
		<table class ="joinform">
				<tr><td>사용할 닉네임</td>
				<td colspan="2"><input type="text" id="newname" name="name"	>&nbsp;&nbsp;<input type="button" id="namecheck" class ="scan" value="닉네임중복확인" onclick="namematch()"><br>
					<a style="font-size:12px; color:black;">닉네임은 최대 10글자까지 가능합니다. <br>미입력시, 기본값은 <b>"noname"</b>입니다.</a></td></tr>
		
		<tr><td>자기 소개 </td><td colspan="2"> <textarea 	name="intro" ></textarea><script>
							CKEDITOR.replace('intro');
						</script></td></tr>
		</table> 
		<input type="hidden" id="tel" name="tel" value="0">
		<input type="hidden" id=newnameok	value="true">
		 <input type="button" value="가입 하기" class="scan" onclick="join_check()">

	</form>
	</div>
	
</article>
</body>
</html>
<%@ include file="/footer.jsp"%>