<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="container-fluid">
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
		<div class="container mt-4">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<form action="lab3bai3" method="post">
						<div class="card-group mb-0">
							<div class="card p-4 bg-light">
								<div class="mt-3 w-100 mx-auto">
									<c:if test="${not empty error}">
										<div class="alert alert-danger">${error}</div>
									</c:if>
									<c:if test="${not empty message}">
										<div class="alert alert-primary">${message}</div>
									</c:if>
								</div>
								<div class="card-body ">
									<h1>Login</h1>
									<p class="text-muted">Sign In to your account</p>
									<div class="input-group mb-3">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" class="form-control" name="username"
											value="${username}" placeholder="Username">
									</div>
									<div class="input-group mb-4">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="password" class="form-control" name="password"
											value="${password}" placeholder="Password">
									</div>
									<input class="mb-4" name="remember" id="remember" type="checkbox"
										${remember ? 'checked' : ''}> <label for="remember">Remember me?</label>
									<div class="row d-flex justify-content-between">
										<div class="">
											<button type="submit" class="btn btn-primary px-4">Login</button>
										</div>
										<div class="">
											<button type="button" class="btn btn-link px-0">
												Forgot password?</button>
										</div>
									</div>
								</div>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>