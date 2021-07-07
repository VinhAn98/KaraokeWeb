<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order-view</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/index.css"></c:url>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/menu.css"></c:url>'>
<script src='<c:url value="/resources/js/index.js"></c:url>'></script>

</head>
<body>
	<header class="">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href='<c:url value="/index"></c:url>'>KaraokeSite</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href='<c:url value="/index"></c:url>'> Room <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/menu"></c:url>'>Menu</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Something</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</header>
	<br />
	<main>
		<div class="container">
			order-form
			
				<form:form action="saveOrder/${IdroomUSE}" method="post"
					modelAttribute="orderedFood">
					<div class="form-group">
						<label for="AddIdRoom">IdRoom:</label>
						<form:input type="text" class="form-control" id="AddIdRoom"
							path='Idroom' value ="${IdroomUSE}" />
					</div>
					<div class="form-group">
						<label for="AddType">IdMenu:</label>
						<form:input type="text" class="form-control" id="AddType"
							path='Idmenu' value="${IdmenuUSE }" />
					</div>
					<div class="form-group">
						<label for="AddNumber">Number:</label>
						<form:input type="text" class="form-control" id="AddNumber"
							path='number' />
					</div>
					<div class="form-group">
						<label for="Price">Price:</label>
						<form:input type="text" class="form-control" id="AddPrice"
							path='total_price'  />
					</div>
					<div class="form-group">
						<label for="Time-order:">Time order:</label>
						<form:input type="text" class="form-control" id="AddTime"
							path='time_order'  />
					</div>
					<input type="submit" class="btn btn-primary" value="Add">
				</form:form> 
			
			
		</div>
	</main>
</body>
</html>