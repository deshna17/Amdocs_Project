package com.amdocs.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck[]=request.getCookies();
		request.setAttribute("message",Integer.parseInt(ck[0].getValue()));
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	}
}
