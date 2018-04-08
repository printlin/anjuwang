package com.anjuwang.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.anjuwang.bean.Owner;
import com.anjuwang.formBean.RegistFormBean;



public class WebUtil {
	public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
		try{
			T bean=beanClass.newInstance();
			@SuppressWarnings("rawtypes")
			Enumeration e=request.getParameterNames();
			while(e.hasMoreElements()){
				String name=(String)e.nextElement();
				String value=request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public static Owner registFormBeanToOwner(RegistFormBean registForm){
		Owner owner=new Owner();
		owner.setPhomenumber(registForm.getPhomenumber());
		owner.setPassword(registForm.getPassword());
		owner.setNickname(registForm.getNickname());
		owner.setHead("images/static/notHave.jpg");
		return owner;
	}
	public static String mapToJson(HashMap<String,String> map){
		StringBuffer json=new StringBuffer();
		json.append("{");
		for(Map.Entry<String,String> entry:map.entrySet()){//循环遍历  构造json
			json.append("\"");
			json.append(entry.getKey());
			json.append("\":\"");
			json.append(entry.getValue());
			json.append("\",");
		}
		json.append("\"1\":\"1\"}");//由于结尾会多一个逗号，所以多加一行
		return json.toString();
	}
}
