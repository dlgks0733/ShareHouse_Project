<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>ShareHouse</title>

<!-- css include -->
<link rel="stylesheet" type="text/css" href="css/materialize.css">
<link rel="stylesheet" type="text/css" href="css/icofont.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css"
	href="css/owl.theme.default.min.css">

<!-- my css include -->
<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>
<body>
	<!-- ==================== header-section Start ==================== -->
	<header id="header-section" class="header-section w100dt navbar-fixed">

		<nav class="nav-extended main-nav">
			<div class="container">


				<div class="row">

					<div class="nav-wrapper w100dt">

						<div class="logo left">
							<a href="index.html" class="brand-logo"> <img
								src="img/logo.png" alt="brand-logo">
							</a>
						</div>
						<!-- logo -->
						<!-- <div class="row" align="right">
							<a href="index.html"><span style="color: #92B3B7">로그인</span></a>
						</div>-->
						<div>

							<a href="#" data-activates="mobile-demo" class="button-collapse">
								<i class="icofont icofont-navigation-menu"></i>
							</a>

							<ul id="nav-mobile"
								class="main-menu center-align hide-on-med-and-down">
								<!-- <li class="dropdown" class="active"><a href="index.html">HOME</a>
								
								</li> -->
								<li class="dropdown active"><a href="index.html">HOME<i
										class="icofont icofont-simple-down"></i></a>
									<ul class="dropdown-container">
										<li><a href="login.do?command=LoginFormAction">로그인</a></li>
										<li><a href="member?command=joinFormAction">회원가입</a></li>
									</ul> <!-- /.dropdown-container --></li>
								
								<li class="dropdown"><a href="404.html">창업동아리<i
										class="icofont icofont-simple-down"></i></a>
									<ul class="dropdown-container">
										<li><a href="404.html">동아리 소개</a></li>
										<li><a href="stu?command=stuNoticeList">공지사항</a></li>
										<li><a href="stu?command=stuBoardList">게시판</a></li>
										<li><a href="404.html">갤러리</a></li>
									</ul> <!-- /.dropdown-container --></li>
								<li class="dropdown"><a href="404.html">SNS동아리<i
										class="icofont icofont-simple-down"></i></a>
									<ul class="dropdown-container">
										<li><a href="404.html">동아리 소개</a></li>
										<li><a href="404.html">공지사항</a></li>
										<li><a href="404.html">게시판</a></li>
										<li><a href="404.html">갤러리</a></li>
									</ul> <!-- /.dropdown-container --></li>

								<li class="dropdown"><a href="404.html">축구동아리<i
										class="icofont icofont-simple-down"></i></a>
									<ul class="dropdown-container">
										<li><a href="404.html">동아리 소개</a></li>
										<li><a href="404.html">공지사항</a></li>
										<li><a href="404.html">게시판</a></li>
										<li><a href="404.html">갤러리</a></li>
									</ul> <!-- /.dropdown-container --></li>
								<li class="dropdown"><a href="mlb?command=introFormAction">농구동아리<i
										class="icofont icofont-simple-down"></i></a>
									<ul class="dropdown-container">
										<li><a href="404.html">동아리 소개</a></li>
										<li><a href="404.html">공지사항</a></li>
										<li><a href="mlb?command=mlbBoardListFormAciton">게시판</a></li>
										<li><a href="404.html">갤러리</a></li>
									</ul> <!-- /.dropdown-container --></li>
								<!-- <li class="dropdown"><a href="404.html">로그인</a> -->
							</ul>


							<!-- /.main-menu -->

							<!-- ******************** sidebar-menu ******************** -->
							<ul class="side-nav" id="mobile-demo">
								<li class="snavlogo center-align"><img src="img/logo.png"
									alt="logo"></li>
								<!-- <li class="active"><a href="index.html">HOME</a></li> -->
								<li class="dropdown active"><a href="index.html">HOME<i
										class="icofont icofont-simple-down"></i></a>
									<ul class="dropdown-container">
										<li><a href="404.html">로그인</a></li>
										<li><a href="404.html">회원가입</a></li>
									</ul> <!-- /.dropdown-container --></li>
								<li><a href="cateogry.html">창업동아리</a></li>
								<li><a href="single-blog.html">SNS 동아리</a></li>
								<li><a href="contact.html">축구동아리</a></li>
								<li><a href="404.html">농구동아리</a></li>
							</ul>

						</div>

						<!-- main-menu -->

						<a href="#" class="search-trigger right"> <i
							class="icofont icofont-search"></i>
						</a>

						<!-- search -->
						<div id="myNav" class="overlay">
							<a href="javascript:void(0)" class="closebtn">&times;</a>
							<div class="overlay-content">
								<form>
									<input type="text" name="search" placeholder="Search...">
									<br>
									<button class="waves-effect waves-light" type="submit"
										name="action">Search</button>
								</form>
							</div>
						</div>

					</div>
					<!-- /.nav-wrapper -->
				</div>
				<!-- row -->
			</div>
			<!-- container -->
		</nav>

	</header>
	<!-- /#header-section -->
	<!-- ==================== header-section End ==================== -->
</body>
</html>