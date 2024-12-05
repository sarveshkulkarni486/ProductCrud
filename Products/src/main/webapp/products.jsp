<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.example.beans.Product"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="./css/table.css"/>
	<script src="https://kit.fontawesome.com/2dd5f1c1c7.js" crossorigin="anonymous"></script>
</head>
<body>
<%
	response.setContentType("text/html");
	HttpSession sess = request.getSession();
	String role = (String)sess.getAttribute("role");
	if(role!=null && role.equals("admin")){
	 		List<Product> productlist=(List<Product>)request.getAttribute("plist");
	 		if(productlist!=null && !productlist.isEmpty()){
	 			if(request.getAttribute("msg")==null){
	 				
	 			
%>
		<h1>Product List</h1>
		<div class="row">
		<p class="warning" style="display: <% if (request.getAttribute("message") != null) { %>block<% } else { %>none<% } %>; color: <% 
    						String message = (String) request.getAttribute("message");
						    if (message != null) {
						        if (message.contains("success")) { // Check if message indicates success
						            out.print("green");
						        } else {
						            out.print("red");
						        }
						    }
						    else {
						        out.print("red"); // Default to red if no message
						    }
						%>;">
						    <% 
						        if (message != null) {
						            out.print(message);
						        }
						    %>
						</p>
			<div class="col-md-12">
				<table class="table">
					<tr class="table-header">
						<th class="cell">Product Id.</th>
						<th class="cell">Product Name</th>
						<th class="cell">Product Quantity</th>
						<th class="cell">Product Price</th>
						<th class="cell">Expiry Date</th>
						<th class="cell">Product Cid</th>
						<th class="cell">Action</th>
					</tr>
					<%for(Product p:productlist){ %>
					
					<tr  class="active">
					
						<td><%=p.getPid() %></td>
						<td><%=p.getPname() %></td>
						<td><%=p.getQty() %></td>
						<td><%=p.getPrice() %></td>
						<td><%=p.getExpdate() %></td>
						<td><%=p.getCid() %></td>
						<td>
							<a href="editprod?pid=<%=p.getPid() %>"><button class="btn btn-warning"><i class="fa-regular fa-pen-to-square icons"></i>Edit</button></a>
							<a href="delete?pid=<%=p.getPid() %>"><button class="btn btn-danger"><i class="fa-solid fa-trash icons"></i>&nbsp; Delete</button></a>
						</td>
					</tr>
					<% } %>	
				</table>	
			</div>
			<%
        } else {
   
%>
                <button class="btn btn-primary">
                    <i class="fa-solid fa-cart-shopping"></i>
                    <a href="addproduct.jsp" style="color: inherit; text-decoration: none;">Add Product</a>
                </button>
                <h1>Stock is empty please add product</h1>
				
            </div>
 
<%
        }
	 		}	
	} else {
		request.setAttribute("message", "you are not authorized:");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	
	}
	
	%>
			<button class="btn btn-primary"><i class="fa-solid fa-cart-shopping"></i><a href="addproduct.jsp" style="color: inherit; text-decoration: none;">Add Product</a></button>
		</div>
</body>
</html>