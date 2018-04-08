package com.anjuwang.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Order;
import com.anjuwang.bean.Owner;
import com.anjuwang.service.OrderService;

public class SendOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SendOrderServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String com_id=request.getParameter("com_id");
		String city=request.getParameter("city");
		String county=request.getParameter("county");
		String detai=request.getParameter("detai");
		String area=request.getParameter("area");
		String phone=request.getParameter("phone");
		String xing=request.getParameter("xing");
		String gender=request.getParameter("gender");
		//System.out.println("type:"+type+"com_id:"+com_id+"city:"+city+"county:"+county+"detai:"+detai+"area:"+area+"phone:"+phone);
		Object ob=request.getSession(false).getAttribute("owner");
		if(com_id==null || "".equals(com_id)){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else if(ob==null){
			request.getSession().setAttribute("oldURL", "/servlet/SendOrderServlet?type=show&com_id="+com_id);
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
		}else if(type.equals("do")){
			if(city==null || "".equals(city) || county==null || "".equals(county) ||detai==null || "".equals(detai)
					||area==null || "".equals(area) || phone==null || "".equals(phone) || xing==null || "".equals(xing)){
				response.sendRedirect(request.getContextPath()+"/servlet/SendOrderServlet?type=show&com_id="+com_id);
			}else{
				Owner owner=(Owner)ob;
				Order order=new Order();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=sf.format(new Date());
				order.setOw_id(owner.getOw_id());
				order.setCom_id(com_id);
				order.setArea(area);
				order.setAddress(city+county+detai);
				order.setPhone(phone);
				order.setState("audit");
				order.setTime(time);
				order.setSurname(xing+gender);
				order.setReport("准备");
				OrderService os=new OrderService();
				if(os.addThis(order)){
					response.sendRedirect(request.getContextPath()+"/servlet/MessageServlet?message="+URLEncoder.encode("提交订单成功，请等待装修公司联系。", "utf-8")+"&url="+request.getContextPath()+"/servlet/CompanyServlet?com_id="+com_id);
				}else{
					response.sendRedirect(request.getContextPath()+"/servlet/CompanyServlet?com_id="+com_id);
				}
			}
			
		}else if(type.equals("show")){
			request.setAttribute("com_id", com_id);
			request.getRequestDispatcher("/sendOrder.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
