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
		<title>服务-设备测试</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-flex.css" /> 
		<link rel="stylesheet" href="${_staticPath}/resource/employee/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-css.css"/> 
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<style>
			.dot{width: 10px;height: 10px; border-radius: 50%;background-color:#e5e5e5; display: inline-block;}
		    .green{background-color:#49f951;}
			.flex2{display:flex;width:100%;margin:0;padding:0;list-style:none;padding: 2% 0;}
			.flex2 :nth-child(1){flex:1 1 40%;}
			.flex2 :nth-child(2){flex:2 2 50%;margin-top: 2%;}
			.flex2 :nth-child(3){flex:3 3 10%;}
			.progress{width:50%;height:6px;border-radius: 10px;}
			.mar-t40{margin-top: 4em;}
			.line-height3{line-height: 3em;}
			.borderStyle{border: 1px solid #dde8ef; border-radius: 5%;box-shadow: 2px 2px 15px rgba(173, 224, 238, 0.5);}
			.ceshi{ background-color: #fff;background-image:linear-gradient(to top,#fff 85%,#3792fb 15%);
			width: 89%;  margin:3%;}	
		</style>
	<body ontouchstart style="background-color: #EEEEEE;">
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">设备测试</div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini"></a>
				</div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t0b0">
				<div class="xy-border-box height100">
					<div class="weui-cell weui-cell_access xy-mar-t30 xy-white-bg mar-t40">
						<div class="weui-cell__bd xy-clearfix">
							<p class="mini-lovely fixed-mini-lovely xy-full-widthIMG xy-fll xy-pad-l20"><img src="${_staticPath}/resource/employee/img/pic-lovely.gif" /></p>
							<div class="xy-db xy-mar-l35 xy-mar-r60p">
								<ol class="xy-pad-t8 xy-fs16" flex="dir:left">
									<dt class="xy-fc-light-gray">用户名称：</dt>
									<dd flex-box="1" id="userName"></dd>
								</ol>
								<ol class="xy-pad-t3 xy-fs16" flex="dir:left">
									<dt class="xy-fc-light-gray">设备编号：</dt>
									<dd flex-box="1" contenteditable="true" id="equipCode"></dd>
								</ol>
							</div>
						</div>
					</div>
					<div class="borderStyle xy-pad-lr2 xy-white-bg ceshi">									
						<div class="flex width100 xy-tac xy-fc-white line-height3" ><h4 id="fillUser">家的在线监测值</h4></div>
						<ul class="flex2 xy-fs13">
						    <li class="xy-tal">原水TDS值</li>
						    <li class="">
						    	<div class="progress" style="background-color:#fe93ba;"></div>
						    </li>
						    <li id="rawTds" class="xy-tal">0</li>
						</ul>
						<ul class="flex2 xy-fs13">
						    <li class="xy-tal">净水TDS值</li>
						    <li class="">
						    	<div class="progress" style="background-color:#49f951;"></div>
						    </li>
						    <li id="purTds" class="xy-tal">0</li>
						</ul>
						<ul class="flex2 xy-fs13">
						    <li class="xy-tal">过程净化服务</li>
						    <li>
						    	<div class="progress" style="background-color:#49d2f9;"></div>
						    </li>
						    <li id="">0%</li>
						</ul>
						<ul class="flex2 xy-fs13">
						    <li class="xy-tal">原水净化服务</li>
						    <li>
						    	<div class="progress" style="background-color:#fce930;"></div>
						    </li>
						    <li id="">0%</li>
						</ul>
						<ul class="flex2 bt xy-fs13">
						    <li class="xy-tal">是否漏水</li>
						    <li class="xy-tar xy-mar0">
						    	 <div><span class="dot" id="a"></span>是  </div>  
						    </li>
						    <li class="xy-tac"><span class="dot" id="b"> </span>否 </li>
						</ul>
						<ul class="flex2 xy-fs13">
						    <li class="xy-tal">流量</li>
						    <li>
						    </li>
						    <li id="flow">0</li>
						</ul>
					</div>
					<div class="xy-mar-t20 xy-mar-lr10">
						<a href="#" class="weui-btn weui-btn_primary bg-blue boxShadow" id="test" type="button">开&nbsp始&nbsp测&nbsp试</a>
					</div>
				</div>
			</div>			
		</div>    <!--  page  end --> 
		<!-- 弹窗 们-->
			<div id="dialogs">
				<div class="js_dialog" id="iosDialog1" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__bd">
							<p class="icon-dialog-bar"><img src="${_staticPath}/resource/employee/img/sucess.png" /></p>
							<p class="xy-fs18 xy-fc-white xy-pad-t3"><b>数据上报成功</b></p>
							<p class="xy-fs13 xy-fc-white xy-pad-t3"><b id="upTime">上报时间：2017.8.16</b></p>
						</div>
						<div class="xy-waveBox xy-line-h0">
							<div class="xy-wave" id="wave4"></div>
							<div class="xy-wave" id="wave5"></div>
							<div class="xy-wave" id="wave6"></div>
						</div>
						<div class="weui-dialog__ft">
							<div class="xy-pad-lr10 xy-pad-b10 bg-blue-opacity xy-border-box width100" flex="dir:left">
								<a href="javascript:;" class="weui-btn weui-dialog__btn weui-dialog__btn_primary bg-blue dialog-btn-primary" flex-blox="1">确认</a>
							</div>
						</div>
					</div>
				</div>
			</div>  
		<script type="text/javascript" src="${_staticPath}/resource/employee/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/employee/js/SuspendedBall.js"></script>
		<script type="text/javascript" class="js_show">	
			var $iosDialog1 = $('#iosDialog1');	
			//获取地址栏参数				
			function GetQueryString(name){
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  decodeURI(r[2]); return null;
			}			
			if(GetQueryString('equipCode')){
				var //userName = GetQueryString('userName'),
					equipCode = GetQueryString('equipCode');
				$('#equipCode').html(equipCode)
				//$('#userName').html(userName)	
				//$('#fillUser').html(userName+'家的在线检测值')
			}
			function progressWidth(){
				$(".progress").each(function () {
					var a = parseInt($(this).parent().next().html());
			        $(this).css("width",a > 200?'100%':a/2+'%');
			    });
			}
			function getData(equipCode){
				 $.ajax({
					type:'get',
					url:_path+"/employee/monitor/getMonitorOfNew?equipCode="+equipCode,
					success : function(r){								
						if(r.success){
							
							
							$iosDialog1.show();
							$('.xy-fs18').html('数据上报成功');
							$('.icon-dialog-bar img').attr('src','${_staticPath}/resource/employee/img/sucess.png');
							//$(this).html('开  始  测  试').attr('disabled',false);
							
							//填入数据
							$('#userName').html(r.data.userName)	
							$('#fillUser').html(r.data.userName+'家的在线检测值');
							
							$('#flow').html(r.data.flow+'L');
							$('#purTds').html(r.data.purTds+'mg/L');
							$('#rawTds').html(r.data.rawTds+'mg/L');
							$('#upTime').html(r.data.collectTime);
							progressWidth();
							r.data.leak == false ?$('#b').addClass('green'):$('#a').addClass('green');
						}else{
							//alert(r.message);
							$iosDialog1.show();
							$('.icon-dialog-bar img').attr('src','${_staticPath}/resource/employee/img/false.png');
							$('.xy-fs18').html('设备故障');
							$('#upTime').html('请与后台工作人员联系');
						}
					}
				})
			}
			$('#test').click(function(){				
				var equipCode = $('#equipCode').html();
				if(equipCode&&equipCode.length ==12) {
					//$('#equipCode').removeAttr("style")
					//$(this).html('测  试   中…………').attr('disabled','disabled').removeAttr('href');
					getData(equipCode);					
				}else  {
					alert('请填入设备号');
					$('#equipCode').css('border','1px solid red');
				}								
			})
			$('#dialogs').on('click', '.weui-dialog__btn', function(){
				if($(this).is('.dialog-btn-primary')){
					$iosDialog1.hide(300); 
				}
				$(this).parents('.js_dialog').hide();
			});
		</script>

	</body>
</html>