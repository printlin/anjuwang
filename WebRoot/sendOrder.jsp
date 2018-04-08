<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提交订单页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	<script src="js/canvas-particle.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#button").click(function(){
			if($("#city option:selected").val()=="" || $("#city option:selected").val()==null || $("#city option:selected").val()=="undefined"){
				$("#message").text("您还没有输入省市！");
			}else if($("#county option:selected").val()=="" || $("#county option:selected").val()==null || $("#county option:selected").val()=="undefined"){
				$("#message").text("您还没有输入区县！");
			}else if($("#detai").val()=="" || $("#detai").val()==null || $("#detai").val()=="undefined"){
				$("#message").text("您还没有输入详细地址！");
			}else if($("#area").val()=="" || $("#area").val()==null || $("#area").val()=="undefined"){
				$("#message").text("您还没有输入面积！");
			}else if($("#phone").val()=="" || $("#phone").val()==null || $("#phone").val()=="undefined"){
				$("#message").text("您还没有输入电话！");
			}else if($("#xing").val()=="" || $("#xing").val()==null || $("#xing").val()=="undefined"){
				$("#message").text("您还没有姓氏！");
			}else{
				$("#form1").submit();
			}
		});
	});
</script>
<style type="text/css">
	*{
		font-family: 'Microsoft Yahei';
    	color: #666;
    	font-size: 16px;
	}
	.content{
		height: 500px;
		width:300px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 250px;
	}
	.address select{
		width:105px;
		border: 1px solid #0f88eb;
    	background: rgba(255,255,255,0.8);
	}
	.address textarea{
		width:300px;
		height: 80px;
		font-size: 16px;
		padding: 1em .8em;
    	box-sizing: border-box;
    	box-shadow: none;
    	border: 1px solid #0f88eb;
    	background: rgba(255,255,255,0.5);
    	font-family: 'Microsoft Yahei';
    	color: #666;
    	margin-top: 10px;
	}
	.area{
		margin-top: 20px;
	}
	.area input{
		width:188px;
		border: 1px solid #0f88eb;
    	background: rgba(255,255,255,0.5);
    	height: 30px;
    	padding: 1em .8em;
	}
	
	.xing{
		margin-top: 20px;
	}
	.ixing{
		width:90px;
		border: 1px solid #0f88eb;
    	background: rgba(255,255,255,0.5);
    	height: 30px;
    	padding: 1em .8em;
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
		  	<form name="form1" id="form1" action="${pageContext.request.contextPath }/servlet/SendOrderServlet" method="post">
		  		<span id="message" class="message"></span>
		  		<input type="hidden" name="com_id" value="${com_id}">
		  		<input type="hidden" name="type" value="do">
		  		<div class="address">
		  			<span>房屋地址：</span>
		  			<select id="city" name="city">
		  				<option value="">-请选择-</option>
		  				<option value="重庆市">重庆市</option>
		  			</select>
		  			<select id="county" name="county">
		  				<option value="">-请选择-</option>
		  				<option value="万州">万州</option>
						<option value="涪陵">涪陵</option>
						<option value="渝中">渝中</option>
						<option value="大渡口">大渡口</option>
						<option value="江北">江北</option>
						<option value="沙坪坝">沙坪坝</option>
						<option value="九龙坡">九龙坡</option>
						<option value="南岸">南岸</option>
						<option value="北碚">北碚</option>
						<option value="万盛">万盛</option>
						<option value="双桥">双桥</option>
						<option value="渝北">渝北</option>
						<option value="巴南">巴南</option>
						<option value="黔江">黔江</option>
						<option value="长寿">长寿</option>
						<option value="綦江">綦江</option>
						<option value="潼南">潼南</option>
						<option value="铜梁">铜梁</option>
						<option value="大足">大足</option>
						<option value="荣昌">荣昌</option>
						<option value="璧山">璧山</option>
						<option value="梁平">梁平</option>
						<option value="城口">城口</option>
						<option value="丰都">丰都</option>
						<option value="垫江">垫江</option>
						<option value="武隆">武隆</option>
						<option value="忠县">忠县</option>
						<option value="开县">开县</option>
						<option value="云阳">云阳</option>
						<option value="奉节">奉节</option>
						<option value="巫山">巫山</option>
						<option value="巫溪">巫溪</option>
						<option value="石柱">石柱</option>
						<option value="秀山">秀山</option>
						<option value="酉阳">酉阳</option>
						<option value="彭水">彭水</option>
						<option value="江津">江津</option>
						<option value="合川">合川</option>
						<option value="永川">永川</option>
						<option value="南川">南川</option>
		  			</select>
		  			<textarea id="detai" class="texta" name="detai" placeholder="输入您的详细地址" required></textarea>
		  		</div>
		  		<div class="area">
		  			<span>房屋面积：</span>
		  			<input id="area" type="text" name="area" placeholder="输入面积，如：130">
		  			<span>m²</span>
		  		</div>
		  		<div class="area">
		  			<span>联系电话：</span>
		  			<input id="phone" type="text" name="phone" placeholder="输入您的电话">
		  		</div>
		  		<div class="xing">
		  			<span>您的姓氏：</span>
		  			<input id="xing" class="ixing" type="text" name="xing" placeholder="姓">
		  			<input type="radio" name="gender" value="先生" checked="checked">先生
		  			<input type="radio" name="gender" value="女士">女士
		  		</div>
		  		<div class="button">
					<button type="button" class="login-btn register-btn" id="button">提交订单</button>
				</div>
		  	</form>
		  	
	  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
