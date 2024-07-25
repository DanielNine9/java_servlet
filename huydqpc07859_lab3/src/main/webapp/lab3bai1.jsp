<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta charset="UTF-8">
<title>File Upload</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<a class="nav-link nav-item" href="lab3bai1">Java 4</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="./index.jsp">Trang
								chủ</a></li>
						<li class="nav-item"><a class="nav-link" href="lab3bai1">Bài
								1</a></li>
						<li class="nav-item"><a class="nav-link" href="lab3bai2">Bài
								2</a></li>
						<li class="nav-item"><a class="nav-link" href="lab3bai3">Bài
								3</a></li>
						<li class="nav-item"><a class="nav-link" href="lab3bai4">Bài
								4</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container mt-5 w-50">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2 class="card-title">Upload Files</h2>
			</div>
			<div class="card-body">
				<form action="lab3bai1" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="photo_file" class="form-label">Hình ảnh:</label> <input
							type="file" class="form-control" id="photo_file"
							name="photo_file">
					</div>
					<div class="mb-3">
						<label for="doc_file" class="form-label">Tài liệu:</label> <input
							type="file" class="form-control" id="doc_file" name="doc_file">
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-success">Upload</button>
					</div>
				</form>
			</div>
			
		
		</div>
	</div>
	<div class="mt-3 w-50 mx-auto">
				<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-q16pHpZ/P0dAIDzAE7CtsWnTx2msh23aQRIoVx0Tv1S9lkt9K2GpJov5d1u34rHf"
		crossorigin="anonymous"></script>
</body>

</html>
