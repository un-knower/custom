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
		<title>净水器-服务评价查看</title>
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
				<div class="weui-flex__item"><div class="xy-h1-title">木木家的服务评价查看</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b42">
				<div class="swiper-container ve-swiper-container height100">
					<div class="swiper-wrapper">
						<!--------------- swiper-slide ---------------->
						<div class="swiper-slide"> 
							
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">
								<div class="xy-layout-bar xy-query" flex="dir:top">
									<div class="xy-head-title xy-pad-lr10 xy-corner-0 bg-blue-02" flex="dir:left">
										<p class="xy-fs14"  flex-box="1" id="serHead">过程净化服务</p>
										<p class="xy-fs12" id="notice">通知时间：2017-05-09</p>
									</div>
									<div class="xy-pad-tb10 xy-border-box" flex-box="1" flex="dir:top">
										<div class="xy-border-box xy-tac" flex-box="1">
											<div class="xy-dibVat">
												<p class="mini-lovely width100"><%-- <img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /> --%></p>
												<p class="xy-pad-t3 xy-fs16" id="empName">蒙奇浩浩</p>
												<p class="xy-pad-t3 xy-fc-light-gray xy-fs12" id="time">服务时间：2017-05-30</p>
												<div class="xy-star-bar xy-mini-star xy-tac xy-pad-lr10 xy-pad-t5">
													<div class="xy-emptys"></div>
													<i class="icon-star xy-dibVat on"></i>
													<i class="icon-star xy-dibVat on"></i>
													<i class="icon-star xy-dibVat on"></i>
													<i class="icon-star xy-dibVat on"></i>
													<i class="icon-star xy-dibVat"></i>
												</div><!--/星星-->
											</div>
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
								
								<div class="xy-layout-bar xy-mar-t10 xy-border-box xy-pad-b10 xy-pad-t5 xy-query-bottom" flex-box="1" flex="dir:top">
									<div class="select-menubar xy-clearfix xy-pad-lr5">
										<a href="javascript:;" class="select-menubar__item select-menubar__item_on">
											<p class="select-menubar__label">专业</p>
										</a>
										<a href="javascript:;" class="select-menubar__item select-menubar__item_on">
											<p class="select-menubar__label">高效</p>
										</a>
										<a href="javascript:;" class="select-menubar__item">
											<p class="select-menubar__label">礼貌</p>
										</a>
										<a href="javascript:;" class="select-menubar__item">
											<p class="select-menubar__label">细心</p>
										</a>
										<a href="javascript:;" class="select-menubar__item">
											<p class="select-menubar__label">不专业</p>
										</a>
										<a href="javascript:;" class="select-menubar__item">
											<p class="select-menubar__label">拖拉</p>
										</a>
										<a href="javascript:;" class="select-menubar__item">
											<p class="select-menubar__label">粗鲁</p>
										</a>
										<a href="javascript:;" class="select-menubar__item">
											<p class="select-menubar__label">粗心</p>
										</a>
									</div><!--/评价 head-->
									<div class="eva-con xy-pad-b5 xy-mar-t3 xy-fc-gray xy-pad-lr10 xy-height-1p xy-scrollY swiper-no-swiping" flex-box="1">
										<p id="textContent">
										</p>
									</div>
								</div><!--评价信息-->
							</div>
						</div>
						<!--/列表-->
						<!--------------- swiper-slide ---------------->
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
						<!--/列表-->
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
					url:_path+'/consumer/service/getHis?serCode='+serveId,
					success : function(msg){
						console.log(msg);
						if(msg.data){
							$('.xy-h1-title').html(msg.data.equipName+'家的服务评价查看');
							$('#empName').html(msg.data.empName);
							$('#adress').html(msg.data.adress);
							$('#empCode').html(msg.data.empCode);
							$('#serHead').html(msg.data.serHead);
							$('#equipName').html(msg.data.equipName);
							$('#status').html(msg.data.status);
							$('#time').html('服务时间：'+msg.data.time.slice(0,10));
							$('#notice').html('通知时间：'+msg.data.notice.slice(0,10));
							$('#serContent').html(msg.data.serContent);
							$('#textContent').html('我是文字评价！！');//此处数据需要后台添加
							$('.mini-lovely').html('<img src="${_staticPath}'+msg.data.portrait+'" />');
							drawImg(msg.data.images);
							drawStar(msg.data.rank);
							drawTags(msg.data.evaContent);
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
			function drawStar(rank){
				var starDiv ='',tag=[];
				for(var j=0;j<5;j++){
					if(j<rank) //有星星
						starDiv+='<i class="icon-star xy-dibVat on"></i>';
					else //无星星
						starDiv+='<i class="icon-star xy-dibVat"></i>';
				}
				$('.xy-star-bar').html(starDiv);
			}
			function drawTags(evaContent){
				var cardDiv='';
				console.log(evaContent);
				for(var i=0,len=evaContent.length;i<len; i++){
					cardDiv +=  '<a href="javascript:;" class="select-menubar__item select-menubar__item_on" tagId="'+evaContent[i].id+'">'+
									'<p class="select-menubar__label">'+evaContent[i].tagName+'</p>'+
								'</a>';
				}
				$('.select-menubar').html(cardDiv);
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>