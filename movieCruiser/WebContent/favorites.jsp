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
<title>Favorites</title>
</head>
<body>
	<div class="headnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://www.clipartmax.com/png/small/1-18589_movie-ticket-invitation-clipart-film-strip-solo-hi-png-film-reel.png"
			alt="Movie Ticket Invitation Clipart Film Strip Solo Hi - Png Film Reel @clipartmax.com">
		<a href="ShowMovieListCustomer">Movies</a> <a href="ShowFavorite">Favorites</a>
	</div>
	<h1 class="message">Favorites</h1>
	<c:if test="${message }">
		<div class="success-message">Item removed from Favorites
			Successfully</div>
	</c:if>
	<table id="myTable">
		<tr>
			<th>Title</th>
			<th class="currency">Box Office</th>
			<th>Genre</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${favorites.movieList}" var="movieList">
			<tr>
				<td>${movieList.title}</td>
				<td class="currency"><fmt:formatNumber
						pattern="$#,##,##,##,###" value="${movieList.gross }" /></td>
				<td>${movieList.genre }</td>
				<td><a href="RemoveFavorite?id=${movieList.id }">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><b>No. of Favorites: </b></td>
			<td><b>${favoritesCount }</b></td>
		</tr>
	</table>
	<div class="footnav">
		<h3>Copyright &copy; 2019</h3>
	</div>
</body>
</html>