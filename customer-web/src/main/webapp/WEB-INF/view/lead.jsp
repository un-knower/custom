<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml-transitional.dtd">
<html>
<head>
    <title>lead</title>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- <link href="${_staticPath}/resource/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" / -->

	<!-- HTML5 Shim �?Respond.js 用于�?IE8 支持 HTML5元素和媒体查�?-->
	<!-- <script src="${_staticPath}/resource/bootstrap-3.3.5/js/html5shiv.js"></script>
	<script src="${_staticPath}/resource/bootstrap-3.3.5/js/respond.min.js"></script> -->

	<script src="${_staticPath}/resource/jquery/jquery-2.0.3.min.js"></script>
	<!-- <script src="${_staticPath}/resource/bootstrap-3.3.5/js/bootstrap.min.js"></script> -->
	
	<script src="${_staticPath}/resource/swiper/swiper.jquery.min.js"></script>
	<link href = "${_staticPath}/resource/swiper/swiper.min.css" rel="stylesheet"/>
<style>
ul,li {
		list-style: none;
	}
.pagination {
  position: absolute;
  left: 0;
  text-align: center;
  bottom:5px;
  width: 100%;
  z-index:999;
}
.swiper-pagination-switch {
  display: inline-block;
  width: 20px;
  height: 20px;
  border-radius: 10px;
  background: red;
  box-shadow: 0px 1px 2px #555 inset;
  margin: 0 3px;
  cursor: pointer;
} 
.swiper-active-switch{background: yellow;}
img{
	width:100%;
	height:100%;
}
</style>
<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
<body>
	<div id="lead" class="swiper-container" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-23" data-genuitec-path="/test/WebRoot/lead.html">
		<div class="swiper-wrapper">
			<div class="swiper-slide"> <img src="${_staticPath}/resource/images/customer/1.jpg"> </div>
	        <div class="swiper-slide"> <img src="${_staticPath}/resource/images/customer/2.jpg"> </div>
	        <div class="swiper-slide"><img src="${_staticPath}/resource/images/customer/3.jpg"> </div> 
		</div>
	</div>
	<div class="pagination"></div>
</body>
<script>
	$(function(){
		var mySwiper = new Swiper('.swiper-container',{
		    pagination: '.pagination',
		    //loop : true,
		    autoplay :1500,
		    autoplayStopOnLast:true,
    		autoplayDisableOnInteraction : true,
		    grabCursor: true,
		    paginationClickable: true
		  })
		setTimeout(function(){
			window.location.href ="${_path}"+"/consumer/home";
		},5000);

	})
</script>
</html>