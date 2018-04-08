package com.anjuwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anjuwang.bean.OrderAndCompany;
import com.anjuwang.bean.Owner;
import com.anjuwang.service.OwnerService;




public class OwnerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public OwnerServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object object=session.getAttribute("owner");
		if(object!=null){
			Owner owner=(Owner)object;
			OwnerService os=new OwnerService();
			if(owner.getOw_id()!=null){
				owner=os.linkData(owner);
				OrderAndCompany[] oacA=os.getOrdAndCom(owner.getOw_id());
				request.setAttribute("ownerData", owner);
				request.setAttribute("orderAndCompany", oacA);
				session.setAttribute("oldURL","/owner.jsp");
				request.getRequestDispatcher("/owner.jsp").forward(request, response);
				return;
			}else{
				session.setAttribute("oldURL","/index.jsp");
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}else{
			session.setAttribute("oldURL","/index.jsp");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
