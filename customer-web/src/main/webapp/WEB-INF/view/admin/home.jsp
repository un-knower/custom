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
		<title>净水器-首页</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart>
		<div class="page flex js_show height100 page-navbar">
			<div class="page__bd xy-container xy-container-other">
				<div class="swiper-container ve-swiper-container height100">
					<div class="swiper-wrapper">
						<!--------------------swiper slide---------------------->
						<div class="swiper-slide"> 
							<div class="xy-pad-10 xy-border-box height100">
								<div class="xy-layout xy-layout-bar bg-blue-01" flex="dir:top">
									<div class="full-layout-box" flex-box="1" flex="main:center cross:center">
										<div id="msg-state" value="1">
											<!--<div class="my-msg weui-flex xy-pad-lr10 xy-mar-t20" flex="main:center cross:center">
												<div class="xy-fc-white xy-fs14">
													<p>您好！主人。</p>
													<p>清亭小管家监测数据提示</p>
													<p>您的饮水安全质量<span class="xy-fs15 xy-fwb xy-dibVat">棒棒哒！</span></p>
												</div>
											</div>
										
											<div flex="main:center cross:center">
												<div class="my-lovely xy-tac xy-pad-lr10" id="xy-qt-MaxImg">
													<img src="img/pic-lovely-01.png" />
												</div>
											</div>-->
										</div>
										<!--提示状态-->
									</div>
									<div class="">
										<div class="xy-waveBox xy-line-h0">
											<div class="xy-wave" id="wave1"></div>
											<div class="xy-wave" id="wave2"></div>
											<div class="xy-wave" id="wave3"></div>
										</div><!--/波纹-->
										
										<!--导航-->
										<div class="bg-blue-opacity" style="height:62px;">
											<div class="xy-nav-bar xy-pad-lr10 xy-pore xy-dn">
												<div class="xy-voice-bar xy-top-corner xy-tac xy-pad-t20 xy-poab">
													<div class="xy-db xy-voice-seat"><span class="xy-voice-img xy-qt-img xy-line-h0"><img src="${_staticPath}/resource/weuiWeb/img/icon-corner-qt.png" /></span></div>
												</div>
												<div class="xy-wave-img xy-poab xy-tac xy-dn"><img src="${_staticPath}/resource/weuiWeb/img/icon-wave.png" /></div>	
												<div class="weui-navbar xy-navbar xy-navbar-seat xy-layout-bar bg-white reset-poab reset-top">
													<a class="weui-navbar__item weui-bar__item_on" href="#" id="home">
														<p class="xy-navbar-icon xy-line-h0"><img src="${_staticPath}/resource/weuiWeb/img/nav-home.png" /></p>			
														<p class="xy-pad-t2">首页</p>									
													</a>
													<a class="weui-navbar__item" href="#" id="device">
														<p class="xy-navbar-icon xy-line-h0"><img src="${_staticPath}/resource/weuiWeb/img/nav-warning.png" /></p>	
														<p class="xy-pad-t2">设备</p>
													</a>
													<a class="weui-navbar__item" href="#" id="attention">
														<p class="xy-navbar-icon xy-line-h0"><img src="${_staticPath}/resource/weuiWeb/img/nav-follow.png" /></p>	
														<p class="xy-pad-t2">关注</p>
													</a>
													<a class="weui-navbar__item btn-services-list" href="javascript:;" id="sevice"><!--判断 btn-services-list 连接服务列表-->
														<p class="xy-navbar-icon xy-line-h0"><img src="${_staticPath}/resource/weuiWeb/img/nav-heart-shaped.png" /></p>	
														<p class="xy-pad-t2">服务</p>
													</a>
													<a class="weui-navbar__item" href="#" id="me">
														<p class="xy-navbar-icon xy-line-h0"><img src="${_staticPath}/resource/weuiWeb/img/nav-me.png" /></p>	
														<p class="xy-pad-t2">我的</p>
													</a>
												</div>
											</div>
										</div>
										<!--/导航-->
										<div class="xy-tac xy-pad-lr10 bg-blue-opacity xy-clearfix xy-fc-blue xy-fs16">
											<ol class="xy-fll xy-pad-tb10">
												<dt class="xy-dibVat">监测次数</dt>
												<dd class="dt xy-dibVat" id="moitorCount">200172</dd>
											</ol>
											<ol class="xy-flr  xy-pad-tb10">
												<dt class="xy-dibVat">服务次数</dt>
												<dd class="dt xy-dibVat" id="serviceCount">230</dd>
											</ol>
										</div>
									</div><!--/bottom-->
								</div><!--内容-->
							</div>
						</div>
						<!--列表-->
						
						<!--------------------swiper slide---------------------->
						<div class="swiper-slide">
							<div class="xy-pad-10 xy-border-box height100">
								<div class="xy-layout xy-layout-bar bg-blue-01" flex="dir:top">
									<div class="full-layout-box xy-dataListBox xy-mar-t20" flex-box="1" flex="dir:top">
										<div class="xy-dataList">
											<div class="xy-dataItem">
												<div class="xy-dataItemName">原水TDS值</div>
												<div class="xy-dataItemValue" id="rawTds">59</div>
											</div>
										</div>
										<div class="xy-dataList">
											<div class="xy-dataItem">
												<div class="xy-dataItemName">净水TDS值</div>
												<div class="xy-dataItemValue" id="purTds">9</div>
											</div>
										</div>
										<div class="xy-dataList">
											<div class="xy-dataItem">
												<div class="xy-dataItemName">流量</div>
												<div class="xy-dataItemValue" id="flow">23</div>
											</div>
										</div>
										<div class="xy-dataList">
											<div class="xy-dataItem">
												<div class="xy-dataItemName">湿度</div>
												<div class="xy-dataItemValue" id="humidity">12</div>
											</div>
										</div>
										<div class="xy-dataList">
											<div class="xy-dataItem">
												<div class="xy-dataItemName">电磁阀开关</div>
												<div class="xy-dataItemValue" id="leak">8</div>
											</div>
										</div>
										<div class="xy-dataList">
											<div class="xy-dataItem">
												<div class="xy-dataItemName">温度</div>
												<div class="xy-dataItemValue" id="temp">26</div>
											</div>
										</div>
									</div>
								
									<div class="">
										<div class="xy-waveBox xy-line-h0">
											<div class="xy-wave" id="wave4"></div>
											<div class="xy-wave" id="wave5"></div>
											<div class="xy-wave" id="wave6"></div>
										</div><!--/波纹-->
										<div class="xy-tac xy-pad-tb10 bg-blue-opacity xy-clearfix xy-fc-blue">
											<div class="xy-clearfix xy-dataListBtn">
												<a href="#" class="weui-btn weui-btn_primary bg-light-blue xy-btn-next" id="monitorDetail">查看监测详情</a>
												<div class="xy-dataListBtnImg"></div>
											</div>
										</div>
									</div><!--/bottom-->
								</div><!--内容-->
							</div>
						</div>
						<!--列表-->
						
					</div>
					
				</div>
				<div class="swiper-button-prev xy-bottom_btnPrve"></div>
				<div class="swiper-button-next xy-bottom_btnNext"></div>
			</div>
			<!--/ container -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/swiper.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper-vertical.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
				
			}
			$(function(){
				//ajax获取后台数据，填充页面  ,  包括
				 $.ajax({
					type:'get',
					url:_path+'/consumer/home/listStickMonitor',
					//data:{account:account},
					success : function(msg){
						//console.log(msg);
						if(msg)	{
							$('#flow').html(msg.data.flow);
							$('#humidity').html(msg.data.humidity);
							$('#moitorCount').html(msg.data.moitorCount);
							$('#msgType').html(msg.data.msgType);
							$('#purTds').html(msg.data.purTds);
							$('#rawTds').html(msg.data.rawTds);
							$('#serviceCount').html(msg.data.serviceCount);
							$('#temp').html(msg.data.temp);
							msg.data.leak == 'false' ?$('#leak').html('否'):$('#leak').html('是');
						}
						knowStatue(msg.code);						
					}
				}); 
				
				//蜻蜓点击显示隐藏导航
				$("body").on("click","#xy-qt-MaxImg",function(){
					$(".xy-nav-bar").toggle();
				})
				
				//msg 状态
				function knowStatue(msgState){
					if(msgState==1){
						var txt = "换芯说明";
						var img ="msg-01";
					}else if(msgState==2){
						var txt = "申请关注";
						var img ="msg-02";
					}else if(msgState==3){
						var txt = "有未评价";
						var img ="msg-03";
					}else if(msgState==4){
						var txt = "预警提醒";
						var img ="msg-04";
					}else if(msgState==5){
						var txt = "预警正常情况";
						var img ="msg-05";
					}
					var params = "<div class='my-msg weui-flex xy-pad-lr10 xy-mar-t20' flex='main:center cross:center'><div class='xy-fc-white xy-fs14'><p>"+txt+"</p></div></div><div flex='main:center cross:center'><div class='my-lovely xy-tac xy-pad-lr10' id='xy-qt-MaxImg'><img src='${_staticPath}/resource/weuiWeb/img/"+img+".gif' /></div></div>";
					$('#msg-state').html(params);
				}								
				//服务 列表需要判断，点击事件   单独写
				$('.btn-services-list').click(function(){
					sessionStorage.setItem('iffuwu',1);//跳转页面，公用一个列表页，设假数据为1，若1 ==》 跳转页面标题改成"历史服务记录列表";
					window.location.href="page-services-list.html";
				})
				bindEvent();
			})
			function bindEvent(){
				$('#home').click(function(){
					window.location.href =_path+"/consumer/home";
				});
				$('#device').click(function(){
					window.location.href =_path+"/consumer/project.jsp";
				});
				$('#attention').click(function(){
					window.location.href =_path+"/consumer/device-follow.jsp";
				});
				$('#me').click(function(){
					window.location.href =_path+"/consumer/me.jsp";
				});
				$('#monitorDetail').click(function(){
					window.location.href =_path+"/consumer/device-details.jsp";
				});
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>