<%@page import="com.anjuwang.bean.Company"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
    
    <title>安居网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/company.css">
	<script src="js/company.js"></script>
  </head>
  
  <body>
  	<jsp:include page="comhead.jsp"></jsp:include>
  	<div class="widfloat">
  		<p><a href="${pageContext.request.contextPath}/servlet/SendMessageServlet?type=show&com_id=${requestScope.company.com_id}" title="在线咨询">在线咨询</a></p>
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
  			<a href="servlet/HomeServlet?place=all&page=1">首页</a><a>公司介绍</a><a>成功案例</a><a>业主点评</a>
  	</div>
  	<div class="banner_score">
  		<div class="banner">
  			<div id="bannerbod">
  				<input type="hidden" value="3" id="bannernum"/>
  				<img alt="木有加载出来" src="images/static/combanner1.jpg" id="banner1"><img alt="" src="images/static/combanner2.jpg"><img alt="" src="images/static/combanner3.jpg">
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
  				<a href="${pageContext.request.contextPath}/servlet/SendMessageServlet?type=show&com_id=${requestScope.company.com_id}">免费咨询</a>
  				咨询热线：<span>${requestScope.company.getHotline() }</span>,已有<span>${requestScope.company.getInquiry() }</span>人咨询
  			</p>
  		</div>
  		<dir class="clears"></dir>
  	</div>
  	<div class="case">
  		<p>成功案例<a>更多></a></p>
  		<div>
  			<ul>
  				<c:forEach begin="1" end="3" step="1">
	  				<li>
	  					<img alt="" src="images/static/anli1.jpg">
	  					<p><span class="home">唐先生的新家</span><span class="priceandtime">2.83万</span><span class="priceandtime">2017/2/3</span></p>
	  				</li>
  				</c:forEach>
  				<div class="clears"></div>
  			</ul>
  		</div>
  	</div>
  	<div class="evaluates">
  		<p>业主点评<a>更多></a></p>
  		<div>
  			<ul>
  			</ul>
  		</div>
  	</div>
  	<jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
