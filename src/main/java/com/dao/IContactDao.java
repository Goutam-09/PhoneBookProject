package com.dao;

import java.util.List;

import com.entity.Contact;

public interface IContactDao {
	public boolean saveContact(Contact c);
	public List<Contact> getAllContact(int userId);
	public boolean deleteContact(int id);
	public boolean editContact(Contact c);
	public Contact getContact(int id);
}
