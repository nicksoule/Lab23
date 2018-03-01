<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>

	<table border="1">
	<tr>
				<td>Name</td>
				<td>Description</td>
				<td>Quantity</td>
				<td>Price</td>
				</tr>
		<c:forEach var="items" items="${pList}">
			<tr>
				<td>${items.name}</td>
				<td>${items.description}</td>
				<td>${items.quantity}</td>
				<td>${items.price}</td>
				<td><a href="update?name=${items.name}description=${items.description}quantity=${items.quantity}price=${items.price}" >Edit</a></td>
				<td><a href="delete?name=${items.name}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<a href="addprodsuccess">Add a new Item</a>
</body>
</html>