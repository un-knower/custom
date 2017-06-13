<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml-transitional.dtd">
<html>
<head data-genuitec="wc2-22-44">
    <title data-genuitec="wc2-22-45">登录</title>
	<meta charset="utf-8" data-genuitec="wc2-22-46"/>

	<meta name="viewport" content="width=device-width, initial-scale=1.0" data-genuitec="wc2-22-47"/>

	<link href="${_staticPath}/resource/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" data-genuitec="wc2-22-48"/>

	
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/html5shiv.js" data-genuitec="wc2-22-49"></script>
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/respond.min.js" data-genuitec="wc2-22-50"></script>

	<script src="${_staticPath}/resource/jquery/jquery-2.0.3.min.js" data-genuitec="wc2-22-51"></script>
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/bootstrap.min.js" data-genuitec="wc2-22-52"></script>

	
	<link href="${_staticPath}/resource/datetime/datetimepicker.min.css" rel="stylesheet" data-genuitec="wc2-22-53"/>
	<script src="${_staticPath}/resource/datetime/datetimepicker.min.js" data-genuitec="wc2-22-54"></script>
	<script src="${_staticPath}/resource/datetime/datetimepicker.zh-CN.js" data-genuitec="wc2-22-55"></script> 
	<link href="${_staticPath}/resource/css/index.css" rel="stylesheet" data-genuitec="wc2-22-113"/>
	<script type="text/javascript" src="./main.js" data-genuitec="wc2-22-118"></script>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<style>
		 /* input:-webkit-autofill{
	     
		 -webkit-box-shadow:0 0 0px 1000px white inset !important;
		-webkit-text-fill-color:#333; 
		color:#fff;
		background-color: transparent;
		}  */
	</style>
<body style="background : url('${_staticPath}/resource/images/bg.jpg')" data-genuitec="wc2-22-116">
	<header class="cui-header" style="display:none;" data-genuitec="wc2-22-119" data-genuitec-lp-enabled="true" data-genuitec-file-id="wc2-22" data-genuitec-path="/test/WebRoot/index.html">
		<span class="glyphicon glyphicon-chevron-left tc" aria-hidden="true" data-genuitec="wc2-22-121"></span>
		<h3 class="tc" data-genuitec="wc2-22-122">忘记密码</h3>
		<span class="glyphicon glyphicon-option-horizontal tc  pull-righ" aria-hidden="true" data-genuitec="wc2-22-123"></span>
		
	</header>
	<div class="login-inputs" data-genuitec="wc2-22-120">
		<div class="logo tc" data-genuitec="wc2-22-124"><img src="${_staticPath}/resource/images/logo.png" data-genuitec="wc2-22-129"/></div>
		<div class="tc" style="color:#fff;margin-bottom: 5%;" data-genuitec="wc2-22-125"><h4 data-genuitec="wc2-22-130">持续保障你的饮水安全</h4></div>
		<div class="loginPage" data-genuitec="wc2-22-126">
		    <form id="login-form" style="position:relative;" data-genuitec="wc2-22-131" method="post">
				<input id="mobile" class="input-group-me " name="mobile" type="text" placeholder="请输入手机号" autocomplete="nope" data-genuitec="wc2-22-133">
				<input id="passWord" class="input-group-me " name="password" type="password" placeholder="请输入密码" autocomplete="off" data-genuitec="wc2-22-134">
				<img id="eye" src="${_staticPath}/resource/images/eye.png"/ style="position: absolute; left: 90%;top: 41%;width:10%;" data-genuitec="wc2-22-135">
				<!-- <input id="loging" class="input-group-me input-login" name="login" type="button" value="登&nbsp&nbsp&nbsp&nbsp录" data-genuitec="wc2-22-136"> -->	
				<button id="loging" class="btn btn-default btn-lg btn-block">登&nbsp&nbsp&nbsp&nbsp录</button>		
			</form> 
			<div class="down" data-genuitec="wc2-22-132"> <a href="#" id="fPassword" class="fl" data-genuitec="wc2-22-137">忘记密码？</a><a href="#" id="register" class="fr" data-genuitec="wc2-22-138">立即注册</a></div> 
		</div>
		<div class="fPwPage" style="display:none;" data-genuitec="wc2-22-127">
		    <form style="position:relative;" data-genuitec="wc2-22-139" method="post">
				<input id="rmobile" class="input-fPwPage input-group-me" name="mobile" type="number" placeholder="请输入手机号" data-genuitec="wc2-22-140">
				<div class="yzmDiv" data-genuitec="wc2-22-141">
					<input id="rYzm" class="input-fPwPage yzm fl"  type="text" placeholder="请输入验证码" style="display: block;width:60%;" data-genuitec="wc2-22-143">
					<input id="getYzm" class="input-fPwPage fr" type="button" value="获取验证码" style="font-size:16px;border-radius:20px;color:#a09999;display: block;width:39%;" data-genuitec="wc2-22-144">
				</div>
				<input id="setPassword" class="input-fPwPage input-group-me" name="password" type="password" placeholder="请设置大于6位的密码" data-genuitec="wc2-22-142">
				<img id="eye1" src="${_staticPath}/resource/images/eye.png"/ style="position: absolute; left: 90%;top: 41%;width:10%;" data-genuitec="wc2-22-145">
				<input id="setPasswordA" class="input-fPwPage input-group-me" name="password" type="password" placeholder="确认密码" data-genuitec="wc2-22-146">
				<img id="eye2" src="${_staticPath}/resource/images/eye.png"/ style="position: absolute; left: 90%;top: 60%;width:10%;" data-genuitec="wc2-22-147">
				<input id="login" class="input-group-me input-login" type="button" value="注&nbsp&nbsp&nbsp&nbsp册" style="margin-top: 10%;" data-genuitec="wc2-22-148">														
			</form> 			
		</div>

	</div>
	
</body>

</html>