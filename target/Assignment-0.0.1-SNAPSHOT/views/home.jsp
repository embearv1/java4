<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Hero Section Begin -->
    <section class="hero">
      <div class="container">
        <div class="hero__slider owl-carousel">
          <div class="hero__items set-bg" data-setbg="<c:url value='/template/user/img/hero/hero-1.jpg'/>">
            <div class="row">
              <div class="col-lg-6">
                <div class="hero__text">
                  <div class="label">Adventure</div>
                  <h2>Fate / Stay Night: Unlimited Blade Works</h2>
                  <p>Most beautifull anime</p>
                  <a href="#"
                    ><span>Watch Now</span> <i class="fa fa-angle-right"></i
                  ></a>
                </div>
              </div>
            </div>
          </div>
          <div class="hero__items set-bg" data-setbg="<c:url value='/template/user/img/hero/hero-1.jpg'/>">
            <div class="row">
              <div class="col-lg-6">
                <div class="hero__text">
                  <div class="label">Adventure</div>
                  <h2>Fate / Stay Night: Unlimited Blade Works</h2>
                  <p>After 30 days of travel across the world...</p>
                  <a href="#"
                    ><span>Watch Now</span> <i class="fa fa-angle-right"></i
                  ></a>
                </div>
              </div>
            </div>
          </div>
          <div class="hero__items set-bg" data-setbg="<c:url value='/template/user/img/hero/hero-1.jpg'/>">
            <div class="row">
              <div class="col-lg-6">
                <div class="hero__text">
                  <div class="label">Adventure</div>
                  <h2>Fate / Stay Night: Unlimited Blade Works</h2>
                  <p>Premiered on 9 May 2023</p>
                  <a href="<c:url value='/video/detail?id=5'/>"
                    ><span>Watch Now</span> <i class="fa fa-angle-right"></i
                  ></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Hero Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <div class="trending__product">
              <div class="row">
                <div class="col-lg-8 col-md-8 col-sm-8">
                  <div class="section-title">
                    <h4>Trending Now</h4>
                  </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4">
                  <div class="btn__all">
                    <a href="<c:url value='/all-video'/>" class="primary-btn"
                      >View All <span class="arrow_right"></span
                    ></a>
                  </div>
                </div>
              </div>
              <div class="row">
               <c:forEach items="${_list}" var="x">
               		 <div class="col-lg-4 col-md-6 col-sm-6">
                  <div class="product__item">
                    <div
                      class="product__item__pic set-bg"
                      data-setbg="<c:url value='${x.poster}'/>"
                    >
                      <div class="comment">
                        <i class="fa fa-comments"></i> 11
                      </div>
                      <div class="view"><i class="fa fa-eye"></i>${x.view}</div>
                    </div>
                    <div class="product__item__text">
                      <ul>
                        <li>${x.type.name}</li>
                      </ul>
                      <h5>
                        <a href="<c:url value='/video/detail?id=${x.id}'/>">${x.title}</a>
                      </h5>
                    </div>
                  </div>
                </div>
               </c:forEach>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 col-sm-8">
            <div class="product__sidebar">
              <div class="product__sidebar__view">
                <div class="section-title">
                  <h5>New Update Video</h5>
                </div>
<!--                 <ul class="filter__controls">
                  <li class="active">Most Like</li>
                </ul> -->
                <div class="filter__gallery">
                <c:forEach items="${_ds}" var="c">
                	<div
                    class="product__sidebar__view__item set-bg mix day years"
                    data-setbg="<c:url value='${x.poster}'/>"
                  >
                    <div class="view"><i class="fa fa-eye"></i> ${c.view}</div>
                    <h5><a href="#">${c.title}</a></h5>
                  </div>
                </c:forEach>
                  
                </div>
              </div>
          </div>
        </div>
      </div>
      </div>
    </section>
    <!-- Product Section End -->