package com.anjuwang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anjuwang.bean.Owner;
import com.anjuwang.service.OwnerService;



public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req; 
		HttpServletResponse response = (HttpServletResponse) resp; 
		Cookie[] cookies=request.getCookies();
		HttpSession session=request.getSession();
		if(session.getAttribute("noAutoLogin")==null ){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("isLogin")){
					String[] str=cookie.getValue().split("&");
					String phomenumber=str[0];
					String password=str[1];
					OwnerService os=new OwnerService();
					Owner owner=os.linkData(os.login(phomenumber, password));
					if(owner!=null){
						session.setAttribute("owner", owner);
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
