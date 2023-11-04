<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Examination</title>
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
<div class="container mt-4">
<c:if test="${msg ne null }">
<div class="alert alert-success text-center">${msg }</div>
</c:if>
<h4 class="p-2 text-center">Welcome to Admin Dashboard</h4>	
<div class="row">
	<div class="col-sm-3">
		<div class="card shadow">
			<div class="card-body text-right">
				<h5>Total Questions</h5>
				<h4>${totalques }</h4>
			</div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="card shadow">
			<div class="card-body text-right">
				<h5>Total Registered Users</h5>
				<h4>${totalusers }</h4>
			</div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="card shadow">
			<div class="card-body text-right">
				<h5>Total Cleared Users</h5>
				<h4>${totalclear }</h4>
			</div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="card shadow">
			<div class="card-body text-right">
				<h5>Total UnCleared Users</h5>
				<h4>${totalfail }</h4>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>