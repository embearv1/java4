<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    
    
	<!-- Begin View -->
    <jsp:include page="${view}"/>
	<!-- End View -->



    <!-- Footer Section Begin -->
   <%@include file="/layout/footer.jsp"%>
    <!-- Footer Section End -->

    <!-- Search model Begin -->
    <div class="search-model">
      <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form class="search-model-form">
          <input type="text" id="search-input" placeholder="Search here....." />
        </form>
      </div>
    </div>
    <!-- Search model end -->

    <!-- Js Plugins -->
    <%@include file="/common/foot.jsp" %>
  </body>
</html>
