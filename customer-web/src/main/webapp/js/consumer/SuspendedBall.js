//获取当前文件名
/*var  filename = location.href;
filename=filename.substr(filename.lastIndexOf('/')+1);  
*/
var PublicJs = {},_staticPath="http://192.168.10.201:8083/smart-static",_path="http://192.168.10.20:8086/customer-web";
PublicJs.IsPhone = function () {//判断是否是手机浏览器
    try {
        if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
            return true;
        } else {
            return false;
        }
    } catch (e) {
        return false;
    }
}
//鼠标事件
PublicJs.Mouse = {
    Down: (PublicJs.IsPhone() ? "touchstart" : "mousedown"),
    Move: (PublicJs.IsPhone() ? "touchmove" : "mousemove"),
    Up: (PublicJs.IsPhone() ? "touchend" : "mouseup"),
};
//鼠标移动
PublicJs.Move = function (e) {
    var move = { x: 0, y: 0 };
    var _e = e.touches ? e : window.event;
    if (PublicJs.IsPhone()) {
        try {
            // evt.preventDefault(); //阻止触摸时浏览器的缩放、滚动条滚动等
            var touch = _e.touches[0]; //获取第一个触点
            move.x = Number(touch.pageX); //页面触点X坐标
            move.y = Number(touch.pageY); //页面触点Y坐标
        } catch (e) {
            move.x = _e.screenX;
            move.y = _e.screenY;
        }
    }
    else {
        move.x = e.screenX;
        move.y = e.screenY;
    }
    return move;
};


