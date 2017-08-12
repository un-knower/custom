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
		<title>净水器-个人中心</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
		
		<link rel="stylesheet" type="text/css" href="upLoad.css" />
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
	<style>
		#form0{ width: 100%; height: 100%;position: absolute; top: 0; left: 0;}
		#file0{    width: 100%; height: 100%;opacity: 0;} 
	</style>
	<body ontouchstart>
		<div class="page flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title">个人信息</div></div>
				<div class="xy-width-45"></div>
			</div><!--/header-->
			<div class="page__bd xy-container xy-container-t45b10 xy-scrollY">
				<div class="xy-pad-lr10 xy-pad-t10 xy-border-box xy-list-top-bar">
					<ul>						
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar xy-border-box">
							<div class="weui-cells xy-mar-t0 xy-fs16 link-icon-listview">
								<a class="weui-cell weui-cell_access" href="#" id="head">
									<div class="weui-cell__hd">头像</div>
									<div class="weui-cell__bd xy-tar">
										 <img style="width:60px;padding-left: 70%;" src="${_staticPath}/resource/weuiWeb/img/icon-list-device.png">
										 <form name="form0" id="form0" >
										    <input type="file" name="file0" id="file0" multiple="multiple"  accept="image/*"/><br>
										 </form>																				
									</div>									
								</a>
							</div>
							<!-- <input type="file" accept="image/*"> -->
						</li><!--列表-->
						
						<!--------------------- 列表 --------------------------->
						<li class="xy-layout-bar xy-border-box">
							<div class="weui-cells xy-mar-t0 xy-fs16 link-icon-listview">
								<a class="weui-cell weui-cell_access" href="#" id="setName">
									<div class="weui-cell__hd"><p>昵称</p></div>
									<div class="weui-cell__bd" id="showIOSDialog1">
										<p class="xy-tar"></p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
								<a class="weui-cell weui-cell_access" href="javascript:;" id="setSex">
									<div class="weui-cell__hd"><p>性别</p></div>
									<div class="weui-cell__bd" id="showAndroidActionSheet">
										<p class="xy-tar">设置</p>
									</div>
									<div class="weui-cell__ft"></div>
								</a>
							</div>
						</li><!--列表-->
					</ul><!--ul 列表-->
				</div>
			</div>
			<!--/ container -->
			
		</div>
		<!--/page End-->
		<div class="weui-skin_android" id="androidActionsheet" style="display: none">
	        <div class="weui-mask"></div>
	        <div class="weui-actionsheet">
	            <div class="weui-actionsheet__menu">
	                <div class="weui-actionsheet__cell">选择性别</div>
	                <div class="weui-actionsheet__cell">女</div>
	                <div class="weui-actionsheet__cell">男</div>
	            </div>
	        </div>
	    </div>
		<div class="js_dialog" id="iosDialog1" style="display: none;">
            <div class="weui-mask"></div>
            <div class="weui-dialog">
                <div class="weui-dialog__hd"><strong class="weui-dialog__title">修改昵称</strong></div>
                <div class="weui-dialog__bd">昵称<input class="xy-pad-lr2" id="dialogName" value="" type="text" style="    border: none;"></div>
                <div class="weui-dialog__ft bg-blue-02">
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">保存</a>                  
                </div>
            </div>
        </div>
        <!--上传头像-->
		<div class="img-container">  
			    <img id="img0"  src="">  
			    <div class="close" >取消</div>
			    <div class="saveBtn">选取</div>
		</div>
		<img class="newImg" src="">
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script src="${_path}/js/consumer/imagecropper.js"></script>
		<script type="text/javascript" class="js_show">
			var  $ajaxurl  = 'http://admin.enflux.com.cn';
			var  $ajaxGET  = "GET";
			//var  $ajaxPOST = "POST";
			//var tooken=getToken();
			function eventCollection(weui){
			}
			//获取地址栏参数				
			function GetQueryString(name){
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  decodeURI(r[2]); return null;
			}
			$('#head img').attr('src',GetQueryString('src'));
			$('#setName .weui-cell__bd p').html(GetQueryString('name'));
			$('#head').click(function(){//修改头像
			});
			 // android
		    $(function(){
		        var $androidActionSheet = $('#androidActionsheet'),$iosDialog1 = $('#iosDialog1'),
		         $androidMask = $androidActionSheet.find('.weui-mask');
		
		        $("#showAndroidActionSheet").on('click', function(){//修改性别
		            $androidActionSheet.fadeIn(200);
		            $androidMask.on('click',function () {
		                $androidActionSheet.fadeOut(200);
		            });
		            $('.weui-actionsheet__cell:eq(0)').click(function(){return});
		            $('.weui-actionsheet__cell:eq(1)').click(function(){
		            	 var thisSex = $(this).html();
		            	 c(thisSex);
		            	 //$('#setSex .weui-cell__bd p').html('女');
					});
		            $('.weui-actionsheet__cell:eq(2)').click(function(){
	            		var thisSex = $(this).html();
		            	 c(thisSex);
		            });
		            function c(a){		           		
		            	 var b = $('#setSex .weui-cell__bd p').html()
		            	 //console.log(a,b)
		            	 if(a !== b) {alert('修改成功！');
		            	 			$('#setSex .weui-cell__bd p').html(a)
		            	 }
		            	 
		            	 $androidActionSheet.fadeOut(200);
	            	 }
		        });
		        
		        
		        $('#showIOSDialog1').on('click', function(){//修改昵称
		        	$('#dialogName').val(GetQueryString('name'))
		            $iosDialog1.fadeIn(200);	            		            
		        });	
		        $('.weui-dialog__btn_default').click(function(){//修改昵称保存
		        	var newName = $('#dialogName').val();
		        	$iosDialog1.fadeOut(200);
		        	$('#setName .weui-cell__bd p').html(newName);
		        });
		        
		        
		        var $image = $('.img-container > img');
				$image.on("load", function() {        // 等待图片加载成功后，才进行图片的裁剪功能
				    $image.cropper({  
				        aspectRatio: 1 / 1  　　// 1：1的比例进行裁剪，可以是任意比例，自己调整  
				    });
				})
			
				// 点击保存
				$(".saveBtn").on("click", function() {
				    var src = $image.eq(0).attr("src");  
				    var canvasdata = $image.cropper("getCanvasData");  
				    var cropBoxData = $image.cropper('getCropBoxData');  
				    convertToData(src, canvasdata, cropBoxData, function(basechar) {
				        // 回调后的函数处理  
				        $(".newImg").attr("src", basechar);
						// 上传图片获取链接
						ajaxpubilc("/file/downloadBase64Img",{base64Img:basechar},'post', function (data) {
							if (data.success) {
								var url = data.data;
								// 保存头像地址
								ajaxpubilc("/member/info/saveMemberImageUrl",{imgUrl:url},'post', function (res) {
									if(res.success == true && res.code == 0) {
										window.location.href='changeInformation3.html';
									}else{
										alert("服务器繁忙");
									}
								});
							} else {
								alert("服务器繁忙");
							}
						});
				    });
				});
				$("#file0").change(function(){
					var objUrl = getObjectURL(this.files[0]) ;
					console.log("objUrl = "+objUrl) ;
					if (objUrl) {
						$("#img0").attr("src", objUrl) ;
						$('.cropper-canvas img').attr('src',objUrl);
						$('.cropper-view-box img').attr('src',objUrl);
					}
					var File=$('#img0').attr('src');
					if(File!=''||File==undefined){
						$('.img-container').show();
					}
				}) ;		        
		    });		    
			
			//建立一個可存取到該file的url
			function getObjectURL(file) {
				var url = null ; 
				if (window.createObjectURL!=undefined) { // basic
					url = window.createObjectURL(file) ;
				} else if (window.URL!=undefined) { // mozilla(firefox)
					url = window.URL.createObjectURL(file) ;
				} else if (window.webkitURL!=undefined) { // webkit or chrome
					url = window.webkitURL.createObjectURL(file) ;
				}
				return url ;
			}
			
			$('.close').click(function(){
				$('.img-container').hide();
			})
			
			function convertToData(url, canvasdata, cropdata, callback) {
				var cropw = cropdata.width; // 剪切的宽
				var croph = cropdata.height; // 剪切的宽
				var imgw = canvasdata.width; // 图片缩放或则放大后的高
				var imgh = canvasdata.height; // 图片缩放或则放大后的高
			
				var poleft = canvasdata.left - cropdata.left; // canvas定位图片的左边位置
				var potop = canvasdata.top - cropdata.top; // canvas定位图片的上边位置
			
				var canvas = document.createElement("canvas");
				var ctx = canvas.getContext('2d');
			
				canvas.width = cropw;
				canvas.height = croph;
			
				var img = new Image();
				img.src = url;
			
				img.onload = function() {
					this.width = imgw;
					this.height = imgh;
					// 这里主要是懂得canvas与图片的裁剪之间的关系位置
					ctx.drawImage(this, poleft, potop, this.width, this.height);
					var base64 = canvas.toDataURL('image/jpg', 1);  // 这里的“1”是指的是处理图片的清晰度（0-1）之间，当然越小图片越模糊，处理后的图片大小也就越小
					callback && callback(base64)      // 回调base64字符串
				}
			}
			function ajaxpubilc(url,data,posttype,callback){
				var loginrel= $ajaxurl+'/'+'login.html';								
				if(data==undefined){
				data = {};
				}
				data["access_token"]=tooken;
				$.ajax({
					url:$ajaxurl+url,
					type:posttype, /*$ajaxPOST*/
					dataType:'json',
					data:data,
					success: function(msg){
						callback(msg);
					},
					error:function(msg){
						var data = jQuery.parseJSON(msg.responseText);															
						if(data.error==undefined){
							alert(msg);
						}else{
						     if(msg.status==401){
								$.removeCookie("access_token");
	                    		window.location='loginnew.html'
			                 }
						}
					}
				})
			}
			function getToken(){
			    if(!$.cookie('access_token')||window.localStorage.getItem("access_token")==null){
			        return undefined;
			    }else{
			        return $.cookie('access_token')||window.localStorage.getItem("access_token");
			    }						
			}
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>