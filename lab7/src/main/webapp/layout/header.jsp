
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Java 4</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/lab7/auth/home">Trang chủ</a></li>
			</ul>
			<c:choose>
				<c:when
					test="${not empty sessionScope.user && sessionScope.user.getAdmin()}">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li id="management" class="nav-item"><a class="nav-link active"
							aria-current="page" href="/lab7/user/index">Quản lý user</a></li>
					</ul>
				</c:when>
			</c:choose>


			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					<form method="post" class="d-flex gap-2">
						<button id="logout" formaction="/lab7/auth/logout" class="btn btn-primary">Đăng
							xuất</button>
					</form>
				</c:when>
				<c:otherwise>
					<form class="d-flex gap-2">
						<button formaction="/lab7/auth/login" class="btn btn-primary">Đăng
							nhập</button>
						<button formaction="/lab7/auth/register"
							class="btn btn-outline-primary">Đăng ký</button>
					</form>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</nav>