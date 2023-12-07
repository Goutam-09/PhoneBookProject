package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.connection.dbConnection;
import com.dao.IUserDao;
import com.entity.User;

public class UserDaoImpl implements IUserDao {

	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private static final String TABLE_NAME = "userData";
	private static final String INSERT_USER = "INSERT INTO "+TABLE_NAME+" (uname,uemail,upwd) VALUES(?,?,?)";
	private static final String SELECT_USER = "SELECT * FROM "+TABLE_NAME+" WHERE uemail=? AND upwd=?";
	
	
	
	public UserDaoImpl() {
		super();
		con = dbConnection.getConnection();
	}



	@Override
	public boolean userRegisteration(User user) {
		try {
			pstmt = con.prepareStatement(INSERT_USER);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public User loginUser(String userEmail, String userPwd) {
		
		User user = null;
		try {
			pstmt=con.prepareStatement(SELECT_USER);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userPwd);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
