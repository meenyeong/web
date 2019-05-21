function preview() {
	var frm = document.form;
	var subject = frm.subject.value;
	var pjimg = frm.pjimg.value;
	var plimg = frm.plimg.value;
	var plname = frm.plname.value;
	var plinfo = frm.plinfo.value;
	var goal = frm.goal.value;
	var date_fin = frm.date_fin.value;
	var contents = CKEDITOR.instances.contents.getData();

	frm.view_btn.style.visibility = 'hidden';
	document.getElementById('preview').style.visibility = 'visible';

	if(subject == ""){
		document.getElementById('input_subject').innerHTML = '제목을 입력하세요.';
		document.getElementById('input_subject').style.color = 'DarkGray';
	}else if(subject != ""){
		document.getElementById('input_subject').innerHTML = subject;
		document.getElementById('input_subject').style.color = '#022528';
	}
	
	if(plname == ""){
		document.getElementById('input_planner').innerHTML = 
			'<img src="images/profile.png" alt="profile">&nbsp;<span style="vertical-align: 10px;">창작자 성함을 입력하세요.</span>';
		document.getElementById('input_planner').style = ""
		document.getElementById('input_planner').style.color = 'DarkGray';
		document.getElementById('input_planner').style.fontSize = '15px';
	}
	else if(plname != ""){
		document.getElementById('input_planner').innerHTML = '<img src="images/profile.png" alt="profile">' + plname;
		document.getElementById('input_planner').style.fontWeight = 'bolder';
		document.getElementById('input_planner').style.color = 'black';
		document.getElementById('input_planner').style.fontSize = '15px';
	}
	
	if(plinfo == ""){
		document.getElementById('input_plinfo').innerHTML = '창작자 소개를 입력하세요.';
		document.getElementById('input_plinfo').style.color = 'DarkGray';
		document.getElementById('input_planner').style.fontSize = '12px';
	}else if(plinfo != ""){
		document.getElementById('input_plinfo').innerHTML = plinfo;
		document.getElementById('input_plinfo').style.color = 'DarkGray';
		document.getElementById('input_planner').style.fontSize = '12px';
	}

	if(goal != ""){
		document.getElementById('value1').innerHTML = goal + "원";
	}
	
	if(date_fin == ""){
		document.getElementById('input_fin').innerHTML = '(마감일을 설정하세요)';
		document.getElementById('input_fin').style.color = 'DarkGray';
		document.getElementById('input_fin').style.fontSize = '11px';
	} else if (date_fin != "") {

		var a = document.form.pj_fin.value;
		var year = Number(a.substring(0, 4));
		var month = Number(a.substring(4, 6));
		var day = Number(a.substring(6, 8));

		var toDay = new Date();
		var dDay = new Date(year, month - 1, day);

		var n = Math.floor((dDay.getTime() - toDay.getTime()) / 86400000) + 1;

		document.getElementById('input_dday').innerHTML = n + "일";
		document.getElementById('input_fin').innerHTML = "(" + date_fin + ")";
		document.getElementById('input_fin').style.color = 'gray';
		document.getElementById('input_fin').style.fontSize = '15px';

	}

	if(contents == ""){
		document.getElementById('input_contents').innerHTML = '스토리보드를 작성하세요';
		document.getElementById('input_contents').style.color = 'DarkGray';
	}else if(contents != ""){
		document.getElementById('input_contents').innerHTML = contents;
		document.getElementById('input_contents').style.color = 'Black';
	}
	  
}
