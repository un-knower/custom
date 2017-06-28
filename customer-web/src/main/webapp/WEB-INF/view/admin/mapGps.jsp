<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";font-size:14px;}
		#l-map{height:500px;width:100%;}
		#r-result{width:100%;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PfDU9hmL8qe4IWgoE8tQ3iTkClaMtwyC"></script>
	<title>百度地图获取Gps</title>
</head>
<body>
	<div id="l-map"></div>
	<div id="r-result">请输入:<input type="text" id="suggestId" size="20" value="百度" style="width:150px;" /></div>
	<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}

	var map = new BMap.Map("l-map");
	var point = new BMap.Point(104.071216,30.576279);
		map.centerAndZoom(point,12);                  // 初始化地图,设置城市和地图级别。
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId"
		,"location" : map
	});

	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
		var _value = e.item.value;
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
			
			setPlace();
	});

	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			var marker = new BMap.Marker(pp);// 创建标注
			map.addOverlay(marker);//添加标注
			marker.enableDragging();    //可拖拽
			markerClick(marker);
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
	}
	function markerClick(marker){
		var geoc = new BMap.Geocoder();
		/* var opts = {
		  width : 200,     // 信息窗口宽度
		  height: 100,     // 信息窗口高度
		  title : "青羊区大石东路7号院" , // 信息窗口标题
		  enableMessage:true,//设置允许信息窗发送短息
		  message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
		}
		var infoWindow = new BMap.InfoWindow("地址：青羊区大石东路7号院", opts);  // 创建信息窗口对象 
		marker.addEventListener("click", function(){          
			map.openInfoWindow(infoWindow,point); //开启信息窗口
			}); */
		marker.addEventListener("click",function(e){			 
		    var pt = e.point;
			geoc.getLocation(pt, function(rs){				
				var addComp = rs.addressComponents;
				var r=confirm('您当前选择的位置为  ：'+
				addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber+',          '+
				'经纬度   ： '+e.point.lng+ "," + e.point.lat);
				  if (r==true){
				    	//关闭页面，或者跳转页面  （回到编辑弹出框位置），填入获取的Gps，提交传给后台。。。
				    } else{
				    	//关闭信息框，重新选择
				    }
				//alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber+','+e.point.lng+ "," + e.point.lat);
			});
		});
	}
</script>