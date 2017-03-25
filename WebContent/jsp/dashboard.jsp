<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<spring:url value="/resources/javascript/dashboard.js" var="dashboardJS" />
<script src="${dashboardJS}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/header.css" var="headerCSS" />
<link href="${headerCSS}" rel="stylesheet" />
<spring:url value="/resources/css/listOfContent.css" var="listOfContentCSS" />
<link href="${listOfContentCSS}" rel="stylesheet" />
<title>Admin Dashboard</title>
</head>
<body>

	<div class="header">
		<div class="header-cont" >
			<p>Hi ${loggedInUser},</p>
			<a href="/DailyLunchGenerator">Logout</a>
		</div>
	</div>
	
	<input type="hidden" id="result" value="${result}">
	
	<div id="rtnmsg" class="rtnmsg">
		<div class="rtnmsg-cont">
			<span class="close">&times;</span>
			<p>${result}</p>
		</div>
	</div>
	
	<div class="functionDiv">
		<div class="addRes">
			<form action="addRes" method="get">
				<input type="hidden" name="loggedInUser" value="${loggedInUser}">
				<input type="submit" name="addRes" value="Add Restaurant">
			</form>
		</div>
	</div>
	
	<div class="list">
		<br/>		
		<br/>
		
		<c:if test="${not empty lists}">
			<table>
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
						<td class="actions">
							<form class="action" action="${listvalue.id}/delete" method="post">
								<input type="submit" name="delete" value="Delete">
							</form>
							<form class="action" action="${listvalue.id}/update" method="post">
								<input type="submit" name="update" value="Update">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

</body>
</html>