<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml-transitional.dtd">
<html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>氓聬聨氓聫掳莽庐隆莽聬聠莽鲁禄莽禄聼</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="${_staticPath}bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${_staticPath}bootstrap-3.3.5/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${_staticPath}ace/css/ace.min.css" />
	<link rel="stylesheet" href="${_staticPath}ace/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${_staticPath}ace/css/ace-skins.min.css" />
	
	<link rel="stylesheet" href="${_staticPath}ace/css/ui.jqgrid.css" />
	<link rel="stylesheet" href="${_staticPath}ace/css/daterangepicker.css" />
	
	<script src="${_staticPath}jquery/jquery-2.0.3.min.js"></script>
	
	<script src="${_staticPath}bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="${_staticPath}bootstrap-3.3.5/js/typeahead-bs2.min.js"></script>
	
	<script src="${_staticPath}ace/js/ace-extra.min.js"></script>
	<script src="${_staticPath}ace/js/ace.min.js"></script>	
	
	<script src="${_staticPath}ace/js/jquery.jqGrid.min.js"></script>
	<script src="${_staticPath}ace/js/grid.locale-en.js"></script>
	<script src="${_staticPath}ace/js/bootstrap-datepicker.min.js"></script>
	
	<!-- <script src="${_staticPath}main.js"></script> -->
	<script src="${_staticPath}table.js"></script>
	<!-- <script src="${_staticPath}warn.js"></script>  -->
	<script type="text/javascript">
		/* var _path="http://192.168.10.107:8080/";
		var _staticpath; */
		//var $path_base = "/";//this will be used in gritter alerts containing images
	</script>
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
					莽聸聭忙聨搂氓聬聨氓聫掳莽庐隆莽聬聠莽鲁禄莽禄聼
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
							猫驴聵忙聹聣4盲赂陋盲禄禄氓聤隆氓庐聦忙聢聬
						</li>	
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">猫陆炉盲禄露忙聸麓忙聳掳</span>
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
									<span class="pull-left">莽隆卢盲禄露忙聸麓忙聳掳</span>
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
									<span class="pull-left">氓聧聲氓聟聝忙碌聥猫炉聲</span>
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
									<span class="pull-left">茅聰聶猫炉炉盲驴庐氓陇聧</span>
									<span class="pull-right">90%</span>
								</div>

								<div class="progress progress-mini progress-striped active">
									<div style="width:90%" class="progress-bar progress-bar-success"></div>
								</div>
							</a>
						</li>	
						<li>
							<a href="#">
								忙聼楼莽聹聥盲禄禄氓聤隆猫炉娄忙聝聟
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
							8忙聺隆茅聙職莽聼楼
						</li>	
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">
										<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
										忙聳掳茅聴禄猫炉聞猫庐潞
									</span>
									<span class="pull-right badge badge-info">+12</span>
								</div>
							</a>
						</li>	
						<li>
							<a href="#">
								<i class="btn btn-xs btn-primary icon-user"></i>
								氓聢聡忙聧垄盲赂潞莽录聳猫戮聭莽聶禄氓陆聲..
							</a>
						</li>	
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">
										<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
										忙聳掳猫庐垄氓聧聲
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
										莽虏聣盲赂聺
									</span>
									<span class="pull-right badge badge-info">+11</span>
								</div>
							</a>
						</li>	
						<li>
							<a href="#">
								忙聼楼莽聹聥忙聣聙忙聹聣茅聙職莽聼楼
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
							5忙聺隆忙露聢忙聛炉
						</li>	
						<li>
							<a href="#">
								<img src="${_staticPath}images/avatar.png" class="msg-photo" alt="Alex's Avatar" />
								<span class="msg-body">
									<span class="msg-title">
										<span class="blue">Alex:</span>
										盲赂聧莽聼楼茅聛聯氓聠聶氓聲楼 ...
									</span>

									<span class="msg-time">
										<i class="icon-time"></i>
										<span>1氓聢聠茅聮聼盲禄楼氓聣聧</span>
									</span>
								</span>
							</a>
						</li>	
						<li>
							<a href="#">
								<img src="${_staticPath}images/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
								<span class="msg-body">
									<span class="msg-title">
										<span class="blue">Susan:</span>
										盲赂聧莽聼楼茅聛聯莽驴禄猫炉聭...
									</span>

									<span class="msg-time">
										<i class="icon-time"></i>
										<span>20氓聢聠茅聮聼盲禄楼氓聣聧</span>
									</span>
								</span>
							</a>
						</li>	
						<li>
							<a href="#">
								<img src="${_staticPath}images/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
								<span class="msg-body">
									<span class="msg-title">
										<span class="blue">Bob:</span>
										氓聢掳氓潞聲忙聵炉盲赂聧忙聵炉猫聥卤忙聳聡 ...
									</span>

									<span class="msg-time">
										<i class="icon-time"></i>
										<span>盲赂聥氓聧聢3:15</span>
									</span>
								</span>
							</a>
						</li>	
						<li>
							<a href="inbox.html">
								忙聼楼莽聹聥忙聣聙?β溌壝β堵埫β伮?
								<i class="icon-arrow-right"></i>
							</a>
						</li>
					</ul>
				</li>	
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="${_staticPath}images/user.jpg" alt="Jason's Photo" />
						<span class="user-info">
							<small>忙卢垄猫驴聨氓聟聣盲赂麓,</small>
							Jason
						</span>	
						<i class="icon-caret-down"></i>
					</a>	
					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="#">
								<i class="icon-cog"></i>
								猫庐戮莽陆庐
							</a>
						</li>	
						<li>
							<a href="#">
								<i class="icon-user"></i>
								盲赂陋盲潞潞猫碌聞忙聳聶
							</a>
						</li>	
						<li class="divider"></li>	
						<li>
							<a href="#">
								<i class="icon-off"></i>
								茅聙聙氓聡潞
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
								<span class="menu-text"> 莽聸聭忙聨搂茅隆碌茅聺垄 </span>
							</a>
						</li>
						<li id="project">
							<a href="#">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 茅隆鹿莽聸庐莽庐隆莽聬聠</span>
							</a>
						</li>
						<li id="device">
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 猫庐戮氓陇聡莽庐隆莽聬聠 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
						</li>
						<li id="warn">
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 茅垄聞猫颅娄莽庐隆莽聬聠 </span>
							</a>
						</li>
						<li id="">
							<a href="#" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 猫炉聞盲禄路莽庐隆莽聬聠 </span>
							</a>
						</li>
						<li id="user">
							<a href="#">
								<i class="icon-list-alt"></i>
								<span class="menu-text"> 莽聰篓忙聢路莽庐隆莽聬聠 </span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="icon-calendar"></i>
								<span class="menu-text">
									莽鲁禄莽禄聼猫庐戮莽陆庐
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
								<a href="#">茅娄聳茅隆碌</a>
							</li>
							<li class="active">莽聸聭忙聨搂茅隆碌茅聺垄</li>
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
			<!-- 氓聸戮猫隆篓氓聦潞 -->
			<div class="page-content"  id="monitorPage">
				<div class="page-header">
					<h1>
						莽聸聭忙聨搂茅隆碌茅聺垄
						<small>
							<i class="icon-double-angle-right"></i>
							 忙聼楼莽聹聥
						</small>
					</h1>
				</div><!-- /.page-header -->
				<div class="row" style="margin: 0 1%;">
					<ul class="nav nav-tabs" role="tablist" style="height:35px;border:none;">
						<li role="presentation" class="active"><a href="#deviceDiv" aria-controls="deviceDiv" role="tab" data-toggle="tab">猫庐戮氓陇聡氓聢聠氓赂聝氓聸戮</a></li>
						<li role="presentation"><a href="#efficieDiv" role="tab" data-toggle="tab" aria-controls="efficieDiv">忙聹聧氓聤隆忙聲聢莽聨聡氓聢聠氓赂聝氓聸戮</a></li>
						<li role="presentation"><a href="#recordDiv" role="tab" data-toggle="tab" aria-controls="recordDiv">忙聹聧氓聤隆猫炉聞盲禄路氓聢聠氓赂聝氓聸戮</a></li>
						<li role="presentation"><a href="#waterDiv" role="tab" data-toggle="tab" aria-controls="waterDiv">忙掳麓猫麓篓氓聢聠氓赂聝氓聸戮</a></li>
					</ul>
					<div class="tab-content col-xs-12 col-md-12" style="border:none;padding:0 12px;">
						<div role="tabpanel" class="tab-pane active" id="deviceDiv">
							<!-- <div class="col-xs-12 col-md-12"> -->
								<div class="row">
									<div id="mapDevice" style="height:800px;width:100%;"></div>
									<div id="proviceDevice" style="height:800px;width:100%;display: none;"></div>
								</div>
							<!-- </div> -->
						</div>
						<div role="tabpanel" class="tab-pane" id="efficieDiv">
								<div class="row">
									<div id="mapServe" style="height:800px;width:100%;"></div>
									<div id="proviceServe" style="height:800px;width:100%;display: none;">
									</div>
								</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="recordDiv">
								<div class="row">
									<div id="mapQuality" style="height:800px;width:100%;"></div>
									<div id="proviceQuality" style="height:800px;width:100%;display: none;">
									</div>
								</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="waterDiv">
								<div class="row">
									<div id="mapWater" style="height:800px;width:100%;"></div>
									<div id="proviceWater" style="height:800px;width:100%;display: none;">
									</div>
								</div>
						</div>
					</div>													
				</div> 	
			</div>
			<div class="page-content" id="tablePage" style="display:none;">
				<div class="page-header">
					<h1>
						猫庐戮氓陇聡莽庐隆莽聬聠
						<small><i class="icon-double-angle-right"></i>氓聫炉莽录聳猫戮聭</small>
					</h1>
				</div><!-- /.page-header -->
				<div class="row">
					<div class="col-xs-12 ">
						<table id="grid-table" class="" style="overfli"></table>
						<div id="grid-pager"></div>
						
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.page-content -->
			<div class="page-content" id="projectTablePage" style="display:none;">
				<div class="page-header">
					<h1>
						茅隆鹿莽聸庐莽庐隆莽聬聠
						<small><i class="icon-double-angle-right"></i>氓聫炉莽录聳猫戮聭</small>
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
						茅垄聞猫颅娄莽庐隆莽聬聠
						<small><i class="icon-double-angle-right"></i>氓聫炉莽录聳猫戮聭</small>
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
						莽聰篓忙聢路莽庐隆莽聬聠
						<small><i class="icon-double-angle-right"></i>氓聫炉莽录聳猫戮聭</small>
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
			</div><!-- /.page-content -->
			
