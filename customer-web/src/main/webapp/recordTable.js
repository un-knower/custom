/*$(function(){
	
	bindEvent();
});
function bindEvent(){	
	$('#record').click(function(){
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#recordTablePage').siblings().hide();
		$('#recordTablePage').show();
		drawRecordTable();
	});
}*/
function drawRecordTable(){
	//$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			// 列表
    		var $table = $("#_table").table({
    			url : "${_path}/admin/user/list",
    			data:[{account:15828609056,loginCount:2,lastLoginIp:190,lastLoginTime:'2017.6.16',createTime:'2017.5.25'}],
    			formId : "_form",
				tools : [
					{text : '新增', 'class' : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/admin/user/edit', handler : function(){
						
					}},
					{text : '删除', clazz : 'btn-warning', icon : 'fa fa-lock orange', permission : '/admin/user/enable', handler : function(){
						
					}},
					{text : '修改', clazz : 'btn-info', icon : 'fa fa-lock orange', permission : '/admin/user/enable', handler : function(){
						
					}}
				],
				columns : [
			        {field:'id', hide : true},
			        {field:'isEnable', hide : true},
			        {field:'appId', hide : true},
			        {field:'account', title:'登录名', align:'left'},
			        {field:'loginCount', title:'登录总次数', mobileHide : true},
			        {field:'lastLoginIp', title:'最后登录IP', mobileHide : true},
			        {field:'lastLoginTime', title:'最后登录时间', mobileHide : true},
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
	//});
}