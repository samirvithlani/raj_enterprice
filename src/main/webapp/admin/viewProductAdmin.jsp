<%@page import="com.bean.admin.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.product.ProductBean"%>
<%@page import="java.util.List"%>
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

<meta charset="ISO-8859-1">
<title>ADMIN-VIEW-PHONES</title>
<style>
.container {
	padding: 2rem 0rem;
}

h4 {
	margin: 2rem 0rem 1rem;
}

.table-image {td , th { vertical-align:middle;
	
}
}
</style>

</head>
<body>
	<h1>
		<a href="./index.jsp">HOME</a>
	</h1>
	<h1>ALL PHONES ADDED BY ADMIN</h1>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-image">
					<thead>
						<tr>
							<th scope="col">PHONE NAME</th>
							<th scope="col">PHONE PRICE</th>
							<th scope="col">DATE</th>
							<th scope="col">PHONE TYPE</th>
							<th scope="col">Image</th>
							<th scope="col">ACTION</th>
						</tr>
					</thead>
					<%
					List<ProductBean> phoneList = (ArrayList<ProductBean>) request.getAttribute("phoneList");
					if (phoneList != null) {
					%>
					<tbody>
						<%
						for (int i = 1; i < phoneList.size(); i++) {

							ProductBean productBean = phoneList.get(i);
						%>

						<tr>

							<td><%=productBean.getpName()%></td>
							<td><%=productBean.getpPrice()%></td>
							<td><%=productBean.getCreationDate()%></td>
							<td><%=productBean.getpType()%></td>
							<td class="w-25"><img
								src="upload/<%=productBean.getpImageURL()%>"
								class="img-fluid img-thumbnail" alt=""></td>
							<td><a
								href="./DeleteProductControllerAdmin?id=<%=productBean.getpId()%>">SOLD</a></td>

						</tr>
						<%
						}
						} else {

						response.sendRedirect("../AdminViewProduct");
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>