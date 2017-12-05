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

    <title>Edit Suppliers and Shipping Agencies</title>

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
	<form action="editSuppliersAndShipmentAgency.jsp">
        		<select name="business_type" >
				<option value="shipping_agency">Shipment Agency</option>
				<option value="supplier">Supplier</option>
			</select>
			<input type="submit">
	</form>
    <div class="businessTable">
   	<table>
 		<tr>
 			<th>Business Name</th>
 			<th>Address</th>
 			<th>Business Phone</th>
 			<th>Contact Name</th>
 			<th>Email</th>
 			<th>Work phone</th>
 			<th>Cell phone</th>
 			<th>Action</th>
 		</tr>
 		<% 
 		String business_type = request.getParameter("business_type");
 		//System.out.println(business_type);
 		if(business_type != null){
 			bookstore_query db = new bookstore_query();
			ResultSet rs = db.getSuppliersOrShipment(business_type);
			while (rs.next()){
    		%>
 		
 		<tr>
 			<td><%=rs.getString("business_name") %></td>
 			<td><%=rs.getString("business_address") %></td>
 			<td><%=rs.getString("business_phone") %></td>
 			<td><%=rs.getString("contact_name") %></td>
 			<td><%=rs.getString("email") %></td>
 			<td><%=rs.getString("workphone") %></td>
 			<td><%=rs.getString("cellphone") %></td>
 			<td>
 			<form action="EditShipmentServlet" method="post">
  				<input type="text" name="business_name" value="<%=rs.getString("business_name") %>" hidden>
  				<input type="submit" value="Update">
			</form> 	
			<form action="RemoveShipmentServlet" method="post">
  				<input type="text" name="business_name" value="<%=rs.getString("business_name") %>" hidden>
  				<input type="submit" value="Remove">
			</form>
			</td>
  		</tr>
  		<%}}%>
  	</table>
    </div>

    <footer class="footer"></footer>

</div>
</body>
</html>
