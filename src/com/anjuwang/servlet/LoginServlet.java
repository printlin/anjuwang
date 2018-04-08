package com.anjuwang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anjuwang.bean.Owner;
import com.anjuwang.common.WebUtil;
import com.anjuwang.formBean.LoginFormBean;
import com.anjuwang.service.OwnerService;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldURL=(String)request.getSession(false).getAttribute("oldURL");
		LoginFormBean loginForm=WebUtil.requestToBean(request, LoginFormBean.class);//将参数获取包装到对象中
		HashMap<String,String> mes=loginForm.chack();//调用检查 方法，验证信息是否有误
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		if(mes.size()<=0){
			Object s_chackCodeOb=request.getSession().getAttribute("chackCode");
			if(s_chackCodeOb!=null){
				String s_chackCode=(String) s_chackCodeOb;
				String c_chackCode=loginForm.getChackCode();
				if(c_chackCode==null){
					mes.put("chackCode", "*验证码不能为空");
				}else if(!c_chackCode.equals(s_chackCode)){
					mes.put("chackCode", "*验证码错误");
				}else{//所有验证通过
					if(request.getParameter("type")!=null && request.getParameter("type").equals("submit")){//如果是点击提交
						OwnerService os=new OwnerService();
						Owner owner=os.login(loginForm.getPhomenumber(), loginForm.getPassword());
						if(owner!=null){
							session.setAttribute("owner", owner);
							if(loginForm.getRemember().equals("true")){
								Cookie cookie=new Cookie("isLogin",loginForm.getPhomenumber()+"&"+loginForm.getPassword());
								cookie.setMaxAge(60*60*24*7);//保存七天
								cookie.setPath("/");
								response.addCookie(cookie);
							}
							mes.put("susses", "登录成功");
							System.out.println("登录成功："+loginForm.getPhomenumber());
							mes.put("oldURL", oldURL);
						}else{
							mes.put("loginError", "用户名或密码错误");
						}
						
					}
				}
			}else{
				mes.put("chackCode", "*服务器生成验证码失败,请重试");
			}
		}
		out.print(WebUtil.mapToJson(mes));
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Owner owner=new Owner();
		OwnerDao od=new OwnerDao();
		HttpSession session=request.getSession();
		PrintWriter out= response.getWriter();
		String mes="";
		String s_chackCode=(String) session.getAttribute("chackCode");
		String c_chackCode=(String) request.getParameter("chackCode");
		owner.setPhomenumber(request.getParameter("phomenumber"));
		owner.setPassword(request.getParameter("password"));
		System.out.println("phomenumber="+request.getParameter("phomenumber")+"&password="+request.getParameter("password"));
		if(s_chackCode!=null && c_chackCode!=null && s_chackCode.equals(c_chackCode)){
			if(od.loginJudge(owner)){
			session.setAttribute("owner", od.getOwner());
			mes="success";
			}else{
				mes="密码或用户名错误";
			}
		}else{
			mes="验证码错误";
		}
		out.print(mes);*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
