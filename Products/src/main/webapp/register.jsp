<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <img src="images/register.jpg" class="img-fluid" alt="Login Image" />
                </div>
                <div class="col-md-6">
                    <div class="card-body" style="margin-top: 2rem;">
                        <h5 class="card-title">Register User</h5>
                        <form action="register" method="post">
                            <div class="mb-3">
                                <label class="form-label" for="firstname">Firstname</label>
                                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="John" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="lastname">Lastname</label>
                                <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Doe" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="username@domain.com">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="*****" min="7">
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" id="male" name="gender" value="Male">
                                <label class="form-check-label" for="male">Male</label><br>
                                <input type="radio" class="form-check-input" id="female" name="gender" value="Female">
                                <label class="form-check-label" for="female">Female</label><br>
                            </div>
                            <div class="mb-3" style="margin-top: 1rem;">
                                <select name="city" class="form-control">Enter City
                                    <option value="Pune">Pune</option>
                                    <option value="Mumbai">Mumbai</option>
                                    <option value="Nagpur">Nagpur</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <p class="login-tag">Already a user? <a href="login.jsp">Login</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


</body>
</html>