<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#back-img {
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
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


	<section id="back-img" class="vh-100 bg-image"
		style="background-image: url('image/img5.jpg');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<%
								String success = (String) session.getAttribute("sucMsg");
								String error = (String) session.getAttribute("errorMsg");

								if (success!= null) {
								%>
								<p class="text-center text-success"><%=success%></p>
								<%
								session.removeAttribute("sucMsg");
								}
								if (error!= null) {
								%>
								<p class="text-center text-danger"><%=error%></p>
								<%
								session.removeAttribute("errorMsg");
								}
								%>
								<h2 class="text-uppercase text-center mb-5 text-success">Add
									Contact</h2>
								<form action="addcontact" method="post">
									<%
									if (user != null) {
									%>
									<input class="mb-2" type="hidden" value="<%=user.getId()%>"
										name="userId">
									<%
									}
									%>
									<div class="form-outline mb-4">
										<input type="text" name="name" id="form3Example1cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example1cg">Enter Name</label>
									</div>

									<div class="form-outline mb-4">
										<input type="email" name="email" id="form3Example3cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example3cg">Email
											Address</label>
									</div>

									<div class="form-outline mb-4">
										<input type="number" name="mobile" id="form3Example4cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example4cg">Mobile No.</label>
									</div>

									<div class="form-outline mb-4">
										<textarea name="about" class="form-control form-control-lg"
											rows="3" cols="57" placeholder="Enter About"></textarea>
									</div>

									<div class="d-flex justify-content-center">
										<button type="submit"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Save
											Contact</button>
									</div>

									<p class="text-center text-muted mt-5 mb-0">
										Have already an account? <a href="login.jsp"
											class="fw-bold text-body"><u>Login here</u></a>
									</p>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<%@include file="component/footer.jsp"%>
	</section>
</body>
</html>