package com.entity;

public class Contact {
	private Integer id;
	private String name;
	private String email;
	private String mobileNo;
	private String about;
	private int userId;
	
	
	public Contact() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", about="
				+ about + ", userId=" + userId + "]";
	}

	
	
	
}
