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
</head>
<body>

	<%@include file="../layout/header.jsp"%>
	<form method="post" action="/lab6/find/choose-month"
		class="w-50 mx-auto p-4 border">
		<h3 class="text-center text-danger">Choose months</h3>
		<div
			class="d-flex flex-column gap-2 py-2 justify-content-center align-items-center">
			<div class="d-flex gap-1">
				<div>
					<input value="1" name="months" type="checkbox" id="1"> <label for="1">Tháng
						1</label>
				</div>
				<div>
					<input value="2" name="months" type="checkbox" id="2"> <label for="2">Tháng
						2</label>
				</div>
				<div>
					<input value="3" name="months" type="checkbox" id="3"> <label for="3">Tháng
						3</label>
				</div>
				<div>
					<input value="4" name="months" type="checkbox" id="4"> <label for="4">Tháng
						4</label>
				</div>
				<div>
					<input value="5" name="months" type="checkbox" id="5"> <label for="5">Tháng
						5</label>
				</div>
				<div>
					<input value="6" name="months" type="checkbox" id="6"> <label for="6">Tháng
						6</label>
				</div>
			</div>
			<div class="d-flex gap-1">
				<div>
					<input value="7" name="months" type="checkbox" id="7"> <label for="7">Tháng
						7</label>
				</div>
				<div>
					<input value="8" name="months" type="checkbox" id="8"> <label for="8">Tháng
						8</label>
				</div>
				<div>
					<input value="9" name="months" type="checkbox" id="9"> <label for="9">Tháng
						9</label>
				</div>
				<div>
					<input value="10" name="months" type="checkbox" id="10"> <label
						for="10">Tháng 10</label>
				</div>
				<div>
					<input value="11" name="months" type="checkbox" id="11"> <label
						for="11">Tháng 11</label>
				</div>
				<div>
					<input value="12" name="months" type="checkbox" id="12"> <label
						for="12">Tháng 12</label>
				</div>
			</div>
			<div class="d-flex justify-content-center">
				<button class="btn btn-primary">Find</button>

			</div>
		</div>

	</form>
	<div class="mt-3 w-50 mx-auto">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="alert alert-primary">${message}</div>
		</c:if>

	</div>
	<h3 class="text-danger text-center">List of videos</h3>
	<table class="w-50 mx-auto table table-striped table-hover" border="1">
		<thead>
			<th>ID</th>
			<th>Title</th>
			<th>Views</th>
			<th>Active</th>
		</thead>
		<tr>
			<c:forEach var="item" items="${videos}">
				<tr>
					<td>${item.id}</td>
					<td>${item.title}</td>
					<td>${item.views}</td>
					<td>${item.active}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>

</body>
</html>