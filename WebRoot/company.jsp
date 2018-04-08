<%@page import="com.anjuwang.bean.Company"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公司页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/company.css">
	<script src="js/company.js"></script>
	<script type="text/javascript">
		function jump(who){
         window.location.hash = who;
		}
	</script>
  </head>
  
  <body>
  	<jsp:include page="head.jsp"></jsp:include>
	  	<div style="background: #fff;">
		  	<div class="widfloat">
		  		<p><a title="在线咨询" href="servlet/SendMessageServlet?type=show&com_id=${company.com_id }">在线咨询</a></p>
		  	</div>
		  	<div class="comtitle">
		  		<img alt="${requestScope.company.getCom_name() }" src="${requestScope.companyimg.getLogo() }" class="com_logo">
		  		<div class="comtitle_txt">
		  			<P>
		  				<span class="com_name">${requestScope.company.getCom_name() }</span><span class="reptn">口碑值 ${requestScope.company.getReputation() } </span>
		  			</P>
		  			<p class="authentica">
						<c:if test="${requestScope.company.getAuthentica()[0]=='1'}"><img alt="" src="images/static/ying.gif"></c:if>
						<c:if test="${requestScope.company.getAuthentica()[1]=='1'}"><img alt="" src="images/static/ren.gif"></c:if>
						<c:if test="${requestScope.company.getAuthentica()[2]=='1'}"><img alt="" src="images/static/hui.gif"></c:if>
					</p>
		  		</div>
		  		<div class="clears"></div>
		  	</div>
		  	<div class="nav">
		  			<div>
		  				<span><a href="servlet/HomeServlet?place=all&page=1">首页</a><a onclick="jump('#anli')">成功案例</a><a onclick="jump('#dianping')">业主点评</a><a onclick="jump('#wenda')">动态问答</a></span><a class="owner" href="servlet/SendOrderServlet?type=show&com_id=${company.com_id }">我要装修</a>
		  			</div>
		  	</div>
	  	</div>
	  	<div style="background: #fff;" class="banner_score">
	  		<div class="banner">
	  			<div id="bannerbod">
	  				<input type="hidden" value="3" id="bannernum"/>
	  				<img src="${company.img1 }" id="banner1">
	  				<img src="${company.img2 }">
	  				<img src="${company.img3 }">
	  				<div class="clears"></div>
	  			</div>
	  			<p>
	  				<c:forEach begin="1" end="3" step="1" var="num"><a id="point${num }" onclick="pointClick(${num})"></a></c:forEach>
	  			</p>
	  		</div>
	  		<div class="evaluateAndScore">
	  			<div class="evaluate">
	  				<p>业主评价</p>
	  				<ul>
	  					<li><a href="#">好评次数：<span>${requestScope.company.getPraise() }</span></a></li>
	  					<li><a href="#">中评次数：<span>${requestScope.company.getCommonly() }</span></a></li>
	  					<li><a href="#">差评次数：<span>${requestScope.company.getBad() }</span></a></li>
	  				</ul>
	  			</div>
	  			<div class="score">
		  			<p>动态评分</p>
		  			<ul>
		  				<li>
		  					<a href="#">
			  					设计水平
			  					<span>
				  					<c:choose>
				  						<c:when test="${requestScope.company.getLel()<=0.5 }"></c:when>
				  						<c:when test="${requestScope.company.getLel()<=1.0 }">★</c:when>
				  						<c:when test="${requestScope.company.getLel()<=1.5 }">★☆</c:when>
				  						<c:when test="${requestScope.company.getLel()<=2.0 }">★★</c:when>
				  						<c:when test="${requestScope.company.getLel()<=2.5 }">★★☆</c:when>
				  						<c:when test="${requestScope.company.getLel()<=3.0 }">★★★</c:when>
				  						<c:when test="${requestScope.company.getLel()<=3.5 }">★★★☆</c:when>
				  						<c:when test="${requestScope.company.getLel()<=4.0 }">★★★★</c:when>
				  						<c:when test="${requestScope.company.getLel()<=4.5 }">★★★★☆</c:when>
				  						<c:when test="${requestScope.company.getLel()<=5.0 }">★★★★★</c:when>
				  					</c:choose>
			  					</span>
			  					${requestScope.company.getLel()}
		  					</a>
		  				</li>
		  				<li>
		  					<a href="#">
			  					服务态度
			  					<span>
				  					<c:choose>
				  						<c:when test="${requestScope.company.getAtde()<=0.5 }"></c:when>
				  						<c:when test="${requestScope.company.getAtde()<=1.0 }">★</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=1.5 }">★☆</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=2.0 }">★★</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=2.5 }">★★☆</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=3.0 }">★★★</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=3.5 }">★★★☆</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=4.0 }">★★★★</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=4.5 }">★★★★☆</c:when>
				  						<c:when test="${requestScope.company.getAtde()<=5.0 }">★★★★★</c:when>
				  					</c:choose>
			  					</span>
			  					${requestScope.company.getAtde()}
		  					</a>
		  				</li>
		  				<li>
		  					<a href="#">
			  					施工质量
			  					<span>
				  					<c:choose>
				  						<c:when test="${requestScope.company.getQuty()<=0.5 }"></c:when>
				  						<c:when test="${requestScope.company.getQuty()<=1.0 }">★</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=1.5 }">★☆</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=2.0 }">★★</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=2.5 }">★★☆</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=3.0 }">★★★</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=3.5 }">★★★☆</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=4.0 }">★★★★</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=4.5 }">★★★★☆</c:when>
				  						<c:when test="${requestScope.company.getQuty()<=5.0 }">★★★★★</c:when>
				  					</c:choose>
			  					</span>
			  					${requestScope.company.getQuty()}
		  					</a>
		  				</li>
		  			</ul>
	  			</div>
	  			<div class="clears"></div>
	  			<div class="brief">
	  				<p>公司简介</p>
	  				<div>
	  					<c:choose>
	  						<c:when test="${fn:length(requestScope.company.getProfile())<=55 }">
	  							<c:out value="${requestScope.company.getProfile() }"></c:out>
	  						</c:when>
	  						<c:otherwise>
	  							<c:out value="${fn:substring(requestScope.company.getProfile(),0,55) }..."></c:out><a href="#">更多</a>
	  						</c:otherwise>
	  					</c:choose>
	  				</div>
	  			</div>
	  			<p class="hotline">
	  				<a href="servlet/SendMessageServlet?type=show&com_id=${company.com_id }">免费咨询</a>咨询热线：<span>${requestScope.company.getHotline() }</span>,已有<span>${requestScope.company.getInquiry() }</span>人咨询
	  			</p>
	  		</div>
	  		<dir class="clears"></dir>
	  	</div>
	  	<div style="background: #fff;" class="case">
	  		<p id="anli">成功案例</p>
	  		<div>
	  			<ul>
		  			<li>
		  				<img alt="" src="${company.orderImg1 }">
		  				<p>
		  				<span class="home">唐先生的新家</span>
		  				<span class="priceandtime">2.83万</span>
		  				<span class="priceandtime">2017/2/3</span>
		  				</p>
		  			</li>
	  				<li>
		  				<img alt="" src="${company.orderImg2 }">
		  				<p>
		  				<span class="home">李先生的新家</span>
		  				<span class="priceandtime">9.8万</span>
		  				<span class="priceandtime">2017/3/8</span>
		  				</p>
		  			</li>
		  			<li>
		  				<img alt="" src="${company.orderImg3 }">
		  				<p>
		  				<span class="home">游先生的新家</span>
		  				<span class="priceandtime">10.3万</span>
		  				<span class="priceandtime">2017/5/3</span>
		  				</p>
		  			</li>
	  				<div class="clears"></div>
	  			</ul>
	  		</div>
	  	</div>
	  	<div  style="background: #fff;" class="evaluates">
	  		<p id="dianping">业主点评</p>
	  		<div>
	  			<ul>
	  				<c:forEach var="order" items="${company.orders }">
		  				<li>
		  					<div class="evaluates_left">
		  						<p class="home">${order.surname}的新家</p>
		  						<p class="reas">${order.area }M²</p>
		  						<p class="mony">${order.price}元</p>
		  					</div>
		  					<div class="evaluates_right">
		  						<div>
		  							<span>业主评分</span>
		  							<span>
		  								设计：${order.comment.level}
			  							<b>
			  								<c:choose>
						  						<c:when test="${order.comment.level<=1.0 }">★</c:when>
						  						<c:when test="${order.comment.level<=2.0 }">★★</c:when>
						  						<c:when test="${order.comment.level<=3.0 }">★★★</c:when>
						  						<c:when test="${order.comment.level<=4.0 }">★★★★</c:when>
						  						<c:when test="${order.comment.level<=5.0 }">★★★★★</c:when>
				  							</c:choose>
			  							</b>
		  							</span>
		  							<span>
		  								施工：${order.comment.quality}
			  							<b>
			  								<c:choose>
						  						<c:when test="${order.comment.quality<=1.0 }">★</c:when>
						  						<c:when test="${order.comment.quality<=2.0 }">★★</c:when>
						  						<c:when test="${order.comment.quality<=3.0 }">★★★</c:when>
						  						<c:when test="${order.comment.quality<=4.0 }">★★★★</c:when>
						  						<c:when test="${order.comment.quality<=5.0 }">★★★★★</c:when>
				  							</c:choose>
			  							</b>
		  							</span>
		  							<span>
		  								服务：${order.comment.attitude}
			  							<b>
			  								<c:choose>
						  						<c:when test="${order.comment.attitude<=1.0 }">★</c:when>
						  						<c:when test="${order.comment.attitude<=2.0 }">★★</c:when>
						  						<c:when test="${order.comment.attitude<=3.0 }">★★★</c:when>
						  						<c:when test="${order.comment.attitude<=4.0 }">★★★★</c:when>
						  						<c:when test="${order.comment.attitude<=5.0 }">★★★★★</c:when>
				  							</c:choose>
			  							</b>
		  							</span>
		  							<p class="nick">${order.owner.nickname}</p>
		  						</div>
		  						<p class="evaluates_right_body">${order.comment.comment }</p>
		  						<p class="time">${order.comment.time }</p>
		  					</div>
		  					<div class="clears"></div>
		  				</li>
	  				</c:forEach>
	  			</ul>
	  		</div>
	  	</div>
	  	<div  style="background: #fff;" class="questions">
	  		<p id="wenda">问答动态</p>
	  		<div class="questions_body">
	  			<ul>
	  				<c:forEach var="message" items="${company.messages }">
		  				<li>
		  					<p><b>问：</b><span class="question">${message.question }？</span><span class="time">${message.time }</span></p>
		  					<p class="ansquer"><b>答：</b>${message.answer }</p>
		  				</li>
	  				</c:forEach>
	  			</ul>
	  		</div>
	  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
