<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<title>Client Records</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/clientApp.css">
</head>
<body>
	 <div id="mainPage">
	<div id="header">
	<h2>Client Management App</h2>
	</div>
	</div>
	<div id="container">
	<div id="content">
	<table id="table">
	<tr><th>First Name</th>
	<th>Last Name</th>
	<th>Email</th></tr>
	<c:forEach var="theClient" items="${client_Records}">
	<tr>
		<td> ${theClient.firstName}</td>
		<td> ${theClient.lastName}</td>
		<td> ${theClient.email}</td>
	</tr>
	</c:forEach>
	</table>
	</div>
	</div> 
	
</body>


</html>