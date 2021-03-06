<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@	include file="../header.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">

	<link rel="stylesheet" href="../css/style.css" />

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<title>HR management</title>

</head>

<body>

	<h3>Wpisz dane jednostki</h3>
<form:form modelAttribute="unit" method="post">
		<form:hidden path="id" />
		
		<div class="form-group">
			<label>nazwa:</label><br/>
			<form:errors path="name"/>
			<form:input path="name" value="${unit.name}"/>
		</div>	
		
		<div class="form-group">
			<label>typ jednostki:</label><br/>
			<form:select path="unitType">
            	<form:options items="${uniteTypes}"></form:options>
			</form:select>
		</div>
				
		
		<div class="form-group">
			<label>jednostka nadrzędna:</label><br/>
			<form:select path="parentUnit.id">
            	<form:options items="${parentUnits}" itemValue="id" itemLabel="name"></form:options>
			</form:select>
		</div>
		
		<div class="form-group">
			<label>kierownik:</label><br/>
			<form:select path="manager.id">
            	<form:options items="${managers}" itemValue="id" itemLabel="name"></form:options>
			</form:select>
		</div>
	
		
		<br/><form:button type="submit">zapisz</form:button>
	</form:form>
	

</body>

<%@	include file="../footer.jsp"%>

</html>