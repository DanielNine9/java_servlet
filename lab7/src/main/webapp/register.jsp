
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="w-50 mx-auto border p-4">
	<div class="mt-3 ">
		<c:if test="${not empty message}">
			<div class="alert alert-danger">${message}</div>
		</c:if>
		<c:if test="${not empty success}">
			<div class="alert alert-success">${success}</div>
		</c:if>
	</div>
	<h3 class="text-center text-danger">Register</h3>
	<form action="/lab7/auth/register" method="post">
		<label>Fullname</label> <input name="fullname" class="form-control">
		<label>Username</label> <input name="id" class="form-control">
		<label>Password</label> <input type="password" name="password" class="form-control">
		<label>Confirm Password</label> <input type="password"  name="confirmPassword"
			class="form-control">
		<button class="btn btn-primary my-2">Register</button>
	</form>
</div>