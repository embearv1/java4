<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="<c:url value='/template/user/img/normal-breadcrumb.jpg'/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Share Video</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<section class="login spad">
		<div class="container">
			<div class="row mb-2">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>Share video</h3>
						<form action="/Assignment/video/share" method="post">
							<div class="input__item">
								<input type="email" name="email" placeholder="Enter Your Email"
									required="required"> <span class="icon_mail"></span>
							</div>
							<button type="submit" class="site-btn">Send</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

