//$(function(){
	function eventCollection(weui){
	}
	var show = false, equipId='';
	//获取地址栏参数				
	function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  decodeURI(r[2]); return null;
	}
	if(GetQueryString('equipCode')){
		equipId = GetQueryString('equipCode');
	}
	//获取图表数据
	var chart = echarts.init(document.getElementById('rawCharts')),thisNum =0;
	getData(chart,equipId,thisNum);
		
	$('.weui-tabbar__item').on('click', function () {
		$(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
		var thisNum = $(this).index();
		$('.xy-tab-list').eq(thisNum).addClass('xy-tab-list_on').siblings('.xy-tab-list_on').removeClass('xy-tab-list_on');
		if(thisNum == 0){
			var chart =  echarts.init(document.getElementById('rawCharts'));
			getData(chart,equipId,thisNum);
			chart.resize();
		}else{
			var chart = echarts.init(document.getElementById('purCharts'));
			getData(chart,equipId,thisNum);
			chart.resize();
		}
		if(!show){
			//更新一次视图
			chart.resize();
			show = true;
		}		
	});	
//});
function getData(chart,equipId,thisNum){
	$.ajax({
		type:'get',
		url:_path+'/consumer/monitor/listNew?equipCode='+equipId,
		//data: {equipId:''},
		success : function(msg){
			console.log(msg);

			if(msg.data.secondDates.length == msg.data.purDatas.length&&msg.data.purDatas.length != 0)	{
				$('.xy-h1-title').html(msg.data.userName+"家的监测详情");
				drawEchart(chart,thisNum,msg.data);
			}			
		}
	});
}
 
function drawEchart(chart,thisNum,data){
	console.log(data);
	var xdata = data.secondDates,newData =[],len = xdata.length;
	for(var i = 0;i < len;i++){
		newData.push(xdata[i].slice(11))
	}	
	var	option = {
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
		/*legend: {
			x: 'left',
			y:'top',
			padding: [5,5,50,5],
			data:['原水数据'],
			textStyle:{
				color:'#000'
			}
		},*/
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
			//name:'原水数据',
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
			//data:data.rawDatas.reverse(),
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
		} ,
	};      
	// 使用刚指定的配置项和数据显示图表。
	chart.setOption(option,true);
	chart.on('click',function(params){
		console.log(params);
		//区域图里数据点的点击事件
		//点击逻辑
		if(params.data.value != undefined) return false;

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
	//判断用户手指滑动的方向
	//getTouchEvent(data,thisChart);					 					
}
//自适应分辨率
$(window).resize(function(){
	//alert('wobianl');
	chart.resize();
});
