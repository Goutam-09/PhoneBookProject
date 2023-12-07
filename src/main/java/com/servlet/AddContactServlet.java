package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.factory.ContactDaoFactory;
import com.dao.IContactDao;
import com.entity.Contact;
import com.mysql.cj.Session;

@WebServlet("/addcontact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddContactServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId =Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobile");
		String about = request.getParameter("about");
		
		Contact c = new Contact();
		c.setName(name);
		c.setEmail(email);
		c.setMobileNo(mobileNo);
		c.setAbout(about);
		c.setUserId(userId);
		

		IContactDao dao = ContactDaoFactory.getDao();
		boolean bol=dao.saveContact(c);
		HttpSession session = request.getSession();
		if(bol) {
			session.setAttribute("sucMsg", "Contact Saved...");
			response.sendRedirect("viewContact.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Save Contact Failed...");
			response.sendRedirect("addContact.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
