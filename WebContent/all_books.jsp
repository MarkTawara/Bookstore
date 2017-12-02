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

    <!--Jumbotron/Our Search area for books-->
    <div class="jumbotron">
        <h2>Looking for something in particular?</h2>

        <form id="search_bar">
            <div class="form-group">
                <div class="input-group input-group-lg max_width">
                    <!-- <div class="input-group-addon white-background"><img id="search_img" src="images/search_img_small.png" alt="search"/></div> -->
                    <input type="text" class="form-control" id="inlineFormInputGroup" name="keyword" placeholder="Search">
                    <span class="input-group-btn">
                        <button class="btn btn-default blue" type="submit">Search</button>
                    </span>
                </div>
                <a class="input-advanced" href="advancedSearch.html">Advanced Search</a>
            </div>
        </form>
    </div>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table>
		<tr>
			<th><a href="#">Title</a></th>
            <th><a href="#">Author</a></th>
            <th><a href="#">Publisher</a></th>
            <th><a href="#">Price</a></th>
<!--             <th><a href="#">Rating</a></th> -->
            <th><a href="#">Option</a></th>
		</tr>
		<c:forEach items="${results}" var="book">
			<tr>
				<td>
					${book.title}
					<img class="center-img carousel-img" src="data:image/jpg;base64,'${book.cover_picture}'" alt="book image"/>
					ISBN: ${book.isbn}
				</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.publisher}</td>
				<td>${book.price}</td>
				<td><form action="AddToCartServlet" method="post">Qty:<input type="number" name="qty" min="1" max="99"><input type="submit" value="Add to Cart""></form><td>
			</tr>
		</c:forEach>
	</table>
    
    <footer class="footer"></footer>

</div>
</body>
</html>
