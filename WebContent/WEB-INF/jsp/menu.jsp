<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
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
		<div class="ui three column grid container">
			<div class="row d-flex flex-row-reverse">

				<a href='<c:url value="/addMenu"></c:url>'>
					<button class="ui button  primary ">add</button>
				</a>

			</div>
			<!-- 
			<div class="ui two column grid">
				<div class="ui segment row">
					<img class="column" src="resources/img/Coca.jpg" style="margin-bottom: 15px"
										alt="room" height="0%" width="100%">
					<div class="column">
						<div class="row menu-info">Id:1</div>
						<div class="row menu-info">Name:2</div>
						<div class="row menu-info">Type:3</div>
						<div class="row menu-info">Price:4</div>
					</div>
					<button class="ui button primary sixteen wide column">sua</button>
				</div>

			</div>
			 -->

			<c:if test="${not empty listmenu}">
				<c:forEach var="menu" items="${listmenu}">
					<div class="column">
						<div class="ui segment">
							<div class="ui two column grid">
								<div class="ui segment row">
									<img class="column"
										src=<c:url value="/resources/img/${menu.getImgname()}"></c:url>
										style="margin-bottom: 15px" alt="room" height="65%"
										width="100%">
									<div class="column">
										<div class="row menu-info">ID: ${menu.getIdmenu()}</div>
										<div class="row menu-info">Name:${menu.getName()}</div>
										<div class="row menu-info">Type:${menu.getType()}</div>
										<div class="row menu-info">Price:${menu.getPrice()}</div>

									</div>
									<div class=" row" style="margin-left: 65px; width: 100%">
										<a href='<c:url value="/changeMenu/${menu.getIdmenu()}"></c:url>'> 
											<button class="ui button primary eight column  "
											style="margin-left: 20px">update</button>
										</a>
										
										<a
											href='<c:url value="/deleteMenu/${menu.getIdmenu()}"></c:url>'>
											<button class="ui button red eight column "
												style="margin-left: 20px">remove</button>
										</a>


									</div>
								</div>

							</div>

						</div>
					</div>


				</c:forEach>

			</c:if>





		</div>
	</main>
</body>
</html>