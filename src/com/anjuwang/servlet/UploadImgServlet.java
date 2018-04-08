package com.anjuwang.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.anjuwang.bean.Company;
import com.anjuwang.common.UploadListener;
import com.anjuwang.service.CompanyService;



public class UploadImgServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UploadImgServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath="";
		String type=request.getParameter("type");
		PrintWriter out=response.getWriter();
		if(type!=null && type.equals("show")){
			HttpSession session =request.getSession();
			String com_id=request.getParameter("com_id");
			String who=request.getParameter("who");
			session.setAttribute("uploadCom_id", com_id);
			session.setAttribute("uploadWho", who);
			response.sendRedirect("../uploadImg.jsp");
			return;
		}else{
			HttpSession session =request.getSession();
			Object ob1=session.getAttribute("uploadCom_id");
			Object ob2=session.getAttribute("uploadWho");
			String com_id="";
			String who="";
			if(ob1==null){
				out.print("未获取到公司id");
				return;
			}
			if(ob2==null){
				out.print("未获取到操作对象");
				return;
			}
			com_id=(String) ob1;
			who=(String) ob2;
			// 为解析类提供配置信息
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建解析类的实例
			ServletFileUpload sfu = new ServletFileUpload(factory);
			UploadListener listener=new UploadListener(request);
			// 开始解析
			sfu.setProgressListener(listener);
			sfu.setFileSizeMax(1024 * 1024*20);//最大20m
			CompanyService cs=new CompanyService();
			Company com=new Company();
			com.setCom_id(com_id);
			com=cs.selectThis(com);
			// 每个表单域中数据会封装到一个对应的FileItem对象上
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = sfu.parseRequest(request);
				// 区分表单域
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					// isFormField为true，表示这不是文件上传表单域
					if (!item.isFormField()) {
						ServletContext sctx = getServletContext();
						// 获得存放文件的物理路径
						String srPath=sctx.getRealPath(sctx.getContextPath());//C:\apache-tomcat-8.5.11\webapps\anjuwang\anjuwang
						srPath=srPath.substring(0, srPath.lastIndexOf("\\"));//C:\apache-tomcat-8.5.11\webapps\anjuwang
						// 获得文件名
						String fileName = item.getName();
						String postfix=fileName.substring(fileName.lastIndexOf(".")+1);//后缀
						if("JPG JPEG GIF PNG BMP jpg jpeg gif png bmp".indexOf(postfix)!=-1){
							Date date=new Date();
							String time=date.getTime()+"";
							String dbPath="images\\company\\"+com.getCom_name()+"\\"+time+"."+postfix;//  images\company\天古装饰\1496973777803.jpg
							filePath=srPath+"\\"+dbPath;
							/*System.out.println("srPath:"+srPath);
							System.out.println("dbPath:"+dbPath);
							System.out.println("filePath:"+filePath);*/
							File file = new File(filePath);
							if (!file.exists()) {
								item.write(file);
								if(who.equals("hand")){
									deleteFile(srPath+"\\"+com.getHand());
									com.setHand(dbPath);
								}else if(who.equals("img1")){
									deleteFile(srPath+"\\"+com.getImg1());
									com.setImg1(dbPath);
								}else if(who.equals("img2")){
									deleteFile(srPath+"\\"+com.getImg2());
									com.setImg2(dbPath);
								}else if(who.equals("img3")){
									deleteFile(srPath+"\\"+com.getImg3());
									com.setImg3(dbPath);
								}else if(who.equals("orderImg1")){
									deleteFile(srPath+"\\"+com.getOrderImg1());
									com.setOrderImg1(dbPath);
								}else if(who.equals("orderImg2")){
									deleteFile(srPath+"\\"+com.getOrderImg2());
									com.setOrderImg2(dbPath);
								}else if(who.equals("orderImg3")){
									deleteFile(srPath+"\\"+com.getOrderImg3());
									com.setOrderImg3(dbPath);
								}
								if(cs.updateThis(com)){
									out.print("上传成功<a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
								}else{
									out.print("上传失败<a href='CompanyManagerServlet?com_id="+com_id+"'>返回</a>");
								}
							}
						}else{
							out.print("不支持该格式");
							return;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		
	}
	private boolean deleteFile(String filePath){
		if(filePath==null || "".equals(filePath)){
			return false;
		}
		File file=new File(filePath);
		if (file.exists() && file.isFile()) {//是文件且存在
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
	}
}
