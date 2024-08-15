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
	<div class="container w-50 mx-auto p-4 border">
		<h3 class="text-center text-danger">Đăng ký</h3>
		<form accept-charset="UTF-8" action="bai2" method="post">
			<div>
				<label style="font-weight: bold;">Tên đăng nhập</label> <input
					name="username" class="form-control">
			</div>
			<div>
				<label style="font-weight: bold;">Mật khẩu</label> <input
					name="password" type="password" class="form-control">
			</div>
			<div>
				<label style="font-weight: bold;">Giới tính</label> <br> <label for="male">Nam</label>
				<input type="radio" name="gender" value="true" id="male"> <label for="female">Nữ</label>
				<input type="radio" name="gender" value="false" id="female">
			</div>
			<div>
				<label style="font-weight: bold;">Tình trạng</label> <br> <label for="married">Đã
					có gia đình? </label> <input id="married" type="checkbox" name="married">
			</div>
			<div>
				<label style="font-weight: bold;">Quốc tịch</label> <select
					name="country" class="form-select">
					<option value="vn">Việt Nam</option>
					<option value="tq">Trung Quốc</option>
					<option value="my">Mỹ</option>
				</select>
			</div>
			<div>
				<label style="font-weight: bold;">Sở thích</label> <br> <label for="db">Đá
					banh</label> <input id="db" value="Đá banh" name="hobbies" type="checkbox" name="fav"> <label for="cg">Chơi
					game</label> <input id="cg" value="Chơi game" name="hobbies" type="checkbox" name="fav"> <label for="xp">Xem
					phim</label> <input id="xp" value="Xem phim" name="hobbies" type="checkbox" name="fav">
			</div>
			<div>
				<label style="font-weight: bold;">Ghi chú</label>
				<textarea name="notes" class="form-control" rows="" cols=""></textarea>
			</div>
			<hr>
			<div class="my-2">
				<button class="btn btn-primary">Đăng ký</button>
			</div>
		</form>
	
	</div>
<div class="mt-3 w-50 mx-auto">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>