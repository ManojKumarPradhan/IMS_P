<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save" method="post" modelAttribute="agent"
		enctype="multipart/form-data">
ID : <form:input path="id" />
Name : <form:input path="name" />
Age : <form:input path="age" />
Photo : <input type="file" name="photo">
		<input type="submit" value="Register">
	</form:form>
</body>
</html>