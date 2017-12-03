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

    <title>Create account</title>

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
    <!-- <script type="text/javascript" src="scripts/validateInput.js"></script> -->
    <!-- Custom styles for this template -->
    <link type="text/css" href="css/index.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <!--The login top bar which holds our options to Log In and Sign Up/Register-->
	<div class="top_bar"></div>
	
		<!--Navigation Bar at the top right which hold links to other sites on our page-->
    <div id="navibar" class="header clearfix"></div>

	<!--Main information for the page is here-->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <div class="regDiv">
    <c:forEach items="${book}" var="book">
    	<p>We didn't have enough books in our system to add to your cart. For the book <strong><c:out value="${book.title}"/></strong> we have <strong><c:out value="${book.quantityInStock}" /></strong> left.</p>
    </c:forEach>
    	<p>Please return to our <a href="SearchBooksServlet">browse.</a></p>
    </div>

    <footer class="footer"></footer>

</div>
</body>
</html>
