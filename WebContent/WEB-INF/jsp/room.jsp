<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>room</title>
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
			<a class="navbar-brand" href="redirect:/">KaraokeSite</a>
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

	<main class="ui grid container">
		<c:if test="${not empty inforoom }">



			<div class="row">
				<div class="sixteen wide column" style="">
					<!-- information about the room -->
					<div class="d-flex  justify-content-around flex-row">
						<div class="p-2">
							<div>NAME:</div>
							<div>${ inforoom.getName()}</div>
						</div>
						<div class="p-2">
							<div>PEOPLE:</div>
							<div>${ inforoom.getPeople()}</div>
						</div>
						<div class="p-2">
							<div>GUEST NUMBER:</div>
							<div>${ inforoom.getGuestnumber()}</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<c:if test="${not empty listorder }">

			<div class="row">
				<div class="sixteen wide column" style="">
					<!-- show table  of list menu order -->
					<table class="ui celled table">
						<thead>
							<tr>
								<th>IDroom</th>
								<th>IDmenu</th>
								<th>number</th>
								<th>time_order</th>
								<th>Price</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" items="${listorder}">
								<tr>
									<td data-label="IDroom">${order.getIdroom()}</td>
									<td data-label="IDmenu">${order.getIdmenu()}</td>
									<td data-label="number">${order.getNumber()}</td>
									<td data-label="time_order">${order.getTime_order()}</td>
									<td data-label="Price">${order.getTotal_price()}</td>
								</tr>


							</c:forEach>
							<tr>

								<td colspan=5>total_price: ${total_Price} VND</td>

							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</c:if>



		<div class="row">

			<a href='<c:url value="orderFood/${IdroomUSE }"></c:url>'>
				<button class="ui button primary">order</button>
			</a>

		</div>
		<div class="row d-flex justify-content-around">
			Current Time:
			<div>
				<p id="demo"></p>
				<button class="ui red button" onclick="myStopFunction()">Stop time</button>
			</div>

		</div>
		<div class="row">
			<div class="eight wide column">
				<a href='<c:url value="/index"></c:url>'>
					<button class="ui red button">back to list room</button>
				</a> <a
					href='<c:url value="/useroom/room/${IdroomUSE }/payRoom"></c:url>'>
					<button class="ui primary button">Pay</button>
				</a>

			</div>

		</div>
	</main>

</body>
<script>
	var myVar = setInterval(myTimer, 1000);

	function myTimer() {
		var d = new Date();
		var t = d.toLocaleTimeString();
		document.getElementById("demo").innerHTML = t;
	}

	function myStopFunction() {
		clearInterval(myVar);
	}
</script>
</html>