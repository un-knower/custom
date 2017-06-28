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
		<title>净水器-登录</title>
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
						<!--pic-ripple-bg-other-->
						<div class="xy-seat-01 xy-line-h0">
							<div class="xy-waveBox xy-line-h0">
								<div class="xy-wave" id="wave1"></div>
								<div class="xy-wave" id="wave2"></div>
								<div class="xy-wave" id="wave3"></div>
							</div>
							<div class="bg-blue-opacity xy-pad-lr10 xy-pad-b10">
								<div class="lovely-state xy-tac xy-line-h0">
									<img src="${_staticPath}/resource/weuiWeb/img/lovely-open-eye.png" />
								</div><!--/lovely state-->
								<form id="loginform" method="post" >
									<div class="weui-cells weui-cells_form  xy-login-form xy-layout-bar xy-login-form-seat">
										<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
											<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-tel.png" /></label></div>
											<div class="weui-cell__bd">
												<input id="mobile" class="weui-input xy-input-tel" name="mobile" type="number" maxLength="11" placeholder="请输入您的手机号">
											</div>
										</div>
										<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
											<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-pwd.png" /></label></div>
											<div class="weui-cell__bd">
												<input id="password" class="weui-input xy-input-pwd" name="password" type="password" placeholder="请输入密码">
											</div>
										</div>
										<div class="xy-mar-tb10 xy-mar-lr10">
											<!-- <a href="#" class="weui-btn weui-btn_primary bg-light-blue" id="login" type="button">登录</a> -->
											<button class="weui-btn weui-btn_primary bg-light-blue" id="login">登录</button>
										</div>
										<div class="bg-light-gray xy-clearfix">
											<a href="#" id="fpassword" class="xy-fc-black xy-fs14 xy-pad-tb7lr10 xy-fll">忘记密码？</a>
											<a href="#" id="register" class="xy-fc-black xy-fs14 xy-pad-tb7lr10 xy-flr">立即注册</a>
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
				//alert("宽:"+$(window).width()+";"+"高:"+$(window).height());
			
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
				/* $('input').blur(function(){
			        //var $parent=$(this).parent().parent();
			        //$parent.find('.formtips').remove();//清除之前的提醒消息
			        this.value=$.trim($(this).val());//去掉前后的空格
			        //验证手机号
			        if($(this).is('#mobile')){                      
			            if(this.value==''||(this.value!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test(this.value))){
			                //var errorMsg='请输入正确的手机号码';
			                //$parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			                alert('请输入正确的手机号码');
			            } else{
			                var okMsg='输入正确';
			                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
			            }   
			        }
			        //验证密码位数
			        if($(this).is('#password')){                      
			            if(this.value==''||this.value.length<6){
			            	alert('请输入6位或者以上的密码');
			                //var errorMsg='请输入6位或者以上的密码';
			                //$parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			            } else{
			                var okMsg='输入正确';
			                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
			            }   
			        }
		
			    }).keyup(function(){
			        $(this).triggerHandler("blur");
			    }).focus(function(){
			        $(this).triggerHandler("blur");
			    });
				}) */
				$('#login').click(function(){
					var mobile = $.trim($('#mobile').val()),password = $.trim($('#password').val());
					if(mobile ==''||(mobile!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test(mobile))){
			              $('#mobile').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
	            	}else if(password ==''||password.length<6){
					  $('#password').parents('.weui-cell').css('border','1px solid red').siblings().removeAttr("style");
		            }else{
			            //alert('3434555');
						$('form[id=loginform]').attr('action',_path+"/login/consumer/login");
						$('#loginform').submit();
					} 
				});	
				
				$('#fpassword').click(function(){
					window.location.href =_path+"/forget";
				})
				$('#register').click(function(){
					//alert('233');
					window.location.href =_path+"/register";
				})			 				
			});
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>