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
		<title>净水器-修改密码</title>
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
				<div class="weui-flex__item"><div class="xy-h1-title">修改密码</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b42 xy-container-zb0">
				<div class="xy-border-box height100">
					<div class="xy-layout bg-white">
						<div class="xy-pad-lr10 xy-pad-b10">
							<div class="weui-cells weui-cells_form xy-login-form xy-layout-bar">
								<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
									<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-tel.png" /></label></div>
									<div class="weui-cell__bd">
										<input class="weui-input xy-input-tel" type="number" placeholder="" value="12345678910" readonly="readonly">
									</div>
								</div>
								<div class="weui-cell weui-cell_vcode xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
									<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-code.png" /></label></div>
									<div class="weui-cell__bd">
										<input class="weui-input xy-input-code" type="number" placeholder="请输入验证码">
									</div>
									<div class="weui-cell__ft">
										<button class="weui-vcode-btn">获取验证码</button>
									</div>
								</div>
								<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
									<div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="${_staticPath}/resource/weuiWeb/img/form-pwd.png" /></label></div>
									<div class="weui-cell__bd">
										<input class="weui-input xy-input-pwd" type="password" placeholder="请设置大于6位数密码">
									</div>
								</div>
								<div class="xy-mar-tb10 xy-mar-lr10">
									<a href="javascript:;" class="weui-btn weui-btn_primary bg-light-blue" id="reviseBtn">确认修改</a>
								</div>
								<div class="bg-light-gray xy-clearfix">
									<a href="javascript:;" class="xy-fc-black xy-fs14 xy-pad-tb7lr10 xy-flr">&nbsp;</a>
								</div>
							</div>
						</div>
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
				$("#reviseBtn").click(function(){
					var loading = weui.default.loading();
					setTimeout(function(){
						loading.hide();
						weui.default.toast("修改密码成功",2000);
						setTimeout(function(){
							history.go(-1);
						},2000)
					},1000)
				})
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>