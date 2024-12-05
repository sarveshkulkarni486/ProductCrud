<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, jakarta.servlet.http.HttpServlet.*, jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container mt-5">
        <div class="card mx-auto" style="max-width: 800px;">
            <div class="row g-0">
                <div class="col-md-6 d-flex align-items-center">
                    <img src="images/login.jpg" class="img-fluid" alt="Login Image" />
                </div>
                <div class="col-md-6">
                    <div class="card-body" style="margin-top: 2rem;">
                        <p class="warning" style="display: <% if (request.getAttribute("message") != null) { %>block<% } else { %>none<% } %>; color: <% 
    						String message = (String) request.getAttribute("message");
						    if (message != null) {
						        if (message.contains("success")) { // Check if message indicates success
						            out.print("green");
						        } else {
						            out.print("red");
						        }
						    } else {
						        out.print("red"); // Default to red if no message
						    }
						%>;">
						    <% 
						        if (message != null) {
						            out.print(message);
						        }
						    %>
						</p>
                        <h5 class="card-title">Login</h5>
                        <form action="login" method="post">
                            <div class="mb-3">
                                <label class="form-label" for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="username@domain.com">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="*****" min="7">
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <p class="login-tag">New to us? <a href="register.jsp">Register</a></p>
                            <p class="forgot-tag">Forgot Password <a href="forgot.jsp">Forgot Password!</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>