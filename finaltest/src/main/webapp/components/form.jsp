	<c:url var="url" value="finaltest" />

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
				type="email"
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
