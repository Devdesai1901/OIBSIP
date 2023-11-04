<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions List</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<style>
body{
min-height:100vh;
background:linear-gradient(rgba(255,255,255,.9),rgba(255,255,255,0.8)), url('images/bg.jpg') no-repeat;min-height:100vh;
background-size:100% 100%;
}
</style>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container-fluid mt-4">
<c:if test="${msg ne null }">
<div class="alert alert-success text-center">${msg }</div>
</c:if>
<div class="row">
	<div class="col-sm-8">
<h4 class="p-2 border-bottom">Questions for Subject ${sub.subname }</h4>
	<table class="table table-sm table-bordered">
<thead>
	<tr>
		<td>Id</td>
		<td>Question</td>
		<td>Choices</td>
		<td>Answer</td>
		<td>Action</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="q">
	<tr>
		<td>${q.id }</td>
		<td>${q.descr }</td>
		<td>
			<ol type="A">
			<li>${q.op1 }</li>
			<li>${q.op2 }</li>
			<li>${q.op3 }</li>
			<li>${q.op4 }</li>
			</ol>
		</td>
		<td>${q.cans }</td>
		<td><a href="/delques/${q.subject.id }/${q.id }" class="btn btn-sm btn-danger">Delete</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
	</div>
	<div class="col-sm-4">
	<h4 class="p-2 text-center">Add New Question</h4>	
	<form method="post" action="/addques">
		<input type="hidden" name="subject" value="${sub.id }">
		<div class="form-group">
			<label>Question</label>
			<input type="text" placeholder="Question text here" required name="descr" class="form-control">
		</div>
		<div class="form-group">
			<label>Choice A</label>
			<input type="text" required name="op1" class="form-control">
		</div>
		<div class="form-group">
			<label>Choice B</label>
			<input type="text" required name="op2" class="form-control">
		</div>
		<div class="form-group">
			<label>Choice C</label>
			<input type="text" required name="op3" class="form-control">
		</div>
		<div class="form-group">
			<label>Choice D</label>
			<input type="text" required name="op4" class="form-control">
		</div>
		<div class="form-group">
			<label>Correct Answer</label>
			<select required name="cans" class="form-control">
				<option value="">Select Answer</option>
				<option>A</option>
				<option>B</option>
				<option>C</option>
				<option>D</option>
			</select>
		</div>
		<button class="btn btn-primary float-right">Save Question</button>
	</form>
	</div>
</div>	
</div>
</body>
</html>