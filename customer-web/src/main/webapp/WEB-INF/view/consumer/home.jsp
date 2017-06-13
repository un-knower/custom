<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml-transitional.dtd">
<html>
<head>
    <title>firstPage</title>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="${_staticPath}/resource/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${_staticPath}/resource/css/style.css"  rel="stylesheet" /> 
	<link href="${_staticPath}/resource/css/index.css"  rel="stylesheet" />
	<!-- HTML5 Shim �?Respond.js 用于�?IE8 支持 HTML5元素和媒体查�?-->
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/html5shiv.js"></script>
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/respond.min.js"></script>

	<script src="${_staticPath}/resource/jquery/jquery-2.0.3.min.js"></script>
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	
<style>
html, body{width:100%; height:100%;}
.container div{ width:110px; height:35px;border-radius: 7px;line-height:13px;
border:1px solid #ccc;padding:3% 7%;margin:0 6% 3% 0; float:left;
}
.container div:nth-child(3),.container div:nth-child(6){margin:0 0 3% 0;float:right;}
.container button{ margin-bottom: 4%;}
.banner{margin-bottom:0;background-color: #3D9BFB;;}
.bottom{position: relative;top: 85%;}
.bottom span:nth-child(2){float: right;}

/* nav样式，与其他页面不一�?*/

.circle,.ring{height:270px;width:270px;position: relative;
    }
.circle{margin:0 auto; position: absolute;
    top: 40%;
    left: 20%; }
.ring{background-color:rgba(255,255,255,0.3);border-radius:50%;opacity:0;-webkit-transform-origin:50% 50%;-moz-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-transform:scale(0.1) rotate(-270deg);
-moz-transform:scale(0.1) rotate(-270deg);-transform:scale(0.1) rotate(-270deg);-webkit-transition:all 0.4s ease-out;-moz-transition:all 0.4s ease-out;transition:all 0.4s ease-out;    border: 1px solid #fff;}
.open .ring{opacity:1;-webkit-transform:scale(1) rotate(0);-moz-transform:scale(1) rotate(0);-transform:scale(1) rotate(0);}
.center{border-radius:50%;bottom:0;color:white;height:50px;left:0;line-height:80px;margin:auto;position:absolute;right:0;text-align:center;top:0;width:80px;-webkit-transition:all 0.4s ease-out;-moz-transition:all 0.4s ease-out;transition:all 0.4s ease-out;}
.open .center{border-color:#aaaaaa;}
.menuItem{border-radius:50%;color:#fff;display:block;height:40px;line-height:20px;margin-left:-20px;
margin-top:-20px;position:absolute;text-align:center;width:60px;}
.ring img{width:60%;}
</style>
<body>
	<div class="banner" style="height:78%;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-13" data-genuitec-path="/test/WebRoot/html/firstPage.html">
		<div class="container">
			<h1>此处是背景与动画效果</h1>
		</div>
		<div class="bottom container">
			<span>监测次数<b></b></span>
			<span>服务次数<b></b></span>
		</div>
	</div>
	<div style="height:20%;">
		<nav class="navbar navdefault navbar-fixed-bottom">
			<div class="container">
				<div>温度 : <b></b></div>
				<div>温度 : <b></b></div>
				<div>温度 : <b></b></div>
				<div>温度 : <b></b></div>
				<div>温度 : <b></b></div>
				<div>温度 : <b></b></div>
				<button type="button" class="btn btn-default btn-lg btn-block" id="detail">监测详情</button>
			</div>
		</nav>
	</div>
	<div class="circle" >
		<div class="ring">
			<a id="home" href="#" class="menuItem fa"><span class="" aria-hidden="true">
			<img src="${_staticPath}/resource/images/home.png"/></span><br/><span class="f1">首页</span></a>
			<a id="warnRecord" href="#" class="menuItem fa"><span class="" aria-hidden="true">
			<img src="${_staticPath}/resource/images/warn.png"/></span><br/><span class="f1">预警记录</span></a>
			<a id="myPage" href="#" class="menuItem fa"><span class="" aria-hidden="true">
			<img src="${_staticPath}/resource/images/me.png"/></span><br/><span class="f1">我的</span></a>
			<a id="addPage" href="#" class="menuItem fa"><span class=" " aria-hidden="true">
			<img src="${_staticPath}/resource/images/add.png"/></span><br/><span class="f1">添加</span></a>
			<a id="deviceMan" href="#" class="menuItem fa"><span class=" " aria-hidden="true">
			<img src="${_staticPath}/resource/images/device.png"/></span><br/><span class="f1">设备管理</span></a>
			<a id="serRecord" href="#" class="menuItem fa"><span class=" " aria-hidden="true">
			<img src="${_staticPath}/resource/images/serve.png"/></span><br/><span class="f1">服务记录</span></a>
		</div>
		<a href="#" class="center fa"><span class="" aria-hidden="true" style="margin-top: 25px;">
		<img src="${_staticPath}/resource/images/logo-min.png"/></span></a>
	</div>
	<script type="text/javascript">
		var items = document.querySelectorAll('.menuItem');
		
		for(var i = 0, l = items.length; i < l; i++) {
		  items[i].style.left = (48 - 35*Math.cos(-0.5 * Math.PI - 2*(1/l)*i*Math.PI)).toFixed(4) + "%";
		  
		  items[i].style.top = (45 + 35*Math.sin(-0.5 * Math.PI - 2*(1/l)*i*Math.PI)).toFixed(4) + "%";
		}
		
		document.querySelector('.center').onclick = function(e) {
		   e.preventDefault(); document.querySelector('.circle').classList.toggle('open');
		}		
	</script>
</body>
<script>
$(function(){	
	bindEvent();
})
function bindEvent(){
	var hosturl = window.location.hostname;
	$('#detail').click(function(){
		window.location.href ="http://"+hosturl+":8080/test/html/monitorDetail.html";
	});
	$('#warnRecord').click(function(){
		window.location.href ="http://"+hosturl+":8080/test/html/remindPage.html";
	});
	$('#myPage').click(function(){
		window.location.href ="http://"+hosturl+":8080/test/html/self.html";
	});
	$('#deviceMan').click(function(){
		window.location.href ="http://"+hosturl+":8080/test/html/deviceMan.html";
	});
	$('#serRecord').click(function(){
		window.location.href ="http://"+hosturl+":8080/test/html/historyRecordPage.html";
	});
	
}
</script>
</html>