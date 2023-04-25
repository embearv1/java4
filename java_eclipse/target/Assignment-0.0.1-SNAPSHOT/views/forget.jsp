<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/head.jsp"%>
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<%@include file="/layout/header.jsp"%>
	<!-- Header End -->

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="<c:url value='/template/user/img/normal-breadcrumb.jpg'/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Forget Pass</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- Forget Section Begin -->
	<section class="login spad">
		<div class="container">
			<div class="row mb-2">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>Forget Password</h3>
						<form action="forget" method="post">
							<div class="input__item">
								<input type="text" name="user" placeholder="User Name"
									required="required"> <span class="icon_profile"></span>
							</div>
							<div class="input__item">
								<input type="email" name="email" placeholder="Enter Your Email"
									required="required"> <span class="icon_mail"></span>
							</div>
							<button type="submit" class="site-btn">Send</button>
							<span class="text-white ml-3"> or <u><a class="ml-1"
									href="<c:url value='/view-login'/>">Login</a></u></span>
						</form>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__register">
						<h3>Dont’t Have An Account?</h3>
						<a href="<c:url value='/view-signup'/>" class="primary-btn">Register
							Now</a>
					</div>
				</div>
			</div>
			<div class="row ml-3">
				 <h5 class="text-danger">${err}</h5>
			</div>
			<div class="login__social">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6">
						<div class="login__social__links">
							<span>or</span>
							<ul>
								<li><a href="#" class="facebook"><i
										class="fa fa-facebook"></i> Sign in With Facebook</a></li>
								<li><a href="#" class="google"><i class="fa fa-google"></i>
										Sign in With Google</a></li>
								<li><a href="#" class="twitter"><i
										class="fa fa-twitter"></i> Sign in With Twitter</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Forget Section End -->
	<%@include file="/layout/footer.jsp"%>
	<!-- Footer Section End -->

	<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->

	<!-- Js Plugins -->
	<%@include file="/common/foot.jsp"%>
	<!-- Footer section End -->
</body>
</html>