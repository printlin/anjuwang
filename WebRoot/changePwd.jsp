<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码页面</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<style type="text/css">
body{
background-color: #F7FAFC;
}
table{ border: 1px solid black;width: 500px;margin-left: auto;margin-right: auto;}
td{ border: 1px solid black;}
input[type="password"]{
		width: 49%;
		height: 20px;
		font-size: 12px;
		line-height: 20px;
}
.tdfirst{ background-image: url("images/table_title_mid.gif");background-repeat: repeat-x;}
.password{
margin-top: 100px;
}
.password .sbmt{
	width: 80px;
    height: 30px;
    border: 0;
    display: inline-block;
    overflow: hidden;
    vertical-align: middle;
    line-height: 30px;
    font-size: 16px;
    font-weight: 700;
    color: #fff;
    background: #1d80cf;
    border-radius: 3px;
    cursor: pointer;
    zoom: 1;
    margin: 10px 10px;}
.cent-box-header{
			text-align: center;
		}
	.hide{
			font: 0/0 a;
    		color: transparent;
    		text-shadow: none;
    		background-color: transparent;
    		border: 0;
		}
		.cent-box-header .main-title{
			width: 160px;
			height: 74px;
			margin: 0 auto;
			background: url("images/static/logo.png") no-repeat;
			background-size: contain;
		}
		.cent-box-header .sub-title{
			margin: 30px 0 20px;
    		font-weight: 400;
    		font-size: 18px;
    		line-height: 1;
		}
</style>
<script type="text/javascript">
	function checkPwd(){
	
	console.log("测试");
	var password = document.getElementById("password");
	var npassword = document.getElementById("npassword");
	var qpassword = document.getElementById("qpassword");
	console.log(password.value);
	if(npassword.value==password.value){
		alert("不能与原密码一致");
		return;
	}
	
	if(npassword.value.length<6){
		alert("新密码长度不能小于6");
		return;
	}
	
	if(npassword.value!=qpassword.value){
		alert("密码不一致");
		return;
	}
	
	document.changePwd.submit();
	
	
	
}
</script>
</head>
<body>
    <jsp:include page="head.jsp"></jsp:include>
    
	<div class="password">
	<div class="cent-box-header">
		<h1 class="main-title hide">安居网</h1>
		<h2 class="sub-title">荟萃家装名品，装点多彩生活</h2>
	</div>
     	<form action="servlet/ChangePasswordServlet" method="post" name="changePwd">
     			<table>
	     			<tr>
	     				<td class="tdfirst" colspan="2">密码修改</td>
	     			</tr>
     				<tr>
     					<td>原密码：</td>
					  	<td><input type="password" name="oldPassword" id="password"/></td>
					</tr>
					<tr>
						<td>新密码：</td>
					  	<td><input type="password" name="newPassword" id="npassword"/></td>
					</tr>
					<tr>
						<td>确认密码：</td>
					  	<td><input type="password" name="qpassword" id="qpassword"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button" class="sbmt" value="提交" onclick="checkPwd()"/></td>
					</tr>
				</table>
     	</form>
				
     </div>
<div style="position: fixed; bottom: 0px;right: 0px;left: 0px;">
	<jsp:include page="bottom.jsp"></jsp:include>
</div>
</body>


</html>