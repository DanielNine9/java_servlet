<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="url" value="/find" />
<nav class="container navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Java 4 ${url1}</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/lab6/index.jsp">Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="${url}/find-userID">Find User</a>
				<li class="nav-item"><a class="nav-link" href="${url}/find-videoTitle">Find Video Title</a>
				<li class="nav-item"><a class="nav-link" href="${url}/find-userLikeVideo">Find User Like Video</a>
				<li class="nav-item"><a class="nav-link" href="${url}/find-favorite">Find Favorite</a>
				<li class="nav-item"><a class="nav-link" href="${url}/favorite-count">Find Favorite Count</a>
				<li class="nav-item"><a class="nav-link" href="${url}/from-to">From To</a>
				<li class="nav-item"><a class="nav-link" href="${url}/choose-month">Choose based on month</a>
				<li class="nav-item"><a class="nav-link" href="${url}/choose-year">Choose based on year</a>
			</ul>

		</div>
	</div>
</nav>