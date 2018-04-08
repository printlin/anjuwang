package com.anjuwang.dao.impl;


import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Owner;
import com.anjuwang.common.DBUtil;

public class OwnerDao {
	Owner ow;
	public OwnerDao(){
	
	}
	public boolean loginJudge(Owner owner){
		String sql="select * from owner where phomenumber=? and password=?";
		Object[] ob=new Object[]{owner.getPhomenumber(),owner.getPassword()};
		Owner[] ownerA = fullOwner(DBUtil.executeQuery(sql, ob));
		if(ownerA!=null && ownerA.length>0){
			this.ow = ownerA[0];
			return true;
		}
		return false;
	}
	public boolean findByPhomenumber(String phomenumber){
		String sql="select * from owner where phomenumber=?";
		Object[] ob=new Object[]{phomenumber};
		List<Map<String,String>> list=DBUtil.executeQuery(sql, ob);
		if(list==null || !(list.size()>0)){
			return false;
		}
		return true;
	}
	public boolean deleteThis(Owner owner){
		String sql="delete from owner where ow_id=?";
		Object[] ob=new Object[]{owner.getOw_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean addThis(Owner owner){
		if(!findByPhomenumber(owner.getPhomenumber())){
			String sql="insert into owner (phomenumber,nickname,head,password) values (?,?,?,?)";
			Object[] ob=new Object[]{owner.getPhomenumber(),owner.getNickname(),owner.getHead(),owner.getPassword()};
			return DBUtil.executeUpdate(sql, ob);
		}else{
			return false;
		}
		
	}
	public boolean updateThis(Owner owner){
		String sql="update owner set phomenumber=?,nickname=?,head=?,password=? where ow_id=?";
		Object[] ob=new Object[]{owner.getPhomenumber(),owner.getNickname(),owner.getHead(),owner.getPassword(),owner.getOw_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public Owner selectThis(Owner owner){
		Owner[] ownerA=null;
		if(owner.getOw_id()==null){
			if(owner.getPhomenumber()!=null && owner.getPassword()!=null){
				String sql="select * from owner where phomenumber=? and password=?";
				Object[] ob=new Object[]{owner.getPhomenumber(),owner.getPassword()};
				ownerA=fullOwner(DBUtil.executeQuery(sql, ob));
				if(ownerA!=null && ownerA.length>0){
					return ownerA[0];
				}
			}
		}else{
			String sql="select * from owner where ow_id=?";
			Object[] ob=new Object[]{owner.getOw_id()};
			ownerA=fullOwner(DBUtil.executeQuery(sql, ob));
			if(ownerA!=null && ownerA.length>0){
				return ownerA[0];
			}
		}
		return null;
	}
	public Owner selectByOw_id(String ow_id){
		Owner[] ownerA=null;
		String sql="select * from owner where ow_id=?";
		Object[] ob=new Object[]{ow_id};
		ownerA=fullOwner(DBUtil.executeQuery(sql, ob));
		if(ownerA!=null && ownerA.length>0){
			return ownerA[0];
		}
		return null;
	}
	public Owner[] selectAll(){
		Owner[] ownerA=null;
		String sql="select * from owner";
		ownerA=fullOwner(DBUtil.executeQuery(sql, null));
		return ownerA;
	}
	
	private Owner[] fullOwner(List<Map<String,String>> list){
		Owner[] ownerA=null;
		if(list!=null && list.size()>0){
			ownerA=new Owner[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Owner owner=new Owner();
				owner.setHead(map.get("head"));
				owner.setNickname(map.get("nickname"));
				owner.setOw_id(map.get("ow_id"));
				owner.setPassword(map.get("password"));
				owner.setPhomenumber(map.get("phomenumber"));
				ownerA[i]=owner;
			}
		}
		return ownerA;
	}
	public Owner getOwner() {
		return ow;
	}
	public void setOwner(Owner owner) {
		this.ow = owner;
	}
	
}
