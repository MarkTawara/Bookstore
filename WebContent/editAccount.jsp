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
    <!-- JQuery template stuff -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script>
  		$( function() {
   			$( "#tabs" ).tabs();
 		} );
  	</script>
	</head>

<body>
<div class="container">
    <!--The login top bar which holds our options to Log In and Sign Up/Register-->
	<div class="top_bar"></div>
	
	<!--Navigation Bar at the top right which hold links to other sites on our page-->
    <div id="navibar" class="header clearfix"></div>

	<!--Main information for the page is here-->
	
    
    <h1>Edit Account</h1>
    <div style="color: #FF0000;">${saveMessage}</div>
    <% 
    HttpSession sesh = request.getSession(false);
	String email = (String)sesh.getAttribute("email");
    bookstore_query db = new bookstore_query();
	ResultSet rs = db.getUserInfo(email);
	while (rs.next()){
    %>
 
	<div id="tabs">
	  <ul>
	    <li><a href="#tabs-1">General</a></li>
	    <li><a href="#tabs-2">Shipping</a></li>
	    <li><a href="#tabs-3">Billing</a></li>
	  </ul>
	  <div id="tabs-1">
	  	<b>Current Settings:</b><br>
	  	Name: <%out.println(rs.getString("customer_name"));%><br>
	  	Email: <%out.println(rs.getString("email"));%><br>
	  	Phone: <%out.println(rs.getString("phone_number"));%><br>
	  	Subscribed to promotions and newsletter: 
	  	<%if(rs.getInt("is_subscribed")==1){out.println("Yes");} 
	  	else{out.println("No");}
	  	%>
		
		<br><br>
		<form action="EditAccountServlet" method="post" name="account_edit_form">
			<input type="text" name="form_number" value = "1" hidden>
		  	First Name: <input type="text" name="firstname" id="firstname"><br>
		  	Last Name: <input type="text" name="lastname" id="lastname"><br>
			Email: <input type="text" name="email" id="email">
			<div style="color: #FF0000;">${errorMessage}</div> 
			Password: <input type="password" name="password" id="password"><br>
			Phone Number: <input type="text" name="phonenum" id="phonenum" ><br>
			Subscribe to promotions and newsletter: 
			<input type="radio" name="subscribed" value="-1" hidden checked>
			<input type="radio" name="subscribed" value="1"> Yes
			<input type="radio" name="subscribed" value="0"> No
			<br>
			<input type="submit" id="save_changes_button" value="Save Changes">
		</form>
	  </div>
	  
	  <div id="tabs-2">
	  <b>Current Shipping Address:</b><br>
	  <%out.println(rs.getString("shipping_address"));%>
	  <br><br>
	  <form action="EditAccountServlet" method="post" name="account_edit_form">
	  	<input type="text" name="form_number" value = "2" hidden>
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
			<input type="submit" id="save_changes_button" value="Save Changes">
			</form>
	  </div>
	  
	  <div id="tabs-3">
	  <b>Current Billing Information:</b><br>
	  
	  Card ending in: 
	  <%String cardnum= rs.getString("card_num"); 
	  out.println(cardnum.subSequence(cardnum.length()-4, cardnum.length()));%><br>
	  Billing Address: <%out.println(rs.getString("billing_address"));%> 
	  <br><br>
	  <b>Change Card:</b>
	  <form action="EditAccountServlet" method="post" name="account_edit_form">
	  		<input type="text" name="form_number" value = "3" hidden>
			<input type="radio" name="cardtype" value="visa" checked> Visa 
	 		<input type="radio" name="cardtype" value="mastercard"> MasterCard 
	  		<input type="radio" name="cardtype" value="americanexpress"> American Express
			<br>
			Card Number: <input type="text" name="cardnum" id="cardnum" required><br>
			Expiration Date: 
			<select name='expireMM'>
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
			<select name='expireYY'>
			   <!-- <option value=''>Year</option>-->
			    <option value='17'>2017</option>
			    <option value='18'>2018</option>
			    <option value='19'>2019</option>
			    <option value='20'>2020</option>
			    <option value='21'>2021</option>
			</select> 
			
			<!-- CCV:<input type="text" name="ccv" required><br> -->
			<br>
			<input type="submit" id="save_changes_button" value="Save Changes">
			<br>
			<br>
		</form>
		<form action="EditAccountServlet" method="post" name="account_edit_form">
			<input type="text" name="form_number" value = "4" hidden>
			<b>Change Billing Address:</b><br>
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
			<input type="submit" id="save_changes_button" value="Save Changes">
			
			</form>
	  </div>
	</div>
   
    <%} %>

    <footer class="footer"></footer>

</div>
</body>
</html>
