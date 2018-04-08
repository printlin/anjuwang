<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>咨询页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/canvas-particle.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#button").click(function(){
			if($("#texta").val()==""  || $("#texta").val()==null || $("#texta").val()=="undefined"){
				$("#message").text("您还没有输入问题！");
			}else{
				$("#form1").submit();
			}
		});
	});
</script>
<style type="text/css">
	.content{
		text-align: center;
		height: 500px;
		width:300px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 250px;
	}
	.texta{
		width:300px;
		height: 250px;
		font-size: 16px;
		padding: 1em .8em;
    	box-sizing: border-box;
    	box-shadow: none;
    	border: 1px solid #0f88eb;
    	background: rgba(255,255,255,0.8);
    	font-family: 'Microsoft Yahei';
    	color: #666;
	}
	.button{
			margin-top:18px; 
		}
		#button{
			width: 100%;
			background: #0f88eb;
    		box-shadow: none;
    		border: 0;
    		border-radius: 3px;
    		line-height: 41px;
    		color: #fff;
    		display: block;
    		font-size: 15px;
    		cursor: pointer;
    		font-family: 'Microsoft Yahei';
		}
		#button:hover{
			background: #80c3f7;
		}
		.message{
			display:inline-block;
			color:#f00;
			font-size: 15px;
			margin-bottom: 10px;
		}
</style>
  </head>
  
  <body>
    <jsp:include page="head.jsp"></jsp:include>
  	<div class="content">
	  	<form name="form1" id="form1" action="${pageContext.request.contextPath }/servlet/SendMessageServlet" method="post">
	  		<span id="message" class="message"></span>
	  		<input type="hidden" name="com_id" value="${com_id}">
	  		<input type="hidden" name="where" value="${where}">
	  		<input type="hidden" name="type" value="do">
	  		<textarea class="texta" name="question" id="texta" placeholder="输入您的问题" required></textarea>
	  		<div class="button">
				<button type="button" class="login-btn register-btn" id="button" value="提交">提交问题</button>
			</div>
	  	</form>
	  	
  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
