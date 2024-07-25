<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<div class=" col-12 col-lg-4 m-0 p-1">
	<div class="card">
		<div class="card-header">${item.name}</div>
		<div style="height: 200px;">
			<img style="object-fit: contain;" src="${item.image}"
				class="card-img-top w-100 h-100" alt="...">
		</div>

		<div class="card-body">
			<div class="">
				Giá gốc:
				<del>${item.price}</del>
			</div>
			<div class="">
				Giá mới:
				<del>${item.price - (${item.price} * ${item.discount})}</del>
				<div class="">
					Mức giá:
					<c:choose>
						<c:when test="${item.price< 10}">Giá thấp</c:when>
						<c:when test="${item.price> 100}">Giá cao</c:when>
						<c:otherwise>Bình thường</c:otherwise>
					</c:choose>
				</div>
			</div class="card-footer">
			Ngày: <span>${item.date}</span>
		
		</div>
	</div>
</div>

