<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Triangle Calculation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="container mx-auto">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page" href="index.jsp">Trang chủ</a></li>
		<li class="nav-item"><a class="nav-link" href="bai1">Bài 1</a></li>
		<li class="nav-item"><a class="nav-link" href="bai2">Bài 2</a></li>
		<li class="nav-item"><a class="nav-link" href="bai3">Bài 3</a></li>
	</ul>
	<div class="container w-50 mx-auto">
		<form action="" method="post">
			<div class="border p-4">
				<h3 class="text-center text-danger">Tính tam giác</h3>
				<div class="mb-3">
					<label for="txta" class="form-label">Cạnh a</label> <input
						type="number" id="txta" name="txta" class="form-control"
						value="${txtA}">
				</div>
				<div class="mb-3">
					<label for="txtb" class="form-label">Cạnh b</label> <input
						type="number" id="txtb" name="txtb" class="form-control"
						value="${txtB}">
				</div>
				<div class="mb-3">
					<label for="txtc" class="form-label">Cạnh c</label> <input
						type="number" id="txtc" name="txtc" class="form-control"
						value="${txtC}">
				</div>
				<div class="my-2">
					<button formaction="dientich" class="btn btn-primary">Tính
						diện tích</button>
					<button formaction="chuvi" class="btn btn-primary">Tính
						chu vi</button>
				</div>

			</div>

			<div class="mt-3">
				<c:if test="${not empty message}">
					<div class="alert alert-danger">${message}</div>
				</c:if>
				<c:if test="${not empty chuvi}">
					<div class="alert alert-info">Chu vi: ${chuvi}</div>
				</c:if>
				<c:if test="${not empty dientich}">
					<div class="alert alert-info">Diện tích: ${dientich}</div>
				</c:if>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
