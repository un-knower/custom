$(function(){
	var _path = "http://192.168.10.201:8086/customer-web";
	bindEvent(_path);
	//drawTable();
});
function bindEvent(){	
	$('#project').click(function(){
		//alert('1');
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#projectTablePage').siblings().hide();
		$('#projectTablePage').show();
		drawProTable();
	});
	$('#device').click(function(){
		//alert('2');
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#tablePage').siblings().hide();
		$('#tablePage').show();
		drawTable();
	});
	$('#warn').click(function(){
		//alert('3');
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#warnTablePage').siblings().hide();
		$('#warnTablePage').show();
		drawWarnTable();
	});
	$('#user').click(function(){
		//alert('5');
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#userTablePage').siblings().hide();
		$('#userTablePage').show();
		drawUserTable();
	});
	$('#monitor').click(function(){
		//alert('6');
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#monitorPage').siblings().hide();
		$('#monitorPage').show();
	});
	$('#record').click(function(){
		alert('4');
		$('.nav-list li').removeClass('active');
		$(this).addClass('active');
		$('#recordTablePage').siblings().hide();
		$('#recordTablePage').show();
		drawRecordTable(_path);
	});
}
function drawTable(){
	var grid_data = 
		[ 
			{id:"1",name:"小蜻蜓",deviceNo:"001",note:"note",stock:"Yes",deviceId:"1",pId:'23',version:'0', sdate:"2007-12-03",addr:'青羊区大石东路','gps':'12,56'},
			{id:"2",name:"大蜻蜓",deviceNo:"002",note:"Long text ",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"3",name:"小蜻蜓",deviceNo:"003",note:"note3",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"4",name:"大蜻蜓",deviceNo:"003",note:"note",stock:"No",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"5",name:"小蜻蜓",deviceNo:"005",note:"note2",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"6",name:"大蜻蜓",deviceNo:"006",note:"note3",stock:"No", deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"7",name:"小蜻蜓",deviceNo:"007",note:"note",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"8",name:"大蜻蜓",deviceNo:"008",note:"note2",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"9",name:"小蜻蜓",deviceNo:"009",note:"note3",stock:"No", deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"10",name:"大蜻蜓",deviceNo:"010",note:"note",stock:"Yes",deviceId:"1",pId:'23',version:'0', sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"11",name:"小蜻蜓",deviceNo:"001",note:"Long text ",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"12",name:"大蜻蜓",deviceNo:"001",note:"note3",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"13",name:"小蜻蜓",deviceNo:"001",note:"note",stock:"No",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"14",name:"大蜻蜓",deviceNo:"001",note:"note2",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"15",name:"小蜻蜓",deviceNo:"001",note:"note3",stock:"No", deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"16",name:"大蜻蜓",deviceNo:"001",note:"note",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"17",name:"小蜻蜓",deviceNo:"001",note:"note2",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"18",name:"大蜻蜓",deviceNo:"001",note:"note3",stock:"No",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"19",name:"小蜻蜓",deviceNo:"001",note:"note3",stock:"No",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"20",name:"大蜻蜓",deviceNo:"001",note:"note",stock:"Yes",deviceId:"1",pId:'23',version:'0', sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"21",name:"小蜻蜓",deviceNo:"001",note:"Long text ",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"22",name:"大蜻蜓",deviceNo:"001",note:"note3",stock:"Yes",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'},
			{id:"23",name:"小蜻蜓",deviceNo:"001",note:"note",stock:"No",deviceId:"1",pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路'}
		];	
		
		jQuery(function($) {
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";
		
			jQuery(grid_selector).jqGrid({
				data: grid_data,
		        datatype:"local", //数据来源，本地数据
		        //mtype:"POST",//提交方式
		        height:'auto',//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        colNames:['ID','时间','设备名字', '设备是否开放', '设备编号','备注','设备分类ID','项目ID','数据版本','地址','Gps',],
				colModel:[					
					{name:'id',index:'id', width:60, sorttype:"int", editable: true,sortable:true,align: "center"},
					{name:'sdate',index:'sdate',width:90, editable:true,sortable:true, sorttype:"date",unformat: pickDate,align: "center"},
					{name:'name',index:'name', width:90,editable: true,editoptions:{size:"20",maxlength:"30"},align: "center"},
					{name:'stock',index:'stock', width:100, editable: true,edittype:"checkbox",editoptions: {value:"Yes:No"},unformat: aceSwitch,align: "center"},
					{name:'deviceNo',index:'deviceNo', width:90, editable: true,align: "center"},
					{name:'note',index:'note', width:150, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"1",cols:"10"},align: "center"},
					{name:'deviceId',index:'deviceId', width:80, sortable:true,editable: true,align: "center"},
					{name:'pId',index:'pId', width:80, sortable:true,editable: true,align: "center"},
					{name:'version',index:'version', width:80, sortable:false,editable: true,align: "center"},
					{name:'addr',index:'addr', width:150, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"1",cols:"10"},align: "center"},
					{name:'gps',index:'gps', width:150,editable: true,edittype:"button",editoptions: {value:"点击获取GPS",align: "center",dataEvents: 
					[{type:'click',align: "center",fn:function(e){
						getGps();
					}}]}},
					/*{name:'myac',index:'myac', width:80, fixed:true, sortable:false, resize:false,
						formatter:'actions', 
						formatoptions:{ 
							keys:true,							
							delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
							editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
						}
					},*/
				], 
		        //rownumbers:true,//添加左侧行号
		        viewrecords: true,//是否在浏览导航栏显示记录总数
		        rowNum:15,//每页显示记录数
		        rowList:[15,20,25],//用于改变显示行数的下拉列表框的元素数组。
		        multiselect : true,
		        multiboxonly: true,
		        jsonReader:{
		            id: "blackId",//设置返回参数中，表格ID的名字为blackId
		            repeatitems : false
		        },
		        pager : pager_selector,
				loadComplete : function() {
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
						//if($('#gps').focus()){alert('err');}
					}, 0);
				},
		
				//editurl: path_base+"/dummy.html",//nothing is saved
				caption: "设备管理表",			
				autowidth: true,
				afterComplete :function(){//执行完 add  edit后触发的回调函数
					
				},
				gridComplete: function(){
					              $('#list').closest("div.ui-jqgrid-view")
					                 .children("div.ui-jqgrid-titlebar")
					                 .css("text-align", "center")
					                 .children("span.ui-jqgrid-title")
					                .css("float", "none");
					       }
			});				
			//设备是否开放栏编辑（选择框）
			function aceSwitch( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=checkbox]')
							.wrap('<label class="inline" />')
						.addClass('ace ace-switch ace-switch-5')
						.after('<span class="lbl"></span>');
				}, 0);
			}
			//日期选择
			function pickDate( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
				}, 0);
			}
			//百度地图
			function getGps(){
				//alert('我是');
				window.open(_path+"/admin/mapGps");  
			}
			//navButtons
			jQuery(grid_selector).jqGrid('navGrid',pager_selector,
				{ 	//navbar options
					edit: true,
					editicon : 'icon-pencil blue',
					add: true,
					addicon : 'icon-plus-sign purple',
					del: true,
					delicon : 'icon-trash red',
					search: true,
					searchicon : 'icon-search orange',
					refresh: true,
					refreshicon : 'icon-refresh green',
					view: true,
					viewicon : 'icon-zoom-in grey',
				},
				{
					//edit record form
					//closeAfterEdit: true,
					top:120,
					left:700,
					width:600,
					//height:auto,
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//new record form
					top:120,
					left:700,
					width:600,
					closeAfterAdd: true,
					recreateForm: true,
					viewPagerButtons: false,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//delete record form
					top:250,
					left:880,
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						if(form.data('styled')) return false;
						
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_delete_form(form);
						
						form.data('styled', true);
					},
					onClick : function(e) {
						alert(1);
					}
				},
				{
					//search form
					top:250,
					left:800,
					recreateForm: true,
					afterShowSearch: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						style_search_form(form);
					},
					afterRedraw: function(){
						style_search_filters($(this));
					}
					,
					multipleSearch: true,
					/**
					multipleGroup:true,
					showQuery: true
					*/
				},
				{
					//view record form
					top:120,
					left:750,
					//width:600,
					recreateForm: true,
					beforeShowForm: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
					}
				}
			)
		
		
			
			function style_edit_form(form) {
				//enable datepicker on "sdate" field and switches for "stock" field
				form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					.end().find('input[name=stock]')
						  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
		
				//update buttons classes
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
				
				buttons = form.next().find('.navButton a');
				buttons.find('.ui-icon').remove();
				buttons.eq(0).append('<i class="icon-chevron-left"></i>');
				buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
			}
		
			function style_delete_form(form) {
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
			}
			
			function style_search_filters(form) {
				form.find('.delete-rule').val('X');
				form.find('.add-rule').addClass('btn btn-xs btn-primary');
				form.find('.add-group').addClass('btn btn-xs btn-success');
				form.find('.delete-group').addClass('btn btn-xs btn-danger');
			}
			function style_search_form(form) {
				var dialog = form.closest('.ui-jqdialog');
				var buttons = dialog.find('.EditTable')
				buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
				buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
				buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
			}
			
			function beforeDeleteCallback(e) {
				var form = $(e[0]);
				if(form.data('styled')) return false;
				
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_delete_form(form);
				
				form.data('styled', true);
				console.log('2');
			}
			
			function beforeEditCallback(e) {
				var form = $(e[0]);
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_edit_form(form);
			}
						
			//it causes some flicker when reloading or navigating grid
			//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
			//or go back to default browser checkbox styles for the grid
			function styleCheckbox(table) {
			/**
				$(table).find('input:checkbox').addClass('ace')
				.wrap('<label />')
				.after('<span class="lbl align-top" />')
		
		
				$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
				.find('input.cbox[type=checkbox]').addClass('ace')
				.wrap('<label />').after('<span class="lbl align-top" />');
			*/
			}
			
		
			//unlike navButtons icons, action icons in rows seem to be hard-coded
			//you can change them like this in here if you want
			function updateActionIcons(table) {
				/**
				var replacement = 
				{
					'ui-icon-pencil' : 'icon-pencil blue',
					'ui-icon-trash' : 'icon-trash red',
					'ui-icon-disk' : 'icon-ok green',
					'ui-icon-cancel' : 'icon-remove red'
				};
				$(table).find('.ui-pg-div span.ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
				*/
			}
			
			//replace icons with FontAwesome icons like above
			function updatePagerIcons(table) {
				var replacement = 
				{
					'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
					'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
					'ui-icon-seek-next' : 'icon-angle-right bigger-140',
					'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
				};
				$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
			}
		
			function enableTooltips(table) {
				$('.navtable .ui-pg-button').tooltip({container:'body'});
				$(table).find('.ui-pg-div').tooltip({container:'body'});
			}

		});
}
function drawWarnTable(){
	var grid_data = 
		[ 
			{id:"1",warnId:"888",warnSort:"报警",deviceId:"001",version:'0', sdate:"2007-12-03"},
			{id:"2",warnId:"888",warnSort:"报警",deviceId:"002",version:'0',sdate:"2007-12-03"},
			{id:"3",warnId:"888",warnSort:"报警",deviceId:"003",version:'0',sdate:"2007-12-03"},
			{id:"4",warnId:"888",warnSort:"报警",deviceId:"003",version:'0',sdate:"2007-12-03"},
			{id:"5",warnId:"888",warnSort:"报警",deviceId:"005",version:'0',sdate:"2007-12-03"},
			{id:"6",warnId:"888",warnSort:"报警",deviceId:"006",version:'0',sdate:"2007-12-03"},
			{id:"7",warnId:"888",warnSort:"报警",deviceId:"007",version:'0',sdate:"2007-12-03"},
			{id:"8",warnId:"888",warnSort:"报警",deviceId:"008",version:'0',sdate:"2007-12-03"}
		];	
		
		jQuery(function($) {
			var grid_selector = "#warn-table";
			var pager_selector = "#warn-pager";
		
			jQuery(grid_selector).jqGrid({
				//direction: "rtl",				
				data: grid_data,
				datatype: "local",
				height: 250,
				shrinkToFit:false,
				autoScroll:true,
				colNames:[' ', 'ID','预警分类Id','预警名称', '设备Id', '创建时间','数据版本'],
				colModel:[
					{name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
						formatter:'actions', 
						formatoptions:{ 
							keys:true,							
							delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
							//editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
						}
					},
					{name:'id',index:'id', width:60, sorttype:"int", editable: true},
					{name:'sdate',index:'sdate',width:90, editable:true, sorttype:"date",unformat: pickDate},
					{name:'warnSort',index:'warnSort', width:90,editable: true},
					{name:'deviceId',index:'deviceId', width:90, editable: true},
					{name:'version',index:'version', width:150, sortable:false,editable: true},
					{name:'warnId',index:'warnId', width:150, sortable:false,editable: true}
				], 		
				viewrecords : true,
				rowNum:10,
				rowList:[10,20,30],
				pager : pager_selector,
				altRows: true,
				//toppager: true,
				
				multiselect: true,
				//multikey: "ctrlKey",
		        multiboxonly: true,
		
				loadComplete : function() {
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
		
				editurl: $path_base+"/dummy.html",//nothing is saved
				caption: "预警管理表",			
				autowidth: true,
				afterComplete :function(){//执行完 add  edit后触发的回调函数
					
				}
			});				
			//设备是否开放栏编辑（选择框）
			function aceSwitch( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=checkbox]')
							.wrap('<label class="inline" />')
						.addClass('ace ace-switch ace-switch-5')
						.after('<span class="lbl"></span>');
				}, 0);
			}
			//日期选择
			function pickDate( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
				}, 0);
			}
		
		
			//navButtons
			jQuery(grid_selector).jqGrid('navGrid',pager_selector,
				{ 	//navbar options
					edit: true,
					editicon : 'icon-pencil blue',
					add: true,
					addicon : 'icon-plus-sign purple',
					del: true,
					delicon : 'icon-trash red',
					search: true,
					searchicon : 'icon-search orange',
					refresh: true,
					refreshicon : 'icon-refresh green',
					view: true,
					viewicon : 'icon-zoom-in grey',
				},
				{
					//edit record form
					//closeAfterEdit: true,
					top:10,
					left:200,
					width:1000,
					height:750,
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//new record form
					closeAfterAdd: true,
					recreateForm: true,
					viewPagerButtons: false,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//delete record form
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						if(form.data('styled')) return false;
						
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_delete_form(form);
						
						form.data('styled', true);
					},
					onClick : function(e) {
						alert(1);
					}
				},
				{
					//search form
					recreateForm: true,
					afterShowSearch: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						style_search_form(form);
					},
					afterRedraw: function(){
						style_search_filters($(this));
					}
					,
					multipleSearch: true,
					/**
					multipleGroup:true,
					showQuery: true
					*/
				},
				{
					//view record form
					recreateForm: true,
					beforeShowForm: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
					}
				}
			)
		
		
			
			function style_edit_form(form) {
				//enable datepicker on "sdate" field and switches for "stock" field
				form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					.end().find('input[name=stock]')
						  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
		
				//update buttons classes
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
				
				buttons = form.next().find('.navButton a');
				buttons.find('.ui-icon').remove();
				buttons.eq(0).append('<i class="icon-chevron-left"></i>');
				buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
			}
		
			function style_delete_form(form) {
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
			}
			
			function style_search_filters(form) {
				form.find('.delete-rule').val('X');
				form.find('.add-rule').addClass('btn btn-xs btn-primary');
				form.find('.add-group').addClass('btn btn-xs btn-success');
				form.find('.delete-group').addClass('btn btn-xs btn-danger');
			}
			function style_search_form(form) {
				var dialog = form.closest('.ui-jqdialog');
				var buttons = dialog.find('.EditTable')
				buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
				buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
				buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
			}
			
			function beforeDeleteCallback(e) {
				var form = $(e[0]);
				if(form.data('styled')) return false;
				
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_delete_form(form);
				
				form.data('styled', true);
			}
			
			function beforeEditCallback(e) {
				var form = $(e[0]);
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_edit_form(form);
			}
						
			//it causes some flicker when reloading or navigating grid
			//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
			//or go back to default browser checkbox styles for the grid
			function styleCheckbox(table) {
			/**
				$(table).find('input:checkbox').addClass('ace')
				.wrap('<label />')
				.after('<span class="lbl align-top" />')
		
		
				$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
				.find('input.cbox[type=checkbox]').addClass('ace')
				.wrap('<label />').after('<span class="lbl align-top" />');
			*/
			}
			
		
			//unlike navButtons icons, action icons in rows seem to be hard-coded
			//you can change them like this in here if you want
			function updateActionIcons(table) {
				/**
				var replacement = 
				{
					'ui-icon-pencil' : 'icon-pencil blue',
					'ui-icon-trash' : 'icon-trash red',
					'ui-icon-disk' : 'icon-ok green',
					'ui-icon-cancel' : 'icon-remove red'
				};
				$(table).find('.ui-pg-div span.ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
				*/
			}
			
			//replace icons with FontAwesome icons like above
			function updatePagerIcons(table) {
				var replacement = 
				{
					'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
					'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
					'ui-icon-seek-next' : 'icon-angle-right bigger-140',
					'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
				};
				$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
			}
		
			function enableTooltips(table) {
				$('.navtable .ui-pg-button').tooltip({container:'body'});
				$(table).find('.ui-pg-div').tooltip({container:'body'});
			}

		});

}
function drawProTable(){
	var grid_data = 
		[ 
			{id:"1",name:"净水机1",projectNo:"001",note:"note",num:"1",projectSortId:"3",
projectSortName:'公司',pId:'23',version:'0', sdate:"2007-12-03",addr:'青羊区大石东路',
userId:'56',comboId:'5'},
			{id:"2",name:"净水机2",projectNo:"002",note:"Long",num:"2",projectSortId:"4",
projectSortName:'公司',pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路',
userId:'56',comboId:'5'},
			{id:"3",name:"净水机3",projectNo:"003",note:"note3",num:"3",projectSortId:"5",
projectSortName:'公司',pId:'23',version:'0',sdate:"2007-12-03",addr:'青羊区大石东路',
userId:'56',comboId:'5'}
		];	
		
		jQuery(function($) {
			var grid_selector = "#pro-table";
			var pager_selector = "#pro-pager";
		
			jQuery(grid_selector).jqGrid({
				//direction: "rtl",				
				data: grid_data,
				datatype: "local",
				height: 250,
				shrinkToFit:false,
				autoScroll:true,
				colNames:[' ', 'ID','项目名称','项目Id', '备注', '数量','项目分类Id','项目分类名称','设备Id',
				          '数据版本','更新时间','地址','用户Id','套餐Id'],
				colModel:[
					{name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
						formatter:'actions', 
						formatoptions:{ 
							keys:true,							
							delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
							//editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
						}
					},
					{name:'id',index:'id', width:60, sorttype:"int", editable: true},
					{name:'name',index:'name',width:150, editable:true, sorttype:"date",unformat: pickDate},
					{name:'projectNo',index:'projectNo', width:150,editable: true},
					{name:'note',index:'note', width:90, editable: true},
					{name:'num',index:'num', width:150, sortable:false,editable: true},
					{name:'projectSortId',index:'projectSortId', width:150, sortable:false,editable: true},
					{name:'projectSortName',index:'projectSortName', width:150, sortable:false,editable: true},
					{name:'pId',index:'pId', width:150, sortable:false,editable: true},
					{name:'version',index:'version', width:150, sortable:false,editable: true},
					{name:'sdate',index:'sdate', width:150, sortable:false,editable: true},
					{name:'addr',index:'addr', width:250, sortable:false,editable: true},
					{name:'userId',index:'userId', width:150, sortable:false,editable: true},
					{name:'comboId',index:'comboId', width:150, sortable:false,editable: true},
				], 		
				viewrecords : true,
				rowNum:10,
				rowList:[10,20,30],
				pager : pager_selector,
				altRows: true,
				//toppager: true,
				
				multiselect: true,
				//multikey: "ctrlKey",
		        multiboxonly: true,
		
				loadComplete : function() {
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
		
				editurl: $path_base+"/dummy.html",//nothing is saved
				caption: "预警管理表",			
				autowidth: true,
				afterComplete :function(){//执行完 add  edit后触发的回调函数
					
				}
			});				
			//设备是否开放栏编辑（选择框）
			function aceSwitch( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=checkbox]')
							.wrap('<label class="inline" />')
						.addClass('ace ace-switch ace-switch-5')
						.after('<span class="lbl"></span>');
				}, 0);
			}
			//日期选择
			function pickDate( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
				}, 0);
			}
		
		
			//navButtons
			jQuery(grid_selector).jqGrid('navGrid',pager_selector,
				{ 	//navbar options
					edit: true,
					editicon : 'icon-pencil blue',
					add: true,
					addicon : 'icon-plus-sign purple',
					del: true,
					delicon : 'icon-trash red',
					search: true,
					searchicon : 'icon-search orange',
					refresh: true,
					refreshicon : 'icon-refresh green',
					view: true,
					viewicon : 'icon-zoom-in grey',
				},
				{
					//edit record form
					//closeAfterEdit: true,
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//new record form
					closeAfterAdd: true,
					recreateForm: true,
					viewPagerButtons: false,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//delete record form
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						if(form.data('styled')) return false;
						
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_delete_form(form);
						
						form.data('styled', true);
					},
					onClick : function(e) {
						alert(1);
					}
				},
				{
					//search form
					recreateForm: true,
					afterShowSearch: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						style_search_form(form);
					},
					afterRedraw: function(){
						style_search_filters($(this));
					}
					,
					multipleSearch: true,
					/**
					multipleGroup:true,
					showQuery: true
					*/
				},
				{
					//view record form
					recreateForm: true,
					beforeShowForm: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
					}
				}
			)							
			function style_edit_form(form) {
				//enable datepicker on "sdate" field and switches for "stock" field
				form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					.end().find('input[name=stock]')
						  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
		
				//update buttons classes
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
				
				buttons = form.next().find('.navButton a');
				buttons.find('.ui-icon').remove();
				buttons.eq(0).append('<i class="icon-chevron-left"></i>');
				buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
			}
		
			function style_delete_form(form) {
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
			}
			
			function style_search_filters(form) {
				form.find('.delete-rule').val('X');
				form.find('.add-rule').addClass('btn btn-xs btn-primary');
				form.find('.add-group').addClass('btn btn-xs btn-success');
				form.find('.delete-group').addClass('btn btn-xs btn-danger');
			}
			function style_search_form(form) {
				var dialog = form.closest('.ui-jqdialog');
				var buttons = dialog.find('.EditTable')
				buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
				buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
				buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
			}
			
			function beforeDeleteCallback(e) {
				var form = $(e[0]);
				if(form.data('styled')) return false;
				
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_delete_form(form);
				
				form.data('styled', true);
			}
			
			function beforeEditCallback(e) {
				var form = $(e[0]);
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_edit_form(form);
			}
						
			//it causes some flicker when reloading or navigating grid
			//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
			//or go back to default browser checkbox styles for the grid
			function styleCheckbox(table) {
			/**
				$(table).find('input:checkbox').addClass('ace')
				.wrap('<label />')
				.after('<span class="lbl align-top" />')
		
		
				$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
				.find('input.cbox[type=checkbox]').addClass('ace')
				.wrap('<label />').after('<span class="lbl align-top" />');
			*/
			}
			
		
			//unlike navButtons icons, action icons in rows seem to be hard-coded
			//you can change them like this in here if you want
			function updateActionIcons(table) {
				/**
				var replacement = 
				{
					'ui-icon-pencil' : 'icon-pencil blue',
					'ui-icon-trash' : 'icon-trash red',
					'ui-icon-disk' : 'icon-ok green',
					'ui-icon-cancel' : 'icon-remove red'
				};
				$(table).find('.ui-pg-div span.ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
				*/
			}
			
			//replace icons with FontAwesome icons like above
			function updatePagerIcons(table) {
				var replacement = 
				{
					'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
					'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
					'ui-icon-seek-next' : 'icon-angle-right bigger-140',
					'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
				};
				$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
			}
		
			function enableTooltips(table) {
				$('.navtable .ui-pg-button').tooltip({container:'body'});
				$(table).find('.ui-pg-div').tooltip({container:'body'});
			}

		});
}
function drawUserTable(){

	var grid_data = 
		[ 
			{id:"1",name:"张三",sex:"男",userSortId:"3",
			version:'0', sdate:"2007-12-03",addr:'青羊区大石东路',
			userId:'56'},
						{id:"2",name:"张三",sex:"女",userSortId:"4",
			version:'0',sdate:"2007-12-03",addr:'青羊区大石东路',
			userId:'56'},
						{id:"3",name:"张三",sex:"男",userSortId:"5",
			version:'0',sdate:"2007-12-03",addr:'青羊区大石东路',
			userId:'56'}
					];	
		
		jQuery(function($) {
			var grid_selector = "#user-table";
			var pager_selector = "#user-pager";
		
			jQuery(grid_selector).jqGrid({
				//direction: "rtl",				
				data: grid_data,
				datatype: "local",
				height: 250,
				shrinkToFit:false,
				autoScroll:true,
				colNames:[' ', 'ID','姓名','性别', '用户分类','数据版本','创建时间','地址'],
				colModel:[
					{name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
						formatter:'actions', 
						formatoptions:{ 
							keys:true,							
							delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
							//editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
						}
					},
					{name:'id',index:'id', width:60, sorttype:"int", editable: true},
					{name:'name',index:'name',width:150, editable:true, sorttype:"date",unformat: pickDate},
					{name:'sex',index:'sex', width:150,editable: true},
					{name:'userSortId',index:'userSortId', width:150, sortable:false,editable: true},
					{name:'version',index:'version', width:150, sortable:false,editable: true},
					{name:'sdate',index:'sdate', width:150, sortable:false,editable: true},
					{name:'addr',index:'addr', width:250, sortable:false,editable: true}
				], 		
				viewrecords : true,
				rowNum:10,
				rowList:[10,20,30],
				pager : pager_selector,
				altRows: true,
				//toppager: true,
				
				multiselect: true,
				//multikey: "ctrlKey",
		        multiboxonly: true,
		
				loadComplete : function() {
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
		
				editurl: $path_base+"/dummy.html",//nothing is saved
				caption: "预警管理表",			
				autowidth: true,
				afterComplete :function(){//执行完 add  edit后触发的回调函数
					
				}
			});				
			//设备是否开放栏编辑（选择框）
			function aceSwitch( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=checkbox]')
							.wrap('<label class="inline" />')
						.addClass('ace ace-switch ace-switch-5')
						.after('<span class="lbl"></span>');
				}, 0);
			}
			//日期选择
			function pickDate( cellvalue, options, cell ) {
				setTimeout(function(){
					$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
				}, 0);
			}
		
		
			//navButtons
			jQuery(grid_selector).jqGrid('navGrid',pager_selector,
				{ 	//navbar options
					edit: true,
					editicon : 'icon-pencil blue',
					add: true,
					addicon : 'icon-plus-sign purple',
					del: true,
					delicon : 'icon-trash red',
					search: true,
					searchicon : 'icon-search orange',
					refresh: true,
					refreshicon : 'icon-refresh green',
					view: true,
					viewicon : 'icon-zoom-in grey',
				},
				{
					//edit record form
					//closeAfterEdit: true,
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//new record form
					closeAfterAdd: true,
					recreateForm: true,
					viewPagerButtons: false,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//delete record form
					recreateForm: true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						if(form.data('styled')) return false;
						
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_delete_form(form);
						
						form.data('styled', true);
					},
					onClick : function(e) {
						alert(1);
					}
				},
				{
					//search form
					recreateForm: true,
					afterShowSearch: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						style_search_form(form);
					},
					afterRedraw: function(){
						style_search_filters($(this));
					}
					,
					multipleSearch: true,
					/**
					multipleGroup:true,
					showQuery: true
					*/
				},
				{
					//view record form
					recreateForm: true,
					beforeShowForm: function(e){
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
					}
				}
			)							
			function style_edit_form(form) {
				//enable datepicker on "sdate" field and switches for "stock" field
				form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					.end().find('input[name=stock]')
						  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
		
				//update buttons classes
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
				
				buttons = form.next().find('.navButton a');
				buttons.find('.ui-icon').remove();
				buttons.eq(0).append('<i class="icon-chevron-left"></i>');
				buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
			}
		
			function style_delete_form(form) {
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
				buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
				buttons.eq(1).prepend('<i class="icon-remove"></i>')
			}
			
			function style_search_filters(form) {
				form.find('.delete-rule').val('X');
				form.find('.add-rule').addClass('btn btn-xs btn-primary');
				form.find('.add-group').addClass('btn btn-xs btn-success');
				form.find('.delete-group').addClass('btn btn-xs btn-danger');
			}
			function style_search_form(form) {
				var dialog = form.closest('.ui-jqdialog');
				var buttons = dialog.find('.EditTable')
				buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
				buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
				buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
			}
			
			function beforeDeleteCallback(e) {
				var form = $(e[0]);
				if(form.data('styled')) return false;
				
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_delete_form(form);
				
				form.data('styled', true);
			}
			
			function beforeEditCallback(e) {
				var form = $(e[0]);
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				style_edit_form(form);
			}
						
			//it causes some flicker when reloading or navigating grid
			//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
			//or go back to default browser checkbox styles for the grid
			function styleCheckbox(table) {
			/**
				$(table).find('input:checkbox').addClass('ace')
				.wrap('<label />')
				.after('<span class="lbl align-top" />')
		
		
				$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
				.find('input.cbox[type=checkbox]').addClass('ace')
				.wrap('<label />').after('<span class="lbl align-top" />');
			*/
			}
			
		
			//unlike navButtons icons, action icons in rows seem to be hard-coded
			//you can change them like this in here if you want
			function updateActionIcons(table) {
				/**
				var replacement = 
				{
					'ui-icon-pencil' : 'icon-pencil blue',
					'ui-icon-trash' : 'icon-trash red',
					'ui-icon-disk' : 'icon-ok green',
					'ui-icon-cancel' : 'icon-remove red'
				};
				$(table).find('.ui-pg-div span.ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
				*/
			}
			
			//replace icons with FontAwesome icons like above
			function updatePagerIcons(table) {
				var replacement = 
				{
					'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
					'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
					'ui-icon-seek-next' : 'icon-angle-right bigger-140',
					'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
				};
				$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
					var icon = $(this);
					var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
					
					if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
				})
			}
		
			function enableTooltips(table) {
				$('.navtable .ui-pg-button').tooltip({container:'body'});
				$(table).find('.ui-pg-div').tooltip({container:'body'});
			}

		});

}
function drawRecordTable(){
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			// 列表
    		var $table = $("#_table").table({
    			//url :_path+"/admin/user/list",
    			url:'http://192.168.10.20:8080/smart-sso-server/admin/user/list',
    			//data:[{account:15828609056,loginCount:2,lastLoginIp:190,lastLoginTime:'2017.6.16',createTime:'2017.5.25'}],
    			formId : "_form",
				tools : [
					{text : '新增', 'class' : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/admin/user/edit', handler : function(){
						
					}},
					{text : '删除', clazz : 'btn-danger', icon : 'fa fa-trash-o red', permission : '/admin/user/enable', handler : function(){
						
					}},
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/admin/user/enable', handler : function(){
						
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
					{text : '删除', clazz : 'red', icon : 'fa fa-trash-o', permission : '/admin/user/delete', handler : function(d, i){
						$table.ajaxDelete({					
							url : "${_path}/admin/user/delete"
						});
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
	});
}