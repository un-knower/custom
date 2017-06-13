$(function(){
		var hosturl= window.location.hostname;
		
		$('.logo img').click(function(){//进入引导页			
			window.location.href ="http://"+hosturl+":8080/test/lead.html";
		});
		$('.glyphicon-chevron-left').click(function(){//返回
			$('.fPwPage').hide();
			$('.loginPage').show();
			$('.cui-header').css('display','none');
		});
		
		$('#eye').on("touchstart",function() {//登录页面  密码可见/不可见切换
		
			var imgSrc = $('#eye').attr('src'),inputPassw = $('#passWord');;
			
			if(imgSrc == '${_staticPath}/resource/images/eye.png'){
			
				$(this).attr('src','${_staticPath}/resource/images/eyew.png');
				
				inputPassw.attr('type','text');
			}else{
				$(this).attr('src','${_staticPath}/resource/images/eye.png');
				inputPassw.attr('type','password');
				}
		 })
		 $('#eye1').on("touchstart",function() {//忘记密码页面  密码可见/不可见切换（第一次密码）
		
			var imgSrc = $('#eye1').attr('src'),inputPassw = $('#setPassword');;
			
			if(imgSrc == '${_staticPath}/resource/images/eye.png'){
			
				$(this).attr('src','${_staticPath}/resource/images/eyew.png');
				
				inputPassw.attr('type','text');
			}else{
				$(this).attr('src','${_staticPath}/resource/images/eye.png');
				inputPassw.attr('type','password');
				}
		 })
		 $('#eye2').on("touchstart",function() {//忘记密码页面  密码可见/不可见切换（第二次密码）
		
			var imgSrc = $('#eye2').attr('src'),inputPassw = $('#setPasswordA');;
			
			if(imgSrc == '${_staticPath}/resource/images/eye.png'){
			
				$(this).attr('src','${_staticPath}/resource/images/eyew.png');
				
				inputPassw.attr('type','text');
			}else{
				$(this).attr('src','${_staticPath}/resource/images/eye.png');
				inputPassw.attr('type','password');
				}
		 })
		 
		 $("#loging").on("touchstart",function(){//正常登录点击
		 	$(this).css('background-color','#0a0971');
		 });
		 $("#loging").on("touchend",function(){
		 	$(this).css('background-color','rgba(255,255,255,0.1');
		 	checkLogin();
		 })
		function checkLogin(){
		
			var mobile = $('#mobile').val(),passWord = $('#passWord').val(),reg = /(1[3-9]\d{9}$)/;
			if(!mobile||!passWord){
				alert("手机号或者密码不能为空！");
				return false;
			}else if(!reg.test(mobile)){
				alert("请输入正确格式的手机号码！");
				return false;
			}else if(passWord.length <= 3){
				alert("请输入正确的密码");
				return false;
			}
			submitLogin(mobile,passWord);
		}
		function submitLogin(mobile,passWord){//登录提交
			console.log(mobile,passWord);
			$('form[id=login-form]').attr('action',_path+"/login/login"); 
			//$('form[id=login-form]').val('method',"post");
			$('#login-form').submit();
			/*$.ajax({
				url: _path+"/login/login",
				data : {
					mobile:mobile,
					password:passWord
					},
				type :'post',
				dataType : 'json',
				success : function(data){
					if(data.msg == " false") alert(""); 
				}
			});*/
		}
		
		$("#fPassword").on("touchstart",function() {//点击忘记密码
			$('.cui-header').css('display','flex');
			$('.fPwPage').css('display','block');
			$('.loginPage').css('display','none');
			$('#setPassword').attr('placeholder','请输入大于6位数的新密码');
			$('#setPasswordA').attr('placeholder','请确认新密码');
			$('#login').val('登     录');
			checkRegister();
		});
		$('#register').on("touchstart",function(){//点击注册
			$('.fPwPage').css('display','block');
			$('.loginPage').css('display','none');
			checkRegister();
		});
		
		$('#rYzm').focus(function(){//填写验证码的按钮样式改变
			$('.yzmDiv').addClass('yzmDivchange');
		});
		$('#rYzm').blur(function(){
			$('.yzmDiv').removeClass('yzmDivchange');
		});			
		function checkRegister(){			
			$('#getYzm').on("touchstart",function(){
				alert("12233");
				checkmobileNo();				
			});
			function checkmobileNo(){//验证手机号
					var rmobile = $('#rmobile').val(),regNo = /^1[3-9]\d{9}$/;
					console.log(rmobile);
					if(!regNo.test(rmobile)|| !rmobile){
						alert("请输入正确的手机号码！");
						return false;
					}else{
						settime($('#getYzm'));						
						getYam(rmobile);
						
					}
				}
			var time=60;
			function settime(obj){				
				if(time == 0){
					obj.attr('disabled',false);
					obj.val("获取验证码");
					time = 60;
					return
				}else{
					obj.attr('disabled',true);
					obj.val('重新发送'+time);
					time--;
				}
				setTimeout(function(){					
					settime(obj);},1000)
				
			}
			function getYam(rmobile){//获取验证码
				//console.log(rmobile);
				$.ajax({
					url: "http://192.168.10.20:8086/customer-web/validate/getValidateCode"+"?account="+rmobile,
					//data : {account : rmobile},
					type :'get',
					//dataType : 'JSONP',
					success : function(data){
						//console.log(data);
						if(data.success == "true") {
							alert("验证码已经成功发送");
							
						}
					}
				}); 
			}
			
		}
		
		
		//忘记密码的登录/注册点击
		
		$('#login').on("touchstart",function(){
			var param ={},thisName=$(this).val();
			console.log(thisName);
			param.rmobile = $('#rmobile').val(),param.rYzm = $('#rYzm').val(),regNo = /^1[3-9]\d{9}$/,
			param.setPassword = $('#setPassword').val(),param.setPasswordA = $('#setPasswordA').val();
			if(!param.setPassword||!param.setPasswordA){
				alert("密码不能为空！");
				return false;
			}else if(param.setPassword.length <= 6){
				alert("请输入大于6位数的密码");
				return false;
			}else if(param.setPassword != param.setPasswordA){
				alert("两次输入的密码不一致");
				return false;
			}else{loginAndr(param,thisName);}
		});
		function loginAndr(param,thisName){
			//console.log(rmobile,setPassword);
			console.log(thisName);
			if(thisName == '注    册'){
				$.ajax({//调用注册接口
					url: "",
					data : param,
					type :'post',
					dataType : 'json',
					success : function(data){
						//后台需要判断 用户的验证码是否输入正确
						if(data.code == " false") alert("请输入正确的验证码！");
						//跳转 
					}
				});
			}else{
				$.ajax({//调用修改密码的接口
					url: "",
					data : param,
					type :'post',
					dataType : 'json',
					success : function(data){
						//后台需要判断 用户的验证码是否输入正确
						if(data.code == " false") alert("请输入正确的验证码！");
						//跳转 
					}
				});
			}
			
		}
		
		
	});
