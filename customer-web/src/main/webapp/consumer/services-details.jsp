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
		<title>净水器-服务详情</title>
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
		.jianbian{background-image:linear-gradient(to top,#fff 30%,#3792fb 60%);} 
		.marginb03{ margin-bottom: 0.3em;} 
		.xy-linlk-listview.paddingt{padding: 0 1em 0 2em;}
		.colorfff{color:#fff;}
		.border1{border: 1px solid #fafafa;}
		/* @media screen and (max-width: 340px) {
		 .xy-waveBox{height:80px;}
		}
		@media screen and (min-width: 375px) {
		 .xy-waveBox{height:60px;}
		} */
	</style>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">木木家的服务详情</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b42">
				<div class="swiper-container ve-swiper-container height100">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">
								<div class="xy-layout-bar xy-query xy-query-other" flex="dir:top">
									<div class="xy-head-title xy-pad-lr10 xy-corner-0 bg-blue-01" flex="dir:left">
										<p class="xy-fs18"  flex-box="1">过程净化服务</p>
										<p class="xy-fs12">通知时间：2017-05-09</p>
									</div>
									<div class="xy-pad-tb10 xy-border-box jianbian" flex-box="1" flex="dir:top">
										<div class="xy-border-box xy-pad-lr10 weui-cell weui-cell_access xy-linlk-listview paddingt colorfff" flex-box="1" flex="dir:left">
											<p class="mini-lovely xy-full-widthIMG xy-tac" style="width:25%"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif"/></p>
											<div class="xy-pad-l10 xy-pad-t3" flex-box="1">
												<h3 id="empName"></h3>
												<ol class="xy-pad-t3 xy-fs16" flex="dir:left" id="rank">
													<dt class="xy-dibVat">综合评分:</dt>
													<dd class="xy-dibVat">
														<div class="xy-star-bar xy-mini-star xy-pad-t2 xy-dibVat">
															<div class="xy-emptys"></div>
															<i class="icon-star xy-dibVat on"></i>
															<i class="icon-star xy-dibVat on"></i>
															<i class="icon-star xy-dibVat on"></i>
															<i class="icon-star xy-dibVat on"></i>
															<i class="icon-star xy-dibVat"></i>
														</div><!--/星星-->
													</dd>					
												</ol>
												<ol class="xy-pad-t3 xy-fs13" flex="dir:left">
													<dt class="xy-dibVat">工号：</dt>
													<dd class="xy-dibVat" id="empCode"></dd>													
												</ol>
												<ol class="xy-pad-t3 xy-fs13" flex="dir:left">
													<dt class="xy-dibVat" style="width:150%" id="tag">专业、高效</dt>
													<dd class="xy-dibVat xy-tar" id="recordBtn"><img src="${_staticPath}/resource/weuiWeb/img/pen.jpg" style="width:30%;vertical-align: middle;"><a id="goRecord" style="color: #fff;text-decoration: none;">待评价</a></dd>
												</ol>	
											</div>
											<div class="weui-cell__ft">
											</div>
										</div>
										<div class="xy-waveBox xy-line-h0 bg-blue-01">
											<div class="xy-wave" id="wave1"></div>
											<div class="xy-wave" id="wave2"></div>
											<div class="xy-wave" id="wave3"></div>
										</div>
										<div style="background-image:linear-gradient(to top,#fff,#CBE2FE);">
											<div class=" xy-pad-lr10 xy-corner-0 xy-head-title" flex="dir:left" style="border:none;box-shadow:none;color:#666666;font-weight: 800;">
												<p class="xy-fs18"  flex-box="1" id="">服务方案</p>
												<p class="xy-fs12" id="time"></p>
											</div>											
											<div class="eva-con xy-pad-lr10  xy-fc-gray" flex-box="1" style="padding-top: 1em;line-height:1.8em;">
												<p id="serContent">
													一、我们拥有一流的软件产品设计、开发团队和一流的电气自动化工程师团队。<br>
													二、我们将以国际化的运营理念，多年业界的从业经验和技术积累，持之以恒，自强不息，为广大用户提供更加优异的产品和服务。<br>
													三、我们将以国际化的运营理念，多年业界的从业经验和技术积累，持之以恒，自强不息，为广大用户提供更加优异的产品和服务。<br>
		
												</p>
											</div>																						
										</div>
										<div class="main-img-address xy-pad-lr10 xy-pad-t7" style="">
											<a href="#" class="" flex="dir:left">
												<i class="icon-map icon-mini-map"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
												<div class="xy-mar-l5 xy-line-clamp xy-tal xy-fc-light-gray"  flex-box="1">
													成都市高兴西区天泉路200号 众创办公室茶水间 	
												</div>
											</a>
										</div>	
									</div>
								</div><!--用户信息-->																					
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
			<div class="xy-poab-menuBottom"><a href="#" class="xy-db xy-fc-white xy-tac xy-border-box xy-pad-t9">评价</a></div>
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
			function bindEvent(serveId){
				$('#recordBtn').click(function(){
					window.location.href =_path+"/consumer/evaluate.jsp?serveId="+serveId;
				});
				
			}
			$(function(){
				//获取地址栏参数				
				function GetQueryString(name){
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  decodeURI(r[2]); return null;
				}
								
				//传来的值若1 ==》历史服务记录列表 ==》显示评价按钮 有评价入口;
				//传来的值 若2==》实时服务方案==》隐藏评价按钮 无评价入口;
				var ifel = sessionStorage.getItem('ifel');
				console.log(ifel);
				if(ifel==1){
					//未评价，隐藏右边按钮
					$('.xy-poab-menuBottom').hide();
					$('.weui-cell__ft').hide();
					$('#rank').hide();
					$('#tag').hide();
					$('.weui-cell__ft').hide();
				}else if(ifel==2){
					//评价了，显示右边按钮，跳转评价详情
					$('.xy-linlk-listview').click(function(){
						window.location.href =_path+"/consumer/evaluate-query.jsp?serveId="+GetQueryString('serveId');
					});
					$('.xy-poab-menuBottom').hide();
					$('#recordBtn').hide();
				}
				fillContent(GetQueryString('serveId'))
				bindEvent(GetQueryString('serveId'));
			})
			function fillContent(serveId){
				//获取数据
				$.ajax({
					type:'get',
					url:_path+'/consumer/service/getHis?serCode='+serveId,
					success : function(msg){
						console.log(msg);
						if(msg.data){
							$('.xy-h1-title').html(msg.data.equipName+'家的服务详情');
							$('#empName').html(msg.data.empName);
							$('#adress').html(msg.data.adress);
							$('#empCode').html(msg.data.empCode);
							$('#serHead').html(msg.data.serHead);
							$('#equipName').html(msg.data.equipName);
							$('#status').html(msg.data.status);
							$('#time').html('服务时间：'+msg.data.time.slice(0,10));
							$('#notice').html('通知时间：'+msg.data.notice.slice(0,10));
							$('#serContent').html(msg.data.serContent);
							$('.xy-full-widthIMG').html('<img src="${_staticPath}'+msg.data.portrait+'" />');
							drawImg(msg.data.images);
							drawStar(msg.data.evaContent,msg.data.rank);
							$('#cord').html('3.0');//此处需要后台传值
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
			function drawStar(evaContent,rank){
				var starDiv ='',tag=[];
				for(var j=0;j<5;j++){
					if(j<rank) //有星星
						starDiv+='<i class="icon-star xy-dibVat on"></i>';
					else //无星星
						starDiv+='<i class="icon-star xy-dibVat"></i>';
				}
				$('.xy-star-bar').html(starDiv);
				$.each(evaContent,function(i,n){
					tag.push(evaContent[i].tagName)
				})
				$('#tag').html(tag.join(' ').slice(0,11)+'……');
			}
			</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>