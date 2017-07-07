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
		<title>净水器-监测详情</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<style>
	/*  .warn{width:30px; height:100px;position: absolute; display:none; 
	 background-image:radial-gradient(15px 50px at 15px 50px,hsla(50, 93%, 50%, 0.9),hsla(0, 11%, 96%, 0));
	 animation:twinkling 1s infinite ease-in-out;} */
	 @media screen and (max-width: 768px) {
	    .warn{width:30px; height:100px;position: absolute; display:none; 
		 background-image:radial-gradient(15px 50px at 15px 50px,hsla(50, 93%, 50%, 0.9),hsla(0, 11%, 96%, 0));
		 animation:twinkling 1s infinite ease-in-out;}
	}
	@media screen and (min-width: 768px) {
	    .warn{width:60px; height:200px;position: absolute; display:none; 
		 background-image:radial-gradient(35px 100px at 30px 100px,hsla(50, 93%, 50%, 0.9),hsla(0, 11%, 96%, 0));
		 animation:twinkling 1s infinite ease-in-out;}
	}
	@media screen and (max-width: 320px) {
	    .warn{width:20px; height:80px;position: absolute; display:none; 
		 background-image:radial-gradient(10px 40px at 10px 40px,hsla(50, 93%, 50%, 0.9),hsla(0, 11%, 96%, 0));
		 animation:twinkling 1s infinite ease-in-out;}
	}
	/*  定义一闪一闪的动画 */
	@keyframes twinkling{
		0%{opacity:0;}
		100%{opacity:1;}
	}
	</style>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">监测详情</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b10">
				<div class="xy-pad-lr10 xy-pad-t10 xy-border-box height100">
					<div class="xy-layout xy-layout-bar bg-blue-01 height100" flex="dir:top">
						<div class="full-layout-box miniHalf-layout-box" flex-box="1" flex="main:center cross:center">
							<div>
								<div class="my-msg weui-flex xy-pad-lr10 xy-mar-t15" flex="main:center cross:center">
									<div class="xy-fc-white xy-fs12">
										<p>您好！主人。</p>
										<p id="tips">清亭小管家监测数据提示</p>
									</div>
								</div>
							
								<div flex="main:center cross:center">
									<div class="my-lovely xy-tac xy-pad-lr10" id="xy-qt-MaxImg">
										<img src="${_staticPath}/resource/weuiWeb/img/msg-01.gif" />
									</div>
								</div>
							</div>
							<!--提示状态-->
						</div>
						<div class="">
							<!--波纹-->
							<div class="xy-waveBox xy-line-h0">
								<div class="xy-wave" id="wave1"></div>
								<div class="xy-wave" id="wave2"></div>
								<div class="xy-wave" id="wave3"></div>
							</div>
							<!--净水设备过滤结构-->
							<div class="bg-blue-opacity xy-tac xy-pad-lr10 structure-chart" style="position: relative;">
								 <img src="${_staticPath}/resource/weuiWeb/img/device.gif" />
								 <div class="warn"></div>
							</div>
						</div>
						<div class="xy-tac xy-pad-t1 xy-pad-b10 xy-pad-lr10 bg-blue-opacity xy-clearfix xy-fc-blue xy-fs16">
							<a href="#" class="weui-btn weui-btn_primary bg-light-blue" id="monitorEchart">查看监测曲线图</a>
						</div>
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
			$(function(){
				var equipId='';
				//获取地址栏参数				
				function GetQueryString(name){
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  decodeURI(r[2]); return null;
				}
				if(GetQueryString('equipCode')){
					equipId = GetQueryString('equipCode');
				}
				//后台取warnType				
				 $.ajax({
					type:'get',
					url:_path+'/consumer/warn/getWarnType?equipId='+equipId,
					success : function(msg){
						console.log(msg.data);
						if(msg){
							showType(msg.data);
						}						
					}
				});
				function showType(warnType){
					var tips = $('#tips');
					if(warnType == 0){
						var str = '<p>您的饮水安全质量 <span class="xy-fs13 xy-fwb xy-dibVat">棒棒哒！</span></p>'/* ,img ="structure-chart" */;
						tips.append(str);
					}else if(warnType == 1){
						var str = '<p>您的一级滤芯<span class="xy-fs13 xy-fwb xy-dibVat">该换啦！</span></p>'/* ,img ="structure-chart" */;
						tips.append(str);
						$('.warn').show().css({left:'22%',top:'18%'});						
					}else if(warnType == 2){
						var str = '<p>您的二级滤芯<span class="xy-fs13 xy-fwb xy-dibVat">该换啦！</span></p>'/* ,img ="structure-chart" */;
						tips.append(str);						
						/* if($(window).width() <= 320) $('.warn').show().css({left:'35%',top:'14%'});
						else $('.warn').show().css({left:'32%',top:'18%'}); */
						$('.warn').show().css({left:'32%',top:'18%'});
					}else if(warnType == 3){
						var str = '<p>您的三级滤芯<span class="xy-fs13 xy-fwb xy-dibVat">该换啦！</span></p>'/* ,img ="structure-chart" */;
						tips.append(str);
						$('.warn').show().css({left:'42%',top:'18%'});	
					}else if(warnType == 4){
						var str = '<p>您的四级滤芯<span class="xy-fs13 xy-fwb xy-dibVat">该换啦！</span></p>'/* ,img ="structure-chart" */;
						tips.append(str);
						$('.warn').show().css({left:'57%',top:'18%'});
					}else if(warnType == 5){
						var str = '<p>您的五级滤芯<span class="xy-fs13 xy-fwb xy-dibVat">该换啦！</span></p>',img ="structure-chart";
						tips.append(str);
						$('.warn').show().css({left:'69%',top:'18%'});
					}
					//var params = "<img src='${_staticPath}/resource/weuiWeb/img/"+img+".gif'/>";
					//$('.structure-chart').html(params);
				}				
				//监测曲线图按钮跳转
				$('#monitorEchart').click(function(){
					if(GetQueryString('equipCode')){
						equipCode = GetQueryString('equipCode');
						window.location.href =_path+"/consumer/echarts.jsp?equipCode="+equipCode;
					}else{
						window.location.href =_path+"/consumer/echarts.jsp";
					}					
				});
			})
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>