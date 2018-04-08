<%@ page language="java" import="java.util.*,com.anjuwang.bean.Owner,com.anjuwang.bean.Order,com.anjuwang.bean.Message,com.anjuwang.bean.Comment,com.anjuwang.bean.Report" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'owner.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  	if(session.getAttribute("owner")==null){
  		response.sendRedirect("/zhw/servlet/LoginUIServlet?oldURL=/zhw/owner.jsp");
  		return;
  	}
  %>
  	业主信息：
	 <table border="1" width="1200px">
    	<tr>
    		<td>业主id</td>
    		<td>电话号码</td>
    		<td>称谓</td>
    		<td>头像</td>
    	</tr>
	<%
		Owner owner=null;
		Object object=session.getAttribute("owner");
	 	if(object!=null){
	 		owner=(Owner)object;
	 		out.print("<tr>");
			out.print("<td>"+owner.getOw_id()+"</td>");
			out.print("<td>"+owner.getPhomenumber()+"</td>");
			out.print("<td>"+owner.getNickname()+"</td>");
			out.print("<td>"+owner.getHead()+"</td>");
			out.print("</tr>");
	 	}
	%>
	</table>
	
	<br><br><br>
	订单信息：
	<table border="1" width="1200px">
    	<tr>
    		<td>订单id</td>
    		<td>业主id</td>
    		<td>公司id</td>
    		<td>面积</td>
    		<td>地址</td>
    		<td>电话号码</td>
    		<td>下单时间</td>
    		<td>订单状态</td>
    		<td>说明</td>
    		<td>查看进度</td>
    	</tr>
	<%
		Report report=null;
		Order[] orders=null;
		orders=owner.getOrders();
		if(orders!=null){
    		for(int i=0;i<orders.length;i++){
        		out.print("<tr>");
        		out.print("<td>"+orders[i].getOrd_id()+"</td>");
        		out.print("<td>"+orders[i].getOw_id()+"</td>");
        		out.print("<td>"+orders[i].getCom_id()+"</td>");
        		out.print("<td>"+orders[i].getArea()+"</td>");
        		out.print("<td>"+orders[i].getAddress()+"</td>");
        		out.print("<td>"+orders[i].getPhone()+"</td>");
        		out.print("<td>"+orders[i].getTime()+"</td>");
        		out.print("<td>"+orders[i].getState()+"</td>");
        		out.print("<td>"+orders[i].getExplain()+"</td>");
        		out.print("<td><a href='/anjuwang/servlet/SendCommentServlet?type=show&ord_id="+orders[i].getOrd_id()+"'>评价</a></td>");
        		/*if(report!=null&&report.getRep_id()!=null){
        			out.print("<td><a href='/anjuwang/servlet/SendCommentServlet?type=show&ord_id="+orders[i].getOrd_id()+"'>评价</a></td>");
        		}else{
        			out.print("<td></td>");
        		}*/
        		out.print("</tr>");
        	}
    	}
	%>
    </table>
    
    
    <br><br><br>
	消息信息：
	<table border="1" width="1200px">
    	<tr>
    		<td>消息id</td>
    		<td>业主id</td>
    		<td>公司id</td>
    		<td>问题</td>
    		<td>答复</td>
    		<td>已答复</td>
    		<td>已阅读</td>
    		<td>操作</td>
    	</tr>
	<%
		Message[] messages=null;
		messages=owner.getMessages();
		if(messages!=null){
    		for(int i=0;i<messages.length;i++){
        		out.print("<tr>");
        		out.print("<td>"+messages[i].getMes_id()+"</td>");
        		out.print("<td>"+messages[i].getOw_id()+"</td>");
        		out.print("<td>"+messages[i].getCom_id()+"</td>");
        		out.print("<td>"+messages[i].getQuestion()+"</td>");
        		out.print("<td>"+messages[i].getAnswer()+"</td>");
        		out.print("<td>"+messages[i].getIs_answer()+"</td>");
        		out.print("<td>"+messages[i].getIs_read()+"</td>");
        		if(messages[i].getIs_answer()!=null && messages[i].getIs_answer().equals("false")){//未回复
        			out.print("<td><a href='/zhw/servlet/SendMessageServlet?mes_id="+messages[i].getMes_id()+"'>回复</a></td>");
        		}else{
        			out.print("<td>-</td>");
        		}
        		out.print("</tr>");
        	}
    	}
	%>
    </table>
    
    
    <br><br><br>
	评论信息：
	<table border="1" width="1200px">
    	<tr>
    		<td>评论id</td>
    		<td>业主id</td>
    		<td>订单id</td>
    		<td>内容</td>
    		<td>评论时间</td>
    		<td>等级</td>
    		<td>设计水平</td>
    		<td>服务态度</td>
    		<td>施工质量</td>
    	</tr>
	<%
		Comment[] comments=null;
		comments=owner.getComments();
		if(comments!=null){
    		for(int i=0;i<comments.length;i++){
        		out.print("<tr>");
        		out.print("<td>"+comments[i].getCmt_id()+"</td>");
        		out.print("<td>"+comments[i].getOw_id()+"</td>");
        		out.print("<td>"+comments[i].getOrd_id()+"</td>");
        		out.print("<td>"+comments[i].getComment()+"</td>");
        		out.print("<td>"+comments[i].getTime()+"</td>");
        		out.print("<td>"+comments[i].getGrade()+"</td>");
        		out.print("<td>"+comments[i].getLevel()+"</td>");
        		out.print("<td>"+comments[i].getAttitude()+"</td>");
        		out.print("<td>"+comments[i].getQuality()+"</td>");
        		out.print("</tr>");
        	}
    	}
	%>
    </table>
  </body>
</html>
