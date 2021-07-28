package com.amdocs.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.DBconnect;

public class ViewFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewFeedbackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html"); 
        
        out.println("<html>" +
        		"<head>\r\n" + 
        		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
        		"<title>View Feedback</title>\r\n" + 
        		"<style>\r\n" + 
        		"h1 {text-align: center;}\r\n" + 
        		"p {text-align: center;}\r\n" + 
        		"table {text-align: center;}\r\n" + 
        		"div {text-align: center;}\r\n" + 
        		"body{background-color:#F5E79D}\r\n" + 
        		"</style>\r\n" + 
        		"</head><body>");  
        
		try {
			Connection con=DBconnect.dbconn();
			Statement stmt = con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from feedback");
			out.println("<h1>FEEDBACK FROM USER</h1>");
			out.println("<div>");
			out.println("<table border=1 width=100% height=50%>");  
            out.println("<tr><th>USER ID</th><th>FEEDBACK ID</th><th>FEEDBACK MESSAGE</th><tr>");
            
			while(rs.next()) {
				String n = rs.getString(1);  
                String s = rs.getString(2); 
                String nm = rs.getString(3);
                out.println("<tr><td>" + n + "</td><td>" + s + "</td><td>" + nm + "</td></tr>");  
			}
			out.println("</table>");  
			out.println("</div>");
			out.println("<br><br>");
			out.println("<div>");
			out.println("<a href='/TrainingProject/admin'>Home</a>&emsp;");
			out.println("<a href='/TrainingProject/logout'>Log Out</a>&emsp;");	
			out.println("</div>");
            out.println("</html></body>");  
            con.close();  
			
		} catch (SQLException e) {
			out.println(e.getMessage());
		}  
	}
	
}
