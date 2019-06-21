<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Client Records</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/clientApp.css">
</head>
<body>
	<div id="mainPage">
		<div id="header">
			<h2>
				<a href="${pageContext.request.contextPath}/client/list"
					class="a-header">Client Management App</a>
			</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<div id="searchBox">
				<form:form action="search" method="GET">Search: <input
						type="text" name="clientName" placeholder="Name" />
					<input type="submit" value="Search" class="add-button searchbutton" />
				</form:form>
			</div>
			<table id="table">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Update</th>
				</tr>
				<c:forEach var="theClient" items="${client_Records}">

					<c:url var="editLink" value="/client/editClientInfo">
						<c:param name="clientId" value="${theClient.id}"></c:param>
					</c:url>

					<c:url var="removeLink" value="/client/removeClient">
						<c:param name="clientId" value="${theClient.id}"></c:param>
					</c:url>

					<tr>
						<td>${theClient.firstName}</td>
						<td>${theClient.lastName}</td>
						<td>${theClient.email}</td>
						<td><a href="${editLink}" class="a-edit">Edit</a> | <a
							href="${removeLink}" class="a-remove"
							onclick="if (!(confirm('Are you sure you want to remove this Client?'))) return false">Remove</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			</br> <input type="button" value="Add Client"
				onclick="window.location.href='showAddForm'; return false;"
				class="add-button bigbutton">
		</div>
	</div>

</body>


</html>