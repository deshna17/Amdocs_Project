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

import com.amdocs.main.Course;
import com.amdocs.main.DBconnect;

public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EnrollCourseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>" + "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>Enroll Course</title>\r\n" + "<style>\r\n" + "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n" + "table {text-align: center;}\r\n" + "div {text-align: center;}\r\n"
				+ "body{background-color:#F5E79D}\r\n" + "</style>\r\n" + "</head><body>");

		try {
			Connection con = DBconnect.dbconn();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from course");
			out.println("<h1>Enroll Course</h1>");
			out.println("<div>");
			out.println("<table border=1 width=100% height=50%>");
			out.println(
					"<tr><th>COURSE ID</th><th>COURSE NAME</th><th>COURSE DESCRIPTION</th><th>COURSE FEES</th><th>ENROLL</th><tr>");

			while (rs.next()) {
				String a, b, c, d;
				a = rs.getString(1);
				b = rs.getString(2);
				c = rs.getString(3);
				d = rs.getString(4);
				out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + d + "</td><td>"
						+ "<form action='/FinalProject/user/add-course' method='post'>"
						+ "<input type='hidden' name='courseid' value='" + rs.getString(1) + "'></input>"
						+ "<input type='submit' value='Enroll' />" + "</form>" + "</td></tr>");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Cookie ck[]=request.getCookies();
			Course c = new Course(Integer.parseInt(request.getParameter("courseid")));
			c.enrollCourse(Integer.parseInt(ck[0].getValue()), c.getCourse_id()) ;
			response.sendRedirect("/FinalProject/user/view-course");
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/FinalProject/user/add-course");
		}
	}

}
