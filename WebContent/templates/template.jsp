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
					<li class="login"><small>or</small></li>
					<li class="login shift-left"><a href="Registration.jsp">Create an Account</a></li>
				</ul>
				<%} else {%>
				<ul class="pull-right">
					<li class="login">
						<%
							String name = session.getAttribute("name").toString();
							out.println("Welcome  " + name + "        ");
						%>
					</li>
					<li class="login"><a href="account.jsp">View Account</a></li>
					<li class="login"><small>or</small></li>
					<li class="login shift-left"><a href="LogoutServlet">Logout</a></li>
				</ul>
				<%}%>
			</div>
		</div>
	</div>
	
	<div id="navibar" class="header clearfix">
		<nav>
			<div class="navbar-header">
				<h3>Logo TBD</h3>
			</div>
			<ul class="nav nav-pills pull-right">
				<li role="presentation" class="active"><a href="index.jsp">Home</a></li>
				<li role="presentation"><a href="all_books.html">Browse All
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