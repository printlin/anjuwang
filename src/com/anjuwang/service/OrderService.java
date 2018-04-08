package com.anjuwang.service;

import com.anjuwang.bean.Order;
import com.anjuwang.dao.impl.OrderDao;

public class OrderService {
	OrderDao od=null;
	Order order=null;
	public OrderService(){
		od=new OrderDao();
		order=new Order();
	}
	public boolean addThis(Order order){
		return od.addThis(order);
	}
	public boolean updateThis(Order order){
		return od.updateThis(order);
	}
	public Order selectThis(Order order){
		return od.selectThis(order);
	}
	public boolean deleteThis(Order order){
		return od.deleteThis(order);
	}
	public Order[] selectNewByCom_ID(String com_id,int start,int length){
		return od.selectNewByCom_ID(com_id,start,length);
	}
	public Order[] selectGoingByCom_ID(String com_id,int start,int length){
		return od.selectGoingByCom_ID(com_id,start,length);
	}
}
