<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Book</h1>
	<form action="UploadDoc">
		File: <input type="file" name="file" />
		Title: <input type="text" name="title" />
		Author: <input type="text" name="author" />
		<input type="submit" value="Upload" />
	</form>
</body>
</html>