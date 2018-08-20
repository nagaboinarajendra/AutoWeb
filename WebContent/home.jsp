<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="org.epam.parking.ParkingSpace"%>
<%@page import="org.epam.parking.Slot"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Autoparking</title>
<link rel="stylesheet" href="./css/home.css" />
<script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="./js/menu.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="main">

			<h2>Operations</h2>
			<div class="input">
				<form>
					<input type="radio" name="option" id="option" value="park" checked>Park<br> 
					<input type="radio" name="option" id="option" value="unpark">Unpark<br> 
					<label>Registration number :</label> 
					<input type="text" name="registration" id="registration" /> 
					<input type="button" value="submit" id="submit" /> <br>
				</form>
				<div id="valid"></div>
			</div>
			<div class="display">
				<label>Search :</label> <input type="text" name="search" id="search" onkeyup="myFunction()"/>
				<div class="table" id="tableDisplay">
					<table>
						<thead>
							<tr>
								<th>Vehicle number</th>
								<th>Slot</th>
								<th>In-time</th>
							</tr>
						</thead>
						<tbody id="myTable">
							<%
							ParkingSpace parkingSpace = (ParkingSpace)request.getSession().getServletContext().getAttribute("parkingSpace");
		                    for(Slot obj :parkingSpace.queue) {
							%>
							<tr>
								<td>
									<%
									    out.print(obj.car[obj.getSlotNumber()].getCarNumber());
									%>
								</td>
								<td>
									<%
									    out.print(obj.getSlotNumber());
									%>
								</td>
								<td>
									<%
									    out.print(obj.intime[obj.getSlotNumber()].getInTime());
									%>
								</td>
							</tr>
							<%
							    }
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
