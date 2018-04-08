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
    
    <title>安居网</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<link rel="shortcut icon" type="image/x-icon" href="images/static/title_logo_03.png" media="screen" /> 
	<script src="js/canvas-particle.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/jquery.banner.js"></script>
	
  </head>
  
  <body>
  <jsp:include page="head.jsp"></jsp:include>
	<!--横幅-->
	<div class="banner">
		<ul class="banList">
			<li class="active"><img src="images/static/banner3.jpg" class="banner_img"/></li>
			<li><img src="images/static/83n58PICSeV_1024.jpg" class="banner_img"/></li>
			<li><img src="images/static/93G58PICbE9_1024.jpg" class="banner_img"/></li>
		</ul>
		<div class="fomW">
			<div class="jsNav">
				<a href="javascript:;" class="trigger current"></a>
				<a href="javascript:;" class="trigger"></a>
				<a href="javascript:;" class="trigger"></a>
			</div>
		</div>
	</div>
		
	<script type="text/javascript"> 
	$(function(){
		$(".banner").swBanner();
	});
	</script>
	<!--横幅 end-->
	
	<!-- 筛选 -->
	<div>
		<div class="screen">
			<span>区域：</span>
			<div class="place">
				<a href="servlet/HomeServlet?place=all&page=1">所有地区</a>
				<c:forEach items="${requestScope.places}" var="place">
					<c:choose>
						<c:when test="${requestScope.place eq place.get('place') }"><a style="display:inline-block;color: #f25618;margin-bottom: 8px;" href="servlet/HomeServlet?place=${place.get('place') }"><c:out value="${place.get('place')}"></c:out></a></c:when>
						<c:otherwise>
							<a href="servlet/HomeServlet?place=${place.get('place') }&page=1"><c:out value="${place.get('place')}"></c:out></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<!--  <div class="clears"></div>
			<span>价格：</span>
			<div class="Price">
				5万一下
			</div>-->
			<div class="clears"></div>
		</div>
	</div>
	<!-- 筛选end -->
	<!-- 公司列表 -->
	<div class="companys">
		<c:forEach items="${requestScope.companys}" var="company">
			<div class="company">
				<a href="servlet/CompanyServlet?com_id=${company.getCom_id() }"><img alt="${company.getCom_name() }" src="${company.hand }" class="home_logo" title="${company.getCom_name() }"></a>
				<div>
					<div style="width: 550px;">
						<div>
							<a href="servlet/CompanyServlet?com_id=${company.getCom_id() }" class="company_name"><c:out value="${company.getCom_name() }"></c:out></a>
							<p class="address"><c:out value="${company.getAddress()}"></c:out></p>
							<p class="authentica">
								<c:if test="${company.getAuthentica()[0] eq '1'}"><img alt="" src="images/static/ying.gif"></c:if>
								<c:if test="${company.getAuthentica()[1] eq '1'}"><img alt="" src="images/static/ren.gif"></c:if>
								<c:if test="${company.getAuthentica()[2] eq '1'}"><img alt="" src="images/static/hui.gif"></c:if>
							</p>
						</div>
						<div class="serverNum">
							<ul>
								<li>成交次数：<span><c:out value="${company.getTurnover() }"></c:out></span></li>
								<li>设计水平：<span><c:out value="${company.getLel() }"></c:out></span></li>
								<div class="clears"></div>
								<li>咨询次数：<span><c:out value="${company.getInquiry() }"></c:out></span></li>
								<li>服务态度：<span><c:out value="${company.getAtde() }"></c:out></span></li>
								<div class="clears"></div>
								<li>价格区间：<span><c:out value="${company.getPrice_min() }—${company.getPrice_max() }万"></c:out></span></li>
								<li>施工质量：<span><c:out value="${company.getQuty() }"></c:out></span></li>
								<div class="clears"></div>
							</ul>
						</div>
					</div>
					<div>
						<p>好 评 率：<span><c:out value="${company.getPrse() }"></c:out></span></p>
						<p>口 碑 值：<span><c:out value="${company.getReputation() }"></c:out></span></p>
						<p>推荐指数：
							<span>
								<c:forEach begin="1" end="${company.getWom() }" step="1">★</c:forEach><c:forEach begin="${company.getWom() }" end="4" step="1">☆</c:forEach>
							</span>
						</p>
						<a href="servlet/CompanyServlet?com_id=${company.getCom_id() }">详细信息>></a>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="flip">
			<c:choose>
				<c:when test="${requestScope.page==1}">
					<a>《上一页</a>
				</c:when>
				<c:otherwise>
					<a href="servlet/HomeServlet?place=all&page=${requestScope.page-1}">《上一页</a>
				</c:otherwise>
			</c:choose>
			${requestScope.page}/${requestScope.pageNum}
			<c:choose>
				<c:when test="${requestScope.page==requestScope.pageNum}">
					<a>下一页》</a>
				</c:when>
				<c:otherwise>
					<a href="servlet/HomeServlet?place=all&page=${requestScope.page+1}">下一页》</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- 公司列表end -->
	
  	<jsp:include page="bottom.jsp"></jsp:include>
  	
  </body>
</html>
