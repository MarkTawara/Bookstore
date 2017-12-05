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

    <title>Edit Account</title>

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

	<!--Main information for the page is here-->
	
    
    <h1>Update Book</h1>
    <div style="color: #FF0000;">${saveMessage}</div>
    <% 
    String title = (String)request.getAttribute("title");
    bookstore_query db = new bookstore_query();
	ResultSet rs = db.getBookFromDb(title);
	if (rs.next()){
    %>
 
		<form action="UpdateBookInfoServlet" method="post" name="account_edit_form">
			* Title: <%out.println(rs.getString("title"));%>
			<input name="title" id="title" value="<%=rs.getString("title")%>" hidden>
			<br />
			* Author: <input name="author" id="author" value="<%=rs.getString("author")%>"><br />
			* Price: $<input type="number" step="000.01" name="price" id="price" value="<%=rs.getDouble("price")%>"><br />
			* ISBN: <input name="isbn" id="isbn" value="<%=rs.getString("isbn")%>"><br />
			* Edition: <input name="edition" id="edition" value=<%=rs.getInt("edition")%>><br />
			* Publisher: <input name="publisher" id="publisher" value="<%=rs.getString("publisher")%>"><br />
			* Publication Year: <input name="publication_year" id="publication_year" value="<%=rs.getString("publication_year")%>"><br />
			* Description: <br /><textarea name="descr" id="descr" rows="5" cols="50" value=""><%=rs.getString("description")%></textarea><br />
			* Quantity in Stock: <input name="qty_in_stock" id="qty_in_stock" value="<%=rs.getInt("quantity_in_stock")%>"><br />
			<img id="myImg" src="http://shashgrewal.com/wp-content/uploads/2015/05/default-placeholder.png" alt="your image" width="150" height="200"/><br/>
			* Image: <input type="file" name="image" id="image" onchange="readURL(this)" /> (Accepted formats include .jpg, .jpeg, .png)<div id="imageFailure"></div><br />
			* All inputs are required for submission.
			<br>
			<input type="submit" id="save_changes_button" value="Save Changes">
		</form>
	 
   
    <%} %>

    <footer class="footer"></footer>

</div>
</body>
</html>
