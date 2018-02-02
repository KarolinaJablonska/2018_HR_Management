
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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


 <header>

 
	<ul class="nav nav-pills">
	
  		<li role="presentation" class="active"><a href="../../../2018_HR_Management/">Strona główna</a></li> 

  		<li class="dropdown, active">
   			 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pracownicy<span class="caret"></span></a>
		   		 <ul class="dropdown-menu">
		     		<li><a href="../../../2018_HR_Management/empl/add">Dodaj nowego pracownika</a></li>
		      		<li><a href="../../../2018_HR_Management/empl/showAll">Pokaż listę wszystkich pracowników</a></li>
		   		</ul>
	 	</li>
	 	
	 	
	 	<li class="dropdown, active">
   			 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Jednostki<span class="caret"></span></a>
		   		 <ul class="dropdown-menu">
		     		<li><a href="../../../2018_HR_Management/unit/add">Dodaj nową jednostkę</a></li>
					<li><a href="../../../2018_HR_Management/unit/showAll">Pokaż listę wszystkich jednostek</a></li>
		   		</ul>
	 	</li>
	 	
	 	
	 	<li class="dropdown, active">
   			 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Szkolenia<span class="caret"></span></a>
		   		 <ul class="dropdown-menu">
		     		<li><a href="../../../2018_HR_Management/training/add">Dodaj nowe szkolenie</a></li>
		      		<li><a href="../../../2018_HR_Management/training/showAll">Pokaż listę wszystkich szkoleń</a></li>
		      		<li><a href="../../../2018_HR_Management/unit/budgetSplit">Podział budżetu szkoleniowego</a></li>
		      		<li><a href="../../../2018_HR_Management/training/table">Szczegółowa tabela szkoleniowa</a></li>
		   		</ul>
	 	</li>
  

  		<li role="presentation" class="active"><a href="#">Raporty</a></li>

	</ul> 
      
</header>

</html>