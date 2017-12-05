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

<title>Add book</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--Bootstrap CDN-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!--Carousel CSS-->
<link rel="stylesheet" type="text/css" href="slick/slick.css" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css" />
<!--Carousel Javascript-->
<script type="text/javascript" src="slick/slick.min.js"></script>


<!--Our Javascript for homepage-->
<script type="text/javascript" src="scripts/index.js"></script>

<!-- Custom styles for this template -->
<link type="text/css" href="css/index.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<!--The login top bar which holds our options to Log In and Sign Up/Register-->
		<div class="top_bar">
			<div class="container">
				<div class="pull-right">
					<ul class="pull-right">
						<li class="login">Welcome! Admin</li>
						<li class="login"><a href="adminView.html">admin action</a>
						<li class="login"><a href="account.html">manage account</a></li>
						<li class="login"><a href="">order status</a></li>
						<li class="login shift-left"><a href="shoppingCart.html"><img
								src="images/shopping-cart.png"></a></li>
					</ul>
				</div>
			</div>
		</div>

		<!--Navigation Bar at the top right which hold links to other sites on our page-->
		<div class="header clearfix">
			<nav>
			<div class="navbar-header">
				<h3>Logo TBD</h3>
			</div>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="#">Home</a></li>
				<li role="presentation" class="active"><a href="#">Browse
						All Books</a></li>
				<li role="presentation"><a href="#">About</a></li>
				<li role="presentation"><a href="#">Contact</a></li>
			</ul>
			</nav>
		</div>

		<!-- 
 		Shows the reports including end of day sales, 
 		low inventory notices, book sales, and publishers sale.
 		-->
		<h1>Total sales for today:</h1>
		<p>(Pull all orders made on TODAY, calculate total outside of
			html)</p>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<table>
			<tr>
				<th><a href="#">Order ID</a></th>
				<th><a href="#">Order Date</a></th>
				<th><a href="#">Customer</a></th>
				<th><a href="#">Price</a></th>
			</tr>
			<c:forEach items="${orderResults}" var="order">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.dateOrderedInfo}</td>
					<td>${order.customerName}</td>
					<td>${order.totalPrice}</td>
				</tr>
			</c:forEach>
		</table>

		<p>
			<strong>Total Earned Today : $ ${totalPrice}</strong>
		</p>

		<br />
		<h1>Low Inventory Notices</h1>
		<table>
			<tr>
				<th><a href="#">Title</a></th>
				<th><a href="#">Author</a></th>
				<th><a href="#">Publisher</a></th>
				<th><a href="#">Subject</a></th>
				<th><a href="#">Price</a></th>
				<th><a href="#">Quantity</a></th>
			</tr>
			<c:forEach items="${bookResults}" var="book">
				<tr>
					<td>${book.title} <img class="center-img carousel-img"
						src="data:image/jpg;base64,${book.pic}" alt="book image" /> ISBN:
						${book.isbn}
					</td>
					<td>${book.author}</td>
					<td>${book.publisher}</td>
					<td>${book.subject}</td>
					<td>${book.price}</td>
					<td>${book.quantityInStock}</td>
			
				</tr>
		</c:forEach>
	</table>
	 <br />
		<h1>Book Sales</h1>
		<table>
			<tr>
				<th>Book Title</th>
				<th>Number Sold</th>
				<th>$ Made Today From Book</th>
			</tr>
			<tr>
				<td>Pull book title from database</td>
				<td>Pull the amount that were sold today?</td>
				<td>Calculate the $ made based on the number of books sold
					today?</td>
			</tr>
		</table>

		<br />
		<h1>Publisher's Sales Report</h1>
		<table>
			<tr>
				<th>Publisher Name</th>
				<th>$ Made on Publisher's Titles Today</th>
			</tr>
			<tr>
				<td>Pull publisher name from database - Only show publisher
					names that have sold something today</td>
				<td>Calculate the $ made based on publisher</td>
			</tr>
		</table>

		<footer class="footer">
		<p>&copy; 2016 Company, Inc.</p>
		</footer>


	
					</div>
</body>
</html>
