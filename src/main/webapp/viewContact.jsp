<%@page import="com.dao.impl.ContactDaoImpl"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Contact"%>
<%@page import="com.app.factory.ContactDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<%
	if (user == null) {
		session.setAttribute("invalidMsg", "Login please...");
		response.sendRedirect("login.jsp");
	}
	%>
	<%@ page import="com.dao.IContactDao"%>
	<%@ page import="com.app.factory.ContactDaoFactory"%>

	<%
	String msg3 = (String) session.getAttribute("sucMsg");
	String msg4 = (String) session.getAttribute("failMsg");
	String msg5 = (String) session.getAttribute("deleteMsg");
	%>
	<%
	if (msg3 != null) {
	%>
	<div class="bg-success mt-2">
		<h6 class="text-white text-center"><%=msg3%></h6>
	</div>
	<%
	session.removeAttribute("sucMsg");
	}
	%>
	<%
	if (msg5 != null) {
	%>
	<div class="bg-danger mt-2">
		<h6 class="text-white text-center"><%=msg5%></h6>
	</div>
	<%
	session.removeAttribute("deleteMsg");
	}
	%>
	<%
	if (msg4 != null) {
	%>
	<div class="bg-danger mt-2">
		<h6 class="text-white text-center"><%=msg4%></h6>
	</div>
	<%
	session.removeAttribute("failMsg");
	}
	%>
	<div class="container">

		<div class="row">
			<%
			if (user != null) {
				List<Contact> list = new ArrayList<Contact>();
				IContactDao dao = ContactDaoFactory.getDao();
				list = dao.getAllContact(user.getId());
			%>

			<table class="table table-bordered mt-2">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Ph.No</th>
						<th>About</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Contact c : list) {
					%>
					<tr>

						<td><%=c.getName()%></td>
						<td><%=c.getEmail()%></td>
						<td><%=c.getMobileNo()%></td>
						<td><%=c.getAbout()%></td>
						<td><a href="Edits?id=<%=c.getId()%>" class="btn btn-outline-success">Edit</a>
						<a href="Deletes?id=<%=c.getId()%>" class="btn btn-outline-danger ml-2">Delete</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<%
			}
			%>

		</div>

	</div>
</body>
</html>