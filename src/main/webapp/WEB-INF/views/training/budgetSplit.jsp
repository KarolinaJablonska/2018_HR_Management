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
	<h4>Wpisz podział budżetu:</h4><br/>
	${message}

		<div class="panel panel-primary">
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>zarząd</th>
						<th>jednostka</th>
						<th>wydział</th>
						<th>dział</th>
						<th>budżet</th>
						<th>rozdysponowany</th>
						<th>pozostało</th>
					</tr>
				</thead>
				<tbody>
					<tr> 
						<td>${board.name}</td>
						<td></td>
						<td></td>
						<td></td>
						<td>${board.trainingBudget}</td>
						<td>${board.tBDistributed}</td>
						<td>${board.tBLeft}</td>
					</tr>
					<!-- jednostki -->
					<c:forEach items="${units}" var="unit">
						<tr>
							<td></td>
							<td>${unit.name}</td>
							<td></td>
							<td></td>
							<td>${unit.trainingBudget}</td>
							<td>${unit.tBDistributed}</td>
							<td>${unit.tBLeft}</td>
						</tr>
						
						<!-- wydziały -->
						<c:if test="${not empty unit.getChildren()}">
							
							<c:forEach items="${unit.getChildren()}" var="department">
							<tr>
								<td></td>
								<td></td>
								<td>${department.name}</td>
								<td></td>
								<td>${department.trainingBudget}</td>
								<td>${department.tBDistributed}</td>
								<td>${department.tBLeft}</td>
							</tr>
								
								<!-- działy -->
								<c:if test="${not empty department.getChildren()}">
									<c:forEach items="${department.getChildren()}" var="section">
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td>${section.name}</td>
											<td>${section.trainingBudget}</td>
											<td>${section.tBDistributed}</td>
											<td>${section.tBLeft}</td>
										</tr>
									</c:forEach>
								</c:if>	
							</c:forEach>
						</c:if>	
					</c:forEach>
				</tbody>
			</table>
		</div>


</body>

<%@	include file="../footer.jsp"%>

</html>