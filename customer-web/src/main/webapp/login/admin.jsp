<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台登录页面 </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
	<link href="${_staticPath}/resource/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${_staticPath}/resource/bootstrap-3.3.5/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${_staticPath}/resource/ace/css/ace.min.css" />
	<link rel="stylesheet" href="${_staticPath}/resource/ace/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${_staticPath}/resource/ace/css/ace-skins.min.css" />
	
	<link rel="stylesheet" href="${_staticPath}/resource/ace/css/ui.jqgrid.css" />
	<link rel="stylesheet" href="${_staticPath}/resource/ace/css/daterangepicker.css" />
	
	<script src="${_staticPath}/resource/jquery/jquery-2.0.3.min.js"></script>
	
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/typeahead-bs2.min.js"></script>
	
	<script src="${_staticPath}/resource/ace/js/ace-extra.min.js"></script>
	<script src="${_staticPath}/resource/ace/js/ace.min.js"></script>	
	
	<script src="${_staticPath}/resource/ace/js/jquery.jqGrid.min.js"></script>
	<script src="${_staticPath}/resource/ace/js/grid.locale-en.js"></script>
	<script src="${_staticPath}/resource/ace/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		//var _path = "http://192.168.10.20:8086/customer-web"; 
		var _staticpath;
		var _path="${_path}";		
	</script>
	<style rel="stylesheet">
		.onError{color:red;}
		.onSuccess{color:green;}
	</style>
	</head>
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">后台管理系统</span>
									<!-- <span class="white">Application</span> -->
								</h1>
								<h4 class="blue">&copy; 清渟科技</h4>
							</div>
							<div class="space-6"></div>
							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请登录
											</h4>
											<div class="space-6"></div>
											<form id="login-form" method="post">
												<input type="hidden" name="backUrl" value="${backUrl}" />
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="mobile" class="form-control" placeholder="用户名" id="mobile" autocomplete="off"/>
															<i class="icon-user"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" class="form-control" placeholder="密码" id="password" autocomplete="off"/>
															<i class="icon-lock"></i>
														</span>
													</label>
													<div class="space"></div>
													<div class="clearfix">
														<button type="button" id="login" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->
										<div class="toolbar clearfix">
											 <div>
												<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													忘记密码
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												找回密码
											</h4>
											<div class="space-6"></div>
											<form id="forget-form" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="account" name="account" type="text"class="form-control" placeholder="用户名" autocomplete="off"/>
															<i class="icon-user"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="input-icon input-icon-right">
															<input id="code" name="validateCode" type="text" class="form-control" placeholder="验证码" autocomplete="off"/>				
														</span>
														<button id="getCode" type="button" class="width-35 pull-right btn btn-sm btn-success">
															获取验证码													
														</button>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="fpassword" type="password" name="password" class="form-control" placeholder="密码" autocomplete="off"/>
															<i class="icon-lock"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="fpassword2" type="password" class="form-control" placeholder="密码确认" autocomplete="off"/>
															<i class="icon-retweet"></i>
														</span>
													</label>
													<div class="space-24"></div>
													<div class="clearfix text-center">
														<button id="resetPassword" type="button" class="width-65 btn btn-sm btn-success">
															登录
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												返回登录
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible').find('.formtips').remove();
			 jQuery('#'+id).find('form').trigger('reset');
			 
			 /* .find('form:input').
			 not(":button,:submit,:reset,:hidden").val("").
			 removeAttr("checked").remove("selected") */		
			}						
		</script>
