
/*아이템 리스트에 등록하기(3개까지)*/
function gift_upload() {
	var price = document.form.min_price.value;
	var name = document.form.gift_name.value;
	var frm = document.form;
	frm.min_pricenull.value = '';
	frm.gift_namenull.value = '';
	document.getElementById('gift1_text').style.visibility = 'visible';
	
	if (frm.min_price.value == '') {
		frm.min_pricenull.value = '최소금액을 입력하세요';
	}
	if(frm.gift_name.value == ''){
		frm.gift_namenull.value = '선물이름을 입력하세요';
	}
	
	if (frm.min_price.value != ''	&& frm.gift_name.value != '') {
		if(frm.giftlist1_price.value == ''){
			frm.giftlist1_price.value = price;
			frm.giftlist1_name.value = name;
			frm.giftdel1.style.visibility = 'visible';
			frm.min_price.value = '';
			frm.gift_name.value = '';
			document.getElementById('gift1').style.visibility = 'visible';
			document.getElementById('gift1_text').style.visibility = 'visible';

			document.getElementById('giftlist1_price').style.visibility = 'visible';
			document.getElementById('giftlist1_name').style.visibility = 'visible';
			document.getElementById('gift1').style.visibility = 'visible';
			document.getElementById('gift1').style.color = 'Black';
			document.getElementById('input_gift1_price').innerHTML = price + " 원+";
			document.getElementById('input_gift1_price').style.fontWeight = 'bolder';
			document.getElementById('input_gift1_price').style.fontSize ='30px';
			document.getElementById('input_gift1_name').innerHTML = name + "( X 1 )";
			document.getElementById('input_gift1_name').style.fontSize ='15px';
		}
	}
	
	if (frm.min_price.value != ''	&& frm.gift_name.value != '') {
		if(frm.giftlist1_price.value != '' && frm.giftlist2_price.value == ''){
			frm.giftlist2_price.value = price;
			frm.giftlist2_name.value = name;
			frm.giftdel2.style.visibility = 'visible';
			frm.min_price.value = '';
			frm.gift_name.value = '';
			document.getElementById('gift2').style.visibility = 'visible';
			document.getElementById('gift2_text').style.visibility = 'visible';

			document.getElementById('giftlist2_price').style.visibility = 'visible';
			document.getElementById('giftlist2_name').style.visibility = 'visible';
			document.getElementById('gift2').style.visibility = 'visible';
			document.getElementById('gift2').style.color = 'Black';
			document.getElementById('input_gift2_price').innerHTML = price + " 원+";
			document.getElementById('input_gift2_price').style.fontWeight = 'bolder';
			document.getElementById('input_gift2_price').style.fontSize ='30px';
			document.getElementById('input_gift2_name').innerHTML = name + "( X 1 )";
			document.getElementById('input_gift2_name').style.fontSize ='15px';
		}
	}
	
	if (frm.min_price.value != '' && frm.gift_name.value != '') {
		if(frm.giftlist1_price.value != '' && frm.giftlist2_price.value != '' && frm.giftlist3_price.value == ''){
			frm.giftlist3_price.value = price;
			frm.giftlist3_name.value = name;
			frm.giftdel3.style.visibility = 'visible';
			frm.min_price.value = '';
			frm.gift_name.value = '';
			document.getElementById('gift3').style.visibility = 'visible';
			document.getElementById('gift3_text').style.visibility = 'visible';

			document.getElementById('giftlist3_price').style.visibility = 'visible';
			document.getElementById('giftlist3_name').style.visibility = 'visible';
			document.getElementById('gift3').style.visibility = 'visible';
			document.getElementById('gift3').style.color = 'Black';
			document.getElementById('input_gift3_price').innerHTML = price + " 원+";
			document.getElementById('input_gift3_price').style.fontWeight = 'bolder';
			document.getElementById('input_gift3_price').style.fontSize ='30px';
			document.getElementById('input_gift3_name').innerHTML = name + "( X 1 )";
			document.getElementById('input_gift3_name').style.fontSize ='15px';
		}
	}
	
	if(frm.giftlist1_price.value != '' && frm.giftlist2_price.value != '' && frm.giftlist3_price.value != ''){
		document.getElementById('giftupload').disabled=true;
		document.getElementById('giftupload').style.backgroundColor='gray';
	}
	

}

/*아이템 리스트에서 삭제*/
function delgift1(){
	var frm = document.form;
	frm.giftlist1_price.value = '';
	frm.giftlist1_name.value = '';
	frm.giftdel1.style.visibility = 'hidden';
	document.getElementById('giftupload').disabled=false;
	document.getElementById('giftupload').style.backgroundColor='Maroon';	
	document.getElementById('gift1').style.visibility = 'hidden';
	
}
function delgift2(){
	var frm = document.form;
	frm.giftlist2_price.value = '';
	frm.giftlist2_name.style.visibility = 'hidden';
	document.getElementById('giftupload').disabled=false;
	document.getElementById('giftupload').style.backgroundColor='Maroon';	
	document.getElementById('gift2').style.visibility = 'hidden';
}
function delgift3(){
	var frm = document.form;
	frm.giftlist3_price.value = '';
	frm.giftlist3_name.style.visibility = 'hidden';
	document.getElementById('giftupload').disabled=false;
	document.getElementById('giftupload').style.backgroundColor='Maroon';
	document.getElementById('gift3').style.visibility = 'hidden';
}

