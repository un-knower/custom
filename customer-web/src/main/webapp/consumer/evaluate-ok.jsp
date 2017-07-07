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
		<title>净水器-监测数据</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="page__bd xy-container xy-container-b10">
				<div class="xy-pad-10 xy-border-box height100">
					<div class="xy-layout xy-layout-bar bg-blue-01" flex="dir:top">
						<div class="full-layout-box" flex-box="1" flex="main:center cross:center">
							<div>
								<div class="my-msg  xy-pad-lr10 xy-mar-t20" flex="main:center cross:center">
									<div class="xy-fc-white xy-fs14">
										<p>您好！主人。</p>
										<p>清亭小管家监测数据提示</p>
										<p>您的饮水安全质量<span class="xy-fs15 xy-fwb xy-dibVat">棒棒哒！</span></p>
									</div>
								</div><!--/提示语-->
								<div class="my-lovely xy-tac xy-pad-lr10">
									<img src="${_staticPath}/resource/weuiWeb/img/msg-05.gif" />
								</div><!--/蜻蜓-->
							</div>
						</div>
					
						<div class="">
							<div class="xy-waveBox xy-line-h0">
								<div class="xy-wave" id="wave1"></div>
								<div class="xy-wave" id="wave2"></div>
								<div class="xy-wave" id="wave3"></div>
							</div>
							<div class="xy-tac xy-pad-t20 xy-pad-b10 xy-pad-lr10 bg-blue-opacity xy-clearfix xy-fc-blue xy-fs16">
								<a href="#" class="weui-btn weui-btn_primary bg-light-blue xy-mar-tb10">好的，你去处理吧</a>
							</div>
						</div><!--/bottom-->
					</div><!--内容-->
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
			$(function(){
				$('.xy-mar-tb10').click(function(){
					sessionStorage.setItem('iffuwu',1);//跳转页面，公用一个列表页，设假数据为1，若1 ==》 跳转页面标题改成"历史服务记录列表";
					window.location.href =_path+"/consumer/services-list.jsp";
				});
			})
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>