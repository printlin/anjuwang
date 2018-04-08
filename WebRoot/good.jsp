<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'good.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/good.css">
	

  </head>
  
  <body>
  	<div class="all">
        <div class="orderTitle">请填写订单信息</div>
        <div class="orderInfo">
        	<div class="orderRow">
            	<span class="orderText1">颜色：</span>
                <ul class="floatLeftUl">
                	<li><span class="orderText2 ${fn:indexOf(good.color,'白色')>-1?'show':'noShow' }">白色</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.color,'黑色')>-1?'show':'noShow' }">黑色</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.color,'红色')>-1?'show':'noShow' }">红色</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.color,'黄色')>-1?'show':'noShow' }">黄色</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.color,'绿色')>-1?'show':'noShow' }">绿色</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.color,'蓝色')>-1?'show':'noShow' }">蓝色</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.color,'粉色')>-1?'show':'noShow' }">粉色</span></li>
                </ul>
            </div>
            <div class="orderRow">
            	<span class="orderText1">尺寸：</span>
                <ul class="floatLeftUl">
                	<li><span class="orderText2 ${fn:indexOf(good.size,'37')>-1?'show':'noShow' }">37</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'38')>-1?'show':'noShow' }">38</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'39')>-1?'show':'noShow' }">39</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'40')>-1?'show':'noShow' }">40</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'41')>-1?'show':'noShow' }">41</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'42')>-1?'show':'noShow' }">42</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'43')>-1?'show':'noShow' }">43</span></li>
                    <li><span class="orderText2 ${fn:indexOf(good.size,'44')>-1?'show':'noShow' }">44</span></li>
                </ul>
            </div>
            <div class="orderRow">
            	<span class="orderText1">售价:</span>
                <span class="orderPrace">${good.good_prace }</span>
                <a href="shoppingCart.jsp"><span class="orderJoin">加入购物车</span></a>
                <a href="pay.jsp"><span class="orderBuy">立即购买</span></a>
            </div>
            <div class="clear"></div>
        </div>
        <div>
        	<div class="floatLeft"><img class="orderImg" src="images/static/lizi1.jpg"></div>
            <div class="floatLeft orderInfoStatic">
                <div class="orderRow">
                    <span class="orderText1">品名：</span>
                    <span class="orderText3">${good.good_name }</span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">品牌：</span>
                    <span class="orderText3">${good.good_type }</span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">销量：</span>
                    <span class="orderText3">${good.good_count }</span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">简介：</span>
                    <span class="orderText4">${good.good_desc }</span>
                </div>
            </div>
            <div class="clear"></div>
        </div>
	</div>
  </body>
</html>
