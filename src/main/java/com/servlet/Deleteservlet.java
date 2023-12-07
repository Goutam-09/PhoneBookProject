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

@WebServlet("/Deletes")
public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Deleteservlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		IContactDao dao = ContactDaoFactory.getDao();
		boolean bol=dao.deleteContact(id);
		HttpSession session = request.getSession();
		if(bol) {
			session.setAttribute("deleteMsg", "Contact deleted...");
			response.sendRedirect("viewContact.jsp");
		}
		else {
					session.setAttribute("failMsg", "Contact deleted failed...");
					response.sendRedirect("viewContact.jsp");
		}
	}
		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
