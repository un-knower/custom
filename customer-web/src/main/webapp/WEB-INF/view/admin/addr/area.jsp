<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../common/common.jsp">
	<jsp:param name="title" value="管理员"/>
</jsp:include>

<div class="page-header">
	<h1>
		区列表
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
									<label class="control-label" for="form-field-1"> 市编码： </label>
									<input name="cityCode" type="text" class="form-data input-medium search-data">
								</label> 
								<label >
									<label class="control-label" for="form-field-1"> 区编码： </label>
									<input name="code" type="text" class="form-data input-medium search-data">
								</label> 
							</form>
							<!-- PAGE CONTENT BEGINS -->
							<div>
								<form action="${_path}/admin/addr/insertBytxt" class="dropzone" id="dropzone">
									<div class="fallback">
										<input name="file" type="file" multiple="" />
									</div>
								</form>
							</div>
							<!-- PAGE CONTENT ENDS -->
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

<!-- page specific plugin scripts -->
<script type="text/javascript">
	scripts.push(
			"${_staticPath}/assets/js/dropzone.js?v="+ Math.random()
			);
	
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			// 列表
    		var $table = $("#_table").table({
    			url : "${_path}/admin/addr/listArea",
    			formId : "_form",
				tools : [
					{text : '新增', clazz : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/admin/user/edit', handler : function(){
						$.aceRedirect("${_path}/admin/user/edit");
					}},
					{text : '删除', clazz : 'btn-danger', icon : 'fa fa-trash-o red', permission : '/admin/user/delete', handler : function(){
						$table.ajaxDelete({
							confirm : "删除管理员会影响关联的应用、角色、权限，确认要删除?",
							url : "${_path}/admin/user/delete"
						});
					}}
				],
				columns : [
			        {field:'id', hide : true},
			        
			        {field:'code', title:'编码', mobileHide : true},
			        {field:'name', title:'名称', mobileHide : true},
			        {field:'cityCode', title:'市编码', mobileHide : true},
			        {field:'createTime', title:'创建时间', mobileHide : true}
				],
				operate : [
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/admin/user/edit', handler : function(d, i){
						$.aceRedirect("${_path}/admin/user/edit?id=" + d.id);
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
			
			
			/*$.getJSON("${_path}/admin/addr/listProvince",function(d) {
 				$.each(d,function(index,element){
 					$("#_pro").append("<option value='"+element.id+"'>"+element.name+"</option>");
 				});
			});*/
			/*//更新市下拉选择框
			function updateArea(proCode){
				$("#_area").empty();
				$.getJSON("${_path}/admin/addr/listArea?proCode="+proCode,function(d) {
	 				$.each(d,function(index,element){
	 					$("#_area").append("<option value='"+element.code+"'>"+element.name+"</option>");
	 				});
				});
				$("#_area").change(function(){
					updateArea($("#_area").val());
				});
			}
			//更新区下拉选择框
			function updateArea(areaCode){
				$("#_area").empty();
				$.getJSON("${_path}/admin/addr/listArea?areaCode="+areaCode,function(d) {
	 				$.each(d,function(index,element){
	 					$("#_area").append("<option value='"+element.code+"'>"+element.name+"</option>");
	 				});
				});
			}*/
			
			//搜索
			/* $("#_area").change(function(){
				$table.search();
			}); */
			$(".search-data").keyup(function () { 
				$table.search();
			});
            
			// 取消
			$("#_cancel").click(function(){
				$table.search();
			});
			//初始化省下拉选择框
			//$("#_pro").empty();
			/* $.getJSON("${_path}/admin/addr/listArea?pageNo=1&pageSize=20",function(d) {
 				$.each(d.data,function(index,element){
 					$("#_pro").append("<option value='"+element.id+"'>"+element.name+"</option>");
 				});
			}); */
			
			try {
				Dropzone.autoDiscover = false;
				var myDropzone = new Dropzone("#dropzone" , {
					paramName: "file", // The name that will be used to transfer the file
					maxFilesize: 0.5, // MB
					
					addRemoveLinks : true,
					dictDefaultMessage :
										'<span class="smaller-50 bolder"><i class="ace-icon fa fa-caret-right red"></i> 拖动</span> \
										<span class="smaller-50 grey">(或单击)</span> <br /> \
										<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-1x"></i> <br/> \
										<span class="smaller-50 grey">文本批量新增</span>'
									,
					dictResponseError: 'Error while uploading file!',
					
					//change the previewTemplate to use Bootstrap progress bars
					previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
					
					success:function(){
						$table.reload();
					}
				});
				
				$(document).one('ajaxloadstart.page', function(e) {
					try {
						myDropzone.destroy();
					} catch(e) {}
				});
				$("#dropzone").css("min-height","123px");
				$("#dropzone").css("border","0px solid rgba(0, 0, 0, 0.06)");
			} catch(e) {
			  	alert('Dropzone.js does not support older browsers!');
			}
		});
	});
</script>
