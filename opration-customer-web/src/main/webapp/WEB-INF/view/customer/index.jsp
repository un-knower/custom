<%@ page language="java" pageEncoding="utf-8"%>
<%  
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);   
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>${_systemName}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link type="images/x-icon" rel="shortcut icon" href="${_staticPath}/custom/assets/favicon.ico">
		
		<!--[if !IE]> -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/pace.css" />
		<script data-pace-options='{ "ajax": true, "document": true, "eventLag": false, "elements": false }' src="${_staticPath}/assets/js/pace.js"></script>
		<!-- <![endif]-->

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${_staticPath}/assets/css/font-awesome.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
		
		<!-- 自定义样式，表单多选框 -->
		<link rel="stylesheet" href="${_staticPath}/custom/assets/ace.custom.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${_staticPath}/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${_staticPath}/assets/css/ace-ie.css" />
		<![endif]-->

		<!-- ace settings handler -->
		<script src="${_staticPath}/assets/js/ace-extra.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="${_staticPath}/assets/js/html5shiv.js"></script>
		<script src="${_staticPath}/assets/js/respond.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="main-container" id="main-container">
			
				<a href="${_path}/project/list" class="btn btn-app btn-success">
					<i class="ace-icon glyphicon glyphicon-home bigger-230"></i>
					监测系统
				</a>
		</div>
		
		
		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${_staticPath}/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='${_staticPath}/assets/js/jquery1x.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${_staticPath}/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
		<script src="${_staticPath}/assets/js/bootstrap.js"></script>
		
		<!-- ace scripts -->
		<script src="../../assets/js/ace/elements.scroller.js"></script>
		<script src="../../assets/js/ace/elements.colorpicker.js"></script>
		<script src="../../assets/js/ace/elements.fileinput.js"></script>
		<script src="../../assets/js/ace/elements.typeahead.js"></script>
		<script src="../../assets/js/ace/elements.wysiwyg.js"></script>
		<script src="../../assets/js/ace/elements.spinner.js"></script>
		<script src="../../assets/js/ace/elements.treeview.js"></script>
		<script src="../../assets/js/ace/elements.wizard.js"></script>
		<script src="../../assets/js/ace/elements.aside.js"></script>
		<script src="../../assets/js/ace/ace.js"></script>
		<script id="_ajaxContent" src="../../assets/js/ace/ace.ajax-content.js" data-path="/Ace"></script>
		<script src="../../assets/js/ace/ace.touch-drag.js"></script>
		<script src="../../assets/js/ace/ace.sidebar.js"></script>
		<script src="../../assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="../../assets/js/ace/ace.submenu-hover.js"></script>
		<script src="../../assets/js/ace/ace.widget-box.js"></script>
		<script src="../../assets/js/ace/ace.settings.js"></script>
		<script src="../../assets/js/ace/ace.settings-rtl.js"></script>
		<script src="../../assets/js/ace/ace.settings-skin.js"></script>
		<script src="../../assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="../../assets/js/ace/ace.searchbox-autocomplete.js"></script>
	</body>
</html>