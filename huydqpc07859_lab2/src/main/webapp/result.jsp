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
<body class="container mx-auto d-flex justify-content-center align-items-center" style="height: 40vh">
	<div class="border w-50 p-4 mx-auto">
		<form action="">
			<button formaction="bai2" class="btn btn-outline-primary">Trở
				về bài 2</button>
		</form>
		<h3 class="text-center text-danger">Thông tin đăng ký</h3>
		<div>
			<label style="font-weight: bold">Tên đăng nhập:</label> ${username}
		</div>
		<div>
			<label style="font-weight: bold">Mật khẩu:</label> ${password}
		</div>
		<div>
			<label style="font-weight: bold">Giới tính:</label> ${gender}
		</div>
		<div>
			<label style="font-weight: bold">Quốc gia: </label> ${country}
			<div>
				<label style="font-weight: bold">Trạng thái: </label> ${married}
			</div>
			<div>
				<label style="font-weight: bold">Sở thích: </label> ${hobbies}
			</div>
			<div>
				<label style="font-weight: bold">Ghi chú:</label> ${notes}
			</div>
		</div>
	</div>
</body>
</html>