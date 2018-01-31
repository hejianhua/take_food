<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加账单</title>
    
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
  		<form action="${pageContext.request.ContextPath}/AddBillServlet">
	   		请选择用户：<select name="u_id">
			   			<c:forEach items="userVoList"  varStatus="vs" var="userVo">
			   				<option  value="${userVo.id }" >${userVo.username}</option>
			   			</c:forEach>
		   			</select><br/>
	   		
			请选择食物 ： <select name="f_id">
			   			<c:forEach items="foodList"  varStatus="vs" var="food">
			   				<option value="${food.id }">${food.name}</option>
			   			</c:forEach>
			   		</select><br/>
	   		
	   		请选择餐型:<select name="m_id">
			   			<c:forEach items="mealsList"  varStatus="vs" var="meals">
			   				<option value="${meals.id }">${meals.name}</option>
			   			</c:forEach>
	   				</select><br/>
	   				
	   		请输入数量:<input type="text" name="number"  />
	   		
	   		请输入此订单总价格:<input type="text" name="totalMoney"  />
	   		
	   				<input type="submit" value="确认" />
   		</form>
  </body>
</html>
