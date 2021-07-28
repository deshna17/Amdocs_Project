package com.amdocs.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
	String userid = null;
	static String password = null;

	public String getUserid() {
		return userid;
	}

	public String getPassword() {
		return password;
	}

	public login(String userid, String password) {
		super();
		this.userid = userid;
		login.password = password;
	}

	public int loginUser() throws SQLException {

		Connection con = DBconnect.dbconn();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user1");

		while (rs.next()) {
			if (getUserid().equals(rs.getString(1)) && getPassword().equals(rs.getString(7)))
				return 0;
		}

		con = DBconnect.dbconn();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from admin1");

		while (rs.next()) {
			if (getUserid().equals(rs.getString(1)) && getPassword().equals(rs.getString(4)))
				return 1;
		}

		con.close();
		return 2;

	}
}
