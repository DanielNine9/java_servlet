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
	
	<form action="${url}/find-favorite" method="post" class="border p-4 mx-auto w-50 text-center">
	<h3 class="text-center text-danger">Search video by favorite</h3>
		<input name="favorite" type="radio" value="true" id="true"><label for="true">Favorite</label>  <input
			name="favorite" type="radio" value="false" id="false"><label for="false">Not favorite</label>
		<button class="btn btn-primary">Search</button>
	</form>
	<table border="1" class="w-50 mx-auto table table-triped table-hover">
		<thead>
			<th>ID</th>
			<th>Title</th>
			<th>View</th>
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