function save(){
	var frm = document.form;
	
	if(frm.subject.value == ''){
		frm.subjectnull.value = '프로젝트 제목을 입력하세요.';
		document.form.tab1.checked = true;
	} else if (frm.subject.value.length < 5){
		frm.subjectnull.value = '5자 이상으로 입력해주세요.';
		document.form.tab1.checked = true;
	} else {
		frm.subjectnull.value = '';
	}
	
	if(frm.pjimg.value == ''){
		frm.pjimgnull.value = '프로젝트 이미지를 등록하세요.';
		document.form.tab1.checked = true;
	}else {
		frm.pjimgnull.value = '';
	}

	if(frm.plimg.value == ''){
		frm.plimgnull.value = '진행자 이미지를 등록하세요.';
		document.form.tab1.checked = true;
	} else {
		frm.plimgnull.value = '';
	}

	if (frm.plname.value == '') {
		frm.plnamenull.value = '진행자 이름을 입력하세요.';
		document.form.tab1.checked = true;
	} else if (frm.plname.value.length < 2){
		frm.plnamenull.value = '1자 이상으로 입력해주세요.';
		document.form.tab1.checked = true;
	} else {
		frm.plnamenull.value = '';
	}

	if (frm.plinfo.value == '') {
		frm.plinfonull.value = '진행자 정보를 입력하세요.';
		document.form.tab1.checked = true;
	} else if (frm.plinfo.value.length < 10){
		frm.plinfonull.value = '10자 이상으로 입력해주세요.';
		document.form.tab1.checked = true;
	}  else {
		frm.plinfonull.value = '';
	}

	if (frm.goal.value == '') {
		frm.goalnull.value = '금액을 입력하세요.';
		document.form.tab1.checked = true;
	} else if (frm.goal.value < 100000){
		frm.goalnull.value = '100000원 이상으로 입력해주세요.';
		document.form.tab1.checked = true;
	}  else {
		frm.goalnull.value = '';
	}
	
		 var after = new Date(Date.parse(new Date()) + 1000 * 3600 * 24 * 7);
		 var fin = frm.date_fin.value;
		 var nowYear = String(after.getFullYear()),
		 	 nowMonth = String(after.getMonth() + 1), // getMonth == 현재날짜 - 1
         	 nowDate = String(after.getDate());
		 
		 if( nowMonth.length == 1 ) nowMonth = "0"+nowMonth;
		 if( nowDate.length == 1 ) nowDate = "0"+nowDate; 
		 
		 var today = Number(nowYear + nowMonth + nowDate);
		 var dif = fin - today;
		
	if (frm.date_fin.value == '') {
		frm.date_finnull.value = '마감일을 설정하세요.';
		document.form.tab1.checked = true;
		
	} else if (dif < 0){
		frm.date_finnull.value = '일주일 후부터 설정 가능합니다.';
	}else {
		frm.date_finnull.value = '';
	} 

	if (frm.giftlist1_price.value == '' && frm.giftlist2_price.value == '' && frm.giftlist3_price.value == '') {
		frm.gift_listnull.value = '아이템을 1개 이상 등록하세요.';
		document.form.tab2.checked = true;
	} else {
		frm.gift_listnull.value = '';
	}
	
	var contents = CKEDITOR.instances.contents.getData();
	if (contents == '') {
		frm.contents_null.value = '스토리텔링을 입력하세요.';
		document.form.tab2.checked = true;
	} else if (contents < 10) {
		frm.contents_null.value = '10자 이상 입력하세요.';
		document.form.tab2.checked = true;
	} else{
		frm.contents_null.value = '';
	}
	
	
	if(frm.subjectnull.value == '' && frm.pjimgnull.value == '' && frm.plimgnull.value == '' && frm.plnamenull.value == '' &&
		frm.plinfonull.value == '' && frm.goalnull.value == '' && frm.date_finnull.value == '' &&
		frm.gift_listnull.value == '' && frm.contents_null.value == ''){
		
		if(frm.giftlist1_price.value == ''){
			frm.giftlist1_price.value = '0';
			frm.giftlist1_name.value = '.';
		}
		if(frm.giftlist2_price.value == ''){
			frm.giftlist2_price.value = '0';
			frm.giftlist2_name.value = '.';
		}
		if(frm.giftlist3_price.value == ''){
			frm.giftlist3_price.value = '0';
			frm.giftlist3_name.value = '.';
		}
		
		document.form.action = "newProject";
		document.form.method = "Post";
		document.form.submit();
		alert("프로젝트 검토 요청이 완료되었습니다.");
	}
	


}