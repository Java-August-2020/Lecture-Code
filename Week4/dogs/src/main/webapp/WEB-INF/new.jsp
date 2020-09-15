<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new pet</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

<div class="container">
<h1>Add a new Dog</h1>
<hr>
<form:form action="/" method="post" modelAttribute="dog">
    <form:hidden path="owner" value="${ userID }"/>
    <div class="form-data">
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </div>
    <p>
        <form:label path="breed">Breed</form:label>
        <form:errors path="breed"/>
        <form:input path="breed"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>
    

    <button>Add Dog To Database</button>
</form:form>    

</div>
</body>
</html>