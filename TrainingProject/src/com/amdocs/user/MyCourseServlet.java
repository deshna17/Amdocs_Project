package com.amdocs.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.DBconnect;

public class MyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck[]=request.getCookies();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>" + "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>View Feedback</title>\r\n" + "<style>\r\n" + "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n" + "table {text-align: center;}\r\n" + "div {text-align: center;}\r\n"
				+ "body{background-color:#F5E79D}\r\n" + "</style>\r\n" + "</head><body>");

		try {
			Connection con = DBconnect.dbconn();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from enroll natural join course where enroll.user_id=" + Integer.parseInt(ck[0].getValue()));
			out.println("<h1>My Course</h1>");
			out.println("<div>");
			out.println("<table border=1 width=100% height=50%>");
			out.println(
					"<tr><th>ENROLL ID</th><th>COURSE ID</th><th>COURSE NAME</th><th>COURSE DESCRIPTION</th><th>COURSE FEES</th><th>COURSE RESOURCE</th><tr>");

			while (rs.next()) {
				String a, b, c,d,e,f;
				a = rs.getString(2);
				b = rs.getString(1);
				c = rs.getString(4);
				d = rs.getString(5);
				e = rs.getString(6);
				f = rs.getString(7);
				out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + d + "</td><td>" + e + "</td><td>" + f + "</td></tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("<br><br>");
			out.println("<div>");
			out.println("<a href='/FinalProject/user'>Home</a>&emsp;");
			out.println("<a href='/FinalProject/logout'>Log Out</a>&emsp;");	
			out.println("</div>");
			out.println("</html></body>");
			con.close();

		} catch (SQLException e) {
			out.println(e.getMessage());
		}
	}

}
