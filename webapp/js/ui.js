
//		The eLibrary main UI Javascript file

$(document).ready(function(){


	$('button').button().css({'margin': '2px'});
	$('#registerBtn').bind('click', function(){
		window.location="http://localhost:8080/eLibrary/registerUser.html";
	});
	
	// Login
	$('#topLogin input').focus(function(){
		$(this).css({'color': '#2D3A4B'});
		$(this).attr('value', '');
	});
	$('#topLogin input').focusout(function(){
		if($(this).val().length > 0){
			$('#topLogin #loginPassword').attr('type', 'password');
		}else{
			$(this).val('Username');
			$(this).css({'color': '#909090'});
			$('#topLogin #password').val('Password');
		};
	});
	$('#topLogin').hide();
	$('#showLoginBtn').button({icons: {primary: 'ui-icon-triangle-1-s'}}).click(function(){
		$('#topLogin').slideToggle();
	});
	$('#registerBtn').click(function(){
		window.location = "localhost:8080/eLibrary/registerUser.html";
	});
/*	$('#showLoginBtn, #topLogin').bind('mouseenter', function(){
		$('#showLoginBtn').css({'height': '34px'});
		$('#registerBtn').css({'height': '34px'});
	});
	$('#showLoginBtn, #registerBtn').bind('mouseleave', function(){
		$('#showLoginBtn').css({'height': '31px'});
		$('#registerBtn').css({'height': '31px'});
	});
*/	
	// Upload
	$('#uploadBtn').button({icons: {secondary: 'ui-icon-arrowthick-1-n'}});

	// Search
	$('#searchBtn').button({ icons: {primary: 'ui-icon-search'}});
	$('#search input').focus(function(){
		$(this).css({'color': '#2D3A4B'});
		$(this).attr('value', '');
	});
	$('#search input').focusout(function(){
		if($(this).val().length < 1){
			$(this).val('Search');
			$(this).css({'color': '#909090'});
		};
	});
	
	
	// Date Fields
	$('.dateField').datepicker();
	
	
	// Create XHR Object
	$('#userName').focusout(function(){
		if(XMLHttpRequest){
			xmlhttp = new XMLHttpRequest();
		}else{
			xmlhttp = ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open('GET', 'http://localhost:8080/eLibrary/ValidateUsername?userName=' + escape($(this).val()), true);
		xmlhttp.send();
		
		xmlhttp.onreadystatechange = function(){
			if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
				this.resp = xmlhttp.responseText;
				if(this.resp == 'true' || $("#userName").val().length < 1){
					$("#userName").css('border', 'solid 1px red');
					$("#userName").attr('valid', 'false');
					$("#userNameLbl").css('color', 'red');
					$('#registerUser button[type=submit]').attr('disabled', 'disabled');
				}
			}
		};
		
	});
	
	$("#userName").focus(function(){
		$(this).css({
			"border-radius": "2px",
			"border": "solid 1px #909090"
		});
		$("#userName").attr('valid', 'true');
		$("#userNameLbl").css('color', '#2D3A4B');
		if($('#email').val().length > 0 && $('#password').val().length > 0)
			$('#registerUser button[type=submit]').removeAttr('disabled');
		
	});

	$('#email').focusout(function(){
		if($(this).val().length < 1){
			$("#email").css('border', 'solid 1px red');
			$("#email").val('');
			$("#emailLbl").css('color', 'red');
			$('#registerUser button[type=submit]').attr('disabled', 'disabled');
		}
		
	});
	$("#email").focus(function(){
		$(this).css({
			"border-radius": "2px",
			"border": "solid 1px #909090"
		});
		$("#emailLbl").css('color', '#2D3A4B');
		if($('#userName').attr('valid') == 'true' && $('#password').val().length > 0)
			$('#registerUser button[type=submit]').removeAttr('disabled');
		
	});

	$('#password').focusout(function(){
		if($(this).val().length < 1){
			$("#password").css('border', 'solid 1px red');
			$("#password").val('');
			$("#passwordLbl").css('color', 'red');
			$('#registerUser button[type=submit]').attr('disabled', 'disabled');
		}
		
	});
	$("#password").focus(function(){
		$(this).css({
			"border-radius": "2px",
			"border": "solid 1px #909090"
		});
		$("#passwordLbl").css('color', '#2D3A4B');
		if($('#userName').attr('valid') == 'true' && $('#email').val().length > 0)
			$('#registerUser button[type=submit]').removeAttr('disabled');
		
	});

	
	// Text boxes
	$('input[type=text], input[type=password]').css({
		"border-radius": "2px",
		"border": "solid 1px #909090"
	});
	$('#registerUser button[type=submit]').attr('disabled', 'disabled');

});