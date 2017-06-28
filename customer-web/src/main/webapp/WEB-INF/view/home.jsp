<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>后台管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="${_staticPath}/resource/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
	<%-- <link rel="stylesheet" href="${_staticPath}/resource/bootstrap-3.3.5/css/font-awesome.min.css" /> --%>
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
	<script src="${_staticPath}/resource/ace/js/grid.locale-cn.js"></script>
	<script src="${_staticPath}/resource/ace/js/bootstrap-datepicker.min.js"></script>
	
<%-- 	
	<script src="${_staticPath}/custom/jquery.form.min.js"></script>
	<script src="${_staticPath}/custom/jquery.table.min.js"></script>
	<script src="${_staticPath}/assets/js/bootbox.js"></script>
	<script src="${_staticPath}/custom/assets/bootbox.custom.js"></script>
	<script src="${_staticPath}/custom/assets/jquery.gritter.custom.js"></script>
	<script src="${_staticPath}/custom/jquery.validate-2.0.min.js"></script>
	<script src="${_staticPath}/custom/jquery.validate-2.0.custom.min.js"></script> --%>
	
	<!-- <script src="./main.js"></script> -->
	<script src="${_path}/table.js"></script>	
	<!-- <script src="./warn.js"></script>  -->
	<script type="text/javascript">
		var _path = "http://192.168.10.201:8086/customer-web";
		//var _staticpath;
		//var $path_base = "/";//this will be used in gritter alerts containing images
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
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
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
				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">监控页面</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
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
<script type="text/javascript">
/* function darwAgin(){
	alert($('.nav-tabs .active a').attr('href'));

	$('#back').click(function(){
		
	})
} */
$(function(){	
	//$('#mapDevice').css('width',$('.tab-content').width());
	$('#mapServe').css('width',$('.tab-content').width());
	$('#mapQuality').css('width',$('.tab-content').width());
	$('#mapWater').css('width',$('.tab-content').width());
	var mapChart = echarts.init(document.getElementById('mapDevice')),
		mapServe = echarts.init(document.getElementById('mapServe')),
		mapQuality = echarts.init(document.getElementById('mapQuality')),
		mapWater = echarts.init(document.getElementById('mapWater')),
	    geoCoordMap = {
		    '上海': [121.4648, 31.2891],
		    '东莞': [113.8953, 22.901],
		    '东营': [118.7073, 37.5513],
		    '中山': [113.4229, 22.478],
		    '临汾': [111.4783, 36.1615],
		    '临沂': [118.3118, 35.2936],
		    '丹东': [124.541, 40.4242],
		    '丽水': [119.5642, 28.1854],
		    '乌鲁木齐': [87.9236, 43.5883],
		    '佛山': [112.8955, 23.1097],
		    '保定': [115.0488, 39.0948],
		    '兰州': [103.5901, 36.3043],
		    '包头': [110.3467, 41.4899],
		    '北京': [116.4551, 40.2539],
		    '北海': [109.314, 21.6211],
		    '南京': [118.8062, 31.9208],
		    '南宁': [108.479, 23.1152],
		    '南昌': [116.0046, 28.6633],
		    '南通': [121.1023, 32.1625],
		    '厦门': [118.1689, 24.6478],
		    '台州': [121.1353, 28.6688],
		    '合肥': [117.29, 32.0581],
		    '呼和浩特': [111.4124, 40.4901],
		    '咸阳': [108.4131, 34.8706],
		    '哈尔滨': [127.9688, 45.368],
		    '唐山': [118.4766, 39.6826],
		    '嘉兴': [120.9155, 30.6354],
		    '大同': [113.7854, 39.8035],
		    '大连': [122.2229, 39.4409],
		    '天津': [117.4219, 39.4189],
		    '太原': [112.3352, 37.9413],
		    '威海': [121.9482, 37.1393],
		    '宁波': [121.5967, 29.6466],
		    '宝鸡': [107.1826, 34.3433],
		    '宿迁': [118.5535, 33.7775],
		    '常州': [119.4543, 31.5582],
		    '广州': [113.5107, 23.2196],
		    '廊坊': [116.521, 39.0509],
		    '延安': [109.1052, 36.4252],
		    '张家口': [115.1477, 40.8527],
		    '徐州': [117.5208, 34.3268],
		    '德州': [116.6858, 37.2107],
		    '惠州': [114.6204, 23.1647],
		    '成都': [103.9526, 30.7617],
		    '扬州': [119.4653, 32.8162],
		    '承德': [117.5757, 41.4075],
		    '拉萨': [91.1865, 30.1465],
		    '无锡': [120.3442, 31.5527],
		    '日照': [119.2786, 35.5023],
		    '昆明': [102.9199, 25.4663],
		    '杭州': [119.5313, 29.8773],
		    '枣庄': [117.323, 34.8926],
		    '柳州': [109.3799, 24.9774],
		    '株洲': [113.5327, 27.0319],
		    '武汉': [114.3896, 30.6628],
		    '汕头': [117.1692, 23.3405],
		    '江门': [112.6318, 22.1484],
		    '沈阳': [123.1238, 42.1216],
		    '沧州': [116.8286, 38.2104],
		    '河源': [114.917, 23.9722],
		    '泉州': [118.3228, 25.1147],
		    '泰安': [117.0264, 36.0516],
		    '泰州': [120.0586, 32.5525],
		    '济南': [117.1582, 36.8701],
		    '济宁': [116.8286, 35.3375],
		    '海口': [110.3893, 19.8516],
		    '淄博': [118.0371, 36.6064],
		    '淮安': [118.927, 33.4039],
		    '深圳': [114.5435, 22.5439],
		    '清远': [112.9175, 24.3292],
		    '温州': [120.498, 27.8119],
		    '渭南': [109.7864, 35.0299],
		    '湖州': [119.8608, 30.7782],
		    '湘潭': [112.5439, 27.7075],
		    '滨州': [117.8174, 37.4963],
		    '潍坊': [119.0918, 36.524],
		    '烟台': [120.7397, 37.5128],
		    '玉溪': [101.9312, 23.8898],
		    '珠海': [113.7305, 22.1155],
		    '盐城': [120.2234, 33.5577],
		    '盘锦': [121.9482, 41.0449],
		    '石家庄': [114.4995, 38.1006],
		    '福州': [119.4543, 25.9222],
		    '秦皇岛': [119.2126, 40.0232],
		    '绍兴': [120.564, 29.7565],
		    '聊城': [115.9167, 36.4032],
		    '肇庆': [112.1265, 23.5822],
		    '舟山': [122.2559, 30.2234],
		    '苏州': [120.6519, 31.3989],
		    '莱芜': [117.6526, 36.2714],
		    '菏泽': [115.6201, 35.2057],
		    '营口': [122.4316, 40.4297],
		    '葫芦岛': [120.1575, 40.578],
		    '衡水': [115.8838, 37.7161],
		    '衢州': [118.6853, 28.8666],
		    '西宁': [101.4038, 36.8207],
		    '西安': [109.1162, 34.2004],
		    '贵阳': [106.6992, 26.7682],
		    '连云港': [119.1248, 34.552],
		    '邢台': [114.8071, 37.2821],
		    '邯郸': [114.4775, 36.535],
		    '郑州': [113.4668, 34.6234],
		    '鄂尔多斯': [108.9734, 39.2487],
		    '重庆': [107.7539, 30.1904],
		    '金华': [120.0037, 29.1028],
		    '铜川': [109.0393, 35.1947],
		    '银川': [106.3586, 38.1775],
		    '镇江': [119.4763, 31.9702],
		    '长春': [125.8154, 44.2584],
		    '长沙': [113.0823, 28.2568],
		    '长治': [112.8625, 36.4746],
		    '阳泉': [113.4778, 38.0951],
		    '青岛': [120.4651, 36.3373],
		    '韶关': [113.7964, 24.7028]
		};
		;
		drawDeviceChart(mapChart,geoCoordMap);				
		
		var a ='china',t1='服务效率分布图',t2='服务评价分布图',t3='水质图',
			dataServe = [
		    { name: "上海", value: 29},
		    { name: "珠海", value: 21},
		    { name: "三亚", value: 11},
		    { name: "惠州", value: 19},
		    { name: "海口", value: 25},
		    { name: "合肥", value: 40},
		    { name: "南京", value: 69},
		    { name: "杭州", value: 56},
		    { name: "苏州", value: 67},
		    { name: "无锡", value: 33},
		    { name: "昆山", value: 18},
		    { name: "广州", value: 15},
		    { name: "深圳", value: 8},
		    { name: "佛山", value: 57},
		    { name: "东莞", value: 30},
		    { name: "福州", value: 45},
		    { name: "厦门", value: 33},
		    { name: "南宁", value: 31},
		    { name: "郑州", value: 66},
		    { name: "武汉", value: 86},
		    { name: "长沙", value: 53},
		    { name: "南昌", value: 30},
		    { name: "北京", value: 20},
		    { name: "长春", value: 30},
		    { name: "大连", value: 32},
		    { name: "沈阳", value: 45},
		    { name: "哈尔滨", value: 31},
		    { name: "天津", value: 86},
		    { name: "济南", value: 43},
		    { name: "青岛", value: 66},
		    { name: "太原", value: 40},
		    { name: "石家庄", value: 61},
		    { name: "西安", value: 69},
		    { name: "成都", value: 13},
		    { name: "重庆", value: 13},
		    { name: "昆明", value: 46},
		],dataQuality=[
			{ name: "青岛", value: 86},
		    { name: "太原", value: 30},
		    { name: "石家庄", value:81},
		    { name: "西安", value: 69},
		    { name: "成都", value: 43},
		    { name: "重庆", value: 23},
		    { name: "昆明", value: 46}
		],dataWater =[
			{ name: "福州", value: 45},
		    { name: "厦门", value: 23},
		    { name: "南宁", value: 31},
		    { name: "郑州", value: 56},
		    { name: "武汉", value: 36},
		    { name: "长沙", value: 35},
		    { name: "南昌", value: 65},
		    { name: "北京", value: 21},
		    { name: "长春", value: 90},
		    { name: "大连", value: 32},
		];	
		drawChart(mapServe,geoCoordMap,a,dataServe,t1);
		drawChart(mapQuality,geoCoordMap,a,dataQuality,t2);
		drawChart(mapWater,geoCoordMap,a,dataWater,t3);	 
	//返回全国按钮
	$('#back').click(function(){
		
		if($('.nav-tabs li:eq(1)').hasClass('active')){
			$('#proviceServe').hide();
			$('#mapServe').show();	
		}else if($('.nav-tabs li:eq(2)').hasClass('active')){
			$('#proviceQuality').hide();
			$('#mapQuality').show();
		}else if($('.nav-tabs li:eq(3)').hasClass('active')){
			$('#proviceWater').hide();
			$('#mapWater').show();
		}else if($('.nav-tabs li:eq(0)').hasClass('active')){
			$('#proviceDevice').hide();
			$('#mapDevice').show();
		}
	}) ;
	darwAgin()	
});
//tab页面切换重绘
 function darwAgin(){
	 $('a[href="#efficieDiv"]').click(function(){
	 	$('#proviceServe').hide();
		$('#mapServe').show();
	 })
};
function drawChart(mapDiv,geoCoordMap,a,data,text){	
var convertData = function(data) {
    var res = [];
    //console.log(data);
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
};

var convertedData = [
    convertData(data),
    convertData(data.sort(function(a, b) {
        return b.value - a.value;
    }).slice(0, 6))
];
data.sort(function(a, b) {
    return a.value - b.value;
})

var selectedItems = [];
var categoryData = [];
var barData = [];
//   var maxBar = 30;
var sum = 0;
var count = data.length;
for (var i = 0; i < data.length; i++) {
    categoryData.push(data[i].name);
    barData.push(data[i].value);
    sum += data[i].value;
}
//console.log(categoryData);
//console.log(sum + "   " + count)
option = {
    backgroundColor: text =='服务评价分布图'?'#1b1b1b':'#404a59',
    animation: true,
    animationDuration: 1000,
    animationEasing: 'cubicInOut',
    animationDurationUpdate: 1000,
    animationEasingUpdate: 'cubicInOut',
    title: [{
        text: text,
        //link: 'http://pages.anjuke.com/expert/newexpert.html',
        subtext: '内部数据',
        //sublink: 'http://pages.anjuke.com/expert/newexpert.html',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    }, {
        id: 'statistic',
        text: count ? '平均: ' + parseInt((sum / count).toFixed(4)) : '',
        right: 120,
        top: 40,
        width: 100,
        textStyle: {
            color: '#fff',
            fontSize: 16
        }
    }],
    toolbox: {
        iconStyle: {
            normal: {
                borderColor: '#fff'
            },
            emphasis: {
                borderColor: '#b1e4ff'
            }
        },
        feature: {
            dataZoom: {},
            brush: {
                type: ['rect', 'polygon', 'clear']
            }, 
            saveAsImage: {
                show: true
            },
            myTool1:{
            	show:true,
            	title:'全屏显示',
            	icon:'image://${_staticPath}/resource/images/backPro/eyew.png',
            	onclick : function(){
            		$('#mapServe').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
            		 $('#mapQuality').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
            		 $('#mapWater').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
						var mapServe = echarts.init(document.getElementById('mapServe')),
							mapQuality = echarts.init(document.getElementById('mapQuality')),
							mapWater = echarts.init(document.getElementById('mapWater'));
            		 		mapServe.resize();
							mapQuality.resize();
							mapWater.resize();
            	}
            },
            myTool2:{
            	show:true,
            	title:'复原',
            	icon:'image://${_staticPath}/resource/images/backPro/eye.png',
            	onclick : function(){
            		$('#mapServe').css({'width':$('.tab-content').width(),'top':'0px','height':'700px','left':0});
            		$('#mapQuality').css({'width':$('.tab-content').width(),'top':'0px','height':'700px','left':0});
            		$('#mapWater').css({'width':$('.tab-content').width(),'top':'0px','height':'700px','left':0}); 
            		var mapServe = echarts.init(document.getElementById('mapServe')),
						mapQuality = echarts.init(document.getElementById('mapQuality')),
						mapWater = echarts.init(document.getElementById('mapWater'));
          		 		mapServe.resize();
						mapQuality.resize();
						mapWater.resize();           		
            	}
            },
           /*  myTool3:{
            	show:true,
            	title:'返回第一级',
            	icon:'image://./images/home.png',
            	onclick : function(param){  
            		//console.log(param) 
           		var mapServe = echarts.init(document.getElementById('mapServe')),
					mapQuality = echarts.init(document.getElementById('mapQuality')),
					mapWater = echarts.init(document.getElementById('mapWater'));        		
           			drawChart(mapServe,geoCoordMap,a,data,'服务效率分布图');
            	}
            } */
        }
    },
    brush: {
        outOfBrush: {
            color: '#abc'
        },
        brushStyle: {
            borderWidth: 2,
            color: 'rgba(0,0,0,0.2)',
            borderColor: 'rgba(0,0,0,0.5)',
        },
        seriesIndex: [0, 1],
        throttleType: 'debounce',
        throttleDelay: 300,
        geoIndex: 0
    },
    geo: {
        map: a,
        left: '0',
        right: '35%',
        label :{
			normal:{show:true,
					textStyle:{
						color:'#fff'
					}
			}
		},
       // center: [117.98561551896913, 31.205000490896193],
        //zoom: 1.5,
        //roam: true,
        itemStyle: {
            normal: {
                areaColor: '#323c48',
                borderColor: '#111'
            },
            emphasis: {
                areaColor: '#2a333d'
            }
        }
    },
    tooltip: {
        trigger: 'item',
        formatter: function(param){
        			return param.name +':' +param.value[2];},
    },
     grid: {
        right: 0,
        top: 100,
        bottom: 40,
        width: '30%'
    }, 
    xAxis: {
        type: 'value',
        scale: true,
        position: 'top',
        boundaryGap: false,
        splitLine: {
            show: false
        },
        axisLine: {
            show: false
        },
        axisTick: {
            show: false
        },
        axisLabel: {
            margin: 2,
            textStyle: {
                color: '#aaa'
            }
        },
    },
    yAxis: {
        type: 'category',
        //  name: 'TOP 20',
        nameGap: 16,
        axisLine: {
            show: true,
            lineStyle: {
                color: '#ddd'
            }
        },
        axisTick: {
            show: false,
            lineStyle: {
                color: '#ddd'
            }
        },
        axisLabel: {
            interval: 0,
            textStyle: {
                color: '#ddd'
            }
        },
        data: categoryData
    },     
    series: [{
        type: 'scatter',
        coordinateSystem: 'geo',
        data: convertedData[0],
        symbolSize: function(val) {
            return Math.max(val[2] / 3, 8);
        },
        label: {
            normal: {
                formatter: '{b}',
                position: 'right',
                show: false
            },
            emphasis: {
                show: true
            }
        },
        itemStyle: {
            normal: {
                color: '#FF8C00',
                position: 'right',
                show: true
            }
        }
    }, {		       
        type: 'effectScatter',
        coordinateSystem: 'geo',
        data: convertedData[0],
        zlevel: 2,
        symbol:'emptyCircle',//空心
        symbolSize: function(val) {
            return Math.max(val[2] / 5, 8);
        },
        showEffectOn: 'render',
        rippleEffect: {
       		scale:4,
            brushType: 'fill'
        },
        hoverAnimation: true,
        label: {
            normal: {
                formatter: function(param){
        			return param.name +':' +param.value[2];},
                position: 'right',
                show: true 
            }
        },
        itemStyle: {
            normal: {
                color: '#f4e925',
                shadowBlur: 50,
                shadowColor: '#EE0000'
            }
        },
        zlevel: 1 
        
    }, {
        id: 'bar',
        zlevel: 2,
        type: 'bar',
        symbol: 'none',
        itemStyle: {
            normal: {
                color: '#ddb926'
            }
        },

        data: data
    }]
};
	if(text == '水质图'){
		option.visualMap ={
			type:'continuous',
	        min : 0,
	        max : 100,
	        calculable : true,
	        color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
	        textStyle:{
	            color:'#fff'
	        }
		}
	}
	mapDiv.setOption(option);
 	window.onresize = mapDiv.resize;
	mapDiv.on('click',function(param){
		//alert(param);
		clickDown(param,geoCoordMap);
	})
}
function clickDown(param,geoCoordMap){
	//服务效率页面下钻
	$('#mapServe').hide();
	$('#proviceServe').show();	
	$('#proviceServe').css('width',$('.tab-content').width());
	var mySecondChart = echarts.init(document.getElementById('proviceServe')),
	data = [{ name: "成都", value: 90}];
	drawChart(mySecondChart,geoCoordMap,param.name,data); 
	
	//服务评价页面下钻
	$('#mapQuality').hide();
	$('#proviceQuality').show();	
	$('#proviceQuality').css('width',$('.tab-content').width());
	var myproviceChart = echarts.init(document.getElementById('proviceQuality')),
	data = [{ name: "成都", value: 60}];
	drawChart(myproviceChart,geoCoordMap,param.name,data); 
	
	//水质页面下钻
	$('#mapWater').hide();
	$('#proviceWater').show();	
	$('#proviceWater').css('width',$('.tab-content').width());
	var myWaterChart = echarts.init(document.getElementById('proviceWater')),
	data = [{ name: "成都", value: 10}];
	drawChart(myWaterChart,geoCoordMap,param.name,data);
}



