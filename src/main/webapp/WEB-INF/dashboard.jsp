<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Stock investor</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/home.css"/>

</head>


<body>
	<div id = "container">
		<h1>Dashboard page!</h1>
	</div>
	<h3>Welcome, <c:out value = "${user.firstname}" />!</h3>
	<h3>Your current portfolio consists of $$$ dollars.</h3>
	<p>Stock API:  https://polygon.io/dashboard </p>
</body>
</html>