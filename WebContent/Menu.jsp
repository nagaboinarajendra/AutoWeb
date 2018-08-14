<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%>
<html>
<head>
<style>
.body {
	background-color: #006989; /* Orange */
	color: #000000;
}

.jumb {
	color: #000000;
	border: 1px solid;
	box-shadow: 2px 2px white;
}

.btn-success {
	border-radius: 10px;
	border: none;
	text-align: center;
}
</style>

<link href="https://fonts.googleapis.com/css?family=Kirang+Haerang"	rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body class="body">
	<div class="container">
		<div class="row">
			<br>
			<br>
		</div>
	<div class="row text-center">
			<p style="font-size: 24px; font-family: 'Kirang Haerang', cursive; color: white;">AUTO PARKING SYSTEM</p>
			<div class="col-sm-3"></div>
			<div class="col-sm-6 jumbotron jumb">
				<p>Select an Option</p>
				<form action="PerformOperations" method="POST">
					<div class="radio">	<label><input type="radio" value="park" checked	name="option" onClick="show()">Park</label></div>
					<div class="radio">	<label><input type="radio" value="unpark" name="option" onClick="show()">Unpark</label></div>
					<div class="radio">	<label><input type="radio" value="display" name="option" onClick="hide()">Display</label></div>
					<input type="text" id="input" name="input" class="form-control"	placeholder="enter vehicle number" style="display: block"><br>
					<div class="form-group"> <input type="submit" value="submit" class="btn-success" style="width: 100px; height: 30px"></div>
				</form>
				<div style="color: red;">
		     <%
		      if(request.getAttribute("message") != null) {
		          out.println("<pre>" + request.getAttribute("message") + "</pre>");
		          }
            %>

     			</div>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-2 text-center jumbotron">
		   <%
		     if(session.getAttribute("username") !=null){
		      String name = (String) session.getAttribute("username");
		      out.println("Hello " + name + "!");
		      }else {
		      response.sendRedirect("login.jsp");
		      }
            %>
				<br>
				<form action="LogoutServlet" method="POST">
					<input type="submit" value="LOGOUT" class="btn-danger">
				</form>
			</div>
		</div>



	</div>
</body>
<script type="text/javascript">
function hide() {
	document.getElementById("input").style.display='none';
}
function show() {
	document.getElementById("input").style.display='block';
}

</script>

</html>
