<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row page-titles">
	<div class="col-md-5 align-self-center">
		<h3 class="text-themecolor">Hello ${sessionScope.user.name}!</h3>
	</div>
</div>
<div class="row">
	<h3 class="text-white bg-danger">Most View Video</h3>
		<table class="table table-success table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Type Video</th>
					<th scope="col">Href</th>
					<th scope="col">Poster</th>
					<th scope="col">View</th>
					<th scope="col">Share</th>
					<th scope="col">Description</th>
					<th scope="col">Active</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videoView}" var="x">
					<tr>
						<th scope="row">${x.id}</th>
						<td>${x.title}</td>
						<td>${x.type.name}</td>
						<td>${x.href}</td>
						<td><img alt="" width="100px"
							src="<c:url value='${x.poster}'/>"></td>
						<td>${x.view}</td>
						<td>${x.share}</td>
						<td>${x.descrip}</td>
						<td>${x.active}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
<hr>
<div class="row">
	<h3 class="text-white bg-danger">Most Share Video</h3>
		<table class="table table-info table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Type Video</th>
					<th scope="col">Href</th>
					<th scope="col">Poster</th>
					<th scope="col">View</th>
					<th scope="col">Share</th>
					<th scope="col">Description</th>
					<th scope="col">Active</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videoShare}" var="x">
					<tr>
						<th scope="row">${x.id}</th>
						<td>${x.title}</td>
						<td>${x.type.name}</td>
						<td>${x.href}</td>
						<td><img alt="" width="100px"
							src="<c:url value='${x.poster}'/>"></td>
						<td>${x.view}</td>
						<td>${x.share}</td>
						<td>${x.descrip}</td>
						<td>${x.active}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>