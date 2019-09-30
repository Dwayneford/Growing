<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'commonsFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<!-- enctype="application/x-www-form-urlencoded" -->
	<form action="servlet/CommonsServlet?method=commonFileUp" method="post" enctype="multipart/form-data">
		头像：<input type="file" name="useImg" /> <br/>
		
		昵称：<input type="text" name="userNickName"><br/>
		年龄：<input type="text" name="userAge"><br/>
		<button type="submit">提交</button>
	</form>
    <hr/>
    <a href="servlet/CommonsServlet?method=showCommonFileList">显示上传文件 </a>
    <hr/>
    <c:forEach items="${list }" var="li">
    	<a href="servlet/CommonsServlet?method=downloadFile&fileName=${li }">下载的图片：${li }</a><br/>
    </c:forEach>
  </body>
</html>
