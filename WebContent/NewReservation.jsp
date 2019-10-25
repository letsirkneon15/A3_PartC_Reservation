<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Hotel Reservation</title>
</head>
	<style type="text/css">
		
		body {
			font-family:arial;
			margin: 0px;
			padding:0px;
		}
		
		#navigation-bar {
		
			/***********  Fixed position at top, 100% */
			position:fixed;
			top: 0;
			left:0;
			margin:0;
			width:100%;
			height:41px;
			z-index:1;
			
			/*********** alignment of items within bar */
			display: flex;
			align-items: center;
			justify-content: center;
			/**padding-left:130px;*/
			overflow:hidden;
			
			/***********  styling */
			background-color:#eaf0fa;
					
		}
		
		.nav-link:hover {
			background-color:#001a66;
			box-shadow: 2px 2px 2px 2px grey;
			color: white;
		}
		
		#logo {
			position:fixed;
			top:0px;
			left:2px;
			text-transform: none;
			display:inline-block;
			background-color:#001a66;
			color:white;
			z-index:4;
		}
		
		.nav-font-box {	
			border-radius: 5px;
			margin: 5px 5px 5px 5px;
			padding: 5px 10px 5px 10px;
			text-transform: uppercase;
			font-size:15;
			color: black;
			font-family: arial;
			letter-spacing: 1px;
			text-decoration:none;
			background-color:#eaf0fa;
			float:left;
		}
	
		#main-containter{
			margin-left:auto;
			margin-right:auto;
			padding:30px 50px 200px 50px;
			top:0px;
			width:1190px;
			background-color:#f9f9f9;
		}
		
		hr {
			border-top: 1px #0f213e solid;
		}
		h1 {
			color: #0f213e;
			font-size:200%;
			text-align: center;
			letter-spacing: 1px;
		}
		
		.longPlease {
			width: 300px;
		}
		
		td {
		width : 100px
		}
		tr{
			height:40px;
		}
		
	</style>
	
<body>


<div id="main-containter" align = "center">
				
			<p><h1> New Reservation</h1></p>
			<hr>

<Form method="post" action=${pageContext.request.contextPath}/main?action=reservation>
<table border=0>

<tr>
		<td> First Name: </td>
		<td> <input type ="text" class="longPlease" name ="firstName" value="${firstName}"></input> </td>
<tr>
		<td> Last Name: </td>
		<td> <input type ="text"  class="longPlease" name="lastName" value="${lastName}"></input> </td>
</tr>
<tr>
		<td> Address: </td>
		<td> <input type ="text"  class="longPlease" name="address" value="${address}"></input> </td>
</tr>
<tr>
		<td> Check in: </td>
		<td> <input type ="date"  class="longPlease" name = "checkIn" value="${checkIn}"></input> </td>
</tr>
<tr>
		<td> Check out: </td>
		<td> <input type ="date" class="longPlease"  name = "checkOut" value="${checkOut}"></input> </td>
</tr>
<tr>
		<td> Available Rooms: </td>
		<td> <select class="form-control" id="rooms" name="rooms" data-selected="${rooms}">
  			<option value="Standard">Standard</option>
 		    <option value="Deluxe">Deluxe</option>
    		<option value="Deluxe King">Deluxe King</option>
  			<option value="Alpine">Alpine</option>
			</select>
 		</td>
</tr>
<tr>
		<td> Charges: </td>
		<td><label> ${chargeWithoutTax} </label></td>
</tr>
<tr>
		<td> 10% Tax: </td>
		<td><label> ${taxes} </label></td>
</tr>
<tr>
		<td> Total Charges: </td>
		<td><label> ${totalCharges} </label></td>
</tr>
<tr>
<td></td>
<td>
		<input type="submit" value="Calculate Charges" name="Calculate Charges">
</td>
</tr>
</table>
</Form>			
</div>

<script type="text/javascript">
/**************** For Drop Down Default Value ********************************/

$("select[data-selected]").each(function() {
    var selected = $(this).data("selected");
    $("select[data-selected='" + selected + "'] option[value='" + selected + "']").attr("selected", "selected");
})
</script>

</body>
	
</html>
		