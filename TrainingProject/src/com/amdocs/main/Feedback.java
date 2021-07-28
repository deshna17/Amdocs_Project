package com.amdocs.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Feedback {
	int feedback_id;
	int user_id;
	String feedback_message;

	public String getFeedback_message() {
		return feedback_message;
	}

	public void setFeedback_message(String feedback_message) {
		this.feedback_message = feedback_message;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	private void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Feedback() {
		super();
		feedback_id = 0;
		user_id = 0;
		feedback_message = null;
	}

	public Feedback(int user_id,String feedback_message) throws SQLException {
		super();
		setUser_id(user_id);
		setFeedback_message(feedback_message);
		setFeedback_id(submitFeedback());
	}
	
	public int submitFeedback() throws SQLException {
		
		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call submitFeedback(?,?)}");
		preparedStatement.setInt(2, getUser_id());
		preparedStatement.setString(3, getFeedback_message());
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();
		con.close();
		
		return preparedStatement.getInt(1);
	}
	
}
