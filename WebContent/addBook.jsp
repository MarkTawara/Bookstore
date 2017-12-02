<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <!-- JavaScript / jQuery for uploading a book -->
    <script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="scripts/addBook.js"></script>
    
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

 		<!-- 
 		This is the form used to input book info to the database 
 		Corresponds to the AddBook Servlet's post method.
 		Relies on addBook.js for error checking
 		-->
 		
		<form ACTION="AddBook" method="post" id="addBookForm" enctype="multipart/form-data">
			<fieldset>
				<legend style="width:auto;">Add a book to the database</legend>
				* Title: <input name="bookTitle" id="title" value="" required><br />
				* Author: <input name="author" id="author" value="" required><br />
				* Price: $<input type="number" step="000.01" name="price" id="price" value="" required><br />
				* ISBN: <input name="isbn" id="isbn" value="" required><br />
				* Edition: <input name="edition" id="edition" value="" required><br />
				* Publisher: <input name="publisher" id="publisher" value="" required><br />
				* Publication Year: <input name="publication_year" id="publication_year" value="" required><br />
				* Description: <br /><textarea name="descr" id="descr" rows="5" cols="50" required></textarea><br />
				* Quantity in Stock: <input name="qty_in_stock" id="qty_in_stock" value="" required><br />
				<img id="myImg" src="http://shashgrewal.com/wp-content/uploads/2015/05/default-placeholder.png" alt="your image" width="150" height="200"/><br/>
				* Image: <input type="file" name="image" id="image" onchange="readURL(this)" /> (Accepted formats include .jpg, .jpeg, .png)<div id="imageFailure"></div><br />
				* All inputs are required for submission.
				<div class="bdBtnDiv">
					<input type="submit" name="submitBook" value="Add Book" />
				</div>
			</fieldset>
		</form>
		 
		<footer class="footer"></footer>

	</div>
</body>

<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#myImg')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}
    </script>
</html>