function drawDeviceChart(mapChart,geoCoordMap){
var data = [
    [{name: '成都' }, { name: '上海',value: 85,value2: 45}],
    [{name: '成都'}, {name: '广州', value: 70,value2: 0}],
    [{name: '成都'}, { name: '大连', value: 60,value2: 15}],
    [{name: '成都'}, { name: '南宁',value: 50,value2: 0}],
    [{ name: '成都' }, {name: '南昌',value: 50,value2: 25}],
    [{name: '成都' }, {name: '拉萨', value: 45,value2: 25 }],
    [{name: '成都'}, {name: '长春', value: 40 ,value2: 0}],
    [{name: '成都' }, { name: '包头',value: 30,value2: 35}],
    [{name: '成都'}, {name: '重庆', value: 20 ,value2: 0}],
    [{name: '成都'}, {name: '常州',value: 10,value2: 5}]
];
var convertData = function(data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var dataItem = data[i];
        var fromCoord = geoCoordMap[dataItem[1].name];
        var toCoord = geoCoordMap[dataItem[0].name];
        if (fromCoord && toCoord) {
            res.push({
                fromName: dataItem[1].name,
                toName: dataItem[0].name,
                coords: [fromCoord, toCoord]
            });
        }
    }
    //console.log(res);
    return res;
};
//此处是排序 ，后台排好？
 /* var convertedData = [
    convertData(data),
    convertData(data.sort(function(a, b) {
        return b.value - a.value;
    }).slice(0, 6))
];
data.sort(function(a, b) {
    return a.value - b.value;
})  */

