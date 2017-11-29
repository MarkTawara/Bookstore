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

    <title>Bookstore</title>

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
    <!-- Custom styles for this template -->
    <link type="text/css" href="css/index.css" rel="stylesheet">
    <!-- Open Sans link -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
</head>

<body>
<div class="container">
    <!--The login top bar which holds our options to Log In and Sign Up/Register-->
    <div class="top_bar">
        <div class="container">
            <div class="pull-right">
            		<% if (session.getAttribute("name") == null) { %>
            			<ul class="pull-right">
                    		<li class="login"><a href="login.jsp">Log In</a></li>
                    		<li class="login"><small>or</small></li>
                    		<li class="login shift-left"><a href="registration.html">Create an Account</a></li>
                		</ul>
				<% } else {%>
    					<ul>
                    		<li>
                    		<% 
                    		String name = session.getAttribute("name").toString();
                    		out.println("Welcome  "+ name + "        ");
                    		%>
                    		</li>
                    		<li><a href="account.html">View Account</a></li>
                    		<li><a href="LogoutServlet">Logout</a></li>
                		</ul>
				<% } %>
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
                <li role="presentation" class="active"><a href="index.html">Home</a></li>
                <li role="presentation"><a href="all_books.html">Browse All Books</a></li>
                <li role="presentation"><a href="#">About</a></li>
                <li role="presentation"><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>
    <!-- About Us text -->
    <h2 id="about-us-header">About Us</h2>
    <p class="about-us-text">
        Founded in recently in 2017, (Name) is a new start-up dedicated to bringing the descriptive literate
        books to feed their need for knowledge at a delectable rate. We originally started in Athens, GA at
        the University of Georgia as a class project but soon grew up from these roots to be a fully fledged
        company.
    </p>
    <p class="about-us-text">
        We contain numerous categories whether it be fiction, fantasy,
        non-fiction, science-fiction, magazines, anime, etc.
        Notice a book we don't have? Make sure to point it out and we'll get right on it to add your selected
        book into our large repository of books.
    </p>
    <p class="about-us-text">
        Contact us through email at delectableBooks@gmail.com
    </p>


    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div>
</body>
</html>
