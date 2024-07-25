<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	<c:url var="url" value="/find" />
	
	<%@include file="../layout/header.jsp"%>
	<form action="${url}/find-userLikeVideo" method="post" class="border p-4 mx-auto w-50">
	<h3 class="text-center text-danger">Search users of video by video id</h3>
		<input class="form-control" required name="videoId" placeholder="Keyword?">
		<button class="btn btn-primary my-2">Search</button>
	</form>
	
	<table border="1" class="w-50 mx-auto table table-triped table-hover">
		<thead>
			<th>ID</th>
			<th>Fullname</th>
			<th>Email</th>
			<th>Role</th>
		</thead>
		<tr>
			<c:forEach var="item" items="${users}">
				<tr>
					<td>${item.id}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>