$(function(){
	
	$.extend($.fn.validatebox.defaults.rules, {
		isNumber:{
			validator:function(val){
				return !isNaN(val);
			},
			message:"必须是数字！"
		},
		myEqLength:{
			validator:function(val, params){
				/* for(var i=0; i<params.length; i++){
					console.log(params[i]);
				} */
				return val.length==params[0];
			},
			message:"长度必须是{0}位！！"
		},
		myLength:{
			validator:function(val, params){
				return val.length>=params[0] && val.length<=params[1];
			},
			message:"长度必须是{0}到{1}位！！！"
		},
		myEquals:{
			validator:function(value, params){
				return value == $(params[0]).val();
			},
			message:"两次输入必须一致！！！"
		},
		phoneNum: { //验证手机号   
	        validator: function(value, param){ 
	         return /^1[3-8]+\d{9}$/.test(value);
	        },    
	        message: '请输入正确的手机号码。'   
	    },
	    
	    telNum:{ //既验证手机号，又验证座机号
	      validator: function(value, param){ 
	          return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\d{3})|(\d{3}\-))?(1[358]\d{9})$)/.test(value);
	         },    
	         message: '请输入正确的电话号码。' 
	    },
	    phone : {// 验证电话号码  
            validator : function(value) {  
                return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);  
            },  
            message : '格式不正确,请使用下面格式:020-88888888'  
        },  
        mobile : {// 验证手机号码  
            validator : function(value) {  
                return /^(13|15|18)\d{9}$/i.test(value);  
            },  
            message : '手机号码格式不正确'  
        },  
        phoneAndMobile : {// 电话号码或手机号码  
            validator : function(value) {  
                return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value) || /^(13|15|18)\d{9}$/i.test(value);  
            },  
            message : '电话号码或手机号码格式不正确'  
        },  
		/*
		自定义规则名:{
			// 校验函数
			validator:function(){
			
			},
			// 错误提示信息
			mesasge:"错误提示"
		},
		自定义名2:{}
		*/
	});
	
	// 日期的格式转换
	/*$.fn.datebox.defaults.formatter = function(mydate){
		var y = mydate.getFullYear();
		var m = mydate.getMonth() + 1;
		var d = mydate.getDate();
		console.log(y+"/"+m+"/"+d);
		return y+"/"+m+"/"+d;
	}; 
	$.fn.datebox.defaults.parser = function(strDate){
		var t = Date.parse(strDate);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	};*/
});


/*  
 *easyui通用js代码 
 *  
 */  
  
