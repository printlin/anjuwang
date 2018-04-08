package com.anjuwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUIServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginUIServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldURL=(String)request.getSession(false).getAttribute("oldURL");
		if(request.getSession(false).getAttribute("owner")!=null){
			if(oldURL!=null){
				response.sendRedirect(request.getContextPath()+oldURL);
			}else{
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			
		}else{
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
