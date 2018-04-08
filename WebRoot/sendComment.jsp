<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>评价页面</title>
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
		$("#bad").mouseover(function(){
			toGray($("#praise"));
			toGray($("#commonly"));
			notGray($("#bad"));
			$("#grade").val("bad");
		});
		$("#commonly").mouseover(function(){
			toGray($("#praise"));
			toGray($("#bad"));
			notGray($("#commonly"));
			$("#grade").val("commonly");
		});
		$("#praise").mouseover(function(){
			toGray($("#bad"));
			toGray($("#commonly"));
			notGray($("#praise"));
			$("#grade").val("praise");
		});
		$("#star_star11").mouseover(function(){
			$("#level").val("1");
			$("#star_star21").text("☆");
			$("#star_star31").text("☆");
			$("#star_star41").text("☆");
			$("#star_star51").text("☆");
		});
		$("#star_star21").mouseover(function(){
			$("#level").val("2");
			$("#star_star21").text("★");
			$("#star_star31").text("☆");
			$("#star_star41").text("☆");
			$("#star_star51").text("☆");
		});
		$("#star_star31").mouseover(function(){
			$("#level").val("3");
			$("#star_star21").text("★");
			$("#star_star31").text("★");
			$("#star_star41").text("☆");
			$("#star_star51").text("☆");
		});
		$("#star_star41").mouseover(function(){
			$("#level").val("4");
			$("#star_star21").text("★");
			$("#star_star31").text("★");
			$("#star_star41").text("★");
			$("#star_star51").text("☆");
		});
		$("#star_star51").mouseover(function(){
			$("#level").val("5");
			$("#star_star21").text("★");
			$("#star_star31").text("★");
			$("#star_star41").text("★");
			$("#star_star51").text("★");
		});
		
		$("#star_star12").mouseover(function(){
			$("#attitude").val("1");
			$("#star_star22").text("☆");
			$("#star_star32").text("☆");
			$("#star_star42").text("☆");
			$("#star_star52").text("☆");
		});
		$("#star_star22").mouseover(function(){
			$("#attitude").val("2");
			$("#star_star22").text("★");
			$("#star_star32").text("☆");
			$("#star_star42").text("☆");
			$("#star_star52").text("☆");
		});
		$("#star_star32").mouseover(function(){
			$("#attitude").val("3");
			$("#star_star22").text("★");
			$("#star_star32").text("★");
			$("#star_star42").text("☆");
			$("#star_star52").text("☆");
		});
		$("#star_star42").mouseover(function(){
			$("#attitude").val("4");
			$("#star_star22").text("★");
			$("#star_star32").text("★");
			$("#star_star42").text("★");
			$("#star_star52").text("☆");
		});
		$("#star_star52").mouseover(function(){
			$("#attitude").val("5");
			$("#star_star22").text("★");
			$("#star_star32").text("★");
			$("#star_star42").text("★");
			$("#star_star52").text("★");
		});
		
		
		$("#star_star13").mouseover(function(){
			$("#quality").val("1");
			$("#star_star23").text("☆");
			$("#star_star33").text("☆");
			$("#star_star43").text("☆");
			$("#star_star53").text("☆");
		});
		$("#star_star23").mouseover(function(){
			$("#quality").val("2");
			$("#star_star23").text("★");
			$("#star_star33").text("☆");
			$("#star_star43").text("☆");
			$("#star_star53").text("☆");
		});
		$("#star_star33").mouseover(function(){
			$("#quality").val("3");
			$("#star_star23").text("★");
			$("#star_star33").text("★");
			$("#star_star43").text("☆");
			$("#star_star53").text("☆");
		});
		$("#star_star43").mouseover(function(){
			$("#quality").val("4");
			$("#star_star23").text("★");
			$("#star_star33").text("★");
			$("#star_star43").text("★");
			$("#star_star53").text("☆");
		});
		$("#star_star53").mouseover(function(){
			$("#quality").val("5");
			$("#star_star23").text("★");
			$("#star_star33").text("★");
			$("#star_star43").text("★");
			$("#star_star53").text("★");
		});
		
		$("#button").click(function(){
			if($("#grade").val()=="" || $("#grade").val()==null || $("#grade").val()=="undefined"){
				$("#message").text("您还没有选择好/中/差评！");
			}else if($("#level").val()=="" || $("#level").val()==null || $("#level").val()=="undefined"){
				$("#message").text("您还没有选择设计水平！");
			}else if($("#attitude").val()=="" || $("#attitude").val()==null || $("#attitude").val()=="undefined"){
				$("#message").text("您还没有选择服务态度！");
			}else if($("#quality").val()=="" || $("#quality").val()==null || $("#quality").val()=="undefined"){
				$("#message").text("您还没有选择施工质量！");
			}else if($("#texta").val()=="" || $("#texta").val()==null || $("#texta").val()=="undefined"){
				$("#message").text("您还没有输入评价！");
			}else{
				$("#form1").submit();
			}
		});
	});
	function notGray(ob){
		ob.css("-webkit-filter","grayscale(0%)");
		ob.css("-moz-filter","grayscale(0%)");
		ob.css("-ms-filter","grayscale(0%)");
		ob.css("-o-filter","grayscale(0%)");
		ob.css("filter","grayscale(0%)");
	}
	function toGray(ob){
		ob.css("-webkit-filter","grayscale(100%)");
		ob.css("-moz-filter","grayscale(100%)");
		ob.css("-ms-filter","grayscale(100%)");
		ob.css("-o-filter","grayscale(100%)");
		ob.css("filter","grayscale(100%)");
		ob.css("filter","gray");
	}
