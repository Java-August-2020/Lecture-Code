<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results of my awesome site</title>
</head>
<body>
<h1>Results:</h1>
<p>Name: <c:out value="${name}"/></p>
<p>Location: <c:out value="${location}"/></p>
<p>Fav. Color: <c:out value="${color}"/></p>

</body>
</html>