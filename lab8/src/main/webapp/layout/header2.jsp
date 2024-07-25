<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<fmt:setLocale value="${sessionScope.lang}" scope="request" />
<fmt:setBundle basename="global" scope="request" />

<c:url var="url" value="bai2" />

<nav class="container navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Online Entertainment</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/lab8/home/trang-chu"><fmt:message
							key="menu.home" /></a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/lab8/${url}/myFar"><fmt:message
							key="menu.myFar" /></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"><fmt:message
							key="menu.myAccount" /></a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="/lab8/${url}/login"><fmt:message
									key="menu.login" /></a></li>
						<li><a class="dropdown-item"
							href="/lab8/${url}/forget-password"><fmt:message
									key="menu.forgetPassword" /></a></li>
						<li><a class="dropdown-item" href="/lab8/${url}/register"><fmt:message
									key="menu.register" /></a></li>
						<li><a class="dropdown-item" href="/lab8/${url}/logout">
								<fmt:message key="menu.logout" />
						</a></li>
						<li><a class="dropdown-item"
							href="/lab8/${url}/change-password"><fmt:message
									key="menu.changePassword" /></a></li>
						<li><a class="dropdown-item" href="/lab8/${url}/edit-profile"><fmt:message
									key="menu.profile" /></a></li>
					</ul></li>

			</ul>
			<div class="d-flex gap-2">
				<form action="">
					<input type="hidden" value="vi" name="lang">
					<button formaction="?vi" class="btn btn-primary">
						<img alt=""
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANYAAACUCAMAAADYrSd7AAAAclBMVEXaJR3//wDyvg/YAB7ZHB3WAB///QHZDx7++APeRhvvsBH88AbZFh3bMxzbLRzxuxDnhRb54wn32gvrmhTgVxrdPhvzwg7rnxPlehf0yw3jcBjfUBr76Qf53gnzxw3eSxvspxLojRT20QzjaBjhYRnqkxTNielEAAADd0lEQVR4nO2baXeqMBCGiQkkbLLIori0aP3/f/GquECwBlt6yeTM87WnnnnPDG+SmcSyEARBEARBEARBEARBEARBEARBkP8I+/ikU8fwB9A6DdnUQYyPnfqHYOogxocSsuBTBzE6tCZkH04dxejQPSHO2rSPi7k+IaQ2zQtpLU6yUnvqOEaGF+SMYZ4RZMlFlmFVyOOLKtOqkHmNLD83ygvzTSPLWZhUhUFFrqxM2j/Z0U1WkhmkyyZ3YnM8PsgesqKpgxkPe/aQZZAXss1DFqlM+bh4JVqyZqZYPPVIG0M2GixPO7IOZnhhtwYJKcxIV1B2VJENM8ILw31XlliaUIUsIxJGeCFdyLJSE1ZkeyPLMqEKmSWrIqQEsNGYz1/+mZZ9WaoqfP2L/wWWRcXsBZHfl+XsXv3HrKg10BXEST/wX/Hp6mAp3C3GFCUqroOqUx3SeDxVq1wfm6TZdhxR/oLqkaoGnnvqmNVsK822wYwthTpsBZGrTwHe4B+pOvBXiFgTr+gS0M/fJCzJdd0B0+WPlzDhzfUrwBt0vfuZKn+p9dkyYL1jyBC2ob6parDdJ5vA14hSq8XqOTyM3nOOtNLVKzowK35HV+GCUHXSxd3eifg7nKMF4Ex5hXHPGaQqgZKqK3TIKUzMAt0dUGbAEraJA/0dUIZ/KD4wmONx9qXK1g6iLKo8gSVrOCZ4x1YuXg7A8ThzVaoI8eA5hj2gC5DAa8bTIRsNcHeS+WHIvtCD5oVqHzwjNGs0qWDzvVrUCWAWz6thh8kIVrrkMfiFJ0p9WCtXuOpLqKt+R1tUkHSxde+45R84n896ukB5Ia/l8AvrnBa719EG9UrIlsrNP157SzSTHNIHVYVSSh69JZ5LZgJhPH5FGuNF7eYm491CXMF5JdSpQaeSmps879hkBuXjYq3GrrPv95YCWraWsCOUj4su7vbulE8HIfbykc8tFIvn956T+PpmENK+HWDBqMLb6x9CduG3Nte6HXCEka7bWqyY2tvrLawqbF5epAdFuDxsOtpCi0szKlgzVxgwtb/eDoDRBr28/hHD+tCBe74dsIJg8bQ4D00HJoDRUpDNF4ANFCXCY4PjZLRKIKzIvHLem9rT9Wqnwf1BBfSYv1lSgbXM/yaWMfmBrQEccyEIgiAIgiAIgiAIgiAIgiAIgiAIgiDIBPwDhWYkZ/Da5HUAAAAASUVORK5CYII="
							style="width: 3 0px; height: 20px; overflow: hidden">
					</button>

				</form>
				<form action="">
					<input type="hidden" value="en" name="lang">
					<button formaction="?en" class="btn btn-primary">
						<img alt=""
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwwxhCMpFSg4qToHq_HKLhhU6bo5f1JJPh8w&s"
							style="width: 3 0px; height: 20px; overflow: hidden">
					</button>

				</form>


			</div>

		</div>

	</div>
</nav>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>