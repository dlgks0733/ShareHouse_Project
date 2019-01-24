<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">

		<title>Share House :: sns동아리 게시판</title>

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
						<h4>sns동아리 게시판</h4>
					</div>
					<div class="nav-wrapper right">
						<a href="index.html" class="breadcrumb">Home</a>
						<a href="sns?command=snsBoardListFormAciton" class="breadcrumb active">sns동아리 게시판</a>
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
			<table class="centered">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					

					<c:forEach var="mVO" items="${list}" varStatus="status">
					<tr>
					<td width="10%">${status.index+1}</td>
					<td width="20%"><a href="sns?command=snsBoardViewFormAction&bodNum=${mVO.bodNum}">${mVO.bodTitle}</a></td>
					<td width="10%">${snsVo.memberName}</td>
					<td width="10%">${snsVo.bodDate}</td>
					<td width="10%">${snsVO.bodHits}</td>
					</tr>
					</c:forEach>
				</tbody>
							
			</table>			
			
			<hr>
			<div>
				<input type="button" class="btn" style="float: right;"
				onclick="location.href='sns?command=snsInsertFormAction'" value="등록">
			</div>
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