<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>managerLogin</title>
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
	

  </head>
  
  <body>
    <div>
    <form action="servlet/ManagerLoginServlet" method="post">
    	<table>
    	
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="username"></td>
    		</tr>
    		<tr>
	    		<td>密码：</td>
	    		<td><input type="password" name="password"></td>
    		</tr>
    		<tr>
	    		<td>验证码：</td>
	    		<td><input type="text" name="chackCode"><img src="${pageContext.request.contextPath }/servlet/ChackCode"></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="登录"></td>
    		</tr>
    	
    	</table>
    </form>
    </div>
  </body>
</html>
