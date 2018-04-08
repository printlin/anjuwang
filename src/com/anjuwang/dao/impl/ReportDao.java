package com.anjuwang.dao.impl;

import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Report;
import com.anjuwang.common.DBUtil;



public class ReportDao {
	public boolean deleteThis(Report bean){
		String sql="delete from `report` where rep_id=?";
		Object[] ob=new Object[]{bean.getRep_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean addThis(Report bean){
		String sql="insert into `report` (ord_id,`explain`,`time`) values (?,?,?)";
		Object[] ob=new Object[]{bean.getOrd_id(),bean.getExplain(),bean.getTime()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean updateThis(Report bean){
		String sql="update `report` set ord_id=?,`explain`=?,`time`=? where rep_id=?";
		Object[] ob=new Object[]{bean.getOrd_id(),bean.getExplain(),bean.getTime(),bean.getRep_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public Report selectThis(Report bean){
		Report[] beanA=null;
		String sql="select * from `report` where rep_id=?";
		Object[] ob=new Object[]{bean.getRep_id()};
		beanA=full(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	public Report[] selectAll(){
		Report[] beanA=null;
		String sql="select * from `report`";
		beanA=full(DBUtil.executeQuery(sql, null));
		return beanA;
	}
	
	private Report[] full(List<Map<String,String>> list){
		Report[] beanA=null;
		if(list!=null && list.size()>0){
			beanA=new Report[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Report bean=new Report();
				bean.setRep_id(map.get("rep_id"));
				bean.setOrd_id(map.get("ord_id"));
				bean.setExplain(map.get("explain"));
				bean.setTime(map.get("time"));
				beanA[i]=bean;
			}
		}
		return beanA;
	}
}
