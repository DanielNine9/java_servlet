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
	<form class="p-4 w-50 mx-auto border my-2" action="${url}/find-videoTitle" method="post" class="border p-4 mx-auto w-50">
		<h3 class="text-center text-danger">Search video by video title has favorites</h3>
		<input class="form-control" placeholder="Typing..." class="form-control" required name="keyword">
		<button class="btn btn-primary my-2">Search</button>
	</form>
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