</body>
<script type="text/javascript">
$(function(){
	    $('input').blur(function(){
	        var $parent=$(this).parent();
	        $parent.find('.formtips').remove();//清除之前的提醒消息
	        this.value=$.trim($(this).val());//去掉前后的空格
	        //验证手机号
	        if($(this).is('#mobile')){                      
	            if(this.value==''||(this.value!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test(this.value))){
	                var errorMsg='请输入正确的手机号码';
	                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
	            }else{
	                var okMsg='输入正确';
	                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
	            }  
	        }
	        //验证密码位数
	        if($(this).is('#password')){                      
	            if(this.value==''||this.value.length<6){
	                var errorMsg='请输入6位或者以上的密码';
	                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
	            }/* else{
	                var okMsg='输入正确';
	                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
	            } */  
	        }
	        //验证账号
	        if($(this).is('#account')){                      
	            if(this.value==''||(this.value!=''&& !/^1[3|4|5|7|8][0-9]\d{8}$/.test(this.value))){
	                var errorMsg='请输入正确的手机号码';
	                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
	            }else{
	                var okMsg='输入正确';
	                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
	            }  
	        }
	        //验证验证码
	        if($(this).is('#code')){                      
	            if(this.value==''||this.value.length<4){
	                var errorMsg='请输入4位数的验证码';
	                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
	            }else{
	                var okMsg='输入合格';
	                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
	            }  
	        } 
	        //验证密码1
	        if($(this).is('#fpassword')){                      
	            if(this.value==''||this.value.length<6){
	                var errorMsg='请输入6位数或者以上的密码';
	                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
	            }/* else{
	                var okMsg='输入合格';
	                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
	            }  */ 
	        } 
	        //验证密码2
	        if($(this).is('#fpassword2')){                      
	            if(this.value==''||this.value.length<6){
	                var errorMsg='请再次输入6位数或者以上的密码';
	                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
	            }/* else{
	                var okMsg='输入合格';
	                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
	            }  */ 
	        } 
	    }).keyup(function(){
	        $(this).triggerHandler("blur");
	    }).focus(function(){
	        $(this).triggerHandler("blur");
	    });
	    //获取短信验证码	
		$('#getCode').click(function(){
			
			settime($(this));
			var account = $('#account').val();
			$.ajax({
				type:'get',
				url:_path+'/validate/getValidateCode'+'?'+'account='+account,
				//data:{account:account},
				success : function(msg){
					if(msg) alert('验证码已成功发送至您手机！')								
				}
			}); 
		});	
		var time=60;
		function settime(obj){			
			if(time == 0){
				obj.attr('disabled',false);
				obj.html("获取验证码");
				time = 60;
				return
			}else{
				obj.attr('disabled',true);
				obj.html('重新发送'+time);
				time--;
			}
			setTimeout(function(){					
				settime(obj);},1000)
			
		}
		//正常登录提交		
		$('#login').click(function(){		
			$('form[id=login-form]').attr('action',_path+"/login/admin/submit");
			$('#login-form').submit();			
			//window.location.href =_path+"admin/home";
			/*  var param ={};
			param.mobile = $('#username').val(),param.password = $('#password').val();
			$.ajax({
				type:'POST',
				url:_path+'login/login',
				data:param,
				success : function(msg){
					if(!msg) alert('用户名和密码不匹配！')
					else window.location.href =_path + "admin/home";//登录成功后跳转到首页					
				}
			}); */ 
			
		});	
		//忘记密码登录提交		
		$('#resetPassword').click(function(){
			/* var a = $('#fpassword').val(),b=$('#fpassword2').val();
			if(a != b){alert('两次密码不一致')}
			$('form[id=forget-form]').attr('action',_path+"/forget/updatePassword");
			$('#forget-form').submit(); */	
			 var param ={},a = $('#fpassword').val(),b=$('#fpassword2').val();
			param.account = $('#account').val(),param.validateCode = $('#code').val(),
			param.password = a;
			if(a != b){alert('两次密码不一致')}
			else{
				$.ajax({
				type:'POST',
				url:_path+'/forget/updatePassword',
				data:param,
				success : function(msg){
					if(!msg) {alert('验证码不符！')}
					else {
						alert('密码修改成功！');
						window.location.href =_path + "/admin/home";//登录成功后跳转到首页
						}					
					}
				});
			} 
			
		});		
	})					
</script>
</html>
