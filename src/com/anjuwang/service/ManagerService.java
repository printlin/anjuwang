package com.anjuwang.service;

import com.anjuwang.bean.Manager;
import com.anjuwang.dao.impl.ManagerDao;

public class ManagerService {
	ManagerDao md=null;
	Manager manager=null;
	public ManagerService(){
		md=new ManagerDao();
		manager=new Manager();
	}
	public Manager login(String username,String password){
		manager.setUsername(username);
		manager.setPassword(password);
		Manager ma=md.selectThis(manager);
		if(ma!=null && ma.getMag_id()!=null){
			ma=linkData(ma);
			return ma;
		}else{
			return null;
		}
	}
	public Manager linkData(Manager manager){
		/*if(manager.getMag_id()!=null){
			MessageDao md=new MessageDao();
			OrderDao od=new OrderDao();
			manager.setOrders(od.selectAllByOw_ID(manager.getMag_id(),0,6));
			manager.setMessages(md.selectAllByOw_ID(manager.getMag_id(),0,6));
		}*/
		return manager;
	}
	public boolean findByUsername(String phomenumber){
		return md.findByUsername(phomenumber);
	}
	public boolean updateThis(Manager manager){
		return md.updateThis(manager);
	}
}
