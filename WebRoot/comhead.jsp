<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/headAndBottom.css">
<div class="comhead">
	<div class="comheadbody">
		<a href="servlet/HomeServlet?place=all&page=1" title="回到首页"><img src="images/static/logo.png"></a>
		<div class="comhead_right">
			<c:choose>
				<c:when test="${empty sessionScope.owner}">
					<a href="#">登录</a>
					<a href="#">注册</a>
				</c:when>
				<c:otherwise>
					<img alt="头像" src="images/static/head.jpg" class="comhead_img">
					<a href="#">昵称</a>
					<a href="#">注销</a>
				</c:otherwise>
			</c:choose>
			服务热线：010——1199268
		</div>
	</div>
</div>