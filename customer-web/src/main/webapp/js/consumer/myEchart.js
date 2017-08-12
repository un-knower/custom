$(function(){
	function eventCollection(weui){
	}
	var show = false, equipId='';	
	if(GetQueryString('equipCode')){
		equipId = GetQueryString('equipCode');
	}
	//bindEvent();
	//获取图表数据
	var chart = echarts.init(document.getElementById('rawCharts')),thisNum =0,endTime='',type='',data;
	getData(chart,equipId,thisNum,endTime,type,data);//初始化画表				
	function getData(chart,equipId,thisNum,endTime,type,data){
		$.ajax({
			type:'get',
			url:_path+'/consumer/monitor/list?equipCode='+equipId+'&endTime='+endTime+'&type='+type,
			success : function(msg){
				console.log(msg);
				if(msg.data.secondDates.length == msg.data.purDatas.length&&msg.data.purDatas.length != 0)	{					
					$('.xy-h1-title').html(msg.data.userName+"家的监测详情");
					if(data){
						data.secondDates.push.apply(data.secondDates,msg.data.secondDates);
						data.purDatas.push.apply(data.purDatas,msg.data.purDatas);
						data.rawDatas.push.apply(data.rawDatas,msg.data.rawDatas);
						drawEchart(chart,thisNum,data,type);
					}else drawEchart(chart,thisNum,msg.data,type);					
				}			
			}
		});
	}
	$('.weui-tabbar__item').on('click', function () {
		$(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
		var thisNum = $(this).index();
		$('.xy-tab-list').eq(thisNum).addClass('xy-tab-list_on').siblings('.xy-tab-list_on').removeClass('xy-tab-list_on');
		if(thisNum == 0){
			var chart =  echarts.init(document.getElementById('rawCharts'));
			getData(chart,equipId,thisNum,endTime,type);
			chart.resize();
		}else{
			var chart = echarts.init(document.getElementById('purCharts'));
			getData(chart,equipId,thisNum,endTime,type);
			chart.resize();
		}
		if(!show){
			//更新一次视图
			chart.resize();
			show = true;
		}		
	});
	function drawEchart(chart,thisNum,data){
		console.log(data);
		var xdata = data.secondDates,newData =[],len = xdata.length;
		for(var i = 0;i < len;i++){
			if(type) newData.push(xdata[i].slice(0,10))
			else newData.push(xdata[i].slice(11))
		}
		var	option = {
			title : {
				x: 'center',
				y: 'bottom',
				padding: [5,5,50,5],
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
			calculable : true,
			xAxis : [
				{
					type : 'category',
					boundaryGap : false,
					data : newData.reverse(), 			          
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
			series :{
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
				areaStyle: {
					normal:{
						//color:'#000'
						color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
							offset: 0, color: '#7312e9'
						}, {
							offset: 0.5, color: '#D4C7FE'
						}, {
							offset: 1, color: '#fff'
						}], false)
					}
				},
				itemStyle: {
				  normal: {
					color: '#7B52EE',
				  }
				},
				data:thisNum == 0?data.rawDatas.reverse():data.purDatas.reverse(),
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
						},
						label :{
							normal:{
								position: 'middle',
								formatter: '{b}: {c}%'
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
						},
						label :{
							normal:{
								position: 'middle',
								formatter: '{b}: {c}%'
							}
						}
					}] 
				}
			},
		};
		// 使用刚指定的配置项和数据显示图表。	
		chart.setOption(option,true);
		//向右滑动到最左边时请求接口
		chart.on('datazoom',function(params){
			var opt = chart.getOption(),dz = opt.dataZoom[0],s = opt.xAxis[0].data[dz.startValue],
			a = data.secondDates[data.secondDates.length-1];
			//console.log(data);
			if(s == a.slice(11)){
				getData(chart,equipId,thisNum,a,type,data) 
				return				
			}
		});
	}
	//自适应分辨率
	$(window).resize(function(){
		//alert('wobianl');
		chart.resize();
	});
	//手指缩放事件?在echart图表中有bug，图表区域无响应
	touch.on('#rawCharts', 'pinchout', function(ev){
	    //alert("you have done", ev.type);
		type = 'day';
		getData(chart,equipId,thisNum,endTime,type,data)
	});
	touch.on('#rawCharts', 'pinchin', function(ev){
	    //alert("you have done", ev.type);
		type = '';
		getData(chart,equipId,thisNum,endTime,type,data)
	});
	/*$('#rawCharts').click(function(){
		type = 'day';
		getData(chart,equipId,thisNum,endTime,type,data)
	});*/
});
//获取地址栏参数				
function GetQueryString(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
}