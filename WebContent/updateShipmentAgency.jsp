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

    <title>Edit Supplier or Shipment Agency</title>

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
	
    <div>
        <h1>Edit Supplier or Shipment Agency</h1>
        
        All inputs are required.<br><br>
        <% 
		String business_type = (String)request.getAttribute("business_type");
		String business_name = (String)request.getAttribute("business_name");
		System.out.println(business_name);
    		bookstore_query db = new bookstore_query();
		ResultSet rs = db.getABusiness(business_type, business_name);
		if (rs.next()){
    		%>
    		<b>Current Settings:</b><br>
	  	Business Name:<%out.println(rs.getString("business_name"));%><br>
	 	Address: <%out.println(rs.getString("business_address")); %><br>
	 	Phone: <%out.println(rs.getString("business_phone")); %><br>
	 	Contact Name: <%out.println(rs.getString("contact_name"));%><br>
	 	Email: <% out.println(rs.getString("email")); %><br>
	 	Workphone: <%out.println(rs.getString("workphone")); %><br>
	 	Cellphone: <%out.println(rs.getString("cellphone")); %><br>
	 	<%} %>
        <form action="UpdateShippingAgencyServlet" method="post">
       		Business Name: <input type="text" name="business_name"><br>
       		<b>Address</b> <br>
       		Street: <input type="text" name="street" id="street"><br>
			City: <input type="text" name="city" id="city">
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
			Zip Code: <input type="text" name="zip" id="zip"><br>
       		Phone number: <input type="text" name="businessphone"><br><br>
       		<b>Contact person information: </b><br>
       		Name: <input type="text" name="contact_name" ><br>
       		E-mail address: <input type="email" name="email" id="email"><br>
       		Business phone number: <input type="text" name="workphone"><br>
       		Cellphone number: <input type="text" name="cellphone"><br>
			
			<br><br>
			<input type="submit" value="Update">
			<a href="editSuppliersAndShipmentAgency.jsp">Cancel</a>
		</form>
    </div>

    <footer class="footer"></footer>

</div>
</body>
</html>
