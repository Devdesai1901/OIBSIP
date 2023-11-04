<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions List</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
ul li{
padding:0px !important;
}
input[type=radio]{
	display:none;
}
label{
	display:block;
	height:100%;
	padding:8px;
}
input[type=radio] ~ label{
	background-color:white;
	color:black;
}
input[type=radio]:checked ~ label{
	background-color:green;
	color:white;
}
</style>
<script src="js/jquery-3.4.1.js"></script>
<script src="js/bootstrap.js"></script>
<script>
let max=30*60; //30minutes
if(sessionStorage.getItem("max")!=null){
	max=sessionStorage.getItem("max");
}
window.onload=function(){	
	setInterval(()=>{
		let time=parseInt($("#time").html());
		$("#time").html(time+1);
		$("#ntime").val(time+1);
	},1000);
	setInterval(()=>{
		max--;
		let x=converttotime(max);
		$("#max").html(x);	
		sessionStorage.setItem("max",max);
		$("#nmax").val(max);
	},1000);
};
function finishnow(){
	console.log("finish run");
	sessionStorage.removeItem("max");
}
function converttotime(num){
	let min=Math.floor(num/60);
	let sec=num%60;
	return pad(min,2)+":"+pad(sec,2);
}
function pad(num, size) {
    num = num.toString();
    while (num.length < size) num = "0" + num;
    return num;
}
</script>
</head>
<body>
<div class="container mt-4">
<c:if test="${msg ne null }">
<div class="alert alert-success text-center">${msg }</div>
</c:if>
<h4 class="float-right p-2">${sessionScope.user.uname }</h4>
<h4 class="p-2 text-center">Online Exam</h4>	
<div class="card shadow mb-2">
	<div class="card-body">
	<h4 class="p-2 border text-center">Time Remaining : <span id="max"></span></h4>
	<span id="time" class="text-white">${ex.time eq null ? "0" :ex.time }</span>
	<h4>Question ${sessionScope.id } of ${sessionScope.total }</h4>
	<form method="post">
		<input type="hidden" name="id" value="${ex.id }">
		<input type="hidden" name="time" id="ntime" value="${ex.time }">
		<input type="hidden" name="userid" value="${sessionScope.user.userid }">
		<h5 class="p-2">Q ${ex.question.descr } ${ex.uans }</h5>
		<ul class="list-group">
		<li class="list-group-item">
			<input id="a" type="radio" name="uans" ${ex.uans=='A' ? 'checked' : ''} value="A">
			<label for="a">A ${ex.question.op1 }</label>
		</li>
		<li class="list-group-item">
		<input type="radio" id="b" name="uans" ${ex.uans=='B' ? 'checked' : ''} value="B">
		<label for="b">B ${ex.question.op2 }</label>
		</li>
		<li class="list-group-item">
		<input type="radio" id="c" name="uans" ${ex.uans=='C' ? 'checked' : ''} value="C">
		<label for="c">C ${ex.question.op3 }</label>
		</li>
		<li class="list-group-item">
		<input type="radio" id="d" name="uans" ${ex.uans=='D' ? 'checked' : ''} value="D">
		<label for="d">D ${ex.question.op4 }</label>
		</li>
		<br>
		</ul>
		<c:if test="${sessionScope.id ne sessionScope.total }">		
			<button class="btn btn-primary float-right ml-2" name="next">Next</button>
		</c:if>
		<c:if test="${sessionScope.id eq sessionScope.total }">		
			<button class="btn btn-primary float-right ml-2" name="finish" onclick="finishnow()">Finish</button>
		</c:if>
		<c:if test="${not first and sessionScope.id>1}">
			<button class="btn btn-primary float-right ml-2" name="prev">Previous</button>
		</c:if>
	</form>
	</div>
</div>
</div>

</body>
</html> 