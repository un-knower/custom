<%@ page language="java" pageEncoding="utf-8"%>
<%  
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);   
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${_path}/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${_path}/easyui/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="${_path}/easyui/IconExtension.css">
		<script type="text/javascript" src="${_path}/easyui/js/jquery.min.js"></script>
		<script type="text/javascript" src="${_path}/easyui/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${_path}/easyui/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${_path}/js/common.js"></script>
		<script type="text/javascript" src="${_path}/js/main.js"></script>
		<script type="text/javascript">
			var localObj=window.location;
			var contextPath=localObj.pathname.split("/")[1];
			var basePath=localObj.protocol+"//"+localObj.host+"/"+contextPath;
		</script>
		<script type="text/javascript">
			$(function(){
				var global_person_id;
				var global_category_id;
				// 修改group面板的内容
				var westPanel = $("#main_list").layout("panel","west");
				westPanel.panel("refresh",basePath+"/main/menu.jsp");
				/*var centerPanel=$("#main_list").layout("panel","center");
				centerPanel.panel("refresh",basePath+"/main/table.jsp");*/
				var centerPanel=$("#main_list").layout("panel","center");
				centerPanel.panel("refresh",basePath+"/main/center.jsp");
				
				
				/*var northPanel=$("#main_list").layout("panel","north");
				northPanel.panel("refresh",basePath+"/main/menu.jsp");
				var eastPanel=$("#main_list").layout("panel","east");
				eastPanel.panel("refresh",basePath+"/main/detail.jsp");*/
				/*--------------------
				 * 初始化
				 * -----------------------*/
				//初始化——添加联系人的dialog
				$("#addDiv").dialog({    
					title:"添加",
					resizable:true,
					collapsible:true,
					minimizable:true,
					maximizable:true, 
					width:300,
					height:300,
					closed:true,
					modal:true,   // 模式/模态 对话框
					//toolbar:"#tb",
					buttons:"#add_div_button",
					href:basePath+"/main/add.jsp",
					cache:false
				});
				//初始化——修改联系人的dialog
				$("#modifyDiv").dialog({    
					title:"修改",
					resizable:true,
					collapsible:true,
					minimizable:true,
					maximizable:true, 
					width:300,
					height:300,
					closed:true,
					modal:true,   // 模式/模态 对话框
					//toolbar:"#tb",
					buttons:"#modify_div_button",
					href:basePath+"/main/edit.jsp",
					cache:false
				});
			});
		</script>
	</head>
	<body id="main_list" class="easyui-layout">
	   	<!-- <div data-options="region:'north',title:'菜单栏',split:true" style="height:100px;"></div>  --> 
	    <div data-options="region:'west',title:'菜单',split:true" style="width:150px;"></div>   
	    <div data-options="region:'center'" style="padding:5px;"></div>   
	    <!-- <div data-options="region:'east',title:'详情',split:true" style="width:300px;"></div>  -->   
	    
	</body>
	
</html>