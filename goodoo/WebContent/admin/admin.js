/**
 * 
 */

function go_search(){
	var theForm = document.frm;
	theForm.action = "NonageServlet?command=admin_product_list";
	theForm.submit();
}

function go_total(){
	document.frm.action = "NonageServlet?command=admin_product_list&key=&tpage=1";
	document.frm.submit();
}

function go_wrt(){
	document.frm.action = "NonageServlet?command=admin_product_add_form";
	document.frm.submit();
}

function sum(){
	document.getElementByName("price3").value = document.getElementByName("price2").value - document.getElementByName("price1").value;
}

function go_save(){
	var theForm = document.frm;
	if(theForm.kind.value == ''){
		alert('상품분류를 선택하시오.');
		theForm.kind.focus();
	}else if(theForm.name.value ==''){
		alert('상품명를 입력하세요.');
		theForm.name.focus();	
	}else if(theForm.price1.value == ''){
		alert('원가를 입력하세요.');
		theForm.price1.focus();
	}else if(theForm.price2.value == ''){
		alert('판매가를 입력하세요.');
		theForm.price2.focus();
	}else if(theForm.content.value == ''){
		alert('상품상세를 입력하세요.');
		theForm.content.focus();
	}else if(theForm.image.value == ''){
		alert('상품이미지를 입력하세요.');
		theForm.image.focus();
	}else{
		theForm.encoding = "multipart/form-data";
		theForm.action = "NonageServlet?command=admin_product_add";
		theForm.submit();
	}
}

function go_mov(){
	document.frm.action = 'NonageServlet?command=admin_product_list';
	document.frm.submit();
}

function go_list(tpage){
	var url = 'NonageServlet?command=admin_product_list&tpage=' + tpage; 
	document.frm.action = url;
	document.frm.submit();
}

function go_detail(tpage, pseq){
	var url = 'NonageServlet?command=admin_product_detail&tpage=' + tpage + '&pseq=' + pseq; 
	document.frm.action = url;
	document.frm.submit();
}

function go_modify(tpage, pseq){
	var url = 'NonageServlet?command=admin_product_update_form&tpage=' + tpage + '&pseq=' + pseq;
	document.frm.action = url;
	document.frm.submit();
}


function go_modify_save(tpage, pseq){
	var url = 'NonageServlet?command=admin_product_update&tpage=' + tpage + '&pseq=' + pseq;
	document.frm.encoding = "multipart/form-data";
	document.frm.action = url;
	document.frm.submit();
}

function go_name_search(){
	var url = 'NonageServlet?command=admin_order_list';
	document.frm.action = url;
	document.frm.submit();
}


function go_order_save(){
	var count = 0;
	if(document.frm.result.length == undefined){
		if(doucment.frm.result.checked == true){
			count++;
		}
	}else{
		for(var i = 0 ; i < document.frm.result.length; i++){
			if(document.frm.result[i].checked == true){
				count++;
			}
		}
	}
	
	if(count == 0){
		alert('주문처리할 항목을 선택해 주세요.');
	}else{
		document.frm.action = 'NonageServlet?command=admin_order_save';
		document.frm.submit();
	}
}


function go_member_search(){
	var url = 'NonageServlet?command=admin_member_list';
	document.frm.action = url;
	document.frm.submit();
}


function go_qna_detail(qseq){
	document.frm.qseq.value = qseq;
	document.frm.action = 'NonageServlet?command=admin_qna_detail';
	document.frm.submit();
}

function go_qna_update(qseq){
	document.frm.qseq.value = qseq;
	document.frm.action = 'NonageServlet?command=admin_qna_update';
	document.frm.submit();
}

function go_qna_list(){
	document.frm.action = 'NonageServlet?command=admin_qna_list';
	document.frm.submit();
}