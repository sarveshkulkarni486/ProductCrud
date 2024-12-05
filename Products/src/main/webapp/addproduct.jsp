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
<script src="https://kit.fontawesome.com/2dd5f1c1c7.js"></script>
</head>
<body>

<% 
	response.setContentType("text/html");
	HttpSession sess = request.getSession();
	String role = (String)sess.getAttribute("role");
	if(role!=null && role.equals("admin")){
%>

<div class="container mt-5">
        <div class="card mx-auto" style="max-width: 800px;">
            <div class="row g-0">
                <div class="col-md-6 d-flex align-items-center">
                    <img src="images/addproduct.jpg" class="img-fluid" alt="Login Image" />
                </div>
                <div class="col-md-6">
                    <div class="card-body" style="margin-top: 2rem;">
                        <h5 class="card-title">Add Product</h5>
                        <form action="showprod" method="post">
                            <div class="mb-3">
                                <label class="form-label" for="pid">Product ID</label>
                                <input type="number" class="form-control" id="pid" name="pid" placeholder="1" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="pname">Product Name</label>
                                <input type="text" class="form-control" id="pname" name="pname" placeholder="Chips" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="qty">Product Quantity</label>
                                <input type="number" class="form-control" id="qty" name="qty" placeholder="qunatity">
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="price">Product Price</label>
                                <input type="text" class="form-control" id="price" name="price" placeholder="$88" min="7">
                            </div>
                            <div class="mb-3">
                            	<label class="form-label" for="expdate">Expiry Date</label>
                            	<input type="date" class="form-control" id="expdate" name="expdate">
                            </div>
                            <div class="mb-3">
                            	<label class="form-label" for="cid">Category id</label>
                            	<input type="number" class="form-control" id="cid" name="cid">
                            </div>
                            <button type="submit" id="submit" value="submit" name="submit" class="btn btn-primary"><i class="fa-solid fa-cart-shopping"></i>Add Product</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    -->
    <%} 
	else {
		request.setAttribute("message", "you are not authorized:");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	
	}
	
	%>

</body>
</html>