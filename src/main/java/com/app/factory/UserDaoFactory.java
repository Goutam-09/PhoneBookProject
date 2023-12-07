package com.app.factory;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	public static IUserDao getDao() {
		return new UserDaoImpl();
	}
}
