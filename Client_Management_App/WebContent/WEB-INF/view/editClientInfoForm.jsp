<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Client Info</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/clientApp.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/clientApp-addClient.css">
</head>
<body>
	<div id="addClientPage">
		<div id="header">
			<h2>Client Management App</h2>
		</div>
	</div>
	<div id="container">
		<h3>Edit Client Information</h3>
		<form:form action="addClient" modelAttribute="client" method="POST">
			<form:hidden path="id" />
			<!-- without this you will lose the context -->

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="add" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div>
			<p>
				<a href="${pageContext.request.contextPath}/client/list">Go to
					home page</a>
			</p>
		</div>
	</div>
</body>

</html>