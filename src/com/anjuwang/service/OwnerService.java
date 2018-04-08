package com.anjuwang.service;


import com.anjuwang.bean.Company;
import com.anjuwang.bean.Order;
import com.anjuwang.bean.OrderAndCompany;
import com.anjuwang.bean.Owner;
import com.anjuwang.dao.impl.CommentDao;
import com.anjuwang.dao.impl.CompanyDao;
import com.anjuwang.dao.impl.MessageDao;
import com.anjuwang.dao.impl.OrderDao;
import com.anjuwang.dao.impl.OwnerDao;


public class OwnerService {
	OwnerDao od=null;
	Owner owner=null;
	public OwnerService(){
		od=new OwnerDao();
		owner=new Owner();
	}
	public Owner login(String username,String password){
		owner.setPhomenumber(username);
		owner.setPassword(password);
		Owner ow=od.selectThis(owner);
		if(ow!=null && ow.getOw_id()!=null){
			ow=linkData(ow);
			return ow;
		}else{
			return null;
		}
	}
	public Owner linkData(Owner owner){
		if(owner.getOw_id()!=null){
			MessageDao md=new MessageDao();
			OrderDao od=new OrderDao();
			owner.setOrders(od.selectAllByOw_ID(owner.getOw_id(),0,6));
			owner.setMessages(md.selectAllByOw_ID(owner.getOw_id(),0,6));
		}
		return owner;
	}
	public OrderAndCompany[] getOrdAndCom(String ow_id){
		if(ow_id!=null && !"".equals(ow_id)){
			OrderDao od=new OrderDao();
			CommentDao cmd=new CommentDao();
			CompanyDao cd=new CompanyDao();
			Order[] oa=od.selectAllByOw_ID(ow_id,0,6);
			if(oa!=null && oa.length>0){
				OrderAndCompany[] oacA=new OrderAndCompany[oa.length];
				Company com=new Company();
				for(int i=0;i<oa.length;i++){
					OrderAndCompany oac=new OrderAndCompany();
					oa[i].setComment(cmd.selectByOrd_id(oa[i].getOrd_id()));
					com.setCom_id(oa[i].getCom_id());
					oac.setCompany(cd.selectThis(com));
					oac.setOrder(oa[i]);
					oacA[i]=oac;
				}
				return oacA;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	public boolean addThis(Owner owner){
		return od.addThis(owner);
	}
	public boolean findByPhomenumber(String phomenumber){
		return od.findByPhomenumber(phomenumber);
	}
	public boolean updateThis(Owner owner){
		return od.updateThis(owner);
	}
}
