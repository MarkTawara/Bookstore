<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import= "logic_layer.bookstore_query"%>

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

	<div style="color: #FF0000;">${removeMessage}</div>
    <div class="bookTable">
   	<table>
 		<tr>
 			<th>Title</th>
 			<th>Author</th>
 			<th>Price</th>
 			<th>ISBN</th>
 			<th>Edition</th>
 			<th>Publisher</th>
 			<th>Publication Year</th>
 			<th>In Stock</th>
 			<th>Minimum Threshold</th>
 			<th>Action</th>
 		</tr>
 		<% 
   		bookstore_query db = new bookstore_query();
		ResultSet rs = db.getBooks();
		while (rs.next()){
    		%>
 		
 		<tr>
 			<td><%=rs.getString("title") %></td>
 			<td><%=rs.getString("author") %></td>
 			<td><%=rs.getDouble("price") %></td>
 			<td><%=rs.getString("isbn") %></td>
 			<td><%=rs.getInt("edition") %></td>
 			<td><%=rs.getString("publisher") %></td>
 			<td><%=rs.getString("publication_year") %></td>
 			<td><%=rs.getInt("quantity_in_stock") %></td>
 			<td><%=rs.getInt("minimum_threshold") %></td>
 			<td>
 			<form action="EditBookServlet" method="post">
  				<input type="text" name="title" value="<%=rs.getString("title") %>" hidden>
  				<input type="submit" value="Edit">
			</form> 	
			<form action="RemoveBookServlet" method="post">
  				<input type="text" name="title" value="<%=rs.getString("title") %>" hidden>
  				<input type="submit" value="Remove">
			</form>
			</td>
  		</tr>
  		<%}%>
  	</table>
    </div>

    <footer class="footer"></footer>

</div>
</body>
</html>
