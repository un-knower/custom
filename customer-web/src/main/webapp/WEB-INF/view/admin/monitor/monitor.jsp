<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../common/common.jsp">
	<jsp:param name="title" value="管理员"/>
</jsp:include>

<div class="page-header">
	<h1>
		监测列表
	</h1>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<div class="col-xs-12">
				<div class="widget-box">
					<div class="widget-header widget-header-small">
						<h5 class="widget-title lighter">搜索栏</h5>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<form id="_form" class="form-inline">
								<label >
									<label class="control-label" for="form-field-1"> 设备编号： </label>
									<input name="equipCode" type="text" class="form-data input-medium search-data">
								</label> 
							</form>
						</div>
					</div>
				</div>

				<div>
					<div class="dataTables_wrapper form-inline no-footer">
						<table id="_table" class="table table-striped table-bordered table-hover dataTable no-footer">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="table-dialog"></div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
	
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			// 列表
    		var $table = $("#_table").table({
    			url : "${_path}/admin/monitor/list",
    			formId : "_form",
    			ajaxData : {//加载表格的请求设置
    				type : "post",
    				dataFormat : "json",
    				contentType : "application/json; charset=utf-8"
    			},
				tools : [
					{text : '删除', clazz : 'btn-danger', icon : 'fa fa-trash-o red', permission : '/admin/user/delete', handler : function(){
						$table.ajaxDelete({
							confirm : "删除管理员会影响关联的应用、角色、权限，确认要删除?",
							url : "${_path}/admin/user/delete"
						});
					}}
				],
				columns : [
			        {field:'rowkey',hide:true},
			        {field:'id', hide : true},
			        
			        {field:'rawTds', title:'原水TDS', mobileHide : true,validate:true},
			        {field:'purTds', title:'净水TDS', mobileHide : true,validate:true},
			        {field:'temp', title:'温度', mobileHide : true},
			        {field:'humidity', title:'湿度', mobileHide : true},
			        {field:'flow', title:'流量', mobileHide : true},
			        {field:'leak', title:'漏水开关(true-漏水、false-无漏水)', mobileHide : true},
			        {field:'magnetic', title:'电磁阀输出状态(true:电磁阀供电 false:电池阀不供电)', mobileHide : true},
			        {field:'outRelay', title:'输出继电器(true:闭合 false:断开)', mobileHide : true},
			        {field:'powerRelay', title:'电源继电器 (true:有输出 false:无输出)', mobileHide : true},
			        {field:'oneResult', title:'一级滤芯结果', mobileHide : true},
			        {field:'twoResult', title:'二级滤芯结果', mobileHide : true},
			        {field:'threeResult', title:'三级滤芯结果', mobileHide : true},
			        {field:'fourResult', title:'四级滤芯结果', mobileHide : true},
			        {field:'fiveResult', title:'五级滤芯结果', mobileHide : true},
			        {field:'microResult', title:'微生物芯结果', mobileHide : true},
			        
			        {field:'equipCode', title:'设备编号', align:'left'},
			        {field:'collectTime', title:'采集时间', mobileHide : true},
			        {field:'createTime', title:'创建时间', mobileHide : true}
				],
				operate : [
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/admin/user/edit', handler : function(d, i){
						//$.aceRedirect("${_path}/admin/user/edit?id=" + d.id);
						//savePortrait(d.id);
						//alert("handler~~");
						
						//$table.add_edit(d,i,"用户编辑");
						//$('#_editForm').validate();
						$table.dialog(d,i,"监测值编辑").validate();
					}},
					{text : '删除', clazz : 'red', icon : 'fa fa-trash-o', permission : '/admin/user/delete', handler : function(d, i){
						$table.ajaxDelete({
							confirm : "删除管理员会影响关联的应用、角色、权限，确认要删除?",
							url : "${_path}/admin/user/delete"
						});
					}}
				],
				after : function(){
					// 权限处理
					$.permission();
					
				}
			});
			
			
			
			//弹出层初始化
	        $('.modal.aside').ace_aside();
		
			$(document).one('ajaxloadstart.page', function(e) {
				//in ajax mode, remove before leaving page
				$('.modal.aside').remove();
				$(window).off('.aside');
			});
			
			//搜索
			$(".search-data").blur(function () { 
				$table.search();
			});
            
			// 取消
			$("#_cancel").click(function(){
				$table.search();
			});
		});
	});
</script>
