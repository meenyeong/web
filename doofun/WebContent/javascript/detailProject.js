
function share(){
	document.getElementById('share_content').style.display='block';
	document.getElementById('fade').style.display='block';
}
function exit(){
	document.getElementById('share_content').style.display='none';
	document.getElementById('fade').style.display='none';
}
function go_funding(){
	document.form.action = "funding" + document.getElementById('pnum').value;
	document.form.method = "Post";
	document.form.submit();
}
function check_gift(){
	if (document.form.min_price1.value == '0') {
		document.getElementById('gift1detail').style.visibility = 'hidden';
	}
	if (document.form.min_price2.value == '0') {
		document.getElementById('gift2detail').style.visibility = 'hidden';
	}
	if (document.form.min_price3.value == '0') {
		document.getElementById('gift3detail').style.visibility = 'hidden';
	}
}

function modify(){
   document.getElementById('story1').style.visibility = 'hidden';
   document.getElementById('story2').style.visibility = 'visible';
}
function modify_cancel(){
   var pnum = document.getElementById('pnum').value;
   document.form.action = "project" + pnum;
   document.form.method = "Get";
   document.form.submit();
}

function like(){
   document.form.action = "projectLike" + document.getElementById('pnum').value;
   document.form.submit();
}

function go_mine(){
	document.form.action = "lookmine";
	document.form.submit();
}
function modify_story(){
   var contents = CKEDITOR.instances.contents.getData();
   var pnum = document.getElementById('pnum').value;
   
   if (contents == '') {
      alert('스토리텔링을 입력하세요.');
   } else if (contents < 10) {
      alert('10자 이상 입력하세요.');
   } else {
      alert("수정이 완료되었습니다.");
       document.getElementById('modify').value = contents;
      document.form.action = "modify_story" + pnum;
      document.form.method = "Get";
      document.form.submit(); 
   }
}