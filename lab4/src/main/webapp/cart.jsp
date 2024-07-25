<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>

<div class="container mt-4">
<%@include file="header.jsp"%>
    <h2>Your Shopping Cart</h2>
    <div class="mt-3 w-50 mx-auto">
        <c:if test="${not empty message}">
            <div class="alert alert-danger">${message}</div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success">${success}</div>
        </c:if>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Product ID</th>
            <th scope="col">Image</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${sessionScope.cartItems}">
            <tr>
                <td>${product.id}</td>
                <td>
                    <img alt="${product.name}" src="${product.image}" style="width: 50px; height: 60px;">
                </td>
                <td>${product.name}</td>
                <td>$${product.price}</td>
                <td>
                    <form action="/lab4/cart/update" method="post" class="form-inline">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="number" name="quantity" value="${product.quantity}" class="form-control mx-2" min="1">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                </td>
                <td>
                    <form action="/lab4/cart/delete" method="post" class="form-inline">
                        <input type="hidden" name="id" value="${product.id}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty sessionScope.cartItems}">
            <tr>
                <td colspan="6" class="text-center">Your cart is empty.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and dependencies (optional for certain Bootstrap features) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
</body>
</html>
