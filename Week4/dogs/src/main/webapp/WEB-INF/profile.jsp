<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<t:wrapper>
<h2>User Details for ${user.firstName} ${user.lastName }</h2>
<hr>
<h3>Dogs Owned:</h3>
<ul>
<c:forEach items="${user.dogs}" var="dog">
<li><a href="${dog.id }">${dog.name }</a>
</c:forEach>
</ul>
</t:wrapper>

</body>
</html>