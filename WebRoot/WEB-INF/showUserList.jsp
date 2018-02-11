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
  <script src="/take_food/js/jquery-1.12.4.js"></script>
  <link rel="stylesheet" type="text/css" href="/take_food/css/jquery-ui.min.css"/>
  <script src="/take_food/css/jquery-ui.min.js"></script>
    <script type="text/javascript">
  		function showCreat(uid){
  			console.log(uid);
  			$('#getUserId').val(uid);
  			$('#createDialog').dialog(
  					{title: '分配角色'},
  					{height:580},
  					{width:780},
  					{modal:true},
  					{show:'clip'}
  				
  			)
  			
  		}
  
  </script>
  
  
  <body>
  	<h1 align="center">用户列表</h1>
    <table align="center" border="1" width="600"  height="400"> 
    	<th>行号</th>
    	<th>姓名</th>
    	<th>昵称</th>
    	<th>添加角色</th>
    	<c:forEach items="${list}" var="item" varStatus="index"   >
    		<tr>
    			<td align="center">${index.index+1}</td>
    			<td align="center">${item.userName}</td>
    			<td align="center">${item.nikename }</td>
    			<td><input type="button" onclick="showCreat(${item.id})" value="添加角色"></td>
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
    
    <div class="roleForm" id="createDialog" style="display: none;">
    	<form id="addRole" action="${pageContext.request.contextPath }/AddUserOfRoleServlet" >
    		<input id="getUserId" type="hidden"  name="u_id" value="" >
    		
    			<table>
    				<tr>
    					<th>行号</th>
    					<th>角色名</th>
    					<th>选择</th>
    				</tr>
    				<c:forEach items="${roleList }" var="role" varStatus="vs">
    				<tr>	
    					<td>${vs.index+1 }</td>
    					<td>${role.name }</td>
    					<td><input type="checkbox" name="roleIds" value="${role.id}" /></td>
    				</tr>	
    				</c:forEach>
    			</table>
    			<input type="submit" value="提交"/>
    	</form>
    </div>
    
  </body>

</html>
