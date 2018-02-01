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

	<br/>
	<h4>Lista wszystkich jednostek:</h4><br/>
	${message}

		<div class="panel panel-primary">
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>nazwa</th>
						<th>budżet szkoleniowy</th>
						<th>budżet szkoleniowy rozdysponowane</th>
						<th>budżet szkoleniowy pozostałe</th>
						<th>typ jednostki</th>
						<th>jednostka nadrzędna</th>
						<th>imię kierownika</th>
						<th>nazwisko kierownika</th>
						<th>akcja</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${units}" var="unit">
						<tr>
							<th>${unit.id}</th>
							<td>${unit.name}</td>
							<td>${unit.trainingBudget}</td>
							<td>${unit.tBDistributed}</td>
							<td>${unit.tBLeft}</td>
							<td>${unit.unitType}</td>
							<td>${unit.parentUnit.name}</td>
							<td>${unit.manager.name}</td>
							<td>${unit.manager.lastName}</td>
							<td>
								<a href='<c:url value = '/unit/delete/${unit.id}'/>'>usuń</a> / 
								<a href='<c:url value = '/unit/update/${unit.id}'/>'>edytuj</a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

</body>

<%@	include file="../footer.jsp"%>

</html>