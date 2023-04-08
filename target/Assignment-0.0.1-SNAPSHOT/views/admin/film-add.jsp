<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mb-3 text-center">
		 <span class=" bg-warning text-white">Add New Film</span>
</div>
<form action="" method="post">
	<div class="form-outline mb-4 mt-2">
		<input type="text" id="form4Example1" class="form-control"
			name="title" /> <label class="form-label" for="form4Example1">Tiltle</label>
	</div>
	<div class="form-outline mb-4">
		<select name="type_video">
			<c:forEach items="${all_type}" var="c">
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-outline mb-4 mt-2">
		<input type="text" id="form4Example1" class="form-control" /> <label
			class="form-label" for="form4Example1">Href</label>
	</div>
	<div class="form-outline mb-4 mt-2">
		<input type="text" id="form4Example1" class="form-control" /> <label
			class="form-label" for="form4Example1">Poster</label>
	</div>
	<!-- Message input -->
	<div class="form-outline mb-4">
		<textarea class="form-control" id="form4Example3" rows="4"></textarea>
		<label class="form-label" for="form4Example3">Description</label>
	</div>

	<!-- Submit button -->
	<button type="submit" class="btn btn-success btn-block mb-4">Add</button>
</form>