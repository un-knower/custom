<%@ page language="java" pageEncoding="utf-8"%>
<%  
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);   
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		<meta charset="utf-8" />
		<title>${_systemName}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		
		
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
	
		<script  src="${_staticPath}/custom/assets/ace.ajax-content.js"></script>
		<!-- ace scripts -->
		<script src="${_staticPath}/assets/js/ace/elements.scroller.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.colorpicker.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.fileinput.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.typeahead.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.wysiwyg.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.spinner.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.treeview.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.wizard.js"></script>
		<script src="${_staticPath}/assets/js/ace/elements.aside.js"></script>
		<!-- 修改默认首页 -->
		<script id="_ace" src="${_staticPath}/custom/assets/ace.js?v" data-path="${defaultPage}"></script>
		<!-- 切换菜单处理 -->
		<script id="_ajaxContent" src="${_staticPath}/custom/assets/ace.ajax-content.js?v" data-path="${_path}"></script>
		<!-- 权限处理 -->
		<script id="_permission" src="${_staticPath}/custom/jquery.permission.min.js?v" data="${sessionUserNoPermissions}"></script>
		<script src="${_staticPath}/assets/js/ace/ace.touch-drag.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.sidebar.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.submenu-hover.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.widget-box.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.settings.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.settings-rtl.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.settings-skin.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="${_staticPath}/assets/js/ace/ace.searchbox-autocomplete.js"></script>	
	
	
	
		
		<script src="${_staticPath}/custom/jquery.form.min.js"></script>
		<script src="${_staticPath}/custom/jquery.table.min.js"></script>
		<script src="${_staticPath}/assets/js/bootbox.js"></script>
		<script src="${_staticPath}/custom/assets/bootbox.custom.js"></script>
		<script src="${_staticPath}/custom/assets/jquery.gritter.custom.js"></script>
		<script src="${_staticPath}/custom/jquery.validate-2.0.min.js"></script>
		<script src="${_staticPath}/custom/jquery.validate-2.0.custom.min.js"></script>
		
		<!-- <script src="./main.js"></script> -->
		<script src="${_path}/table.js"></script>	
		<!-- <script src="./warn.js"></script>  -->
		<script type="text/javascript">
			var _path="${_path}";
			//var _path = "http://192.168.10.201:8086/customer-web";
			var _staticPath="${_staticPath}";
		</script>
		<!-- 文本框 -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/jquery-ui.custom.css" />
		<!-- 多选框 -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/bootstrap-multiselect.css" />
		<!-- 颜色选择  -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/colorpicker.css" />
		<!-- 时间  -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/bootstrap-timepicker.css" />
		<!-- 日期、日期+时间、日期范围  -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/daterangepicker.css" />
		<!-- 提示框  -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/jquery.gritter.css" />
		<!-- 拖拽式单文件上传 -->
		<link rel="stylesheet" href="${_staticPath}/assets/css/dropzone.css" />
		<link rel="stylesheet" href="${_staticPath}/assets/css/uploadifive.css" />
		<script type="text/javascript">
			var scripts = [
				// Form提交Json转换
				"${_staticPath}/custom/jquery.form.min.js?v=" + Math.random(),
				// 列表
				"${_staticPath}/custom/jquery.table.min.js?v=" + Math.random(),
				// 确认框
				"${_staticPath}/assets/js/bootbox.js?v=" + Math.random(),
				"${_staticPath}/custom/assets/bootbox.custom.js?v=" + Math.random(),
				// 自动隐藏的提醒框
				"${_staticPath}/assets/js/jquery.gritter.js?v=" + Math.random(),
				"${_staticPath}/custom/assets/jquery.gritter.custom.js?v=" + Math.random(),
				// UI
				"${_staticPath}/assets/js/jquery-ui.custom.js?v=" + Math.random(),
				// 验证
				"${_staticPath}/custom/jquery.validate-2.0.min.js?v=" + Math.random(),
				"${_staticPath}/custom/jquery.validate-2.0.custom.min.js?v=" + Math.random()
			];
		</script>
		<%-- <script src="${_path}/recordTable.js"></script> --%>
	</head>
	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							监控后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->	
				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a>	
							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-ok"></i>
									还有4个任务完成
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">软件更新</span>
											<span class="pull-right">65%</span>
										</div>
		
										<div class="progress progress-mini ">
											<div style="width:65%" class="progress-bar "></div>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">硬件更新</span>
											<span class="pull-right">35%</span>
										</div>
		
										<div class="progress progress-mini ">
											<div style="width:35%" class="progress-bar progress-bar-danger"></div>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">单元测试</span>
											<span class="pull-right">15%</span>
										</div>
		
										<div class="progress progress-mini ">
											<div style="width:15%" class="progress-bar progress-bar-warning"></div>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">错误修复</span>
											<span class="pull-right">90%</span>
										</div>
		
										<div class="progress progress-mini progress-striped active">
											<div style="width:90%" class="progress-bar progress-bar-success"></div>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										查看任务详情
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>	
						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>	
							<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-warning-sign"></i>
									8条通知
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												新闻评论
											</span>
											<span class="pull-right badge badge-info">+12</span>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										<i class="btn btn-xs btn-primary icon-user"></i>
										切换为编辑登录..
									</a>
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
												新订单
											</span>
											<span class="pull-right badge badge-success">+8</span>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info icon-twitter"></i>
												粉丝
											</span>
											<span class="pull-right badge badge-info">+11</span>
										</div>
									</a>
								</li>	
								<li>
									<a href="#">
										查看所有通知
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>	
						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>	
							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-envelope-alt"></i>
									5条消息
								</li>	
								<li>
									<a href="#">
										<img src="${_staticPath}/resource/images/backPro/avatar.png" class="msg-photo" alt="Alex's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Alex:</span>
												不知道写啥 ...
											</span>
		
											<span class="msg-time">
												<i class="icon-time"></i>
												<span>1分钟以前</span>
											</span>
										</span>
									</a>
								</li>	
								<li>
									<a href="#">
										<img src="${_staticPath}/resource/images/backPro/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Susan:</span>
												不知道翻译...
											</span>
		
											<span class="msg-time">
												<i class="icon-time"></i>
												<span>20分钟以前</span>
											</span>
										</span>
									</a>
								</li>	
								<li>
									<a href="#">
										<img src="${_staticPath}/resource/images/backPro/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Bob:</span>
												到底是不是英文 ...
											</span>
		
											<span class="msg-time">
												<i class="icon-time"></i>
												<span>下午3:15</span>
											</span>
										</span>
									</a>
								</li>	
								<li>
									<a href="inbox.html">
										查看所有消息
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>	
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${_staticPath}/resource/images/backPro/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									Jason
								</span>	
								<i class="icon-caret-down"></i>
							</a>	
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>	
								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>	
								<li class="divider"></li>	
								<li>
									<a href="#">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>
	
						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>
	
						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>
	
						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>
	
						<span class="btn btn-info"></span>
	
						<span class="btn btn-warning"></span>
	
						<span class="btn btn-danger"></span>
					</div>
				</div><!-- #sidebar-shortcuts -->
				<ul class="nav nav-list">
					<li class="active" id="monitor">
						<a href="#">
							<i class="icon-dashboard"></i>
							<span class="menu-text"> 监控页面 </span>
						</a>
					</li>
					<li id="project">
						<a href="#">
							<i class="icon-text-width"></i>
							<span class="menu-text"> 项目管理</span>
						</a>
					</li>
					<li id="device">
						<a href="#" class="dropdown-toggle">
							<i class="icon-desktop"></i>
							<span class="menu-text"> 设备管理 </span>
							<b class="arrow icon-angle-down"></b>
						</a>
					</li>
					<li id="warn">
						<a href="#" class="dropdown-toggle">
							<i class="icon-list"></i>
							<span class="menu-text"> 预警管理 </span>
						</a>
					</li>
					<li id="record">
						<a href="#" class="dropdown-toggle">
							<i class="icon-edit"></i>
							<span class="menu-text"> 评价管理 </span>
						</a>
					</li>
					<li id="user">
						<a href="#">
							<i class="icon-list-alt"></i>
							<span class="menu-text"> 用户管理 </span>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="icon-calendar"></i>
							<span class="menu-text">
								系统设置
								<span class="badge badge-transparent tooltip-error" title="2&nbsp;Important&nbsp;Events">
									<i class="icon-warning-sign red bigger-130"></i>
								</span>
							</span>
						</a>
					</li>
				</ul><!-- /.nav-list -->
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
				
				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">监控页面</li>
						</ul><!-- .breadcrumb -->
		
						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>
				
					<!-- 图表区 -->
					<div class="page-content"  id="monitorPage">
						<div class="page-header">
							<h1>
								监控页面
								<small>
									<i class="icon-double-angle-right"></i>
									 查看
								</small>
							</h1>
							<button class="btn btn-default pull-right" id="back">返回全国</button>
						</div><!-- /.page-header -->
						<div class="row" style="margin: 0 1%;">
							<ul class="nav nav-tabs" role="tablist" style="height:35px;border:none;">
								<li role="presentation" class="active"><a href="#deviceDiv" aria-controls="deviceDiv" role="tab" data-toggle="tab">设备分布图</a></li>
								<li role="presentation"><a href="#efficieDiv" role="tab" data-toggle="tab" aria-controls="efficieDiv">服务效率分布图</a></li>
								<li role="presentation"><a href="#recordDiv" role="tab" data-toggle="tab" aria-controls="recordDiv">服务评价分布图</a></li>
								<li role="presentation"><a href="#waterDiv" role="tab" data-toggle="tab" aria-controls="waterDiv">水质分布图</a></li>
							</ul>
							<div class="tab-content col-xs-12 col-md-12" style="border:none;padding:0 12px;">
								<div role="tabpanel" class="tab-pane active" id="deviceDiv">
									<!-- <div class="col-xs-12 col-md-12"> -->
										<div class="row">
											<div id="mapDevice" style="height:700px;width:100%;"></div>
											<div id="proviceDevice" style="height:700px;width:100%;display: none;"></div>
										</div>
									<!-- </div> -->
								</div>
								<div role="tabpanel" class="tab-pane" id="efficieDiv">
										<div class="row">
											<div id="mapServe" style="height:700px;width:100%;"></div>
											<div id="proviceServe" style="height:700px;width:100%;display: none;">
											</div>
										</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="recordDiv">
										<div class="row">
											<div id="mapQuality" style="height:700px;width:100%;"></div>
											<div id="proviceQuality" style="height:700px;width:100%;display: none;">
											</div>
										</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="waterDiv">
										<div class="row">
											<div id="mapWater" style="height:700px;width:100%;"></div>
											<div id="proviceWater" style="height:700px;width:100%;display: none;">
											</div>
										</div>
								</div>
							</div>													
						</div> 	
					</div>
					<div class="page-content" id="tablePage" style="display:none;">
						<div class="page-header">
							<h1>
								设备管理
								<small><i class="icon-double-angle-right"></i>可编辑</small>
							</h1>
						</div><!-- /.page-header -->
						<div class="row">
							<div class="col-xs-12 ">
								<table id="grid-table" class=""></table>
								<div id="grid-pager"></div>
								
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					<div class="page-content" id="projectTablePage" style="display:none;">
						<div class="page-header">
							<h1>
								项目管理
								<small><i class="icon-double-angle-right"></i>可编辑</small>
							</h1>
						</div><!-- /.page-header -->
						<div class="row">
							<div class="col-xs-12">
								<table id="pro-table"></table>
								<div id="pro-pager"></div>
								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					<div class="page-content" id="warnTablePage" style="display:none;">
						<div class="page-header">
							<h1>
								预警管理
								<small><i class="icon-double-angle-right"></i>可编辑</small>
							</h1>
						</div><!-- /.page-header -->
						<div class="row">
							<div class="col-xs-12">
								<table id="warn-table"></table>
								<div id="warn-pager"></div>
								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					<div class="page-content" id="userTablePage" style="display:none;">
						<div class="page-header">
							<h1>
								用户管理
								<small><i class="icon-double-angle-right"></i>可编辑</small>
							</h1>
						</div><!-- /.page-header -->
						<div class="row">
							<div class="col-xs-12">
								<table id="user-table"></table>
								<div id="user-pager"></div>
								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div>
					<div class="page-content" id="recordTablePage" style="display:none;">
						<div class="page-header">
							<h1>
								评价管理
								<small><i class="icon-double-angle-right"></i>可编辑</small>
							</h1>
						</div><!-- /.page-header -->
						<div class="page-content-area" data-ajax-content="true">
							<div class="col-xs-12">
								<div class="widget-box">
									<div class="widget-header widget-header-small">
										<h5 class="widget-title lighter">搜索栏</h5>
									</div>
				
									<div class="widget-body">
										<div class="widget-main">
											<form id="_form" class="form-inline">
												<label>
													<label class="control-label" for="form-field-1"> 登录名： </label>
													<input name="account" type="text" class="form-data input-medium search-data">
												</label>
											</form>
										</div>
									</div>
								</div>							
								<div>
									<div class="dataTables_wrapper form-inline no-footer table-responsive">
										<table id="_table" class="table table-striped table-bordered table-hover dataTable no-footer">
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
<script src="${_staticPath}/resource/source/echarts.js"></script>
<script src="${_staticPath}/resource/source/chart/china.js"></script>

<script src="${_staticPath}/resource/source/map/qinghai.js"></script>
<script src="${_staticPath}/resource/source/map/shandong.js"></script>
<script src="${_staticPath}/resource/source/map/shanghai.js"></script>
<script src="${_staticPath}/resource/source/map/sichuan.js"></script>
<script src="${_staticPath}/resource/source/map/hubei.js"></script>
<script src="${_staticPath}/resource/source/map/hunan.js"></script>
<script src="${_staticPath}/resource/source/map/chengdu.js"></script>
<script src="${_staticPath}/resource/source/map/dazhou.js"></script>
<script src="${_path}/js/admin/home.js"></script>
</html>

