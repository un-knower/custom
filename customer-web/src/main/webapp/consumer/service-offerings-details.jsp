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
		<title>净水器-服务方案详情</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
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
				<div class="weui-flex__item"><div class="xy-h1-title">实时服务方案详情</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b42">
				<div class="swiper-container ve-swiper-container height100">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">
								<div class="xy-layout-bar" flex="dir:top">
									<div class="xy-head-title xy-pad-lr10 xy-corner-0 bg-blue-02" flex="dir:left">
										<p class="xy-fs14"  flex-box="1" id="serHead">过程净化服务</p>
										<p class="xy-fs12" id="notice">通知时间：2017-05-09</p>
									</div>
									<div class="xy-pad-tb10 xy-border-box" flex-box="1" flex="dir:top">
										<div class="xy-border-box xy-pad-lr10" flex-box="1" flex="dir:left">
											<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG"><%-- <img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png" /> --%></p>
											<div class="xy-pad-l10" flex-box="1">
												<ol class="xy-pad-t3 xy-fs16" flex="dir:left">
													<dt>设备：</dt>
													<dd flex-box="1" id="equipName">净化系统</dd>
												</ol>
												<ol class="xy-pad-t3 xy-fs13" flex="dir:left">
													<dt>编号：</dt>
													<dd flex-box="1" id="equipCode">01988929</dd>
												</ol>
												<ol class="xy-fc-light-gray xy-fs13" flex="dir:left">
													<dt>备注：</dt>
													<dd flex-box="1" id="remark">制造、能源、医疗、通信</dd>
												</ol>
											</div>
										</div>
										<div class="xy-fwb-title xy-border-box xy-pad-10 xy-pad-b5">
											预警内容：我们拥有一流的软件产品设计、开发团队和一流的电气自动化工程师团队。
										</div>
										<div class="main-img-address xy-pad-lr10 xy-pad-t7">
											<a href="#" class="" flex="dir:left">
												<i class="icon-map icon-mini-map"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
												<div class="xy-mar-l5 xy-line-clamp xy-tal xy-fc-light-gray"  flex-box="1">
													成都市高兴西区天泉路200号 众创办公室茶水间 	
												</div>
											</a>
										</div>
									</div>
								</div><!--用户信息-->
								
								<div class="xy-layout-bar xy-mar-t10" flex-box="1" flex="dir:top">
									<div class="xy-head-title xy-pad-lr10 xy-corner-0 bg-blue-01" flex="dir:left">
										<p class="xy-fs14"  flex-box="1">服务方案</p>
										<p class="xy-fs12" id="status">待服务</p>
									</div>
									
									<div class="eva-con xy-pad-lr10 xy-pad-t10 xy-pad-b20 xy-fc-gray xy-height-1p xy-scrollY swiper-no-swiping" flex-box="1">
										<p id="serContent">
											补充评价：一、我们拥有一流的软件产品设计、开发团队和一流的电气自动化工程师团队。
二、我们将以国际化的运营理念，多年业界的从业经验和技术积累，持之以恒，自强不息，为广大用户提供更加优异的产品和服务。

										</p>
									</div>
								</div><!--信息-->
							</div>
						</div>
						<!--列表-->
					
						<div class="swiper-slide"> 
							
							<div class="swiper-container xy-swiper-container picLayout-swiper-container height100">
								
								<div class="xy-head-title bg-blue xy-pad-lr20 xy-mar-10">服务相关图片</div>
								<div class="swiper-wrapper" id="imgContainer">
									<div class="swiper-slide"> 
										<div class="main-img">
											<img src="${_staticPath}/resource/weuiWeb/img/pic-list.png" />
										</div>	
									</div><!--/列表-->
									<div class="swiper-slide"> 
										<div class="main-img">
											<img src="${_staticPath}/resource/weuiWeb/img/pic-list.png" />
										</div>	
									</div><!--/列表-->
									<div class="swiper-slide"> 
										<div class="main-img">
											<img src="${_staticPath}/resource/weuiWeb/img/pic-list.png" />
										</div>	
									</div><!--/列表-->
									<div class="swiper-slide"> 
										<div class="main-img">
											<img src="${_staticPath}/resource/weuiWeb/img/pic-list.png" />
										</div>	
									</div><!--/列表-->
									<div class="swiper-slide"> 
										<div class="main-img">
											<img src="${_staticPath}/resource/weuiWeb/img/pic-list.png" />
										</div>	
									</div><!--/列表-->
								</div>
							</div>
							<div class="swiper-pagination swiper-pagination-fraction xy-swiper-pagination xy-swiper-paginationB0">&nbsp;</div>
							
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
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
			}
			function showStatu(){
			}
			$(function(){
				//获取地址栏参数				
				function GetQueryString(name){
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  decodeURI(r[2]); return null;
				}
				fillContent(GetQueryString('serveId'))
			})
			function fillContent(serveId){
				//获取数据
				$.ajax({
					type:'get',
					url:_path+'/consumer/service/getPlan?serCode='+serveId,
					success : function(msg){
						console.log(msg);
						if(msg.data){
							$('#serHead').html(msg.data.serHead);
							$('#equipCode').html(msg.data.equipCode);
							$('#notice').html(msg.data.notice);
							$('#remark').html(msg.data.remark.slice(0,12)+'……');
							$('#equipName').html(msg.data.equipName);
							$('.xy-fwb-title').html('预警内容： '+msg.data.warnContent);
							$('.xy-mar-l5').html(msg.data.adress);
							$('#status').html(msg.data.status);
							$('#serContent').html(msg.data.serContent);
							$('.xy-full-widthIMG').html('<img src="${_staticPath}'+msg.data.image+'" />');
							drawImg(msg.data.images);
							}						
						}
				});
			}
			function drawImg(imgData){
				//console.log(imgData);
				var imgDiv='';
				for(var i=0,len=imgData.length;i<len;i++){
					imgDiv +=  '<div class="swiper-slide">'+
									'<div class="main-img">'+
										'<img src="${_staticPath}'+imgData[i]+'" />'+
									'</div>	'+
								'</div>';
				}
				$('#imgContainer').html(imgDiv);
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>