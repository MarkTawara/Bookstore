<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shopping Cart</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--Bootstrap CDN-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--Carousel CSS-->
    <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
    <!--Carousel Javascript-->
    <script type="text/javascript" src="slick/slick.min.js"></script>
    <!--Our Javascript for homepage-->
    <script type="text/javascript" src="scripts/index.js"></script>
    <script src="scripts/template.js"></script>
    <!-- Custom styles for this template -->
    <link type="text/css" href="css/index.css" rel="stylesheet">
</head>

<body>
<div class="container">

	<!--The login top bar which holds our options to Log In and Sign Up/Register-->
    <div class="top_bar"></div>

    <!--Navigation Bar at the top right which hold links to other sites on our page-->
    <div id="navibar" class="header clearfix"></div>


	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table class="displayCart">
	<%	double totalPrice = 0;	%>
	<%@page import = "object.Book"%>
	<%@page import = "java.util.ArrayList"%>
	<%	Book b = new Book();
		ArrayList<Book> l = (ArrayList<Book>)request.getAttribute("books");
		if(l!=null){
			for(Book z : l){
				totalPrice = totalPrice + z.getPrice();
			}
		}else{
			totalPrice = 0;
		}
	%>
		<tr>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Options</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td><c:out value="${book.title}" /><!-- Insert Image Here --><br />ISBN:<c:out value="${book.isbn}" /></td>
				<td><c:out value="${book.quantityInCart}" /></td>
				<td><c:out value="${book.price}" /></td>
				<td><a href="RemoveFromCartServlet?param=${book.isbn}&param2=${book.quantityInCart}">Remove from cart</a></td>
			</tr>
		</c:forEach>
	</table>
   
    <hr>
    <div class="subTotalDiv">
    	<label>Subtotal: <%out.print(totalPrice); %></label>
    </div>
    <div class="checkoutDiv">
    	<button onclick="location.href='EmptyCartServlet'">Empty cart</button>
    	<button onclick="location.href='checkout.html'">Process to checkout</button>    
    </div>
    
    <footer class="footer"></footer>

</div>
</body>
</html>
