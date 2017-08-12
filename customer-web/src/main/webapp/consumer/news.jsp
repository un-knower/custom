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
		<title>净水器-消息列表</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
		<link rel="stylesheet" type="text/css" href="${_path}/css/base.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<style>
		.spanLine{width: 1.5px;margin-top: 10px; color: #2E8DFB;} 
		.dotPosition{top:8px;left:inherit;}		
		.scrolly{ overflow: hidden; overflow-y: scroll;}
		.messageNotRead{top: 36%;left: 28%;}
		.pr{position: relative;} 
		.xy-tabbar .lineStyle{    height: 25px;
		    border-right: 2px solid #227ce4;
		    margin-top: 0.5em;
		    line-height: 25px;} 
	    .textAdd{overflow:hidden;text-overflow:ellipsis; -o-text-overflow:ellipsis;white-space:nowrap;width:100%;}
	    .timeline .timeline-item .blueDot{background: #71affa;box-shadow: 0px 0px 5px 3px rgba(132, 210, 249, 0.52);}
	    @media screen and ( max-width:350px ){
	    	.messageNotRead{top: 36%;left: 32%;}
	    }
	</style>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">消息</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-white-bg" style="padding-bottom: 0.5em;">
				<div class="weui-tab xy-border-box xy-pad-tb10">
					<div class="weui-tabbar xy-tabbar bg-white">
						<a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
							<p class="weui-tabbar__label ">服务提醒</p>
						</a>
						<a href="javascript:;" class="weui-tabbar__item">
							<p class="weui-tabbar__label ">服务评价</p>
						</a>
						<a href="javascript:;" class="weui-tabbar__item">
							<p class="weui-tabbar__label ">好友申请</p>
						</a>
						<a href="javascript:;" class="weui-tabbar__item">
							<p class="weui-tabbar__label  pr">续费提醒<i class="xy-poab icon-new-message dotPosition">&nbsp;</i></p>
						</a>
					</div><!--/tab 导航-->
					<div class="weui-tab__panel xy-tab__panel xy-scrollH" >
						<div class="xy-tab-list xy-tab-list_on">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">	
								<div class="htmleaf-container height100">
									<div class="container height100 scrolly">
										<div class="timeline">
											 <div class="timeline-item">
												<div class="timeline-icon" style=" background: #71affa;
			   				box-shadow: 0px 0px 5px 3px rgba(132, 210, 249, 0.52);">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="#" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待服务</span>
																			<dt class=" xy-fs16"><b>胡先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>建议更换五级滤芯</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style="">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待服务</span>
																			<dt class=" xy-fs16"><b>胡先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>建议更换五级滤芯</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style="">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待服务</span>
																			<dt class=" xy-fs16"><b>胡先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>建议更换五级滤芯</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style="">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待服务</span>
																			<dt class=" xy-fs16"><b>胡先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>建议更换五级滤芯</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 --> 		
										</div>
									</div>
								</div>																	
							</div>
						</div>	
						<div class="xy-tab-list">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">	
								<div class="htmleaf-container height100">
									<div class="container height100 scrolly">
										<div class="timeline">
											<%-- <div class="timeline-item">
												<div class="timeline-icon" style=" background: #71affa;
			   				box-shadow: 0px 0px 5px 3px rgba(132, 210, 249, 0.52);">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待评价</span>
																			<dt class=" xy-fs16"><b>张三</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>更换第5级滤芯，日常维护</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style=" ">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待评价</span>
																			<dt class=" xy-fs16"><b>张三</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>更换第5级滤芯，日常维护</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style=" ">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待评价</span>
																			<dt class=" xy-fs16"><b>张三</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>更换第5级滤芯，日常维护</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 --> --%>			
										</div>
									</div>
								</div>																	
							</div>
						</div>
						<div class="xy-tab-list">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">	
								<div class="htmleaf-container height100">
									<div class="container height100 scrolly">
										<div class="timeline">
											<%-- <div class="timeline-item">
												<div class="timeline-icon" style=" background: #71affa;
			   				box-shadow: 0px 0px 5px 3px rgba(132, 210, 249, 0.52);">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待处理</span>
																			<dt class=" xy-fs16"><b>小飞流</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>我申请关注你家设备</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style="">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待处理</span>
																			<dt class=" xy-fs16"><b>小飞流</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>我申请关注你家设备</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style=" ">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待处理</span>
																			<dt class=" xy-fs16"><b>小飞流</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>我申请关注你家设备</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style=" ">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">待处理</span>
																			<dt class=" xy-fs16"><b>小飞流</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>我申请关注你家设备</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 --> --%>			
										</div>
									</div>
								</div>																	
							</div>
						</div>
						<div class="xy-tab-list">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">	
								<div class="htmleaf-container height100">
									<div class="container height100 scrolly">
										<div class="timeline">
											<%-- <div class="timeline-item">
												<div class="timeline-icon" style=" background: #71affa;
			   				box-shadow: 0px 0px 5px 3px rgba(132, 210, 249, 0.52);">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">去续费</span>
																			<dt class=" xy-fs16"><b>周先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>剩余服务时长：07天5小时</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style=" ">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">去续费</span>
																			<dt class=" xy-fs16"><b>周先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>剩余服务时长：07天5小时</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style="">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">去续费</span>
																			<dt class=" xy-fs16"><b>周先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>剩余服务时长：07天5小时</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon" style="">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="xy-fll line-normal-wrapper">
																<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
																	<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																	<div class="line-normal-msg" style="padding: 0.5em 0 0 1em;">
																		<ol class="xy-pad-t3">
																			<span class="xy-flr xy-fs13 xy-pad-t2">去续费</span>
																			<dt class=" xy-fs16"><b>周先生家的设备</b></dt>
																		</ol>
																		<ol class="xy-pad-t3 xy-fs13">
																			<dt>剩余服务时长：07天5小时</dt>
																		</ol>
																	</div>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->	 --%>		
										</div>
									</div>
								</div>																	
							</div>
						</div>
					</div><!--weui-tab__panel 内容-->
				</div><!--weui-tab 内容-->
			</div><!--/ container -->	
		</div>
		<!--/page End--><!--删除确认 弹窗-->
				
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<%-- <script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/leftDelete.js"></script> --%>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
			}												
$(function(){
	var sortCode = 'fwtx',fillDiv = $('.timeline:eq(0)'),endId='';
	getData(sortCode,fillDiv,endId);
	$('.weui-tabbar__item').on('click', function () {
		$(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
		var thisNum = $(this).index(),sortCode,fillDiv,endId='';
		console.log(thisNum);
		$('.xy-tab-list').eq(thisNum).addClass('xy-tab-list_on').siblings('.xy-tab-list_on').removeClass('xy-tab-list_on');
		if(thisNum == 1){
			sortCode = 'fwpj';
			fillDiv = $('.timeline:eq(1)');
			getData(sortCode,fillDiv,endId);
			monitorScroll();
		}else if(thisNum == 2){
			sortCode = 'sqgz';
			fillDiv = $('.timeline:eq(2)');
			getData(sortCode,fillDiv,endId)
			monitorScroll();
		}else if(thisNum == 3){
			sortCode = 'xftx';
			fillDiv = $('.timeline:eq(3)');
			getData(sortCode,fillDiv,endId)
			monitorScroll();
		}
	});
	monitorScroll();
	$('body').on('click','.timeline-item',function(){
				var id = $(this).attr('data-value'),//获取消息id
				thisSort = $(this).attr('sortCode');
				if($(this).find('i').length > 0){//如果有小红点，调消息已读接口
					//alert(thisSort)										
					$.ajax({
					type:'get',
					url:_path+'/consumer/message/setRead?id='+id+"&sortCode="+thisSort,
					success : function(msg){
						console.log(msg);
						if(msg){
								alert('成功');
							}						
						}
					});
					//return
				}			
				var followTime=$(this).find('h3').html(),
				name=$(this).find('b').html(),
				content=$(this).find('#content').html(),
				thisSrc=$(this).find('img').attr('src'),
				thisequipCode = $(this).attr('equipCode'),
				detailId = $(this).attr('detailId');
				console.log(thisSort,followTime,name,content,thisSrc); 
				  if(thisSort == 'sqgz'){//关注处理
window.location.href =_path+"/consumer/follow.jsp?followTime="+followTime+'&name='
+name+'&content='+content+'&thisSrc='+thisSrc+'&equipCode='+thisequipCode+'&detailId='+detailId+'&id='+id;
				}else if(thisSort == 'fwtx'){//跳转到服务提醒列表
					window.location.href =_path+"/consumer/remind-list.jsp";
				}else if(thisSort == 'fwpj'){//未评价服务，跳转有评价按钮页面
					sessionStorage.setItem('ifel',1);
					window.location.href =_path+"/consumer/services-details.jsp?serveId="+thisId;
				}else if(thisSort == 'xftx'){//跳转到续费提醒页面,暂时还没有写
					return
					//window.location.href =_path+"/consumer/service-offerings-details.jsp?serveId="+thisId;
				}  
	})				
});
function getData(sortCode,fillDiv,endId){
	//获取消息列表		
	$.ajax({
		type:'post',
		url:_path+'/consumer/message/list',
		//contentType: "application/json; charset=utf-8",
		data:{'endId':endId,"sortCode":sortCode},
		cache: true,		
		success : function(msg){
			console.log(msg);
			if(msg.data){
				//画消息列表
				drawMessageList(msg.data,fillDiv,endId)		
				}						
			}
	});	
}
function drawMessageList(data,fillDiv,endId){
	//console.log(data,fillDiv);	
	var messageDiv = '';
	for (var i in data){       
	 	messageDiv += '<div class="timeline-item" data-value="'+data[i].id+'" sortCode="'+data[i].sortCode+'" equipCode="'+data[i].strParam+'" detailId="'+data[i].detailId+'">'+
						'<div class="timeline-icon" style="">'+
						'</div>';
if(data[i].readFlag == false) {
		  messageDiv +='<i class="xy-poab icon-new-message messageNotRead">&nbsp;</i>';	
		  //$('.weui-bar__item_on').append('<i class="xy-poab icon-new-message dotPosition">&nbsp;</i></p>');			
}
		messageDiv +=   '<div class="timeline-content">'+
							'<h3>'+data[i].createTime+'</h3>'+
							'<div class="line-wrapper">'+
								'<div class="xy-border-box line-scroll-wrapper xy-clearfix">'+
									'<div class="xy-fll line-normal-wrapper">'+
						  				'<a href="#" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">'+
											'<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}'+data[i].path+'" /></p>'+
											'<div class="line-normal-msg" style="padding: 0 0 0 1em;">'+
												'<ol class="xy-pad-t3">'+
													'<span class="xy-flr xy-fs13 xy-pad-t2">'+data[i].status+'</span>'+
													'<dt class=" xy-fs16"><b>'+data[i].title+'</b></dt>'+
												'</ol>'+
												'<ol class="xy-pad-t3 xy-fs13">'+
													'<dt id="content" class="textAdd">'+data[i].content+'</dt>'+
												'</ol>'+
											'</div>'+
										'</a>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div><!-- timeline-item结束	 -->'; 			 	
	}
	if(endId&&endId !== ''){
		fillDiv.append(messageDiv)
	}else{
		fillDiv.html(messageDiv);
	}
	
	$('.xy-tab-list_on .timeline-icon:eq(0)').addClass('blueDot');
	$('.line-normal-wrapper').width($(window).width()*0.75)
	$('.line-normal-msg').width($(window).width()*0.75-92)		
}
function monitorScroll(){
	$('.xy-tab-list_on .scrolly').scroll(function(){		
	  //输出垂直的滚动距离
	  var b = $(this).scrollTop(),  viewH =$(this).height(),//可见高度  
         contentH =$(this).get(0).scrollHeight;
	  //console.log(b);
	   $('.xy-tab-list_on .timeline-icon').each( function(i, e){
		 	 var a = $(this);
		 	 if(b > 120*i){
		 	 	a.addClass('blueDot');
		 	 }else {
		 	 	a.removeClass('blueDot');
		 	 	$('.xy-tab-list_on .timeline-icon:eq(0)').addClass('blueDot');
		 	 }
		});
		if(contentH - viewH - b <= 0) {
			var sortcode = $(this).find('.timeline-item:last').attr('sortcode'),
			fillDiv = $(this).find('.timeline'),endId=$(this).find('.timeline-item:last').attr('data-value');
			getData(sortcode,fillDiv,endId)					
		}
	});
}

		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>