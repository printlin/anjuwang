<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>500错误</title>
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
	
	<style type="text/css">
		.clear{
			clear:both;
			height:0;
			font-size:0;
			line-height:0;
			overflow:hidden;
		}
		.content{
			width: 820px;
			margin-left: auto;
			margin-right: auto;
			margin-top: 200px;
			margin-bottom: 200px;
		}
		.img1{
			display:block;
			width:400px;
			height:380px;
			float: left;
		}
		.textAll{
			width:400px;
			margin-left: 20px;
			float: left;
		}
		.text0{
			margin-top:20px;
			font-size: 80px;
			color:#df3e3e;
			text-align: center;
		}
		.text1{
			margin-top:20px;
			font-size: 25px;
			color:#616b6f;
			text-align: center;
		}
		.buttonAll{
			margin-top:50px;
			width:400px;
			text-align: center;
		}
		.returnI{
			display:inline-block;
			width: 130px;
			height: 50px;
			text-align:center;
			line-height: 50px;
			color: #ffffff;
			background-color: #e7691e;
			margin-top: 30px;
			box-shadow: 2px 2px 3px #e0e0e0;
		}
		.returnI:HOVER {
			background-color: #f5b50a;
			box-shadow: 2px 2px 3px #bfbfbf;
		}
	</style>
  </head>
  
  <body style="background: #ececec;">
  	<jsp:include page="head.jsp"></jsp:include>
  	<div class="content">
  		<img class="img1" src="${pageContext.request.contextPath}/images/error/500.jpg" width="400px" height="380px"/>
  		<div class="textAll">
  			<h1 class="text0">500</h1>
  			<h2 class="text1">系统内部错误,程序员正在抢修中...</h2>
  			<div class="buttonAll">
  				<a class="returnI" href="${pageContext.request.contextPath }/index.jsp">返回首页</a>
  			</div>
  		</div>
  		<div class="clear"></div>
  	</div>
  	<div class="error">
  		message:<%=exception.getMessage()%><br>
  		LocalizedMessage:<%=exception.getLocalizedMessage()%><br>
  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  	
  </body>
</html>
