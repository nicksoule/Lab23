<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add Item</h1>
	<form action="addproduct" method="get">
	Name: <input type="text" name="name" required><br>
	Description <input type="text" name="description"><br>
	Quantity: <input type="number" min="1" step="any" name="quantity"><br>
	Price: <input type="number" min="1" step="any" name="price"><br>
	<input type="submit" value="Add Product">
	</form>
</body>
</html>