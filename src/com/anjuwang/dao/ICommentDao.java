package com.anjuwang.dao;

import com.anjuwang.bean.Comment;

public interface ICommentDao {

	boolean deleteThis(Comment bean);

	boolean addThis(Comment bean);

	boolean updateThis(Comment bean);

	Comment selectThis(Comment bean);

	Comment selectByOrd_id(String ord_id);
	
	Comment[] selectAll(int start,int length);

	Comment[] selectAllByOw_ID(String ow_id,int start,int length);

	Comment[] selectAllByOrd_ID(String ord_id,int start,int length);

}