<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/head.jsp" %>
</head>
<body>
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
						<form action="/Assignment/change-email" method="post">
							<div class="input__item">
								<input type="email" name="email" placeholder="Enter Your Email"
									required="required" value="${email}"> <span class="icon_mail"></span>
							</div>
							<button type="submit" class="site-btn">Change Email</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	 <!-- End profile -->
    
    
     <!-- Footer Section Begin -->
     <%@include file="/layout/footer.jsp"%>
      <!-- Footer Section End -->

      <!-- Search model Begin -->
      <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch"><i class="icon_close"></i></div>
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

