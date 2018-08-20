<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <link rel="stylesheet" href="./css/index.css"/>
</head>
<style>
#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #333;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
}

#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

</style>
<body>
			                <button type="button" class="btn btn-warning col-sm-12 two"><h3><b>AUTO PARKING MANAGEMENT SYSTEM</b></h3></button>
			
  <div class="row">
                <button type="button" class="btn btn-info one col-sm-4 " data-toggle="modal" data-target="#myModal" id="admin1" onClick="reply_click(this.id)"><h3><b>PARK VEHICLE</b></h3></button>

                    <button type="button" class="btn btn-info one col-sm-4 " data-toggle="modal" data-target="#myModal" id="admin2" onClick="reply_click(this.id)"><h3><b>UNPARK VEHICLE</b></h3></button>

                    <button type="button" class="btn btn-info one col-sm-4 " data-toggle="modal" data-target="#myModal" id="admin3" onClick="reply_click(this.id)"><h3><b>VIEW PARKING SPACE</b></h3></button>

  </div>
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
			<div class="main">
				<h2>AdminLogin</h2>
				<form id="form_id" method="post" action="login">
					<label>User Name :</label> 
					<input type="text" name="uname" id="username" />
					<label>Password :</label> 
					<input type="password" name="psw" id="password" />
					<input type="submit" value="Login" id="submit" />
				</form>
			</div>
        </div>
    </div>
</div>
<input type="hidden" id="hiddenField"/>
<%
		      if(request.getAttribute("message") != null) {	 
		    	  %>
		    	  
		           <div id="snackbar"><% out.println(request.getAttribute("message")); %></div>
		         <%  }
            %>
<script>
$('#myModal').modal('show');
function myFunction() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}

function reply_click(clicked_id)
	var el = document.getElementById("hiddenField");
	el.value = clicked_id;
	alert(clicked_id);
}

</script>
