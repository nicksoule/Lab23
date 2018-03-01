<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Product</title>
</head>
<body>
<h1>Edit Item</h1>
	<form action="updateproduct" method="post">
	<input type="hidden" name="id" value="${productID}">
	Name: <input type="text" name="name" required><br>
	Description <input type="text" name="description"><br>
	Quantity: <input type="number" min="1" step="any" name="quantity"><br>
	Price: <input type="number" min="1" step="any" name="price"><br>
	<input type="submit" value="Update Product">
	</form>
</body>
</html>