//var selectedItems = [];
var categoryData = [];
var barData = [];
//   var maxBar = 30;
var sum = 0;
var count = data.length;
for (var i = 0; i < data.length; i++) {
	var dataItem = data[i];
    categoryData.push(dataItem[1].name);
    //barData.push(dataItem[1].value);
    barData.push({
                name: dataItem[1].name,
                value: dataItem[1].value
            });
    sum += dataItem[1].value;
}
//console.log(selectedItems);
//console.log(categoryData);
//console.log(barData);
//console.log(data);
var color = ['#a6c84c', '#ffa022', '#46bee9'];
var series = [];
    series.push({
        name: '',
        type: 'lines',
        zlevel: 1,
        effect: {
            show: true,
            period: 6,
            trailLength: 0.7,
            color: 'red',
            symbol:'pin',
            symbolSize: 3
        },
        lineStyle: {
            normal: {
                color: '#a6c84c',
                width: 0,
                curveness: 0.2
            }
        },        
        data: convertData(data)
    }, {
        name: '',
        type: 'lines',
        zlevel: 2,
        symbol: ['none', 'roundRect'],
        symbolSize: 8,
        effect: {
            show: true,
            period: 6,
            trailLength: 0,
           	symbol:'diamond',
            symbolSize: 2
        },
        lineStyle: {
            normal: {
                color: '#F9EE9F',
                width: 1,
                opacity: 0.6,
                curveness: 0.2
            }
        },
        data: convertData(data)
    }, {
        name: '',
        type: 'effectScatter',
        coordinateSystem: 'geo',
        zlevel: 2,
        rippleEffect: {
        	scale:4,
            brushType: 'fill'
        },
        symbol:'emptyCircle',
        symbolSize: function(val) {
            return val[2] / 5;
        },
        itemStyle:{
           normal:{
               label:{show:true},
               color:function(param){
               		if(param.value[3] > 0)return 'orange'
               		else return 'aqua'
               },
               opacity:0,
               //borderClolor:'red',
               //shadowColor:'yellow',
               shadowBlur:50,
           },
           emphasis: {
               label:{position:'top'}
             }
          },
        tooltip : {
	        //trigger: 'item',
	        formatter: function(param){
	        	return param.name +':' +param.value[2] + '/'+param.value[3];
	        }
	    },           
        data:data.map(function(dataItem) {
            return {
                name: dataItem[1].name,
                value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value,dataItem[1].value2])
            };
        }) 
    },
    {
        id: 'bar',
        zlevel: 2,
        type: 'bar',
        symbol: 'none',
        itemStyle: {
            normal: {
                color: '#ddb926'
            }
        },

        data: barData.reverse()
    }
  )
  console.log(series);
