package com.anjuwang.dao;

import com.anjuwang.bean.Owner;

public interface IOwnerDao {
	public boolean addOwner(Owner owner);//添加业主，成功返回true
	public boolean deleteOwner(int id);//删除业主，成功返回true
	public boolean updateOwner(Owner owner);//修改业主，成功返回true
	public Owner selectOwner(int id);
	public Owner selectOwner(String nick);
	public Owner selectOwner(String nick,String password);
}
