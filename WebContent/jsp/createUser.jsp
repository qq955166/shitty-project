<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/javascript/createUser.js" var="createUserJS" />
<script src="${createUserJS}"></script>
<spring:url value="/resources/css/createUser.css" var="createUserCSS" />
<link href="${createUserCSS}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>

	<fm:form class="createform" method="post" action="createUser/submit" modelAttribute="userBean">
		<fm:label path="username">Enter your username</fm:label>
		<fm:input id="username" name="username" path="username" /><br>
		<fm:errors path="username" cssClass="error"/>
		<fm:label path="password">Enter your password</fm:label>
		<fm:password id="password" name="password" path="password" /><br>
		<fm:errors path="password" cssClass="error"/>
		<label for="cpassword">Confirm your password</label>
		<input type="password" id="cpassword" onkeyup="checkPass()" />
		<div class="submitDiv">
			<input type="submit" name="login" value="CreateUser" />
			<a href="/DailyLunchGenerator">Cancel</a>
		</div>
	</fm:form>

</body>
</html>