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
<title>Edit Movie</title>
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
	<div class="body-content-colour">
		<form action="EditMovie" name="editMovieStatus"
			onsubmit="return validateForm()" method="POST">
			<br>
			<div class="form-field-spacing">
				<label for="name1">Title</label> <input type="text"
					class="text-box text-box-title" name="title" id="name1"
					value="${movieList.title }">
			</div>
			<div class="form-field-spacing">
				<label for="gross">Gross($)</label> <br> <input type="text"
					class="text-box" name="gross" id="gross"
					value="<fmt:formatNumber pattern="####"
							value="${movieList.gross }" />">
			</div>
			<div class="form-field-spacing">
				<label for="active">Active</label> <br> <input class="radio"
					type="radio" name="active" value="yes"
					<c:if test="${movieList.active }">checked</c:if>>Yes <input
					class="radio" type="radio" name="active" value="no"
					<c:if test="${!movieList.active }">checked</c:if>>No
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Lunch</label> <br> <input
					type="text" class="text-box" name="dateOfLaunch"
					value="<fmt:formatDate value="${movieList.dateOfLaunch}"
							pattern="dd/MM/yyyy" />">
			</div>
			<div class="form-field-spacing">
				<label for="genre">Genre</label> <br> <select name="genre"
					class="dropdown">
					<option value="${movieList.genre}" selected>${movieList.genre}</option>
					<option value="scienceFiction">Science Fiction</option>
					<option value="superhero">Superhero</option>
					<option value="romance">Romance</option>
					<option value="comedy">Comedy</option>
					<option value="adventure">Adventure</option>
					<option value="thriller">Thriller</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<label for="teaser">Has Teaser</label> <input type="checkbox"
					name="teaser" <c:if test="${movieList.teaser }">checked</c:if> />
			</div>
			<br>
			<div>
				<input type="hidden" name="id" value="${movieList.id }" />
			</div>
			<div class="form-field-spacing">
				<input type="submit" class="button success-button" value="Save">
			</div>
		</form>
	</div>
	<div class="footnav">
		<h3>Copyright &copy; 2019</h3>
	</div>
</body>
</html>