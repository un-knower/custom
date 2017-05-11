<%@ page language="java" pageEncoding="utf-8"%>


<html>
	<head>
		
	</head>
	<body>
		ssoServerUrl:"${_ssoServerUrl}" 
		<form action="${_ssoServerUrl}/login?backUrl=${param.backUrl}&appCode=${param.appCode}" method="post">
			手机号<input type="text" name="account" value=""/><br/>
			密    码<input type="text" name="password"/><br/>
			<input type="submit" value="登陆"/> <br/>
			<a href="">忘记密码</a> &nbsp;&nbsp; <a href="${_path}/reg">立即注册</a>
		</form>
	</body>
</html>