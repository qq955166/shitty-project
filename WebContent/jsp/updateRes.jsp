<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/header.css" var="headerCSS" />
<link href="${headerCSS}" rel="stylesheet" />
<spring:url value="/resources/css/updateRes.css" var="updateResCSS" />
<link href="${updateResCSS}" rel="stylesheet" />
<title>Update Restaurant</title>
</head>
<body>

	<div class="header">
		<div class="header-cont" >
			<p>Hi ${loggedInUser},</p>
			<a href="/DailyLunchGenerator">Logout</a>
		</div>
	</div>

	<div class="updateRes">
		<p>${error}</p>
		<p>Please complete the following fields:</p>
		<br/>
		<div class="res">
			<fm:form action="save" method="post" modelAttribute="resBean">
				<p class="text">Restaurant Name:</p>
				<fm:input type="text" path="resname" placeholder="${resname}" />
				<fm:errors path="resname" cssClass="error" />
				<br />
				<p class="text">Restaurant Address:</p>
				<fm:input type="text" path="address" placeholder="${address}" />
				<br />
				<p class="text">Description:</p>
				<fm:input type="text" path="description"
					placeholder="${description}" />
				<br />
				<p class="text">Food Type:</p>
				<fm:radiobutton path="food_type" value="normal" checked="yes" />
				<p class="checkbox">Normal</p>
				<fm:radiobutton path="food_type" value="fast" />
				<p class="checkbox">Fast</p>
				<p></p>
				<div class="updateDiv">
					<input type="submit" name="updateRes" value="Update"> 
					<input type="submit" name="cancel" value="Cancel">
				</div>
				<br />
			</fm:form>
		</div>
	</div>
</body>
</html>