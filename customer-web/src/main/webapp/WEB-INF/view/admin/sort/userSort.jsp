<%@ page language="java" pageEncoding="utf-8"%>

<jsp:include page="../../common/common.jsp">
	<jsp:param name="title" value="应用"/>
</jsp:include>

<div class="page-header">
	<h1>
		用户分类列表
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
								<label>
									<label class="control-label" for="form-field-1"> 分类名称： </label>
									<input name="name" type="text" class="form-data input-medium search-data">
								</label>
								<!-- 
								<button id="_search" type="button" class="btn btn-info btn-sm">
									<i class="ace-icon fa fa-search bigger-110"></i>搜索
								</button>
								 -->
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

<script type="text/javascript">
	scripts.push(
			"${_staticPath}/custom/zTree/js/jquery.ztree.core-3.5.min.js?v=" + Math.random(),
			"${_staticPath}/custom/zTree/js/jquery.ztree.excheck-3.5.min.js?v=" + Math.random());
	
	var myScripts = [
		// 验证
		"${_staticPath}/custom/jquery.validate-2.0.min.js?v=" + Math.random(),
		"${_staticPath}/custom/jquery.validate-2.0.custom.min.js?v=" + Math.random()
	];	
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			
			// 列表
    		var $table = $("#_table").table({
    			url : "${_path}/admin/sort/listUserSort",
    			formId : "_form",
				tools : [
					{text : '新增', clazz : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/admin/user/edit', handler : function(){
						$table.dialog(null,null,"用户添加",{
							url:'${_path}/admin/sort/saveUserSort',
							type:'post',
							callback:function(d){
								$.gritter.add({
									text: d.message,
									sticky: false,
									time: '1000'
								});
							}
						},null);
						$('.page-content-area').ace_ajax('loadScripts', myScripts, function() {});
					}},
					{text : '禁用', clazz : 'btn-warning', icon : 'fa fa-lock orange', permission : '/admin/user/enable', handler : function(){
						$table.ajaxEnable({url : "${_path}/admin/user/enable"}, false);
					}},
					{text : '启用', clazz : 'btn-success', icon : 'fa fa-unlock green', permission : '/admin/user/enable', handler : function(){
						$table.ajaxEnable({url : "${_path}/admin/user/enable"}, true);
					}},
					{text : '删除', clazz : 'btn-danger', icon : 'fa fa-trash-o red', permission : '/admin/user/delete', handler : function(){
						$table.ajaxDelete({
							confirm : "删除管理员会影响关联的应用、角色、权限，确认要删除?",
							url : "${_path}/admin/user/delete"
						});
					}},
					{text : '重置密码', clazz : 'btn-default', icon : 'fa fa-key grey', permission : '/admin/user/resetPassword', handler : function(){
						$table.ajax({
							url : "${_path}/admin/user/resetPassword",
							confirm : "确认重置密码?",
							after : function(){
								$table.reload();
							}
						});
					}}/*,
					{text : '分配应用', clazz : 'btn-default', icon : 'fa fa-cog grey', permission : '/admin/userApp/allocate', handler : function(){
						if(!$table.validateSelected(true)){
							return;						
						}
						$.aceRedirect("${_path}/admin/userApp/allocate?userId=" + $table.getSelectedItemKeys("id"));
					}},
					{text : '分配角色', clazz : 'btn-default', icon : 'fa fa-cog grey', permission : '/admin/userApp/allocate', handler : function(){
						if(!$table.validateSelected(true)){
							return;						
						}
						$.aceRedirect("${_path}/admin/userRole/allocate?userId=" + $table.getSelectedItemKeys("id"));
					}}*/
				],
				columns : [
					{field:'rowkey',hide:true},
			        {field:'id', hide : true},
			        
			        {field:'sortName', title:'分类名称', mobileHide : true},
			        {field:'userId', title:'创建者ID', mobileHide : true},
			        {field:'createTime', title:'创建时间', mobileHide : true}
				],
				operate : [
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/admin/user/edit', handler : function(d, i){
						$table.dialog(d,i,"用户编辑").validate();
					}},
					{text : '禁用', clazz : 'orange', icon : 'fa fa-lock', permission : '/admin/user/enable', 
						handler : function(){
							$table.ajaxEnable({url : "${_path}/admin/user/enable"}, false);
						},
						show : function(d){
							return d.isEnable;
						}
					},
					{text : '启用', clazz : 'green', icon : 'fa fa-unlock', permission : '/admin/user/enable', 
						handler : function(){
							$table.ajaxEnable({url : "${_path}/admin/user/enable"}, true);
						},
						show : function(d){
							return !d.isEnable;
						}
					},
					{text : '删除', clazz : 'red', icon : 'fa fa-trash-o', permission : '/admin/user/delete', handler : function(d, i){
						$table.ajaxDelete({
							confirm : "删除管理员会影响关联的应用、角色、权限，确认要删除?",
							url : "${_path}/admin/user/delete"
						});
					}},
					{text : '重置密码', clazz : 'grey', icon : 'fa fa-key', permission : '/admin/user/resetPassword', handler : function(d, i){
						$table.ajax({
							url : "${_path}/admin/user/resetPassword",
							confirm : "确认重置密码?",
							after : function(){
								$table.reload();
							}
						});
					}},
					{text : '分配应用', clazz : 'grey', icon : 'fa fa-cog', permission : '/admin/userApp/allocate', handler : function(d, i){
						$.aceRedirect("${_path}/admin/userApp/allocate?userId=" + d.id);
					}},
					{text : '分配角色', clazz : 'grey', icon : 'fa fa-cog', permission : '/admin/userRole/allocate', handler : function(d, i){
						$.aceRedirect("${_path}/admin/userRole/allocate?userId=" + d.id);
					}}
				],
				after : function(){
					// 权限处理
					$.permission();
					
				}
			});
			/* $table.dialog(null,null,"用户添加");
			$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
				//弹出层初始化
		        $('.modal.aside').ace_aside();
			
				$(document).one('ajaxloadstart.page', function(e) {
					//in ajax mode, remove before leaving page
					$('.modal.aside').remove();
					$(window).off('.aside');
				});
				
				$("#table-dialog-modal-a").click();
				$("#_name").focus();
			}); */
			
			/*console.log("d:"+$table.options.data);
			var data=$table.options.data;
			$.each(data,function(index,element){
				var addBtn = $("#updatePortrait_" + element.id);
				if(addBtn){
					console.log("yes");
					addBtn.bind("click", function(){
						setForm(treeNode,'add');
						$("#my-modal-a").click();
						$("#_name").focus();
					});
				}
			});*/
			
			//点击保存按钮
			$("#_submit").click(function(){
				if($('#_editForm').validate()){
					/* var btn = $(this);
					btn.button('loading');
					$.post("${_path}/admin/permission/save", $.formJson('_editForm'),function(d) {
						if(d){
							btn.button('reset');
							$.gritter.add({
								text: d.message,
								sticky: false,
								time: '1000'
							});
							$("#_editForm")[0].reset();
							reloadTree();
						}else{
							//这里打印提示信息
							$.gritter.add({
								text: "服务器返回值空"+d.message,
								sticky: false,
								time: '1000'
							});
						}
			        },'json'); */
				}else{
					return false;
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
			$(".search-data").keyup(function () { 
				$table.search();
			});
			$("#_appId").change(function () { 
				$table.search();
           	});
            
			// 取消
			$("#_cancel").click(function(){
				$table.search();
			});
			
			//$("#my-modal-a").click();
		});
	});
</script>
