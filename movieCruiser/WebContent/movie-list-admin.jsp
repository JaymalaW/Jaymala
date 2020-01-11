<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
<title>Movie List Admin</title>
</head>
<body>
	<div class="headnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://www.clipartmax.com/png/small/1-18589_movie-ticket-invitation-clipart-film-strip-solo-hi-png-film-reel.png"
			alt="Movie Ticket Invitation Clipart Film Strip Solo Hi - Png Film Reel @clipartmax.com">
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<h1 class="message">Movies</h1>
	<table id="myTable">
		<tr>
			<th>Title</th>
			<th class="currency">Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movieListItem}" var="movieList">
			<tr>
				<td>${movieList.title }</td>
				<td class="currency"><fmt:formatNumber
						pattern="$#,##,##,##,###" value="${movieList.gross }" /></td>
				<td><c:if test="${movieList.active }">Yes</c:if> <c:if
						test="${!movieList.active }">No</c:if></td>
				<td><fmt:formatDate value="${movieList.dateOfLaunch }"
						pattern="dd/MM/yyyy" /></td>
				<td>${movieList.genre }</td>
				<td><c:if test="${movieList.teaser }">Yes</c:if> <c:if
						test="${!movieList.teaser }">No</c:if></td>
				<td><a href="ShowEditMovie?id=${movieList.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footnav">
		<h3>Copyright &copy; 2019</h3>
	</div>
</body>
</html>