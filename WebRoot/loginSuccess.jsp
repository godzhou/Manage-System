<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <script type=text/javascript src="<%=path %>/js/jquery.js"></script>
  <script type=text/javascript >
  	function sub(){
  		$.ajax({
    dataType:"json",    //数据类型为json格式
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    type:"GET",
    url:"actServlet",
    statusCode: {404: function() {
        alert('page not found'); }
    },
    success:function(data,textStatus){
    	var htmlCon;
        htmlCon = "<table border='1'><tr><td>序号</td><td>课程</td><td>学期</td><td>教师</td><td>分数</td></tr>";
        for(var key in data[0]){
         var count = 0;
				count++;
				htmlCon = htmlCon + "<tr><td>"+count+"</td><td>"+data[0][key][0]+"</td><td>"+data[0][key][1]+"</td><td>"+data[0][key][2]+"</td><td>"+data[0][key][3]+"</td></tr>";
          
        }
        htmlCon = htmlCon +"</table>";
        $("#sp").html(htmlCon);
    }
});
}
function modifyPw(){
	$("#sp").html("输入新密码：<br><input id='newpw' type='text' name='newpw'><input type='button' value='提交' id='btn_mod' onclick='ajax2()'>");
}

function ajax2(){
var con = $("#newpw").val();
  		$.ajax({
    dataType:"json",    //数据类型为json格式
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    type:"GET",
    url:"stuModifyPw?password="+con,
    statusCode: {404: function() {
        alert('page not found'); }
    },
    success:function(data,textStatus){
    	if(data){
    		$("#sp").html("修改密码成功！");
    	}else{
    		$("#sp").html("修改密码失败！");
    	}
    }
});
}
function selectCourse(){
	$("#sp").append("选择你要查询的学期：<select id='sel'><option value='2016-2017春'>2016-2017春</option><option value='2017-2018秋'>2017-2018秋</option><option value='2017-2018春'>2017-2018春</option></select>");
	$("#sp").append("<input type='button' value='查询' onclick='ajax3()'>");
}
function ajax2(){
var con = $("#sel").val();
  		$.ajax({
    dataType:"json",    //数据类型为json格式
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    type:"GET",
    url:"selectCourseByTerm?term="+con,
    statusCode: {404: function() {
        alert('page not found'); }
    },
    success:function(data,textStatus){
    	var htmlCon;
        htmlCon = "<table border='1'><tr><td>序号</td><td>课程</td><td>学期</td><td>教师</td></tr>";
        for(var key in data[0]){
         var count = 0;
				count++;
				htmlCon = htmlCon + "<tr><td>"+count+"</td><td>"+data[0][key][0]+"</td><td>"+data[0][key][1]+"</td><td>"+data[0][key][2]+"</td><td>"+data[0][key][3]+"</td></tr>";
          
        }
        htmlCon = htmlCon +"</table>";
        $("#sp").html(htmlCon);
    }
});
}
  </script>

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
 <%=student.getPassword() %><br>
<input type="button" value="查询成绩信息" id="btn" onclick="sub()">
<input type="button" value="修改密码" id="btn2" onclick="modifyPw()">
<input type="button" value="查看所开课程" id="btn3" onclick="selectCourse()">

<br>
result:
<span id="sp"></span>
</body>
</html>