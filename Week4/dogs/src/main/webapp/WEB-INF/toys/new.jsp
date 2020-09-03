<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gift a Toy</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Give a Dog a new Toy</h1>
<hr>
<form:form method="POST" action="/toys" modelAttribute="toy">
<div class="form-group">
<form:label path="dog">Gift This Toy To:</form:label>
<form:errors path="dog"/>
<form:select path="dog">
<c:forEach items="${dogs}" var="dog">
<option value="${dog.id}">${dog.name}</option>
</c:forEach>
</form:select>
</div>

<div class="form-group">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    </div>
    <div class="form-group">
    <form:label path="price">Price
    <form:errors path="price"/>
    <form:input  type="decimal" path="price"/></form:label>
    </div>
	<div class="form-group">
    <form:label path="color">Color
    <form:errors path="color"/>
    <form:input path="color"/></form:label>
	</div>
	
	<button>Gift Toy</button>
</form:form>



</div>
</body>
</html>