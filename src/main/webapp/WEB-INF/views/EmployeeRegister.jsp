<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- container start -->
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2>REGISTER FORM EMPLOYEE</h2>
			</div>
			<div class="panel-body">
				<form:form action="/save" method="POST" modelAttribute="employee"
					enctype="multipart/form-data" class="form-horizontal">
					<div class="form-group">
						<label for="name" class="control-label col-sm-2">Employee
							Name</label>
						<div class="col-sm-4">
							<form:input path="name" class="form-control"
								placeholder="Enter Name" />
						</div>
					</div>
					<div class="form-group">
						<label for="emailId" class="control-label col-sm-2">Employee
							Email</label>
						<div class="col-sm-4">
							<form:input path="emailId" class="form-control"
								placeholder="Enter Email" />
						</div>
					</div>
					<div class="form-group">
						<label for="mobile" class="control-label col-sm-2">Employee
							Mobile</label>
						<div class="col-sm-4">
							<form:input path="mobile" class="form-control"
								placeholder="Enter Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Roles</label>
						<div class="col-sm-4">
							<label class="checkbox-inline"> <form:checkbox
									path="roles" value="Admin" />Admin
							</label> <label class="checkbox-inline"><form:checkbox
									path="roles" value="Employee" />Employee</label>
						</div>
					</div>
					<div class="form-group">
						<label for="address1" class="control-label col-sm-2">Employee
							Address</label>
						<div class="col-sm-4">
							<form:input path="address1" class="form-control"
								placeholder="Enter Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label for="address2" class="control-label col-sm-2">Employee
							Address</label>
						<div class="col-sm-4">
							<form:input path="address2" class="form-control"
								placeholder="Enter Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label for="address3" class="control-label col-sm-2">Employee
							Address</label>
						<div class="col-sm-4">
							<form:input path="address3" class="form-control"
								placeholder="Enter Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label for="idType" class="control-label col-sm-2">Select
							ID Type</label>
						<div class="col-sm-4">
							<form:select path="idType" class="form-control">
								<form:option value="">--Select One--</form:option>
								<form:option value="Aadhar">Aadhar</form:option>
								<form:option value="VoterId">VoterId</form:option>
								<form:option value="DL">DL</form:option>
								<form:option value="Pan Card">Pan Card</form:option>
								<form:option value="Passport">Passport</form:option>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="idNum" class="control-label col-sm-2">Employee
							ID Number</label>
						<div class="col-sm-4">
							<form:input path="idNum" class="form-control"
								placeholder="Enter Email" />
						</div>
					</div>
					<div class="form-group">
						<label for="docName" class="control-label col-sm-2">Employee
							Document</label>
						<div class="col-sm-4">
							<input type="file" class="form-control" required="required" />
						</div>
					</div>
					<div class="form-group" align="center">
						<input type="submit" value="Uom Register"
							class="btn btn-success col-sm-4" width="50%" />
					</div>
				</form:form>
			</div>
			<!-- panel body close -->

			<div class="panel-footer panel-info">
				<c:if test="${message ne null }">
					<div class="card-footer bg-success text-white">${message}</div>
				</c:if>
			</div>
			<!-- panel footer close -->
		</div>
		<!-- panel close -->
	</div>
	<!-- container close -->

</body>
</html>