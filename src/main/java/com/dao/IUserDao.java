package com.dao;

import com.entity.User;

public interface IUserDao {
	public boolean userRegisteration(User user);
	public User loginUser(String userName,String userPwd);
}
