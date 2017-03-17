<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/addRes.css" var="addResCss" />
<link href="${addResCss}" rel="stylesheet" />
<title>Add Restaurant</title>
</head>
<body>
	<div class="header">
		<div class="header-cont" >
			<p>Hi ${loggedInUser},</p>
			<a href="/DailyLunchGenerator">Logout</a>
		</div>
	</div>
	<div class="addRes">
		<p>Please complete the following fields:</p>
		<br/>
		<div class="res">
			<fm:form action="action" method="post" modelAttribute="resBean">
				<p>Restaurant Name:</p>
				<fm:input type="text" path="resname" required="required"/><br/>
				<p>Restaurant Address:</p>
				<fm:input type="text" path="address"/><br/>
				<p>Description:</p>
				<fm:input type="text" path="description"/><br/>
				<p>Food Type:</p>
				<fm:radiobutton path="food_type" value="normal" checked="yes"/><p class="checkbox">Normal</p>
				<fm:radiobutton path="food_type" value="fast"/><p class="checkbox">Fast</p>
				<div class="resDiv">
					<input type="submit" name="addRes" value="Add" />
					<input type="submit" name="cancel" value="Cancel" />
				</div>
				<br/>
				<p id="result">${result}</p>
			</fm:form>
		</div>
	</div>
</body>
</html>