<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/board.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>Share House :: 창업동아리 공지사항</title>

<!-- css include -->
<link rel="stylesheet" type="text/css" href="css/materialize.css">
<link rel="stylesheet" type="text/css" href="css/icofont.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css"
	href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/site.css">

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
					<h4>창업동아리 공지사항</h4>
				</div>
				<div class="nav-wrapper right">
					<a href="index.html" class="breadcrumb">Home</a> <a
						href="mlb?command=mlbBoardListFormAciton"
						class="breadcrumb active">창업동아리 공지사항</a>
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
	<section id="single-blog-section"
		class="single-blog-section w100dt mb-50">
		<form name="frm" method="post" action="stu?command=stuBoardUpdate"
			onsubmit="return validateUpdateBoard()">
			<div class="container">

				<div class="row">
					<div class="col m12 s12">
						<div class="blogs mb-30">
							<div class="card">
								<!-- nlb board table form -->


								<input type="hidden" name="bodNum" value="${bodList.bodNum}">
								<table class="bordered">
									<tr>
										<th>제목</th>
										<td><input type="text" name="bodTitle"
											value="${bodList.bodTitle}"></td>
										<th>작성자</th>
										<td>${bodList.memberName}</td>
										<th>작성일</th>
										<td>${bodList.bodDate}</td>

									</tr>

									<tr>
										<th>내용</th>
										<td colspan="5"><textarea name="bodContents" rows="28"
												cols="93" style="margin: 0px; width: 1051px; height: 246px;">${bodList.bodContents}</textarea></td>
									</tr>

								</table>


							</div>
						</div>
						<div>
							<a type="button" href="stu?command=stuBoardList"
								class="btn btn-danger" style="float: right;">취소</a>
							<button type="submit" class="btn btn-primary"
								style="float: right;" onclick="return updateAlert()">수정</button>
						</div>
					</div>
				</div>
			</div>
			<!-- container -->
		</form>
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