
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
