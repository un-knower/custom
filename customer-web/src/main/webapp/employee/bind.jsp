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
		<title>服务-绑定</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-flex.css" /> 
		<link rel="stylesheet" href="${_staticPath}/resource/employee/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/employee/css/xy-css.css"/> 
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<body ontouchstart style="background-color: #EEEEEE;">
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">设备绑定</div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini"></a>
				</div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t0b0">
				<div class="xy-border-box height100">
					<div class="xy-layout" flex="dir:top main:justify">
						<div class="xy-line-h0 xy-pad-tb73">
							<div class="xy-pad-lr10 xy-pad-b10 height100 ">
								<div class="weui-cells weui-cells_form xy-login-form xy-mar-t0 bgTransparent xy-pad-b20">
									<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
										<!-- <div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="img/form-tel.png" /></label></div> -->
										
										<div class="weui-cell__bd">
											<input class="weui-input xy-input-tel" type="number" maxLength="11" placeholder="用户手机" id="tel">
										</div>
										<div class="weui-cell__ft" id="serTel"><botton class="weui-vcode-btn"><img src="${_staticPath}/resource/employee/img/serch.png"/ style="width:30px;"></botton></div> 
									</div>
									<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t8">
										<!-- <div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="img/form-pwd.png" /></label></div> -->
										<div class="weui-cell__bd">
											<input class="weui-input xy-input-pwd" type="text" placeholder="设备编号" id="deviceNo">
										</div>
									    <div class="weui-cell__ft" id="saoDevice"><botton class="weui-vcode-btn" id="showPicker0"><img src="${_staticPath}/resource/employee/img/serch.png" style="width:30px;" /></botton></div>
									</div>
									<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
										<!-- <div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="img/form-tel.png" /></label></div> -->
										
										<div class="weui-cell__bd">
											<input class="weui-input xy-input-tel" type="text"  placeholder="请选择用水来源" value="" id="water" readonly="readonly">
										</div>
										<%-- <div class="weui-cell__ft" id="showPicker"><botton class="weui-vcode-btn" id="showPicker"><img src="${_staticPath}/resource/employee/img/serch.png" style="width:30px;"/></botton></div> --%>
									</div>
									<div class="weui-cell xy-login-ImgLine xy-mar-lr10 xy-mar-t15">
										<!-- <div class="weui-cell__hd"><label class="weui-label xy-pad-r5"><img src="img/form-tel.png" /></label></div> -->
										
										<div class="weui-cell__bd">
											<input class="weui-input xy-input-tel" type="text"  placeholder="请选择滤芯规格" id="filter" readonly="readonly">
										</div>
										<%-- <div class="weui-cell__ft"><botton class="weui-vcode-btn" id="showPicker1"><img src="${_staticPath}/resource/employee/img/serch.png"/ style="width:30px;"></botton></div> --%>
									</div>
									<div class="xy-mar-t20 xy-mar-lr10">
										<a href="#" class="weui-btn weui-btn_primary bg-blue boxShadow " id="bindDevice">绑&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp定</a>
									</div>
									<button class="btn btn_primary" id="scanQRCode">scanQRCode(微信处理结果)</button>
								</div>
							</div>
						</div><!--/bottom-->
					</div><!--内容-->
				</div>
			</div>			
		</div>
		
		<!-- 弹窗 们-->
			<div id="dialogs">
				<div class="js_dialog" id="iosDialog1" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__hd">
							<stong class="weui-dialog__title xy-fc-white">搜索结果</stong>
						</div>
						<div class="weui-dialog__bd xy-border-t">
							<p class="xy-fs16 xy-fc-white xy-pad-t25"><span class="xy-pad-r5" id="userName">软绵绵</span><span id="userTel">12345678998</span></p>
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
				<!-- <div class="js_dialog" id="iosDialog2" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__hd">
							<stong class="weui-dialog__title xy-fc-white">扫描结果</stong>
						</div>
						<div class="weui-dialog__bd xy-border-t">
							<p class="xy-fs16 xy-fc-white xy-pad-t25"><span class="xy-pad-r5">设备编号</span><span>QT2017081125</span></p>
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
				</div> -->
				<div class="js_dialog" id="iosDialog2" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog bg-blue-01">
						<div class="weui-dialog__bd">
							<p class="icon-dialog-bar"><img src="${_staticPath}/resource/employee/img/false.png" /></p>
							<p class="xy-fs18 xy-fc-white xy-pad-t3"><b id="mesage">查无此人</b></p>
							<p class="xy-fs18 xy-fc-white xy-pad-t3"><b id="mesage1"></b></p>
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
		<script type="text/javascript" src="${_staticPath}/resource/employee/js/weui.min.js"></script>
		<script type="text/javascript" src="${_staticPath}/resource/employee/js/jweixin.min.js"></script>
		<script type="text/javascript" class="js_show">
		//调用微信扫一扫 
		 $.ajax({
		        type:"post",
		        url:"",//请求地址
		        data:{},//传入请求的url？
		        success:function(result){
		            wx.config({
		            // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		            debug: false,
		            // 必填，公众号的唯一标识
		            appId: result.appId,
		            // 必填，生成签名的时间戳
		            timestamp:""+result.timestamp,
		            // 必填，生成签名的随机串
		            nonceStr:result.noncestr,
		             // 必填，签名，见附录1
		             signature:result.signature,
		             // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		             jsApiList : [ 'checkJsApi', 'scanQRCode' ]
		             });
		          }
		    });
		    wx.error(function(res) {
		        alert("出错了：" + res.errMsg);//这个地方的好处就是wx.config配置错误，会弹出窗口哪里错误，然后根据微信文档查询即可。
		    });
		    wx.ready(function() {
		        wx.checkJsApi({
		             jsApiList : ['scanQRCode'],
		             success : function(res) {
		
		             }
		        });
		
		        //点击按钮扫描二维码
		        document.querySelector('#scanQRCode').onclick = function() {
		            wx.scanQRCode({
		                needResult : 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
		                scanType : [ "qrCode"], // 可以指定扫二维码还是一维码，默认二者都有
		                success : function(res) {
		                var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
		                 	$iosDialog1.show();
		                 	$('#iosDialog1 .weui-dialog__title').html('扫描结果');
		                 	$('#userName').html('设备编号');
		                 	$('#userTel').html(result);
		                }
		            });
		        };
		
		    });
		
			var $iosDialog1 = $('#iosDialog1'),$iosDialog2 = $('#iosDialog2');
			//验证手机号
			//$("input[id='tel']").blur(function(){
			$('#serTel').click(function(){
				var $tel = $('#tel')
			 if($tel.val()==''||($tel.val()!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test($tel.val()))){
	                //alert('请输入正确的手机号码');
	                $tel.attr('placeholder','请输入11位的手机号')
	                 $tel.parents('.weui-cell').css('border-bottom','1px solid red').siblings().removeAttr("style");
	            } else{
	            	$tel.parents('.weui-cell').removeAttr("style");
					$.ajax({
						type:'get',
						url:_path+"/employee/employee/searchUser?mobile="+$tel.val(),
						success : function(r){								
							if(r.success){
								$iosDialog1.show();
								$('#userName').html(r.data[0].name);
								$('#userTel').html(r.data[0].mobile);
								$("input[id='tel']").attr('userId',r.data[0].id);						
							}else{
								$iosDialog2.show();
								$('#mesage').html('查无此人');
								$('#mesage1').html('');								
							}
						}
					})
	            } 
			});
			//设备编号
			//$("input[id='deviceNo']").blur(function(){
			$('#showPicker0').on('click', function () {//还是用搜索按钮
				var $deviceNo = $('#deviceNo');
			 if($deviceNo.val().length <= 6){			 
	                //alert('请输入等于大于6位数的设备编号');
	                $deviceNo.parents('.weui-cell').css('border-bottom','1px solid red').siblings().removeAttr("style");
	                $deviceNo.attr('placeholder','请先输入大于6位数的设备编号')
	            }else{
	            	$.ajax({
						type:'get',
						url:_path+"/consumer/equip/searchEquip?equipCode="+$deviceNo.val(),
						success : function(r){								
							if(r.success){
								var deviceData =[],a = r.data;
								for(var i in a){
									var value = i,
									label =a[i].equipCode;
									deviceData.push({'value':value,'label':label})
								}
								console.log(deviceData);
								weui.picker(deviceData, {
						            onChange: function (result) {
						                console.log(result);
						            },
						            onConfirm: function (result) {
						            	console.log(deviceData[result].label);
						            	$deviceNo.val(deviceData[result].label);
						            }
						        });
							}else{
								$iosDialog2.show();	
								$('#mesage').html('设备未找到');
								$('#mesage1').html('请查证后再操作');
							} 
						}
					})
	            	$(this).parents('.weui-cell').removeAttr("style")
	            } 
			});
			
			/* $('#saoDevice').on('click',function(){
				//调取相机扫二维码
			});	 */ 
			
			$('#dialogs').on('click', '.weui-dialog__btn', function(){
				if($(this).is('.dialog-btn-primary')){
					$iosDialog1.hide(300); 
					//填入  设备编号
				}
				$(this).parents('.js_dialog').hide();
			});
									
			//$('#showPicker').on('click', function () {
			$("input[id='water']").focus(function(){
				//先去后台取数据
				$.ajax({
					type:'get',
					url:_path+"/employee/water/listWaterArea",
					success : function(r){								
						if(r.success){
							var newData =[],a = r.data;
							for(var i in a){
								var value = a[i].id,label = a[i].name;
								newData.push({'value':value,'label':label})
							}
							//console.log(newData);
							weui.picker(newData/* [{
					            label: '飞机票',
					            value: 0
					        }, {
					            label: '火车票',
					            value: 1
					        }, {
					            label: '的士票',
					            value: 2
					        },{
					            label: '公交票 (disabled)',
					            disabled: true,
					            value: 3
					        }, {
					            label: '其他',
					            value: 4
					        }] */, {
					            onChange: function (result) {
					                console.log(result);
					            },
					            onConfirm: function (result) {
					                $('#water').val(newData[result-1].label).attr('waterId',result);
					               // $("input[id='water']").;
					            }
					        });
						}else{
							$iosDialog2.show();	
							$('#mesage').html('暂无水源地信息');
						}
					}
				})		        
		    });
		    //$('#showPicker1').on('click', function () {//拉取滤芯组合
		    $("input[id='filter']").focus(function(){
				//先去后台取数据
				$.ajax({
					type:'get',
					url:_path+"/employee/filterGroup/list",
					success : function(r){								
						if(r.success){
							var filterData =[],a = r.data;
							for(var i in a){
								var value = a[i].id,
								label =a[i].oneFilterName.slice(0,5)+' '+a[i].twoFilterName.slice(0,4)+' '+a[i].threeFilterName.slice(0,4)+' '+a[i].fourFilterName.slice(0,4)+' '+a[i].fiveFilterName.slice(0,4);
								filterData.push({'value':value,'label':label})
							}
							//console.log(newData);
							weui.picker(filterData, {
					            onChange: function (result) {
					                console.log(result);
					            },
					            onConfirm: function (result) {
					                $('#filter').val(filterData[result-1].label).attr('filterId',result);
					            }
					        });
						}else{
							$iosDialog2.show();	
							$('#mesage').html('暂无滤芯信息');
						}
					}
				})		        
		    });
		    $('#bindDevice').click(function(){
		    	var userId = $('#tel').attr('userId'),filterGroupId =$('#filter').attr('filterId'),
		    	waterAreaId = $('#water').attr('waterId'),equipCode = $('#deviceNo').val();
		    	//userName = $('#userName').html();
		    	if(!userId){
		    		$('#tel').parents('.weui-cell').css('border-bottom','1px solid red').siblings().removeAttr("style");
		    	}else if(!equipCode){
		    		$('#deviceNo').parents('.weui-cell').css('border-bottom','1px solid red').siblings().removeAttr("style");
		    	}else if(!waterAreaId){
		    		$('#water').parents('.weui-cell').css('border-bottom','1px solid red').siblings().removeAttr("style");
		    	}else if(!filterGroupId){
		    		$('#filter').parents('.weui-cell').css('border-bottom','1px solid red').siblings().removeAttr("style");
		    	}else{
		    		$('input').parents('.weui-cell').removeAttr("style");
		    		$.ajax({
					type:'get',
url:_path+"/admin/equip/bindEquip?userId="+userId+'&filterGroupId='+filterGroupId+'&waterAreaId='+waterAreaId+'&equipCode='+equipCode,
					success : function(r){								
						if(r.success){
							//console.log(r);
							window.location.href =_path+"/employee/test.jsp?equipCode="+equipCode;
						}else{
							$iosDialog2.show();	
							$('#mesage').html('此设备已经被绑定');
							$('#mesage1').html('请与后台工作人员联系');
							}
					}
				})
		    	}
		    		
		    })
		   
		</script>

	</body>
</html>