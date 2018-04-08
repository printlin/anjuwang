package com.anjuwang.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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

import com.anjuwang.bean.Owner;
import com.anjuwang.common.UploadListener;
import com.anjuwang.service.OwnerService;

public class UploadOwnerHandServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UploadOwnerHandServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath="";
		PrintWriter out=response.getWriter();
		HttpSession session =request.getSession();
		Object ob=session.getAttribute("owner");
		Owner owner=null;
		if(ob==null){
			request.getSession().setAttribute("oldURL", "/servlet/OwnerServlet");
			response.sendRedirect(request.getContextPath()+"/servlet/LoginUIServlet");
			return;
		}
		owner=(Owner) ob;
		// 为解析类提供配置信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析类的实例
		ServletFileUpload sfu = new ServletFileUpload(factory);
		UploadListener listener=new UploadListener(request);
		// 开始解析
		sfu.setProgressListener(listener);
		sfu.setFileSizeMax(1024 * 1024*20);//最大20m
		OwnerService os=new OwnerService();
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
						String dbPath="images\\owner\\"+time+"."+postfix;
						filePath=srPath+"\\"+dbPath;
						File file = new File(filePath);
						if (!file.exists()) {
							item.write(file);
							deleteFile(srPath+"\\"+owner.getHead());
							owner.setHead(dbPath);
							if(os.updateThis(owner)){//URLEncoder.encode(URLEncoder.encode(  , "utf-8"), "utf-8")
								response.sendRedirect(request.getContextPath()+"/servlet/MessageServlet?message="+URLEncoder.encode("上传头像成功","utf-8")+"&url="+request.getContextPath()+"/servlet/OwnerServlet");
							}else{
								response.sendRedirect(request.getContextPath()+"/servlet/OwnerServlet");
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
