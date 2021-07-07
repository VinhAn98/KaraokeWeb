<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
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
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
<script src="resources/js/index.js"></script>
</head>
<body>
	<header class="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="index">KaraokeSite</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href='<c:url value="/index"></c:url>'> Room </a></li>
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/menu"></c:url>'> Menu</a></li>
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
			
			<c:if test="${not empty listroom}">
				<c:forEach var="room" items="${listroom}">
					<div class="column">
						<div class="ui segment content-board">
							<div class="ui container">
								<div class="ui large header"> room ${room.getIdroom()}</div>				
								<c:choose>
									<c:when test="${room.getSituation() == false}">
										<div class="ui large header"> Situation:Trống </div>
									</c:when>
									
									<c:otherwise>
										<div class="ui large header"> Situation:Đang Sử Dụng</div>
									</c:otherwise>
								</c:choose>
								
								
								<div>
									<img src="resources/img/room2.png" style="margin-bottom: 15px"
										alt="room" height="250vh" width="100%">
								</div>
							</div>
							<a href='<c:url value="/useroom/${room.getIdroom()}"></c:url>'>
								<button class="ui button primary" >use</button>
							</a>
								
						</div>
					</div>
				</c:forEach>

			</c:if>

			
		</div>
		
			
		
	</main>

</body>
</html>
