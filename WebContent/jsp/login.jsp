<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/login.css" var="loginCss" />
<link href="${loginCss}" rel="stylesheet" />
<spring:url value="/resources/tomcat.png" var="icon" />
<link href="${icon}" rel="shortcut icon" type="image/x-icon"/>
<title>Daily Lunch Generator</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
	<div class="login">
		<p class="message">${message}</p>
		<p>Sign In</p>
		<fm:form method="post" action="submit" modelAttribute="userBean">
			<fm:input name="username" path="username" placeholder="Account Name" />
			<fm:errors path="username" cssClass="error"/>
			<br>
			<fm:password name="password" path="password" placeholder="Password"/>
			<fm:errors path="password" cssClass="error"/>
			<br>
			<div class="submitDiv">
				<input type="submit" name="login" value="Login" />
				<input type="submit" name="createuser" value="Create User" />
			</div>
		</fm:form>
	</div>

	<div class="generateDiv">
		<fm:form class="generate" method="post" action="generate">
			<input type="submit" name="generate" value="Generate" /><br/>
			<div class="filter">
				<input type="checkbox" name="fastOnly" value="fast"/><p>Fast Only</p>
			</div>
		</fm:form>
		<br/>
		<fm:form class="checkIn" method="post" action="${res.id}/checkIn">
			<c:if test="${not empty res}">
				<p>${msg.resname} ${res.resname}</p><br/>
				<p>${msg.address} ${res.address}</p><br/>
				<p>${msg.description} ${res.description}</p><br/>
				<p>${msg.lastvisitedday} ${res.lastvisitedday}</p><br/>
				<p>${error}</p><br/>
				<input type="submit" name="check" value="Check In" />
			</c:if>
			<p>${checkIn}</p>
		</fm:form>
	</div>
	
</body>
</html>