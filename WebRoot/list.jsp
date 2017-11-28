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
    </br>
    <center>
    	第${pb.pageNum }页/共${pb.totalPage }页 
    	<a href="${pb.url }?pageNum=1">首页</a>
    	<c:if test="${pb.pageNum>1 }">
    		<a href="${pb.url }?pageNum=${pb.pageNum-1}">上一页</a>
    	</c:if>
    	<c:choose>
    	<c:when test="${pb.totalPage<=10}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${pb.totalPage}"/>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${pb.pageNum-5}"/>
            <c:set var="end" value="${pb.pageNum+4}"/>
            <%--头溢出--%>
            <c:if test="${begin<1}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="10"/>
            </c:if>
            <%--尾溢出--%>
            <c:if test="${end>pb.totalPage}">
                <c:set var="end" value="${pb.totalPage}"/>
                <c:set var="begin" value="${pb.totalPage-9}"/>
            </c:if>
        </c:otherwise>
    	</c:choose>
    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:choose>
            <c:when test="${i eq pb.pageNum}">
                [${i}]
            </c:when>
            <c:otherwise>
                <a href="${pb.url}?pageNum=${i}">[${i}]</a>
            </c:otherwise>
        </c:choose>

    </c:forEach>
    <c:if test="${pb.pageNum<pb.totalPage}">
    <a href="${pb.url}?pageNum=${pb.pageNum+1}">下一页</a>
    </c:if>
    <a href="${pb.url}?pageNum=${pb.totalPage}">尾页</a>
    </center>
  </body>
</html>
