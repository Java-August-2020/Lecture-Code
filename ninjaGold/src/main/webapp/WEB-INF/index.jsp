<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="wrapper">
<p>Your Gold: <c:out value="${totalGold}"/></p>

<div class="box">
<h5>Farm</h5>
<p>(earn 10-20 gold)</p>
<form method="post" action="/activity">
<input type="hidden" name="building" value="farm">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>Cave</h5>
<p>(earn 5-10 gold)</p>
<form method="post" action="/activity">
<input type="hidden" name="building" value="cave">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>House</h5>
<p>(earn 2-5 gold)</p>
<form method="post" action="/activity">
<input type="hidden" name="building" value="house">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>Casino</h5>
<p>(earn/lose 0-50 gold)</p>
<form method="post" action="/activity">
<input type="hidden" name="building" value="casino">
<input type="submit" value="Find Gold!">
</form>
</div>
<h3>Activities</h3>
<div class="activities">

<c:forEach items="${activityLog}" var="activity">
<p class='${activity.contains("lost")? "red": "green"}'><c:out value="${activity}"/></p>

</c:forEach>
</div>
</div>
</body>
</html>