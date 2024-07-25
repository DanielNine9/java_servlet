<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">


	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Tẹn tài khoản</th>
				<th scope="col">Mật khẩu</th>
				<th scope="col">Ghi nhớ mật khẩu</th>
				<th scope="col">Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
					<th scope="row">${status.index + 1}</th>
					<td>${user.getUsername()}</td>
					<td>${user.getPassword()}</td>
					<td>${user.isRemember() ? "True" : "False"}</td>
					<td class="d-flex gap-2">
						<form action="" method="get">
							<input style="display: none !important;"
								value="${user.getUsername()}" name="username">
							<button class="btn btn-warning"
								formaction="/lab4/bai2/edit?username=${user.getUsername()}">Edit</button>
						</form>

						<button type="button" class="btn btn-danger" data-toggle="modal"
							data-target="#exampleModalCenter">Delete</button> <!-- Modal -->
						<div class="modal fade" id="exampleModalCenter" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalCenterTitle"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">Delete</h5>

									</div>
									<div class="modal-body">Bạn có chắc muốn xóa username
										"${user.getUsername()}" này không?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
										<form action="" method="get">
											<input style="display: none !important;"
												value="${user.getUsername()}" name="username">
											<button class="btn btn-danger"
												formaction="/lab4/bai2/delete">OK</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
