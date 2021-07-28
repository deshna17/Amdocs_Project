package com.amdocs.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LogOutServlet() {
        super();  
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck=new Cookie("user_id","");
		response.addCookie(ck);
		response.sendRedirect("/FinalProject"); 
	}
}
