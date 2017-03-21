<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>

	<fm:form id="userform" method="post" action="submit" modelAttribute="userBean">
		<fm:label path="username">Please enter your username</fm:label>
		<fm:input id="username" name="username" path="username" /><br>
		<fm:errors path="username" cssClass="error"/>
		<fm:label path="password">Please enter your password</fm:label>
		<fm:password id="password" name="password" path="password" /><br>
		<fm:errors path="password" cssClass="error"/>
		<fm:label path="cpassword">Please confirm your password</fm:label>
		<fm:password id="cpassword" name="cpassword" path="cpassword" /><br>
		<fm:errors path="cpassword" cssClass="error"/>
	</fm:form>

</body>
</html>