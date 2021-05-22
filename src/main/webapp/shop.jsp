
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.product.ProductBean"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<!--
	ustora by freshdesignweb.com
	Twitter: https://twitter.com/freshdesignweb
	URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shop Page- Ustora Demo</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/responsive.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@include file="header.jsp"%>

	<%
	List<ProductBean> phoneList = (ArrayList<ProductBean>) request.getAttribute("phoneList");
	if (phoneList != null) {
	%>

	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<%
				for (int i = 1; i < phoneList.size(); i++) {

					ProductBean productBean = phoneList.get(i);
				%>

				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper">
							<img src="upload/<%=productBean.getpImageURL() %>" alt="">
						</div>
						<h2>
							<a href=""><%=productBean.getpDetail() %></a>
						</h2>
						<div class="product-carousel-price">
							<ins>$899.00</ins>
							<del>$999.00</del>
						</div>

						<div class="product-option-shop">
							<a class="add_to_cart_button" data-quantity="1"
								data-product_sku="" data-product_id="70" rel="nofollow"
								href="/canvas/shop/?add-to-cart=70">Add to cart</a>
						</div>
					</div>
				</div>
				<%
				}
				} else {

				response.sendRedirect("ViewProductController");
				}
				%>

				<div class="row">
					<div class="col-md-12">
						<div class="product-pagination text-center">
							<nav>
								<ul class="pagination">
									<li><a href="#" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>


		<%@include file="footer.jsp"%>
		<!-- Latest jQuery form server -->
		<script src="https://code.jquery.com/jquery.min.js"></script>

		<!-- Bootstrap JS form CDN -->
		<script
			src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

		<!-- jQuery sticky menu -->
		<script src="js/owl.carousel.min.js"></script>
		<script src="js/jquery.sticky.js"></script>

		<!-- jQuery easing -->
		<script src="js/jquery.easing.1.3.min.js"></script>

		<!-- Main Script -->
		<script src="js/main.js"></script>
</body>
</html>