<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<c:if test="${not empty user}">
		<form action="bai2" method="post"
			class="w-50 border p-4 rounded-sm mx-auto my-4">
			<input type="hidden" name="originalUsername"
				value="${user.getUsername()}">
			<div class="mb-2">
				<label for="username">Tên tài khoản</label> <input
					value="${user.getUsername()}" name="username" class="form-control"
					id="username">
			</div>
			<div class="mb-2">
				<label for="password">Mật khẩu</label> <input
					value="${user.getPassword()}" name="password" class="form-control"
					id="password">
			</div>
			<div class="mb-2">
				<input type="checkbox" name="remember" id="remember"
					<c:if test="${user.isRemember()}">checked</c:if>> <label
					for="remember">Ghi nhớ mật khẩu?</label>
			</div>
			<button formmethod="get" formaction="/lab4/bai2/update" class="btn btn-primary">Chỉnh sửa</button>
			<button  formmethod="get" formaction="/lab4/bai2/refresh" class="btn btn-secondary">Làm mới</button>
		</form>
	</c:if>
	<c:if test="${empty user}">
		<form action="/lab4/bai2" method="post"
			class="w-50 border p-4 rounded-sm mx-auto my-4">
			<div class="mb-2">
				<label for="username">Tên tài khoản</label> <input name="username"
					class="form-control" id="username">
			</div>
			<div class="mb-2">
				<label for="password">Mật khẩu</label> <input name="password"
					class="form-control" id="password">
			</div>
			<div class="mb-2">
				<input value="true" name="remember" type="checkbox" id="remember">
				<label for="remember">Ghi nhớ mật khẩu?</label>
			</div>
			<button class="btn btn-primary">Tạo</button>
			<button formmethod="get" formaction="/lab4/bai2/refresh" class="btn btn-secondary">Làm mới</button>
		</form>
	</c:if>
	<div class="mt-3 w-50 mx-auto">
		<c:if test="${not empty message}">
			<div class="alert alert-danger">${message}</div>
		</c:if>
		<c:if test="${not empty success}">
			<div class="alert alert-success">${success}</div>
		</c:if>
	</div>
</div>

<!-- Add Bootstrap JS and dependencies if not already included -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
