package com.anjuwang.common;


import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class UploadListener implements ProgressListener {
	private HttpSession session;  
    private long kiloBytes=-1;  
	public UploadListener(HttpServletRequest request) {

		this.session = request.getSession();
	}

	public void update(long PBytesRead, long PContentLength, int PItems) {
		Long KBytes = PBytesRead / 1024;
		if (kiloBytes == KBytes) {//如果没有发生改变则不执行
			return;
		}
		kiloBytes = KBytes;//记录当前长度

		double read = ((double) KBytes) / (PContentLength / 1024);// 获取上传进度的百分比

		NumberFormat nf = NumberFormat.getPercentInstance();

		session.setAttribute("uploadRate", nf.format(read));//保存到session方便获取

	}

}

