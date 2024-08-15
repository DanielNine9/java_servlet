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
		<form id="userform" class="mx-auto w-50 border my-4 p-4" action="${url}/index"
			method="post" enctype="multipart/form-data">
			<h3 id="title-user" class="text-danger text-center">User Form</h3>

			<label>Username: </label> <input required id="username" class="form-control"
				value="${form.id}" name="id" placeholder="Username?"> <label>Password:</label>
			<input required id="password" class="form-control" value="${form.password}"
				name="password" placeholder="Password?" type="password"> <label>Fullname:</label>
			<input required id="fullname" class="form-control" value="${form.fullname}"
				name="fullname" placeholder="Fullname?"> <label>Email:</label>
			<input type="email" required id="email" class="form-control" value="${form.email}"
				name="email" placeholder="Email?">

			<div class="mb-3">
				<label for="test" class="form-label">Hình ảnh</label>
				<div class="image-wrapper">
					<img id="videoImage"
						src="${form.image != null ? form.image : 'https://static.vecteezy.com/system/resources/thumbnails/004/141/669/small/no-photo-or-blank-image-icon-loading-images-or-missing-image-mark-image-not-available-or-image-coming-soon-sign-simple-nature-silhouette-in-frame-isolated-illustration-vector.jpg'}"
						alt="Hình ảnh video" class="img-fluid mb-2"
						style="height: 150px; width: 150px; object-fit: cover; cursor: pointer;">
					<input name="photo" type="file" id="test" class="d-none">
				</div>
			</div>
			<div class="mb-3">
				<label for="hobbies" class="form-label">Hobbies</label>
				<div>
					<label>Swimming:</label> <input type="checkbox" name="hobbies"
						value="Swimming"
						${form.hobby.contains('Swimming') ? 'checked' : ''}>
				</div>
				<div>
					<label>Reading:</label> <input type="checkbox" name="hobbies"
						value="Reading" ${form.hobby.contains('Reading') ? 'checked' : ''}>
				</div>
				<div>
					<label>Traveling:</label> <input type="checkbox" name="hobbies"
						value="Traveling"
						${form.hobby.contains('Traveling') ? 'checked' : ''}>
				</div>
			</div>
			<div class="mb-3">
				<label>Married:</label> <input ${form.married ? 'checked' : ''}
					type="checkbox" name="married" value="true">
			</div>



			<label>Role:</label><br> <input ${form.admin ? 'checked' : ''}
				id="adminRole" name="admin" type="radio" value="true"> <label
				for="adminRole">Admin</label> <input id="userRole"
				${form.admin ? '' : 'checked'} name="admin" type="radio"
				value="false"> <label for="userRole">User</label><br>

			<hr>
			<button id="create" class="btn btn-primary"
				formaction="${url}/create" ${edit ? 'disabled' : ''}>Create</button>
			<button id="update" class="btn btn-warning"
				formaction="${url}/update" ${!edit ? 'disabled' : ''}>Update</button>
			<a id="reset" href="${url}/index" class="btn btn-secondary"
				name="reset">Reset</a>
		</form>



		<!-- Messages -->
		<div id="alert" class="mt-3 w-50 mx-auto">
			<c:if test="${not empty message}">
				<div class="alert alert-danger">${message}</div>
			</c:if>
			<c:if test="${not empty success}">
				<div class="alert alert-success">${success}</div>
			</c:if>
		</div>

		<form action="${url}/find" class="w-50 border p-4 mx-auto">
			<h3 class="text-center text-danger">Find</h3>
			<input class="form-control" name="find">
			<button class="my-2 btn btn-primary">Search</button>
		</form>



	</div>
	<!-- User Table -->

	<table class="table mx-auto w-75 table-striped table-hover mt-3">
		<thead>
			<tr>
				<th scope="col">Username</th>
				<th scope="col">Password</th>
				<th scope="col">Fullname</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Hobbies</th>
				<th scope="col">Married</th>
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
					<td>${item.hobby}</td>
					<td>${item.married ? 'True' : 'False'}</td>
					<td><a class="btn btn-warning" href="${url}/edit/${item.id}">Edit</a>
						<a class="btn btn-danger" href="#" data-bs-toggle="modal"
						id="delete${item.id}" data-bs-target="#deleteConfirmationModal"
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
					href="${url}/index?page=${i}&pageSize=${param.pageSize}">${i}</a></li>
			</c:forEach>
			<c:if test="${currentPage < totalPages}">
				<li class="page-item"><a class="page-link"
					href="${url}/index?page=${currentPage + 1}&pageSize=${param.pageSize}">Next</a>
				</li>
			</c:if>
		</ul>
	</nav>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<script>
	
	document.querySelector('#userform').addEventListener('submit', function(event) {
        const checkboxes = document.querySelectorAll('input[name="hobbies"]');
        let checked = false;
      
        checkboxes.forEach((checkbox) => {
            if (checkbox.checked) {
                checked = true;
            }
        });

        if (!checked) {
            event.preventDefault(); // Ngăn không cho gửi form
           alert("Vui lòng chọn sở thích")
        }	
    });
	
		function prepareDelete(userId, userName) {
			document.getElementById("deleteUserId").value = userId;
			document.getElementById("deleteUserName").innerText = userName;
		}
		
		
		   document.querySelector('.image-wrapper').addEventListener('click', () => {
		        document.querySelector('#test').click();
		    });

		    document.querySelector('#test').addEventListener('change', function (e) {
		        const file = e.target.files[0];
		        const reader = new FileReader();
		        reader.onload = function (event) {
		            document.querySelector('#videoImage').src = event.target.result;
		        };
		        reader.readAsDataURL(file);
		    });
		    
		
	</script>

</body>
</html>
