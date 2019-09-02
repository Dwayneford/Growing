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
	<div style="margin:20px 0;"></div>
	
	<table class="easyui-datagrid" title="Aligning Columns in DataGrid" 
		style="width:700px;height:250px"
			
		data-options="singleSelect:true,
		collapsible:true,
		url:'servlet/GoodsSerevlet',
		method:'get'">
		
		<thead>
			<tr>
				<th data-options="field:'good_id',width:80,halign:'center'">GID</th>
				<th data-options="field:'good_name',width:100,halign:'center'">商品名称</th>
				<th data-options="field:'good_num',width:80,align:'right',halign:'center'">数量</th>
				<th data-options="field:'good_type',width:80,align:'right',halign:'center'">类型</th>
				<th data-options="field:'good_price',width:80,align:'right',halign:'center'">价格</th>
				<th data-options="field:'good_date',width:250,halign:'center'">日期</th>
				<th data-options="field:'good_beg_time',width:60,align:'center',halign:'center'">日期</th>
			</tr>
		</thead>
	</table>
 
</body>
</html>