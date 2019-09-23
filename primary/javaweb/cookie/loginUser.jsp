<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginUser.jsp' starting page</title>
    
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
			//记住密码
			var userName = getCookie("userName");
			var password = getCookie("password");
			var isLogin = getCookie("isLogin");
			
			//将获取 的值填充到 文本框中
			$("#userName").val(userName);
			$("#password").val(password);
			
			//复选框 操作
			if("yes"==isLogin){
				$('input[type=checkbox]').attr('checked','true');
			}else{
				$('input[type=checkbox]').removeAttr('checked');
			}
		
		});
		
		//写方法 根据 名称 判断 cooKies中是否 有该数据
		function getCookie(cname){
		   // 拼接 cookie中的 键值对             
		   var name = cname+'=';
		   //将获取到的cookie值进行拆分
		   var ca = document.cookie.split(';');	
		   //遍历
		   for(var i=0; i<ca.length;i++){
		   	var c = ca[i];
		   	while(c.charAt(0)==' '){
		   		c= c.substring(1);
		   	}
		   	//判断内容
		   	if(c.indexOf(name)!=-1){
		   		return c.substring(name.length, c.length);
		   	}
		   }
		   return "";
		}
		
	</script>
  </head>
  
  <body>
   <form action="servlet/LoginServlet?op=login" method="post">
   		用户名：<input type="text" name="login_name" id="userName" placeholder="输入用户名" /> <br/>
   		密码：<input type="password" name="password" id="password" placeholder="输入密码" /><br/>
   		
   		<input type="checkbox" name="isLogin" value="yes"> 记住密码<br/>
   		
   		<button type="submit">登录</button>
   </form>
  </body>
</html>
