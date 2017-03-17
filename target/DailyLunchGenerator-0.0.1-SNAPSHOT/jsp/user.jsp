<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome ${loggedInUser}</title>
</head>
<body>
	<p>Hi ${loggedInUser},</p>
	<a href="/DailyLunchGenerator">Logout</a>
	<form id="form" action="addRes" method="get">
		<input type="hidden" name="loggedInUser" value="${loggedInUser}">
		<input type="submit" name="addRes" value="Add Restaurant">
	</form>
</body>
</html>