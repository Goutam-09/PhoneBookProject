package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.factory.UserDaoFactory;
import com.dao.IUserDao;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String pwd = request.getParameter("upwd");
		HttpSession session = request.getSession();		
		
		IUserDao dao = UserDaoFactory.getDao();
		User user = dao.loginUser(email, pwd);
		
		if(user!=null) {
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("invalidMsg", "Invalid email and password");
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
