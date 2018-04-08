package com.anjuwang.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anjuwang.bean.CompanyImage;
import com.anjuwang.bean.Image;
import com.anjuwang.common.MyDbUtil;
import com.anjuwang.dao.IImage;

public class ImageDao implements IImage {

	@Override
	public List<Image> getImages(String[] Com_id, String type) {
		// TODO Auto-generated method stub
		List<Image> images=new ArrayList<Image>();
		String coms="(-1";
		for(int i=0;i<Com_id.length;i++){
			coms=coms+","+String.valueOf(Com_id[i]);
		}
		coms=coms+")";
		List<Map<String, String>> imgs=MyDbUtil.executeQuery("SELECT * FROM images WHERE com_id IN "+coms+" AND TYPE=?", new Object[]{type});
		for(int a=0;a<imgs.size();a++){
			Image image=new Image();
			image.setCom_id(imgs.get(a).get("com_id"));
			image.setImg_id(imgs.get(a).get("img_id"));
			image.setType(imgs.get(a).get("type"));
			image.setUrl(imgs.get(a).get("url"));
			images.add(image);
		}
		return images;
	}

	
	@Override
	public CompanyImage getCompanyImages(String com_id) {//获取公司所有图片
		// TODO Auto-generated method stub
		CompanyImage images=new CompanyImage();
		images.setCom_id(com_id);
		List<Map<String, String>> imgs=MyDbUtil.executeQuery("SELECT * FROM images WHERE com_id=?", new Object[]{com_id});
		for(int i=0;i<imgs.size();i++){
			switch(imgs.get(i).get("type")){
			case "banner":images.setBanner(imgs.get(i).get("url"));break;
			case "logo":images.setLogo(imgs.get(i).get("url"));break;
			case "home_logo":images.setHome_logo(imgs.get(i).get("url"));break;
			case "body":images.setBody(imgs.get(i).get("url"));break;
			}
		}
		return images;
	}

}
