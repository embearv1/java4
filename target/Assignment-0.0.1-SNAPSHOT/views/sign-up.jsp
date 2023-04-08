<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
	<%@include file="/common/head.jsp" %>
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
						<h2>Sign Up</h2>
						<p>Welcome to the official Anime blog.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- Signup Section Begin -->
	<section class="signup spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>Sign Up</h3>
						<form action="sign-up" method="post">
							<div class="input__item">
								<input name="user" type="text" placeholder="User Name" required="required"> <span
									class="icon_profile"></span>
							</div>
							<div class="input__item">
								<input name="mail" type="email" placeholder="Email address" required="required"> <span
									class="icon_mail"></span>
							</div>

							<div class="input__item">
								<input name="pass" type="password" placeholder="Password" required="required"> <span
									class="icon_lock"></span>
							</div>
							<div class="input__item">
								<input type="password" name="repass" placeholder="Re-Password" required="required"> <span
									class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn">Sign Up</button>
						</form>
						<h5>
							Already have an account? <a href="<c:url value='/view-login'/>">Log In!</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__social__links">
						<h3>Login With:</h3>
						<ul>
							<li><a href="#" class="facebook"><i
									class="fa fa-facebook"></i> Sign in With Facebook</a></li>
							<li><a href="#" class="google"><i class="fa fa-google"></i>
									Sign in With Google</a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter"></i>
									Sign in With Twitter</a></li>
						</ul>
					</div>
				</div>
				
			</div>
			<div class="text-center text-danger"><h4>${err}</h4></div>
		</div>
		
	</section>
	<!-- Signup Section End -->

	<!-- Footer Section Begin -->
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
	<%@include file="/common/foot.jsp" %>

</body>

</html>