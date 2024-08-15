

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div  class="w-50 mx-auto border p-4">
	<div id="alert" class="mt-3 ">
		<c:if test="${not empty message}">
			<div class="alert alert-danger">${message}</div>
		</c:if>
		<c:if test="${not empty success}">
			<div class="alert alert-success">${success}</div>
		</c:if>
	</div>
	<h3 class="text-center text-danger">Login</h3>
	<form method="post" action="/finaltest_09082024/auth/login">
		<label>Username</label> <input id="username" name="id" class="form-control">
		<label>Password</label> <input id="password" type="password" name="password" class="form-control">
		<div class="d-flex justify-content-end my-1">
			<input type="checkbox" id="remember"> <label for="remember">Remember
				me?</label>
		</div>
		<button id="login" class="btn btn-primary my-2">Login</button>
	</form>
</div>