<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./view/CSS/ASM.css" rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<%@include file="../layout/header.jsp"%>
	<div class="main">
		<c:forEach var="video" items="${videos}">
			<div class="video">
				<div class="poster">
					<a href="./detail?id=${video.id}"><img src="/ASM/view/images/${video.poster}" alt=""></a>
				</div>
				<div class="title">
					<a href="./detail?id=${video.id}">${video.title}</a>
				</div>
				<div class="btnGroup">
					<button style="background-color: blue;">Like</button>
					<button style="background-color: #F09658;">Share</button>
				</div>
			</div>
		</c:forEach>
		<div class="pagination">
			<button class="btn btn-primary">|<</button>
			<button class="btn btn-primary"><<</button>
			<button class="btn btn-primary">>></button>
			<button class="btn btn-primary">>|</button>
		</div>
	</div>
</body>
</html>