</script>
<style type="text/css">
	.content{
		text-align: center;
		height: 500px;
		width:300px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 150px;
		margin-bottom: 100px;
	}
	.grade{
		height: 70px;
	}
	.grade_all{
		margin-left:10px;
		float:left;
		width: 80px;
		color:#666;
	}
	.grade_img{
		display:block;
		width: 40px;
		height:40px;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 5px;
		-webkit-filter: grayscale(100%);
		-moz-filter: grayscale(100%); 
		-ms-filter: grayscale(100%); 
		-o-filter: grayscale(100%); 
		filter: grayscale(100%);
		filter: gray;
	}
	.grade_inp{
		width: 16px;
		height:16px;
		cursor: pointer;
	}
	.star{
		margin-top:20px;
		height: 80px;
		width: 300px;
		color:#666;
	}
	.star_all{
		margin-bottom:5px;
		height: 20px;
		margin-left:20px;
		text-align: left;
	}
	.star_text{
		margin-left: 5px;
	}
	.star_starAll{
		cursor: pointer;
	}
	.star_star{
		margin-left: 5px;
		color:#fab329;
	}
	.texta{
		margin-top:20px;
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
	  	<form name="form1" id="form1" action="${pageContext.request.contextPath }/servlet/SendCommentServlet" method="post">
	  		<span id="message" class="message"></span>
	  		<input id="grade" type="hidden" name="grade">
	  		<input id="level" type="hidden" name="level">
	  		<input id="attitude" type="hidden" name="attitude">
	  		<input id="quality" type="hidden" name="quality">
	  		<input type="hidden" name="com_id" value="${com_id}">
	  		<input type="hidden" name="ord_id" value="${ord_id}">
	  		<input type="hidden" name="type" value="do">
		  	<div class="grade">
		  		<div class="grade_all">
		  			<img id="praise" class="grade_img" alt="praise" src="${pageContext.request.contextPath }/images/static/comment/praise.jpg">
		  			好评
		  		</div>
		  		<div class="grade_all">
		  			<img id="commonly" class="grade_img" alt="commonly" src="${pageContext.request.contextPath }/images/static/comment/commonly.jpg">
		  			中评
		  		</div>
				<div class="grade_all">
		  			<img id="bad" class="grade_img" alt="bad" src="${pageContext.request.contextPath }/images/static/comment/bad.jpg">
		  			差评
				</div>
		  	</div>
	  		<div class="star">
	  			<div class="star_all">
	  				<span class="star_text">设计水平:</span>
	  				<span class="star_starAll">
		  				<span id="star_star11" class="star_star">★</span>
		  				<span id="star_star21" class="star_star">☆</span>
		  				<span id="star_star31" class="star_star">☆</span>
		  				<span id="star_star41" class="star_star">☆</span>
		  				<span id="star_star51" class="star_star">☆</span>
	  				</span>
	  			</div>
	  			<div class="star_all">
	  				<span class="star_text">服务态度:</span>
	  				<span class="star_starAll">
		  				<span id="star_star12" class="star_star">★</span>
		  				<span id="star_star22" class="star_star">☆</span>
		  				<span id="star_star32" class="star_star">☆</span>
		  				<span id="star_star42" class="star_star">☆</span>
		  				<span id="star_star52" class="star_star">☆</span>
	  				</span>
	  			</div>
	  			<div class="star_all">
	  				<span class="star_text">施工质量:</span>
	  				<span class="star_starAll">
		  				<span id="star_star13" class="star_star">★</span>
		  				<span id="star_star23" class="star_star">☆</span>
		  				<span id="star_star33" class="star_star">☆</span>
		  				<span id="star_star43" class="star_star">☆</span>
		  				<span id="star_star53" class="star_star">☆</span>
	  				</span>
	  			</div>
			</div>
	  		<textarea class="texta" name="comment" id="texta" placeholder="输入您的评价" required></textarea>
	  		<div class="button">
				<button type="button" class="login-btn register-btn" id="button">提交评价</button>
			</div>
	  	</form>
	  	
  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
