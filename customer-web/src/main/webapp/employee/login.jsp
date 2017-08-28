<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="">
		<meta http-equiv="X-UA-Compatible" content="chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
		<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<title>服务-登录</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-flex.css" /> 
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-css.css"/> 
		<%-- <link rel="stylesheet" type="text/css" href="${_path}/css/employee/xy-css.css" />  --%>
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="page__bd xy-container xy-container-t0b0">
				<div class="xy-border-box height100">
					<div class="xy-layout bg-blue-01" flex="dir:top main:justify">
						<div class="xy-logo-bar" flex-box="1" flex="main:center cross:center">
							<div>
								<p flex="main:center cross:center">
									<span class="logo-lovely" flex="main:center cross:center"><img src="${_staticPath}/resource/employee/img/logo-lovely.png" /></span>
								</p>
								<p class="logo-text xy-pad-t10 xy-tac"><img src="${_staticPath}/resource/employee/img/logo-text.png" /></p>
							</div>
						</div>
						<!--pic-ripple-bg-other-->
						<div class="xy-line-h0 height60">
							<div class="xy-waveBox xy-line-h0">
								<div class="xy-wave" id="wave1"></div>
								<div class="xy-wave" id="wave2"></div>
								<div class="xy-wave" id="wave3"></div>
							</div>
							<div class="xy-pad-lr10 xy-pad-b10 height100 bgBlueWhite">
								<div class="weui-cells weui-cells_form xy-login-form xy-mar-t0 bgTransparent">
									<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
										<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/employee/img/form-tel.png" /></label></div>
										<div class="weui-cell__bd">
											<input class="weui-input xy-input-tel" type="number" maxLength="11" placeholder="手机号" id="mobile">
										</div>
									</div>
									<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
										<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/employee/img/form-pwd.png" /></label></div>
										<div class="weui-cell__bd">
											<input class="weui-input xy-input-pwd" type="password" placeholder="密码" id="password">
										</div>
										<div class="weui-cell__ft"><botton class="weui-vcode-btn">忘记密码</botton></div>
									</div>
									<div class="xy-mar-tb10 xy-mar-lr10">
										<a href="#" class="weui-btn weui-btn_primary bg-blue boxShadow" id="login">登&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp录</a>
									</div>
									<div class=" xy-clearfix xy-tac xy-fc-gray xy-mar-t20">
										<a href="#" class="xy-fc-gray xy-fs14 xy-pad-tb7lr10">专业   诚信   持续   主动</a>
										<a href="#" class="xy-fc-gray xy-fs14 xy-pad-tb7lr10">专注   合作   发展    分享 </a>
									</div>
								</div>
							</div>
						</div><!--/bottom-->
					</div><!--内容-->
				</div>
			</div>
			<!--/ container -->
			
		</div>
		<script type="text/javascript" src="${_staticPath}/resource/employee/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" class="js_show">	
			$('#login').click(function(){
				var mobile = $.trim($('#mobile').val()),password = $.trim($('#password').val());
				if(mobile ==''||(mobile!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test(mobile))){
		              $('#mobile').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
            	}else if(password ==''||password.length<6){
				  $('#password').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
	            }else{
					//$('form[id=loginform]').attr('action',_path+"/login/consumer/login");
					//$('#loginform').submit();
				$.ajax({
						type:'POST',
						url:_path+"/login/consumerLoginByAjax",
						data:{
							"mobile":mobile,
							"password":password
						},
						success : function(r){								
							if(r.success){//跳转到引导页
								window.location.href =_path+"/employee/bind.jsp";
							}else{
								alert(r.message);
							}
						}
					}); 
				} 
			});	
			
			$('#fpassword').click(function(){
				window.location.href =_path+"/forget";
			})	
		</script>

	</body>
</html>