<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/user.css" var="userCss" />
<link href="${userCss}" rel="stylesheet" />
<title>Welcome ${loggedInUser}</title>
</head>
<body>

	<div class="header">
		<div class="header-cont" >
			<p>Hi ${loggedInUser},</p>
			<a href="/DailyLunchGenerator">Logout</a>
		</div>
	</div>
	<div class="user">
		<div class="addResDiv">
			<form id="form" action="addRes" method="get">
				<input type="hidden" name="loggedInUser" value="${loggedInUser}">
				<input type="submit" name="addRes" value="Add Restaurant">
			</form>
		</div>
	</div>
	
	<div class="list">
		<c:if test="${not empty lists}">
			<table id="table">
				<tr>
			    	<th>Restaurant</th>
			    	<th>Address</th>
			    	<th>Description</th>
			    	<th>Food Type</th>
			    	<th>Last Visited Day</th>
			    	<th>Action</th>
			  	</tr>
				<c:forEach var="listvalue" items="${lists}">
					<tr>
						<td>${listvalue.resname}</td>
						<td>${listvalue.address}</td>
						<td>${listvalue.description}</td>
						<td>${listvalue.food_type}</td>
						<td><c:out value="${listvalue.lastvisitedday}" default="Never" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>