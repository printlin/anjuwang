package com.anjuwang.service;

import com.anjuwang.bean.Message;
import com.anjuwang.dao.impl.MessageDao;


public class MessageService {
	MessageDao md=null;
	Message message=null;
	public MessageService(){
		md=new MessageDao();
		message=new Message();
	}
	public boolean addThis(Message message){
		return md.addThis(message);
	}
	public boolean updateThis(Message message){
		return md.updateThis(message);
	}
	public Message selectThis(Message message){
		return md.selectThis(message);
	}
	public boolean deleteThis(Message message){
		return md.deleteThis(message);
	}
	public Message[] selectNewByCom_ID(String com_id,int start,int length){
		return md.selectNewByCom_ID(com_id,start,length);
	}
}
