<%@page import="com.bean.admin.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>ADMIN</title>
</head>

<body>
	<%
	AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
	if (adminBean != null) {
	%>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<span class="navbar-text"> WELCOME &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=adminBean.getaName()%>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="AdminLogoutController">LOGOUT</a>
			</span>
		</div>
	</nav>
	<div class="container">
		<form action="../AddProductController" method="post"
			enctype="multipart/form-data">

			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">ENTRE
					PHONE NAME</span> <input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default" name="txtPhoneName">
			</div>
			<div class="input-group">
				<span class="input-group-text">ENTER PHONE DETAILS</span>
				<textarea class="form-control" aria-label="With textarea"
					name="txtPhoneDetail"></textarea>
			</div>

			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">ENTER
					PHONE PRICE</label> <input type="text" class="form-control"
					name="txtPhonePrice">
			</div>

			<div class="input-group mb-3">
				<input type="file" class="form-control" id="inputGroupFile02"
					name="image">
			</div>


			<div class="form-check">
				<input class="form-check-input" type="radio" name="phoneType"
					id="flexRadioDefault1" value="old"> <label
					class="form-check-label" for="flexRadioDefault1">OLD</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="phoneType"
					id="flexRadioDefault1" value="new"> <label
					class="form-check-label" for="flexRadioDefault1"> NEW</label>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<%
	} else {
	response.sendRedirect("adminLogin.jsp");
	}
	%>
	}
</body>
</html>