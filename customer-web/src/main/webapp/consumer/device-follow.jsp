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
		<title>净水器-关注设备</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
		<script src="${_staticPath}/resource/weuiWeb/js/echarts.min.js"></script>
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<style>
	 .line-btn-follow button.forbidClick{background: #ccc;}
	</style>
	<body ontouchstart>
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">关注设备</div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini"></a>
				</div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-zb10">
				<div class="weui-search-bar weui-search-bar_focusing xy-search-bar-sbso" id="searchBar">
					<div class="weui-search-bar__form">
						<div class="weui-search-bar__box">
							<i class="weui-icon-search"></i>
							<input type="search" class="weui-search-bar__input" id="searchInput" placeholder="请输入6位以上的设备号" required/>
							<a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
						</div>
					</div>
					<a href="javascript:" class="weui-search-bar__cancel-btn" id="search">搜索</a>
				</div>
				<!--<div class="weui-tab xy-border-box xy-pad-tb10 xy-pad-b45p xy-scrollY">-->
					
				<div class="page__bd xy-container xy-container-zb10 xy-scrollY">
					<div class="xy-pad-lr10 xy-pad-t10 xy-border-box xy-list-top-bar" id="followList">						
					</div>
				</div>
			</div>
			<!--/ container -->
			
		</div>
		<!--/page End-->
		
		<!--关注确认 弹窗-->
		<div id="dialogs">
			<!--确认关注？弹窗-->
			<div class="js_dialog" id="iosDialog1" style="display: none;">
				<div class="weui-mask"></div>
				<div class="weui-dialog bg-blue-01">
					<div class="weui-dialog__bd">
						<p class="icon-dialog-bar"><img src="${_staticPath}/resource/weuiWeb/img/icon-question-mark.png" /></p>
						<p class="xy-fs16 xy-fc-white xy-pad-t3">您确认关注该设备吗？ </p>
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
		<script type="text/javascript" class="tabbar js_show">
			function eventCollection(weui){
			}
			var show = false;
			var followBtn;
			function drawList(equipCode){
				//alert(equipCode)
				$.ajax({
					type:'get',
					url:_path+'/consumer/equip/searchEquip?equipCode='+equipCode,
					success : function(msg){
						console.log(msg);
						//console.log(msg.data.length);
						if(msg.data.length>0){
							//alert('找到啦');
							$("#followList").show();
							showList(msg.data);							
							}
						else if(msg.data.length==0){ 
							$("#followList").hide();
							alert('设备未找到');return
							}						
						}
				});
			}
			function showList(data){
				var listDiv = '';
				for(var i in data){
					listDiv += '<div class="xy-layout-bar xy-mar-b10 line-wrapper line-follow-box">'+
								'<div class="xy-border-box line-scroll-wrapper xy-clearfix">';
if(data[i].isOpen == true)listDiv += '<div class="line-btn-follow"><button>关注</button></div>';						
			         else listDiv += '<div class="line-btn-follow"><button type="button" disabled="disabled" class="forbidClick">此设备未公开</button></div>';						
						   listDiv +='<div class="line-normal-wrapper">'+
										'<a href="#" class="xy-border-box xy-pad-lr10 xy-pad-tb5 xy-dib line-normal-left-wrapper">'+
											'<div class="xy-pad-l10 line-normal-msg">'+
												'<ol class="xy-pad-t3">'+
													'<dt class=" xy-fs16">'+data[i].equipMark+'</dt>'+
												'</ol>'+
												'<ol class="xy-pad-t3 xy-fs13">'+
													'<dt id="deviceNo">设备编号:'+data[i].equipCode+'</dt>'+
												'</ol>'+
											'</div>'+
										'</a>'+
									'</div>'+
								'</div>'+
							'</div>';
				}
				$('#followList').html(listDiv);
			}
			$(function(){			
				var $iosDialog1 = $('#iosDialog1');
				var $iosDialog2 = $('#iosDialog2');
				
				$('#dialogs').on('click', '.weui-dialog__btn', function(){
					if($(this).is('.dialog-btn-primary')){
						//调后台确认关注的接口
						$.ajax({
							type:'get',
							url:_path+'/consumer/equip/addAttent?equipCode='+thisfollowNo,
							success : function(msg){
								console.log(msg);
								if(msg.success == true){
									 $iosDialog2.show().delay(2000).hide(300); 
									setTimeout(function(){							
										followBtn.parents(".line-follow-box").remove();							
									},2500);
									}//else{alert('添加失败')}						
								}
						});						
					}
					$(this).parents('.js_dialog').hide();
				});
				
				$('body').on('click','.line-btn-follow',function(){//添加关注设备事件
					followBtn = $(this);
					thisfollowNo = $(this).next().find('#deviceNo').html().slice(5);
					console.log(thisfollowNo);
					$iosDialog1.show();
				});
				
				
				var $searchBar = $('#searchBar'),
					$searchInput = $('#searchInput'),
					$searchClear = $('#searchClear'),
					$search = $('#search');

				function hideSearchResult(){
					$searchInput.val('');
				}
				function cancelSearch(){
					hideSearchResult();
				}
				$searchInput[0].focus();
				$search.on('click', function(){
					//alert($searchInput.val());				
					if(!$searchInput.val().length ||$searchInput.val().length <= 6){
						alert('请输入6位以上的编号');
				   		cancelSearch();
						$("#followList").hide();
				   }else{
				   		drawList($searchInput.val());
				   }
				});
				/*  $searchInput.on('blur', function () {//失去焦点时判断
					if(!this.value.length || this.value.length <= 4){
						alert('请输入4位数以上的设备编号');
						cancelSearch();
						$("#followList").hide();
					}
				}); */
				//这里是实时搜索，以后再用
				/* $searchInput.bind('input propertychange', function() {
				   //alert( $(this).val());
				   if(!this.value.length){
				   		cancelSearch();
						$("#followList").hide();
				   }else{
				   		drawList(this.value);
				   }
				   
				}); */
				/* $searchInput.on('blur', function () {
					if(!this.value.length){
						cancelSearch();
						$("#followList").hide();
					}else{
						//console.log(this.value);
						drawList(this.value);
						//$("#followList").show();
					}
				});
				 $searchInput.on('keypress', function(evt) {
					//console.log(evt.keyCode);
					//回车键 13
					if(evt.keyCode == 13){
						//$('#searchInput').val();
						drawList(this.value);
						$("#followList").show();
					}
				}); */
				$searchClear.on('click', function(){
					hideSearchResult();
					$searchInput[0].focus();
					$("#followList").hide();
				});
				/* $searchCancel.on('click', function(){
					cancelSearch();
					$searchInput.blur();
					$("#followList").hide();
				}); */

			});
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>