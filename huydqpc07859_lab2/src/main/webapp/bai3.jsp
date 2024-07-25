<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
<style>
label {
	margin-bottom: 4px;
}
</style>
</head>
<body class="container mx-auto">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page" href="index.jsp">Trang chủ</a></li>
		<li class="nav-item"><a class="nav-link" href="bai1">Bài 1</a></li>
		<li class="nav-item"><a class="nav-link" href="bai2">Bài 2</a></li>
		<li class="nav-item"><a class="nav-link" href="bai3">Bài 3</a></li>
	</ul>
	<div class="container w-50 mx-auto p-4 border">Số lượng truy cập:
		<strong class="text-danger">${count}</strong> </div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>