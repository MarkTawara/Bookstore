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

    <title>Manage User</title>

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
    <!-- Custom styles for this template -->
    <link type="text/css" href="css/index.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <!--The login top bar which holds our options to Log In and Sign Up/Register-->
    <div class="top_bar">
        <div class="container">
            <div class="pull-right">
                <ul class="pull-right">
                    <li class="login">Welcome! Admin</li>
                	<li class="login"><a href="adminView.html">admin action</a>
                    <li class="login"><a href="account.html">manage account</a></li>
                    <li class="login"><a href="">order status</a></li>
                    <li class="login shift-left"><a href="shoppingCart.html"><img src="images/shopping-cart.png"></a></li>
                </ul>
            </div>
        </div>
    </div>

    <!--Navigation Bar at the top right which hold links to other sites on our page-->
    <div class="header clearfix">
        <nav>
            <div class="navbar-header">
                <h3>Logo TBD</h3>
            </div>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a href="#">Home</a></li>
                <li role="presentation" class="active"><a href="#">Browse All Books</a></li>
                <li role="presentation"><a href="#">About</a></li>
                <li role="presentation"><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>

    <!--Jumbotron/Our Search area for books-->
    <div class="jumbotron">
        <h2>Manage Users</h2>

        <form id="search_bar">
            <div class="form-group">
                <div class="input-group input-group-lg max_width">
                    <!-- <div class="input-group-addon white-background"><img id="search_img" src="images/search_img_small.png" alt="search"/></div> -->
                    <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Search with username">
                    <span class="input-group-btn">
                        <button class="btn btn-default blue" type="submit">Search</button>
                    </span>
                </div>
            </div>
        </form>
    </div>

    <table> 
        <tr>
            <th><a href="#">Username</a></th>
            <th class="muCol2"><a href="#"></a></th>
        </tr>
        <tr>
            <td>User1<td>
            <td class="muCol2">
            	<button>Edit</button>
            	<button>Delete</button>
            	<button>Suspend</button>
            <td>
        </tr>
        <tr>
            <td>User2<td>
            <td class="muCol2">
            	<button>Edit</button>
            	<button>Delete</button>
            	<button>Suspend</button>
            <td>
        </tr>
        <tr>
            <td>User3<td>
            <td class="muCol2">
            	<button>Edit</button>
            	<button>Delete</button>
            	<button>Suspend</button>
            <td>
        </tr>
        <tr>
            <td>User4<td>
            <td class="muCol2">
            	<button>Edit</button>
            	<button>Delete</button>
            	<button>Suspend</button>
            <td>
        </tr>
    </table>
    
    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div>
</body>
</html>