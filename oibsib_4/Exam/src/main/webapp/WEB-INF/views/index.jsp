<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
<div class="jumbotron bg-transparent text-center shadow">
	<h3>Online Examination Application</h3>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-6 mx-auto">
			<div class="card shadow bg-transparent">
				<div class="card-header text-center">
					<h5>Login Screen</h5>
				</div>
				<div class="card-body">
					<form method="post">
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">User ID</label>
							<div class="col-sm-8">
								<input type="text" required name="userid" placeholder="User Id" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Password</label>
							<div class="col-sm-8">
								<input type="password" required placeholder="Password" name="pwd" class="form-control">
							</div>
						</div>
						<button class="btn btn-primary px-4 float-right">Login</button>
					</form>
				</div>
				<div class="card-footer text-right">
					Not registered <a href="/register">Click here</a>
				</div>
				<div class="clearfix"></div>
				<c:if test="${error ne null }">
					<div class="alert text-danger text-center font-weight-bold">${error }</div>
				</c:if>
				<c:if test="${msg ne null }">
					<div class="alert text-success text-center font-weight-bold">${msg }</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
</body>
</html>