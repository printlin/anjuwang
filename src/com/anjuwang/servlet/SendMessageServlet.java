package com.anjuwang.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Message;
import com.anjuwang.bean.Owner;
import com.anjuwang.service.MessageService;

public class SendMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SendMessageServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String where=request.getParameter("where");
		String com_id=request.getParameter("com_id");
		String question=request.getParameter("question");
		String whereJump="";
		Object ob=request.getSession(false).getAttribute("owner");
		if(com_id==null || "".equals(com_id)){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else if(ob==null){
			request.getSession().setAttribute("oldURL", "/servlet/SendMessageServlet?type=show&com_id="+com_id);
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
		}else if(type.equals("do")){
			if(where==null ||"".equals(where)){
				whereJump=request.getContextPath()+"/servlet/CompanyServlet?com_id="+com_id;
			}else if(where.equals("owner")){
				whereJump=request.getContextPath()+"/servlet/OwnerServlet";
			}
			if(question==null || "".equals(question)){
				response.sendRedirect(request.getContextPath()+"/servlet/SendMessageServlet?type=show&com_id="+com_id);
			}else{
				Owner owner=(Owner)ob;
				Message message=new Message();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=sf.format(new Date());
				message.setOw_id(owner.getOw_id());
				message.setCom_id(com_id);
				message.setQuestion(question);
				message.setTime(time);
				MessageService ms=new MessageService();
				if(ms.addThis(message)){
					response.sendRedirect(request.getContextPath()+"/servlet/MessageServlet?message="+URLEncoder.encode("提交问题成功，请等待回复。", "utf-8")+"&url="+whereJump);
				}else{
					response.sendRedirect(whereJump);
				}
			}
			
		}else if(type.equals("show")){
			request.setAttribute("com_id", com_id);
			request.setAttribute("where", where);
			request.getRequestDispatcher("/sendMessage.jsp").forward(request, response);
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
