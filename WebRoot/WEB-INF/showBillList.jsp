<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用于显示账单</title>
    
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
    	<table align="center" border="1" width="600" height="100">
    		<th>行号</th>
    		<th>客户名</th>
    		<th>餐型</th>
    		<th>食物名称</th>
    		<th>食物价格</th>
    		<th>份数</th>
    		<th>总金额</th>
    		<c:forEach items="${list}" var="item" varStatus="vs" >
    			<tr>
    				<td>${vs.index}</td>
    				<td>${userMap[item.id].userName }</td>
    				<td>${mealsMap[item.id].name }</td>
    				<td>${foodMap[item.id].name }</td>
    				<td>${foodMap[item.id].price }</td>
    				<td>${item.number}</td>
    				<td>${item.totalMoney}</td>
    			</tr>
    		</c:forEach>
    	</table>
  </body>
</html>
