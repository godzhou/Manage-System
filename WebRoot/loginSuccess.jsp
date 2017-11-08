<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <script type=text/javascript src=js/jquery.js></script>
  <script type=text/javascript src=js/stuAct.js></script>

<%@ page import="JavaBean.Student" %>
<title>登录成功</title>
</head>
<body>
登陆成功！
欢迎你，
 <%
 request.setCharacterEncoding("utf-8");
 Student student = (Student)session.getAttribute("User");
  %>
  <%=request.getParameter("name") %>!
 <%=student.getAge() %>
 <%=student.getPassword() %>
<button id="btn" action="servlet/actServlet">查询成绩信息</button>
</body>
</html>