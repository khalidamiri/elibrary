 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>eLibrary: Home</title>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.ui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/theme.ui/jquery.ui.min.css" />
	<script type="text/javascript" src="js/ui.js"></script>
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<%!
			String userName = session.getAttribute("userName");
	 %>
	<div id="hdrWrapper">
		<div id="hdr">
			<h1>eLibrary</h1>
			<button class="primary" id="uploadBtn">Upload</button>
			<%
					if(userName.isEmpty()){ %>
						<button id="registerBtn" class="loginRegister">Register</button>
						<button id="showLoginBtn" class="loginRegister">Login</button>
						<div id="topLogin">
							<form action="LoginServlet" method="POST">
								<input type="text" name="loginUserName" id="loginUserName" value="Username" /><br />
								<input type="text" name="loginPassword" id="loginPassword" value="Password" /><br />
								<a href="" style="float:right;">I forgot my password.</a>
								<button type="submit" id="loginSubmitBtn">Login</button>
							</form>
						</div>
					<% }else{ %>
						<div id="topLogin">Hi <% userName %>
						</div>
					<%}		
			%>
			<form id="search">
				<input type="text" name="search" value="Search" id="searchBox" />
				<button type="submit" id="searchBtn"></button>
			</form>
		</div>
	</div>
	<div id="contentWrapper">
		<div id="hdr2">
			<ul id="categories">
			</ul>
		</div>

		<div id="mainContent">
		Here.
		</div>
	</div>
</body>
</html>