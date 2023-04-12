<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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
    
    
    <!-- Start profile -->
    <section class="profile spad">
		<div class="container">
			<div class="row">
					<div class="login__form">
						<h3>My profile</h3>
						<form action="change-pass" method="post">
							<div class="input__item">
								<input name="user" type="text" placeholder="User Name"  disabled="disabled" value="${user.user}"> <span
									class="icon_profile"></span>
							</div>
							<div class="input__item">
								<input name="mail" type="email" placeholder="Email address" disabled="disabled"  value="${user.email}"> <span
									class="icon_mail"></span>
							</div>
							<div class="input__item">
								<input name="oldpass" type="password" placeholder="Old-Password" required="required"> <span
									class="icon_lock"></span>
							</div>
							<div class="input__item">
								<input name="pass" type="password" placeholder="Password" required="required"> <span
									class="icon_lock"></span>
							</div>
							<div class="input__item">
								<input type="password" name="repass" placeholder="Re-Password" required="required"> <span
									class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn">Change Password</button>
							<a href="<c:url value='/view-change-email'/>" class="text-white">Change Your Email</a>
						</form>
						<h4 class="text-white">${err}</h4>
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