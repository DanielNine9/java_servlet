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
	
	<c:url var="url" value="/find" />
	<div class="">
		<form action="${url}/find-userID" method="post" class="border p-4 mx-auto w-50">
		<h3 class="text-center text-danger">Search user and videos by user id</h3>
			<input class="form-control mb-2" required name="username" placeholder="Username?">
			<button class="btn btn-primary">Search</button>
		</form>
		<ul class="border my-4 mx-auto w-50 p-4">
			<li>Fullname: ${user.fullname}</li>
			<li>Email: ${user.email}</li>
		</ul>
		<table border="1" class="w-50 mx-auto table table-triped table-hover">
			<thead>
				<th>ID</th>
				<th>Title</th>
				<th>Views</th>
				<th>Active</th>
			</thead>
			<tr>
				<c:forEach var="item" items="${favorites}">
					<tr>
						<td>${item.id}</td>
						<td>${item.video.title}</td>
						<td>${item.video.views}</td>
						<td>${item.video.active}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>

	</div>
</body>
</html>