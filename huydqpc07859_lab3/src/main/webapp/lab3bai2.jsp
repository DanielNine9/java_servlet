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
		<div class="mt-3 w-50 mx-auto">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
		<div class="container mt-2 w-50">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Thêm mới nhân viên</h3>
				</div>
				<div class="card-body">
					<form action="lab3bai2" method="post" enctype="multipart/form-data">
						<div class="mb-3 row">
							<label for="fullname" class="col-sm-2 col-form-label">Họ
								và tên</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fullname"
									name="fullname">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="photo_file" class="col-sm-2 col-form-label">Hình</label>
							<div class="col-sm-10">
								<input name="photo" type="file">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="birthday" class="col-sm-2 col-form-label">Ngày
								sinh</label>
							<div class="col-sm-10">
								<input type="date" class="form-control" id="birthday"
									name="birthday">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="country" class="col-sm-2 col-form-label">Quốc
								tịch</label>
							<div class="col-sm-10">
								<select class="form-select" id="country" name="country">
									<option value="Việt Nam">Việt Nam</option>
									<option value="Trung Quốc">Trung Quốc</option>
									<option value="Mỹ">Mỹ</option>
								</select>
							</div>
						</div>
						<fieldset class="mb-3 row">
							<legend class="col-form-label col-sm-2 pt-0">Giới tính</legend>
							<div class="col-sm-10">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" id="genderMale"
										checked name="gender" value="true"> <label
										class="form-check-label" for="genderMale">Nam</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" id="genderFemale"
										name="gender" value="false"> <label
										class="form-check-label" for="genderFemale">Nữ</label>
								</div>
							</div>
						</fieldset>
						<div class="mb-3 row">
							<label class="col-sm-2 col-form-label">Tình trạng hôn nhân</label>
							<div class="col-sm-10">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="married"
										name="married"> <label class="form-check-label"
										for="married">Đã có gia đình?</label>
								</div>
							</div>
						</div>
						<fieldset class="mb-3 row">
							<legend class="col-form-label col-sm-2 pt-0">Sở thích</legend>
							<div class="col-sm-10">
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										id="hobbyReading" name="hobbies" value="Đọc sách"> <label
										class="form-check-label" for="hobbyReading">Đọc sách</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										id="hobbyTravel" name="hobbies" value="Du lịch"> <label
										class="form-check-label" for="hobbyTravel">Du lịch</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="hobbyMusic"
										name="hobbies" value="Âm nhạc"> <label
										class="form-check-label" for="hobbyMusic">Âm nhạc</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="hobbyOther"
										name="hobbies" value="Khác"> <label
										class="form-check-label" for="hobbyOther">Khác</label>
								</div>
							</div>
						</fieldset>
						<div class="mb-3 row">
							<label for="notes" class="col-sm-2 col-form-label">Ghi
								chú</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="notes" name="notes" rows="3"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-10 offset-sm-2">
								<button type="submit" class="btn btn-primary">Thêm mới</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+IXJp2tw1AfnOHeD3w6PFwRIo4G3"
		crossorigin="anonymous"></script>
</body>
</html>