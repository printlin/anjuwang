<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>安居网登录页面</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
<script src="js/canvas-particle.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script></head>


<body>

<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">安居网</h1>
		<h2 class="sub-title">荟萃家装名品，装点多彩生活</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="${pageContext.request.contextPath}/LoginUIServlet" class="active">登录</a>
				<a href="${pageContext.request.contextPath}/Register.jsp">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-con tel">
					<input type="text" name="phomenumber" id="tel" class="con" pattern="^1[34578]\d{9}$" placeholder="电话号码" required>
					<span id="telMes" class="message"></span>
				</div>
				<div class="group-con password">
					<input type="password" name="password" id="password" class="con" placeholder="输入您的登录密码" required>
					<span id="passwordMes" class="message"></span>
				</div>
				<!-- 验证码 -->
				<div class="group-con verify">
					<input type="text" name="chackCode" id="chackCode" class="chackCode" placeholder="验证码" required>
					<img id="chackImg" class="chackImg" src="${pageContext.request.contextPath }/servlet/ChackCode">
					<span id="chackCodeMes" class="message"></span>
				</div>
				<!-- 验证码 end -->
			</div>
		</div>

		<div class="button">
			<button type="button" class="login-btn register-btn" id="button" value="登录">登录</button>
			<span id="loginErrorMes" class="message"></span>
		</div>

		<div class="remember clearfix">
			<label class="remember-me">
			<input type="checkbox" name="remember" id="remember" class="remember-mecheck" value="记住我">记住我
			</label>
			<!--  label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label-->
		</div>
	</div>
</div>



</body>

</html>
