package com.amdocs.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.Course;

public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AddCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String desp = request.getParameter("desp");
        String fees = request.getParameter("fees");
        String resource = request.getParameter("resource");
            
        try {
        	Course c = new Course(name,resource,desp,fees);
			c.addCourse();
			response.sendRedirect("/TrainingProject/admin");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/TrainingProject/admin/course");
		}
	}

}
