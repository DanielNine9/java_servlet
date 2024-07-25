<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class=" col-12 col-lg-4 m-0 p-1">
	<div class="card">
		<div style="height: 200px;">
			<img style="object-fit: contain;"
				src="${param.image}"
				class="card-img-top w-100 h-100" alt="...">
		</div>

		<div class="card-body">
			<h5 class="card-title">${param.name}</h5>
			<a href="#" class="btn btn-primary">Buy</a>
		</div>
	</div>
</div>

