<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%-- <%@ page import="com.cognizant.truyum.model.MenuItem"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
<title>Edit Menu Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images\truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<h3>Edit Menu Item</h3>
	<div class="body-content-colour">
		<form action="EditMenuItem" name="menuItemForm"
			onsubmit="return validateForm()" method="POST">
			<br>
			<div class="form-field-spacing">
				<label for="name1">Name</label> <input type="text"
					class="text-box text-box-title" name="name" id="name"
					value="${menuItem.name }">
			</div>
			<div class="form-field-spacing">
				<label for="price">Price(Rs.)</label> <input type="text"
					class="currency" name="price" id="price"
					value="<fmt:formatNumber pattern="#####.00"
							value="${menuItem.price }" />">
			</div>
			<div class="form-field-spacing">
			
<!-- 			<label for="active">Active</label> -->
<%-- 			 <input type="radio" name="active" 	<c:if test="${menuItem.active }">checked</c:if> value="yes"/>Yes --%>
<%-- 			 <input type="radio" name="active" 	<c:if test="${!menuItem.active }">checked</c:if> value="no"/>No --%>
			
				<c:choose>
					<c:when test="${(menuItem.active)}">
						<label for="active">Active</label>
						<input class="radio" type="radio" name="active" value="yes"
							checked="checked">Yes
						<input class="radio" type="radio" name="active" value="no">No 
					</c:when>
					<c:otherwise>
						<label for="active">Active</label>
						<input class="radio" type="radio" name="active" value="yes">Yes
						<input class="radio" type="radio" name="active" value="no"
							checked="checked">No
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Lunch</label> <input type="text"
					class="text-box" name="dateOfLaunch"
					value="<fmt:formatDate value="${menuItem.dateOfLaunch }"
							pattern="dd/MM/yyyy" />">
			</div>
			<div class="form-field-spacing">
				<label for="category">Category</label> <select name="category"
					class="dropdown">
					<option value="${menuItem.category }" selected>${menuItem.category }</option>
					<option value="Starter">Starter</option>
					<option value="Main Course">Main Course</option>
					<option value="Dessert">Dessert</option>
					<option value="Drinks">Drinks</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<b><label for="freeDelivery">Free Delivery</label></b> <input
					type="checkbox" name="freeDelivery"
					<c:if test="${menuItem.freeDelivery }">checked</c:if> />
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id }" />
			</div>
			<div class="form-field-spacing">
				<input type="submit" class="button success-button" value="Save">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>