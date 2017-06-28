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
		<title>净水器-注册</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
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
									<span class="logo-lovely" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/logo-lovely.png" /></span>
								</p>
								<p class="logo-text xy-pad-t10 xy-tac"><img src="${_staticPath}/resource/weuiWeb/img/logo-text.png" /></p>
							</div>
						</div>
					
						<div class="xy-seat-01">
							<div class="xy-waveBox xy-line-h0">
								<div class="xy-wave" id="wave1"></div>
								<div class="xy-wave" id="wave2"></div>
								<div class="xy-wave" id="wave3"></div>
							</div>
							<div class="bg-blue-opacity xy-pad-lr10 xy-pad-b10">
								<div class="lovely-state xy-tac xy-line-h0">
									<img src="${_staticPath}/resource/weuiWeb/img/lovely-open-eye.png" />
								</div><!--/lovely state-->
								<form method="post" id="register-form">
									<div class="weui-cells weui-cells_form xy-login-form xy-layout-bar xy-login-form-seat">
										<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
											<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-tel.png" /></label></div>
											<div class="weui-cell__bd">
												<input class="weui-input xy-input-tel" type="number" placeholder="请输入您的手机号" name="mobile" id="mobile">
											</div>
										</div>
										<div class="weui-cell weui-cell_vcode xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
											<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-code.png" /></label></div>
											<div class="weui-cell__bd">
												<input class="weui-input xy-input-code" type="number" placeholder="请输入验证码" name="validateCode" id="validateCode">
											</div>
											<div class="weui-cell__ft">
												<button class="weui-vcode-btn">获取验证码</button>
											</div>
										</div>
										<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
											<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-pwd.png" /></label></div>
											<div class="weui-cell__bd">
												<input class="weui-input xy-input-pwd" type="password" placeholder="请输入密码" name="password" id="password">
											</div>
										</div>
										<div class="xy-mar-tb10 xy-mar-lr10">
											<a href="#" class="weui-btn weui-btn_primary bg-light-blue" id="register">注册</a>
										</div>
										<div class="bg-light-gray xy-clearfix">
											<a href="#" class="xy-fc-black xy-fs14 xy-pad-tb7lr10 xy-flr" id="toLogin">立即登录</a>
										</div>
									</div>
								</form>
							</div>
						</div><!--/bottom-->
					</div><!--内容-->
				</div>
			</div>
			<!--/ container -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
				$('.xy-login-form .weui-input').focus(function(){//输入框 获取焦点 蜻蜓睁眼闭眼动作
					$(this).parents('.weui-cell').css('border','1px solid #509ffc').siblings().removeAttr("style");
					if($(this).is('.xy-input-pwd')){
						$('.lovely-state img').attr('src','${_staticPath}/resource/weuiWeb/img/lovely-close-eye.png');
					}else{
						$('.lovely-state img').attr('src','${_staticPath}/resource/weuiWeb/img/lovely-open-eye.png');
					}
				})
			}
			$(function(){
				$('.weui-vcode-btn').click(function(){
					var mobile = $.trim($('#mobile').val());
					if(mobile ==''||(mobile!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test(mobile))){
		              //$('#mobile').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
		              alert('请输入正确的手机号');
		              return
	            	}else{
	            		settime($(this));
						$.ajax({
							type:'get',
							url:_path+'/validate/getValidateCode'+'?'+'mobile='+mobile,
							success : function(msg){
								if(msg) alert('验证码已成功发送至您手机！')								
							}
						}); 
	            	}
	            	var time=60;
					function settime(obj){			
						if(time == 0){
							obj.attr('disabled',false);
							obj.html("获取验证码");
							time = 60;
							return
						}else{
							obj.attr('disabled',true);
							obj.html('重新发送'+time);
							time--;
						}
						setTimeout(function(){					
							settime(obj);},1000)
						
					}
				}); 
				 $('#register').click(function(){
					var mobile = $.trim($('#mobile').val()),validateCode = $.trim($('#validateCode').val()),
						password = $.trim($('#password').val());
				    if(password ==''||password.length<6){
					  $('#password').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
		            }else if(validateCode ==''||validateCode.length<4){
		              $('#validateCode').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
		            }else{
			            //alert('3434555');
						$('form[id=register-form]').attr('action',_path+"/register/submit");
						$('#register-form').submit(); 
					} 
				}); 
				$('#toLogin').click(function(){
					window.location.href =_path+"/login/consumer";
				})
			})
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>