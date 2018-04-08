<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公司管理页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	 <link rel="stylesheet" href="css/imgUpload/amazeui.min.css">
     <link rel="stylesheet" href="css/imgUpload/amazeui.cropper.css">
     <link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<style type="text/css">
	table{ border: 1px solid black;width: 1200px;margin-top:50px;margin-left: auto;margin-right: auto;}
	td{ border: 1px solid #0f88eb;}
</style>
<script type="text/javascript">
	var progress;
	var uploadProcessTimer = null;
	
	function formSubmit() {
		uploadProcessTimer = window.setInterval("getFileUploadProcess()", 100); //每隔100毫秒执行callback 
		if($(".show").width()=='100%'){
			document.forms[0].submit();
		}
	}
	function getFileUploadProcess() {
		$.ajax({
			type : "GET",
			url : "/zhw/servlet/UploadRateServlet",
			dataType : "text",
			cache : false,
			success : function(data) {
				if (data == "100%") {
					window.clearInterval(uploadProcessTimer);
				} else {
					progress = data;
					$(".show").width(data);
					$(".msg").text(data);
				}
			}
		});
	};
	function imgClick(who,com_id){
		window.location.href="servlet/UploadImgServlet?com_id="+com_id+"&who="+who+"&type=show";
	}
	$(function(){
	})
	
</script>
  </head>
  
  <body>
  	<jsp:include page="head.jsp"></jsp:include>
  	<table>
  		<tr>
			<td>
				公司logo
			</td>
			<td>
  				<img onclick="imgClick('hand',${company.com_id})" style="width: 200px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.hand }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
			</td>
			<td>
				公司简介
			</td>
			<td>
				<textarea rows="5" cols="60">${company.profile }</textarea>
				<input type="button" id="profileButton" value="修改">
			</td>
  		</tr>
  		<tr>
  			<td>
  				公司简介图
  			</td>
  			<td>
  				<img onclick="imgClick('img1',${company.com_id})" style="width: 300px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.img1 }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
  			</td>
  			<td>
  				<img onclick="imgClick('img2',${company.com_id})" style="width: 300px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.img2 }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
  			</td>
  			<td>
  				<img onclick="imgClick('img3',${company.com_id})" style="width: 300px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.img3 }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				公司案例图
  			</td>
  			<td>
  				<img onclick="imgClick('orderImg1',${company.com_id})" style="width: 300px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.orderImg1 }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
  			</td>
  			<td>
  				<img onclick="imgClick('orderImg2',${company.com_id})" style="width: 300px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.orderImg2 }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
  			</td>
  			<td>
  				<img onclick="imgClick('orderImg3',${company.com_id})" style="width: 300px;height: 200px;margin: 10px 10px;border: 1px solid #d6d6d6;" src="${company.orderImg3 }" data-am-popover="{content: '点击修改', trigger: 'hover focus'}">
  			</td>
  		</tr>
  	</table>
  	<table id="audit">
  		<tr>
  			<td colspan="8">待接受订单</td>
  		</tr>
  		<tr>
  			<td>订单id</td>
  			<td>业主id</td>
  			<td>业主称谓</td>
  			<td>地址</td>
  			<td>面积</td>
  			<td>联系电话</td>
  			<td>状态</td>
  			<td>审核</td>
  		</tr>
  		<c:forEach var="order" items="${newOrder }">
  			<tr>
  				<td>${order.ord_id }</td>
  				<td>${order.ow_id }</td>
  				<td>${order.surname }</td>
  				<td>${order.address }</td>
  				<td>${order.area }</td>
  				<td>${order.phone }</td>
  				<td>
	  				<c:choose>
						<c:when test="${order.state=='audit'}">待审核</c:when>
						<c:when test="${order.state=='refuse'}">拒绝</c:when>
						<c:when test="${order.state=='accept'}">受理</c:when>
						<c:when test="${order.state=='acceptance'}">验收</c:when>
						<c:when test="${order.state=='termination'}">终止</c:when>
						<c:when test="${order.state=='request_acceptance'}">请求验收</c:when>
						<c:when test="${order.state=='request_termination'}">请求终止</c:when>
				  	</c:choose>
			  	</td>
  				<td>
  					<form action="servlet/CompanyManagerDoServlet" method="post">
	  					<input type="hidden" name="ord_id" value="${order.ord_id}">
	  					<input type="hidden" name="type" value="audit">
	  					<input type="radio" name="isPass" value="true">通过
	  					<input type="radio" name="isPass" value="false">拒绝
	  					<input type="submit" value="确定">
  					</form>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  	
  	<table>
  		<tr>
  			<td colspan="8">待回复咨询</td>
  		</tr>
  		<tr>
  			<td>消息id</td>
  			<td>业主id</td>
  			<td>咨询内容</td>
  			<td>回复</td>
  		</tr>
  		<c:forEach var="message" items="${newMessage }">
  			<tr>
  				<td>${message.mes_id }</td>
  				<td>${message.ow_id }</td>
  				<td>${message.question }</td>
  				<td id="messageAll">
  					<form action="servlet/CompanyManagerDoServlet" method="post">
	  					<input type="hidden" name="mes_id" value="${message.mes_id}">
	  					<input type="hidden" name="type" value="message">
	  					<input type="text" name="answer" placeholder="输入您的答复">
	  					<input type="submit" value="回复">
  					</form>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  	
  	<table>
  		<tr>
  			<td colspan="8">进行中订单</td>
  		</tr>
  		<tr>
  			<td>订单id</td>
  			<td>业主id</td>
  			<td>业主称谓</td>
  			<td>地址</td>
  			<td>面积</td>
  			<td>联系电话</td>
  			<td>发布状态</td>
  			<td>发布进度</td>
  		</tr>
  		<c:forEach var="order" items="${goingOrder }">
  			<tr>
  				<td>${order.ord_id }</td>
  				<td>${order.ow_id }</td>
  				<td>${order.surname }</td>
  				<td>${order.address }</td>
  				<td>${order.area }</td>
  				<td>${order.phone }</td>
  				<td>
  					<form action="servlet/CompanyManagerDoServlet" method="post">
	  					<input type="hidden" name="ord_id" value="${order.ord_id}">
	  					<input type="hidden" name="type" value="state">
	  					<select name="state">
	  						<option value="accept" ${order.state=='accept'?'selected':'' }>受理</option>
	  						<option value="acceptance" ${order.state=='acceptance'?'selected':'' }>验收</option>
	  						<option value="request_acceptance" ${order.state=='request_acceptance'?'selected':'' }>请求验收</option>
	  						<option value="request_termination" ${order.state=='request_termination'?'selected':'' }>请求终止</option>
	  					</select>
	  					<input type="submit" value="确定">
  					</form>
  				</td>
  				<td>
  					<form action="servlet/CompanyManagerDoServlet" method="post">
	  					<input type="hidden" name="ord_id" value="${order.ord_id}">
	  					<input type="hidden" name="type" value="report">
	  					<select name="report">
	  						<option value="准备" ${order.report=='准备'?'selected':'' }>准备</option>
	  						<option value="水电" ${order.report=='水电'?'selected':'' }>水电</option>
	  						<option value="地板" ${order.report=='地板'?'selected':'' }>地板</option>
	  						<option value="木工" ${order.report=='木工'?'selected':'' }>木工</option>
	  						<option value="漆工" ${order.report=='漆工'?'selected':'' }>漆工</option>
	  						<option value="安装" ${order.report=='安装'?'selected':'' }>安装</option>
	  						<option value="完工" ${order.report=='完工'?'selected':'' }>完工</option>
	  					</select>
	  					<input type="submit" value="确定">
  					</form>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  	
  	<jsp:include page="bottom.jsp"></jsp:include>

  </body>
</html>
