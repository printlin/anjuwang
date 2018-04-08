package com.anjuwang.dao.impl;

import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Message;
import com.anjuwang.common.DBUtil;



public class MessageDao {
	public boolean deleteThis(Message bean){
		String sql="delete from `message` where mes_id=?";
		Object[] ob=new Object[]{bean.getMes_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean addThis(Message bean){
		String sql="insert into `message` (ow_id,com_id,`question`,`answer`,`is_answer`,`is_read`,`time`) values (?,?,?,?,?,?,?)";
		Object[] ob=new Object[]{bean.getOw_id(),bean.getCom_id(),bean.getQuestion(),bean.getAnswer(),bean.getIs_answer(),bean.getIs_read(),bean.getTime()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public boolean updateThis(Message bean){
		String sql="update `message` set ow_id=?,com_id=?,`question`=?,`answer`=?,`is_answer`=?,`is_read`=?,`time`=? where mes_id=?";
		Object[] ob=new Object[]{bean.getOw_id(),bean.getCom_id(),bean.getQuestion(),bean.getAnswer(),bean.getIs_answer(),bean.getIs_read(),bean.getTime(),bean.getMes_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	public Message selectThis(Message bean){
		Message[] beanA=null;
		String sql="select * from `message` where mes_id=?";
		Object[] ob=new Object[]{bean.getMes_id()};
		beanA=full(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	public Message[] selectAll(int start,int length){
		Message[] beanA=null;
		String sql="select * from `message` order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	public Message[] selectAllByOw_ID(String ow_id,int start,int length){
		Message[] beanA=null;
		String sql="select * from `message` where ow_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{ow_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	public Message[] selectAllByCom_ID(String com_id,int start,int length){
		Message[] beanA=null;
		String sql="select * from `message` where com_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	public Message[] selectAllByCom_IDShow(String com_id,int start,int length){
		Message[] beanA=null;
		String sql="select * from `message` where com_id=? and NOT(answer IS NULL)  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	public Message[] selectNewByCom_ID(String com_id,int start,int length){
		Message[] beanA=null;
		String sql="select * from `message` where com_id=? and answer IS NULL order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{com_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	private Message[] full(List<Map<String,String>> list){
		Message[] beanA=null;
		if(list!=null && list.size()>0){
			beanA=new Message[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Message bean=new Message();
				bean.setCom_id(map.get("com_id"));
				bean.setMes_id(map.get("mes_id"));
				bean.setOw_id(map.get("ow_id"));
				bean.setQuestion(map.get("question"));
				bean.setIs_answer(map.get("is_answer"));
				bean.setIs_read(map.get("is_read"));
				bean.setAnswer(map.get("answer"));
				bean.setTime(map.get("time"));
				beanA[i]=bean;
			}
		}
		return beanA;
	}
}
