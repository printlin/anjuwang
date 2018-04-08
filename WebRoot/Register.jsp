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

<title>注册页面</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
<!--div id="box"></div-->
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">安居网</h1>
		<h2 class="sub-title">荟萃家装名品，装点多彩生活</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登录</a>
				<a href="${pageContext.request.contextPath}/Register.jsp" class="active">注册</a>
				<div class="slide-bar slide-bar1"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-con tel">
					<input type="text" name="phomenumber" id="tel" class="con"  placeholder="电话号码" required>
					<span id="telMes" class="message"></span>
				</div>
				<div class="group-con user">
					<input type="text" name="nickname" id="user" class="con" placeholder="您的称谓" required>
					<span id="userMes" class="message"></span>
				</div>
				<div class="group-con password">
					<input type="password" name="password" id="password" class="con" placeholder="设置密码" required>
					<span id="passwordMes" class="message"></span>
				</div>
				<div class="group-con repassword">
					<input type="password" name="repassword" id="repassword" class="con" placeholder="重复密码" required>
					<span id="repasswordMes" class="message"></span>
				</div>
				<!-- 验证码 -->
				<div class="group-con verify">
					<div>
						<input type="text" name="chackCode" id="chackCode" class="chackCode" placeholder="验证码" required>
						<img id="chackImg" class="chackImg" src="${pageContext.request.contextPath }/servlet/ChackCode">
					</div>
					<span id="chackCodeMes" class="message"></span>
				</div>
				<!-- 验证码 end -->
			</div>
		</div>

		<div class="button">
			<button type="button" class="login-btn register-btn" id="button" value="提交">提交</button>
			<span id="addErrorMes" class="message"></span>
		</div>
	</div>
</div>





</body>
</html>
