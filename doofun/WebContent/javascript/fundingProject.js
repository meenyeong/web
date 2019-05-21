function only_funding() {
	var only = document.getElementById('only');
	var onlylabel = document.getElementById('onlylabel');
	var comment1 = document.getElementById('comment1');
	var go1 = document.getElementById('go1');
	only.style.width = '150px';
	only.style.padding = '5px';
	only.placeholder = '1000';
	only.value = '';
	only.style.backgroundColor = 'white';
	only.disabled = false;
	onlylabel.style.visibility = 'visible';
	onlylabel.style.fontSize = '15px';
	comment1.style.visibility = 'visible';
	go1.style.visibility = 'visible';

	var gift1 = document.getElementById('gift1');
	var gift1label = document.getElementById('gift1label');
	var comment2 = document.getElementById('comment2');
	var go2 = document.getElementById('go2');
	var gift1_price = document.getElementById('gift1_price').value;
	gift1.style.width = '500px';
	gift1.style.padding = '5px';
	gift1.placeholder = '';
	gift1.value = gift1_price + '원 이상 펀딩해주시는 분께';
	gift1.style.backgroundColor = 'transparent';
	gift1label.disabled = true;
	gift1label.style.visibility = 'hidden';
	comment2.style.visibility = 'hidden';
	go2.style.visibility = 'hidden';

	var gift2 = document.getElementById('gift2');
	var gift2label = document.getElementById('gift2label');
	var comment3 = document.getElementById('comment3');
	var go3 = document.getElementById('go3');
	var gift2_price = document.getElementById('gift2_price').value;
	gift2.style.width = '500px';
	gift2.style.padding = '5px';
	gift2.placeholder = '';
	gift2.value = gift2_price + '원 이상 펀딩해주시는 분께';
	gift2.style.backgroundColor = 'transparent';
	gift2label.disabled = true;
	gift2label.style.visibility = 'hidden';
	comment3.style.visibility = 'hidden';
	go3.style.visibility = 'hidden';

	var gift3 = document.getElementById('gift3');
	var gift3label = document.getElementById('gift3label');
	var comment4 = document.getElementById('comment4');
	var go4 = document.getElementById('go4');
	var gift3_price = document.getElementById('gift3_price').value;
	gift3.style.width = '500px';
	gift3.style.padding = '5px';
	gift3.placeholder = '';
	gift3.value = gift3_price + '원 이상 펀딩해주시는 분께';
	gift3.style.backgroundColor = 'transparent';
	gift3label.disabled = true;
	gift3label.style.visibility = 'hidden';
	comment4.style.visibility = 'hidden';
	go4.style.visibility = 'hidden';
}

function gift1_funding() {
	var gift1 = document.getElementById('gift1');
	var gift1label = document.getElementById('gift1label');
	var comment2 = document.getElementById('comment2');
	var go2 = document.getElementById('go2');
	var gift1_price = document.getElementById('gift1_price').value;
	gift1.style.width = '150px';
	gift1.style.padding = '5px';
	gift1.placeholder = gift1_price;
	gift1.value = '';
	gift1.style.backgroundColor = 'white';
	gift1.disabled = false;
	gift1label.style.visibility = 'visible';
	gift1label.style.fontSize = '15px';
	comment2.style.visibility = 'visible';
	go2.style.visibility = 'visible';

	var only = document.getElementById('only');
	var onlylabel = document.getElementById('onlylabel');
	var comment1 = document.getElementById('comment1');
	var go1 = document.getElementById('go1');
	only.style.width = '500px';
	only.style.padding = '5px';
	only.placeholder = '';
	only.value = '1000원 이상 펀딩합니다.';
	only.style.backgroundColor = 'transparent';
	only.disabled = true;
	onlylabel.style.visibility = 'hidden';
	comment1.style.visibility = 'hidden';
	go1.style.visibility = 'hidden';

	var gift2 = document.getElementById('gift2');
	var gift2label = document.getElementById('gift2label');
	var comment3 = document.getElementById('comment3');
	var go3 = document.getElementById('go3');
	var gift2_price = document.getElementById('gift2_price').value;
	gift2.style.width = '500px';
	gift2.style.padding = '5px';
	gift2.placeholder = '';
	gift2.value = gift2_price + '원 이상 펀딩해주시는 분께';
	gift2.style.backgroundColor = 'transparent';
	gift2label.disabled = true;
	gift2label.style.visibility = 'hidden';
	comment3.style.visibility = 'hidden';
	go3.style.visibility = 'hidden';

	var gift3 = document.getElementById('gift3');
	var gift3label = document.getElementById('gift3label');
	var comment4 = document.getElementById('comment4');
	var go4 = document.getElementById('go4');
	var gift3_price = document.getElementById('gift3_price').value;
	gift3.style.width = '500px';
	gift3.style.padding = '5px';
	gift3.placeholder = '';
	gift3.value = gift3_price + '원 이상 펀딩해주시는 분께';
	gift3.style.backgroundColor = 'transparent';
	gift3label.disabled = true;
	gift3label.style.visibility = 'hidden';
	comment4.style.visibility = 'hidden';
	go4.style.visibility = 'hidden';
}

