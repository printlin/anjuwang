package com.anjuwang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Order;
import com.anjuwang.bean.Owner;
import com.anjuwang.service.OrderService;


@WebServlet("/servlet/SendOrderDataServlet")
public class SendOrderDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SendOrderDataServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ord_id=request.getParameter("ord_id");
		String type=request.getParameter("type");
		Object ob=request.getSession(false).getAttribute("owner");
		Owner owner=null;
		if(ob==null){
			request.getSession().setAttribute("oldURL", "/servlet/SendOrderDataServlet?type="+type+"&ord_id="+ord_id);
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
			return;
		}else{
			owner=(Owner)ob;
		}
		PrintWriter out=response.getWriter();
		if(ord_id==null || "".equals(ord_id)){
			out.print("未获取到ord_id");
			return;
		}
		if(type==null || "".equals(type)){
			out.print("未获取到type");
			return;
		}
		if(type.equals("state")){
			String state=request.getParameter("state");
			OrderService os=new OrderService();
			Order order=new Order();
			order.setOrd_id(ord_id);
			order=os.selectThis(order);
			order.setState(state);
			if(os.updateThis(order)){
				response.sendRedirect(request.getContextPath()+"/servlet/MessageServlet?message="+URLEncoder.encode("进度信息修改成功。", "utf-8")+"&url="+request.getContextPath()+"/servlet/OwnerServlet?ow_id="+owner.getOw_id());
				return;
			}else{
				out.print("保存失败");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
