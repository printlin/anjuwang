package com.anjuwang.service;

import com.anjuwang.bean.Company;
import com.anjuwang.dao.impl.CompanyDao;
import com.anjuwang.dao.impl.MessageDao;
import com.anjuwang.dao.impl.OrderDao;

public class CompanyService {
	Company company=null;
	CompanyDao cd=null;
	public CompanyService(){
		cd=new CompanyDao();
	}
	public boolean loginJudge(String username,String password){
		company.setAccounts(username);
		company.setPassword(password);
		Company com=cd.selectThis(company);
		if(com!=null && com.getCom_id()!=null){
			com=linkData(com);
			this.company=com;
			return true;
		}else{
			return false;
		}
	}
	public Company linkData(Company com){
		MessageDao md=new MessageDao();
		OrderDao od=new OrderDao();
		com=cd.selectThis(com);
		com.setOrders(od.selectAllDetailByCom_IDShow(com.getCom_id(),0,6));
		com.setMessages(md.selectAllByCom_IDShow(com.getCom_id(),0,6));
		return com;
	}
	public boolean updateThis(Company bean){
		return cd.updateThis(bean);
	}
	public Company selectThis(Company bean){
		return cd.selectThis(bean);
	}
}
