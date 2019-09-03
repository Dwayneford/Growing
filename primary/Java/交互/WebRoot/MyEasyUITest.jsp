<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Aligning Columns in DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>数据表格</h2>
	<p>数据库数据表</p>
	<div style="margin:20px 0;"></div>
	
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
			data-options="singleSelect:true,
			collapsible:true,
			url:'websitesSerevlet',
			method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80">ID</th>
				<th data-options="field:'name',width:100">名字</th>
				<th data-options="field:'url',width:300">url</th>
				<th data-options="field:'alexa',width:80,align:'right'">alexa</th>
				<th data-options="field:'country',width:60,align:'center'">country</th>			
			</tr>
		</thead>
	</table>

</body>
<body>
	<h2>Context Menu on DataGrid</h2>
	<p>Right click on the header of DataGrid to display context menu.</p>
	<div style="margin:20px 0;"></div>
	<table id="dg"></table>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
				url: 'datagrid_data1.json',
				method: 'get',
				title: 'Context Menu on DataGrid',
				iconCls: 'icon-save',
				width: 700,
				height: 250,
				fitColumns: true,
				singleSelect: true,
				columns:[[
					{field:'itemid',title:'Item ID',width:80},
					{field:'productid',title:'Product ID',width:120},
					{field:'listprice',title:'List Price',width:80,align:'right'},
					{field:'unitcost',title:'Unit Cost',width:80,align:'right'},
					{field:'attr1',title:'Attribute',width:250},
					{field:'status',title:'Status',width:60,align:'center'}
				]],
				onHeaderContextMenu: function(e, field){
					e.preventDefault();
					if (!cmenu){
						createColumnMenu();
					}
					cmenu.menu('show', {
						left:e.pageX,
						top:e.pageY
					});
				}
			});
		});
		var cmenu;
		function createColumnMenu(){
			cmenu = $('<div/>').appendTo('body');
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						$('#dg').datagrid('hideColumn', item.name);
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-empty'
						});
					} else {
						$('#dg').datagrid('showColumn', item.name);
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-ok'
						});
					}
				}
			});
			var fields = $('#dg').datagrid('getColumnFields');
			for(var i=0; i<fields.length; i++){
				var field = fields[i];
				var col = $('#dg').datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
	</script>
</body>
	<br>
	<hr>
	<br>
<body>
	<h2>数据表格</h2>
	<p>json数据表</p>
	<div style="margin:20px 0;"></div>
	
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
			data-options="singleSelect:true,
			collapsible:true,
			url:'datagrid_data1.json',
			method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">产品ID</th>
				<th data-options="field:'productname',width:100">产品名字</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>				
				<th data-options="field:'attr1',width:150">Attribute</th>				

			</tr>
		</thead>
	</table>

</body>
<br>
<br>
<br>
<br>
<br>
	<body>
		
		
	<!--// 注册框*****************************-->	
		<h2>欢迎您注册</h2>
	<p>在您提交前不会生效</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="注册框" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="name" style="width:100%" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="email" style="width:100%" data-options="label:'Email:',required:true,validType:'email'">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="subject" style="width:100%" data-options="label:'Subject:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="message" style="width:100%;height:60px" data-options="label:'Message:',multiline:true">
			</div>
			<div style="margin-bottom:20px">
				<select class="easyui-combobox" name="language" label="Language" style="width:100%">
					<option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">中文繁体</option>
					<option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option>
					<option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option>
					<option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option>
					<option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option>
					<option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option>
					<option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option>
					<option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option>
					<option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option>
					<option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
		<!--//注册框*****************************-->	
		<!--//提示收缩框*****************************-->	
		<h2>信息</h2>
	<p>存放文本</p>
	<div style="margin:20px 0 10px 0;">
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">打开</a>
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">收起</a>
	</div>
	<div id="p" class="easyui-panel" title="Basic Panel" style="width:700px;height:200px;padding:10px;">
		<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
		<ul>
			<li>easyUI是一个基于jQuery的用于界面交互的框架</li>
			<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
			<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
			<li>complete framework for HTML5 web page.</li>
			<li>easyui save your time and scales while developing your products.</li>
			<li>easyui is very easy but powerful.</li>
		</ul>
	</div>
	<!--//提示收缩框*****************************-->
	
	
	
	<h2>SideMenu Style</h2>
	<p>Collapse the side menu to display the main icon.</p>
	<div style="margin:20px 0;">
		<a href="javascript:;" class="easyui-linkbutton" onclick="toggle()">切换</a>
	</div>
	<div id="sm" class="easyui-sidemenu" data-options="data:data"></div>
	<link rel="stylesheet" type="text/css" href="sidemenu_style.css">
	<script type="text/javascript">
		var data = [{
	        text: 'Forms',
	        iconCls: 'fa fa-wpforms',
	        state: 'open',
	        children: [{
	            text: 'Form Element'
	        },{
	            text: 'Wizard'
	        },{
	            text: 'File Upload'
	        }]
	    },{
	        text: 'Mail',
	        iconCls: 'fa fa-at',
	        selected: true,
	        children: [{
	            text: 'Inbox'
	        },{
	            text: 'Sent'
	        },{
	            text: 'Trash',
	            children: [{
	                text: 'Item1'
	            },{
	                text: 'Item2'
	            }]
	        }]
	    },{
	        text: 'Layout',
	        iconCls: 'fa fa-table',
	        children: [{
	            text: 'Panel'
	        },{
	            text: 'Accordion'
	        },{
	            text: 'Tabs'
	        }]
	    }];

		function toggle(){
			var opts = $('#sm').sidemenu('options');
			$('#sm').sidemenu(opts.collapsed ? 'expand' : 'collapse');
			opts = $('#sm').sidemenu('options');
			$('#sm').sidemenu('resize', {
				width: opts.collapsed ? 60 : 200
			})
		}
	</script>
	</body>
	

<br />
<br />
<br />
<br />

<br />
<br />

</html>
