package com.anjuwang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Message;
import com.anjuwang.bean.Order;
import com.anjuwang.service.MessageService;
import com.anjuwang.service.OrderService;


@WebServlet("/CompanyManagerDoServlet")
public class CompanyManagerDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CompanyManagerDoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		PrintWriter out=response.getWriter();
		String com_id="1";
		boolean isSuccess=false;
		if(type==null || "".equals(type)){
			out.print("操作类型为空  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
			return;
		}
		if(type.equals("audit")){
			String ord_id=request.getParameter("ord_id");
			String isPass=request.getParameter("isPass");
			if(ord_id==null || "".equals(ord_id)){
				out.print("未能获取到订单id  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			if(isPass==null || "".equals(isPass)){
				out.print("未能获取到审核信息  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			OrderService os=new OrderService();
			Order order=new Order();
			order.setOrd_id(ord_id);
			order=os.selectThis(order);
			if(isPass.equals("true")){
				order.setState("accept");
			}
			if(isPass.equals("false")){
				order.setState("refuse");
			}
			isSuccess=os.updateThis(order);
		}else if(type.equals("message")){
			String mes_id=request.getParameter("mes_id");
			String answer=request.getParameter("answer");
			if(mes_id==null || "".equals(mes_id)){
				out.print("未能获取到消息id  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			if(answer==null || "".equals(answer)){
				out.print("未能获取到回复信息  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			MessageService ms=new MessageService();
			Message mess=new Message();
			mess.setMes_id(mes_id);
			mess=ms.selectThis(mess);
			mess.setAnswer(answer);
			isSuccess=ms.updateThis(mess);
		}else if(type.equals("state")){
			String ord_id=request.getParameter("ord_id");
			String state=request.getParameter("state");
			if(ord_id==null || "".equals(ord_id)){
				out.print("未能获取到订单id  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			if(state==null || "".equals(state)){
				out.print("未能获取到审核信息  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			OrderService os=new OrderService();
			Order order=new Order();
			order.setOrd_id(ord_id);
			order=os.selectThis(order);
			order.setState(state);
			isSuccess=os.updateThis(order);
		}else if(type.equals("report")){
			String ord_id=request.getParameter("ord_id");
			String report=request.getParameter("report");
			if(ord_id==null || "".equals(ord_id)){
				out.print("未能获取到订单id  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			if(report==null || "".equals(report)){
				out.print("未能获取到进度信息  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
				return;
			}
			OrderService os=new OrderService();
			Order order=new Order();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=sf.format(new Date());
			order.setOrd_id(ord_id);
			order=os.selectThis(order);
			order.setReport(report);
			order.setReportTime(time);
			isSuccess=os.updateThis(order);
		}
		if(isSuccess){
			response.sendRedirect("CompanyManagerServlet?com_id="+com_id);
		}else{
			out.print("保存到数据库失败  <a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
