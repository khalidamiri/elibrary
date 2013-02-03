<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<p>Please enter your username and password</p>
	<form action="LoginServlet">
		<input type="text" name="userName" />
		<input type="password" name="password" />
		<input type="submit" name="submit" />
	</form>
</body>
</html>