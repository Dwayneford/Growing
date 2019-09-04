<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'a.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script>
		$(function(){
			$("#userReg").click(function(){
				//ajax 的异步操作
				// 1.获取参数 2.使用ajax 提交数据
				var userName =$("#userName").val();
				var userPwd =$("#userPwd").val();
				
				$.ajax({
					url:"LogServlet",
					type:"get",
					dataType:"json",
					data:{op:'regst',userName:userName,userPwd:userPwd},
					success:function(resData){
						//处理返回的响应数据
						//JSON.parse(resData);
						//将数据 转换为标准的 jsong 格式
						//var data = $.preseJSON(resData);\
						//登录成功 界面跳转
						window.location.href="main_ind.jsp";
						//window.location.replace="";
						
						//$(window).attr("src","");
						//$(document).attr("src","");
						// prop();
						
						//获取状态码
						if(resData.status==200){
							//resData.变量名称
							alert("登录成功");
						} else{
							alert(resData.message);
						}
					},
					error:function(errData){
						alert("error:"+errData);
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
   <form action="">
   	  名称：<input type="text" id="userName" placeholder="请输入用户名"/>
   	  密码：<input type="password" id="userPwd" placeholder="请输入用密码"/>
   	  <input type="button" id="userReg" value="登录">
   </form>
  </body>
</html>
