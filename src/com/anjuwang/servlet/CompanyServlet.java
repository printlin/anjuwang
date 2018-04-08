package com.anjuwang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Company;
import com.anjuwang.bean.CompanyImage;
import com.anjuwang.dao.ICompanyDao;
import com.anjuwang.dao.IImage;
import com.anjuwang.dao.impl.CompanyDao;
import com.anjuwang.dao.impl.ImageDao;
import com.anjuwang.service.CompanyService;


public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CompanyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IImage iimg=new ImageDao();
		ICompanyDao icd=new CompanyDao();
		CompanyService cs=new CompanyService();
		String com_id=request.getParameter("com_id");
		CompanyImage comimg=iimg.getCompanyImages(com_id);
		Company com=icd.getCompanyForId(com_id);
		com=cs.linkData(com);
		request.setAttribute("companyimg", comimg);
		request.setAttribute("company", com);
		request.getSession().setAttribute("oldURL","/servlet/CompanyServlet?com_id="+com_id);
		request.getRequestDispatcher("/company.jsp").forward(request, response);
	}

}
