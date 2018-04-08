<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/canvas-particle.js"></script>
	<script type="text/javascript">
		window.onload = function(){
			document.getElementById("bodyy").onmouseover=function(){
				alert("4");
			}
			document.getElementById("bodyy").onm
		    //配置
		    var config = {
		        vx: 4,//点x轴速度,正为右，负为左
		        vy:  4,//点y轴速度
		        height: 2,//点高宽，其实为正方形，所以不宜太大
		        width: 2,
		        count: 100,//点个数
		        color: "121, 162, 185",//点颜色
		        stroke: "100,200,180",//线条颜色
		        dist: 6000,//点吸附距离
		        e_dist: 20000,//鼠标吸附加速距离
		        max_conn: 10//点到点最大连接数
		    }
		    //调用
		    CanvasParticle();
		}
	</script>
  </head>
  
  <body id="bodyy">
 <jsp:include page="head.jsp"></jsp:include>
  </body>
</html>
