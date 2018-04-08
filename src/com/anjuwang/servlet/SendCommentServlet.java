package com.anjuwang.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anjuwang.bean.Comment;
import com.anjuwang.bean.Owner;
import com.anjuwang.service.CommentService;

public class SendCommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SendCommentServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String ord_id=request.getParameter("ord_id");
		Object ob=request.getSession(false).getAttribute("owner");
		if(ord_id==null || "".equals(ord_id)){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else if(ob==null){
			request.getSession().setAttribute("oldURL", "/servlet/SendCommentServlet?type=show&ord_id="+ord_id);
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
		}else if(type==null || "".equals(type)){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else if(type.equals("do")){
			String grade=request.getParameter("grade");
			String level=request.getParameter("level");
			String attitude=request.getParameter("attitude");
			String quality=request.getParameter("quality");
			String comment=request.getParameter("comment");
			if(grade==null || "".equals(grade) || level==null || "".equals(level) ||attitude==null || "".equals(attitude)
					||quality==null || "".equals(quality) ||comment==null || "".equals(comment)){
				response.sendRedirect(request.getContextPath()+"/servlet/SendCommnetServlet?type=show&ord_id="+ord_id);
			}else{
				Owner owner=(Owner)ob;
				Comment comm=new Comment();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=sf.format(new Date());
				comm.setOw_id(owner.getOw_id());
				comm.setOrd_id(ord_id);
				comm.setAttitude(attitude);
				comm.setComment(comment);
				comm.setGrade(grade);
				comm.setLevel(level);
				comm.setQuality(quality);
				comm.setTime(time);
				CommentService cs=new CommentService();
				if(cs.addThis(comm)){
					response.sendRedirect(request.getContextPath()+"/servlet/MessageServlet?message="+URLEncoder.encode("评价成功", "utf-8")+"&url="+request.getContextPath()+"/servlet/OwnerServlet?ow_id="+owner.getOw_id());
				}else{
					response.sendRedirect(request.getContextPath()+"/servlet/OwnerServlet?ow_id="+owner.getOw_id());
				}
			}
			
		}else if(type.equals("show")){
			request.setAttribute("ord_id", ord_id);
			request.getRequestDispatcher("/sendComment.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
