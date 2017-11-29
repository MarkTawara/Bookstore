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
	
    <div class="regDiv">
        <h1>Create account</h1>
        All inputs are required
        <form action="SignUpServlet" method="post" name="registration_form" id="registration_form" >
			First name: <input type="text" name="firstname" id="firstname" required><br>
			Last name: <input type="text" name="lastname" id="lastname" required><br>
			Email: <input type="text" name="email" id="email" required>
			<p id="email_error"></p> 
			Password: <input type="password" name="password" id="password" required><br>
			Phone Number: <input type="text" name="phonenum" id="phonenum" required><br>
			Subscribe to promotions and newsletter: 
			<input type="radio" name="subscribed" value="1" checked> Yes
			<input type="radio" name="subscribed" value="0"> No
			<br>
			<br>
			Shipping Address:<br>
			Street: <input type="text" name="street" id="street" required><br>
			City: <input type="text" name="city" id="city" required>
			State: 
			<select name="state" >
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>
			Zip Code: <input type="text" name="zip" id="zip" required><br>
			<br>
			Billing Info: <br>
			<input type="radio" name="cardtype" value="visa" checked> Visa 
	 		<input type="radio" name="cardtype" value="mastercard"> MasterCard 
	  		<input type="radio" name="cardtype" value="americanexpress"> American Express
			<br>
			Card Number:<input type="text" name="cardnum" id="cardnum" required><br>
			Expiration Date: 
			<select name='expireMM' required>
		   		<!--  <option value=''>Month</option> -->
		 		<option value='01'>01</option>
		    		<option value='02'>02</option>
		    		<option value='03'>03</option>
		    		<option value='04'>04</option>
		    		<option value='05'>05</option>
		    		<option value='06'>06</option>
		    		<option value='07'>07</option>
		    		<option value='08'>08</option>
		    		<option value='09'>09</option>
		    		<option value='10'>10</option>
		    		<option value='11'>11</option>
		    		<option value='12'>12</option>
			</select> 
			<select name='expireYY' required>
			   <!-- <option value=''>Year</option>-->
			    <option value='17'>2017</option>
			    <option value='18'>2018</option>
			    <option value='19'>2019</option>
			    <option value='20'>2020</option>
			    <option value='21'>2021</option>
			</select> 
			
			<!-- CCV:<input type="text" name="ccv" required><br> -->
			<br>
			Billing Address: <br>
			<!--  <input type="checkbox" name="billingEqualsShipping" value="true"> Same as shipping address<br>  -->
			Street: <input type="text" name="street2" id="street2" required><br>
			City: <input type="text" name="city2" id="city2" required>
			State: 
			<select name="state2">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>
			Zip Code: <input type="text" name="zip2" id="zip2" required><br>
			
			<br><br>
			<input type="submit" id="create_account_button" value="Create Account">
		</form>
    </div>

    <footer class="footer"></footer>

</div>
</body>
</html>
