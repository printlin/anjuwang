package com.anjuwang.dao;

import java.util.List;

import com.anjuwang.bean.CompanyImage;
import com.anjuwang.bean.Image;

public interface IImage {
	public List<Image> getImages(String Com_id[],String type);//根据公司ID集合找公司类型图片
	public CompanyImage getCompanyImages(String com_id);//获取公司所有图片
}
