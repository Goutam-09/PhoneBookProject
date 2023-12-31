<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp" %>
<style type="text/css">
	#back-img{
		background-size: cover;
		background-repeat: no-repeat;
	}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	
	<section id="back-img" class="vh-100 bg-image"
  style="background-image: url('image/img1.jpg');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
          <div class="card" style="border-radius: 15px; ">
            <div class="card-body p-5">
            
            <%
            	String successMsg =(String) session.getAttribute("successMsg");
            	String errorMsg =(String) session.getAttribute("errorMsg");
            	
            	if(successMsg!=null){
            		%>
            			<p class="text-center text-success"><%= successMsg %></p>
            		<%
            		session.removeAttribute("successMsg");
            	}
            	if(errorMsg!=null){
            		%>
            			<p class="text-center text-danger"><%= errorMsg %></p>
            		<%
            		session.removeAttribute("errorMsg");
            	}
            	%>
              <h2 class="text-uppercase text-center mb-5 text-success">Create an account</h2>

				
              <form action="register" method="post">

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="name" required />
                  <label class="form-label" for="form3Example1cg">User Name</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="email" id="form3Example3cg" class="form-control form-control-lg" name="email" required/>
                  <label class="form-label" for="form3Example3cg">Your Email</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" id="form3Example4cg" class="form-control form-control-lg" name="pwd" required />
                  <label class="form-label" for="form3Example4cg">Password</label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit" 
                    class="btn btn-danger btn-block btn-lg gradient-custom-4 text-body">Register</button>
                </div>

                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="login.jsp"
                    class="fw-bold text-body"><u>Login here</u></a></p>

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <br>
  <%@include file="component/footer.jsp" %>
</section>
</body>
</html>