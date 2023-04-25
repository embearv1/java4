<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row border border-primary">
	<form action="AccountController" method="post">
		<div class="mt-2 text-center">Manage Account</div>
		<div class="form-outline mb-4 mt-2">
			<input type="text" id="form4Example1" class="form-control"
				name="user" required="required" value="${uu.user}"/> <label class="form-label"
				for="form4Example1">User</label>
		</div>
		<div class="form-outline mb-4 mt-2">
			<input type="password" id="form4Example1" class="form-control"
				required="required" name="pass" value="${uu.pass}"/> <label class="form-label" 
				for="form4Example1">Password</label>
		</div>
		<div class="form-outline mb-4 mt-2">
			<input type="text" id="form4Example1" class="form-control"
				required="required" name="name" value="${uu.name}"/> <label class="form-label" for="form4Example1"
				>Name</label>
		</div>
		<div class="form-outline mb-4">
			<input type="email"  class="form-control" name="email"
				required="required" value="${uu.email}"/> <label class="form-label" for="form4Example1"
				>Email</label>
		</div>
		<div class="form-outline mb-4 mt-2">
			<h5>Admin:${uu.admin==true?"Admin":"User"}</h5>
		</div>
		<!-- Message input -->

		<!-- Submit button -->
		<button formaction="<c:url value='/account/add-acc'/>" type="submit" class="btn btn-success btn-block mb-4">Add</button>
		<button formaction="<c:url value='/account/update-acc'/>" type="submit" class="btn btn-success btn-block mb-4">Update</button>
	</form>
</div>
<div class="row mt-2">
	<h3>List Video</h3>
	<table class="table  table-hover">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">User</th>
				<th scope="col">Pass</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Admin</th>
				<th scope="col">Active</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${all_acc}" var="x">
				<tr>
					<th scope="row">${x.id}</th>
					<td>${x.user}</td>
					<td>${x.pass}</td>
					<td>${x.name}</td>
					<td>${x.email}</td>
					<td>${x.admin==true?"Admin":"User"}</td>
					<td>${x.active}</td>
					<td><a href="<c:url value='/account/detail-acc'/>?id=${x.id}" class="edit"
						data-toggle="modal"><i class="fa fa-pencil" aria-hidden="true">Edit</i></a>
						<br> <a href="<c:url value='/account/delete-acc'/>?id=${x.id}" class="delete"
						data-toggle="modal"><i class="fa fa-trash-o"
							aria-hidden="true"></i>Dele</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>