package com.anjuwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Company;
import com.anjuwang.dao.ICompanyDao;
import com.anjuwang.dao.impl.CompanyDao;
import com.anjuwang.service.CompanyService;
import com.anjuwang.service.MessageService;
import com.anjuwang.service.OrderService;


public class CompanyManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CompanyManagerServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICompanyDao icd=new CompanyDao();
		CompanyService cs=new CompanyService();
		OrderService os=new OrderService();
		MessageService ms=new MessageService();
		String com_id=request.getParameter("com_id");
		Company com=icd.getCompanyForId(com_id);
		com=cs.linkData(com);
		request.setAttribute("company", com);
		request.setAttribute("newOrder", os.selectNewByCom_ID(com_id, 0, 6));
		request.setAttribute("newMessage", ms.selectNewByCom_ID(com_id, 0, 6));
		request.setAttribute("goingOrder", os.selectGoingByCom_ID(com_id, 0, 6));
		request.getSession().setAttribute("oldURL","/servlet/CompanyManagerServlet?com_id="+com_id);
		request.getRequestDispatcher("/companyManager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
