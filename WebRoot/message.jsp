<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>消息显示页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Refresh" content="3; url=${url}" />
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	
	<!--
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.clear{
			clear:both;
			height:0;
			font-size:0;
			line-height:0;
			overflow:hidden;
		}
		.content{
			width: 1200px;
			height:600px;
			margin-left: auto;
			margin-right: auto;
			margin-bottom: 180px;
			text-align: center;
		}
		.img1{
			display:block;
			width:200px;
			height:200px;
			margin-left: auto;
			margin-right: auto;
		}
		.message1{
			color:#4d4949;
			font-size: 50px;
			margin-left: auto;
			margin-right: auto;
		}
		.text1{
			color:#4d4949;
			font-size: 16px;
			margin-left: auto;
			margin-right: auto;
			margin-top: 20px;
		}
		.button1{
			color:#60d391;
		}
		.button1:HOVER {
			color:#f0a452;
		}
	</style>
  </head>
  
  <body>
  	<jsp:include page="head.jsp"></jsp:include>
  	<div class="content">
	  	<img class="img1" src="${pageContext.request.contextPath}/images/message/succes.png" width="200px" height="200px"/>
	  	<div class="message1">${message}</div>
  		<div class="text1">
  			页面将在3秒后跳转，如果没有跳转，请<a class="button1" href="${url}">点我</a>
  		</div>
  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