//悬浮球
var SuspendedBall = {
    ShowWidth: 500,//显示悬浮球的页面宽度
    //添加悬浮球 参数集合可中包含有 top、left、scc、class四个属性
    Add: function (obj) {
        if ($(".SuspendedBall").length == 0) {
            $("body").append("<div class=\"SuspendedBall\"><div></div></div>")
            $("body").append("<div class=\"BallBox\"><div class=\"Bg\"></div><div class=\"BallBoxInfo\"></div></div>")
        }
        if (obj) {
            var _this = $(".SuspendedBall");
            if (typeof (obj.top) != "undefined") {
                _this.offset({ top: obj.top });
                _this.css({ top: obj.top });
            }
            if (typeof (obj.left) != "undefined") {
                _this.offset({ left: obj.left });
                _this.css({ left: obj.left });
            }
            if (typeof (obj.css) != "undefined") {
                _this.css(obj.css);
            }
            if (typeof (obj.class) != "undefined") {
                _this.addClass(obj.class);
            }
        }
    },
    //控制悬浮球移动，显示的方法 其中UpFun是指的当触摸或鼠标抬起的时候的执行的方法
    Move: function (UpFun) {//第一个参数是鼠标抬起的事件触发，第二个参数是创建的时候添加的其他事件
        var x = 0, y = 0;
        var sx = 0, sy = 0;
        var mx = 0, my = 0;
        var isDown = false;
        var isMove = false;
        $(window).resize(function () {
		var newWinW = $(window).width();
		var newWinH = $(window).height();
		var position = sessionStorage.getItem("ballPosition");
		if(position != undefined || position != null){
			position = JSON.parse(position);
		}
		var newLeft = (position.left/position.oldWinW)*newWinW;
		var newTop = (position.top/position.oldWinH)*newWinH;
		var NewPosition = {
			left: newLeft,
			top: newTop,
			oldWinW: newWinW,
			oldWinH: newWinH
		};
		//存储新的位置
		sessionStorage.setItem("ballPosition",JSON.stringify(NewPosition));
		//变更悬浮球位置
		SuspendedBall.Add(NewPosition);
	})
        $("body").bind(PublicJs.Mouse.Down, function (e) {
            //if ($(window).width() < SuspendedBall.ShowWidth) {
                $(".SuspendedBall").show();
                $(".BallBox").hide();
            //}
        });
        $(".BallBox").bind(PublicJs.Mouse.Down, function (e) {
            /*if ($(window).width() < SuspendedBall.ShowWidth) {
                $(".SuspendedBall").show();
                $(".BallBox").hide();
            }*/
		//获取列表里点击元素	
		var clickBox = $(e.target).is("a")?$(e.target):$(e.target).parents("a");
		console.log(clickBox);
		if(clickBox.is(".nav_href_1")){
			//首页
			window.location.href =_path+"/consumer/home.jsp";
		}else if(clickBox.is(".nav_href_2")){
			//设备
			window.location.href =_path+"/consumer/project.jsp";
		}else if(clickBox.is(".nav_href_3")){
			//关注
			window.location.href =_path+"/consumer/device-follow.jsp";
		}else if(clickBox.is(".nav_href_4")){
			//服务列表
			sessionStorage.setItem('iffuwu',1);//跳转页面，公用一个列表页，设假数据为1，若1 ==》 跳转页面标题改成"历史服务记录列表";
			window.location.href=_path+"/consumer/services-list.jsp";
		}else if(clickBox.is(".nav_href_5")){
			//我的
			window.location.href =_path+"/consumer/me.jsp";
		}else if(clickBox.is("#xy-lyBtn")){
			//录音 显示录音动画
			clickBox.prev().show();
		}
            return false;//取消元素事件向下冒泡
        });
        $(".BallBox").bind(PublicJs.Mouse.Up, function (e) {
		//获取录音动画
		var ly = $(".xy-ly-dh");
		//监测录音动画元素是否显示
		if(ly.is(":visible")){
			ly.hide();
		}
            return false;//取消元素事件向下冒泡
        });
        $(".SuspendedBall").bind(PublicJs.Mouse.Down, function (e) {
            //#region 去除原有的动画样式
            var right = $(window).width() - $(this).width();
            var bottom = $(window).height() - $(this).height();
            if ($(this).hasClass("ToLeft")) {
                $(this).removeClass("ToLeft").offset({ left: 0 });
            }
            else if ($(this).hasClass("ToTop")) {
                $(this).removeClass("ToTop").offset({ top: 0 });
            }
            else if ($(this).hasClass("ToBottom")) {
                $(this).removeClass("ToBottom").offset({ top: bottom });
            }
            else if ($(this).hasClass("ToRight")) {
                $(this).removeClass("ToRight").offset({ left: right });
            }
            //#endregion-----
            isDown = true;
            x = $(this).offset().left;
            y = $(this).offset().top;
            var move = PublicJs.Move(e);
            sx = move.x;
            sy = move.y;
            return false;//取消元素事件向下冒泡
        });
        $(".SuspendedBall").bind(PublicJs.Mouse.Move, function (e) {
            if (isDown) {
                var move = PublicJs.Move(e);
                mx = move.x - sx;//获取鼠标移动了多少
                my = move.y - sy;//获取鼠标移动了多少

                var movemunber = 5;//当触摸的时候移动像素小于这个值的时候代表着不移动
                if ((mx) > movemunber || (0 - mx) > movemunber || (my) > movemunber || (0 - my) > movemunber) {
                    isMove = true;
                }
                var _top = (y + my), _left = (x + mx);
                var maxtop = $(window).height()-$(this).height();//获取最小的宽度
                var maxleft = $(window).width() - $(this).width();//获取最大的宽度
                _top = _top < 0 ? 0 : (_top > maxtop ? maxtop : _top);//避免小球移除移出去
                _left = _left > 0 ? _left : 0;//避免小球移除移出去
                $(this).offset({ top: _top , left: _left });
                mx = move.x;
                my = move.y;
                // isMove = true;
            }
            return false;//取消元素事件向下冒泡
        })
        $(".SuspendedBall").bind(PublicJs.Mouse.Up, function (e) {
            var _this = this;
            //添加定时器，是因为有的时候move事件还没运行完就运行了这个事件，为了给这个时间添加一个缓冲时间这里定义了10毫秒
            setTimeout(function () {
                if (isMove) {//如果移动了执行移动方法
                    var move = { x: $(_this).offset().left, y: $(_this).offset().top };
                    var width = $(window).width() / 2;
                    var height = $(window).height() / 2;
                    var ToLeftOrRight = "left";
                    var ToTopOrBottom = "top";
                    var MoveTo = "x";
                    if (move.x > width) {
                        ToLeftOrRight = "right";
                        move.x = 2 * width - move.x;//左右边距
                    }
                    if (move.y > height) {
                        ToTopOrBottom = "bottom";
                        move.y = 2 * height - move.y;//上下边距
                    }
                    if (move.x > move.y) {
                        MoveTo = "y";
                    }

                    $(_this).removeClass("ToLeft").removeClass("ToTop").removeClass("ToBottom").removeClass("ToRight");//去除原样式
			//获取球的位置 并存储
			var winW = $(window).width();
			var winH = $(window).height();
			var ballLeft = 0;//默认值
			var ballTop = winH/2 - 25;//默认值
                    if (MoveTo == "x") {
                        if (ToLeftOrRight == "left") {
                            $(_this).addClass("ToLeft");
				ballLeft = 0;
				ballTop = $(_this).position().top;
                        }
                        else {
                            $(_this).addClass("ToRight");
				ballLeft = winW - 50;
				ballTop = $(_this).position().top;
                        }
                    }
                    else {
                        if (ToTopOrBottom == "top") {
                            $(_this).addClass("ToTop");
				ballLeft = $(_this).position().left;
				ballTop = 0;
                        }
                        else {
                            $(_this).addClass("ToBottom");
				ballLeft = $(_this).position().left;
				ballTop = winH - 50;
                        }
                    }
			var position = {
				left: ballLeft,
				top: ballTop,
				oldWinW: winW, //当前窗口宽度
				oldWinH: winH //当前窗口高度
			};
			sessionStorage.setItem("ballPosition",JSON.stringify(position));
                }
                else {
                    if (typeof (UpFun) == "function") {
                        UpFun();
                    }
                    $(".SuspendedBall").hide();
                    $(".BallBox").show();
                }
                isDown = false;
                isMove = false;
            }, 10);
            return false;//取消元素事件向下冒泡
        })
    },
    //这个方法是显示页面上面的悬浮球方法
    ShowBall: function () {
        $(".SuspendedBall").show();
        $(".BallBox").hide();
    },
    //这个方法是显示页面上面的悬浮球菜单的方法
    ShowBox: function () {
        $(".SuspendedBall").hide();
        $(".BallBox").show();
    },
    //这个方法是给悬浮球菜单添加内容的方法
    BoxHtml: function (html) {
        $(".BallBoxInfo").html(html);
    },
    //这个方法是获取到父级页面的悬浮球的方法
    Partent: function () {
        if (typeof (window.parent.SuspendedBall) != "undefind") {
            return window.parent.SuspendedBall;
        }
        return null;
    }
};
//frame页面点击隐藏顶级父页面悬浮球菜单的方法
function FrameBodyClick() {
    var topWin = (function (p, c) {
        while (p != c) {
            c = p
            p = p.parent
        }
        return c
    })(window.parent, window);
    $("body").bind(PublicJs.Mouse.Down, function (e) {
        if (topWin.SuspendedBall) {
            if ($(window).width() < topWin.SuspendedBall.ShowWidth) {
                topWin.SuspendedBall.ShowBall();
            }
        }
    });
}
$(function () {
    FrameBodyClick();
	
	/*var supendeBallUI = "";
	//修改框内布局
	if(filename == "index.html"){
		//是首页 
		supendeBallUI =  '<div class="xy-wave-img xy-poab xy-tac xy-dn xy-ly-dh"><img src="img/icon-wave.png" /></div>'+
						'<a class="xy-voice-bar xy-top-corner xy-tac xy-pad-t20 xy-poab" id="xy-lyBtn">'+
						'	<div class="xy-db xy-voice-seat"><span class="xy-voice-img xy-line-h0"><img src="img/icon-voice.png" /></span></div>'+
						'</a>';
	}else{
		//不是首页 
		supendeBallUI =  '<a class="xy-voice-bar xy-top-corner xy-tac xy-pad-t20 xy-poab">'+
						'	<div class="xy-db xy-voice-seat"><span class="xy-voice-img xy-qt-img xy-line-h0"><img src="img/icon-corner-qt.png" /></span></div>'+
						'</a>';
	}*/
	//悬浮框ui
	var supendeBallDom = ''+
		'<div class="xy-nav-bar xy-pad-lr10 xy-pore">'+
		'	<a class="xy-voice-bar xy-top-corner xy-tac xy-pad-t20 xy-poab">'+
		'		<div class="xy-db xy-voice-seat"><span class="xy-voice-img xy-qt-img xy-line-h0"><img src="'+_staticPath+'/resource/weuiWeb/img/icon-corner-qt.png" /></span></div>'+
		'	</a>'+
		'	<div class="weui-navbar xy-navbar xy-navbar-seat xy-layout-bar bg-white reset-poab reset-top">'+
		'		<a class="weui-navbar__item nav_href_1" href="javascript:;"><!--判断 nav_href_1 连接首页-->'+
		'			<p class="xy-navbar-icon xy-line-h0"><img src="'+_staticPath+'/resource/weuiWeb/img/nav-home.png" /></p>'+	
		'			<p class="xy-pad-t2">首页</p>'+
		'		</a>'+
		'		<a class="weui-navbar__item nav_href_2" href="javascript:;"><!--判断 nav_href_2 连接设备列表-->'+
		'			<p class="xy-navbar-icon xy-line-h0"><img src="'+_staticPath+'/resource/weuiWeb/img/nav-warning.png" /></p>'+
		'			<p class="xy-pad-t2">设备</p>'+
		'		</a>'+
		'		<a class="weui-navbar__item nav_href_3" href="javascript:;"><!--判断 nav_href_3 连接关注列表-->'+
		'			<p class="xy-navbar-icon xy-line-h0"><img src="'+_staticPath+'/resource/weuiWeb/img/nav-follow.png" /></p>'+
		'			<p class="xy-pad-t2">关注</p>'+
		'		</a>'+
		'		<a class="weui-navbar__item nav_href_4" href="javascript:;"><!--判断 nav_href_4 连接服务列表-->'+
		'			<p class="xy-navbar-icon xy-line-h0"><img src="'+_staticPath+'/resource/weuiWeb/img/nav-heart-shaped.png" /></p>'+
		'			<p class="xy-pad-t2">服务</p>'+
		'		</a>'+
		'		<a class="weui-navbar__item nav_href_5" href="javascript:;"><!--判断 nav_href_5 连接我的个人中心-->'+
		'			<p class="xy-navbar-icon xy-line-h0"><img src="'+_staticPath+'/resource/weuiWeb/img/nav-me.png" /></p>'+
		'			<p class="xy-pad-t2">我的</p>'+
		'		</a>'+
		'	</div>'+
		'</div>';
	
	//获取存储球的位置 改变当前位置
	var position =  sessionStorage.getItem("ballPosition");
	if(position != undefined || position != null){
		position = JSON.parse(position);
	}
	//添加悬浮球
	SuspendedBall.Add(position);
	SuspendedBall.BoxHtml(supendeBallDom);
	SuspendedBall.Move();
	
})