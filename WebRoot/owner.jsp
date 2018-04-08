<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业主页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/owner.css">
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
  	$(()=>{
  		$(".operation_no").attr('href','javascript:void(0);');
  	});
  	function imgClick(){
		window.location.href="ownerUploadHand.jsp";
	}
  </script>
  </head>
  
  <body>
  	<jsp:include page="head.jsp"></jsp:include>
  		<div class="body">
  			<div class="userif">
  				<p class="div_title">基本信息</p>
  				<div class="userif_l">
  					<div class="userif_l_top">
  						<img style="cursor:hand" onclick="imgClick()" src="${ownerData.head }">
  						<p>${ownerData.nickname }</p>
  						<span>︿</span>
  					</div>
  					<div>
  						<p class="set"><a href="changePwd.jsp">修改密码</a></p>
  					</div>
  				</div>
  				<div style="text-align: center;" class="userif_r">
					<span style="color:#b3b3b3;font-size: 50px;text-align: center;margin-top: 20px;display: inline-block;">欢迎您</span><br>
					<span style="color:#9a9a9a;font-size: 80px;text-align: center;">${ownerData.nickname  }</span>
					<div>
						
					</div>
				</div>
  				<div class="clears"></div>
  			</div>
  			
  			<div class="userif">
  				<p class="div_title">我的订单</p>
  				<c:forEach var="oac" items="${orderAndCompany}">
  				<p class="interval"></p>
	  				<div class="userif_l">
	  					<div class="userif_l_top">
	  						<img src="${oac.company.hand }">
	  						<p>${oac.company.com_name }</p>
	  						<span>︿</span>
	  					</div>
	  					<div class="contact">
	  						<p>联系电话：</p>
	  						<p>${oac.company.hotline }</p>
	  					</div>
	  				</div>
	  				<div class="userif_r">
	  					<p class="address">${oac.order.address }</p>
	  					<div class="sop">
	  						<!-- yes为完成状态 no为未完成状态 -->
	  						<div class="stage"><p>准备</p><p class="${fn:indexOf('准备-水电-地板-木工-漆工-安装-完工', oac.order.report)>-1?'yes':'on'}">●——</p></div>
	  						<div class="stage"><p>水电</p><p class="${fn:indexOf('水电-地板-木工-漆工-安装-完工', oac.order.report)>-1?'yes':'on'}">●——</p></div>
	  						<div class="stage"><p>地板</p><p class="${fn:indexOf('地板-木工-漆工-安装-完工', oac.order.report)>-1?'yes':'on'}">●——</p></div>
	  						<div class="stage"><p>木工</p><p class="${fn:indexOf('木工-漆工-安装-完工', oac.order.report)>-1?'yes':'on'}">●——</p></div>
	  						<div class="stage"><p>漆工</p><p class="${fn:indexOf('漆工-安装-完工', oac.order.report)>-1?'yes':'on'}">●——</p></div>
	  						<div class="stage"><p>安装</p><p class="${fn:indexOf('安装-完工', oac.order.report)>-1?'yes':'on'}">●——</p></div>
	  						<div class="stage"><p>完工</p><p class="${fn:indexOf('完工', oac.order.report)>-1?'yes':'on'}">●</p></div>
	  						<div class="clears"></div>
	  					</div>
	  					<div class="oder_inf">
	  						<div>
		  						<p>订单编号：${oac.order.ord_id }</p>
		  						<p>创建时间：${oac.order.time }</p>
		  						<p>上次发布：<c:choose><c:when test="${oac.order.reportTime==null }">暂无动态</c:when><c:otherwise>${oac.order.reportTime}</c:otherwise></c:choose></p>
	  						</div>
	  						<div>
	  							<!-- 可选择操作按钮是否可操作，operation_yes是可操作样式，operation_no是不可操作样式 -->
	  							<a class="operation_yes" href="servlet/SendMessageServlet?type=show&where=owner&com_id=${oac.order.com_id }">发送消息</a>
	  							<a class="${oac.order.report=='完工' && oac.order.state!='termination'?'operation_yes':'operation_no' }" href="servlet/SendOrderDataServlet?type=state&state=termination&ord_id=${oac.order.ord_id }">确认成交</a>
	  							<a class="${oac.order.state=='termination' && oac.order.comment==null?'operation_yes':'operation_no' }" href="servlet/SendCommentServlet?type=show&ord_id=${oac.order.ord_id }">发表评论</a>
	  						</div>
	  						<div class="clears"></div>
	  					</div>
	  				</div>
	  				<div class="clears"></div>
  				</c:forEach>
  			</div>
  			
  			<div class="userif">
  				<p class="div_title">我的消息</p>
  				<div class="messages">
  					<c:forEach var="mess" items="${ownerData.messages }">
	  					<div class="message">
	  						<p><b>问：</b>${mess.question }<span class="time">${mess.time }</span></p>
	  						<p><b>答：</b>${mess.answer }</p>
	  					</div>
  					</c:forEach>
	  				<!--  <div class="flip">
						<c:choose>
							<c:when test="${requestScope.page==1}">
								<a>《上一页</a>
							</c:when>
							<c:otherwise>
								<a href="#">《上一页</a>
							</c:otherwise>
						</c:choose>
						1/3
						<c:choose>
							<c:when test="${requestScope.page==requestScope.pageNum}">
								<a>下一页》</a>
							</c:when>
							<c:otherwise>
								<a href="#">下一页》</a>
							</c:otherwise>
						</c:choose>
					</div>-->
  				</div>
  			</div>
  			
  		</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  	
  </body>
  
</html>
