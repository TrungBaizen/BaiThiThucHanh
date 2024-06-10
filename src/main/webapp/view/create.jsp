<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2024
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <input type="text" name="nameProduct" value="${product.nameProduct}" readonly>
    <input type="text" name="price" value="${product.price}" >
    <input type="text" name="quantity" value="${product.quantity}">
    <input type="text" name="color" value="${product.color}">
    <input type="text" name="descriptions" value="${book.descriptions}">
    <input type="text" name="category_id" value="${book.category.getid()}">
    <button>Submit</button>
</form>
</body>
</html>