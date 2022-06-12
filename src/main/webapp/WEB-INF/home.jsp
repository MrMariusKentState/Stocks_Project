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
	<h1>Track your stocks and account balances with MyTrade!</h1>
	<br>
	<br>	
		<div id = "leftcol">
			<h3 class = "welcome">Create a free account! </h3>
	 		<form:form method="POST" action="/registration/submit" modelAttribute="newuser">
		 
		        <p>
		            <form:label path="firstname">First Name:</form:label>
		            <form:input class = "label" type="text" path="firstname"/>
		            <br>
		            <form:errors class = "text-danger" path = "firstname"/>
		        </p>
		        <p>
		            <form:label path="lastname">Last Name:</form:label>
		            <form:input class = "label" type="text" path="lastname"/>
		            <br>
		            <form:errors class = "text-danger" path = "lastname"/>
		            
		        </p>
		        <p>
		            <form:label path="email">Email:</form:label>
		            <form:input class = "label" type="text" path="email" />
		            <br>
		            <form:errors class = "text-danger" path = "email"/>
		            
		        </p>
		        
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password class = "label" path="password"/>
		            <br>
		            <form:errors class = "text-danger" path = "password"/>
		            
		        </p>
		        <p>
		            <form:label path="confirmpassword">Confirm Password:</form:label>
		            <form:password class = "label" path="confirmpassword"/>
		            <br>
		            <form:errors class = "text-danger" path = "confirmpassword"/>
		            
		        </p>
		        
		        <input type="submit" class="btn btn-primary" value="Register!"/>
	   		</form:form>
		</div>
		<div id = "rightcol">
			<h3 class = "welcome">Login to track your stock portfolio!</h3>
    		<form:form method="POST" action="/login" modelAttribute="newuser">
    			<p id = "loginconfirm"><c:out value = "${error}"/></p>
     				<p>
			            <form:label path="email">Email:</form:label>
			            <form:input class = "label2" type="text" path="email"/>
	        		</p>
	    			<p>
			            <form:label path="password">Password:</form:label>
			            <form:password class = "label2" path="password"/>
	        		</p>

        		<input type="submit" class="btn btn-primary" value="Login"/>
     		</form:form>
		</div>
		
		
	</div>

</body>

</html>
