<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的账单列表</title>
    
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
    <table align="center" border="1" width="600"  height="400"> 
    	<th>行号</th>
    	<th>姓名</th>
    	<th>昵称</th>
    	<c:forEach items="${list}" var="item" varStatus="index"   >
    		<tr>
    			<td align="center">${index.index}</td>
    			<td align="center">${item.userName}</td>
    			<td align="center">${item.nikename }</td>
    		</tr>
    	</c:forEach>
    
    </table>
  </body>
</html>
