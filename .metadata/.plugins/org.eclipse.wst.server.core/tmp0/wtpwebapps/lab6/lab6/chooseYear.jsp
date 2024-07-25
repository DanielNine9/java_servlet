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
	<form method="post" action="/lab6/find/choose-year" class="w-50 mx-auto p-4 border">
		<h3 class="text-center text-danger">Choose year</h3>
		<div class="d-flex gap-2 py-2 justify-content-center">
			<select name="year" class="form-select">
				<option value="2019">2019</option>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
			</select>
		</div>
		<div class="d-flex justify-content-center">
			<button class="btn btn-primary">Find</button>

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