<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_xml_stuInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('button').click(function(){
				//写ajax
				$.ajax({
					type:"get",
					url:"stu.xml",
					dataType:"xml",
					error:function(xml){
						alert("加载静态资源文件 出错！！！");
					},
					success:function(xml){
						//jQuery创建emlment对象
						var flag = $("<ul/>");
						//解析xml
						$(xml).find("student").each(function(i,item){
							//获取 每个对象中的 属性 和子元素
							var id = $(item).children("id");
							var name = $(item).children("name");
							var stuSex = $(item).children("stuSex");
							var stuAddress = $(item).children("stuAddress");
							//属性
							var email = $(item).attr("email");
							//取值
							id_val = id.text();
							name_val = name.text();
							stuSex_val = stuSex.text();
							stuAddress_val = stuAddress.text();
							//追加到ul中
							flag.append("<li>"+id_val+"==="+name_val+"===="+stuSex_val+"===="+stuAddress_val+"===="+email+"</li>");
						});
						//存放到 div中
						flag.appendTo("#load");
					}
				});
			});
		});	
	</script>
  </head>
  <body>
  	<button>加载xml中的数据</button>
  	<hr/>
  	<div id="load">
  		
  	</div>
  	
  
  
  </body>
</html>
