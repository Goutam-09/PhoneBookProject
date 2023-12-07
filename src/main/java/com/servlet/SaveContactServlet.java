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

@WebServlet("/savecontact")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveContactServlet() {
        super();
    }   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobile");
		String about = request.getParameter("about");
		
		Contact c = new Contact();
		c.setId(id);
		c.setName(name);
		c.setEmail(email);
		c.setMobileNo(mobileNo);
		c.setAbout(about);
		
		IContactDao dao = ContactDaoFactory.getDao();
		boolean bol=dao.editContact(c);
		HttpSession session = request.getSession();
		if(bol) {
			session.setAttribute("updMsg", "Contact update successfully...");
			response.sendRedirect("viewContact.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Save Contact Failed...");
			response.sendRedirect("viewContact.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
