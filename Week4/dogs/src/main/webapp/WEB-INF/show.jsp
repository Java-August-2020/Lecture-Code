<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet Details Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Details For <c:out value="${dog.name}"/></h1>
<hr>
<p>Name: ${dog.name}</p>
<p>Breed: ${dog.breed}</p>
<p>Age: ${dog.age}</p>
<c:choose>
<c:when test="${dog.tag != null}">
<p> City: ${dog.tag.city}</p>
<p> State: ${dog.tag.state}</p>
</c:when>
<c:otherwise>
<form:form method="POST" action="/tag" modelAttribute="tag">
	<div class="form-data">
		<form:label path="city">City</form:label>
		<form:errors path="city"/>
		<form:input path="city"/>
	</div>
		<div class="form-data">
		<form:label path="state">state</form:label>
		<form:errors path="state"/>
		<form:input path="state"/>
	</div>
	<form:hidden path="dog" value="${dog.id}"/>
	<button>Register This Pet!</button>
</form:form>
</c:otherwise>
</c:choose>


<hr>
<form:form action="/${dog.id}" method="post" modelAttribute="dog">
<input type="hidden" name="_method" value="put">
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
    <button>Edit Dog Details</button>
</form:form>  
</div>  
</body>
</html>