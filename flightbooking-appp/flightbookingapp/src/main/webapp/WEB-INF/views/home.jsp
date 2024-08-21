<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<title><c:out value="${page}"></c:out></title>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center">Welcome to Flight Booking App</h1>


			<c:if test="${not empty msg}">
				<div class="alert alert-success">
				<c:out value="${msg}"></c:out>
				</div>
			</c:if>
		<div class="row mt-5">
			<div class="col md-2">
				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active"
						aria-current="true">Menu</button>
					<a href='<c:url value='/add'></c:url>' type="button"
						class="list-group-item list-group-item-action">Add Booking</a>
					<a href='<c:url value='/viewBooking'></c:url>' type="button"
						class="list-group-item list-group-item-action">View Booking</a>
				</div>
			</div>
			<div class="col md-10">
				<c:if test="${page=='home' }">
					<h1 class="text-center">Welcome to Flight Booking Page</h1>
				</c:if>
				<c:if test="${page=='add' }">
					<h1 class="text-center">New Booking</h1>
				<br>
				<form:form action="${pageContext.request.contextPath}/saveTodo" method="post" modelAttribute="flightBooking">
				 <div class="form-group row">
					<div class="form-group">
						<form:label path="" class="col-form-label">Flight ID:: </form:label>
						<form:input path="customerID" cssClass="formControl"
							placeholder="Enter Flight ID" />
					</div>
					<div class="form-group">
						<form:label path="" class="col-form-label">Flight Name:: </form:label>
						<form:input path="customerName" cssClass="formControl"
							placeholder="Enter Flight name"/>
					</div>
					<div class="container text-center">
						<button type= "submit" class="btn btn-outline-success">Create booking</button>
					</div>
				 </div>
				</form:form>
				</c:if>
				<c:if test="${page=='viewBooking' }">
					<h1 class="text-center">All Booking</h1>
					<table class= "table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Booking ID</th>
							    <th scope="col">Flight ID</th>
							    <th scope="col">Flight Name</th>
							    <th scope="col">Booking Date</th>
							    <th scope="col">Update</th>
							    <th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items = "${allBookings}" var="booking">
							<tr>
								 <td>${booking.bookingID}</td>
					             <td>${booking.flightID}</td>
					             <td>${booking.flightName}</td>
					             <td>${booking.date}</td>
								 <td><a href="updateBooking/${booking.flightID}" class="btn btn-warning">Update</a></td>
								 <td><a href="deleteBookingById/${booking.flightID}" class="btn btn-danger">Delete</a></td>

							</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
</body>
</html>