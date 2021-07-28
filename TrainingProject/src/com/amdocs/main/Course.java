package com.amdocs.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Course {
	int Course_id;
	String Course_name;
	String Courser_esource;
	String Course_desc;
	String Course_fee;
	
	public int getCourse_id() {
		return Course_id;
	}

	protected String getCourse_name() {
		return Course_name;
	}

	protected void setCourse_name(String course_name) {
		Course_name = course_name;
	}

	protected String getCourser_esource() {
		return Courser_esource;
	}

	protected void setCourser_esource(String courser_esource) {
		Courser_esource = courser_esource;
	}

	protected String getCourse_desc() {
		return Course_desc;
	}

	protected void setCourse_desc(String course_desc) {
		Course_desc = course_desc;
	}

	protected String getCourse_fee() {
		return Course_fee;
	}

	protected void setCourse_fee(String course_fee) {
		Course_fee = course_fee;
	}

	protected void setCourse_id(int course_id) {
		Course_id = course_id;
	}

	public Course(int course_id) {
		super();
		Course_id = course_id;
	}

	public Course(String course_name, String courser_esource, String course_desc, String course_fee) {
		super();
		Course_name = course_name;
		Courser_esource = courser_esource;
		Course_desc = course_desc;
		Course_fee = course_fee;
	}
	
	public int addCourse() throws SQLException {
		
		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call addCOURSE(?,?,?,?)}");
		preparedStatement.setString(2, getCourse_name());
		preparedStatement.setString(3, getCourse_desc());
		preparedStatement.setString(4, getCourse_fee());
		preparedStatement.setString(5, getCourser_esource());
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();

		con.close();
		setCourse_id(preparedStatement.getInt(1));
		
		return Course_id;
	}
	
	public int enrollCourse(int user_id,int Course_id) throws SQLException {
		
		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call enrollCOURSE(?,?)}");
		preparedStatement.setInt(2, user_id);
		preparedStatement.setInt(3, Course_id);
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();

		con.close();
		
		return preparedStatement.getInt(1);
	}
	
}
