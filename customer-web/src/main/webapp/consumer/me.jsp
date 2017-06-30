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
		<title>净水器-个人中心</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">我的</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b10 xy-scrollY">
				<div class="xy-pad-lr10 xy-pad-t10 xy-border-box xy-list-top-bar">
					<ul>
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar bg-blue-01 xy-border-box">
							<div class="weui-cell weui-cell_access">
								<div class="weui-cell__bd xy-clearfix">
									<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG xy-fll"><img /></p>
									<!--<p class="xy-flr xy-code xy-full-widthIMG xy-pad-t5"><img src="img/pic-code.png" /></p>-->
									<div class="xy-db xy-mar-l85p xy-mar-r60p xy-fc-white">
										<ol class="xy-pad-t8 xy-fs16" id="name">
											蒙奇浩浩
										</ol>
										<ol class="xy-pad-t3 xy-fs14" flex="dir:left">
											<dt>手机号码：</dt>
											<dd flex-box="1" id="mobile">18820998887</dd>
										</ol>
									</div>
								</div>
							</div><!--信息模块-->
								
							<div class="xy-waveBox xy-line-h0">
								<div class="xy-wave" id="wave1"></div>
								<div class="xy-wave" id="wave2"></div>
								<div class="xy-wave" id="wave3"></div>
							</div>
							<div class="main-img-device xy-fs14 bg-blue-opacity xy-clearfix xy-pad-t7 xy-pad-b7" flex="main:center cross:center">
								<ul class="width100 xy-border-box xy-pad-lr10" id="deviceUl">
									<li>
										<p>设备总数</p>
										<p id="totalDevice">120个</p>
									</li>
									<li>
										<a href="#" class="xy-db xy-fc-black">
											<p>我的设备</p>
											<p id="mineDevice">120个</p>
										</a>
									</li>
									<li>
										<p>关注设备</p>
										<p id="attentDevice">12个</p>
									</li>
								</ul>
							</div>
						</li><!--列表-->
						
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar xy-border-box">
							<div class="weui-cells xy-mar-t0 xy-fs16 link-icon-listview">
								<a class="weui-cell weui-cell_access" href="#" id="message">
									<div class="weui-cell__hd xy-pore">
										<img src="${_staticPath}/resource/weuiWeb/img/icon-list-message.png">
										<i class="xy-poab icon-new-message">&nbsp;</i>
										<!-- <script type="text/javascript">
											var a = 1;
											if(a == 1){
												return '<i class="xy-poab icon-new-message">&nbsp;</i>'
											}											
										</script> -->
									</div>
									<div class="weui-cell__bd">
										<p>消息</p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
								<a class="weui-cell weui-cell_access" href="#" id="attent">
									<div class="weui-cell__hd"><img src="${_staticPath}/resource/weuiWeb/img/icon-list-device.png"></div>
									<div class="weui-cell__bd">
										<p>关注设备</p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
								<a class="weui-cell weui-cell_access" href="javascript:;">
									<div class="weui-cell__hd"><img src="${_staticPath}/resource/weuiWeb/img/icon-list-about.png"></div>
									<div class="weui-cell__bd">
										<p>关于清渟科技</p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
							</div>
						</li><!--列表-->
						
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar xy-border-box">
							<div class="weui-cells xy-mar-t0 xy-fs16 link-icon-listview">
								<a class="weui-cell weui-cell_access" href="#" id="setNewPassword">
									<div class="weui-cell__hd"><img src="${_staticPath}/resource/weuiWeb/img/icon-list-graylock.png"></div>
									<div class="weui-cell__bd">
										<p>修改密码</p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
								<a class="weui-cell weui-cell_access" href="javascript:;" id="exit">
									<div class="weui-cell__hd"><img src="${_staticPath}/resource/weuiWeb/img/icon-list-exit.png"></div>
									<div class="weui-cell__bd">
										<p>退出</p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
							</div>
						</li><!--列表-->
					</ul><!--ul 列表-->
				</div>
			</div>
			<!--/ container -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
			}
			function bindEvent(){
				$('#message').click(function(){
					window.location.href =_path+"/consumer/news.jsp";
				});
				$('#attent').click(function(){
					//alert('3344');
					window.location.href =_path+"/consumer/device-follow.jsp";
				});
				$('#setNewPassword').click(function(){
					window.location.href =_path+"/consumer/forget.jsp";
				});
				$('#deviceUl li:eq(1)').click(function(){
					window.location.href =_path+"/consumer/project.jsp";
				});
				$('#deviceUl li:eq(2)').click(function(){
					//sessionStorage.setItem('number',2);
					window.location.href =_path+"/consumer/project.jsp?number=2";
				});
				$('#exit').click(function(){
					//退出
					$.ajax({
						type:'get',
						//url:_path+'/logout',
						url:'http://192.168.10.201:8086/customer-web/logout',
						success : function(msg){
							console.log(msg);
							if(msg){
								
								}						
							}
					});
				});
			}
			$(function(){
				bindEvent();
				//评价多选
				/* $('.select-menubar__item').on('click', function () {
					$(this).toggleClass('select-menubar__item_on').siblings().removeClass('select-menubar__item_on');
				}); */
				//获取用户信息
				$.ajax({
					type:'get',
					url:_path+'/consumer/user/get',
					success : function(msg){
						console.log(msg);
						if(msg){
							$('.xy-full-widthIMG img').attr('src','${_staticPath}'+msg.data.path);
							$('#name').html(msg.data.name);
							//$('#mobile').html(data.name);
							$('#totalDevice').html(msg.data.attentEquip+msg.data.mineEquip+'个');
							$('#mineDevice').html(msg.data.mineEquip+'个');
							$('#attentDevice').html(msg.data.attentEquip+'个');
							}						
						}
				});
			});
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>