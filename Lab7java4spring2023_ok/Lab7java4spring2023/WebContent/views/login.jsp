<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="author" content="Kodinger">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>My Login Page</title>
	<base href="/Lab7java4spring2023/" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/login.css">
</head>

<body class="my-login-page">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<c:choose>
						<c:when test="${not empty yourName}">
							<h3 class="text-danger text-center">Welcome ${yourName}</h3>
						</c:when>
						<c:otherwise>
							<h3 class="text-danger text-center">Welcome You</h3>
						</c:otherwise>
						</c:choose>
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">Login</h4>
							<form method="POST" class="my-login-validation" novalidate="" action="Bai3_LoginServlet">
								<div class="form-group">
									<label for="id">User-ID</label>
									<input id="id" type="text" class="form-control" name="userID" value="" required autofocus>
									<div class="invalid-feedback">
										User-ID is required
									</div>
								</div>

								<div class="form-group">
									<label for="password">Password
										<a href="account/forgot-password" class="float-right">
											Forgot Password?
										</a>
									</label>
									<input id="password" type="password" class="form-control" name="password" required  data-eye>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								<div class="form-group">
									<div class="custom-checkbox custom-control">
										<input type="checkbox" name="remember" id="remember" class="custom-control-input">
										<label for="remember" class="custom-control-label">Remember Me</label>
									</div>
								</div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block" formaction="accountBai3/sign-in">
										Login
									</button>
								</div>
								<div class="mt-4 text-center">
									Don't have an account? <a href="account/sign-up">Create One</a>
								</div>
								<c:if test="${not empty message}">
                            		<div class="alert alert-success">${message}</div>
                            	</c:if>
								<c:if test="${not empty sessionScope.securi}">
                            		<div class="alert alert-danger">${sessionScope.securi}</div>
                            	</c:if>
							</form>
						</div>
					</div>
					<p class="text-danger"></p><p class="text-danger">Lê Anh Tú</p>
					<div class="footer">
						Copyright &copy; 2023 &mdash; 
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">

	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/views/js/login.js"></script>
</body>
</html>