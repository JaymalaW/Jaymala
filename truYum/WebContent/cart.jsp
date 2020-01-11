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
<title>View Cart</title>
</head>
<body onload="addColumn()">
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="C:\Users\833483\Documents\Training - OBL java\truYum\WebContent\images\truyum-logo-light.png">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="field-spacing">
		<h1 class="message">Cart</h1>
		<c:if test="${message }">
			<div class="success-message">Item removed from Cart
				Successfully</div>
		</c:if>
		<table id="myTable">
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th class="currency">Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${cart.menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name }</td>
					<td><c:if test="${menuItem.freeDelivery }">Yes</c:if> <c:if
							test="${!menuItem.freeDelivery }">No</c:if></td>
					<td class="currency">Rs.<fmt:formatNumber
							pattern="#,##,##,##,###.00" value="${menuItem.price }" />
					</td>
					<td>${menuItem.category }</td>
					<td><a href="RemoveCart?id=${menuItem.id }">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td class="total">Total</td>
				<td class="total">Rs.<fmt:formatNumber value="${cart.total }"
						pattern="#,##,##,##,###.00" />
				</td>
				<td></td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>