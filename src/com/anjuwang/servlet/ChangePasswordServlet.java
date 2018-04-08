package com.anjuwang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anjuwang.bean.Owner;
import com.anjuwang.service.OwnerService;

public class ChangePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChangePasswordServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session =request.getSession();
		Object ob=session.getAttribute("owner");
		Owner owner=null;
		if(ob==null){
			request.getSession().setAttribute("oldURL", "/changePwd.jsp");
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
			return;
		}
		owner=(Owner) ob;
		String oldP=request.getParameter("oldPassword");
		String newP=request.getParameter("newPassword");
		if(oldP==null || "".equals(oldP)){
			out.print("未能获取原密码<a href='/changePwd.jsp'>返回</a>");
			return;
		}
		if(newP==null || "".equals(newP)){
			out.print("未能获取新密码<a href='/changePwd.jsp'>返回</a>");
			return;
		}
		if(oldP.equals(owner.getPassword())){
			OwnerService os=new OwnerService();
			owner.setPassword(newP);
			if(os.updateThis(owner)){
				response.sendRedirect(request.getContextPath()+"/servlet/MessageServlet?message="+URLEncoder.encode("修改成功", "utf-8")+"&url="+request.getContextPath()+"/servlet/OwnerServlet");
			}else{
				out.print("保存到数据库失败");
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
