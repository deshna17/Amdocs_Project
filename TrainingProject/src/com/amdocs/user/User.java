package com.amdocs.user;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import com.amdocs.main.DBconnect;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
    private String userid;
    private String email;
    private String upload_photo;
    private String password;
    private String address;
    private String phone;
    private Date reg_date;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpload_photo() {
		return upload_photo;
	}
	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public static int registerUser(User user) throws ClassNotFoundException, SQLException {

		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call insertUSER1(?,?,?,?,?,?,?)}");
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getAddress());
		preparedStatement.setDate(6, (Date) user.getReg_date());
		preparedStatement.setString(7, user.getPassword());
		preparedStatement.setString(8, user.getUpload_photo());
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();

		con.close();
		return preparedStatement.getInt(1);
	}
        
}
