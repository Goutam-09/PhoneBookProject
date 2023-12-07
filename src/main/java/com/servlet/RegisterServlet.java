package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.factory.UserDaoFactory;
import com.dao.IUserDao;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        
    }

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pwd");
	
		
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(pass);
		
		IUserDao dao = UserDaoFactory.getDao();
		boolean bol = dao.userRegisteration(user);
		HttpSession session = request.getSession();
		if(bol!=false) {
			session.setAttribute("successMsg", "User Registered Successfully");
			response.sendRedirect("register.jsp");
		}
		else{
			session.setAttribute("errorMsg", "User Registered failed");
			response.sendRedirect("register.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
