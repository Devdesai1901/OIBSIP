<!DOCTYPE html>
<html>
    <head>
        <title>Instructions</title>
        <link href="css/bootstrap.css" rel="stylesheet">
		<style>
		body{
		min-height:100vh;
		background:linear-gradient(rgba(255,255,255,.9),rgba(255,255,255,0.8)), url('images/bg.jpg') no-repeat;min-height:100vh;
		background-size:100% 100%;
		}
		</style>
    </head>
    <body>
        <div class="container-fluid">            
            <div class="card shadow mt-2 mx-auto" style="min-height: 90vh;max-width:80%;">
                <div class="card-title text-center">
                    <img src="images/logo.png" class="img-thumbnail rounded-circle mt-2" style="width:100px;">
                </div>
                <div class="card-body">  
                <h5 class="p-2 float-right">Hi! ${sessionScope.user.uname }</h5>              
                    <h4 class="text-center p-2" style="border-bottom: 2px solid green;">Instructions</h4>
                    <ol>
                        <li>The examination will comprise of Objective type Multiple Choice Questions (MCQs) </li>
                        <li>All questions are compulsory and each carries equal mark. </li>
                        <li>There will be NO NEGATIVE MARKING for the wrong answers</li>
                        <li>Do not resize or minimise the browser during the online exam.</li>
                        <li> Do not close the browser during the test before your exam is complete.</li>
                        <li> Do not click the 'BACK' button of browser during exam.</li>
                        <li> Keep an eye on the TIMER CLOCK on top left of the online exam page of the browser to keep a track of
                            the time left.</li>                        
                        <li> After finishing the exam, click on the PRE-CONFIRM button at the bottom of the browser page.</li>                                                                       
                        <li> Once submitted, a message shall be displayed "Your Exam has been submitted successfully" and you
                            can logout from the student online portal.</li>
                    </ol>

                    <h4 class="text-center p-2"> ===== All the best =====</h4>
                    <div class="text-center">
	                    <a href="/logout" target="blank" class="btn btn-danger" style="width:200px;margin-top:70px;">Not Agree</a>
	                    <a href="/Start" target="blank" class="btn btn-success" style="width:200px;margin-top:70px;">Agree</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

