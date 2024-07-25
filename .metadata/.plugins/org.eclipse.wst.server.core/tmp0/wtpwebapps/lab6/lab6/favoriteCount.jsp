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

	<h3 class="text-danger text-center">List of videos</h3>
	<table border="1" class="w-50 mx-auto table table-triped table-hover">
		<thead>
			<th>ID</th>
			<th>Favorite Count</th>
			<th>Newest Date</th>
			<th>Oldest Date</th>
		</thead>
		<tr>
			<c:forEach var="item" items="${reports}">
				<tr>
					<td>${item.group}</td>
					<td>${item.like}</td>
					<td>${item.newest}</td>
					<td>${item.oldest}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>

</body>
</html>