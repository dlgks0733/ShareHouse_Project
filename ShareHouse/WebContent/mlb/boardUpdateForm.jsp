<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">

		<title>Share House :: 농구동아리 게시판</title>

		<!-- css include -->
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/icofont.css">
		<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
		<link rel="stylesheet" type="text/css" href="css/owl.theme.default.min.css">

		<!-- my css include -->
		<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/responsive.css">

	</head>
<body>
	<section id="breadcrumb-section" class="breadcrumb-section w100dt mb-30">
			<div class="container">

				<nav class="breadcrumb-nav w100dt">
					<div class="page-name hide-on-small-only left">
						<h4>농구동아리 게시판</h4>
					</div>
					<div class="nav-wrapper right">
						<a href="index.html" class="breadcrumb">Home</a>
						<a href="mlb?command=mlbBoardListFormAciton" class="breadcrumb active">농구동아리 게시판</a>
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
			
		<form method="post" action="mlb?command=mlbBoardUpdateAction">
			<input type="hidden" name="bodNum" value="${mlbVo.bodNum}">		
			<table class="bordered">
					<tr>
						<th>제목</th>
						<td><input type="text" name="bodTitle" value="${mlbVo.bodTitle}"></td>
						<th>작성자</th>
						<td>이한</td>
						<th>작성일</th>
						<td>${mlbVo.bodDate}</td>
						
					</tr>
				
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea name="bodContents"
						rows="28" cols="93" style="margin: 0px; width: 1051px; height: 246px;">${mlbVo.bodContents}</textarea></td>
					</tr>				
							
			</table>			
			<hr>
			<div>
				<input type="submit" class="btn" style="float: right;" value="수정">
				<input type="button" class="btn" style="float: right;"
				onclick="location.href='mlb?command=mlbBoardListFormAciton'" value="목록">
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
<%@include file="../include/footer.jsp" %>		
</body>
</html>