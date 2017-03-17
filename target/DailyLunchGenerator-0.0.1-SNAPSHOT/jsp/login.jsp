<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/tomcat.png" var="icon" />
<link href="${icon}" rel="shortcut icon" type="image/x-icon"/>
<title>Daily Lunch Generator</title>
</head>
<body>
	<div class="login">
		<p class="message">${message}</p>
		<fm:form method="post" action="submit"
			modelAttribute="userBean">

			<fm:label path="username">Enter your username</fm:label>
			<fm:input id="username" name="username" path="" required="required" />
			<br>
			<fm:label path="password">Enter your password</fm:label>
			<fm:password id="password" name="password" path=""
				required="required" />
			<br>
			<div class="submitDiv">
				<input type="submit" name="login" value="Login" /> <input
					type="submit" name="createuser" value="Create User" />
			</div>
		</fm:form>
	</div>

	<div class="generateDiv">
		<fm:form class="generate" method="post" action="generate">
			<input type="submit" name="generate" value="Generate" />
		</fm:form>
		
		<fm:form class="checkIn" method="post" action="${res.id}/checkIn">
			<c:if test="${not empty res}">
				<p>${msg.resname} ${res.resname}</p>
				<p>${msg.address} ${res.address}</p>
				<p>${msg.lastvisitedday} ${res.lastvisitedday}</p>
				<p>${error}</p>
				<input type="submit" name="check" value="Check In" />
			</c:if>
			<p>${checkIn}</p>
		</fm:form>
	</div>
	
</body>
</html>