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
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">消息</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b10 xy-scrollY">
				<div class="xy-pad-lr10 xy-pad-t10 xy-border-box xy-list-top-bar">
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG xy-pore">
										<img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" />
										<i class="xy-poab icon-new-message icon-new-message-other">&nbsp;</i>
									</p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">上午10:31</span>
											<dt class=" xy-fs16">服务提醒</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>您有个设备正在服务中</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-services-details.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">昨天</span>
											<dt class=" xy-fs16">服务评价</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>您有一个服务未评价</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-remind-list.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">5:36</span>
											<dt class=" xy-fs16">预警消息</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>您有5个设备正在预警中</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-follow.html" class="xy-border-box xy-pad-10 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">昨天</span>
											<dt class=" xy-fs16">小飞流</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>申请关注您的饮水安全状态</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-follow.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">三天前</span>
											<dt class=" xy-fs16">萧景琰</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>申请关注您的饮水安全状态</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-follow.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">四天前</span>
											<dt class=" xy-fs16">霓凰</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>申请关注您的饮水安全状态</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
					<div class="xy-layout-bar xy-mar-b10 line-wrapper">
						<div class="xy-border-box line-scroll-wrapper xy-clearfix">
							<div class="xy-fll line-normal-wrapper">
								<a href="page-follow.html" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">
									<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" /></p>
									<div class="xy-pad-l10 line-normal-msg">
										<ol class="xy-pad-t3">
											<span class="xy-flr xy-fs13 xy-pad-t2">一个月前</span>
											<dt class=" xy-fs16">萧景桓</dt>
										</ol>
										<ol class="xy-pad-t3 xy-fs13">
											<dt>申请关注您的饮水安全状态</dt>
										</ol>
									</div>
								</a>
							</div>
							<div class="line-btn-delete"><button>删除</button></div>
						</div>
					</div><!--消息列表-->
				</div>
			</div>
			<!--/ container -->
		</div>
		<!--/page End--><!--删除确认 弹窗-->
			<div id="dialogs">
				<!--确认删除？弹窗-->
				<div class="js_dialog" id="iosDialog1" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__bd">
							<p class="icon-dialog-bar"><img src="${_staticPath}/resource/weuiWeb/img/icon-question-mark.png" /></p>
							<p class="xy-fs16 xy-fc-white xy-pad-t3">确认删除这个消息？</p>
						</div>
						<div class="xy-waveBox xy-line-h0">
							<div class="xy-wave" id="wave4"></div>
							<div class="xy-wave" id="wave5"></div>
							<div class="xy-wave" id="wave6"></div>
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
				<div class="js_dialog" id="iosDialog2" style="display: none;">
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
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/leftDelete.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
			}						
			var $iosDialog1 = $('#iosDialog1');
			var $iosDialog2 = $('#iosDialog2');
			var deleteDom;
			$('#dialogs').on('click', '.weui-dialog__btn', function(){
				if($(this).is('.dialog-btn-primary')){
					$iosDialog2.show().delay(2000).hide(300); 
					setTimeout(function(){
						deleteDom.parents('.line-wrapper').remove();
					},2500);
				}
				$(this).parents('.js_dialog').hide();
			});
			
			$('body').on('click','.line-btn-delete',function(){//删除按钮事件
				deleteDom = $(this);
				$iosDialog1.show();
			});
			 $('body').on('click','.line-scroll-wrapper',function(){//列表点击事件跳转
				//lineClick = $(this);
				var thisSort = $(this).parent().attr('sortCode');
				alert(thisSort);
			}); 
			
			$(function(){				
				//获取消息列表
				$.ajax({
					type:'get',
					url:_path+'/consumer/message/list',
					success : function(msg){
						console.log(msg);
						if(msg){
							//画消息列表
							drawMessageList(msg.data)
							}						
						}
				});
				function drawMessageList(data){
					var messageDiv = '';
					for (var i in data){
					 	messageDiv += '<div class="xy-layout-bar xy-mar-b10 line-wrapper" sortCode="'+data[i].sortCode+'">'+
										'<div class="xy-border-box line-scroll-wrapper xy-clearfix">'+
											'<div class="xy-fll line-normal-wrapper">'+
												'<a href="#" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">'+
													'<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG"><img src="${_staticPath}'+data[i].path+'" /></p>'+
													'<div class="xy-pad-l10 line-normal-msg">'+
														'<ol class="xy-pad-t3">'+
															'<span class="xy-flr xy-fs13 xy-pad-t2">'+data[i].createTime.slice(11,16)+'</span>'+
															'<dt class=" xy-fs16">'+data[i].sortName+'</dt>'+
														'</ol>'+
														'<ol class="xy-pad-t3 xy-fs13">'+
															'<dt>此处是消息的内容！！！</dt>'+
														'</ol>'+
													'</div>'+
												'</a>'+
											'</div>'+
											'<div class="line-btn-delete"><button>删除</button></div>'+
										'</div>'+
									'</div>';
					}
					$('.xy-list-top-bar').html(messageDiv);
					leftDelete();
				}
				
			})
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>