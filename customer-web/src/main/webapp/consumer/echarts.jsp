<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="">
		<meta http-equiv="X-UA-Compatible" content="chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
		<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<title>净水器-监测曲线图</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/suspendedBall.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />
		<script src="${_staticPath}/resource/weuiWeb/js/echarts.min.js"></script>
	</head>
	<script type="text/javascript">
		var _path="${_path}";
	</script>
	<body ontouchstart>
		<div class="page tabbar flex js_show height100">
			<div class="weui-flex xy-header">
				<div>
					<a href="javascript:history.go(-1);" class="weui-btn weui-btn_mini xy-btn-back"></a>
				</div>
				<div class="weui-flex__item"><div class="xy-h1-title"></div></div>
				<div>
					<a href="javascript:;" class="weui-btn weui-btn_mini"></a>
				</div>
			</div><!--/header-->
			<div class="page__bd xy-container">
				<div class="weui-tab xy-border-box xy-pad-tb10 xy-pad-b45p">
					<div class="weui-tabbar xy-tabbar bg-white">
						<a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
							<p class="weui-tabbar__label">实时监测显示图</p>
						</a>
						<a href="javascript:;" class="weui-tabbar__item">
							<p class="weui-tabbar__label">按天监测显示图</p>
						</a>
					</div><!--/tab 导航-->
					<div class="weui-tab__panel xy-tab__panel">
						<div class="xy-tab-list xy-tab-list_on">
							<div class="height100 xy-border-box">
								<div id="MillisecondCharts" class="height100"></div>
							</div>
						</div>
						<div class="xy-tab-list">
							<div class="height100 xy-border-box">
								<div id="MonthCharts" class="height100"></div>
							</div>
						</div>
					</div><!--/tab 内容-->
				</div>
			</div>
			<!--/ container -->
			
			<div class="echarts-qt xy-dn" id="echartsQt" flex="main:center cross:center">
				<div>
					<div class="my-msg weui-flex xy-pad-lr10 xy-mar-t20" flex="main:center cross:center">
						<div class="xy-fc-gray xy-pad-lr10 xy-fs12" style="width:220px;">
							<p>主人，<span id="seriesName"></span>监测数据显示，在<span id="seriesNameX"></span>有服务提醒消息推送。</p>
							<p>服务内容：更换3级滤芯和相关维护;</p>
							<p>服务人员：潘小玲;</p>
							<p>评价：四星。</p>
						</div>
					</div><!--/提示语-->
				
					<div flex="main:center cross:center">
						<div class="my-lovely xy-tac xy-pad-lr10">
							<img src="${_staticPath}/resource/weuiWeb/img/pic-lovely-01.png">
						</div><!--/蜻蜓-->
					</div>
				</div>
			</div>
			
			<div class="weui-footer weui-footer_fixed-bottom xy-footer">
				<div class="xy-pad-lr10 xy-clearfix">
					<a href="javascript:;" class="weui-btn weui-btn_primary bg-light-blue xy-btn-next">服务方案</a>
				</div>
			</div>
			<!--/ footer -->
			
		</div>
		<!--/page End-->
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/swiper.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper.js"></script>
		<script src="${_path}/js/consumer/SuspendedBall.js"></script>
		<script type="text/javascript" class="tabbar js_show">
			function eventCollection(weui){
			}
			var show = false;
			$(function(){
				//获取图表数据
				 $.ajax({
					type:'post',
					url:_path+'/consumer/monitor/listNew',
					data: {equipId:''},
					success : function(msg){
						console.log(msg);
						if(msg){
							$('.xy-h1-title').html(msg.data.userName+"家的监测曲线图")
							drawEchart(msg.data);
						}						
					}
				});
				function drawEchart(data){
					var xdata = data.secondDates,newData =[],len = xdata.length;
					for(var i = 0;i < len;i++){
						newData.push(xdata[i].slice(11))
					}
					console.log(newData)
					/* //毫秒级
					var MillisecondData = ["1'0\"30", "1'1\"0", "1'1\"30", "1'2\"0", "1'2\"30", "1'3\"0", "1'3\"30", "1'4\"0", "1'4\"30", "1'5\"0", "1'5\"30", "1'6\"0", "1'6\"30", "1'7\"0", "1'7\"30", "1'8\"0", "1'8\"30", "1'9\"0"];
					//原水数据
					var oneData = [33, 55, 33, 55, 33, 55, 33, 55, 33, 55, 33, 55, 33, 55, 33, 55, 33, 55];
					//过程数据
					var twoData = [44, 66, 44, 66, 44, 66, 44, 66, 44, 66, 44, 66, 44, 66, 44, 66, 44, 66];
					//季度
					//年份
					var MonthData = ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月', '1月', '2月', '3月', '4月', '5月', '6月'];
					//原水数据
					var threeData = [20, 11, 32, 53, 21, 32, 17, 74, 23, 34, 15, 33, 44, 53, 24, 42, 37, 53];
					//过程数据
					var fourData = [30, 21, 42, 63, 31, 42, 27, 84, 33, 44, 25, 43, 54, 63, 34, 52, 47, 63]; */
					
					//console.log(echarts);
					// 基于准备好的dom，初始化echarts实例
					var MillisecondChart = echarts.init(document.getElementById('MillisecondCharts'));        // 指定图表的配置项和数据
					var	MillisecondOption = {
						title : {
							x: 'center',
							y: 'bottom',
							padding: [5,5,15,5],
							text: '向右滑动监测曲线图查看历史监测数据',
							textStyle: {
								fontSize: 14,
								color: '#888888',
								fontWeight: 400
								
							}
						},
						tooltip : {
							trigger: 'item',
							triggerOn: 'click',
							formatter: function(params) {  
								if(params.data.value == undefined){
									var data = params.data;
								}else{
									var data = params.data.value;
								}
								var res = '<span style="color:'+params.color+'">'+params.seriesName+'</span><br/>'+params.name+': '+data+'%'; 
								return res;  
							}  
						},
						legend: {
							y: 'bottom',
							padding: [5,5,50,5],
							data:['原水数据','过程数据']
						},
						calculable : true,
						xAxis : [
							{
								type : 'category',
								boundaryGap : false,
								data : newData, 
								//data : ["22:49:23", "22:49:24", "22:49:25", "22:49:26"], 				          
							}
						],
						yAxis : [
							{
								type : 'value',
								axisLabel : {
									formatter: '{value}%'
								},
								//min: 0,
								//max: 100,
								//splitNumber: 10,
							}
						],
						grid: {
							x: 80,
							y: 20,
							//x2:10 ,
							y2: 100
						},
						dataZoom: {
							type: 'inside',
							show: true,
							start : 65,
							end:100
						},
						series : [
							{
								name:'过程数据',
								type:'line',
								smooth:true,
								lineStyle: {
									normal: {
										width: 2,
										shadowColor: 'rgba(80,80,80,0.6)',
										shadowBlur: 18,
										shadowOffsetY: 5,
										shadowOffsetX: 6
									}
								},
								itemStyle: {
								  normal: {
									color: '#65a8f4',							
									areaStyle: {
										// 线性渐变，前四个参数分别是 x0, y0, x2, y2, 范围从 0 - 1
										// 相当于在图形包围盒中的百分比，如果最后一个参数传 true，则该四个值是绝对的像素位置
										color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
											offset: 0, color: '#0c7dfc'
										}, {
											offset: 0.5, color: '#65a8f4'
										}, {
											offset: 1, color: '#fff'
										}], false),
										// 纹理填充
										//color: new echarts.graphic.Pattern(myChart, 'repeat')
										/*shadowColor: 'rgba(0, 0, 0, 0.5)',
										shadowBlur: 10,
										shadowOffsetX:8,
										shadowOffsetY:8,
										borderWidth:0,*/
									}
								  }
								},
								data:data.purDatas,
								symbolSize: 10,
							},
							{
								name:'原水数据',
								type:'line',
								smooth:true,
								lineStyle: {
									normal: {
										width: 2,
										shadowColor: 'rgba(80,80,80,0.6)',
										shadowBlur: 18,
										shadowOffsetY: 5,
										shadowOffsetX: 6
									}
								},
								itemStyle: {
								  normal: {
									color: '#7B52EE',
									//borderWidth:0,
									//borderColor:'9C86F7',
									areaStyle: {
										// 线性渐变，前四个参数分别是 x0, y0, x2, y2, 范围从 0 - 1
										// 相当于在图形包围盒中的百分比，如果最后一个参数传 true，则该四个值是绝对的像素位置
										color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
											offset: 0, color: '#7312e9'
										}, {
											offset: 0.5, color: '#D4C7FE'
										}, {
											offset: 1, color: '#fff'
										}], false),
										// 纹理填充
										//color: new echarts.graphic.Pattern(myChart, 'repeat')
										/*shadowColor: 'rgba(0, 0, 0, 0.2)',
										shadowBlur: 10,
										shadowOffsetX:8,
										shadowOffsetY:8,	*/					
										}
								  }
								},
								data:data.rawDatas,
								symbolSize: 10,
								//绘制Y轴平行线 
								markLine: { 
									data: [{ 
										name: '预警线', 
										yAxis: 70,
										itemStyle: {
											normal: {
												color: '#f1ec91',
												lineStyle: {
													type: 'solid',
													width: 3,
												}
											}
										}
									}, { 
										name: '超标线', 
										yAxis: 80,
										itemStyle: {
											normal: {
												color: '#ff7057',
												lineStyle: {
													type: 'solid',
													width: 3,
												}
											}
										}
									}] 
								}
							}
						],
					};      
					// 使用刚指定的配置项和数据显示图表。
					MillisecondChart.setOption(MillisecondOption,true);
					//console.log(MillisecondChart._option);
					//alert(MillisecondChart.MillisecondOption.xAxis[0].data[0])
					MillisecondChart.on('click',function(params){
						console.log(params);
						//区域图里数据点的点击事件
						//点击逻辑
						if(params.data.value != undefined) return false;
						/*MillisecondChart.dispatchAction({
							type: 'showTip',
							// 系列的 index，在 tooltip 的 trigger 为 axis 的时候可选。
							seriesIndex: params.seriesIndex,
							// 数据的 index，如果不指定也可以通过 name 属性根据名称指定数据
							dataIndex: params.dataIndex,
							// 可选，数据名称，在有 dataIndex 的时候忽略
							name: params.name,
							// 本次显示 tooltip 的位置。只在本次 action 中生效。
							// 缺省则使用 option 中定义的 tooltip 位置。
							position: null
						});*/
						if(params.seriesName == '原水数据'){
							var seriesName = '原水';
						}else if(params.seriesName == '过程数据'){
							var seriesName = '过程';
						}
						$("#seriesName").text(seriesName);
						$("#seriesNameX").text(params.name);
						$("#echartsQt").show();
						event.preventDefault();
						event.stopPropagation();
					});
					// 基于准备好的dom，初始化echarts实例
					var MonthChart = echarts.init(document.getElementById('MonthCharts'));        // 指定图表的配置项和数据
					var	MonthOption = {
						title : {
							x: 'center',
							y: 'bottom',
							padding: [5,5,15,5],
							text: '向右滑动监测曲线图查看历史监测数据',
							textStyle: {
								fontSize: 14,
								color: '#888888',
								fontWeight: 400
								
							}
						},
						tooltip : {
							trigger: 'item',
							triggerOn: 'click',
							formatter: function(params) {  
								if(params.data.value == undefined){
									var data = params.data;
								}else{
									var data = params.data.value;
								}
								var res = '<span style="color:'+params.color+'">'+params.seriesName+'</span><br/>'+params.name+': '+data+'%'; 
								return res;  
							}  
						},
						legend: {
							y: 'bottom',
							padding: [5,5,50,5],
							data:['原水数据','过程数据']
						},
						calculable : true,
						xAxis : [
							{
								type : 'category',
								boundaryGap : false,
								data : newData
							}
						],
						yAxis : [
							{
								type : 'value',
								axisLabel : {
									formatter: '{value}%'
								},
							}
						],
						grid: {
							x: 50,
							y: 20,
							y2: 100
						},
						dataZoom: {
							type: 'inside',
							show: true,
							start : 65,
							end:100
						},
						series : [
							{
								name:'过程数据',
								type:'line',
								smooth:true,
								itemStyle: {
								  normal: {
									color: '#8fbcdd',
									areaStyle: {
										// 线性渐变，前四个参数分别是 x0, y0, x2, y2, 范围从 0 - 1
										// 相当于在图形包围盒中的百分比，如果最后一个参数传 true，则该四个值是绝对的像素位置
										color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
											offset: 0, color: '#6abfff'
										}, {
											offset: 0.5, color: '#9ed1ff'
										}, {
											offset: 1, color: '#fff'
										}], false),
										// 纹理填充
										//color: new echarts.graphic.Pattern(myChart, 'repeat')
									}
								  }
								},
								data:data.purDatas,
								symbolSize: 10,
							},
							{
								name:'原水数据',
								type:'line',
								smooth:true,
								itemStyle: {
								  normal: {
									color: '#c9bbec',
									areaStyle: {
										// 线性渐变，前四个参数分别是 x0, y0, x2, y2, 范围从 0 - 1
										// 相当于在图形包围盒中的百分比，如果最后一个参数传 true，则该四个值是绝对的像素位置
										color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
											offset: 0, color: '#a6a3da'
										}, {
											offset: 0.5, color: '#d2cafb'
										}, {
											offset: 1, color: '#fff'
										}], false),
										// 纹理填充
										//color: new echarts.graphic.Pattern(myChart, 'repeat')
									}
								  }
								},
								data:data.rawDatas,
								symbolSize: 10,
								//绘制Y轴平行线 
								markLine: { 
									data: [{ 
										name: '预警线', 
										yAxis: 70,
										itemStyle: {
											normal: {
												color: '#f1ec91',
												lineStyle: {
													type: 'solid',
													width: 3,
												}
											}
										}
									}, { 
										name: '超标线', 
										yAxis: 80,
										itemStyle: {
											normal: {
												color: '#ff7057',
												lineStyle: {
													type: 'solid',
													width: 3,
												}
											}
										}
									}] 
								}
							}
						],
					};      
					// 使用刚指定的配置项和数据显示图表。
					MonthChart.setOption(MonthOption,true);
					MonthChart.on('click',function(params){
						console.log(params);
						//区域图里数据点的点击事件
						//点击逻辑
						if(params.data.value != undefined) return false;
						/*MonthChart.dispatchAction({
							type: 'showTip',
							// 系列的 index，在 tooltip 的 trigger 为 axis 的时候可选。
							seriesIndex: params.seriesIndex,
							// 数据的 index，如果不指定也可以通过 name 属性根据名称指定数据
							dataIndex: params.dataIndex,
							// 可选，数据名称，在有 dataIndex 的时候忽略
							name: params.name,
							// 本次显示 tooltip 的位置。只在本次 action 中生效。
							// 缺省则使用 option 中定义的 tooltip 位置。
							position: null
						});*/
						if(params.seriesName == '原水数据'){
							var seriesName = '原水';
						}else if(params.seriesName == '过程数据'){
							var seriesName = '过程';
						}
						$("#seriesName").text(seriesName);
						$("#seriesNameX").text(params.name);
						$("#echartsQt").show();
						event.preventDefault();
						event.stopPropagation();
					});
					$('.weui-tabbar__item').on('click', function () {
					$(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
					var thisNum = $(this).index();
					$('.xy-tab-list').eq(thisNum).addClass('xy-tab-list_on').siblings('.xy-tab-list_on').removeClass('xy-tab-list_on');
					//MillisecondChart.resize();
					if(!show){
						//更新一次视图
						MonthChart.resize();
						show = true;
						}
					});
					
					//自适应分辨率
					$(window).resize(function(){
						MillisecondChart.resize();
						MonthChart.resize();
					});
					
					//判断当前显示哪个图表
					var thisChart,thisOption;
					if($('.bg-white a:eq(0)').hasClass('weui-bar__item_on')){
						thisChart = MillisecondChart;
						//thisOption = MillisecondOption;
					}else{
						thisChart = MonthChart;
						//thisOption = MonthOption;
					}
					//判断用户手指滑动的方向
					getTouchEvent(data,thisChart);					 					
				}
				
				//getTouchEvent(data);
				function getTouchEvent(data,thisChart){
					console.log(data);
					var startx, starty;
				    //获得角度
				    function getAngle(angx, angy) {
				        return Math.atan2(angy, angx) * 180 / Math.PI;
				    };
				 
				    //根据起点终点返回方向 1向上 2向下 3向左 4向右 0未滑动
				    function getDirection(startx, starty, endx, endy) {
				        var angx = endx - startx;
				        var angy = endy - starty;
				        var result = 0;
				 
				        //如果滑动距离太短
				        if (Math.abs(angx) < 2 && Math.abs(angy) < 2) {
				            return result;
				        }
				 
				        var angle = getAngle(angx, angy);
				        if (angle >= -135 && angle <= -45) {
				            result = 1;
				        } else if (angle > 45 && angle < 135) {
				            result = 2;
				        } else if ((angle >= 135 && angle <= 180) || (angle >= -180 && angle < -135)) {
				            result = 3;
				        } else if (angle >= -45 && angle <= 45) {
				            result = 4;
				        }
				 
				        return result;
				    }
				    //手指接触屏幕
				    document.addEventListener("touchstart", function(e) {
				        startx = e.touches[0].pageX;
				        starty = e.touches[0].pageY;
				    }, false);
				    //手指离开屏幕
				    document.addEventListener("touchend", function(e) {
				        var endx, endy,me = this;
				        endx = e.changedTouches[0].pageX;
				        endy = e.changedTouches[0].pageY;
				        var direction = getDirection(startx, starty, endx, endy);
				        switch (direction) {
				            case 0:
				                //alert("未滑动！");
				                break;
				            case 1:
				                //alert("向上！")
				                break;
				            case 2:
				                ///alert("向下！")
				                break;
				            case 3:
				                //alert("向左！")
				                break;
				            case 4:
				                //alert("向右！");
				                var rightRange = endx-startx;
				                getNewData(rightRange);
				                break;
				            default:
				        }
				    }, false);
				    
				    function getNewData(rightRange){
						if(rightRange > $(window).width()){
							//console.log(data);
							var endCalendar = data.secondDates[0];
							 $.ajax({
							type:'post',
							url:_path+'/consumer/monitor/list',
							data: {equipId:'',endCalendar:endCalendar},
							success : function(msg){
								//console.log(msg);
								//a = data.secondDates,b=
								if(msg){	
									//需要判断数据未更新的情况								
									data.secondDates.push.apply(data.secondDates,msg.data.secondDates);
									data.purDatas.push.apply(data.purDatas,msg.data.purDatas);
									data.rawDatas.push.apply(data.rawDatas,msg.data.rawDatas);
									/* var newOption = thisChart.getOption();
									newOption.xAxis.data=data.secondDates;
									newOption.series[0].data=data.purDatas;
									newOption.series[1].data=data.rawDatas; */
									drawEchart(data);									
 									/* thisChart.setOption(newOption,true);
 									thisChart.resize();								
 									console.log(data); */
									}						
								}
							});
						}						
					}
				}				
				$(document).click(function(){
					$("#echartsQt").hide();
				})
				$('.xy-btn-next').click(function(){
					sessionStorage.setItem('iffuwu',2);//跳转页面，公用一个列表页，设假数据为2，若2 ==》 跳转页面标题改成"实时服务方案";
					window.location.href =_path+"/consumer/services-list.jsp";
					//window.location.href =_path+"/consumer/service-offerings-details.jsp";
				})								
				var $searchBar = $('#searchBar'),
					$searchInput = $('#searchInput'),
					$searchClear = $('#searchClear'),
					$searchCancel = $('#searchCancel');

				function hideSearchResult(){
					$searchInput.val('');
				}
				function cancelSearch(){
					hideSearchResult();
				}
				$searchInput.on('blur', function () {
					if(!this.value.length) cancelSearch();
				})
				;
				$searchClear.on('click', function(){
					hideSearchResult();
					$searchInput.focus();
				});
				$searchCancel.on('click', function(){
					cancelSearch();
					$searchInput.blur();
				});

			});			
			
			
			
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>