</body>
<script src="${_staticPath}source/echarts.js"></script>
<script src="${_staticPath}source/chart/china.js"></script>

<script src="${_staticPath}source/map/qinghai.js"></script>
<script src="${_staticPath}source/map/shandong.js"></script>
<script src="${_staticPath}source/map/shanghai.js"></script>
<script src="${_staticPath}source/map/sichuan.js"></script>
<script src="${_staticPath}source/map/hubei.js"></script>
<script src="${_staticPath}source/map/hunan.js"></script>
<script src="${_staticPath}source/map/忙聢聬茅聝陆氓赂聜.js"></script>
<script src="${_staticPath}source/map/猫戮戮氓路聻氓赂聜.js"></script>
<script type="text/javascript">
function darwAgin(){
	$('.nav-tabs a').click(function(e){
		e.preventDefault()
		$(this).tab('show');
		console.log($(this).html());
	});
}
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
		    '盲赂聤忙碌路': [121.4648, 31.2891],
		    '盲赂聹猫聨聻': [113.8953, 22.901],
		    '盲赂聹猫聬楼': [118.7073, 37.5513],
		    '盲赂颅氓卤卤': [113.4229, 22.478],
		    '盲赂麓忙卤戮': [111.4783, 36.1615],
		    '盲赂麓忙虏聜': [118.3118, 35.2936],
		    '盲赂鹿盲赂聹': [124.541, 40.4242],
		    '盲赂陆忙掳麓': [119.5642, 28.1854],
		    '盲鹿聦茅虏聛忙聹篓茅陆聬': [87.9236, 43.5883],
		    '盲陆聸氓卤卤': [112.8955, 23.1097],
		    '盲驴聺氓庐職': [115.0488, 39.0948],
		    '氓聟掳氓路聻': [103.5901, 36.3043],
		    '氓聦聟氓陇麓': [110.3467, 41.4899],
		    '氓聦聴盲潞卢': [116.4551, 40.2539],
		    '氓聦聴忙碌路': [109.314, 21.6211],
		    '氓聧聴盲潞卢': [118.8062, 31.9208],
		    '氓聧聴氓庐聛': [108.479, 23.1152],
		    '氓聧聴忙聵聦': [116.0046, 28.6633],
		    '氓聧聴茅聙職': [121.1023, 32.1625],
		    '氓聨娄茅聴篓': [118.1689, 24.6478],
		    '氓聫掳氓路聻': [121.1353, 28.6688],
		    '氓聬聢猫聜楼': [117.29, 32.0581],
		    '氓聭录氓聮聦忙碌漏莽聣鹿': [111.4124, 40.4901],
		    '氓聮赂茅聵鲁': [108.4131, 34.8706],
		    '氓聯聢氓掳聰忙禄篓': [127.9688, 45.368],
		    '氓聰聬氓卤卤': [118.4766, 39.6826],
		    '氓聵聣氓聟麓': [120.9155, 30.6354],
		    '氓陇搂氓聬聦': [113.7854, 39.8035],
		    '氓陇搂猫驴聻': [122.2229, 39.4409],
		    '氓陇漏忙麓楼': [117.4219, 39.4189],
		    '氓陇陋氓聨聼': [112.3352, 37.9413],
		    '氓篓聛忙碌路': [121.9482, 37.1393],
		    '氓庐聛忙鲁垄': [121.5967, 29.6466],
		    '氓庐聺茅赂隆': [107.1826, 34.3433],
		    '氓庐驴猫驴聛': [118.5535, 33.7775],
		    '氓赂赂氓路聻': [119.4543, 31.5582],
		    '氓鹿驴氓路聻': [113.5107, 23.2196],
		    '氓禄聤氓聺聤': [116.521, 39.0509],
		    '氓禄露氓庐聣': [109.1052, 36.4252],
		    '氓录聽氓庐露氓聫拢': [115.1477, 40.8527],
		    '氓戮聬氓路聻': [117.5208, 34.3268],
		    '氓戮路氓路聻': [116.6858, 37.2107],
		    '忙聝聽氓路聻': [114.6204, 23.1647],
		    '忙聢聬茅聝陆': [103.9526, 30.7617],
		    '忙聣卢氓路聻': [119.4653, 32.8162],
		    '忙聣驴氓戮路': [117.5757, 41.4075],
		    '忙聥聣猫聬篓': [91.1865, 30.1465],
		    '忙聴聽茅聰隆': [120.3442, 31.5527],
		    '忙聴楼莽聟搂': [119.2786, 35.5023],
		    '忙聵聠忙聵聨': [102.9199, 25.4663],
		    '忙聺颅氓路聻': [119.5313, 29.8773],
		    '忙聻拢氓潞聞': [117.323, 34.8926],
		    '忙聼鲁氓路聻': [109.3799, 24.9774],
		    '忙聽陋忙麓虏': [113.5327, 27.0319],
		    '忙颅娄忙卤聣': [114.3896, 30.6628],
		    '忙卤聲氓陇麓': [117.1692, 23.3405],
		    '忙卤聼茅聴篓': [112.6318, 22.1484],
		    '忙虏聢茅聵鲁': [123.1238, 42.1216],
		    '忙虏搂氓路聻': [116.8286, 38.2104],
		    '忙虏鲁忙潞聬': [114.917, 23.9722],
		    '忙鲁聣氓路聻': [118.3228, 25.1147],
		    '忙鲁掳氓庐聣': [117.0264, 36.0516],
		    '忙鲁掳氓路聻': [120.0586, 32.5525],
		    '忙碌聨氓聧聴': [117.1582, 36.8701],
		    '忙碌聨氓庐聛': [116.8286, 35.3375],
		    '忙碌路氓聫拢': [110.3893, 19.8516],
		    '忙路聞氓聧職': [118.0371, 36.6064],
		    '忙路庐氓庐聣': [118.927, 33.4039],
		    '忙路卤氓聹鲁': [114.5435, 22.5439],
		    '忙赂聟猫驴聹': [112.9175, 24.3292],
		    '忙赂漏氓路聻': [120.498, 27.8119],
		    '忙赂颅氓聧聴': [109.7864, 35.0299],
		    '忙鹿聳氓路聻': [119.8608, 30.7782],
		    '忙鹿聵忙陆颅': [112.5439, 27.7075],
		    '忙禄篓氓路聻': [117.8174, 37.4963],
		    '忙陆聧氓聺聤': [119.0918, 36.524],
		    '莽聝聼氓聫掳': [120.7397, 37.5128],
		    '莽聨聣忙潞陋': [101.9312, 23.8898],
		    '莽聫聽忙碌路': [113.7305, 22.1155],
		    '莽聸聬氓聼聨': [120.2234, 33.5577],
		    '莽聸聵茅聰娄': [121.9482, 41.0449],
		    '莽聼鲁氓庐露氓潞聞': [114.4995, 38.1006],
		    '莽娄聫氓路聻': [119.4543, 25.9222],
		    '莽搂娄莽職聡氓虏聸': [119.2126, 40.0232],
		    '莽禄聧氓聟麓': [120.564, 29.7565],
		    '猫聛聤氓聼聨': [115.9167, 36.4032],
		    '猫聜聡氓潞聠': [112.1265, 23.5822],
		    '猫聢聼氓卤卤': [122.2559, 30.2234],
		    '猫聥聫氓路聻': [120.6519, 31.3989],
		    '猫聨卤猫聤聹': [117.6526, 36.2714],
		    '猫聫聫忙鲁陆': [115.6201, 35.2057],
		    '猫聬楼氓聫拢': [122.4316, 40.4297],
		    '猫聭芦猫聤娄氓虏聸': [120.1575, 40.578],
		    '猫隆隆忙掳麓': [115.8838, 37.7161],
		    '猫隆垄氓路聻': [118.6853, 28.8666],
		    '猫楼驴氓庐聛': [101.4038, 36.8207],
		    '猫楼驴氓庐聣': [109.1162, 34.2004],
		    '猫麓碌茅聵鲁': [106.6992, 26.7682],
		    '猫驴聻盲潞聭忙赂炉': [119.1248, 34.552],
		    '茅聜垄氓聫掳': [114.8071, 37.2821],
		    '茅聜炉茅聝赂': [114.4775, 36.535],
		    '茅聝聭氓路聻': [113.4668, 34.6234],
		    '茅聞聜氓掳聰氓陇職忙聳炉': [108.9734, 39.2487],
		    '茅聡聧氓潞聠': [107.7539, 30.1904],
		    '茅聡聭氓聧聨': [120.0037, 29.1028],
		    '茅聯聹氓路聺': [109.0393, 35.1947],
		    '茅聯露氓路聺': [106.3586, 38.1775],
		    '茅聲聡忙卤聼': [119.4763, 31.9702],
		    '茅聲驴忙聵楼': [125.8154, 44.2584],
		    '茅聲驴忙虏聶': [113.0823, 28.2568],
		    '茅聲驴忙虏禄': [112.8625, 36.4746],
		    '茅聵鲁忙鲁聣': [113.4778, 38.0951],
		    '茅聺聮氓虏聸': [120.4651, 36.3373],
		    '茅聼露氓聟鲁': [113.7964, 24.7028]
		};
		;
		drawDeviceChart(mapChart,geoCoordMap);				
		
		var a ='china',t1='忙聹聧氓聤隆忙聲聢莽聨聡氓聢聠氓赂聝氓聸戮',t2='忙聹聧氓聤隆猫炉聞盲禄路氓聢聠氓赂聝氓聸戮',t3='忙掳麓猫麓篓氓聸戮',
			dataServe = [
		    { name: "盲赂聤忙碌路", value: 29},
		    { name: "莽聫聽忙碌路", value: 21},
		    { name: "盲赂聣盲潞職", value: 11},
		    { name: "忙聝聽氓路聻", value: 19},
		    { name: "忙碌路氓聫拢", value: 25},
		    { name: "氓聬聢猫聜楼", value: 40},
		    { name: "氓聧聴盲潞卢", value: 69},
		    { name: "忙聺颅氓路聻", value: 56},
		    { name: "猫聥聫氓路聻", value: 67},
		    { name: "忙聴聽茅聰隆", value: 33},
		    { name: "忙聵聠氓卤卤", value: 18},
		    { name: "氓鹿驴氓路聻", value: 15},
		    { name: "忙路卤氓聹鲁", value: 8},
		    { name: "盲陆聸氓卤卤", value: 57},
		    { name: "盲赂聹猫聨聻", value: 30},
		    { name: "莽娄聫氓路聻", value: 45},
		    { name: "氓聨娄茅聴篓", value: 33},
		    { name: "氓聧聴氓庐聛", value: 31},
		    { name: "茅聝聭氓路聻", value: 66},
		    { name: "忙颅娄忙卤聣", value: 86},
		    { name: "茅聲驴忙虏聶", value: 53},
		    { name: "氓聧聴忙聵聦", value: 30},
		    { name: "氓聦聴盲潞卢", value: 20},
		    { name: "茅聲驴忙聵楼", value: 30},
		    { name: "氓陇搂猫驴聻", value: 32},
		    { name: "忙虏聢茅聵鲁", value: 45},
		    { name: "氓聯聢氓掳聰忙禄篓", value: 31},
		    { name: "氓陇漏忙麓楼", value: 86},
		    { name: "忙碌聨氓聧聴", value: 43},
		    { name: "茅聺聮氓虏聸", value: 66},
		    { name: "氓陇陋氓聨聼", value: 40},
		    { name: "莽聼鲁氓庐露氓潞聞", value: 61},
		    { name: "猫楼驴氓庐聣", value: 69},
		    { name: "忙聢聬茅聝陆", value: 13},
		    { name: "茅聡聧氓潞聠", value: 13},
		    { name: "忙聵聠忙聵聨", value: 46},
		],dataQuality=[
			{ name: "茅聺聮氓虏聸", value: 86},
		    { name: "氓陇陋氓聨聼", value: 30},
		    { name: "莽聼鲁氓庐露氓潞聞", value:81},
		    { name: "猫楼驴氓庐聣", value: 69},
		    { name: "忙聢聬茅聝陆", value: 43},
		    { name: "茅聡聧氓潞聠", value: 23},
		    { name: "忙聵聠忙聵聨", value: 46}
		],dataWater =[
			{ name: "莽娄聫氓路聻", value: 45},
		    { name: "氓聨娄茅聴篓", value: 23},
		    { name: "氓聧聴氓庐聛", value: 31},
		    { name: "茅聝聭氓路聻", value: 56},
		    { name: "忙颅娄忙卤聣", value: 36},
		    { name: "茅聲驴忙虏聶", value: 35},
		    { name: "氓聧聴忙聵聦", value: 65},
		    { name: "氓聦聴盲潞卢", value: 21},
		    { name: "茅聲驴忙聵楼", value: 90},
		    { name: "氓陇搂猫驴聻", value: 32},
		];	
		drawChart(mapServe,geoCoordMap,a,dataServe,t1);
		drawChart(mapQuality,geoCoordMap,a,dataQuality,t2);
		drawChart(mapWater,geoCoordMap,a,dataWater,t3);
	//tab茅隆碌茅聺垄氓聢聡忙聧垄茅聡聧莽禄聵
	//darwAgin();	
});
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
    backgroundColor: text =='忙聹聧氓聤隆猫炉聞盲禄路氓聢聠氓赂聝氓聸戮'?'#1b1b1b':'#404a59',
    animation: true,
    animationDuration: 1000,
    animationEasing: 'cubicInOut',
    animationDurationUpdate: 1000,
    animationEasingUpdate: 'cubicInOut',
    title: [{
        text: text,
        //link: 'http://pages.anjuke.com/expert/newexpert.html',
        subtext: '氓聠聟茅聝篓忙聲掳忙聧庐',
        //sublink: 'http://pages.anjuke.com/expert/newexpert.html',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    }, {
        id: 'statistic',
        text: count ? '氓鹿鲁氓聺聡: ' + parseInt((sum / count).toFixed(4)) : '',
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
            	title:'氓聟篓氓卤聫忙聵戮莽陇潞',
            	icon:'image://${_staticPath}images/eyew.png',
            	onclick : function(){
            		$('#mapServe').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
            		 $('#mapQuality').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
            		 $('#mapWater').css({'width':$(window).width(),'position':"absolute",'top':'-200px',
            		 'left':'-225px','right':0,'bottom':0,'height':$(window).height(),'z-index':9999999});
            		 window.onresize = mapChart.resize;
            	}
            },
            myTool2:{
            	show:true,
            	title:'氓陇聧氓聨聼',
            	icon:'image://${_staticPath}images/eye.png',
            	onclick : function(){
            		$('#mapServe').css({'width':$('.tab-content').width(),'top':'0px','height':'800px','left':0});
            		$('#mapQuality').css({'width':$('.tab-content').width(),'top':'0px','height':'800px','left':0});
            		$('#mapWater').css({'width':$('.tab-content').width(),'top':'0px','height':'800px','left':0});            		
            	}
            },
            myTool2:{
            	show:true,
            	title:'猫驴聰氓聸聻',
            	icon:'image://${_staticPath}images/home.png',
            	onclick : function(param){  
            		console.log(param)         		
           			drawChart(mapServe,geoCoordMap,a,dataServe,t1);
            	}
            }
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
        roam: true,
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
        right: 40,
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
        symbol:'emptyCircle',//莽漏潞氓驴聝
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
	if(text == '忙掳麓猫麓篓氓聸戮'){
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
	mapDiv.on('click',function(param){
		//alert(param);
		clickDown(param,geoCoordMap);
	})
}
function clickDown(param,geoCoordMap){
	//忙聹聧氓聤隆忙聲聢莽聨聡茅隆碌茅聺垄盲赂聥茅聮禄
	$('#mapServe').hide();
	$('#proviceServe').show();	
	$('#proviceServe').css('width',$('.tab-content').width());
	var mySecondChart = echarts.init(document.getElementById('proviceServe')),
	data = [{ name: "忙聢聬茅聝陆", value: 90}];
	drawChart(mySecondChart,geoCoordMap,param.name,data); 
	
	//忙聹聧氓聤隆猫炉聞盲禄路茅隆碌茅聺垄盲赂聥茅聮禄
	$('#mapQuality').hide();
	$('#proviceQuality').show();	
	$('#proviceQuality').css('width',$('.tab-content').width());
	var myproviceChart = echarts.init(document.getElementById('proviceQuality')),
	data = [{ name: "忙聢聬茅聝陆", value: 60}];
	drawChart(myproviceChart,geoCoordMap,param.name,data); 
	
	//忙掳麓猫麓篓茅隆碌茅聺垄盲赂聥茅聮禄
	$('#mapWater').hide();
	$('#proviceWater').show();	
	$('#proviceWater').css('width',$('.tab-content').width());
	var myWaterChart = echarts.init(document.getElementById('proviceWater')),
	data = [{ name: "忙聢聬茅聝陆", value: 10}];
	drawChart(myWaterChart,geoCoordMap,param.name,data);
}



function drawDeviceChart(mapChart,geoCoordMap){
var data = [
    [{name: '忙聢聬茅聝陆' }, { name: '盲赂聤忙碌路',value: 85,value2: 45}],
    [{name: '忙聢聬茅聝陆'}, {name: '氓鹿驴氓路聻', value: 70,value2: 0}],
    [{name: '忙聢聬茅聝陆'}, { name: '氓陇搂猫驴聻', value: 60,value2: 15}],
    [{name: '忙聢聬茅聝陆'}, { name: '氓聧聴氓庐聛',value: 50,value2: 0}],
    [{ name: '忙聢聬茅聝陆' }, {name: '氓聧聴忙聵聦',value: 50,value2: 25}],
    [{name: '忙聢聬茅聝陆' }, {name: '忙聥聣猫聬篓', value: 45,value2: 25 }],
    [{name: '忙聢聬茅聝陆'}, {name: '茅聲驴忙聵楼', value: 40 ,value2: 0}],
    [{name: '忙聢聬茅聝陆' }, { name: '氓聦聟氓陇麓',value: 30,value2: 35}],
    [{name: '忙聢聬茅聝陆'}, {name: '茅聡聧氓潞聠', value: 20 ,value2: 0}],
    [{name: '忙聢聬茅聝陆'}, {name: '氓赂赂氓路聻',value: 10,value2: 5}]
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
//忙颅陇氓陇聞忙聵炉忙聨聮氓潞聫 茂录聦氓聬聨氓聫掳忙聨聮氓楼陆茂录聼
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
  //console.log(series);
option = {
    backgroundColor: '#1b1b1b',
    title: [{
        text: '茅隆鹿莽聸庐/猫庐戮氓陇聡氓聢聠氓赂聝氓聸戮',
        subtext: '氓聠聟茅聝篓忙聲掳忙聧庐猫炉路氓聥驴氓陇聳盲录聽',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    },
    {
        id: 'statistic',
        text: count ? '氓鹿鲁氓聺聡: ' + parseInt((sum / count).toFixed(4)) : '',
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
        formatter: function(param){
        	return param.name +':' +param.value[2] + '/'+param.value[3];
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
        right: 40,
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
	mapChart.on('click',function(param){
		//console.log(param)
	//猫炉路忙卤聜忙聲掳忙聧庐,忙聢聬氓聤聼氓聬聨氓聸聻猫掳聝氓聡陆忙聲掳茅聡聦莽聰禄猫隆篓
	var data =[{name: "忙聢聬茅聝陆", value: [103.9526, 30.7617,100,40]},
	   			{name: "猫聡陋猫麓隆", value: [104.773447,29.352765,70,0]},
	  			{name: "忙聰聙忙聻聺猫聤卤", value: [101.716007,26.580446,50,10]},
   				{name: "氓戮路茅聵鲁", value: [104.398651,31.127991,40,40]}]
		clickProviceDown(param,data);		
	});
}
//茅隆鹿莽聸庐/猫庐戮氓陇聡氓聢聠氓赂聝氓聸戮盲赂聥茅聮禄
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
		        text: selectProvice+'茅隆鹿莽聸庐/猫庐戮氓陇聡氓聢聠氓赂聝氓聸戮',
		        subtext: '忙聲掳忙聧庐莽潞炉氓卤聻猫聶職忙聻聞',
		        left: 'center',
		        textStyle: {
		            color: '#fff'
		        }
		    },
		    {
	        id: 'statistic',
	        text: count ? '氓鹿鲁氓聺聡: ' + parseInt((sum / count).toFixed(4)) : '',
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
		        orient : 'vertical',
		        x: 'right',
		        y: 'center',
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		     grid: {
		        right: 40,
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
	    	name : selectProvice + '氓聢聠氓赂聝氓聸戮',
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
	    myChartProvice.on('click',function(param){
	    	//console.log(param);
		   var  data =[{name: "茅聰娄忙卤聼氓聦潞", value: [104.080989, 30.657689]},
					   {name: "茅聡聭莽聣聸氓聦潞", value: [104.043487, 30.692058]},
					   {name: "茅聺聮莽戮聤氓聦潞", value: [104.055731, 30.667648]},
					   {name: "忙聢聬氓聧聨氓聦潞", value: [104.103077, 30.660275]}]
	    	clickProviceDown(param,data);
	    })
}
</script>
</html>

