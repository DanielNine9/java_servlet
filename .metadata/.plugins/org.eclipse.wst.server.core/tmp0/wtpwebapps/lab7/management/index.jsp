<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="../layout/header.jsp"%>
	<div class="container">
		<c:url var="url" value="/user" />

		<!-- Delete Confirmation Modal -->
		<div class="modal fade" id="deleteConfirmationModal" tabindex="-1"
			role="dialog" aria-labelledby="deleteConfirmationModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteConfirmationModalLabel">Confirm
							Deletion</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						Bạn có chắc muốn xóa user <span id="deleteUserName"></span> này
						không?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancel</button>
						<form id="deleteForm" action="${url}/delete" method="post">
							<input type="hidden" id="deleteUserId" name="id">
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- User Form -->
		<form class="mx-auto w-50 border my-4 p-4" action="${url}/index"
			method="post">

			<h3 class="text-danger text-center">User Form</h3>
			<label>Username: </label> <input class="form-control"
				value="${form.id}" name="id" placeholder="Username?"> <label>Password:</label>
			<input class="form-control" value="${form.password}" name="password"
				placeholder="Password?" type="password"> <label>Fullname:</label>
			<input class="form-control" value="${form.fullname}" name="fullname"
				placeholder="Fullname?"> <label>Email:</label> <input
				class="form-control" value="${form.email}" name="email"
				placeholder="Email?"> <label>Role:</label><br> <input
				${form.admin ? 'checked' : ''} id="adminRole" name="admin"
				type="radio" value="true"> <label for="adminRole">Admin</label>
			<input id="userRole" ${form.admin ? '' : 'checked'} name="admin"
				type="radio" value="false"> <label for="userRole">User</label><br>
			<hr>
			<button class="btn btn-primary" formaction="${url}/create"
				${edit ? 'disabled' : ''}>Create</button>
			<button class="btn btn-warning" formaction="${url}/update"
				${!edit ? 'disabled' : ''}>Update</button>
			<a href="${url}/index" class="btn btn-secondary" name="reset">Reset</a>
		</form>

		<!-- Messages -->
		<div class="mt-3 w-50 mx-auto">
			<c:if test="${not empty message}">
				<div class="alert alert-danger">${message}</div>
			</c:if>
			<c:if test="${not empty success}">
				<div class="alert alert-success">${success}</div>
			</c:if>
		</div>

		<!-- User Table -->
		<table class="table mx-auto w-50 table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">Username</th>
					<th scope="col">Password</th>
					<th scope="col">Fullname</th>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.id}</td>
						<td>${item.password}</td>
						<td>${item.fullname}</td>
						<td>${item.email}</td>
						<td>${item.admin ? 'Admin' : 'User'}</td>
						<td><a class="btn btn-warning" href="${url}/edit/${item.id}">Edit</a>
							<a class="btn btn-danger" href="#" data-bs-toggle="modal"
							data-bs-target="#deleteConfirmationModal"
							onclick="prepareDelete('${item.id}', '${item.id}')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example"
			class="d-flex justify-content-center">
			<ul class="pagination">
				<c:if test="${currentPage > 1}">
					<li class="page-item"><a class="page-link"
						href="${url}/index?page=${currentPage - 1}&pageSize=${param.pageSize}">Previous</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<li class="page-item ${i == currentPage ? 'active' : ''}"><a
						class="page-link"
						href="${url}/index?page=${i}&pageSize=${param.pageSize}">${i}</a>
					</li>
				</c:forEach>
				<c:if test="${currentPage < totalPages}">
					<li class="page-item"><a class="page-link"
						href="${url}/index?page=${currentPage + 1}&pageSize=${param.pageSize}">Next</a>
					</li>
				</c:if>
			</ul>
		</nav>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<script>
		function prepareDelete(userId, userName) {
			document.getElementById("deleteUserId").value = userId;
			document.getElementById("deleteUserName").innerText = userName;
		}
	</script>

</body>
</html>
