package com.amdocs.admin;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("adminRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin user = new Admin();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			Admin.registerAdmin(user);
			response.sendRedirect("/logout");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
