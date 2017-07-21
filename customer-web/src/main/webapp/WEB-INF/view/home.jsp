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
		<title>净水器-首页</title>
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/weui.min.css" />
		<link rel="stylesheet" href="${_staticPath}/resource/weuiWeb/css/swiper.min.css">
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-flex.css" />
		<link rel="stylesheet" type="text/css" href="${_staticPath}/resource/weuiWeb/css/xy-css.css" />		
		<link rel="stylesheet" href="example.css">
		<script src="${_staticPath}/resource/weuiWeb/js/echarts.min.js"></script>
		<style>
			.marginleft{
				margin-left: 2em;
			}
			.ceshi{
				    background-color: #fff;
				    width: 88%;
				    margin: 0 6%;
				    border-top: 2px solid #e6e6e6;
			}
			.flex{display:flex;width:100%;margin:0;padding:0;list-style:none;padding: 2% 0;}
			.flex :nth-child(1){flex:1 1 25%;}
			.flex :nth-child(2){flex:2 2 60%;margin-top: 2%;}
			.flex :nth-child(3){flex:3 3 10%;}
			.progress{
				width:50%;height:6px;border-radius: 10px;			
			}
			.jianbian{background-image:linear-gradient(to top,#fff,#CBE3FE);}
			.jianbian2{background-image:linear-gradient(to top,#fff 60%,#3792FB 40%);}
		</style>
	</head>
	<script type="text/javascript">
		var _path="${_path}",_staticPath="${_staticPath}";
	</script>
<body ontouchstart>		
	<div class="page tabbar js_show">
	    <div class="page__bd" style="height: 100%;">
	        <div class="weui-tab">
	        	<!-- <div class="swiper-container ve-swiper-container height100">
					<div class="swiper-wrapper">
						------------------swiper slide--------------------
						<div class="swiper-slide"> -->
				            <div class="weui-tab__panel jianbian2" style="background-color: #3792FB;">		            	
				            	<ol class="weui-cell weui-cell_access" style="padding:4em 3.5em 0 3.5em; color:#fff;">
									<dt class="">
										<p class="xy-fll mini-lovely fixed-mini-lovely xy-full-widthIMG">
											<img src="${_staticPath}/resource/weuiWeb/img/pic-lovely.gif" />
										</p>
									</dt>
									<dd class="">
										<h3 style="line-height: 2em;" class="marginleft"></h3>
										<p class="marginleft">当前设备运行良好，有1个净水设备正在持续关注中…………</p>
									</dd>
								</ol>
								<div class="xy-waveBox xy-line-h0">
									<div class="xy-wave" id="wave1"></div>
									<div class="xy-wave" id="wave2"></div>
									<div class="xy-wave" id="wave3"></div>
								</div><!--/波纹-->
								<div class="weui-cell_access jianbian" style="height:35%;width:100%;"><!--/饼图-->
									<div id="myChart" style="width:100%;height:80%"></div>
									<div style="height:20%;padding:0 2em;">
										<ol class="xy-fll xy-pad-tb10">
											<dt class="xy-dibVat">监测次数</dt>
											<dd class="dt xy-dibVat" id="moitorCount">200172</dd>
										</ol>
										<ol class="xy-flr  xy-pad-tb10">
											<dt class="xy-dibVat">服务次数</dt>
											<dd class="dt xy-dibVat" id="serviceCount">230</dd>
										</ol>
									</div>							
								</div><!--/饼图-->
								
								<div style="background-color: #fff;" class="ceshi">
									<ul class="flex xy-tac">
									    <li>原水TDS值</li>
									    <li>
									    	<div class="progress" style="background-color:#FBB55F;"></div>
									    </li>
									    <li id="rawTds"></li>
									</ul>
									<ul class="flex xy-tac">
									    <li>净水TDS值</li>
									    <li>
									    	<div class="progress" style="background-color:#85E037;"></div>
									    </li>
									    <li id="purTds"></li>
									</ul>
									<ul class="flex xy-tac">
									    <li>温度</li>
									    <li>
									    	<!-- <div class="progress" style="background-color:#52CDD5;"></div> -->
									    </li>
									    <li id="temp"></li>
									</ul>
									<ul class="flex xy-tac">
									    <li>湿度</li>
									    <li>
									    	<!-- <div class="progress" style="background-color:#F3B4D4;"></div> -->
									    </li>
									    <li id="humidity"></li>
									</ul>
									<ul class="flex xy-tac">
									    <li>流量</li>
									    <li>
									    	<!-- <div class="progress" style="background-color:#85E037;"></div> -->
									    </li>
									    <li id="flow"></li>
									</ul>
									<ul class="flex xy-tac">
									    <li>是否漏水</li>
									    <li>
									    	<!-- <div class="progress" style="background-color:#52cdd5;"></div> -->
									    </li>
									    <li id="leak"></li>
									</ul>
								</div>
				            </div>
		            	<!-- </div> -->
		            	<!-- <div class="swiper-slide">
							<div class="xy-pad-10 xy-border-box height100">此处为设备</div>
						</div> -->
		           <!--  </div>
	            </div> -->
	            <div class="weui-tabbar">
	                <a href="${_path}/consumer/home" class="weui-tabbar__item weui-bar__item_on" id="home">
	                    <span style="display: inline-block;position: relative;">
	                        <img src="${_staticPath}/resource/weuiWeb/img/nav-home.png" alt="" class="weui-tabbar__icon">
	                        <!-- <span class="weui-badge" style="position: absolute;top: -2px;right: -13px;">8</span> -->
	                    </span>
	                    <p class="weui-tabbar__label">首页</p>
	                </a>
	                <a href="${_path}/consumer/project.jsp" class="weui-tabbar__item" id="device">
	                    <img src="${_staticPath}/resource/weuiWeb/img/nav-heart-shaped.png" alt="" class="weui-tabbar__icon">
	                    <p class="weui-tabbar__label">设备</p>
	                </a>
	                <a href="${_path}/consumer/device-follow.jsp" class="weui-tabbar__item" id="attention">
	                    <span style="display: inline-block;position: relative;">
	                        <img src="${_staticPath}/resource/weuiWeb/img/nav-follow.png" alt="" class="weui-tabbar__icon">
	                        <span class="weui-badge weui-badge_dot" style="position: absolute;top: 0;right: -6px;"></span>
	                    </span>
	                    <p class="weui-tabbar__label">关注</p>
	                </a>
	                <a href="${_path}/consumer/services-list.jsp" class="weui-tabbar__item" id="sevice">
	                    <img src="${_staticPath}/resource/weuiWeb/img/nav-warning.png" alt="" class="weui-tabbar__icon">
	                    <p class="weui-tabbar__label">服务</p>
	                </a>
	                	                
	                <a href="${_path}/consumer/news.jsp" class="weui-tabbar__item" id="message">
	                    <span style="display: inline-block;position: relative;">
	                        <img src="${_staticPath}/resource/weuiWeb/img/nav-home.png" alt="" class="weui-tabbar__icon">
	                        <span class="weui-badge" style="position: absolute;top: -2px;right: -13px;">8</span>
	                    </span>
	                    <p class="weui-tabbar__label">消息</p>
	                </a>
	                <a href="${_path}/consumer/me.jsp" class="weui-tabbar__item" id="me">
	                    <img src="${_staticPath}/resource/weuiWeb/img/nav-me.png" alt="" class="weui-tabbar__icon">
	                    <p class="weui-tabbar__label">我</p>
	                </a>
	            </div>
	        </div>
	    </div>
	</div>
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/jquery-1.12.4.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/swiper.min.js"></script>
		<script src="${_staticPath}/resource/weuiWeb/js/xy-swiper-vertical.js"></script>
		<script type="text/javascript" class="js_show">
			function eventCollection(weui){
				
			}
			$(function(){
				//ajax获取后台数据，填充页面  ,  包括
				 $.ajax({
					type:'get',
					url:_path+'/consumer/home/listStickMonitor',
					//data:{account:account},
					success : function(msg){
						console.log(msg);
						if(msg.data)	{
							$('#flow').html(msg.data.flow);
							$('#humidity').html(msg.data.humidity);
							$('#moitorCount').html(msg.data.moitorCount);
							$('#msgType').html(msg.data.msgType);
							$('#purTds').html(msg.data.purTds);
							$('#rawTds').html(msg.data.rawTds);
							$('#serviceCount').html(msg.data.serviceCount);
							$('#temp').html(msg.data.temp);
							msg.data.leak == 'false' ?$('#leak').html('否'):$('#leak').html('是');
							progressWidth();
							drawEchart();//数据待拉取							
						}					
					}
				}); 
				fillDate();																
				bindEvent();															
			})
			function fillDate(){
				var now = new Date(),hour = now.getHours(),h3Text; 
				//console.log(date);
				if(hour < 12){
				 	h3Text = '主人，上午好!'
				}else if(hour < 19){
					h3Text = '主人，下午好!'
				}else{
					h3Text = '主人，晚上好!'
				}
				$('h3').html(h3Text); 
			}
			function progressWidth(){
				$(".progress").each(function () {
					var a = parseInt($(this).parent().next().html());
			        $(this).css("width",a > 200?'100%':a/2+'%');
			    });
			}
			function bindEvent(){
				/* $('#sevice').click(function(){//服务
					window.location.href =_path+"/consumer/services-list.jsp";
				})
				$('#home').click(function(){//首页
					window.location.href =_path+"/consumer/home";
				});
				$('#device').click(function(){//设备
					window.location.href =_path+"/consumer/project.jsp";
				});
				$('#attention').click(function(){//关注
					window.location.href =_path+"/consumer/device-follow.jsp";
				});
				$('#me').click(function(){//我的
					window.location.href =_path+"/consumer/me.jsp";
				});
				$('#message').click(function(){//消息
					window.location.href =_path+"/consumer/news.jsp";
				}); */
				$('.weui-tabbar__item').on('click', function () {
		            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
		        });
				$('.ceshi').click(function(){//跳转至监测详情
					window.location.href =_path+"/consumer/device-details.jsp";
				});
			}
			function drawEchart(){
				var myChart = echarts.init(document.getElementById('myChart'));
				//自适应分辨率
				$(window).resize(function(){
					//console.log('我变了');
					myChart.resize();
				});
				var data = 10;
				option = {
				    //backgroundColor: "#263559",
				    color: ["#cff7cd", "#6cf0da"],
				    textStyle: {
				        color: "#d7d7d7"
				    },
				    xAxis: [{
				        type: 'category',
				        axisTick: {
				            show: false
				        },
				        axisLine: {
				            lineStyle: {
				                color: '#fff',
				                width: 2,
				                shadowBlur: 10,
				                shadowColor: '#fff',
				                shadowOffsetX: 0,
				                shadowOffsetY: 1,
				                opacity: 0.5
				            }
				        } ,
				        data: [{
				            value: '设备运行情况',
				            textStyle: {
				                color: '#bcbfff',
				                fontSize: 14
				            }
				        }] 
				    }],
				    yAxis: [{
				        type: 'value',
				        name: "",
				        show: false,
				        axisTick: {
				            show: false
				        },
				        axisLine: {
				            show: false
				        },
				        splitLine: {
				            show: false
				        },
				    }],
				    series: [{
				        name: '正常运行的设备数',
				        type: 'bar',
				        barWidth: 100,				       
				        itemStyle: {
				            normal: {
				                color: 'rgba(0,0,0,0)',	
				                 label: {
                                    show: true,
                                    position: 'top',
                                    formatter: function(value) {
					                	return value.data+'(正常运行)'
					                },
                                    textStyle: {
                                        fontSize: 14,
                                        color:'#00a2ff'
                                    }
                                },			                
				                borderWidth: 2,
				                borderColor: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
				                    offset: 0,
				                    color: '#00a2ff'
				                }, {
				                    offset: 1,
				                    color: '#70ffac'
				                }]),
				                shadowBlur: 5,
				                shadowColor: '#fff',
				                shadowOffsetX: 0,
				                shadowOffsetY: 0,
				                opacity: 1,
				                barBorderRadius: 3
				            }
				        },
				        data: [10]
				    }, {
				        name: '预警中的设备数',
				        type: 'bar',
				        barWidth: 100,
				        barGap: "0%",
				        label: {
				            normal: {
				                show: true,
				                position: 'top',
				                //formatter: '{b}: {c}',
				                formatter: function(value) {
				                	//console.log(value);
				                	return value.value+'(预警中)'
				                    //return '↓' + ((value.data.originalcost - value.data.value) * 100 / value.data.originalcost).toFixed(2) + '%';
				                },
				                textStyle: {
				                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
				                        offset: 0,
				                        color: '#00a2ff'
				                    }, {
				                        offset: 1,
				                        color: '#70ffac'
				                    }]),
				                    fontSize: 14
				                }
				            }
				        },
				        itemStyle: {
				            normal: {
				                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
				                    offset: 0,
				                    color: '#00a2ff'
				                }, {
				                    offset: 1,
				                    color: '#70ffac'
				                }]),
				                barBorderRadius: 3
				            }
				        },
				        data: [{
				            "name": '',
				            "originalcost": 10,//总设备数
				            "value": 5
				        }]
				    }, ]
				};
				myChart.setOption(option);
			}			 
		</script>
		
		<script type="text/javascript" src="${_staticPath}/resource/weuiWeb/js/xy-common.js"></script>
	</body>
</html>