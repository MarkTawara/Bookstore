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

	<!--Main information for the page is here-->
	
    <div class="row marketing">
        <h1 class="center-text">Account Settings</h1>
        <div class="account_sections">
        	<h3>Change Your Name</h3>
        	Current Name: mark tawara<br>
        	New First Name: <input type="text" name="newFirstName" value="">
        	New Last Name: <input type="text" name="newLastName" value=""><br>
        	<input type="submit" value="Save Changes"> Cancel
        </div>
        <hr>
        <div class="account_sections">
        	<h3>Change Your Email Address</h3>
        	Current Email Address: mark@gmail.com<br>
        	New Email Address: <input type="text" name="newEmail" value=""><br>
        	Confirm New Email Address: <input type = "text" name="newEmailConfirm" value=""><br>
        	<input type="submit" value="Save Changes"> Cancel
        </div>
        <hr>
        <div class="account_sections">
        	<h3>Change Your Password</h3>
        	Current Password: <input type="password" name="currentPassword" value=""><br>
        	New Password: <input type = "password" name="newPassword" value=""><br>
        	<input type="submit" value="Save Changes"> Cancel
        </div>
        <hr>
        <div class="account_sections">
        	<h3>Change Your Phone Number</h3>
        	Current Phone Number: 770-123-1234<br>
        	New Phone Number: <input type="text" name="newPhone" value=""><br>
        	<input type="submit" value="Save Changes"> Cancel
        </div>
        <hr>
        <div class="account_sections">
        	<h3>Change Your Promotion Settings</h3>
        	Do you want to subscribe to any available promotions in the future?<br>
        	<button>Subscribe</button> <button>Unsubscribe</button>
        </div>
    </div>

    <footer class="footer"></footer>

</div>
</body>
</html>
