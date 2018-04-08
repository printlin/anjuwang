package com.anjuwang.dao.impl;

import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Manager;
import com.anjuwang.common.DBUtil;

public class ManagerDao {
	Manager ow;
	public ManagerDao(){
	
	}
	public boolean loginJudge(Manager manager){
		String sql="select * from manager where username=? and password=?";
		Object[] ob=new Object[]{manager.getUsername(),manager.getPassword()};
		Manager[] ManagerA = fullManager(DBUtil.executeQuery(sql, ob));
		if(ManagerA!=null && ManagerA.length>0){
			this.ow = ManagerA[0];
			return true;
		}
		return false;
	}
	public boolean findByUsername(String username){
		String sql="select * from manager where username=?";
		Object[] ob=new Object[]{username};
		List<Map<String,String>> list=DBUtil.executeQuery(sql, ob);
		if(list==null || !(list.size()>0)){
			return false;
		}
		return true;
	}
	public boolean deleteThis(Manager manager){
		String sql="delete from manager where mag_id=?";
		Object[] ob=new Object[]{manager.getMag_id()};
		return DBUtil.executeUpdate(sql, ob);
	}

	public boolean updateThis(Manager manager){
		String sql="update Manager set username=?,password=?,loginCount=?,lastLoginTime=?,level=? where mag_id=?";
		Object[] ob=new Object[]{manager.getUsername(),manager.getPassword(),manager.getLoginCount(),manager.getLastLoginTime(),manager.getLevel(),manager.getMag_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public Manager selectThis(Manager manager){
		Manager[] managerA=null;
		if(manager.getMag_id()==null){
			if(manager.getUsername()!=null && manager.getPassword()!=null){
				String sql="select * from manager where username=? and password=?";
				Object[] ob=new Object[]{manager.getUsername(),manager.getPassword()};
				managerA=fullManager(DBUtil.executeQuery(sql, ob));
				if(managerA!=null && managerA.length>0){
					return managerA[0];
				}
			}
		}else{
			String sql="select * from manager where mag_id=?";
			Object[] ob=new Object[]{manager.getMag_id()};
			managerA=fullManager(DBUtil.executeQuery(sql, ob));
			if(managerA!=null && managerA.length>0){
				return managerA[0];
			}
		}
		return null;
	}
	public Manager selectBymag_id(String mag_id){
		Manager[] ManagerA=null;
		String sql="select * from manager where mag_id=?";
		Object[] ob=new Object[]{mag_id};
		ManagerA=fullManager(DBUtil.executeQuery(sql, ob));
		if(ManagerA!=null && ManagerA.length>0){
			return ManagerA[0];
		}
		return null;
	}
	public Manager[] selectAll(){
		Manager[] ManagerA=null;
		String sql="select * from manager";
		ManagerA=fullManager(DBUtil.executeQuery(sql, null));
		return ManagerA;
	}
	
	private Manager[] fullManager(List<Map<String,String>> list){
		Manager[] managerA=null;
		if(list!=null && list.size()>0){
			managerA=new Manager[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Manager manager=new Manager();
				manager.setUsername(map.get("username"));
				manager.setLoginCount(map.get("loginCount"));
				manager.setLastLoginTime(map.get("lastLoginTime"));
				manager.setMag_id(map.get("mag_id"));
				manager.setPassword(map.get("password"));
				manager.setLevel(map.get("level"));
				manager.setCom_id(map.get("com_id"));
				managerA[i]=manager;
			}
		}
		return managerA;
	}
	public Manager getManager() {
		return ow;
	}
	public void setManager(Manager Manager) {
		this.ow = Manager;
	}
}
