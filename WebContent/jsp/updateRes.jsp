<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/updateRes.css" var="updateRessCss" />
<link href="${updateRessCss}" rel="stylesheet" />
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
		<fm:form action="save" method="post" modelAttribute="resBean">
			<p><label>Restaurant Name:</label><fm:input type="text" path="resname" placeholder="${resname}"></fm:input></p>
			<p><label>Restaurant Address:</label><fm:input type="text" path="address" placeholder="${address}"></fm:input></p>
			<p><label>Description:</label><fm:input type="text" path="description" placeholder="${description}"></fm:input></p>	
			<label>Food Type:</label>
			<div class="checkbox"><fm:radiobutton path="food_type" value="normal" checked="yes"/>Normal</div>
			<div class="checkbox"><fm:radiobutton path="food_type" value="fast"/>Fast</div>
			<div class="updateDiv">
				<input type="submit" name="updateRes" value="Update">
			</div>
		</fm:form>
	</div>
</body>
</html>