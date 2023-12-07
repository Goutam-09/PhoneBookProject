package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.dbConnection;
import com.dao.IContactDao;
import com.entity.Contact;

public class ContactDaoImpl implements IContactDao {
	private static final String TABLE_NAME1 = "contact";
	private static final String ADD_CONTACT = "INSERT INTO "+TABLE_NAME1+" (`name`,`email`,`MobileNo.`,`about`,`userId`) VALUES(?,?,?,?,?)";
	private static final String VIEW_ALL_CONTACTS = "SELECT * FROM "+TABLE_NAME1+" WHERE userId=?";
	private static final String DELETE_CONTACT = "DELETE FROM "+TABLE_NAME1+" WHERE id=?";
	private static final String GET_CONTACT = "SELECT * FROM "+TABLE_NAME1+" WHERE id=?";
	private static final String UPDATE_CONTACT = "UPDATE "+TABLE_NAME1+" SET `name`=?,`email`=?,`MobileNo.`=?,`about`=? WHERE id=?";
	private PreparedStatement pstmt = null;
	private Connection con=null;
	
	
	public ContactDaoImpl() {
		super();
		con = dbConnection.getConnection();
	}
	

	@Override
	public boolean saveContact(Contact c) {
		try {
			pstmt = con.prepareStatement(ADD_CONTACT);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getMobileNo());
			pstmt.setString(4, c.getAbout());
			pstmt.setInt(5, c.getUserId());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Contact> getAllContact(int userId) {
		List<Contact> list = new ArrayList<Contact>();
		Contact c = null;
		try {
			pstmt=con.prepareStatement(VIEW_ALL_CONTACTS);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setMobileNo(rs.getString(4));
				c.setAbout(rs.getString(5));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean deleteContact(int id) {
		try {
			pstmt =  con.prepareStatement(DELETE_CONTACT);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public Contact getContact(int id) {
		Contact c = null;
		try {
			pstmt = con.prepareStatement(GET_CONTACT);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setMobileNo(rs.getString(4));
				c.setAbout(rs.getString(5));
				c.setUserId(rs.getInt(6));
			}
			return c;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	@Override
	public boolean editContact(Contact c) {
		try {
			pstmt = con.prepareStatement(UPDATE_CONTACT);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getMobileNo());
			pstmt.setString(4, c.getAbout());
			pstmt.setInt(5, c.getId());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
