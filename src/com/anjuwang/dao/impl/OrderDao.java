package com.anjuwang.dao.impl;

import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Order;
import com.anjuwang.common.DBUtil;


public class OrderDao {
	public boolean deleteThis(Order bean){
		String sql="delete from `order` where ord_id=?";
		Object[] ob=new Object[]{bean.getOrd_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean addThis(Order bean){
		String sql="insert into `order` (ow_id,com_id,`address`,`area`,`explain`,`phone`,`state`,`time`,`report`,`reportTime`,`surname`,`price`) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] ob=new Object[]{bean.getOw_id(),bean.getCom_id(),bean.getAddress(),bean.getArea(),bean.getExplain(),bean.getPhone(),bean.getState(),bean.getTime(),bean.getReport(),bean.getReportTime(),bean.getSurname(),bean.getPrice()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean updateThis(Order bean){
		String sql="update `order` set ow_id=?,com_id=?,`address`=?,`area`=?,`explain`=?,`phone`=?,`state`=?,`time`=?,`report`=?,`reportTime`=?,`surname`=?,`price`=? where ord_id=?";
		Object[] ob=new Object[]{bean.getOw_id(),bean.getCom_id(),bean.getAddress(),bean.getArea(),bean.getExplain(),bean.getPhone(),bean.getState(),bean.getTime(),bean.getReport(),bean.getReportTime(),bean.getSurname(),bean.getPrice(),bean.getOrd_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public Order selectThis(Order bean){
		Order[] beanA=null;
		String sql="select * from `order` where ord_id=?";
		Object[] ob=new Object[]{bean.getOrd_id()};
		beanA=full(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	
	public Order selectDetailThis(Order bean){
		Order[] beanA=null;
		String sql="select * from `order` where ord_id=?";
		Object[] ob=new Object[]{bean.getOrd_id()};
		beanA=fullDetail(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	
	public Order[] selectAll(int start,int length){
		Order[] beanA=null;
		String sql="select * from `order`  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	public Order[] selectAllByOw_ID(String ow_id,int start,int length){
		String sql="select * from `order` where ow_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{ow_id,start,length};
		return full(DBUtil.executeQuery(sql, od));
	}
	public Order[] selectAllByCom_ID(String com_id,int start,int length){
		Order[] beanA=null;
		String sql="select * from `order` where com_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	public Order[] selectAllDetail(int start,int length){
		Order[] beanA=null;
		String sql="select * from `order`  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{start,length};
		beanA=fullDetail(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	public Order[] selectAllDetailByOw_ID(String ow_id,int start,int length){
		Order[] beanA=null;
		String sql="select * from `order` where ow_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{ow_id,start,length};
		beanA=fullDetail(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	public Order[] selectAllDetailByCom_ID(String com_id,int start,int length){
		Order[] beanA=null;
		String sql="select * from `order` where com_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=fullDetail(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	public Order[] selectAllDetailByCom_IDShow(String com_id,int start,int length){
		Order[] beanA=null;
		String sql="select * from `order` where com_id=? and report='success'  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=fullDetail(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	public Order[] selectNewByCom_ID(String com_id,int start,int length){
		Order[] beanA=null;
		String sql="select * from `order` where com_id=? and state='audit'  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	public Order[] selectGoingByCom_ID(String com_id,int start,int length){
		Order[] beanA=null;
		String sql="select * from `order` where com_id=? and not(state='audit' or state='refuse' or state='termination')  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	private Order[] fullDetail(List<Map<String,String>> list){
		Order[] beanA=null;
		OwnerDao od=new OwnerDao();
		CommentDao cd=new CommentDao();
		if(list!=null && list.size()>0){
			beanA=new Order[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Order bean=new Order();
				bean.setAddress(map.get("address"));
				bean.setArea(map.get("area"));
				bean.setCom_id(map.get("com_id"));
				bean.setOrd_id(map.get("ord_id"));
				bean.setOw_id(map.get("ow_id"));
				bean.setExplain(map.get("explain"));
				bean.setPhone(map.get("phone"));
				bean.setState(map.get("state"));
				bean.setTime(map.get("time"));
				bean.setReportTime(map.get("reportTime"));
				bean.setSurname(map.get("surname"));
				bean.setReport(map.get("report"));
				bean.setPrice(map.get("price"));
				bean.setComment(cd.selectByOrd_id(map.get("ord_id")));
				bean.setOwner(od.selectByOw_id(map.get("ow_id")));
				beanA[i]=bean;
			}
		}
		return beanA;
	}
	
	private Order[] full(List<Map<String,String>> list){
		Order[] beanA=null;
		if(list!=null && list.size()>0){
			beanA=new Order[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Order bean=new Order();
				bean.setAddress(map.get("address"));
				bean.setArea(map.get("area"));
				bean.setCom_id(map.get("com_id"));
				bean.setOrd_id(map.get("ord_id"));
				bean.setOw_id(map.get("ow_id"));
				bean.setExplain(map.get("explain"));
				bean.setPhone(map.get("phone"));
				bean.setState(map.get("state"));
				bean.setTime(map.get("time"));
				bean.setReportTime(map.get("reportTime"));
				bean.setSurname(map.get("surname"));
				bean.setReport(map.get("report"));
				bean.setPrice(map.get("price"));
				beanA[i]=bean;
			}
			return beanA;
		}else{
			return null;
		}
	}
}
