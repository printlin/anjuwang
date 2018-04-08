package com.anjuwang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Owner;
import com.anjuwang.common.WebUtil;
import com.anjuwang.formBean.RegistFormBean;
import com.anjuwang.service.OwnerService;



public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistFormBean registForm=WebUtil.requestToBean(request, RegistFormBean.class);//将参数获取包装到对象中
		HashMap<String,String> mes=registForm.chack();//调用检查 方法，验证信息是否有误
		PrintWriter out = response.getWriter();
		if(mes.size()<=0){
			Object s_chackCodeOb=request.getSession().getAttribute("chackCode");
			if(s_chackCodeOb!=null){
				String s_chackCode=(String) s_chackCodeOb;
				String c_chackCode=request.getParameter("chackCode");
				if(c_chackCode==null){
					mes.put("chackCode", "*验证码不能为空");
				}else if(!c_chackCode.equals(s_chackCode)){
					mes.put("chackCode", "*验证码错误");
				}else{//所有验证通过
					if(request.getParameter("type")!=null && request.getParameter("type").equals("submit")){//如果是点击提交
						Owner owner=new Owner();
						OwnerService os=new OwnerService();
						owner=WebUtil.registFormBeanToOwner(registForm);
						if(os.addThis(owner)){
							mes.put("susses", "注册成功");
							System.out.println("注册成功："+registForm.getPhomenumber());
						}else{
							mes.put("addError","添加到数据库失败");
						}
					}
				}
			}else{
				mes.put("chackCode", "*服务器生成验证码失败,请重试");
			}
		}
		out.print(WebUtil.mapToJson(mes));
		
		/*
		OwnerDao od=new OwnerDao();
		HashMap<String,String> messageMap=new HashMap<String, String>();
		String head=request.getParameter("head");
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		String phomenumber=request.getParameter("phomenumber");
		String c_registChackCode=request.getParameter("chackCode");
		String s_registChackCode=(String) request.getSession(false).getAttribute("chackCode");
		if(c_registChackCode!=null && nickname !=null && nickname.length()<13 && password !=null && password.length()>5 && password.length()<17 && phomenumber !=null && phomenumber.length()==11){
			owner.setNickname(nickname);
			owner.setPassword(password);
			owner.setPhomenumber(phomenumber);
			owner.setHead(head);
			if(s_registChackCode!=null && c_registChackCode.equals(s_registChackCode)){
				if(od.registJudge(phomenumber)){
					if(od.addThis(owner)){
						messageMap.put("susses", "恭喜您，注册成功！");
					}else{
						out.print("注册失败（添加到数据库失败），3秒后跳转，立即<a href='/zhw/regist.jsp'>跳转</a>");
				    	response.setHeader("refresh", "3;url=/zhw/regist.jsp");
				    	return;
					}
				}else{
					out.print("注册失败（该电话号码已注册），3秒后跳转，立即<a href='/zhw/regist.jsp'>跳转</a>");
			    	response.setHeader("refresh", "3;url=/zhw/regist.jsp");
			    	return;
				}
			}else{
				out.print("注册失败（验证码输入错误），3后跳转，立即<a href='/zhw/regist.jsp'>跳转</a>");
		    	response.setHeader("refresh", "3秒;url=/zhw/regist.jsp");
		    	return;
			}
			
		}else{
			out.print("注册失败（键入格式错误），3秒后跳转，立即<a href='/zhw/regist.jsp'>跳转</a>");
	    	response.setHeader("refresh", "3;url=/zhw/regist.jsp");
	    	return;
		}*/
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
