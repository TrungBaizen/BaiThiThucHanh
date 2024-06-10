<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2024
  Time: 9:23 AM
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
<div class="header">
    <div class="search">
        <input type="text" name="search" placeholder="Search">
        <button>Search</button>
    </div>
</div>
<div class="main">
    <div class="name-table">
        <h1>Danh sách sản phẩm</h1>
    </div>
    <table class="show-product">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach var="item" items="${productList}">
            <tr>
                <td>${item.id}</td>
                <td>${item.nameProduct}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>${item.color}</td>
                <td>${item.descriptions}</td>
                <td>${item.category.id}</td>
                <td>
                    <button><a href="http://localhost:9999/product?action=update&id=${item.id}">Edit</a></button>
                </td>
                <td>
                    <button><a href="http://localhost:9999/product?action=delete&id=${item.id}">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td class="create" colspan="8">
                <a href="http://localhost:9999/product?action=create">Create Product</a>
            </td>
        </tr>
    </table>
</body>
</html>