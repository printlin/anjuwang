package com.anjuwang.service;

import com.anjuwang.bean.Comment;
import com.anjuwang.dao.impl.CommentDao;

public class CommentService {
	CommentDao cd=null;
	Comment comment=null;
	public CommentService(){
		cd=new CommentDao();
		comment=new Comment();
	}
	public boolean addThis(Comment comm){
		return cd.addThis(comm);
	}
}
