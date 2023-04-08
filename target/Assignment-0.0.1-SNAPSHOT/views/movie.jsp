<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Product Section Begin -->
	<section class="product-page spad">
		<div class="container">
			<div class="product__page__content">
				<div class="product__page__title">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-6">
							<div class="section-title">
								<h4>List</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="product__page__filter">
								<p>Order by:</p>
								<select>
									<option value="">A-Z</option>
									<option value="">1-10</option>
									<option value="">10-50</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${video}" var="x">
					<div class="col-lg-3 col-md-6 col-sm-6">
						<div class="product__item">
							<div class="product__item__pic set-bg" data-setbg="${x.poster}">
								<div class="comment">
									<i class="fa fa-comments"></i> 11
								</div>
								<div class="view">
									<i class="fa fa-eye"></i>${x.view}</div>
							</div>
							<div class="product__item__text">
								<ul>
									<li>${x.type.name}</li>
								</ul>
								<h5>
									<a href="<c:url value="video/detail?id=${x.id}"/>">${x.title}</a>
								</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="product__pagination text-center">
			<a href="all-video?index=1"><i class="fa fa-angle-double-left"></i></a>
				<c:forEach begin="1" end="${end}" var="i">
					<a href="all-video?index=${i}" class="current-page">${i}</a>
				</c:forEach>
				<a href="all-video?index=${end}"><i class="fa fa-angle-double-right"></i></a>
				<!-- <a href="#" class="current-page">1</a> <a href="#">2</a> <a href="#">3</a>
				<a href="#">4</a> <a href="#">5</a> <a href="#"><i
					class="fa fa-angle-double-right"></i></a> -->
			</div>
		</div>
	</section>
	<!-- Product Section End -->