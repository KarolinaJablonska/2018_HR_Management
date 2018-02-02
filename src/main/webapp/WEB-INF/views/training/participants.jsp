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

	<br/>
	<h4>Lista pracowników zapisanych na dane szkolenie:</h4><br/>
	<p>id: ${training.id}</p>
	<p>nazwa: ${training.name}</p>
	<p>typ: ${training.type}</p>
	<p>ilość zapisanych osób: ${training.employees.size()}</p>
	${message}

		<div class="panel panel-primary">
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>imię</th>
						<th>nazwisko</th>
						<th>typ stanowiska</th>
						<th>jednostka</th>
						<th>akcja</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<th>${employee.id}</th>
							<td>${employee.name}</td>
							<td>${employee.lastName}</td>
							<td>${employee.type}</td>
							<td>${employee.unit.name}</td>
							<td>
								<a href='<c:url value = '/training/participants/delete/${employee.id}/${training.id}'/>'>usuń</a>		
							</td>				
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	

</body>

<%@	include file="../footer.jsp"%>

</html>