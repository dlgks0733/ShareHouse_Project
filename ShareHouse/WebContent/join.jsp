<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/member.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>Share House :: 회원가입</title>

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
					<h4>회원가입</h4>
				</div>
				<div class="nav-wrapper right">
					<a href="index.html" class="breadcrumb">Home</a> <a href="404.html"
						class="breadcrumb active">회원가입</a>
				</div>
				<!-- /.nav-wrapper -->
			</nav>
			<!-- /.breadcrumb-nav -->

		</div>
		<!-- container -->
	</section>
	<!-- /.breadcrumb-section -->
	<!-- ==================== header-section End ==================== -->





	<!-- ==================== error-section start ==================== -->
	<section id="error-section" class="error-section w100dt mb-50">
		<div class="container">

			<!-- join table form -->

			<form name="frm"  method="post" action="member?command=insertMemberAction" onsubmit="return memValidate();">
				<div>
					<table class="bordered">
						<tr>
							<th><span style="color: red;">*</span> &nbsp; 학번</th>
							<td><input type="text" name="memId" readonly="readonly">
							<td><input type="button" class="btn" value="중복체크" onclick="popupOpen()" ></td>
						</tr>
	
						<tr>
							<th><span style="color: red;">*</span> &nbsp; 이름</th>
							<td><input type="text" name="memName"></td>
							<td></td>
						</tr>
						
						<tr>
							<th><span style="color: red;">*</span> &nbsp; 비밀번호</th>
							<td><input type="password" name="memPwd"></td>
							<td></td>
						</tr>
						
						
					</table>
				</div>

				<br>
				
				<button style="float: right;" class="btn" type="reset">취소</button> 
				<button style="float: right;" class="btn" type="submit">가입</button>
				
			</form>
		
		</div>
		<!-- container -->
	</section>
	<!-- /#error-section -->
	<!-- ==================== error-section end ==================== -->





	<!-- ==================== instag leftram-section Start ==================== -->
	<!--   <section id="instagram-section" class="instagram-section w100dt">

			<div class="instagram-link w100dt">
				<a href="#">
					<span>FIND US ON INSTAGRAM</span>
					@SUJONMAJIDESIGN
				</a>
			</div>

		</section> -->
	<!-- /#instag leftram-section -->
	<!-- ==================== instag leftram-section End ==================== -->

	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script>

	<!-- my custom js -->
	<script type="text/javascript" src="js/custom.js"></script>

	<script type="text/javascript">
		
	</script>
	<%@include file="include/footer.jsp"%>
</body>
</html>