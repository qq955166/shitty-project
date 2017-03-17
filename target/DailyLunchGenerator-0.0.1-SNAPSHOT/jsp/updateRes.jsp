<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />
<title>Update Restaurant</title>
</head>
<body>

	<div class="updateRes">
		<p>${error}</p>
		<fm:form action="save" method="post" modelAttribute="resBean">
			<p><label>Restaurant Name:</label><fm:input class="rightA" type="text" path="resname" placeholder="${resname}"></fm:input></p>
			<p><label>Restaurant Address:</label><fm:input type="text" path="address" placeholder="${address}"></fm:input></p>
			<p><label>Description:</label><fm:input type="text" path="description" placeholder="${description}"></fm:input></p>
			<p><input type="submit" name="updateRes" value="Update"></p>
		</fm:form>
	</div>
</body>
</html>