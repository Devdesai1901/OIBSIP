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
<div class="jumbotron text-center bg-transparent shadow p-4">
	<h3>Online Examination Application</h3>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-12 mx-auto">
			<div class="card shadow bg-transparent">
				<div class="card-header text-center">
					<h5>User Registration Screen</h5>
				</div>
				<div class="card-body">
					<form method="post">
					<c:if test="${error ne null }">
						<div class="alert text-danger text-center font-weight-bold">${error }</div>
					</c:if>
					<div class="row">
						<div class="col-sm-6">
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Name</label>
							<div class="col-sm-8">
								<input type="text" value="${user.uname }" name="uname" required placeholder="Name" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Age</label>
							<div class="col-sm-8">
								<input type="number" value="${user.age }" min="10" max="50" name="age" required placeholder="Age" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Education</label>
							<div class="col-sm-8">
								<input type="text" value="${user.education }" name="education" required placeholder="Education" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Present Occupation</label>
							<div class="col-sm-8">
								<input type="text" value="${user.occupation }" name="occupation" required placeholder="Present Occupation" class="form-control">
							</div>
							</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Select Subject</label>
							<div class="col-sm-8">
								<select name="subject" required class="form-control">
									<option value="">Select Subject</option>
									<c:forEach var="s" items="${list }">
									<option value="${s.id }">${s.subname }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						</div>
						<div class="col-sm-6">
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Gender</label>
							<div class="col-sm-8">
								<select name="gender" required class="form-control">
									<option value="">Select Gender</option>
									<option>Male</option>
									<option>Female</option>
								</select>
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Place of Residence</label>
							<div class="col-sm-8">
								<input type="text" name="address" value="${user.address }" required placeholder="Address" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Email ID</label>
							<div class="col-sm-8">
								<input type="text" name="email" value="${user.email }" required placeholder="Your Email Id" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">User Name</label>
							<div class="col-sm-8">
								<input type="text" value="${user.userid }" name="userid" required placeholder="User Id" class="form-control">
							</div>
						</div>
						<div class="form-group form-row">
							<label class="col-form-label col-sm-4">Password</label>
							<div class="col-sm-8">
								<input type="password" required placeholder="Password" name="pwd" class="form-control">
							</div>
						</div>
						</div>
					</div>
						
						
						<button class="btn btn-primary px-4 float-right">Register</button>
					</form>
				</div>
				<div class="card-footer text-right">
					Already registered <a href="/">Click here</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>