
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="alert" class="alert alert-success my-2">
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
        Welcome, ${sessionScope.user.fullname}
    </c:when>
		<c:otherwise>
        Welcome to my website
    </c:otherwise>
	</c:choose>
</div>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<body class="container mx-auto">
	<h3 id="title">Danh sách sản phẩm</h3>
	<div class="row">
		<c:forEach var="item" items="${items}" varStatus="status">
			<div class=" col-12 col-lg-3 m-0 p-1">
				<a>
					<div class="card">
						<div class="card-header">${item.name}</div>
						<div style="height: 200px;">
							<img style="object-fit: contain;" src="${item.image}"
								class="card-img-top w-100 h-100" alt="...">
						</div>



						<div class="card-footer text-center">
							<div class="d-flex gap-2 justify-content-center">
								<div>
									Giá gốc:
									<del>
										<fmt:formatNumber value="${item.price}" type="number"
											minFractionDigits="2" maxFractionDigits="2" />
									</del>
								</div>
								<div class="">
									Giá mới:
									<fmt:formatNumber value="${item.currentPrice}" type="number"
										minFractionDigits="2" maxFractionDigits="2" />
								</div>
							</div>
						</div>
					</div>
				</a>
			</div>

		</c:forEach>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
