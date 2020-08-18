<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
background-color: ${color};
}

</style>
</head>
<body>
<h1>Color Picker</h1>


You have picked a <c:out value="${bgcolor}"/> page.
</body>
</html>