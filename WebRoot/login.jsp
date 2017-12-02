
<!DOCTYPE html>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html >
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="login.css" />
    <script src="/js/jquery.js"></script>
	<script src="/js/login.js"></script>
    <title>Title</title>
</head>
<body>

<!--form action="servlet/loginServlet" method="post">
    <input type="text" name="id" ></br>
    <input type="password" name="password"></br>
    选择用户类型：
    <label><input id="student" type="radio" name="idType" value="student" checked="true">学生</label>
    <label><input id="teacher" type="radio" name="idType" value="teacher">老师</label></br>
    <input type="submit" name="submit" value="登录">
</form-->

<div id="login">
    <div class="loginCon">
        <div class="logintop">
            <div class="logfont">登录</div>
            <div id="close"></div>
        </div>
        <div class="loginright">
            <form action="loginServlet" method="post">
                <input class="input_c fo_ur" name="id" type="text" value="请输入登陆邮箱" /><br>
                <input class="input_c" name="password" type="password" value="" /><br>
                <label>验证码：</label><input type="text" name="validateCode" />
                <span><img id="validate_img" alt="点击刷新" src="CreateCode" onclick="javascript:this.src='CreateCode?rnd='+Math.random()"></span>
                <div class="chose">选择用户类型：</div>
                <label><input type="radio" name="idType" value="student" checked="true">学生</label>
                <label><input type="radio" name="idType" value="teacher">老师</label></br>
                <input class="btu fo_ur" type="submit" name="submit" value="登录">
            </form>
        </div>
        <div class="loginleft">
            <div class="loglefont">一键授权，快速登录</div>
            <button class="btut" style="background: #259cce" onclick="">QQ账号直接登录</button>
            <button class="btut"style="background: #be302f" onclick="">新浪微账号登录</button>
        </div>

    </div>
</div>

</body>
</html>
