<%
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setHeader("Cache-Control", "no-store"); // HTTP 1.1
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

<link href="https://fonts.googleapis.com/css?family=Kirang+Haerang" rel="stylesheet"> 

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="body">

	<div class="container">
		<div class="row">
			<br>
			<br>
		</div>
		<div class="row">
			<p style="font-size: 25px; font-family: 'Kirang Haerang', cursive; color : white;" class="text-center">AUTO
				PARKING SYSTEM</p>
			<div class="col-sm-4"></div>
			<div class="col-sm-4 jumbotron jumb">
				<form action="login" method="get">
					<div class="form-group">
						<label for="uname" style="margin-left : 20px;">Username : </label> <input type="text"
							name="username" class="form-control text-center" required><br>
					</div>
					<div class="form-group">
						<label for="psw" style="margin-left : 20px;">Password : </label> <input type="password"
							name="password" class="form-control text-center" required><br>
					</div>
					<div class="form-group text-center">
						<input type="submit" value="submit" class="btn-success"
							style="width: 100px; height: 30px">
					</div>
				</form>
				<div style="color: red; font-weight: bold;">
					<%
        if (request.getAttribute("message") != null)
            out.println(request.getAttribute("message"));
        %>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>
