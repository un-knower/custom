<%@ page language="java" pageEncoding="utf-8"%>

<jsp:include page="../../common/common.jsp">
	<jsp:param name="title" value="应用"/>
</jsp:include>

<div class="page-header">
	<h1>
		设备入库
	</h1>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<div class="col-xs-12">
				<div>
					<!-- <a id="getQRcode" href="#" class="btn btn-app btn-success">
						<i class="ace-icon fa fa-refresh bigger-230"></i>
						<font>
							获取最新
						</font>
					</a> -->
					<a id="getQRcode" href="#"></a>
					<a id="printCode" href="#" class="btn btn-app btn-success">
						<i class="ace-icon fa fa-print bigger-230"></i>
						<font>
							打印
						</font>
					</a>
					<a id="addEquip" href="#" class="btn btn-app btn-success">
						<i class="ace-icon fa fa-pencil-square-o bigger-230"></i>
						<font>
							设备入库
						</font>
					</a>
					
					<form id="addEquipForm" method="post">
						<!-- <input id="equipCode_input" type="hidden" name="equipCode"/>
						<input id="username_input" type="hidden" name="username"/>
						<input id="password_input" type="hidden" name="password"/> -->
						
						<br/>
						<label class="control-label" for="form-field-1"> 运营商： </label>
						<select id="operatorSort_select" name="operatorSort">
							<option value="">选择分类</option>
							<option value="1">移动</option>
							<option value="2">联通</option>
						</select>
						<label class="control-label" for="form-field-1"> 物联网卡号： </label>
						<input id="cardNumber_input" type="text" name="cardNumber"/>
						<br/><br/>
						<label class="control-label" for="form-field-1"> 设备编号： </label>
						<input id="equipCode_input" type="text" readonly  unselectable="on" name="equipCode"/>
						<br/><br/>
						<label class="control-label" for="form-field-1">  账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号： </label>
						<input id="username_input" type="text" readonly  unselectable="on" name="username"/>
						<br/><br/>
						<label class="control-label" for="form-field-1">  密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码： </label>
						<input id="password_input" type="text" readonly  unselectable="on" name="password"/>
						<br/><br/> 
						
						<!-- <br/>
						<label class="control-label" for="form-field-1"> 设备分类： </label>
						<select id="equipSort_select" class="form-control" name="equipSortId"><option value="">选择分类</option></select>
						<br/><br/>
						<label class="control-label" for="form-field-1"> 物联网卡号： </label>
						<input id="cardNumber_input" type="text" name="cardNumber"/>
						<br/><br/>
						<label class="control-label" for="form-field-1"> 设备编号： </label>
						<input id="equipCode_input" type="text" name="equipCode"/>
						<br/><br/>
						<label class="control-label" for="form-field-1">  账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号： </label>
						<input id="username_input" type="text" name="username"/>
						<br/><br/>
						<label class="control-label" for="form-field-1">  密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码： </label>
						<input id="password_input" type="text" name="password"/>
						<br/><br/> -->
						
					</form>
				</div>
				<div>
					<div>
						&emsp;&emsp;&emsp;&emsp;
						<label class="control-label" for="form-field-1"> 生产用二维码 </label>
						<br/>
						<img id="productionQRcodeImage" src="#"/>
					</div>
					&emsp;&emsp;&emsp;&emsp;
					<label class="control-label" for="form-field-1"> 打印用二维码 </label>
					<div id="printArea">
						<img id="equipQRcodeImage" src="#"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




