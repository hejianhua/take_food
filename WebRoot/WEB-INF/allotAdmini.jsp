<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allotAdmini.jsp' starting page</title>
    
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
	      		<th>增</th>
	      		<th>删</th>
	      		<th>改</th>
	      		<th>查</th>
	      		<th>其他</th>
	      	</tr>
	      	<tr>
	      		<td align="center" >食物分配权限</td>
	      		<td align="center">增:<input type="checkbox" name="0001" value="0001"/></td>
	      		<td align="center">删:<input type="checkbox" name="0001" value="0002"/></td>
	      		<td align="center">改:<input type="checkbox" name="0001" value="0003"/></td>
	      		<td align="center">查:<input type="checkbox" name="0001" value="0004"/></td>
	      	</tr>
	      </table>
	      <input type="submit" value="提交" />
      </form>
  </body>
</html>
