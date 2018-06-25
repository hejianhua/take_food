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
  		<c:out value="${pageContext.request.contextPath}"></c:out>
    	<a href="${pageContext.request.contextPath}/ShowBillVoServlet">查看账单列表</a>
    	<a href="${pageContext.request.contextPath}/ShowFoodServlet">查看食物列表</a>
    	<a href="${pageContext.request.contextPath}/ShowMealsServlet">查看餐型列表</a>
    	<a href="${pageContext.request.contextPath}/ShowUserServlet?pageSize=5&pageNumber=1">查看用户列表</a>
    	<a href="${pageContext.request.contextPath}/ShowRoleServlet">查看角色列表</a>
    	<a href="${pageContext.request.contextPath}/ShowExpressServlet">查看物流</a>
    	<hr/>
    	<a href="${pageContext.request.contextPath}/TransferAddFoodServlet">添加食物</a>
    	<a href="${pageContext.request.contextPath}/TransferAddMealsServlet">添加餐型</a>
    	<a href="${pageContext.request.contextPath}/register.jsp">添加用户</a>
    	<a href="${pageContext.request.contextPath}/TransferAddBillVoServlet">添加账单</a>
    	<a href="${pageContext.request.contextPath}/TransferAddRoleVoServlet">添加角色</a>
    	<a href="${pageContext.request.contextPath}/TransferAddResourceServlet">添加资源</a>
    	
    	<a href="${pageContext.request.contextPath}/BaseSevlet?handler=xc.take.servlet.base.TestBase">点我测试</a>
    	
    	
  </body>
  		
  
</html>
