<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
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
    	登录界面 <br>
    	<%@ include file="login.html" %>
    <!--form action="servlet/loginServlet" method="post">
    	<input type="text" name="id" ></br>
    	<input type="password" name="password"></br>
    	选择用户类型：
    	<label><input id="student" type="radio" name="idType" value="student" checked="true">学生</label>
    	<label><input id="teacher" type="radio" name="idType" value="teacher">老师</label></br>
    	<input type="submit" name="submit" value="登录">
    </form-->
    




  </body>
</html>
