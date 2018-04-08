package com.anjuwang.dao.impl;

import java.util.List;
import java.util.Map;

import com.anjuwang.bean.Comment;
import com.anjuwang.common.DBUtil;
import com.anjuwang.dao.ICommentDao;


public class CommentDao implements ICommentDao {
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#deleteThis(com.anjuwang.bean.Comment)
	 */
	@Override
	public boolean deleteThis(Comment bean){
		String sql="delete from `comment` where cmt_id=?";
		Object[] ob=new Object[]{bean.getCmt_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#addThis(com.anjuwang.bean.Comment)
	 */
	@Override
	public boolean addThis(Comment bean){
		String sql="insert into `comment` (ow_id,ord_id,`time`,`comment`,`grade`,`level`,`attitude`,`quality`) values (?,?,?,?,?,?,?,?)";
		Object[] ob=new Object[]{bean.getOw_id(),bean.getOrd_id(),bean.getTime(),bean.getComment(),bean.getGrade(),bean.getLevel(),bean.getAttitude(),bean.getQuality()};
		return DBUtil.executeUpdate(sql, ob);
	}
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#updateThis(com.anjuwang.bean.Comment)
	 */
	@Override
	public boolean updateThis(Comment bean){
		String sql="update `comment` set ow_id=?,ord_id=?,`time`=?,`comment`=?,`grade`=?,`level`=?,`attitude`=?,`quality`=? where cmt_id=?";
		Object[] ob=new Object[]{bean.getOw_id(),bean.getOrd_id(),bean.getTime(),bean.getComment(),bean.getGrade(),bean.getLevel(),bean.getAttitude(),bean.getQuality(),bean.getCmt_id()};
		return DBUtil.executeUpdate(sql, ob);
	}
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#selectThis(com.anjuwang.bean.Comment)
	 */
	@Override
	public Comment selectThis(Comment bean){
		Comment[] beanA=null;
		String sql="select * from `comment` where cmt_id=?";
		Object[] ob=new Object[]{bean.getCmt_id()};
		beanA=full(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	@Override
	public Comment selectByOrd_id(String ord_id){
		Comment[] beanA=null;
		String sql="select * from `comment` where ord_id=?";
		Object[] ob=new Object[]{ord_id};
		beanA=full(DBUtil.executeQuery(sql, ob));
		if(beanA!=null && beanA.length>0){
			return beanA[0];
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#selectAll()
	 */
	@Override
	public Comment[] selectAll(int start,int length){
		Comment[] beanA=null;
		String sql="select * from `comment`  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#selectAllByOw_ID(java.lang.String)
	 */
	@Override
	public Comment[] selectAllByOw_ID(String ow_id,int start,int length){
		Comment[] beanA=null;
		String sql="select * from `comment` where ow_id=?  order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{ow_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}

	
	/* (non-Javadoc)
	 * @see com.anjuwang.dao.impl.ICommentDao#selectAllByOrd_ID(java.lang.String)
	 */
	@Override
	public Comment[] selectAllByOrd_ID(String ord_id,int start,int length){
		Comment[] beanA=null;
		String sql="select * from `comment` where ord_id=? order by `time` DESC LIMIT ?,?";
		Object[] od=new Object[]{ord_id,start,length};
		beanA=full(DBUtil.executeQuery(sql, od));
		return beanA;
	}
	
	private Comment[] full(List<Map<String,String>> list){
		Comment[] beanA=null;
		if(list!=null && list.size()>0){
			beanA=new Comment[list.size()];
			for(int i=0,len=list.size();i<len;i++){
				Map<String,String> map=list.get(i);
				Comment bean=new Comment();
				bean.setCmt_id(map.get("cmt_id"));
				bean.setOw_id(map.get("ow_id"));
				bean.setTime(map.get("time"));
				bean.setComment(map.get("comment"));
				bean.setOrd_id(map.get("ord_id"));
				bean.setAttitude(map.get("attitude"));
				bean.setGrade(map.get("grade"));
				bean.setLevel(map.get("level"));
				bean.setQuality(map.get("quality"));
				beanA[i]=bean;
			}
		}
		return beanA;
	}

}
