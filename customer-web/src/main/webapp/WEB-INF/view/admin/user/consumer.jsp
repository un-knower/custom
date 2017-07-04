<%@ page language="java" pageEncoding="utf-8"%>

<jsp:include page="../../common/common.jsp">
	<jsp:param name="title" value="应用"/>
</jsp:include>

<div class="page-header">
	<h1>
		应用列表
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
									<label class="control-label" for="form-field-1"> 手机号： </label>
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
<div class="row">
	<div class="col-xs-12">
		<ul id="_tree" class="ztree" style="width:560px; overflow:auto;"></ul>
	</div><!-- /.col -->
	
	<a id="my-modal-a" href="#my-modal" role="button" class="bigger-125 bg-primary white" style="display: none;" data-toggle="modal"></a>

	<div id="my-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">权限信息</h3>
				</div>

				<div class="modal-body">
					<form id="_editForm" class="form-horizontal" role="form"
						validate="true">
						<input type="hidden" id="_id" name="id">
						<input type="hidden" id="_parentId" name="parentId">
			
						<div class="form-group">
							<label for="_appId" class="col-sm-3 control-label no-padding-right"><span class="form-star">*</span>应用</label>
			
							<div class="col-sm-3">
								<select id="_appId" class="form-control help-validate"
									required="true">
									<c:forEach var="item" items="${appList}">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select>
								<input id="_hidden_appId" type="hidden" name="appId"/>
							</div>
						</div> 
						
						<div class="form-group">
							<label for="_name" class="col-sm-3 control-label no-padding-right"><span class="form-star">*</span>名称</label>
			
							<div class="col-sm-9">
								<div class="clearfix help-validate">
									<input id="_name" name="name" type="text" class="form-data col-xs-10 col-sm-5" placeholder="名称"
										required="true" maxlength="64"/>
								</div>
							</div>
							
						</div>
						
						<div class="form-group">
							<label for="_icon" class="col-sm-3 control-label no-padding-right">图标</label>
			
							<div class="col-sm-9">
								<div class="clearfix help-validate">
									<input id="_icon" name="icon" type="text" class="form-data col-xs-10 col-sm-5" placeholder="图标"
										maxlength="100"/>&nbsp;
									<i id="_icon_fa"></i>
								</div>
							</div>
							
						</div>
						
						<div class="form-group">
							<label for="_sort" class="col-sm-3 control-label no-padding-right"><span class="form-star">*</span>排序</label>
			
							<div class="col-sm-9">
								<div class="clearfix help-validate">
									<input id="_sort" name="sort" type="text" class="form-data col-xs-10 col-sm-5" placeholder="排序"
										required="true" vtype="integer" min="1" max="9999"/>
								</div>
							</div>
							
						</div>
					
						<div class="form-group">
							<label for="_url" class="col-sm-3 control-label no-padding-right"><span id="urlspan" class="form-star">*</span>URL</label>
			
							<div class="col-sm-9">
								<div class="clearfix help-validate">
									<input id="_url" name="url" type="text" class="form-data col-xs-10 col-sm-9" placeholder="URL"
										required="true" maxlength="64"/>
								</div>
							</div>
							
						</div>
						
						<div class="form-group">
							<label for="_isMenu" class="col-sm-3 control-label no-padding-right"><span class="form-star">*</span>是否菜单</label>
			
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix help-validate">
									<label class="line-height-1 blue">
										<input name="isMenu" value="true" type="radio" class="ace"/>
										<span class="lbl"> 是</span>
									</label>
									<label class="line-height-1 blue">
										<input name="isMenu" value="false" type="radio" class="ace"/>
										<span class="lbl"> 否</span>
									</label>
								</div>
							</div>
							
						</div>
						
						<div class="form-group">
							<label for="_isEnable" class="col-sm-3 control-label no-padding-right"><span class="form-star">*</span>是否启用</label>
			
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix help-validate">
									<label class="line-height-1 blue">
										<input name="isEnable" value="true" type="radio" class="ace"/>
										<span class="lbl"> 是</span>
									</label>
									<label class="line-height-1 blue">
										<input name="isEnable" value="false" type="radio" class="ace"/>
										<span class="lbl"> 否</span>
									</label>
								</div>
							</div>
							
						</div>
						
					</form>
				</div>

				<div class="modal-footer">
					<button id="_cancel" class="btn btn-sm btn-danger pull-right" data-dismiss="modal" type="reset" >
						<i class="ace-icon fa fa-times"></i>
						关闭
					</button>
					<button id="_submit" class="btn btn-sm btn-success pull-right" data-dismiss="modal"  data-loading-text="正在提交...">
						<i class="ace-icon fa fa-check"></i><!-- class="btn btn-sm btn-success pull-right" -->
						保存
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>
</div><!-- /.row -->
<script type="text/javascript">
	scripts.push(
			"${_staticPath}/custom/zTree/js/jquery.ztree.core-3.5.min.js?v=" + Math.random(),
			"${_staticPath}/custom/zTree/js/jquery.ztree.excheck-3.5.min.js?v=" + Math.random());
			
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			// 列表
    		var $table = $("#_table").table({
    			url : "${_path}/admin/user/list",
    			formId : "_form",
				tools : [
					{text : '新增', clazz : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/admin/user/edit', handler : function(){
						$.aceRedirect("${_path}/admin/user/edit");
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
			        {field:'id', hide : true},
			        
			        {field:'mobile', title:'电话(登陆账号)', align:'left'},
			        {field:'name', title:'姓名', mobileHide : true},
			        {field:'sex', title:'性别', mobileHide : true},
			        {field:'age', title:'年龄', mobileHide : true},
			        {field:'provinceId', title:'省ID', mobileHide : true},
			        {field:'cityId', title:'市ID', mobileHide : true},
			        {field:'areaId', title:'区ID', mobileHide : true},
			        {field:'address', title:'地址', mobileHide : true},
			        {field:'lng', title:'经度', mobileHide : true},
			        {field:'lat', title:'纬度', mobileHide : true},
			        {field:'userSortId', title:'用户分类', mobileHide : true},
			        {field:'portrait', title:'头像', replace : function (d){
			        	return	'<a id="updatePortrait_'+d.id+'" data-toggle="dropdown" href="javascript:void(0)" class="dropdown-toggle">'+
									'<img class="nav-user-photo" src="${_staticPath}'+d.portrait+'" alt="Jasons\' Photo" />'+
								'</a>';
			        }},
			        
			        {field:'status', title:'是否启用', replace : function (d){
				        if(d.status)
				        	return "<span class='label label-sm label-success'>" + d.status + 	"</span>";
			        	else
			        		return "<span class='label label-sm label-warning'>" + d.status + "</span>";
			        }},
			        {field:'createTime', title:'创建时间', mobileHide : true}
				],
				operate : [
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/admin/user/edit', handler : function(d, i){
						$.aceRedirect("${_path}/admin/user/edit?id=" + d.id);
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
			
			console.log("d:"+$table.options.data);
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
		});
	});
</script>
