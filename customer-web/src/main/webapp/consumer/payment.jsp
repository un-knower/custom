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
		<title>净水器-支付页面</title>
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
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">支付页面</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b10 xy-scrollY">
				<div class="xy-pad-lr10 xy-pad-t10 xy-border-box xy-list-top-bar">
					<ul>
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar xy-pad-b10 xy-border-box">
							<div class="xy-head-title xy-pad-lr10 xy-corner-0 bg-blue-01" flex="dir:left">
								<p class="xy-fs14" flex-box="1">充值项目</p>
								<p class="xy-fs12">持续保障您的饮水安全</p>
							</div>
							<div class="weui-cell weui-cell_access">
								<div class="weui-cell__bd xy-clearfix">
									<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG xy-fll"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png" /></p>
									<div class="xy-db xy-mar-l85p">
										<ol class="xy-pad-t3 xy-fs16" flex="dir:left">
											<dt>项目一</dt>
											<dd flex-box="1">(自家的设备)</dd>
										</ol>
										<ol class="xy-pad-t3 xy-fc-light-gray xy-fs13" flex="dir:left">
											<dt>项目编号：</dt>
											<dd flex-box="1">QT20170504233</dd>
										</ol>
										<ol class="xy-fc-light-gray xy-fs13" flex="dir:left">
											<dt>充值编号：</dt>
											<dd flex-box="1">10020170504233</dd>
										</ol>
									</div>
								</div>
							</div><!--信息模块-->
								
							<div class="xy-fwb-title xy-fs15 xy-border-box xy-pad-lr10 xy-pad-t3 xy-tac">
								本次服务所剩时长：25天3小时44分钟
							</div>
						</li><!--列表-->
						
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar xy-pad-b10 xy-border-box">
							<div class="xy-head-titleBlack xy-pad-lr10 xy-corner-0" flex="dir:left">
								<p class="xy-fs14" flex-box="1">充值项目</p>
								<p class="xy-fs12">回馈新老客户，充值就送服务时长</p>
							</div>
							<div class="select-menubar xy-select-menubar xy-clearfix xy-pad-b10 xy-pad-lr5">
								<a href="javascript:;" class="select-menubar__item xy-select-menubar__item">
									<p class="select-menubar__label xy-pad-lr10 xy-pad-tb1 xy-gray-title">一年</p>
									<p class="select-menubar__label xy-pad-tb7 xy-fs16">980元</p>
								</a>
								<a href="javascript:;" class="select-menubar__item xy-select-menubar__item">
									<p class="select-menubar__label xy-pad-lr10 xy-pad-tb1 xy-gray-title">两年</p>
									<p class="select-menubar__label xy-pad-tb7 xy-fs16">1800元</p>
								</a>
								<a href="javascript:;" class="select-menubar__item xy-select-menubar__item select-menubar__item_on">
									<p class="select-menubar__label xy-pad-lr10 xy-pad-tb1 xy-gray-title">三年</p>
									<p class="select-menubar__label xy-pad-tb7 xy-fs16">2600元</p>
								</a>
								<a href="javascript:;" class="select-menubar__item xy-select-menubar__item">
									<p class="select-menubar__label xy-pad-lr10 xy-pad-tb1 xy-gray-title">四年</p>
									<p class="select-menubar__label xy-pad-tb7 xy-fs16">3400元</p>
								</a>
							</div><!--/多选-->
							<div class="xy-pad-lr10">
								充值后服务日期截止为：2020年9月29日(含赠送3个月)
							</div>
						</li><!--列表-->
						
						<li class="xy-layout-bar xy-pad-b7 xy-border-box">
							<div class="xy-head-titleBlack xy-pad-lr10 xy-corner-0" flex="dir:left">
								<p class="xy-fs14" flex-box="1">支付方式</p>
							</div>
							<div class="select-menubar xy-select-menubar-other xy-clearfix xy-pad-t7 xy-pad-lr5 xy-border-t">
								<a href="javascript:;" class="select-menubar__item xy-select-menubar__item50 xy-full-widthIMG xy-line-h0">
									<img src="${_staticPath}/resource/weuiWeb/img/payway-zhifubao.png" alt="支付宝支付"/>
								</a>
								<a href="javascript:;" class="select-menubar__item xy-select-menubar__item50 xy-full-widthIMG xy-line-h0">
									<img src="${_staticPath}/resource/weuiWeb/img/payway-weixin.png" alt="微信支付"/>
								</a>
							</div><!--/多选-->
						</li><!--列表 支付方式-->
					</ul><!--ul 列表-->
					
					<div class="xy-pad-t10">
						<a href="javascript:history.go(-1);;" class="weui-btn weui-btn_primary bg-light-blue">确认支付</a>
					</div><!--支付按钮-->
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
				//评价多选
				$('.select-menubar__item').on('click', function () {
					$(this).toggleClass('select-menubar__item_on').siblings().removeClass('select-menubar__item_on');
				});
			});
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>