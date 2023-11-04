<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions List</title>
<link rel="stylesheet" href="css/bootstrap.css">
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
<h4 class="p-2 text-center">Subjects</h4>	
<div class="form-row">
<div class="col-sm-8">
<table class="table table-bordered">
<thead>
	<tr>
	<th>Id</th>
	<th>Subject Name</th>
	<th>Action</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="q">
<tr>
	<td>${q.id }</td>
	<td>${q.subname }</td>
	<td>
	<a href="/delsub/${q.id }" onClick="return confirm('Are you sure to delete this subject ?')" 
	class="btn btn-sm btn-danger">Delete</a>
	<a href="/questions/${q.id }" class="btn btn-primary btn-sm">Questions</a>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<div class="col-sm-4">
<form method="post">
	<div class="form-group">
		<label>Subject Name</label>
		<input type="text" class="form-control" name="subname">
	</div>
	<button class="btn btn-primary">Save Subject</button>
	</form>
</div>
</div>
</div>
</body>
</html>