<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<%@include file="./layout/header.jsp"%>
	<c:url var="url" value="/find" />
	<form action="${url}/find-userID" method="post">
		<input name="username" placeholder="Username?">
		<button>Search</button>
	</form>
	<ul>
		<li>Fullname: ${user.fullname}</li>
		<li>Email: ${user.email}</li>
	</ul>
	<table border="1">
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>