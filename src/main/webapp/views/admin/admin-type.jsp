<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="row border border-primary">
		<form action="" method="post">
			<div class="mt-2 text-center">Add Type</div>
			<div class="form-outline mb-4 mt-2">
				<input type="text" id="form4Example1" class="form-control"
					name="name" /> <label class="form-label" for="form4Example1">Name Type</label>
			</div>
			<div class="form-outline mb-4 mt-2">
				<input type="text" id="form4Example1" class="form-control" /> <label
					class="form-label" for="form4Example1">Href</label>
			</div>
			<div class="form-outline mb-4 mt-2">
				<input type="text" id="form4Example1" class="form-control" /> <label
					class="form-label" for="form4Example1">Poster</label>
			</div>
			<div class="form-outline mb-3 ">

				<select name="active">
					<option value="true">Active</option>
					<option value="false">Non-Active</option>
				</select> <br> <label>Video Status</label>
			</div>
			<!-- Message input -->
			<div class="form-outline mb-4">
				<textarea class="form-control" id="form4Example3" rows="4"></textarea>
				<label class="form-label" for="form4Example3">Description</label>
			</div>

			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-4">Add</button>
			<button type="submit" class="btn btn-primary btn-block mb-4">Update</button>
		</form>
	</div>
	<div class="row mt-2">
		<h3>List Video</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Active</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${video}" var="x">
					<tr>
						<th scope="row">${x.id}</th>
						<td>${x.title}</td>
						<td>${x.active}</td>
						<td><a href="#editEmployeeModal" class="edit"
							data-toggle="modal"><i class="fa fa-pencil"
								aria-hidden="true">Edit</i></a> <br> <a
							href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
								class="fa fa-trash-o" aria-hidden="true"></i>Dele</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>