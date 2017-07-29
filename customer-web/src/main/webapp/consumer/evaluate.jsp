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
		<script type="text/javascript">
			var _path="${_path}",_staticPath="${_staticPath}";
		</script>
	</head>
	<style>
	@media screen and (max-height:600px){
		.my-msg {
		    height: 80px;
		    padding-bottom: 23px;
		    background-size: 62% 100%;
			 }
		 .xy-mar-t10 {
    		margin-top: .7em;}
   		.my-lovely img {
		    width: 55%;
		}
   		}
	</style>
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
								<!-- <a href="javascript:;" class="select-menubar__item">
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
								</a> -->
							</div>
						</div><!--/评价多选-->
					</div>
				</div>
				<div class="textarea-bar-style xy-line-h0 xy-hide">
					<div class="xy-mar-lr10 xy-mar-b7 xy-pad-7 xy-line-h0 xy-layout-bar textarea-bar">
						<textarea placeholder="我要吐槽" id="textRecord"></textarea>
					</div><!--/写评价窗口-->
				</div>
				
			</div>
			<!--/ container -->
			
			<div class="weui-footer weui-footer_fixed-bottom xy-footer">
				<div class="xy-pad-lr10 xy-clearfix">
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_primary xy-fll bg-light-blue">不评价了</a>
					<a href="#" class="weui-btn weui-btn_primary xy-fll bg-blue">提交评价</a>
				</div>
			</div>
			<!--/ footer -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">
			var _path="${_path}";
			cordData='';
			function eventCollection(weui){
			}						
			$(function(){
				var serveId='';
				//获取地址栏参数				
				function GetQueryString(name){
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  decodeURI(r[2]); return null;
				}
				serveId = GetQueryString('serveId');
				//showCard();				
				//获取评价标签
				 $.ajax({
					type:'get',
					url:_path+'/consumer/evaluate/listAllTag',
					success : function(msg){
						console.log(msg.data);
						if(msg){
							showCard(msg.data.one);//默认进来是0的标签
							cordData = msg.data;
							return cordData;
						}						
					}
				});	
				//console.log(cordData);
				//星星评价
				function changeGIF(el){
					console.log(cordData)
					var elNum = el.parent().find('.on').length;
					if(elNum==0){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-00.gif');
						$('.my-msg').text('无表情');
						showCard(cordData.one);
					}else if(elNum==1){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-11.gif');
						$('.my-msg').text('哭了');
						showCard(cordData.one);
					}else if(elNum==2){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-22.gif');
						$('.my-msg').text('快哭了');
						showCard(cordData.two);
					}else if(elNum==3){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-33.gif');
						$('.my-msg').text('微笑');
						showCard(cordData.three);
					}else if(elNum==4){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-44.gif');
						$('.my-msg').text('开心');
						showCard(cordData.four);
					}else if(elNum==5){
						$('.my-lovely img').attr('src','${_staticPath}/resource/weuiWeb/img/pic-lovely-55.gif');
						$('.my-msg').text('感动');
						showCard(cordData.five);
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
				
				//根据星星画对应的标签
				function showCard(data){
					var cardDiv='';
					console.log(data);
					for(var i=0,len=data.length;i<len; i++){
						cardDiv +=  '<a href="javascript:;" class="select-menubar__item" tagId="'+data[i].id+'">'+
										'<p class="select-menubar__label">'+data[i].tagName+'</p>'+
									'</a>';
					}
					$('.select-menubar').html(cardDiv);
				}
				bindEvent(serveId);
			});
			function bindEvent(serveId){
				//评价多选
				/* $('.select-menubar__item').on('click', function () {
					alert('34454');
					$(this).toggleClass('select-menubar__item_on');
				}); */
				//评价多选
				$('body').on('click','.select-menubar__item',function(){
					$(this).toggleClass('select-menubar__item_on');
				});
				//提交评价
				$('.bg-blue').click(function(){
					var rank = $('.on').length,content=$('#textRecord').val(),
					tags = [],red = $('.select-menubar__item_on');
					 for(var i=0,len=red.length;i<len;i++){
					 	//console.log(red[i]);
						tags.push(parseInt(red[i].getAttribute('tagId')));
					} 			
					$.ajax({
						type:'post',
						traditional: true,
						cache: false,
						contentType: "application/json; charset=utf-8",
						dataType:"json",
						url:_path+'/consumer/evaluate/set',
						data: JSON.stringify({
								'rank':rank,'content':content,'serveCode':serveId,
								'tags':tags
								    }),
						success : function(r){
							console.log(r);
							if(r){
								alert('成功！！');	
								window.location.href =_path+"/consumer/evaluate-ok.jsp";							
								}						
							}
					});
										
				});
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>