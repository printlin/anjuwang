<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404错误</title>
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
			width: 1200px;
			height:600px;
			margin-left: auto;
			margin-right: auto;
			margin-bottom: 180px;
			position: relative;
		}
		.img1{
			display:block;
			width:1200px;
			height:600px;
			position: absolute;
		}
		.buttonAll{
			margin-top:0px;
			width:1200px;
			text-align: center;
			position:absolute ;
			top:500px;
		}
		.returnI{
			display:inline-block;
			width: 130px;
			height: 50px;
			text-align:center;
			line-height: 50px;
			color: #ffffff;
			background-color: #4d4949;
			margin-top: 30px;
			margin-left:50px;
			box-shadow: 2px 2px 3px #e0e0e0;
		}
		.returnI:HOVER {
			background-color: #999191;
			box-shadow: 2px 2px 3px #d1feba;
			color: #000;
		}
	</style>
  </head>
  
  <body>
  	<jsp:include page="head.jsp"></jsp:include>
  	<div class="content">
  		<img class="img1" src="${pageContext.request.contextPath}/images/error/404.png" width="1200px" height="600px"/>
  		<div class="textAll">
  			<div class="buttonAll">
  				<a class="returnI" href="${pageContext.request.contextPath }/index.jsp">返回首页</a>
  			</div>
  		</div>
  		<div class="clear"></div>
  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  	
  </body>
</html>
