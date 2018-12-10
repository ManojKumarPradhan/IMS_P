<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Data Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	
		<div class="card">

			<!-- card heading starts -->
			<div class="card-header bg-info text-white">
				<h2>Employee Data Page</h2>
			</div>

			<!-- card body start -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty employees}">
						<table class="table table-hover table-bordered" width="90%">
							<tr class="success">
								<th>ID</th>
								<th>Name</th>
								<th>Email Id</th>
								<th>Mobile</th>
								<th>Roles</th>
								<th>Address 1</th>
								<th>Address 2</th>
								<th>Address 3</th>
								<th>Id TYPE</th>
								<th>Id Number</th>
								<th>Download</th>
								<th colspan="2">OPERATIONS</th>
							</tr>
							<c:forEach items="${employees}" var="employee">
								<tr>
									<td><c:out value="${employee.id}" /></td>
									<td><c:out value="${employee.name}" /></td>
									<td><c:out value="${employee.emailId}" /></td>
									<td><c:out value="${employee.mobile}" /></td>
									<td><c:out value="${employee.roles}" /></td>
									<td><c:out value="${employee.address1}" /></td>
									<td><c:out value="${employee.address2}" /></td>
									<td><c:out value="${employee.address3}" /></td>
									<td><c:out value="${employee.idType}" /></td>
									<td><c:out value="${employee.idNum}" /></td>
									<td><a href="delete?id=${employee.id}"
										class="btn btn-info">${employee.docName}</a></td>
									<td><a href="delete?id=${employee.id}"
										class="btn btn-danger">Delete</a></td>
									<td><a href="edit?id=${employee.id}"
										class="btn btn-primary">Edit</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<!-- card body end -->
			</div>


			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>


			<!-- card end -->
		</div>
		
</body>
</html>