function showMessage(title,text){  
    $.messager.show({  
        title:title,  
        msg:'<center>'+text+'</center>',  
        timeout:2000,  
        showType:'show',  
        style:{  
            right:'',  
            top:document.body.scrollTop+document.documentElement.scrollTop,  
            bottom:''  
        }  
    });  
}  
  
  
/** 
  * 创建窗口 参数是json格式 
  * @param url url   
  * @param title 窗口标题 
  * @param callback 点击确定按钮的回调函数 
  * @param width  窗口宽度 可以不指定 
  * @param height 窗口高度 可以不指定 
  * @param tools 添加额外按钮 
  */  
 function createWindow(parament){  
     if(!parament)  
         return;  
     var win;  
     var tools = [];  
     if(parament.tools){  
         for(var i = 0;i<parament.tools.length;i++){  
             tools.push(parament.tools[i]);  
         }  
     }  
     if(parament.callback){  
         tools.push({  
             iconCls:'icon-ok',  
             text:$.messager.defaults.ok,  
             handler:parament.callback//调用回调函数  
               
         });  
     }  
     if(!parament.cancel){  
         tools.push({  
             text:$.messager.defaults.cancel,  
             iconCls:'icon-cancel',  
             handler:function(){  
                 win.window("close");  
             }  
         });  
     }  
     var id = parament.id?'#'+parament.id:'#win';  
     win = $(id).dialog({  
         title:parament.title,  
         onLoad:parament.onLoad?parament.onLoad:function(){},  
         width:parament.width?parament.width:$(window).width()>900?900:900*0.9,     
         left:parament.left?parament.left:null,  
         top:parament.top?parament.top:null,  
         height:parament.height?parament.height:$(window).height()>600?600:600*0.9,      
         modal:true,  
         method:parament.method?parament.method:'get',  
         queryParams:parament.queryParams?parament.queryParams:{},  
         href:parament.url,  
         buttons:tools  
     });  
     return win;  
 }  
   
 /** 
  *  
  * @param parament 参数parament的说明  
  * 参数parament是一个json格式，名称和用法和jquery ajax一致 
  * 此方法仅仅是添加了ajax发送请求时出现进度条 
  * parament.progressText是进度条的提示文字  已默认国际化无特殊要求可不填 
  * parament.autoCloseProgress 关闭进度条方式，默认在success回调函数中关闭,设置为false则在回调函数执行完毕后再关闭进度条 
  */  
 function Ajax(parament){  
     $.ajax({  
         type:parament.type?parament.type:"post",  
         url:parament.url,  
         data:parament.data,  
         dataType:parament.dataType,  
         async:parament.async!=undefined?parament.async:true,  
         beforeSend:function(XMLHttpRequest){  
           var text = $("#loadText").val();  
           if(parament.progressText)  
               text = parament.progressText;  
           $.messager.progress({text:text});   
           if(parament.beforeSend)  
               parament.beforeSend(XMLHttpRequest);  
         },  
         success:function(data){  
             if(parament.autoCloseProgress==undefined||parament.autoCloseProgress==true){  
                 $.messager.progress("close");  
                 parament.success(data);  
             }else{  
            	 setTimeout(function(){
            		 if(parament.successText!=undefined){
	            		 $.messager.progress({text:parament.successText});
	            	 }
             	 },1000);
            	 setTimeout(function(){
            		 parament.success(data);  
            		 $.messager.progress("close");
                 },1500);  
             }  
               
         },  
         error:function(request,error,exception){  
             $.messager.progress("close");  
             if(parament.error)  
                 parament.error(request,error,exception);  
             else  
                 alert("System error! "+error);  
         },  
         contentType:parament.contentType,  
         complete:parament.complete,  
         timeout:parament.timeout  
     });  
 }  
   
 /** 
  * easyui FORM表单说明 
  * @param id FORM的ID 如'#form' 
  * @param parament json格式 名称和原来的一样 添加了progressText(进度条文本),dataType(设置dataType='json')回调函数返回的值会自动转换成json格式 
  * parament.autoCloseProgress 关闭进度条方式，默认在success回调函数中关闭,设置为false则在回调函数执行完毕后再关闭进度条 
  * parament.autoValidate 是否自动验证，设置false不自动验证表单，默认自动验证在onSumit时验证 
  * parment.progress false表示不显示进度条 
  * parment.ok  配置createWindow使用的 确定按钮，如传入则用此方法控制该按钮 
  */  
 function formSubmit(id,parament){  
     var form = $(id);  
     form.form({  
            url:parament.url,  
            novalidate:parament.novalidate?parament.novalidate:false,  
            onSubmit:function(param){  
                if((parament.autoValidate||parament.autoValidate==undefined)&&!form.form('validate'))  
                    return false;  
                if(parament.progress){  
                    var text = $("#loadText").val();  
                    if(parament.progressText)  
                        text = parament.progressText;  
                    $.messager.progress({text:text});   
                }  
                if(parament.ok)  
                    parament.ok.linkbutton("disable");//禁用确定按钮  
                if(parament.onSubmit){  
                    if(parament.onSubmit(param)==false)  
                        return false;  
                }  
            },  
            onLoadError :function(){  
                if(parament.progress)  
                    $.messager.progress('close');  
                if(parament.ok)  
                    parament.ok.linkbutton("enable");//启用确定按钮  
                 if(parament.onLoadError)  
                     parament.onLoadError();  
            },  
            success:function(data){  
                if(!parament.dataType||(parament.dataType&parament.dataType.toLowerCase()=="json"))  
                    data = eval('(' + data + ')');  // form表单必须手动转换为json     
                if(parament.progress){  
                    if(parament.autoCloseProgress==undefined||parament.autoCloseProgress==true){  
                        $.messager.progress("close");  
                    }  
                }  
                if(parament.ok)  
                    parament.ok.linkbutton("enable");//启用确定按钮  
                parament.success(data);  
                 
            }      
        }).submit();  
 }  