

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
</head>
<body>

	<div class="border p-4 rounded-sm w-50 mx-auto my-4">
		<form action="lab3bai1" method="get">
			<button class="btn btn-primary">Trở về bài 1</button>
		</form>
		<h3 class="text-danger text-center">Kết quá</h3>
		<h2>1. Hình: ${img}</h2>
		<img src="uploads/${img}" height="100">
		<h2>2. Tài liệu: ${doc}</h2>
		<a href="uploads/${doc}">Tải về</a>
	</div>

</body>
</html>