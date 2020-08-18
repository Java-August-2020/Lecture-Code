<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to the best website on the web!</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Hello From Java</h1>
<hr>
<form method="post" action="/process">
<p>Name:<input type="text" name="name"></p>
<p>Location:<input type="text" name="location"></p>
<p>Favorite Color:<input type="text" name="color"></p>
<button>Submit</button>



</form>
</body>
</html>