option = {
    backgroundColor: '#1b1b1b',
    title: [{
        text: '项目/设备分布图',
        subtext: '内部数据请勿外传',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    },
    {
        id: 'statistic',
        text: count ? '平均: ' + parseInt((sum / count).toFixed(4)) : '',
        right: 120,
        top: 40,
        width: 100,
        textStyle: {
            color: '#fff',
            fontSize: 16
        }
    }
    ],
      tooltip : {
        trigger: 'item',
        /* formatter: function(param){
        	return param.name +':' +param.value[2] + '/'+param.value[3];
        } */
    }, 
    toolbox: {
        show : true,
        //orient : 'vertical',
        //x: 'right',
        //y: 'center',
        feature : {
            mark : {show: false},
            dataView : {show: false, readOnly: false},
            restore : {show: false},
            saveAsImage : {show: true},
            myTool3:{
            	show:true,
            	title:'全屏显示',
            	icon:'image://${_staticPath}/resource/images/backPro/eyew.png',
            	onclick : function(){
            		$('#mapDevice').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
						var mapChart = echarts.init(document.getElementById('mapDevice'));
            		 		mapChart.resize();
            	}
            },
            myTool4:{
            	show:true,
            	title:'复原',
            	icon:'image://${_staticPath}/resource/images/backPro/eye.png',
            	onclick : function(){
            		$('#mapDevice').css({'width':$('.tab-content').width(),'top':'0px','height':'700px','left':0});
            		var mapChart = echarts.init(document.getElementById('mapDevice'));
           		 		mapChart.resize();        		
            	}
            },
        }
		    },
    brush: {
        outOfBrush: {
            color: '#abc'
        },
        brushStyle: {
            borderWidth: 2,
            color: 'rgba(0,0,0,0.2)',
            borderColor: 'rgba(0,0,0,0.5)',
        },
        seriesIndex: [0, 1],
        throttleType: 'debounce',
        throttleDelay: 300,
        geoIndex: 0
    },
    geo :{
		map : 'china',
		selectedMode: 'single',
		left: '0',
        right: '35%',
		center: [103.9526, 30.7617],
        zoom: 1.5,
		roam:true,
		label :{
			normal:{show:true,
					textStyle:{
						color:'#ccc'
					}
			}
		},
		itemStyle:{
              normal:{
                  borderColor:'rgba(100,149,237,1)',
                  borderWidth:0.5,
                  areaColor:'#1b1b1b'
              }
            },
	},
	grid: {
        right: 0,
        top: 100,
        bottom: 40,
        width: '30%'
    }, 
    xAxis: {
        type: 'value',
        scale: true,
        position: 'top',
        boundaryGap: false,
        splitLine: {
            show: false
        },
        axisLine: {
            show: false
        },
        axisTick: {
            show: false
        },
        axisLabel: {
            margin: 2,
            textStyle: {
                color: '#aaa'
            }
        },
    },
    yAxis: {
        type: 'category',
        //  name: 'TOP 20',
        nameGap: 16,
        axisLine: {
            show: true,
            lineStyle: {
                color: '#ddd'
            }
        },
        axisTick: {
            show: false,
            lineStyle: {
                color: '#ddd'
            }
        },
        axisLabel: {
            interval: 0,
            textStyle: {
                color: '#ddd'
            }
        },
        data: categoryData.reverse()
    },         
    series: series   
};
	mapChart.setOption(option);	
	window.onresize = mapChart.resize;
	mapChart.on('click',function(param){
		//console.log(param)
	//请求数据,成功后回调函数里画表
	var data =[{name: "成都", value: [103.9526, 30.7617,100,40]},
	   			{name: "自贡", value: [104.773447,29.352765,70,0]},
	  			{name: "攀枝花", value: [101.716007,26.580446,50,10]},
   				{name: "德阳", value: [104.398651,31.127991,40,40]}]
		clickProviceDown(param,data);		
	});
}
//项目/设备分布图下钻
function clickProviceDown(param,data){	
/* 	    barData = data.map(function(dataItem) {
		            return {
		                name: dataItem.name,
		                value: dataItem.value[2]
		            };
		        }),
        yData =data.map(function(dataItem) {
            return dataItem.name	
        }); */
        var sum = 0,barData=[],yData=[];
		var count = data.length;
		for (var i = 0; i < data.length; i++) {
		    yData.push(data[i].name);
		    barData.push({
		                name: data[i].name,
		                value: data[i].value[2]
		            });
		    sum += data[i].value[2];
		}
       //console.log(barData);
       
      $('#proviceDevice').css('width',$('.tab-content').width());
	var myChartProvice = echarts.init(document.getElementById('proviceDevice'));
		var selectProvice = param.name;
		//console.log(selectProvice);
		var option = {
			backgroundColor: '#1b1b1b',
		    title: [{
		        text: selectProvice+'项目/设备分布图',
		        subtext: '数据纯属虚构',
		        left: 'center',
		        textStyle: {
		            color: '#fff'
		        }
		    },
		    {
	        id: 'statistic',
	        text: count ? '平均: ' + parseInt((sum / count).toFixed(4)) : '',
	        right: 120,
	        top: 40,
	        width: 100,
	        textStyle: {
	            color: '#fff',
	            fontSize: 16
	        }
	    }],
		    tooltip : {
		        trigger: 'item',
		        formatter: '{b}'
		    },
		   toolbox: {
		        show : true,
		        //orient : 'vertical',
		        //x: 'right',
		        //y: 'center',
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true},
		            myTool3:{
		            	show:true,
		            	title:'全屏显示',
		            	icon:'image://${_staticPath}/resource/images/backPro/eyew.png',
		            	onclick : function(){
		            		$('#myChartProvice').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
		            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
							var	myChartProvice = echarts.init(document.getElementById('proviceDevice'));
	            		 		myChartProvice.resize();
		            	}
		            },
		            myTool4:{
		            	show:true,
		            	title:'复原',
		            	icon:'image://${_staticPath}/resource/images/backPro/eye.png',
		            	onclick : function(){
		            		$('#myChartProvice').css({'width':$('.tab-content').width(),'top':'0px','height':'700px','left':0});
		            		var myChartProvice = echarts.init(document.getElementById('proviceDevice'));
	            		 		myChartProvice.resize();        		
		            	}
		            },
		        }
		    },
		     grid: {
		        right: 0,
		        top: 100,
		        bottom: 40,
		        width: '30%'
		    },  
		     brush: {
		        outOfBrush: {
		            color: '#abc'
		        },
		        brushStyle: {
		            borderWidth: 2,
		            color: 'rgba(0,0,0,0.2)',
		            borderColor: 'rgba(0,0,0,0.5)',
		        },
		        seriesIndex: [0, 1],
		        throttleType: 'debounce',
		        throttleDelay: 300,
		        geoIndex: 0
		    },
		    xAxis: {
		        type: 'value',
		        scale: true,
		        position: 'top',
		        boundaryGap: false,
		        splitLine: {
		            show: false
		        },
		        axisLine: {
		            show: false
		        },
		        axisTick: {
		            show: false
		        },
		        axisLabel: {
		            margin: 2,
		            textStyle: {
		                color: '#aaa'
		            }
		        },
		    },
		    yAxis: {
		    	//show:false,
		        type: 'category',
		        //  name: 'TOP 20',
		        nameGap: 16,
		        axisLine: {
		            show: true,
		            lineStyle: {
		                color: '#ddd'
		            }
		        },
		        axisTick: {
		            show: false,
		            lineStyle: {
		                color: '#ddd'
		            }
		        },
		        axisLabel: {
		            interval: 0,
		            textStyle: {
		                color: '#ddd'
		            }
		        },
		        data: yData.reverse()
		    },
		    geo :{
				map : selectProvice,
				selectedMode: 'single',
				left: '0',
		        right: '35%',
				center: [103.9526, 30.7617],
		        zoom: 0.6,
		        roam:true,
		        label :{
					normal:{show:true,
							textStyle:{
								color:'#ccc'
							}
					}
				},
				itemStyle:{
		              normal:{
		                  borderColor:'rgba(100,149,237,1)',
		                  borderWidth:0.5,
		                  areaColor:'#1b1b1b'
		              }
		            },
			},        
		     /* visualMap: {
		    	type:'continuous',
		        min : 0,
		        max : 100,
		        calculable : true,
		        color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
		        textStyle:{
		            color:'#fff'
		        }
		    }, */
		    series :[{
	    	name : selectProvice + '分布图',
	    	type:'scatter',
	    	coordinateSystem: 'geo',
	    	data:data
	    	},{
	    		type: 'effectScatter',
		        coordinateSystem: 'geo',
		        zlevel: 2,
		        rippleEffect: {
		        	scale:4,
		            brushType: 'fill'
		        },
		        symbol:'emptyCircle',
		        symbolSize: function(val) {
		            return val[2] / 5;
		        },
		        itemStyle:{
		           normal:{
		               label:{show:true},
		               color:function(param){
		               		if(param.value[3] > 0)return 'orange'
		               		else return 'aqua'
		               },
		               opacity:0,
		               //borderClolor:'red',
		               //shadowColor:'yellow',
		               shadowBlur:50,
		           },
		           emphasis: {
		               label:{position:'top'}
		           }
		                },
			        data: data
	    	},
	    	 {
		        id: 'bar',
		        zlevel: 2,
		        type: 'bar',
		        symbol: 'none',
		        itemStyle: {
		            normal: {
		                color: '#ddb926'
		            }
		        },		
		        data: barData.reverse()
		    }        	
	    ]  	      
 	}
	    $('#proviceDevice').show();
	    $('#mapDevice').hide();
	    myChartProvice.setOption(option, true);
	    window.onresize = myChartProvice.resize;
	    myChartProvice.on('click',function(param){
	    	//console.log(param);
		   var  data =[{name: "锦江区", value: [104.080989, 30.657689]},
					   {name: "金牛区", value: [104.043487, 30.692058]},
					   {name: "青羊区", value: [104.055731, 30.667648]},
					   {name: "成华区", value: [104.103077, 30.660275]}]
	    	clickProviceDown(param,data);
	    })
}
</script>
</html>

