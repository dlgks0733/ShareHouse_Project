<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>Share House :: 농구동아리 게시판</title>

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
	<section id="breadcrumb-section"
		class="breadcrumb-section w100dt mb-30">
		<div class="container">

			<nav class="breadcrumb-nav w100dt">
				<div class="page-name hide-on-small-only left">
					<h4>농구동아리 갤러리</h4>
				</div>
				<div class="nav-wrapper right">
					<a href="index.html" class="breadcrumb">Home</a> <a
						href="mlb?command=mlbBoardListFormAciton"
						class="breadcrumb active">농구동아리 갤러리</a>
				</div>
				<!-- /.nav-wrapper -->
			</nav>
			<!-- /.breadcrumb-nav -->

		</div>
		<!-- container -->
	</section>
	<!-- /.breadcrumb-section -->
	<!-- ==================== header-section End ==================== -->

	<!-- ==================== board-section start ==================== -->
	<!-- <section id="error-section" class="error-section w100dt mb-50"> -->
	<section id="single-blog-section"
		class="single-blog-section w100dt mb-50">
		<div class="container">
			<c:forEach items="${galList }" var="galVo" varStatus="galStat">
				<div class="col m6 s12">
					<div class="blogs mb-30">
						<div class="card">
							<div class="card-image">
								<img class='max-small' alt=""
									src="displayFile?fileName=${galVo.fileName}">

								<!--<a class="btn-floating center-align cmn-bgcolor halfway-fab waves-effect waves-light">
												<i class="icofont icofont-camera-alt"></i>
											</a> -->
							</div>
							<!-- /.card-image -->

							<div class="card-content w100dt">
								<p>
									<a href="#" class="tag left w100dt l-blue mb-30">농구동아리</a>
								</p>
								<a
									href="mlb?command=mlbGalBoardViewFormAction&galNum=${galVo.galNum}"
									class="card-title"> ${galVo.galTitle} </a>
								<p class="mb-30">${galVo.galContents}</p>
								<ul class="post-mate-time left">
									<li>
										<p class="hero left">
											By - <a href="#" class="l-blue">${galVo.adminId}</a>
										</p>
									</li>
									<li><i class="icofont icofont-ui-calendar"></i>
										${galVo.galDate}</li>
								</ul>

								<!--	<ul class="post-mate right">
												<li class="like">
													<a href="#">
														<i class="icofont icofont-heart-alt"></i> 55
													</a>
												</li>
												<li class="comment">
													<a href="#">
														<i class="icofont icofont-comment"></i> 32
													</a>
												</li>
											</ul> -->
							</div>
							<!-- /.card-content -->
						</div>
						<!-- /.card -->
					</div>
					<!-- /.blogs -->

				</div>
			</c:forEach>

			<%-- 			<c:forEach items="${galList }" var="galVo" varStatus="galStat">
				<div class="col m6 s12">
					<div class="blogs mb-30">
						<div class="card">
							<div class="card-image">
								<img class='max-small' alt=""
									src="/displayFile?fileName=${galVo.fileName}">
							</div>
						</div>
					</div>
				</div>
			</c:forEach> --%>



			<div class="col m12 s12">
				<button type="button" class="custom-btn waves-effect waves-light right"
				 onclick="location.href='mlb?command=mlbGalBoardInsertFormAction'">등록</button>
			</div>

		<ul class="pagination w100dt">
							<li class="waves-effect"><a href="#!"><i class="icofont icofont-simple-left"></i></a></li>
							<li class="active"><a href="#!">1</a></li>
							<li class="waves-effect"><a href="#!">2</a></li>
							<li class="waves-effect"><a href="#!">3</a></li>
							<li class="waves-effect"><a href="#!">4</a></li>
							<li class="waves-effect"><a href="#!">5</a></li>
							<li class="waves-effect"><a href="#!"><i class="icofont icofont-simple-right"></i></a></li>
						</ul>


		</div>
		<!-- container -->
	</section>


	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script>

	<!-- my custom js -->
	<script type="text/javascript" src="js/custom.js"></script>

	<script type="text/javascript">
		
	</script>
	<%@include file="../include/footer.jsp"%>
</body>
</html>