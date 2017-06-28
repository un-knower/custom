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
		<title>净水器-评价</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart  translate="no">
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">评价</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
		
			<div class="page__bd xy-container xy-scrollY">
				<div class="xy-layout" flex="dir:top">
					<div class="xy-layout-bar xy-mar-tb7 xy-mar-lr10 bg-blue-01 xy-evalute-bar" flex-box="1" flex="dir:top">
						
						<div class="lovely-status-bar" flex-box="1" flex="main:center cross:center">
							<div>
								<div class="my-msg xy-tac xy-pad-lr10 xy-mar-t10 xy-fc-white xy-fs14" flex="main:center cross:center">
									<p>无表情</p>
								</div><!--/提示语-->
								<div class="my-lovely xy-tac xy-pad-lr10">
									<img src="${_staticPath}/resource/weuiWeb/img/pic-lovely-00.gif" />
								</div><!--/蜻蜓-->
							</div>
						</div>
						<div class="xy-waveBox xy-line-h0">
							<div class="xy-wave" id="wave1"></div>
							<div class="xy-wave" id="wave2"></div>
							<div class="xy-wave" id="wave3"></div>
						</div>
						<div class="xy-star-bar xy-tac xy-pad-lr10 xy-pad-t5 xy-pad-b5 bg-blue-opacity">
							<div class="xy-emptys"></div>
							<i class="icon-star xy-dibVat"></i>
							<i class="icon-star xy-dibVat"></i>
							<i class="icon-star xy-dibVat"></i>
							<i class="icon-star xy-dibVat"></i>
							<i class="icon-star xy-dibVat"></i>
						</div><!--/星星-->
						<div class="xy-pad-b10 bg-blue-opacity">
							<div class="select-menubar xy-clearfix xy-pad-lr5 xy-scrollY xy-height-68p">
								<a href="javascript:;" class="select-menubar__item">
									<p class="select-menubar__label">专业</p>
								</a>
								<a href="javascript:;" class="select-menubar__item">
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
							</div>
						</div><!--/评价多选-->
					</div>
				</div>
				<div class="textarea-bar-style xy-line-h0 xy-hide">
					<div class="xy-mar-lr10 xy-mar-b7 xy-pad-7 xy-line-h0 xy-layout-bar textarea-bar">
						<textarea placeholder="我要吐槽"></textarea>
					</div><!--/写评价窗口-->
				</div>
				
			</div>
			<!--/ container -->
			
			<div class="weui-footer weui-footer_fixed-bottom xy-footer">
				<div class="xy-pad-lr10 xy-clearfix">
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_primary xy-fll bg-light-blue">不评价了</a>
					<a href="page-evaluate-ok.html" class="weui-btn weui-btn_primary xy-fll bg-blue">提交评价</a>
				</div>
			</div>
			<!--/ footer -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
			}
			$(function(){
				//星星评价
				function changeGIF(el){
					var elNum = el.parent().find('.on').length;
					if(elNum==0){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-00.gif');
						$('.my-msg').text('无表情');
					}else if(elNum==1){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-11.gif');
						$('.my-msg').text('哭了');
					}else if(elNum==2){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-22.gif');
						$('.my-msg').text('快哭了');
					}else if(elNum==3){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-33.gif');
						$('.my-msg').text('微笑');
					}else if(elNum==4){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-44.gif');
						$('.my-msg').text('开心');
					}else if(elNum==5){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-55.gif');
						$('.my-msg').text('感动');
					}
					
				}
				$('.xy-star-bar .icon-star').on('click',function(){
					var moveBtn = $('.xy-footer').clone(true);//footer 定位在下方的 转为普通文档流 
					$('.xy-container').css('padding-bottom','1em');
					$('.xy-footer').remove();
					$('.textarea-bar').after(moveBtn);
					$('.textarea-bar-style .xy-footer').addClass('reset-poab');
					$('.textarea-bar-style').show();
					var el = $(this);
					if(el.is(".on")){
						if(el.next().is(".on")){
							el.nextAll('.icon-star').removeClass("on");//移除下面所有的星
							changeGIF(el);
						}else{
							el.removeClass("on").siblings('.icon-star').removeClass("on");//返回默认全灰星
							changeGIF(el);
						}
					}else{
						el.addClass("on").prevAll('.icon-star').addClass("on");//添加上面所有的星
						changeGIF(el);
					}
				});
				//评价多选
				$('.select-menubar__item').on('click', function () {
					$(this).toggleClass('select-menubar__item_on');
				});
			});
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>