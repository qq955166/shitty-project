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
		<a class="header-cont" href="/DailyLunchGenerator">Logout</a>
	</div>
	<div class="addRes">
		<p>Hi ${loggedInUser},</p>
		<p>Please finish the following fields.</p>
		<div class="res">
			<fm:form action="" method="post" modelAttribute="resBean">
				<p>Restaurant Name:</p>
				<fm:input type="text" path="resname" required="required"/>
				<p>Restaurant Address:</p>
				<fm:input type="text" path="address" required="required"/>
				<p>Description:</p>
				<fm:input type="text" path="description" required="required"/>
				<div class="resDiv">
					<input type="submit" name="addRes" value="Add" />
				</div>
				<p>${result}</p>
			</fm:form>
		</div>
	</div>
</body>
</html>