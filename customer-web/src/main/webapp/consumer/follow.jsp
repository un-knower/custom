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
		<title>净水器-申请关注</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
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
				<div class="weui-flex__item"><div class="xy-h1-title">申请关注</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
		
			<div class="page__bd xy-container">
				<div class="xy-layout">
					<div class="xy-layout-bar xy-mar-10 xy-pad-10">						
						<p class="xy-fc-blue">昨天</p>
						<div class="xy-tac">
							<div class="xy-dib xy-pad-b7">
								<p class="mini-lovely"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
								<p class="xy-pad-t3 xy-fs16">蒙奇浩浩</p>
								<p class="xy-pad-t3 xy-fs16 xy-fc-gray">申请关注您的饮水安全状态</p>
							</div>
						</div>
					</div>
					<div class="xy-pad-10">
						<a href="javascript:history.go(-1);" class="weui-btn weui-btn_primary bg-light-blue">同意</a>
						<a href="javascript:;" class="weui-btn weui-btn_primary xy-marIM-t10 bg-orange">拒绝</a>
					</div>
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
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>