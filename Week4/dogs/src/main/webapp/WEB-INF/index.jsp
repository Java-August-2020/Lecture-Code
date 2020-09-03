<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Dogs dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to Dogs dot Com</h1>
<a href="/new">Create a new four legged best buddy.</a> - <a href="/toys/new">Gift a Dog a Toy</a>
<hr>
<table class="table table-dark">
<thead>
<td>Id</td>
<td>Name</td>
<td>Breed</td>
<td>Age</td>
<td>Tag</td>
</thead>
<tbody>
<c:forEach items="${allDogs}" var="dog">
<tr>

<td>${dog.id}</td>
<td><a href="/${dog.id}">${dog.name}</a></td>
<td>${dog.breed}</td>
<td>${dog.age}</td>
<td>
<c:choose>
<c:when test="${dog.tag != null }">
${dog.tag.city}, ${dog.tag.state}
</c:when>
<c:otherwise>
<font color="#ff0000">** Not Registered **</font>
</c:otherwise>
</c:choose>
</td>


</tr>
</c:forEach>

</tbody>
</table>

</div>
</body>
</html>