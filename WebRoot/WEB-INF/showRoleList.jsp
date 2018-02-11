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
    
    <title>角色管理</title>
    
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
   	<table>
   		<th>行号</th>
   		<th>角色名</th>
   		<th>增加角色</th>
   		<th>删除角色</th>
   		<th>修改角色</th>
		<th>分配权限</th>
		<c:forEach items="${list}" var="role" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${role.name}</td>
				<td><a href="">增加</a></td>
				<td><a href="">删除</a></td>
				<td><a href="">修改</a></td>
				<td><a href="${pageContext.request.contextPath}/AllotAdminiServlet?roleId=${role.id}">分配权限</a></td>
			</tr>
		</c:forEach>
   	</table>
  </body>
</html>
