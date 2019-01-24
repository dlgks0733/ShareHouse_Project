<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/header.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/board.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">

		<title>Share House :: 축구동아리 소개 수정</title>

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
						<h4>축구동아리 소개 수정</h4>
					</div>
					<div class="nav-wrapper right">
						<a href="index.html" class="breadcrumb">Home</a>
						<a href="404.html" class="breadcrumb active">축구동아리 소개</a>
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
		<form name="frm" method="post" action="epl?command=eplIntroUpdateAction" onsubmit="return validateBoard()">
			<input type="hidden" name="adminId" value="${eplVo.adminId}">
			<table class="centered">
					<tr>
						<th>동아리명 </th>
						<td><input type="text" name="intClubname" value="${eplVo.intClubname}"></td>
					</tr>
					
					<tr>
						<th>동아리 소개<hr></th>
						<td><textarea name="intContents"
						rows="28" cols="93" style="margin: 0px; width: 900px; height: 246px;">${eplVo.intContents}</textarea></td>
					</tr>
					<tr>
						<th>동아리 연혁<hr></th>
						<td><textarea name="intHistory"
						rows="28" cols="93" style="margin: 0px; width: 900px; height: 246px;">${eplVo.intHistory}</textarea></td>
					</tr>
					<tr>
						<th>동아리 회장 </th>
						<td><input type="text" name="intName" value="${eplVo.intName}"></td>
					</tr>
					<tr>
						<th>동아리 구성원<hr></th>
						<td><textarea name="intId"
						rows="28" cols="93" style="margin: 0px; width: 900px; height: 246px;">${eplVo.intId}</textarea></td>
					</tr>			
			</table>			
			
			<hr>
			<div>	
				<input type="button" class="btn" style="float: right;"
				onclick="location.href='epl?command=eplIntroListFormAction'" value="취소">
				<input type="submit" class="btn" style="float: right;" value="등록">
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