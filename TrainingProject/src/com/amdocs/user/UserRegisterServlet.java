package com.amdocs.user;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("userRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Date reg_date = new java.sql.Date(new java.util.Date().getTime());
        String password = request.getParameter("password");
		String photo = request.getParameter("photo");
		
        User user = new User();
        
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        user.setEmail(email);
        user.setReg_date(reg_date);
        user.setPassword(password);
        user.setUpload_photo(photo);
        
        int s = -1;
        try {
        	s= User.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		request.setAttribute("message",s);
		request.getRequestDispatcher("userHome.jsp").forward(request, response);
	}

}
