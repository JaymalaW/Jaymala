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
<title>Menu Item List Customer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images\truyum-logo-light.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="field-spacing">
		<div class="message">
			<h3>Menu Items</h3>
		</div>
		<c:if test="${addCartStatus }">
			<div class="success-message">Item added to cart Successfully</div>
		</c:if>
		<table id="myTable">
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th class="currency">Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name }</td>
					<td><c:if test="${menuItem.freeDelivery }">Yes</c:if> <c:if
							test="${!menuItem.freeDelivery }">No</c:if></td>
					<td class="currency">Rs.<fmt:formatNumber type="number"
							pattern="#####.00" value="${menuItem.price }" /></td>
					<td>${menuItem.category }</td>
					<td><a href="AddToCart?id=${menuItem.id }"
						onclick="myFunction()">Add to Cart</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>