function gift2_funding() {
	var gift2 = document.getElementById('gift2');
	var gift2label = document.getElementById('gift2label');
	var comment3 = document.getElementById('comment3');
	var go3 = document.getElementById('go3');
	var gift2_price = document.getElementById('gift2_price').value;
	gift2.style.width = '150px';
	gift2.style.padding = '5px';
	gift2.placeholder = gift2_price;
	gift2.value = '';
	gift2.style.backgroundColor = 'white';
	gift2.disabled = false;
	gift2label.style.visibility = 'visible';
	gift2label.style.fontSize = '15px';
	comment3.style.visibility = 'visible';
	go3.style.visibility = 'visible';

	var only = document.getElementById('only');
	var onlylabel = document.getElementById('onlylabel');
	var comment1 = document.getElementById('comment1');
	var go1 = document.getElementById('go1');
	only.style.width = '500px';
	only.style.padding = '5px';
	only.placeholder = '';
	only.value = '1000원 이상 펀딩합니다.';
	only.style.backgroundColor = 'transparent';
	only.disabled = true;
	onlylabel.style.visibility = 'hidden';
	comment1.style.visibility = 'hidden';
	go1.style.visibility = 'hidden';

	var gift1 = document.getElementById('gift1');
	var gift1label = document.getElementById('gift1label');
	var comment2 = document.getElementById('comment2');
	var go2 = document.getElementById('go2');
	var gift1_price = document.getElementById('gift1_price').value;
	gift1.style.width = '500px';
	gift1.style.padding = '5px';
	gift1.placeholder = '';
	gift1.value = gift1_price + '원 이상 펀딩해주시는 분께';
	gift1.style.backgroundColor = 'transparent';
	gift1label.disabled = true;
	gift1label.style.visibility = 'hidden';
	comment2.style.visibility = 'hidden';
	go2.style.visibility = 'hidden';

	var gift3 = document.getElementById('gift3');
	var gift3label = document.getElementById('gift3label');
	var comment4 = document.getElementById('comment4');
	var go4 = document.getElementById('go4');
	var gift3_price = document.getElementById('gift3_price').value;
	gift3.style.width = '500px';
	gift3.style.padding = '5px';
	gift3.placeholder = '';
	gift3.value = gift3_price + '원 이상 펀딩해주시는 분께';
	gift3.style.backgroundColor = 'transparent';
	gift3label.disabled = true;
	gift3label.style.visibility = 'hidden';
	comment4.style.visibility = 'hidden';
	go4.style.visibility = 'hidden';

}
function gift3_funding() {
	var gift3 = document.getElementById('gift3');
	var gift3label = document.getElementById('gift3label');
	var comment4 = document.getElementById('comment4');
	var go4 = document.getElementById('go4');
	var gift3_price = document.getElementById('gift3_price').value;
	gift3.style.width = '150px';
	gift3.style.padding = '5px';
	gift3.placeholder = gift3_price;
	gift3.value = '';
	gift3.style.backgroundColor = 'white';
	gift3.disabled = false;
	gift3label.style.visibility = 'visible';
	gift3label.style.fontSize = '15px';
	comment4.style.visibility = 'visible';
	go4.style.visibility = 'visible';

	var only = document.getElementById('only');
	var onlylabel = document.getElementById('onlylabel');
	var comment1 = document.getElementById('comment1');
	var go1 = document.getElementById('go1');
	only.style.width = '500px';
	only.style.padding = '5px';
	only.placeholder = '';
	only.value = '1000원 이상 펀딩합니다.';
	only.style.backgroundColor = 'transparent';
	only.disabled = true;
	onlylabel.style.visibility = 'hidden';
	comment1.style.visibility = 'hidden';
	go1.style.visibility = 'hidden';

	var gift1 = document.getElementById('gift1');
	var gift1label = document.getElementById('gift1label');
	var comment2 = document.getElementById('comment2');
	var go2 = document.getElementById('go2');
	var gift1_price = document.getElementById('gift1_price').value;
	gift1.style.width = '500px';
	gift1.style.padding = '5px';
	gift1.placeholder = '';
	gift1.value = gift1_price + '원 이상 펀딩해주시는 분께';
	gift1.style.backgroundColor = 'transparent';
	gift1label.disabled = true;
	gift1label.style.visibility = 'hidden';
	comment2.style.visibility = 'hidden';
	go2.style.visibility = 'hidden';

	var gift2 = document.getElementById('gift2');
	var gift2label = document.getElementById('gift2label');
	var comment3 = document.getElementById('comment3');
	var go3 = document.getElementById('go3');
	var gift2_price = document.getElementById('gift2_price').value;
	gift2.style.width = '500px';
	gift2.style.padding = '5px';
	gift2.placeholder = '';
	gift2.value = gift2_price + '원 이상 펀딩해주시는 분께';
	gift2.style.backgroundColor = 'transparent';
	gift2label.disabled = true;
	gift2label.style.visibility = 'hidden';
	comment3.style.visibility = 'hidden';
	go3.style.visibility = 'hidden';
}

