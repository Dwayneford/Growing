<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%-- <%@ taglib uri="www.myTag" prefix="myt" %> --%>
<%@ taglib uri="www.myTag" prefix="mq" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
  
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js" ></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/layui.all.js" ></script>	
</head>
<body>  
<a href="${pageContext.request.contextPath }/servlet/LayUIServler?method=myPage&size=3&currentPage=1">显示自定义分页数据</a><br/>
<a href="${pageContext.request.contextPath }/servlet/TestServlet?op=xiaobai">测试 监听</a><br/>

<hr/>
 用户访问量：${count };当前登录用户：${count }
<hr/>
	 <form action="${pageContext.request.contextPath }/servlet/TestServlet?op=login" method="post">
    	用户名：<input type="text" name="uname"><br/>
    	密码：<input type="password" name="upwd"><br/>
    	
    	<button type="submit">登录</button>
    </form>
<hr/>
<!-- jstl中的循环标签 forEach -->
<%-- 
<c:forEach items="${list }" var="ite">
	<tr>
		<td>${ite.uname}</td>
		<td>${ite.uage}</td>
	</tr>
</c:forEach> 
--%>
<hr/>
自定义标签的输出内容是：<mq:hello/>
<hr/>
获取 当前的系统时间：
<mq:showTime format="yyyy年MM月dd日 HH:mm:ss"/>

<hr/>
获取 当前的系统时间：
<mq:showTime format="yyyy/MMdd HH:mm:ss"/>
<hr/>
<%
	ArrayList list = new ArrayList();
	list.add("电话手表");
	list.add("汽车配件");
	list.add("服装设计");
	list.add("食品安全");
	list.add("五金杂货");
	
	//存入作用域中
	pageContext.setAttribute("list", list);
 %>

<mq:iteator items="list" var="mgl" scope="page">
	${mgl }<br/>
</mq:iteator>

<hr/>
<!-- 页面的检索框 -->
		   <form class="layui-form">
		   	<div class="layui-form-item">
		   		<div class="layui-inline tool-btn"></div>
		   		 <div class="layui-inline">
			      <label class="layui-form-label">关键字</label>
			      <div class="layui-input-inline">
			        <input type="text" name="keywords" lay-verify="required" autocomplete="off" class="layui-input">
			      </div>
			    </div>
		   		<div class="layui-inline">
		   			<label class="layui-form-label">是否推荐</label>
		   			 <div class="layui-input-inline">
			   			<select name="pos" lay-filter="status">
			   				<option value="">请选择</option>
			   				<option value="1">是</option>
			   				<option value="2">否</option>
			   			</select>
		   			 </div>
		   		</div>
		   		<button class="layui-btn layui-btn-normal" lay-submit="search" lay-filter="keyWordsSearch">搜索</button>
		   	</div>
		   </form>
 
<div class="layui-btn-group demoTable">
  <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
  <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
  <button class="layui-btn" data-type="isAll">验证是否全选</button>
</div>
 
<table class="layui-table"
	lay-data="{width: 992, height:490, url:'servlet/LayUIServler?method=queryPage', page:true, id:'idTest'}" 
	lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
      <th lay-data="{field:'good_id', width:80, sort: true, fixed: true}">ID</th>
      <th lay-data="{field:'good_name', width:80}">商品名</th>
      <th lay-data="{field:'good_num', width:80, sort: true}">数量</th>
      <th lay-data="{field:'good_type', width:80}">类型</th>
      <th lay-data="{field:'good_price', width:160}">价格</th>
      <th lay-data="{field:'good_date', width:80, sort: true}">日期</th>
      
      <th lay-data="{field:'good_beg_time', width:80}">日期2</th>
      <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
               
          

<script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['table','layer','form'], function(){
  var table = layui.table;
  var form = layui.form;
  
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  
  //查询数据 表单监听
  form.on("submit(keyWordsSearch)",function(datas){
  		//取出对应的检索条件名称
  		var data=datas.field;
  		alert(data.keywords);
      //执行重载
      table.reload('idTest', {
        page: {
          curr: 1 //重新从第 1 页开始
        }
        ,where: {
         // key: {}
          	keyWords:data.keywords,
          	pos:data.pos
          
        }
      });
  	layer.msg("数据已刷新！！！");
  	return false;
  });
  
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      //查看操作 layer.msg('ID：'+ data.good_id + ' 的查看操作');
       layer.open({
			type: 2, 		//类型，解析url
			closeBtn: 1, 	//关闭按钮是否显示 1显示0不显示
			skin: 'layui-layer-molv', //样式类名
			title: '商品信息查看', //页面标题
			shadeClose: true, //点击遮罩区域是否关闭页面
			shade: 0.8,  	  //遮罩透明度
			area: ['900px', '500px'],  //弹出层页面比例
			content: 'servlet/LayUIServler?method=queryById&goodId='+data.good_id  //弹出层的url
		}); 
      
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      //layer.alert('编辑行：<br>'+ JSON.stringify(data))
	  var index = layer.open({
				type: 2, 		//类型，解析url
				title: '编辑商品信息', //页面标题
				skin: 'layui-layer-molv', //样式类名
				closeBtn: 1, 	//关闭按钮是否显示 1显示0不显示
				shadeClose: false, //点击遮罩区域是否关闭页面
				shade: 0.8,  	  //遮罩透明度
				area: ['900px', '500px'],  //弹出层页面比例
				content: 'servlet/LayUIServler?method=queryById&goodId='+data.good_id,  //弹出层的url
				success:function(layout,index){
					//成功操作的执行函数.....
				},
				btn:['提交','关闭','重置'],  //子页面显示的按钮
				yes:function(index,layeror){
					//获取参数 编辑后的参数v提交给服务器 多种操作
					var dataGoods = $(layeror).find('iframe')[0].contentWindow.formData();
					//alert('----==='+dataGoods);
					
					//将参数 已异步操作 方式 进行保存
					$.ajax({
						type:'post',
						url:'servlet/LayUIServler?method=updateGoods',
						data:dataGoods,
						dataType:'text',
						success:function(msg){
							//成功 : 刷新列表 关闭弹出层 
							$('.layui-laypage-btn').click();//layui ajax刷新本行数据 
							layer.alert(msg);
							layer.close(index);
						}
					});
					
				},
				btn2:function(){
					
				},
				btn3:function(){
				
				}
				
				
				
			}); 

      
    }
  });
  
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据
      var checkStatus = table.checkStatus('idTest')
      ,data = checkStatus.data;
      layer.alert(JSON.stringify(data));
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus('idTest')
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus('idTest');
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});
</script>

</body>
</html>