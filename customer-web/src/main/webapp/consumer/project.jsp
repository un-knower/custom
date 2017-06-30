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
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart>
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">设备管理</div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini xy-btn-search"></a>
				</div>
			</div><!--/header-->
		
			<div class="page__bd xy-container xy-white-bg">
				<div class="weui-tab xy-border-box xy-pad-tb10">
					<div class="weui-tabbar xy-tabbar bg-white">
						<a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
							<p class="weui-tabbar__label">我的设备</p>
						</a>
						<a href="javascript:;" class="weui-tabbar__item">
							<p class="weui-tabbar__label">我关注的设备</p>
						</a>
					</div><!--/tab 导航-->
					<div class="weui-tab__panel xy-tab__panel xy-scrollH">
						<div class="xy-tab-list xy-tab-list_on">
							
							<div class="swiper-container xy-swiper-container height100 xy-border-box xy-pad-b45p">
								<div class="swiper-wrapper">
									<%--<div class="swiper-slide"> 
										<div class="height100" flex="dir:top">
											<div class="main-img" flex-box="1">
												<div class="height100" flex="dir:top main:justify">
													<h1 class="sub-title">设备-净水系统</h1><!--标题-->
													<div flex-box="1" flex="dir:top main:justify">
														<div class="main-img-con xy-pad-tb7 width100 xy-scrollY" flex-box="1" flex="dir:top main:justify" onclick="window.location.href='page-project-list.html'">
															<p class="pic-lovely"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png"></p>
															<h5 class="sub-title">设备-净水系统</h5>
															<div class="main-img-device xy-clearfix xy-pad-t5 xy-pad-b5">
																<li>
																	<p>TDS纯净水值</p>
																	<p>1</p>
																</li>
																<li>
																	<p>监测次数</p>
																	<p>7</p>
																</li>
																<li>
																	<p>服务次数</p>
																	<p>8</p>
																</li>
															</div>
															<div class="main-img-service xy-pad-t7 xy-border-t width100" flex-box="1" flex="main:center cross:center">
																<div>
																	<p class="xy-tac">剩余服务时长</p>
																	<p class="xy-timer xy-tac">111:11:11</p>
																	<p class="xy-fs12 xy-fc-red xy-line-h20 xy-pad-t2 xy-pad-lr10 xy-line-clamp2">		
																		净水设备快到维护期了，建议及时更换第五级滤芯
																	</p>
																</div>
															</div>
														</div>
													</div><!--内容-->
													<div class="main-img-address xy-pad-lr10 xy-pad-tb7 xy-border-t">
														<a href="#" class="" flex="dir:left">
															<i class="icon-map" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
															<div class="xy-mar-l10 xy-font-address"  flex-box="1">
																成都市高兴西区天泉路200号 众创办公室茶水间 	
															</div>
														</a>
													</div><!--地址-->
												</div>
											</div>
										</div>
									</div><!--/列表-->
									<div class="swiper-slide"> 
										<div class="height100" flex="dir:top">
											<div class="main-img" flex-box="1">
												<div class="height100" flex="dir:top main:justify">
													<h1 class="sub-title">设备-净水系统</h1><!--标题-->
													<div flex-box="1" flex="dir:top main:justify">
														<div class="main-img-con xy-pad-tb7 width100" flex-box="1" flex="dir:top main:justify" onclick="window.location.href='page-project-list.html'">
															<p class="pic-lovely"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png"></p>
															<h5 class="sub-title">项目-净水系统</h5>
															<div class="main-img-device xy-clearfix xy-pad-t5 xy-pad-b5">
																<li>
																	<p>TDS纯净水值</p>
																	<p>1</p>
																</li>
																<li>
																	<p>监测次数</p>
																	<p>7</p>
																</li>
																<li>
																	<p>服务次数</p>
																	<p>8</p>
																</li>
															</div>
															<div class="main-img-service xy-pad-t7 xy-border-t width100" flex-box="1" flex="main:center cross:center">
																<div>
																	<p class="xy-tac">剩余服务时长</p>
																	<p class="xy-timer xy-tac">222:22:22</p>
																</div>
															</div>
														</div>
													</div><!--内容-->
													<div class="main-img-address xy-pad-lr10 xy-pad-tb7 xy-border-t">
														<a href="#" class="" flex="dir:left">
															<i class="icon-map" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
															<div class="xy-mar-l10 xy-font-address"  flex-box="1">
																成都市高兴西区天泉路200号 众创办公室茶水间 	
															</div>
														</a>
													</div><!--地址-->
												</div>
											</div>
										</div>
									</div><!--/列表-->
									 <div class="swiper-slide"> 
										<div class="height100" flex="dir:top">
											<div class="main-img" flex-box="1">
												<div class="height100" flex="dir:top main:justify">
													<h1 class="sub-title">设备-净水系统</h1><!--标题-->
													<div flex-box="1" flex="dir:top main:justify">
														<div class="main-img-con xy-pad-tb7 width100" flex-box="1" flex="dir:top main:justify" onclick="window.location.href='page-project-list.html'">
															<p class="pic-lovely"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png"></p>
															<h5 class="sub-title">项目-净水系统</h5>
															<div class="main-img-device xy-clearfix xy-pad-t5 xy-pad-b5">
																<li>
																	<p>TDS纯净水值</p>
																	<p>1</p>
																</li>
																<li>
																	<p>监测次数</p>
																	<p>7</p>
																</li>
																<li>
																	<p>服务次数</p>
																	<p>8</p>
																</li>
															</div>
															<div class="main-img-service xy-pad-t7 xy-border-t width100" flex-box="1" flex="main:center cross:center">
																<div>
																	<p class="xy-tac">剩余服务时长</p>
																	<p class="xy-timer xy-tac">333:33:33</p>
																</div>
															</div>
														</div>
													</div><!--内容-->
													<div class="main-img-address xy-pad-lr10 xy-pad-tb7 xy-border-t">
														<a href="#" class="" flex="dir:left">
															<i class="icon-map" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
															<div class="xy-mar-l10 xy-font-address"  flex-box="1">
																成都市高兴西区天泉路200号 众创办公室茶水间 	
															</div>
														</a>
													</div><!--地址-->
												</div>
											</div>
										</div>
									</div><!--/列表-->
									<div class="swiper-slide"> 
										<div class="height100" flex="dir:top">
											<div class="main-img" flex-box="1">
												<div class="height100" flex="dir:top main:justify">
													<h1 class="sub-title">设备-净水系统</h1><!--标题-->
													<div flex-box="1" flex="dir:top main:justify">
														<div class="main-img-con xy-pad-tb7 width100" flex-box="1" flex="dir:top main:justify" onclick="window.location.href='page-project-list.html'">
															<p class="pic-lovely"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png"></p>
															<h5 class="sub-title">项目-净水系统</h5>
															<div class="main-img-device xy-clearfix xy-pad-t5 xy-pad-b5">
																<li>
																	<p>TDS纯净水值</p>
																	<p>1</p>
																</li>
																<li>
																	<p>监测次数</p>
																	<p>7</p>
																</li>
																<li>
																	<p>服务次数</p>
																	<p>8</p>
																</li>
															</div>
															<div class="main-img-service xy-pad-t7 xy-border-t width100" flex-box="1" flex="main:center cross:center">
																<div>
																	<p class="xy-tac">剩余服务时长</p>
																	<p class="xy-timer xy-tac">444:44:44</p>
																</div>
															</div>
														</div>
													</div><!--内容-->
													<div class="main-img-address xy-pad-lr10 xy-pad-tb7 xy-border-t">
														<a href="#" class="" flex="dir:left">
															<i class="icon-map" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
															<div class="xy-mar-l10 xy-font-address"  flex-box="1">
																成都市高兴西区天泉路200号 众创办公室茶水间 	
															</div>
														</a>
													</div><!--地址-->
												</div>
											</div>
										</div>
									</div><!--/列表-->
									<div class="swiper-slide">
										<div class="height100" flex="dir:top">
											<div class="main-img" flex-box="1">
												<div class="height100" flex="dir:top main:justify">
													<h1 class="sub-title">设备-净水系统</h1><!--标题-->
													<div flex-box="1" flex="dir:top main:justify">
														<div class="main-img-con xy-pad-tb7 width100" flex-box="1" flex="dir:top main:justify" onclick="window.location.href='page-project-list.html'">
															<p class="pic-lovely"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.png"></p>
															<h5 class="sub-title">项目-净水系统</h5>
															<div class="main-img-device xy-clearfix xy-pad-t5 xy-pad-b5">
																<li>
																	<p>TDS纯净水值</p>
																	<p>1</p>
																</li>
																<li>
																	<p>监测次数</p>
																	<p>7</p>
																</li>
																<li>
																	<p>服务次数</p>
																	<p>8</p>
																</li>
															</div>
															<div class="main-img-service xy-pad-t7 xy-border-t width100" flex-box="1" flex="main:center cross:center">
																<div>
																	<p class="xy-tac">剩余服务时长</p>
																<p class="xy-timer xy-tac">555:55:55</p>
																</div>
															</div>
														</div>
													</div><!--内容-->
													<div class="main-img-address xy-pad-lr10 xy-pad-tb7 xy-border-t">
														<a href="#" class="" flex="dir:left">
															<i class="icon-map" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>
															<div class="xy-mar-l10 xy-font-address"  flex-box="1">
																成都市高兴西区天泉路200号 众创办公室茶水间 	
															</div>
														</a>
													</div><!--地址-->
												</div>
											</div>
										</div>
									</div> --%><!--/列表-->
								</div>
							</div>
							<div class="swiper-pagination swiper-pagination-fraction xy-swiper-pagination">&nbsp;</div>
						</div>
					</div><!--/tab 内容-->
				</div>
			</div>
			<!--/ container -->
			
			<div class="weui-footer weui-footer_fixed-bottom xy-footer">
				<div class="xy-pad-lr10 xy-clearfix">
					<div class="xy-fll xy-switchCp-bar" id="switchBox">
						<input hidden="hidden" id="btn" name="btn1" type="radio" value="off" checked="checked" />
						<label for="switchCP" class="weui-switch-cp">
							<input id="switchCP" class="weui-switch-cp__input" type="checkbox">
							<div class="weui-switch-cp__box xy-tac">
								<div class="xy-dib xy-lock-off">
									<span class="xy-dibVat"><img src="${_staticPath}/resource/weuiWeb/img/icon-lock-off.png" /></span>
									<span class="xy-dibVat xy-pad-l3 xy-fs16">私有</span>
								</div>
								<div class="xy-dib xy-lock-on xy-hide">
									<span class="xy-dibVat"><img src="${_staticPath}/resource/weuiWeb/img/icon-lock-on.png" /></span>
									<span class="xy-dibVat xy-pad-l3 xy-fs16">公开</span>
								</div>
							</div>
						</label>
					</div>
					<a href="javascript:;" class="weui-btn weui-btn_primary xy-btn_del xy-fll xy-dn" id="xy-btn_del"><i class="xy-icon xy-dibVam icon-del"></i>删除</a>
					<a href="javascript:;" class="weui-btn weui-btn_primary xy-btn_setTop xy-fll" id="xy-btn_setTop"><i class="xy-icon xy-dibVam icon-set-top"></i>置顶</a>
				</div>
			</div>
			<!--/ footer -->
			
			<!--删除确认 弹窗-->
			<div id="dialogs">
				<!--确认删除？弹窗-->
				<div class="js_dialog" id="iosDialog1" style="display:none">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__bd">
							<p class="icon-dialog-bar"><img src="${_staticPath}/resource/weuiWeb/img/icon-question-mark.png" /></p>
							<p class="xy-fs16 xy-fc-white xy-pad-t3">您确认删除该设备？</p>
						</div>
						<div class="xy-waveBox xy-line-h0">
							<div class="xy-wave" id="wave1"></div>
							<div class="xy-wave" id="wave2"></div>
							<div class="xy-wave" id="wave3"></div>
						</div>
						<div class="weui-dialog__ft">
							<div class="xy-pad-lr10 xy-pad-b10 bg-blue-opacity xy-border-box width100" flex="dir:left">
								<a href="javascript:;" class="weui-btn weui-dialog__btn weui-dialog__btn_default bg-light-blue dialog-btn-cancel" flex-blox="1">取消</a>
								<a href="javascript:;" class="weui-btn weui-dialog__btn weui-dialog__btn_primary bg-blue dialog-btn-primary" flex-blox="1">确认</a>
							</div>
						</div>
					</div>
				</div>
				
				<!--操作成功弹窗-->
				<div class="js_dialog" id="iosDialog2" style="display:none">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__bd">
							<p class="icon-dialog-bar"><img src="${_staticPath}/resource/weuiWeb/img/icon-ok.png" /></p>
							<p class="xy-fs16 xy-fc-white xy-pad-t3">操作成功</p>
						</div>
						<div class="xy-waveBox xy-line-h0">
							<div class="xy-wave" id="wave4"></div>
							<div class="xy-wave" id="wave5"></div>
							<div class="xy-wave" id="wave6"></div>
						</div>
					</div>
				</div>
				 
			</div>
			<!--/弹窗 End-->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/swiper.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="tabbar js_show">
			function eventCollection(weui){
			}
			function showDeviceList(type){
				//alert(type);
				$.ajax({
					type:'get',
					url:_path+'/consumer/equip/list?type='+type,
					//data: {equipId:''},
					success : function(msg){
						console.log(msg);
						if(msg){
							
							//根据后台数据画列表
							drawList(msg.data);							
							}						
						}
					});
				function drawList(data){
					//console.log(data)
					var deviceDiv = '';
					for(var i in data){
						deviceDiv += '<div class="swiper-slide" data-value="'+data[i].open+'" No="'+data[i].equipCode+'">'+
										'<div class="height100" flex="dir:top">'+
											'<div class="main-img" flex-box="1">'+
												'<div class="height100" flex="dir:top main:justify">'+
													'<h1 class="sub-title">'+data[i].equipMark+'</h1><!--标题-->'+
													'<div flex-box="1" flex="dir:top main:justify">'+
														'<div class="main-img-con xy-pad-tb7 width100" flex-box="1" flex="dir:top main:justify">'+
															'<p class="pic-lovely"><img src="${_staticPath}'+data[i].path+'"></p>'+
															'<h5 class="sub-title">'+data[i].sortName+'</h5>'+
															'<div class="main-img-device xy-clearfix xy-pad-t5 xy-pad-b5">'+
																'<li>'+
																	'<p>TDS纯净水值</p>'+
																	'<p>'+data[i].purTds+'</p>'+
																'</li>'+
																'<li>'+
																	'<p>监测次数</p>'+
																	'<p>'+data[i].monitorCount+'</p>'+
																'</li>'+
																'<li>'+
																	'<p>服务次数</p>'+
																	'<p>'+data[i].serviceCount+'</p>'+
																'</li>'+
															'</div>'+
															'<div class="main-img-service xy-pad-t7 xy-border-t width100" flex-box="1" flex="main:center cross:center">'+
																'<div>'+
																	'<p class="xy-tac">剩余服务时长</p>'+
																'<p class="xy-timer xy-tac">'+data[i].remainTime+'</p>';
							        if(data[i].remainTime < 1000){deviceDiv += '<p class="xy-fs12 xy-fc-red xy-line-h20 xy-pad-t2 xy-pad-lr10 xy-line-clamp2">'+		
																					'净水设备快到维护期了，建议及时更换第五级滤芯'+
																				'</p>';
																  }
													deviceDiv +='</div>'+
															'</div>'+
														'</div>'+
													'</div><!--内容-->'+
													'<div class="main-img-address xy-pad-lr10 xy-pad-tb7 xy-border-t">'+
														'<a href="#" class="" flex="dir:left">'+
															'<i class="icon-map" flex="main:center cross:center"><img src="${_staticPath}/resource/weuiWeb/img/icon-map.png"></i>'+
															'<div class="xy-mar-l10 xy-font-address"  flex-box="1">'+data[i].address+
															'</div>'+
														'</a>'+
													'</div><!--地址-->'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</div>'
					}
					//console.log(deviceDiv);
					$('.swiper-wrapper').html(deviceDiv);										
				}
			}
			function binEvent(equipCode){							
				//点击置顶按钮
				$('#xy-btn_setTop').click(function(){
					var equipCode = $('.swiper-slide-active').attr('No');	
					if($('.bg-white a:eq(0)').hasClass('weui-bar__item_on')) type='mine';
					else type='attent';
					$.ajax({
					type:'get',
					url:_path+'/consumer/equip/setStick?equipCode='+equipCode+'&type='+type,
					success : function(msg){
						console.log(msg);
						if(msg){
							var slideLength = mySwiper.slides.length,
							realIndex =mySwiper.realIndex,slide = mySwiper.slides[realIndex]//获取当前活动slide;	
							console.log(slideLength,realIndex) 						
							 if(slideLength>1){
							 	mySwiper.removeSlide(realIndex);//删除当前slide
							 	//mySwiper.getSlide(realIndex).insertAfter(0);
							 	mySwiper.prependSlide(slide);	//添加当前slide到第一个						 	
							 	//realIndex = 0;
								//slideLength%2 == 0?realIndex = slideLength/2:realIndex = (slideLength-1)/2	
								}												
							}						
						}
					});
				});
			}
			$(function(){
				//获取地址栏参数				
				function GetQueryString(name){
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  decodeURI(r[2]); return null;
				}
				var number = GetQueryString("number");

				if(number == 2){
					//alert('2');
					$('.bg-white a:eq(1)').addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
					type = 'attent';
					showDeviceList(type);
				}else{
					 type = 'mine';
					//画列表
					showDeviceList(type);
				}																		
				$('.weui-tabbar__item').on('click', function () {
					$(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
					var thisNum = $(this).index();
					console.log(thisNum);
					//$('.xy-tab-list').eq(thisNum).addClass('xy-tab-list_on').siblings('.xy-tab-list_on').removeClass('xy-tab-list_on');
					if(thisNum == 0) {
						$("#switchBox").removeClass("xy-dn");
						$("#xy-btn_del").addClass("xy-dn");
						type = 'mine';
						showDeviceList(type);
					}else if(thisNum == 1) {
						$("#switchBox").addClass("xy-dn");
						$("#xy-btn_del").removeClass("xy-dn");
						type = 'attent';
						showDeviceList(type);
					}
					$('.xy-tab-list').addClass('xy-tab-list_on');
				});
				
				switchCP();
				var equipCode = $('.swiper-slide-active').attr('No'),open;
				$("body").on("click","#switchCP", function () {				
					//console.log('当前状态：'+ $("#btn").val() );										
					//var equipCode = $('.swiper-slide-active').attr('No'),open;					
					if($("#btn").val()=="on"){
						$("#btn").val("off");
						$('.xy-lock-off').show();
						$('.xy-lock-on').hide();
						open = false;
					}else{
						
						$("#btn").val("on");
						$('.xy-lock-off').hide();
						$('.xy-lock-on').show();
						open = true;
					}
					$.ajax({
						type:'get',
						url:_path+'/consumer/equip/setOpen?equipCode='+equipCode+'&open='+open,
						//data: {equipId:''},
						success : function(msg){
							console.log(msg);
							if(msg){
									return
									//alert('设置成功!!');
								}						
							}
						});
				});
				binEvent(equipCode);
						
				var $iosDialog1 = $('#iosDialog1');
				var $iosDialog2 = $('#iosDialog2');
				//删除slide方法并传给后台
				function removeSlides(equipCode){
					var slideLength = mySwiper.slides.length;
					var realIndex =mySwiper.realIndex;
					if(slideLength>1){
						mySwiper.removeSlide(realIndex); 	
					}
					$.ajax({
						type:'get',
						url:_path+'/consumer/equip/deleteAttent?equipCode='+equipCode,
						success : function(msg){
							console.log(msg);
							if(msg){
									return
									//alert('设置成功!!');
								}						
							}
					});
				};
				$('#dialogs').on('click', '.weui-dialog__btn', function(){
					var equipCode = $('.swiper-slide-active').attr('No');
					if($(this).is('.dialog-btn-primary')){
						 $iosDialog2.show().delay(2000).hide(300); 
						setTimeout(function(){
							removeSlides(equipCode)
						},1500);
					}
					$(this).parents('.js_dialog').hide();
				});
				
				$('#xy-btn_del').click(function(){//删除slide事件
					$iosDialog1.show();
				});
				//展示公有或者私有状态
				showStatu();
			});
			function switchCP(){
				$('#switchStyle').remove();
				var cpLengthAll = $('.xy-switchCp-bar .weui-switch-cp__box').width();
				var cpSlideLength = cpLengthAll - 40;
				$('head').append('<style id="switchStyle">.xy-switchCp-bar .weui-switch-cp__input:checked~.weui-switch-cp__box:after, .xy-switchCp-bar .weui-switch:checked:after {-webkit-transform: translateX('+cpSlideLength+'px); transform: translateX('+cpSlideLength+'px);</style>');
			}
			$(window).resize(function(){
				switchCP();
			});			
			function showStatu(){				
				//console.log($('.swiper-slide-active').html());
				/* if($('.swiper-slide-active').attr('data-value') == 'true') {
					alert('on');
					$('.xy-lock-off').hide();
					$('.xy-lock-on').show();
				}else{
					$('.xy-lock-off').show();
					$('.xy-lock-on').hide();
				} */
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>