<script type="text/javascript">
	scripts.push(
			"${_staticPath}/custom/zTree/js/jquery.ztree.core-3.5.min.js?v=" + Math.random(),
			"${_staticPath}/custom/zTree/js/jquery.ztree.excheck-3.5.min.js?v=" + Math.random(),
			"${_path}/js/admin/jquery.PrintArea.js"
			);
			
	var myScripts = [
		// 验证
		"${_staticPath}/custom/jquery.validate-2.0.min.js?v=" + Math.random(),
		"${_staticPath}/custom/jquery.validate-2.0.custom.min.js?v=" + Math.random()
	];
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {	
		jQuery(function($) {
			//加载设备分类
			/* $.ajax({
				type : "get", 
	            url : "${_path}/admin/equip/listEquipSort", 
	            data : null, 
	            async : true, 
	            cache : false,
	            dataType : "json",
	          	success : function(result){ 
	          		if(result.success){
	          			setEquipSort(result.data);
	          		}
	          	}
		    }); */
		    //注册获取更新单击事件
			$("#getQRcode").click(function(){
				$.ajax({
					type : "get", 
		            url : "${_path}/admin/equip/getEquipParam", 
		            data : null, 
		            async : true, 
		            cache : false,
		            dataType : "json",
		          	success : function(result){ 
		          		if(result.success){
		          			changeProductionImage(result.data.equipCode,result.data.username,result.data.password);
		          			changeEquipImage(result.data.equipCode);
		          			changeForm(result.data.equipCode,result.data.username,result.data.password);
		          		}
		          	}
			    });
			});
			//注册设备入库单击事件
			$("#addEquip").click(function(){
				var equipSortId=$("#equipSort_select").val();
				var operatorSort=$("#operatorSort_select").val();
				var cardNumber=$("#cardNumber_input").val();
				var equipCode=$("#equipCode_input").val();
				var username=$("#username_input").val();
				var password=$("#password_input").val();
				if(operatorSort ==null || !(operatorSort>0 && operatorSort<3)){
					$.gritter.add({
						text: "运营商不能为空",
						sticky: false,
						time: '1000'
					});
				}else if(cardNumber==null){
					$.gritter.add({
						text: "物联网卡号不能为空",
						sticky: false,
						time: '1000'
					});
				}else if(cardNumber.length!=20){
					$.gritter.add({
						text: "物联网卡号必须20位",
						sticky: false,
						time: '1000'
					});
				}else{
					$.ajax({
						type : "post", 
			            url : "${_path}/admin/equip/insert", 
			            data : {operatorSort:operatorSort,cardNumber:cardNumber,equipCode:equipCode,username:username,password:password}, 
			            async : true, 
			            cache : false,
			            dataType : "json",
			          	success : function(result){ 
			          		if(result.success){
								$.gritter.add({
									text: result.message,
									sticky: false,
									time: '1000'
								});
								reloadGetNew();
							}else{
								//这里打印提示信息
								$.gritter.add({
									text: "失败.code:"+result.code+".message:"+result.message,
									sticky: false,
									time: '1000'
								});
							}
			          	}
				    });
			    }
			});
			//注册打印单击事件
			$("#printCode").click(function(){
				$("div#printArea").printArea(); 
			});
			function reloadGetNew(){
				$.ajax({
					type : "get", 
		            url : "${_path}/admin/equip/getEquipParam", 
		            data : null, 
		            async : true, 
		            cache : false,
		            dataType : "json",
		          	success : function(result){ 
		          		if(result.success){
		          			changeProductionImage(result.data.equipCode,result.data.username,result.data.password);
		          			changeEquipImage(result.data.equipCode);
		          			changeForm(result.data.equipCode,result.data.username,result.data.password);
		          		}
		          	}
			    });
			}
			function changeProductionImage(equipCode,username,password){ 
				var img = document.getElementById("productionQRcodeImage");
				img.src="${_path}/admin/equip/getCodeImage?equipCode="+equipCode+"&username="+username+"&password="+password;
			}
			function changeEquipImage(equipCode){ 
				var img = document.getElementById("equipQRcodeImage");
				img.src="${_path}/admin/equip/getCodeImage?equipCode="+equipCode;
			}
			function changeForm(equipCode,username,password){
				$("#equipCode_input").val(equipCode);
				$("#username_input").val(username);
				$("#password_input").val(password);
			}
			/* function setEquipSort(list){
				$.each(list,function(index,element){
					$("#equipSort_select").append("<option value='"+element.id+"'>"+element.sortName+"</option>");
				});
			} */
			
			$("#getQRcode").click();
		});
	});
</script>
