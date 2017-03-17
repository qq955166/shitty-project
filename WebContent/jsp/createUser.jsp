<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>

	<fm:form id="userform">
		<fm:label path="username">Please enter your username</fm:label>
		<form:input id="username" name="username" path="" /><br>
		<form:label path="password">Please enter your password</form:label>
		<form:password id="password" name="password" path="" /><br>
		<form:label path="password">Please enter your password</form:label>
		<form:password id="password" name="password" path="" /><br>
	</fm:form>

</body>
</html>