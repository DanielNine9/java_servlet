<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	border-box: box-sizing;
}


</style>
</head>
<body class="container mx-auto">
	<%@include file="header.jsp"%>
	<a href="/lab4/bai3" class="my-4">Trở lại danh sách sản phẩm</a>
	<h3>Chi tiết sản phẩm</h3>
		
	<div class="row">

		<div class="col-12">
			<div class="card">
				<div class="card-header">${item.name}</div>
				<div style="height: 200px;">
					<img style="object-fit: contain;" src="${item.image}"
						class="card-img-top w-100 h-100" alt="...">
				</div>

				<div class="card-body border">
					<div class="">
						Giá gốc:
						<del>${item.price}</del>
					</div>
					<div class="">
						Giá mới: ${item.currentPrice}
						<div class="">
							Mức giá:
							<c:choose>
								<c:when test="${item.price< 10}">Giá thấp</c:when>
								<c:when test="${item.price> 100}">Giá cao</c:when>
								<c:otherwise>Bình thường</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="card-footer text-center">Ngày: ${item.date}
				<form method="post" action="/lab4/bai3/buy/${item.id}">
					<button class="btn btn-primary">Buy</button>
				</form>
				</div>
			</div>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>