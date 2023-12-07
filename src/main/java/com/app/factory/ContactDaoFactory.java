package com.app.factory;

import com.dao.IContactDao;
import com.dao.impl.ContactDaoImpl;

public class ContactDaoFactory {
	public static IContactDao getDao() {
		return new ContactDaoImpl();		
	}
}
