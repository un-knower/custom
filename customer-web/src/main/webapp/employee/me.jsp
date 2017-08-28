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
		<title>服务-个人中心</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-flex.css" /> 
		<link rel="stylesheet" href="${_staticPath}/resource/employee/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-css.css"/> 
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<body ontouchstart style="background-color: #EEEEEE;">
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">个人中心</div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini"></a>
				</div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t0b0">
				<div class="xy-border-box height100">
					<div class="xy-pad-tb10 xy-border-box xy-mar-t30" flex-box="1" flex="dir:top">
						<div class="xy-border-box xy-tac xy-white-bg xy-pad-tb10" flex-box="1">
							<div class="xy-dibVat">
								<p class="mini-lovely width100"><img src="${_staticPath}/resource/employee/img/pic-lovely.gif" /></p>
								<p class="xy-pad-t3 xy-fs16">蒙奇浩浩</p>
								<p class="xy-pad-t3 xy-fc-light-gray xy-fs12">工号：QTAZ201706006</p>
							</div>
						</div>
					</div>
					<div class="xy-mar-t20 xy-mar-lr10">
						<a href="#" class="weui-btn weui-btn_primary bg-blue " id="revise_pwd">修&nbsp改&nbsp密&nbsp码</a>
					</div>
					<div class="xy-mar-t20 xy-mar-lr10">
						<a href="#" class="weui-btn weui-btn_primary bg-orange" id="exit">退&nbsp出&nbsp登&nbsp录</a>
					</div>
				</div>
			</div>			
		</div>    <!--  page  end --> 
		<!-- 弹窗 们-->
			<div id="dialogs">
				<div class="js_dialog" id="iosDialog1" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__bd">
							<p class="icon-dialog-bar"><img src="${_staticPath}/resource/employee/img/sucess.png" /></p>
							<p class="xy-fs18 xy-fc-white xy-pad-t3"><b>操作成功</b></p>
						</div>
						<div class="xy-waveBox xy-line-h0">
							<div class="xy-wave" id="wave4"></div>
							<div class="xy-wave" id="wave5"></div>
							<div class="xy-wave" id="wave6"></div>
						</div>
						<div class="weui-dialog__ft">
							<div class="xy-pad-lr10 xy-pad-b10 bg-blue-opacity xy-border-box width100" flex="dir:left">
								<a href="javascript:;" class="weui-btn weui-dialog__btn weui-dialog__btn_primary bg-blue dialog-btn-primary" flex-blox="1">确认</a>
							</div>
						</div>
					</div>
				</div>
			</div>  
		<script type="text/javascript" src="${_staticPath}/resource/employee/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/employee/js/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">	
			var $iosDialog1 = $('#iosDialog1');	
			$('#revise_pwd').click(function(){
				window.location.href =_path+"/employee/revise-pwd.jsp?mobile=15828609056";
				//$iosDialog1.show();
			});	
			$('#exit').click(function(){
				console.log(_path);
				//退出
				//window.location.href =_path+'/logout';
				window.location.href =_path+'/login/employee';
			});
		</script>

	</body>
</html>