function go_only() {
	var only = document.form.only.value;

	if(only == '' || only < '1000')	{
		document.getElementById('funded').value = '1000';
		document.getElementById('number').value = '0';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
	} else {
		document.getElementById('funded').value = only;
		document.getElementById('number').value = '0';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
	}
}

function go_gift1() {
	var gift1 = document.form.gift1.value;
	var gift_null = document.form.gift1_price.value;
	
	if(gift1 == '' || gift1 < gift_null){
		document.getElementById('funded').value = gift_null;
		document.getElementById('number').value = '1';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
		
	} else {
		document.getElementById('funded').value = gift1;
		document.getElementById('number').value = '1';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
	}
}

function go_gift2() {
	var gift2 = document.form.gift2.value;
	var gift_null = document.form.gift2_price.value;
	
	if(gift2 == '' || gift2 < gift_null){
		document.getElementById('funded').value = gift_null;
		document.getElementById('number').value = '2';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
		
	} else {
		document.getElementById('funded').value = gift2;
		document.getElementById('number').value = '2';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
	}
}

function go_gift3() {
	var gift3 = document.form.gift3.value;
	var gift_null = document.form.gift3_price.value;
	
	if(gift3 == '' || gift3 < gift_null){
		document.getElementById('funded').value = gift_null;
		document.getElementById('number').value = '3';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
		
	} else {
		document.getElementById('funded').value = gift3;
		document.getElementById('number').value = '3';
		document.form.action = "payment";
		document.form.method = "POST";
		document.form.submit();
	}
}

function pay_complete(){
	alert('펀딩 완료!');
	document.form.action = "pay_complete";
	document.form.method = "POST";
	document.form.submit();
}