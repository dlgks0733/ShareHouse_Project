<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/board.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>Share House :: SNS동아리 갤러리</title>

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
					<h4>SNS동아리 게시물 등록</h4>
				</div>
				<div class="nav-wrapper right">
					<a href="index.html" class="breadcrumb">Home</a> <a href="404.html"
						class="breadcrumb active">SNS동아리 갤러리</a>
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
	<section id="error-section" class="error-section w100dt mb-50">
		<div class="container">
			<!-- nlb board table form -->
			<form name="frm" method="post" enctype="multipart/form-data"
				action="sns?command=fileInsert" onsubmit="return validateBoard()">


				<table class="centered">
					<tr>
						<th>제목</th>
						<td><input type="text" name="galTitle"></td>
					</tr>

					<tr>
						<th>파일</th>
						<td>
							<div class="file-field">
								<div class="btn btn-primary btn-sm float-left">
									<span>사진 첨부</span> <input type="file" name="fileName">
								</div>
								<div class="file-path-wrapper">
									<input class="file-path validate" type="text"
										placeholder="Upload your file">
								</div>
							</div>
						</td>
					</tr>

					<tr>
						<th>내용</th>
						<td><textarea name="galContents" rows="28" cols="93"
								style="margin: 0px; width: 1051px; height: 246px;"></textarea></td>
					</tr>

				</table>
				<hr>
				<div>
					<input type="button" class="btn" style="float: right;"
						onclick="location.href='sns?command=snsBoardListFormAciton'"
						value="취소"> <input type="submit" class="btn"
						style="float: right;" value="등록">
				</div>
			</form>
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