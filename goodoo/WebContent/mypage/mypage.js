function go_cart(){
	if(document.form.quantity.value == ""){
		alert("수량을 입력하여 주세요.");
		document.form.quantity.focus();
		
	}else{
		document.form.action="NonageServlet?command=cart_insert";
		document.form.submit();
	}
	
	
}


function go_cart_delete(){
	var count=0; //체크박스 갯수 세기위해 변수 만들어줌.
	//하나 체크했을 때
	if(document.form.cseq.length == undefined){
		if(document.form.cseq.checked == true){
			count++;
		}
	}
	//둘 이상 체크했을 때
	for( var i = 0; i<document.form.cseq.length; i++){
		if(document.form.cseq[i].checked == true){
			count++;
		}
	}
	
	//아무것도 체크 안했을 때
	if(count == 0){
		alert("삭제할 항목을 선택해 주세요");
	}else{
	document.form.action="NonageServlet?command=cart_delete";
	document.form.submit();
	}
	
}


function go_order_insert(){
	
	document.form.action="NonageServlet?command=order_insert";
	
	document.form.submit();
	}