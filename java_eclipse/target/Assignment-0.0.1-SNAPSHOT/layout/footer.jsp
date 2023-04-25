<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <footer class="footer mt-2">
      <div class="page-up">
        <a href="#" id="scrollToTopButton"
          ><span class="arrow_carrot-up"></span
        ></a>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="footer__logo">
              <a href="<c:url value='/index.jsp'/>"><img src="<c:url value='/template/user/img/logo.png'/>" alt="" /></a>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="footer__nav">
              <ul>
               <li class="active"><a href="<c:url value='/index.jsp'/>">Homepage</a></li>
                  <li><a href="<c:url value='/all-video'/>">Anime</a></li>
                  <li><a href="<c:url value='/video/blog'/>">Our Blog</a></li>
                <li><a href="#">My Account</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-3">
            <p>
              Copyright &copy;
              <script>
                document.write(new Date().getFullYear());
              </script>
              Made Back-End by EmNguyen
            </p>
          </div>
        </div>
      </div>
    </footer>