<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选择功能吧</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>只有一个功能：<br/>
    	<a href="${request.ContextPath}/BillServlet">查看列表</a>
    	<a href="${request.ContextPath}/addFood.jsp">添加食物</a>
    	<a href="${request.ContextPath}/addBillVo.jsp">添加餐型</a>
    	<a href="${request.ContextPath}/re">添加用户</a>
  </body>
</html>
