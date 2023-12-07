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
	<%@ page import="com.entity.Contact" %>
	<%
		Contact co =(Contact) session.getAttribute("contact");
	%>
	<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-3">
								<h2 class="text-uppercase text-center mb-4 text-success">Edit Contact</h2>
								<form action="savecontact?id=<%=co.getId()%>" method="post">
									
									<div class="form-outline mb-2">
										<input type="text" name="name" value="<%=co.getName() %>" id="form3Example1cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example1cg">Enter Name</label>
									</div>

									<div class="form-outline mb-2">
										<input type="email" name="email" value="<%=co.getEmail() %>" id="form3Example3cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example3cg">Email
											Address</label>
									</div>

									<div class="form-outline mb-2">
										<input type="number" name="mobile" value="<%=co.getMobileNo() %>" id="form3Example4cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example4cg">Mobile No.</label>
									</div>

									<div class="form-outline mb-3">
										<textarea name="about" class="form-control form-control-lg"
											rows="3" cols="57" placeholder="Enter About"><%=co.getAbout() %></textarea>
									</div>

									<div class="d-flex justify-content-center">
										<button type="submit"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Update Contact</button>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>