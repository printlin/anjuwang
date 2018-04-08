package com.anjuwang.dao;

import java.util.List;
import com.anjuwang.bean.*;

public interface ICompanyDao {
	public boolean addCompany(Company company);//增加公司
	public boolean updataCompany(String companyId);//根据公司id修改公司
	public boolean deleteCompany(String companyId);//根据公司id删除公司
	public boolean deleteCompanyByName(String companyName);//根据公司名字删除公司
	public Company getCompanyForId(String com_id);//根据Id获取公司
	public List<Company> getAllCompany();//得到所有公司
	public int getAllCompanyNum();//获取所有公司的数量
	public List<Company> getAllCompany(int start,int lenth);//得到所有公司的从第start个起后lenth个
	public List<Company> getPlaceCompany(String place);//获取指定地区的公司
	public int getPlaceCompanyNum(String place);//获取指定公司的数量
	public List<Company> getPlaceCompany(String place,int start,int lenth);//获取指定地区的公司从第start个起后lenth个
	public boolean deleteThis(Company bean);
	public boolean addThis(Company bean);
	public boolean updateThis(Company bean);
	public Company selectThis(Company bean);
	public Company[] selectAll();
	public Company[] selectByName(String name);
}
