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
    
    <title>资源分配</title>
    
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
  	<form action="${pageContext.request.contextPath}/HandleAdminServlet">
  		<input type="hidden"  name="roleId"  value="${roleId}"  >
	      <table align="center" border="1" width="580" height="260">
	      	<tr>
	      		<th>权限功能</th>
	      		<th>操作</th>
	      	</tr>
	      	<c:forEach items="${resourceList}" var="resource" varStatus="vs">
		      	<tr>
		      		<td align="center" >${resource.name}</td>
		      		<td align="center"><input type="checkbox" name="resourceIds" value="${resource.id}"/></td>
		      	</tr>
	      	</c:forEach>
	      </table>
	      <input type="submit" value="提交" />
      </form>
  </body>
</html>
