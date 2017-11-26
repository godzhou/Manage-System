<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分页列表</title>
  </head>
  
  <body>
        <h3 align="center" >课程列表</h3>
    <table border="1" width="70%" align="center">
        <tr>
            <th>课程编号</th>
            <th>课程名</th>
            <th>开课时间</th>
            <th>教师编号</th>
        </tr>
        <c:forEach items="${pb.beanList}" var="cour">
        <tr>
            <td>${cour.courseID}</td>
            <td>${cour.courseName}</td>
            <td>${cour.courseTrem}</td>
            <td>${cour.teacherID}</td>
        </tr>
        </c:forEach>
    </table>
  </body>
</html>
