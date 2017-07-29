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
		<script src="${_staticPath}/resource/weuiWeb/js/echarts.js"></script>
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
				var MillisecondChart = echarts.init(document.getElementById('MillisecondCharts')),
					MonthChart = echarts.init(document.getElementById('MonthCharts')); 
					var base = +new Date(1968, 9, 3);
					var oneDay = 24 * 3600 * 1000;
					var date = [];
					
					var data = [Math.random() * 300];
					
					for (var i = 1; i < 20000; i++) {
					    var now = new Date(base += oneDay);
					    date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
					    data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
					}
					
					option = {
					    tooltip: {
					        trigger: 'axis',
					        position: function (pt) {
					            return [pt[0], '10%'];
					        }
					    },
					    title: {
					        left: 'center',
					        text: '大数据量面积图',
					    },
					    toolbox: {
					        feature: {
					            dataZoom: {
					                yAxisIndex: 'none'
					            },
					            restore: {},
					            saveAsImage: {}
					        }
					    },
					    xAxis: {
					        type: 'category',
					        boundaryGap: false,
					        data: date
					    },
					    yAxis: {
					        type: 'value',
					        boundaryGap: [0, '100%']
					    },
					    dataZoom: [{
					        type: 'inside',
					        start: 0,
					        end: 10
					    }, /*{
					        start: 0,
					        end: 10,
					        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
					        handleSize: '80%',
					        handleStyle: {
					            color: '#fff',
					            shadowBlur: 3,
					            shadowColor: 'rgba(0, 0, 0, 0.6)',
					            shadowOffsetX: 2,
					            shadowOffsetY: 2
					        }
					    }*/],
					    series: [
					        {
					            name:'模拟数据',
					            type:'line',
					            smooth:true,
					            symbol: 'none',
					            sampling: 'average',
					            itemStyle: {
					                normal: {
					                    color: 'rgb(255, 70, 131)'
					                }
					            },
					            areaStyle: {
					                normal: {
					                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
					                        offset: 0,
					                        color: 'rgb(255, 158, 68)'
					                    }, {
					                        offset: 1,
					                        color: 'rgb(255, 70, 131)'
					                    }])
					                }
					            },
					            data: data
					        }
					    ]					    
					};
					MillisecondChart.setOption(Option);
				//获取图表数据
				/*  $.ajax({
					type:'post',
					url:_path+'/consumer/monitor/listNew',
					data: {equipId:''},
					success : function(msg){
						console.log(msg);
						if(msg){
							$('.xy-h1-title').html(msg.data.userName+"家的监测曲线图")
							drawEchart(msg.data,MillisecondChart);
						}						
					}
				}); */
				//drawEchart(MillisecondChart)
			});
			function drawEchart(domDiv){
				var base = +new Date(1968, 9, 3);
				var oneDay = 24 * 3600 * 1000;
				var date = [];
				
				var data = [Math.random() * 300];
				
				for (var i = 1; i < 20000; i++) {
				    var now = new Date(base += oneDay);
				    date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
				    data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
				}
				
				option = {
				    tooltip: {
				        trigger: 'axis',
				        position: function (pt) {
				            return [pt[0], '10%'];
				        }
				    },
				    title: {
				        left: 'center',
				        text: '大数据量面积图',
				    },
				    toolbox: {
				        feature: {
				            dataZoom: {
				                yAxisIndex: 'none'
				            },
				            restore: {},
				            saveAsImage: {}
				        }
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: date
				    },
				    yAxis: {
				        type: 'value',
				        boundaryGap: [0, '100%']
				    },
				    dataZoom: [{
				        type: 'inside',
				        start: 0,
				        end: 10
				    }, /*{
				        start: 0,
				        end: 10,
				        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
				        handleSize: '80%',
				        handleStyle: {
				            color: '#fff',
				            shadowBlur: 3,
				            shadowColor: 'rgba(0, 0, 0, 0.6)',
				            shadowOffsetX: 2,
				            shadowOffsetY: 2
				        }
				    }*/],
				    series: [
				        {
				            name:'模拟数据',
				            type:'line',
				            smooth:true,
				            symbol: 'none',
				            sampling: 'average',
				            itemStyle: {
				                normal: {
				                    color: 'rgb(255, 70, 131)'
				                }
				            },
				            areaStyle: {
				                normal: {
				                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
				                        offset: 0,
				                        color: 'rgb(255, 158, 68)'
				                    }, {
				                        offset: 1,
				                        color: 'rgb(255, 70, 131)'
				                    }])
				                }
				            },
				            data: data
				        }
				    ]
				};

				domDiv.setOption(option);
			}						
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>