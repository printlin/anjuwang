<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传头像</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	
	
<script type="text/javascript" src="/zhw/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	var progress;
	var uploadProcessTimer = null;
	function formSubmit() {
		uploadProcessTimer = window.setInterval("getFileUploadProcess()", 100); //每隔100毫秒执行callback  
		document.forms[0].submit();
	}
	function getFileUploadProcess() {
		$.ajax({
			type : "GET",
			url : "servlet/UploadImgRateServlet",
			dataType : "text",
			cache : false,
			success : function(data) {
				if (data == "100%") {
					window.clearInterval(uploadProcessTimer);
				} else {
					progress = data;
					$("#show").width(data);
					$("#msg").text(data);
					document.getElementById("show1").innerHTML = data;
				}
			}
		});
	};

</script>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div style="width: 500px;margin-top: 200px;margin-right: auto;margin-left: auto;margin-bottom: 200px;">
		<form action="servlet/UploadOwnerHandServlet" method="post" enctype="multipart/form-data">
			<input type="file" name="fileName" accept="image/*"/>
			<input type="button" onclick="formSubmit()" value="上传" />
		</form>
		<div style="width:273px;">
			<div id="show" style="background:#0ff;height:26px;width:0%;"></div>
		</div>
		<span id="msg"></span>
		<br>
		<span id="show1"></span>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>