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

import com.anjuwang.bean.Manager;
import com.anjuwang.service.ManagerService;

@WebServlet("/servlet/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String chackCode_c=request.getParameter("chackCode");
		Object s_chackCodeOb=request.getSession().getAttribute("chackCode");
		PrintWriter out=response.getWriter();
		if(s_chackCodeOb==null){
			out.print("服务器生成验证码错误！<a href='../managerLogin.jsp'>返回</a>");
		}else{
			String chackCode_s=(String)s_chackCodeOb;
			if(!chackCode_s.equals(chackCode_c)){
				out.print("验证码错误！<a href='../managerLogin.jsp'>返回</a>");
				return;
			}
		}
		
		ManagerService ms=new ManagerService();
		Manager man=ms.login(username, password);
		if(man!=null){
			request.getSession().setAttribute("manager", man);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=sf.format(new Date());
			man.setLastLoginTime(time);
			ms.updateThis(man);
			response.sendRedirect("CompanyManagerServlet?com_id="+man.getCom_id());
		}else{
			out.print("用户名或密码错误！<a href='../managerLogin.jsp'>返回</a>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
