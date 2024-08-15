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
		<div class="container mt-2">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card bg-l">
						
						<div class="card-body">
							<div class="mt-3 w-100 mx-auto">
									<c:if test="${not empty error}">
										<div class="alert alert-danger">${error}</div>
									</c:if>
									<c:if test="${not empty message}">
										<div class="alert alert-primary">${message}</div>
									</c:if>
								</div>
						<h3 class="text-danger text-center">Form Email</h3>
						
							<form enctype="multipart/form-data" role="form" class="form-horizontal" action="lab3bai4"
								method="post">
								<div class="form-group row mb-3">
									<label class="col-sm-2 col-form-label" for="inputForm">
										<span class="glyphicon glyphicon-user"></span> From
									</label>
									<div class="col-sm-10">
										<input type="email" value="huydqpc07859@fpt.edu.vn"
											disabled
											name="form" class="form-control" id="inputForm"
											placeholder="Enter your email...">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label" for="inputTo"> <span
										class="glyphicon glyphicon-user"></span> To
									</label>
									<div class="col-sm-10">
										<input type="email" class="form-control" name="to"
											id="inputTo" placeholder="To...">
									</div>
								</div>
								<div class="form-group row mt-3">
									<label class="col-sm-2 col-form-label" for="inputSubject">
										<span class="glyphicon glyphicon-list-alt"></span> Subject
									</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="subject"
											id="inputSubject" placeholder="Subject...">
									</div>
								</div>
								<div class="form-group row mt-3">
									<label class="col-sm-2 col-form-label" for="inputBody">
										<span class="glyphicon glyphicon-list"></span> Message
									</label>
									<div class="col-sm-10">
										<textarea class="form-control" name="message" id="inputBody"
											rows="8" placeholder="Message..."></textarea>
									</div>
								</div>
								 <div class="form-group row mt-3">
                                <label class="col-sm-2 col-form-label" for="inputAttachment">
                                    <span class="glyphicon glyphicon-paperclip"></span> Attachment
                                </label>
                                <div class="col-sm-10">
                                    <input type="file" class="form-control-file" id="inputAttachment" name="attachment">
                                </div>
                            </div>
                       
								<div class="form-group row mt-3">
									<div class="col-sm-10 offset-sm-2">
										<button type="submit" class="btn btn-primary">Send</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>