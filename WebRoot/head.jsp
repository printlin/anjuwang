<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/headAndBottom.css">
<div class="head">
	<div class="head_body">
		<a href="servlet/HomeServlet?place=all&page=1"><img alt="安居网" src="images/static/logo.png" title="首页" class="logo"></a>
		<!--form action="#">
			<div class="serch">
				<input type="text" name="serch" placeholder="搜索装修公司" class="text"/><input type="submit" value="搜索" class="submit"/>
			</div>
		</form-->
		<div class="body_right">
			<c:choose>
				<c:when test="${owner eq null}">
					<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet" class="body_a">登录</a>
					<a href="${pageContext.request.contextPath}/Register.jsp" class="body_a">注册</a>
				</c:when>
				<c:otherwise>
					<img alt="头像" src="${owner.head }" class="head_img">
					<a href="${pageContext.request.contextPath}/servlet/OwnerServlet" class="body_a">${owner.nickname }</a>
					<a href="${pageContext.request.contextPath}/servlet/LogoutServlet" class="body_a">注销</a>
				</c:otherwise>
			</c:choose>
			服务热线：010——1199268
		</div>
	</div>
	
</div>