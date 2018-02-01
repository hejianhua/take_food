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
    
    <title>我的用户列表</title>
    
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
  	<h1 align="center">用户列表</h1>
    <table align="center" border="1" width="600"  height="400"> 
    	<th>行号</th>
    	<th>姓名</th>
    	<th>昵称</th>
    	<c:forEach items="${list}" var="item" varStatus="index"   >
    		<tr>
    			<td align="center">${index.index+1}</td>
    			<td align="center">${item.userName}</td>
    			<td align="center">${item.nikename }</td>
    		</tr>
    	</c:forEach>
    		<tr align="center">
    			<td><a href="${pageContext.request.contextPath }/ShowUserServlet?pageSize=${pageModel.pageSize}&pageNumber=${pageModel.pageNumber==1? '1' : pageModel.pageNumber-1}">上一页</a></td>
    			<td>页码:${pageModel.pageNumber }/${pageModel.pageCount }
    					<select id="selectPage" name="pageSize">
    						<option value="3">3</option>
    						<option value="5">5</option>
    						<option value="10">10</option>
    					</select>
    			</td>
    			<td><a href="${pageContext.request.contextPath }/ShowUserServlet?pageSize=${pageModel.pageSize}&pageNumber=${pageModel.pageNumber==pageModel.pageCount? pageModel.pageCount : pageModel.pageNumber+1}">下一页</a></td>
    		</tr>
    
    </table>
  </body>
  
</html>
