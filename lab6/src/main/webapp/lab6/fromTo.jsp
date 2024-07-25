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
	<form method="post" action="/lab6/find/from-to" class="w-50 mx-auto p-4 border">
		<h3 class="text-center text-danger">Search videos</h3>
		<div class="d-flex gap-2 py-2 justify-content-center">
			<div>
				<label>From</label> <input type="date" name="from" class="form-control">
			</div>
			<div>
				<label>To</label> <input type="date" name="to" class="form-control">
			</div>
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