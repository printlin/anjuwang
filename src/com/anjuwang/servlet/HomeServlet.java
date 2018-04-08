package com.anjuwang.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Company;
import com.anjuwang.bean.Image;
import com.anjuwang.common.MyDbUtil;
import com.anjuwang.dao.ICompanyDao;
import com.anjuwang.dao.IImage;
import com.anjuwang.dao.impl.CompanyDao;
import com.anjuwang.dao.impl.ImageDao;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException  {
		// TODO Auto-generated method stub
		
		List<Map<String, String>> rs=MyDbUtil.executeQuery("SELECT DISTINCT(place) FROM region",null);
		
		int pageNum=0;
		int page=Integer.valueOf(request.getParameter("page"));
		int number=5;
		
		ICompanyDao companydao=new CompanyDao();
		List<Company> coms;
		if(request.getParameter("place").equals("all")){
			pageNum=companydao.getAllCompanyNum();
			coms=companydao.getAllCompany((page-1)*number,number);
		}else{
			pageNum=companydao.getPlaceCompanyNum(request.getParameter("place"));
			coms=companydao.getPlaceCompany(request.getParameter("place"),(page-1)*number,number);
		}
		pageNum=(int) Math.ceil((double)pageNum/(double)number);
		String[] com_id=new String[coms.size()];
		for(int i=0;i<coms.size();i++){
			com_id[i]=coms.get(i).getCom_id();
		}
		List<Image> imgs;
		Map<String, String> images=new HashMap<String, String>();
		IImage img=new ImageDao();
		imgs=img.getImages(com_id, "logo");
		for(int a=0;a<imgs.size();a++){
			images.put(String.valueOf(imgs.get(a).getCom_id()), imgs.get(a).getUrl());
		}
		request.setAttribute("images", images);
		request.setAttribute("companys", coms);
		request.setAttribute("places", rs);
		request.setAttribute("place", request.getParameter("place"));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("page", page);
		request.setAttribute("number", number);
		request.getSession().setAttribute("oldURL","/index.jsp");
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}


}
