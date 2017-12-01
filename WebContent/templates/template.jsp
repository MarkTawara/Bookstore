<!DOCTYPE html>
<html>
<head>
<script src="../scripts/jquery-3.2.1.js"></script>
</head>
<body>
	<div class="top_bar">
		<div class="container">
			<div class="pull-right">
				<%
					if (session.getAttribute("name") == null) {
				%>
				<ul class="pull-right">
					<li class="login"><a href="login.jsp">Log In</a></li>
					<li class="login"><small>|</small></li>
					<li class="login shift-left"><a href="Registration.jsp">Create an Account</a></li>
				</ul>
				<%} else if(session.getAttribute("type").toString().equals("customer")){%>
				<!-- Show customer view -->
				<ul class="pull-right">
					<li class="login">
						<%
							String name = session.getAttribute("name").toString();
							out.println("Welcome  " + name + "        ");
						%>
					</li>
					<li class="login"><a href="account.jsp">View Account</a></li>
					<li class="login"><small>|</small></li>
					<li class="login"><a href="DisplayCartServlet"><img src="images/shopping-cart.png"></a></li>
					<li class="login"><small>|</small></li>
					<li class="login shift-left"><a href="LogoutServlet">Logout</a></li>
				</ul>
				<%} else if(session.getAttribute("type").toString().equals("manager")){%>
				<!-- Show manager view -->
				<ul class="pull-right">
					<li class="login">
						<%
							String name = session.getAttribute("name").toString();
							out.println("Welcome  " + name + "        ");
						%>
					</li>
					<li class="login"><a href="account.jsp">View Account</a></li>
					<li class="login"><small>|</small></li>
					<li class="login"><a href="adminView.jsp">Manager Actions</a>
					<li class="login"><small>|</small></li>
					<li class="login shift-left"><a href="LogoutServlet">Logout</a></li>
				</ul>
				<%} else if(session.getAttribute("type").toString().equals("shipping")){%>
				<!-- Show shipping employee view -->
				<ul class="pull-right">
					<li class="login">
						<%
							String name = session.getAttribute("name").toString();
							out.println("Welcome  " + name + "        ");
						%>
					</li>
					<li class="login"><a href="account.jsp">View Account</a></li>
					<li class="login"><small>|</small></li>
					<li class="login"><a href="shipping_manager.jsp">Shipping Actions</a>
					<li class="login"><small>|</small></li>
					<li class="login shift-left"><a href="LogoutServlet">Logout</a></li>
				</ul>
				<%}else{ %>
				<!-- Idk if it actually goes here ever -->
				<%} %>
			</div>
		</div>
	</div>
	
	<div id="navibarHome" class="header clearfix">
		<nav>
			<div class="navbar-header">
				<h3>Logo TBD</h3>
			</div>
			<ul class="nav nav-pills pull-right">
				<li role="presentation" class="active"><a href="index.jsp">Home</a></li>
				<li role="presentation"><a href="all_books.jsp">Browse All
						Books</a></li>
				<li role="presentation"><a href="about.jsp">About</a></li>
				<li role="presentation"><a href="#">Contact</a></li>
			</ul>
		</nav>
	</div>
	
	<div id="navibarBrowse" class="header clearfix">
		<nav>
			<div class="navbar-header">
				<h3>Logo TBD</h3>
			</div>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="index.jsp">Home</a></li>
				<li role="presentation" class="active"><a href="all_books.jsp">Browse All
						Books</a></li>
				<li role="presentation"><a href="about.jsp">About</a></li>
				<li role="presentation"><a href="#">Contact</a></li>
			</ul>
		</nav>
	</div>
	
	<div id="navibarAbout" class="header clearfix">
		<nav>
			<div class="navbar-header">
				<h3>Logo TBD</h3>
			</div>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="index.jsp">Home</a></li>
				<li role="presentation"><a href="all_books.jsp">Browse All
						Books</a></li>
				<li role="presentation" class="active"><a href="about.jsp">About</a></li>
				<li role="presentation"><a href="#">Contact</a></li>
			</ul>
		</nav>
	</div>
	
	<div id="navibar" class="header clearfix">
		<nav>
			<div class="navbar-header">
				<h3>Logo TBD</h3>
			</div>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="index.jsp">Home</a></li>
				<li role="presentation"><a href="all_books.jsp">Browse All
						Books</a></li>
				<li role="presentation"><a href="about.jsp">About</a></li>
				<li role="presentation"><a href="#">Contact</a></li>
			</ul>
		</nav>
	</div>
	
	
	<footer class="footer">
		<p>&copy; 2016 Company, Inc.</p>
	</footer>

</body>
</html>