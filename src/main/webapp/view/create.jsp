<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
.<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" action="http://localhost:9999/product?action=create">
    <h1>Create Product</h1>
    <input type="text" name="nameProduct" value="${product.nameProduct}">
    <input type="text" name="price" value="${product.price}" >
    <input type="text" name="quantity" value="${product.quantity}">
    <input type="text" name="color" value="${product.color}">
    <input type="text" name="descriptions" value="${product.descriptions}">
    <input type="text" name="category_id" value="${product.category.getid()}">
    <button>Submit</button>
</form>
</body>
</html>