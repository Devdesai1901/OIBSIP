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
<h4 class="p-2 text-center">Exam Report of ${user.uname }</h4>
<h5 class="text-success float-left">Correct Answers : ${correct }</h5>	
<h5 class="text-danger float-right">Wrong Answers : ${incorrect }</h5>

<div class="clearfix"></div>	
		<table class="table table-bordered table-striped">
		<thead class="table-primary">
			<tr>
				<th>Question ID</th>
				<th>User Ans</th>
				<th>Correct Ans</th>
				<th>Time Taken</th>
				<th>Remarks</th>
			</tr>			
		</thead>		
		<tbody>
		<c:forEach items="${list }" var="u">
			<tr>
				<th>${u.id }</th>
				<th>${u.uans eq null ? "Unanswered" : u.uans }</th>
				<th>${u.question.cans}</th>
				<th>${u.time } seconds</th>
				<th><span class="${u.uans eq u.question.cans ? "text-success":"text-danger" }">
				${u.uans eq u.question.cans ? "&#x2714;":"&#x2718;" }</span>
				</th>
			</tr>
		</c:forEach>
		</tbody>
		</table>
</div>
</body>
</html>