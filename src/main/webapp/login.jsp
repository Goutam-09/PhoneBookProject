<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
#back-img {
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<section id="back-img" class="vh-100 bg-image"
		style="background-image: url('image/img4.jpeg');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<%
								String msg = (String) session.getAttribute("invalidMsg");
								%>
								<%
								if (msg != null) {
								%>
								<p class="text-danger text-center"><%=msg%></p>
								<%
								session.removeAttribute("invalidMsg");
								}
								%>


								<%
								String logoutMsg = (String) session.getAttribute("logoutMsg");
								%>
								<%
								if (logoutMsg != null) {
								%>
								<p class="text-success text-center"><%=logoutMsg%></p>
								<%
								session.removeAttribute("logoutMsg");
								}
								%>
								<h2 class="text-uppercase text-center mb-5 text-success">Login
									Page</h2>

								<form action="./LoginServlet" method="post">

									<div class="form-outline mb-4">
										<input type="email" id="form3Example1cg"
											class="form-control form-control-lg" name="email" required />
										<label class="form-label" for="form3Example1cg">User
											Email</label>
									</div>
									<div class="form-outline mb-4">
										<input type="password" name="upwd" id="form3Example4cg"
											class="form-control form-control-lg" required /> <label
											class="form-label" for="form3Example4cg">Password</label>
									</div>

									<div class="d-flex justify-content-center">
										<button type="submit"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Login</button>
									</div>

									<p class="text-right text-muted mt-2"><a href="#"
											class="fw-bold text-body"><u>Forget Password</u></a>
									</p>
									<p class="text-center text-muted mt-4 mb-0">
										Create an Account <a href="register.jsp"
											class="fw-bold text-body"><u>register here</u></a>
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