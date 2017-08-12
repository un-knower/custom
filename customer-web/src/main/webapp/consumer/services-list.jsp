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
		<title>净水器-设备管理</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css"/>
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
		<link rel="stylesheet" type="text/css" href="${_path}/css/base.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<style>
		.jianbian{background-image:linear-gradient(to top,#fff 30%,#3792fb 60%);}
		.spanLine{width: 1.5px; margin-top: 10px; color: #2E8DFB;} 
		.width100{width:100%;}  
		.marginb03{ margin-bottom: 0.3em;} 
		.margint02{margin-top: 0.2em; width: 13px;}
		.margint02 img{width: 13px;}
		.scrolly{ overflow: hidden; overflow-y: scroll;}
		.border1{border: 1px solid #fafafa;}
		 @media screen and (max-height:526px){
		/*  .xy-waveBox{height:71px;} */
		}
		.pj{position: absolute;left: 75%;top: 0;}.pj2{left: 83%;}
		.timeline .timeline-item .blueDot{background: #71affa;box-shadow: 0px 0px 5px 3px rgba(132, 210, 249, 0.52);}
	</style>
	<body ontouchstart>
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title"><span>胡先生</span>家的服务方案</div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini xy-btn-search"></a>
				</div>
			</div><!--/header-->
		
			<div class="page__bd xy-container xy-white-bg">
				<div class="weui-tab xy-border-box xy-pad-tb10">
					<div class="weui-tabbar xy-tabbar bg-white">
						<a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
							<p class="weui-tabbar__label">实时服务方案</p>
						</a>
						<a href="javascript:;" class="weui-tabbar__item">
							<p class="weui-tabbar__label">历史服务记录</p>
						</a>
					</div><!--/tab 导航-->
					<div class="weui-tab__panel xy-tab__panel xy-scrollH" >
						<div class="xy-tab-list xy-tab-list_on">
							<div class="swiper-container ve-swiper-container height100">
								<div class="swiper-wrapper">
									<div class="swiper-slide">
										<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">
											<div class="xy-layout-bar xy-query xy-query-other" flex="dir:top">
												<div class="xy-head-title xy-pad-lr10 xy-corner-0 bg-blue-01" flex="dir:left">
													<p class="xy-fs18"  flex-box="1">过程净化服务</p>
													<p class="xy-fs12">通知时间：2017-05-09</p>
												</div>
												<div class="xy-pad-tb10 xy-border-box bg-blue-01" flex-box="1" flex="dir:top" style="background-image:linear-gradient(to top,#fff 10%,#3792fb 30%);color:#fff;">
													<div class="xy-border-box xy-pad-lr10 weui-cell weui-cell_access xy-linlk-listview" flex-box="1" flex="dir:left">
														<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="" /></p>
														<div class="xy-pad-l10 xy-pad-t3" flex-box="1">
															<ol class="xy-pad-t3 xy-fs18" flex="dir:left">
																<dt>预警内容</dt>
																<dd flex-box="1"></dd>
															</ol>
															<ol class="xy-pad-t3 xy-fs13" flex="dir:left">
																<dd flex-box="1" id="warnContent">QT20170212</dd>
															</ol>
															<ol class=" xy-fs13" flex="dir:left">
																<dt>备注：</dt>
																<dd flex-box="1">2017-05-30</dd>
															</ol>
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
															<p class="xy-fs12" id="time">服务时间：2017.5.5</p>
														</div>											
														<div class="eva-con xy-pad-lr10  xy-fc-gray" flex-box="1" style="padding-top: 1em;line-height:1.8em;">
															 <p id="serContent"></p> 
															<!-- <p id="">复选框用input写即可,复选框用input写即可。															
															</p> -->
														</div>
													</div>
													<div class="main-img-address xy-pad-lr10 xy-pad-t7" style="background:#fff">
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
									</div><!-- swiper-slide -->
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
								</div>	<!-- swiper-wrapper -->
							</div><!-- swiper-container -->
							<div class="swiper-button-prev xy-bottom_btnPrve" style="top: 103%;"></div>
							<div class="swiper-button-next xy-bottom_btnNext" style="top: 103%;"></div>
						</div>
						<div class="xy-tab-list">
							<div class="height100 xy-pad-lr10 xy-pad-t10 xy-border-box" flex="dir:top">	
								<div class="htmleaf-container height100">
									<div class="container height100 scrolly">
										<div class="timeline">
											<div class="timeline-item">
												<div class="timeline-icon">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="width100 xy-fll line-normal-wrapper">
																<a class="weui-cell weui-cell_access xy-linlk-listview" href="javascript:;">
																	<div class="weui-cell__bd xy-clearfix xy-mar-r5">
																		<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG xy-fll"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																		<div class="xy-db xy-mar-l85p">
																			<p class="xy-fs16 xy-pad-t2">检测内容解读</p>
																			<p class="xy-fc-light-gray xy-pad-t3 xy-fs13 xy-line-clamp2 xy-line-h20">
																				我们拥有一流的软件产品设计、开发团队和电气自动化工程师团队。
																			</p>
																		</div>
																	</div>
																	<div class="weui-cell__ft">
																	</div>
																</a>
																<div class="xy-fwb-title xy-border-box xy-pad-lr10 xy-pad-tb5 xy-clearfix">
																	<ol class="xy-fc-light-gray xy-fs13 xy-line-h22 xy-fll">
																		<dt class="xy-dibVat">服务评分:</dt>
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
																</div>
																<div class="main-img-address xy-pad-lr10">
																	<a href="#" class="" flex="dir:left">
																		<i class="icon-map margint02"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
																		<div class="xy-mar-l5 xy-line-clamp xy-tal xy-fc-light-gray"  flex-box="1">
																			成都市高兴西区天泉路200号 众创办公室茶水间 	
																		</div>
																	</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->
											<div class="timeline-item">
												<div class="timeline-icon blueDot">
												</div>
												<div class="timeline-content">
													<h3>2017.7.13 8:26</h3>
													<div class="line-wrapper">
														<div class="xy-border-box line-scroll-wrapper xy-clearfix">
															<div class="width100 xy-fll line-normal-wrapper">
																<a class="weui-cell weui-cell_access xy-linlk-listview" href="javascript:;">
																	<div class="weui-cell__bd xy-clearfix xy-mar-r5">
																		<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG xy-fll"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
																		<div class="xy-db xy-mar-l85p">
																			<p class="xy-fs16 xy-pad-t2">检测内容解读</p>
																			<p class="xy-fc-light-gray xy-pad-t3 xy-fs13 xy-line-clamp2 xy-line-h20">
																				我们拥有一流的软件产品设计、开发团队和电气自动化工程师团队。
																			</p>
																		</div>
																	</div>
																	<div class="weui-cell__ft">
																	</div>
																</a>
																<div class="xy-fwb-title xy-border-box xy-pad-lr10 xy-pad-tb5 xy-clearfix">
																	<ol class="xy-fc-light-gray xy-fs13 xy-line-h22 xy-fll">
																		<dt class="xy-dibVat">服务评分:</dt>
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
																</div>
																<div class="main-img-address xy-pad-lr10">
																	<a href="#" class="" flex="dir:left">
																		<i class="icon-map margint02"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
																		<div class="xy-mar-l5 xy-line-clamp xy-tal xy-fc-light-gray"  flex-box="1">
																			成都市高兴西区天泉路200号 众创办公室茶水间 	
																		</div>
																	</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div><!-- timeline-item结束	 -->			
										</div>
									</div>
								</div>																	
							</div>
						</div><!-- xy-tab-list -->
					</div><!--weui-tab__panel 内容-->
				</div><!--weui-tab 内容-->
			</div><!--/ container -->								
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/swiper.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper-vertical.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
			}
			getPlanList();//画实时服务列表
			function getPlanList(){
				//var equipCode='';
				//获取地址栏参数				
				/* function GetQueryString(name){
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  decodeURI(r[2]); return null;
				} */
				//GetQueryString('equipCode')?equipCode=GetQueryString('equipCode'):equipCode='';
				var serveId = 0;//此处需要后台定义，为空时拉置顶设备方案？？？
				$.ajax({
					type:'get',
					url:_path+'/consumer/service/getPlan?serCode='+serveId,
					success : function(msg){
						console.log(msg);
						if(msg.data){
							$('#serHead').html(msg.data.serHead);
							//$('#equipCode').html(msg.data.equipCode);
							$('#notice').html('通知时间：'+msg.data.notice.slice(0,11));
							$('#remark').html(msg.data.remark.slice(0,12)+'……');
							//$('#equipName').html(msg.data.equipName);
							$('#warnContent').html(msg.data.warnContent);
							$('.xy-mar-l5').html(msg.data.adress);
							$('#status').html(msg.data.status);
							$('#serContent').html(msg.data.serContent.slice(0,20)+'……');
							$('.xy-full-widthIMG').html('<img src="${_staticPath}'+msg.data.image+'" />');
							drawImg(msg.data.images);
							}						
						}
				});
			}			
			$(function(){													
								
				$('.weui-tabbar__item').on('click', function () {
					$(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
					var thisNum = $(this).index();
					console.log(thisNum);
					$('.xy-tab-list').eq(thisNum).addClass('xy-tab-list_on').siblings('.xy-tab-list_on').removeClass('xy-tab-list_on');
					if($('.xy-tab-list').eq(1).hasClass('xy-tab-list_on')){
						$('.page__bd').css('padding-bottom', '0');
						getHisList();//画历史服务列表
					} else{
						$('.page__bd').css('padding-bottom', '55px');
					} 
				});	
				//点击查看详情(历史)
				$('body').on('click','.goHisDetail',function(){//列表点击事件跳转
					var thisEvalue = $(this).parents('.timeline-item').attr('evalue'),thisId=$(this).parents('.timeline-item').attr('serveId');
					if(thisEvalue == 'true'){
						sessionStorage.setItem('ifel',2);//跳转页面，公用一个详情页，设假数据为2，若2 ==》 跳转页面隐藏评价按钮 不可评价";
					}else if(thisEvalue == 'false'){
						sessionStorage.setItem('ifel',1);//跳转页面，公用一个详情页，设假数据为1，若1 ==》 跳转页面显示评价按钮 可评价";
					}
					window.location.href =_path+"/consumer/services-details.jsp?serveId="+thisId;
				});
				//跳转到评价
				$('body').on('click','#goRecord',function(){					
					var thisId=$(this).parents('.timeline-item').attr('serveId');
					window.location.href =_path+"/consumer/evaluate.jsp?serveId="+thisId;
				});
			})
			function getHisList(){
				$.ajax({
					type:'get',
					url:_path+'/consumer/service/listHis',
					//data: {equipId:''},
					success : function(r){
						console.log(r);
						if(r){
							drawList(r.data);								
							}						
						}
					});
			}
			function drawList(data){
				//alert('234344');
				var listDiv = '';
				for (var i in data){
				 	listDiv += '<div class="timeline-item" serveId="'+data[i].serCode+'" evalue="'+data[i].evaFlag+'">'+
									'<div class="timeline-icon" >'+
									'</div>'+
									'<div class="timeline-content">'+
										'<h3>'+data[i].time+'</h3>'+
										'<div class="line-wrapper">'+
											'<div class="xy-border-box line-scroll-wrapper xy-clearfix">'+
												'<div class="width100 xy-fll line-normal-wrapper">'+
													'<a class="weui-cell weui-cell_access xy-linlk-listview" href="javascript:;">'+
														'<div class="weui-cell__bd xy-clearfix xy-mar-r5 goHisDetail">'+
															'<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG xy-fll"><img src="${_staticPath}'+data[i].image+'" /></p>'+
															'<div class="xy-db xy-mar-l85p">'+
																'<p class="xy-fs16 xy-pad-t2">'+data[i].serHead+'</p>'+
																'<p class="xy-fc-light-gray xy-pad-t3 xy-fs13 xy-line-clamp2 xy-line-h20">'+
																	''+data[i].serContent+''+
																'</p>'+
															'</div>'+
														'</div>'+
														'<div class="weui-cell__ft">'+
														'</div>'+
													'</a>'+
													'<div class="xy-fwb-title xy-border-box xy-pad-lr10 xy-pad-tb5 xy-clearfix">'+
														'<ol class="xy-fc-light-gray xy-fs13 xy-line-h22 xy-fll xy-dibVamImg">';
					if(data[i].evaFlag==true)	{								
												listDiv +=	'<dt class="xy-dibVat">服务评分:</dt>'+
															'<dd class="xy-dibVat">'+
																'<div class="xy-star-bar xy-mini-star xy-pad-t2 xy-dibVat">'+
																	'<div class="xy-emptys"></div>';
																for(var j=0;j<5;j++){
																	if(j<data[i].rank) //有星星
																		listDiv+='<i class="icon-star xy-dibVat on"></i>';
																	else //无星星
																		listDiv+='<i class="icon-star xy-dibVat"></i>';
																} 
														listDiv+='</div><!--/星星-->'+
															'</dd>'+
															'<span class="pj pj2"><a style="color: #ccc;text-decoration: none;">已评价</a></span>';
												}else{
													 listDiv += '<span class="pj"><img src="${_staticPath}/resource/weuiWeb/img/pen.png" style="width:31%"><a id="goRecord" style="color: #2a85ca;text-decoration: none;">待评价</a></span>';
												}
											listDiv +='</ol>'+
													'</div>'+
													'<div class="main-img-address xy-pad-lr10">'+
														'<a href="#" class="" flex="dir:left">'+
															'<i class="icon-map margint02"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>'+
															'<div class="xy-mar-l5 xy-line-clamp xy-tal xy-fc-light-gray"  flex-box="1">'+
																''+data[i].adress+' '+	
															'</div>'+
														'</a>'+
													'</div>'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div><!-- timeline-item结束	 -->';
				}
				$('.timeline').html(listDiv);
				$('.timeline-icon:eq(0)').addClass('blueDot');
			}
			$('.scrolly').scroll(function(){
			  //输出垂直的滚动距离
			  var b = $(this).scrollTop();
			  //console.log( $(this).scrollTop() );
			   $('.timeline-icon').each( function(i, e){
				 	 var a = $(this);
				 	 if(b > 154*i){
				 	 	a.addClass('blueDot');
				 	 }else {
				 	 	a.removeClass('blueDot');
				 	 	$('.timeline-icon:eq(0)').addClass('blueDot');
				 	 }
				});
			});			
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