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
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
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
	.mycontainer{    box-sizing: border-box;height: 100%;margin-top: 2.5em;}
	.pl30{padding-left: 30%;}
	.marginleft{
				margin-left: 2em;
	}
	.ceshi{ background-color: #fff;
		    width: 88%;
		    margin: 0 6%;
		    border-top: 2px solid #e6e6e6;}
	.flexMe,.flex2{display:flex;width:100%;margin:0;padding:0;list-style:none;padding: 2% 0;}
	.flexMe :nth-child(1){flex:1 1 25%;}
	.flexMe :nth-child(2){flex:2 2 60%;margin-top: 2%;}
	.flexMe :nth-child(3){flex:3 3 10%;}
	.flex2 :nth-child(1){flex:1 1 15%;}
	.flex2 :nth-child(2){flex:2 2 35%;}
	.flex2 :nth-child(3){flex:3 3 40%;}
	.flex2 :nth-child(4){flex:4 4 10%;}
	.progress{width:50%;height:6px;border-radius: 10px;}
	.jianbian{background-image:linear-gradient(to top,#fff,#CBE3FE);}
	.jianbian2{background-image:linear-gradient(to top,#fff 60%,#3792FB 40%);}
	</style>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header" style="position: fixed;">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title"><span>胡先生</span>家的监测详情</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd mycontainer">
				<div class="swiper-container ve-swiper-container height100">
					<div class="swiper-wrapper">
						<!-- ------------------swiper slide-------------------- -->
						<div class="swiper-slide"> 
							<div class="xy-pad-t10 xy-border-box height100">
								<div class="xy-layout jianbian2 height100" flex="dir:top">						
									<ol class="weui-cell weui-cell_access" style="color:#fff;">
										<dt class="">
											<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG">
												<img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" />
											</p>
										</dt>
										<dd class="pl30">
											<h3 style="line-height: 2em;">智慧饮水管家通知</h3>
											<p id="tips"></p>
										</dd>
									</ol>
									<div class="">
										<!--波纹-->
										<div class="xy-waveBox xy-line-h0">
											<div class="xy-wave" id="wave1"></div>
											<div class="xy-wave" id="wave2"></div>
											<div class="xy-wave" id="wave3"></div>
										</div>
										<!--净水设备过滤结构-->
										<div class="jianbian xy-tac xy-pad-lr2 structure-chart" style="position: relative;">
											 <img src="${_staticPath}/resource/weuiWeb/img/device.gif" />
											 <div class="warn"></div>
										</div>
									</div>
									<div style="background-color: #fff;" class="ceshi">
										<h4 class="xy-tac xy-pad-tb7"><span>胡先生</span>家的在线监测值</h4>
										<ul class="flexMe xy-tac">
										    <li>原水TDS值</li>
										    <li>
										    	<div class="progress" style="background-color:#FBB55F;"></div>
										    </li>
										    <li id="rawTds"></li>
										</ul>
										<ul class="flexMe xy-tac">
										    <li>净水TDS值</li>
										    <li>
										    	<div class="progress" style="background-color:#85E037;"></div>
										    </li>
										    <li id="purTds"></li>
										</ul>
										<ul class="flex2 xy-tac">
										    <li>温度</li>
										    <li id="temp"></li>
										    <li class="xy-tac">流量</li>
										    <li id="flow"></li>
										</ul>
										<ul class="flex2 xy-tac">
										    <li>湿度</li>
										    <li id="humidity"></li>
										    <li class="xy-tac">是否漏水</li>
										    <li id="leak"></li>
										</ul>
									</div>
								 
											<!-- <div class="xy-tac xy-pad-t1 xy-pad-b10 xy-pad-lr10 bg-blue-opacity xy-clearfix xy-fc-blue xy-fs16">
												<a href="#" class="weui-btn weui-btn_primary bg-light-blue" id="monitorEchart">查看监测曲线图</a>
											</div> -->
								</div>
							</div>
						</div> 
		            	<div class="swiper-slide"><!-- 此处是监测曲线图 -->
							<div class="weui-tab xy-border-box xy-pad-tb10 xy-pad-b45p" style="height:90%">
								<div class="weui-tabbar xy-tabbar bg-white">
									<a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
										<p class="weui-tabbar__label">原水净化</p>
									</a>
									<a href="javascript:;" class="weui-tabbar__item">
										<p class="weui-tabbar__label">过程净化</p>
									</a>
								</div><!--/tab 导航-->
								<div class="weui-tab__panel xy-tab__panel">
									<div class="xy-tab-list xy-tab-list_on">
										<div class="height100 xy-border-box">
											<div id="rawCharts" class="height100"></div>
										</div>
									</div>
									<div class="xy-tab-list">
										<div class="height100 xy-border-box">
											<div id="purCharts" class="height100"></div>
										</div>
									</div>
								</div><!--/tab 内容-->
								<div class="weui-footer weui-footer_fixed-bottom xy-footer">
									<div class="xy-pad-lr10 xy-clearfix">
										<a href="javascript:;" class="weui-btn weui-btn_primary bg-light-blue xy-btn-next">服务方案</a>
									</div>
								</div>
							</div>							
						</div>
						<!--/ container -->
						
						<div class="echarts-qt xy-dn" id="echartsQt" flex="main:center cross:center">
							<div>
								<div class="my-msg weui-flex xy-pad-lr10 xy-mar-t20" flex="main:center cross:center">
									<div class="xy-fc-gray xy-pad-lr10 xy-fs12" style="width:220px;">
										<p>主人，<span id="seriesName"></span>监测数据显示，在<span id="seriesNameX"></span>有服务提醒消息推送。</p>
										<p>服务内容：更换3级滤芯和相关维护;</p>
										<p>服务人员：潘小玲;</p>
										<p>评价：四星。</p>
									</div>
								</div><!--/提示语-->
							
								<div flex="main:center cross:center">
									<div class="my-lovely xy-tac xy-pad-lr10">
										<img src="${_staticPath}/resource/weuiWeb/img/pic-lovely-01.png">
									</div><!--/蜻蜓-->
								</div>
							</div>
						</div>												
	             	</div>
           	 	</div>
           	 	<div class="swiper-button-prev xy-bottom_btnPrve"></div>
				<div class="swiper-button-next xy-bottom_btnNext"></div>
			</div>
			<!--/ container -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/swiper.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper-vertical.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/echarts.min.js"></script>
		<script src="${_path}/js/consumer/myEchart.js"></script>
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
						var str = '您的饮水安全质量 <span class="xy-fs13 xy-fwb xy-dibVat">棒棒哒！</span>';
						tips.html(str);
					}else if(warnType == 1){
						var str = '该设备第一级滤芯即将维护，请你留意一下服务时间';
						tips.html(str);
						$('.warn').show().css({left:'22%',top:'18%'});						
					}else if(warnType == 2){
						var str = '该设备第二级滤芯即将维护，请你留意一下服务时间';
						tips.html(str);						
						$('.warn').show().css({left:'32%',top:'18%'});
					}else if(warnType == 3){
						var str = '该设备第三级滤芯即将维护，请你留意一下服务时间';
						tips.html(str);
						$('.warn').show().css({left:'42%',top:'18%'});	
					}else if(warnType == 4){
						var str = '该设备第四级滤芯即将维护，请你留意一下服务时间';
						tips.html(str);
						$('.warn').show().css({left:'57%',top:'18%'});
					}else if(warnType == 5){
						var str = '该设备第五级滤芯即将维护，请你留意一下服务时间',img ="structure-chart";
						tips.html(str);
						$('.warn').show().css({left:'69%',top:'18%'});
					}
					//var params = "<img src='${_staticPath}/resource/weuiWeb/img/"+img+".gif'/>";
					//$('.structure-chart').html(params);
				}				
				//监测曲线图按钮跳转
				$('.weui-btn_primary').click(function(){
					//if(GetQueryString('equipCode')){
						//equipCode = GetQueryString('equipCode');
						//window.location.href =_path+"/consumer/services-list.jsp?equipCode="+equipCode;
					//}else{
						window.location.href =_path+"/consumer/services-list.jsp";
					//}					
				});
				fillData();
			})
			function fillData(){
				$(function(){
				//ajax获取后台数据，填充页面  ,  包括
				 $.ajax({
					type:'get',
					url:_path+'/consumer/home/listStickMonitor',
					//data:{account:account},
					success : function(msg){
						console.log(msg);
						if(msg.data)	{
							$('#flow').html(msg.data.flow);
							$('#humidity').html(msg.data.humidity);
							$('#purTds').html(msg.data.purTds);
							$('#rawTds').html(msg.data.rawTds);
							$('#temp').html(msg.data.temp);
							msg.data.leak == 'false' ?$('#leak').html('否'):$('#leak').html('是');
							progressWidth();						
							}					
						}
					}); 																											
				})
				function progressWidth(){
				$(".progress").each(function () {
					var a = parseInt($(this).parent().next().html());
			        $(this).css("width",a > 200?'100%':a/2+'%');
				    });
				}
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>