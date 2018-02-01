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

<link rel="stylesheet" href="css/style.css" />

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

	<h3>Wpisz dane pracownika</h3>
	<form:form modelAttribute="employee" method="post">
		<form:hidden path="id" />

		<div class="form-group">
			<label>imię:</label><br />
			<form:errors path="name" />
			<form:input path="name" value="${employee.name}" />
		</div>


		<div class="form-group">
			<label>nazwisko:</label><br />
			<form:errors path="lastName" />
			<form:input path="lastName" value="${employee.lastName}" />
		</div>


		<div class="form-group">
			<label>type:</label><br />
			<form:select path="type">
				<form:options items="${emplTypes}"></form:options>
			</form:select>
		</div>

		<div class="form-group">
			<label>jednostka:</label><br />
			<form:select path="unit.id">
				<form:options items="${allUnits}" itemValue="id" itemLabel="name"></form:options>
			</form:select>
		</div>


		<br />
		<form:button type="submit">zapisz</form:button>
	</form:form>


</body>

<%@	include file="../footer.jsp"%>

</html>