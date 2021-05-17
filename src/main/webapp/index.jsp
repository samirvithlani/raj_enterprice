<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.product.ProductBean"%>
<%@page import="java.util.List"%>
<html>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Simple House Template</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400"
	rel="stylesheet" />
<link href="css/templatemo-style.css" rel="stylesheet" />
</head>
<!--

Simple House

https://templatemo.com/tm-539-simple-house

-->
<body>

	<div class="container">
		<!-- Top box -->
		<!-- Logo & Site Name -->
		<div class="placeholder">
			<div class="parallax-window" data-parallax="scroll"
				data-image-src="img/simple-house-01.jpg">
				<div class="tm-header">

					<div class="row tm-header-inner">
						<div class="col-md-6 col-12">
							<img src="img/simple-house-logo.png" alt="Logo"
								class="tm-site-logo" />
							<div class="tm-site-text-box">
								<h1 class="tm-site-title">Raj Mobile</h1>
								<h6 class="tm-site-description">VERAVAL</h6>
							</div>
						</div>
						<nav class="col-md-6 col-12 tm-nav">
							<ul class="tm-nav-ul">
								<li class="tm-nav-li"><a href="/index.jsp"
									class="tm-nav-link active">Home</a></li>
								<li class="tm-nav-li"><a href="about.html"
									class="tm-nav-link">About</a></li>
								<li class="tm-nav-li"><a href="./admin/adminLogin.jsp"
									class="tm-nav-link">ADMIN LOGIN</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>

		<main>
			<header class="row tm-welcome-section">
				<h2 class="col-12 text-center tm-section-title">Welcome to RAJ
					MOBILE</h2>
				<p class="col-12 text-center">Total 3 HTML pages are included in
					this template. Header image has a parallax effect. You can feel
					free to download, edit and use this TemplateMo layout for your
					commercial or non-commercial websites.</p>
			</header>

			<div class="tm-paging-links">
				<nav>
					<ul>
						<li class="tm-paging-item"><a href="#"
							class="tm-paging-link active">OLD PHONE</a></li>
						<li class="tm-paging-item"><a href="#" class="tm-paging-link">NEW
								PHONE</a></li>
					</ul>
				</nav>
			</div>

			<%
			List<ProductBean> phoneList = (ArrayList<ProductBean>) request.getAttribute("phoneList");
			%>
			<!-- Gallery -->
			<div class="row tm-gallery">
				<!-- gallery page 1 -->
				<div class="tm-gallery-page">
					<%
					for (int i = 1; i < phoneList.size(); i++) {
						
						ProductBean productBean = phoneList.get(i);
			
					%>
					<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
						<figure>
							<img src="upload/<%=productBean.getpImageURL() %>" alt="Image"
								class="img-fluid tm-gallery-img" />
							<figcaption>
								<h4 class="tm-gallery-title"><%=productBean.getpName()%></h4>
								<p class="tm-gallery-description"><%=productBean.getpDetail()%></p>
								<p class="tm-gallery-price"><%=productBean.getpPrice()%></p>
								
							</figcaption>
						</figure>
					</article>
					<%
					}
					%>


				</div>
				<!-- gallery page 1 -->

			</div>
		</main>

		<footer class="tm-footer text-center">
			<p>Copyright &copy; 2021 RAJ MOBILE
		</footer>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/parallax.min.js"></script>
	<script>
		$(document).ready(function() {
			// Handle click on paging links
			$('.tm-paging-link').click(function(e) {
				e.preventDefault();

				var page = $(this).text().toLowerCase();
				$('.tm-gallery-page').addClass('hidden');
				$('#tm-gallery-page-' + page).removeClass('hidden');
				$('.tm-paging-link').removeClass('active');
				$(this).addClass("active");
			});
		});
	</script>
</body>
</html>