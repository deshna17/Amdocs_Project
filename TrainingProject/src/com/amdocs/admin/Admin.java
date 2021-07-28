package com.amdocs.admin;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.amdocs.main.DBconnect;

public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	private String adminid;
	private String name;
	private String email;
	private String password;

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int registerAdmin(Admin admin) throws ClassNotFoundException, SQLException {

		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call insertADMIN1(?,?,?)}");

		preparedStatement.setString(2, admin.getName());
		preparedStatement.setString(3, admin.getEmail());
		preparedStatement.setString(4, admin.getPassword());
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();

		con.close();
		return preparedStatement.getInt(1);
	}

}
