<%@ page language="java" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#getValidateCode").linkbutton({
					onClick:function(){
						Ajax({
							"type":"post",
							"url":"${pageContext.request.contextPath }/reg/getValidateCode",
							"data":{"account":$("input#account").val()},
							"dataType":"text",
							"autoCloseProgress":false, //success回调函数执行结束再关闭进度条
							"progressText":"正在发送请求...", //进度条显示文本
							"timeout":30000, //超时设置30s
							"successText":"操作成功！",
							"success":function(result){
								alert("处理结果："+result);
								//$("#admin_table").datagrid("load");
							}
						});
					}
				});
				
			});
		</script>
		
	</head>
	<body>
		<form action="${_path}/reg/reg" method="post">
			手机号<input type="text" id="account" name="account" value=""/><br/>
			验证码<input type="text" name="validateCode" value=""/> 
			<a id="getValidateCode" class="easyui-linkbutton">获取验证码</a><br/>
			<%-- <a href="${_path}/reg/getValidateCode"><input type="button" value="获取验证码"/></a><br/> --%>
			密码<input type="text" name="password"/><br/>
			<!-- 重复<input type="text" name="password"/><br/> -->
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>