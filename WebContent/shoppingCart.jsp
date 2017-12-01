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
		<tr>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td><c:out value="${book.title}" /><!-- Insert Image Here --><br />ISBN:<c:out value="${book.isbn}" /></td>
				<td><c:out value="${book.quantityInCart}" /></td>
				<td><c:out value="${book.price}" /></td>
			</tr>
		</c:forEach>
	</table>
   
 <!-- 
    <table> 
        <tr>
            <th><a href="#">Title</a></th>
            <th><a href="#">Price</a></th>
            <th><a href="#">Quantity</a></th>
            <th></th>
        </tr>
        <tr>
            <td>Divergent<div><img class="center-img carousel-img" src="images/Divergent_Smaller.png" alt="book image"/></div>ISBN:123435</td>
            <td>$10.99</td>
            <td><input class="cartInput" type="text" value="1"></td>
            <td><button>Delete</button>
        </tr>
        <tr>
            <td>Harry Potter and the Sorcerer's Stone<div><img class="center-img carousel-img" src="images/Harry%20Potter.jpg" alt="book image"/></div>ISBN:5783456</td>
            <td>$10.99</td>
            <td><input class="cartInput" type="text" value="1"></td>
            <td><button>Delete</button>
        </tr>
        <tr>
            <td>The Hunger Games<div><img class="center-img carousel-img" src="images/The_Hunger_Games.jpg" alt="book image"/></div>ISBN:46543</td>        
            <td>$10.99</td>
            <td><input class="cartInput" type="text" value="1"></td>
            <td><button>Delete</button>
        </tr>
        <tr>
            <td>Percy Jackson<div><img class="center-img carousel-img" src="images/Percy%20Jackson.jpg" alt="book image"/></div>ISBN:573939</td>            
            <td>$10.99</td>
            <td><input class="cartInput" type="text" value="1"></td>
            <td><button>Delete</button>
        </tr>
    </table> 
 -->
   
    <hr>
    <div class="subTotalDiv">
    	<label>Subtotal: $43.96</label>
    </div>
    <div class="checkoutDiv">
    	<button>Empty cart</button>
    	<button onclick="location.href='checkout.html'">Process to checkout</button>    
    </div>
    
    <footer class="footer"></footer>

</div>
</body>
</html>
