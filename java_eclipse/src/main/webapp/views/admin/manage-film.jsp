<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="mb-3">
		You Want Add New Film? <a href="<c:url value='/admin/view-add-video'/>" class="btn btn-success">Add new
			Film</a>
	</div>
	<div class="row border border-primary">
		<form action="/Assignment/admin/update-video" method="post" enctype="multipart/form-data">
			<div class="mt-2 text-center">Or Update Film</div>
			<div class="form-outline mb-4 mt-2">
				<input type="text" id="form4Example1" class="form-control"
					name="title"  value="${v.title}"/> <label class="form-label" for="form4Example1">Tiltle</label>
			</div>
			<div class="form-outline mb-4">
				<select name="type">
					<c:forEach items="${all_type}" var="c">
						<option value="${c.id}" ${v.type.id==c.id?'selected':''}>${c.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-outline mb-4 mt-2">
				<input type="text"  id="form4Example1" class="form-control" name="href"  value="${v.href}"/> <label
					class="form-label" for="form4Example1">Href</label>
			</div>
			<div class="form-outline mb-4 mt-2">
				<input type="file" name="poster"  class="form-control" value="${v.poster}" /> <label
			class="form-label" for="form4Example1">Poster</label>
			</div>
			<!-- Message input -->
			<div class="form-outline mb-4">
				<textarea class="form-control" id="form4Example3" rows="4"  name="descrip">${v.descrip}</textarea>
				<label class="form-label" for="form4Example3">Description</label>
			</div>

			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-4">Update</button>
		</form>
	</div>
	<div class="row mt-2">
		<h3>List Video</h3>
		<table class="table table-hover">
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
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${video}" var="x">
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
						<td><a href="<c:url value='/admin/view-update-video'/>?id=${x.id}" class="edit"
							data-toggle="modal"><i class="fa fa-pencil"
								aria-hidden="true">Edit</i></a> <br> <a
							href="<c:url value='/admin/delete-video'/>?id=${x.id}" class="delete" data-toggle="modal"><i
								class="fa fa-trash-o" aria-hidden="true"></i>Dele</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="border"
							href="/Assignment/admin/manage-video?index=1"><i
								class="fa fa-angle-double-left"></i></a></li>
						<li class="page-item"><c:forEach begin="1" end="${end}"
								var="i">
								<a href="/Assignment/admin/manage-video?index=${i}"
									class="border">${i}</a>
							</c:forEach></li>
						<li class="page-item"><a
							href="/Assignment/admin/manage-video?index=${end}" class="border"><i
								class="fa fa-angle-double-right"></i></a></li>
					</ul>
				</nav>
			</div>
	</div>
