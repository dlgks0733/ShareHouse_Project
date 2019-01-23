<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">

		<title>Share House :: 축구동아리 소개</title>

		<!-- css include -->
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
		<link rel="stylesheet" type="text/css" href="css/icofont.css">
		<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
		<link rel="stylesheet" type="text/css" href="css/owl.theme.default.min.css">

		<!-- my css include -->
		<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/responsive.css">
		
		<style>
		@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
		@import url(https://fonts.googleapis.com/css?family=Oleo+Script);

  	
		
	  h1 {
			font-size: 1.8em;
		}
		h2 {
			font-size: 1.3em;
		}
		p {
			font-size: 1.3em;
			line-height: 2.5;
		}
		li {
			font-size: 1em;
			line-height: 2;
		}

		/* 모바일 - 767px 이하 */
		#container {
			width: 100%;
		}
		header {
			width: 100%;
			height: 300px;
			background: url(images/header.jpg) center no-repeat;
			background-size: cover;
			margin: 0;
		}
		nav {
			height: 50px;
			background: #000;
		}
		#main-nav {
			list-style: none;
			margin: 0;
			padding: 10px;
		}
		#main-nav li {
			display: inline-block;		
			color: #fff;
			font-family: "맑은 고딕", 돋움;
			font-size: 0.8em;
			margin: 5px 15px;
		}		
		section {
			position: relative;
			width: 100%;
			padding: 15px 5% 10px 5%;
		}
		#container section:nth-child(odd) {
			background: #eee;
		}
		.page-title {
			position: absolute;
			top: 20px;
			left: 0;
			padding: 30px 50px;
		}
		.page-title h1 {
				margin-bottom: 30px;
			}		
    .content {
    	margin: 80px auto 10px;
      -moz-box-sizing: border-box;
      -webkit-box-sizing: border-box;
      box-sizing: border-box;
      width: 90%;
      padding: 20px;
    }		
		.content ol {
			margin-top: 20px;
		}
		.sub-titles {
			color: #0094ff;
			font-weight: 600;
		}		
		.photo {
			display: none;
		}
		


    
    /* PC - 992px 이상 */
		@media screen and (min-width:992px) {
      #container {
				width: 1100px;
				margin: 0 auto;
				border: 1px solid #ccc;
			}
			
      #intro, #map, #choice {
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        clear: both;
        position: relative;
        width: 100%;
        height: 420px;
        padding: 15px 2% 10px 5%;
      }
      .content {
				margin: 80px auto 10px;
				width: 90%;
				padding: 20px;
			}
      .photo {
				width: 42%;
				display: block;
			}
      .photo > img {
				width: 100%;
				max-width: 320px;
				height: auto;
				margin-bottom: 30px;
			}
      .text {
				width: 50%;
			}
      #intro .photo, #map .photo {
				float: left;
				margin-right: 5%;
			}
			#intro .text, #map .text {
				float: left;
			}
			#choice .photo {
				float: left;
				margin-right: 5%;
			}
			#choice .text {
				float: left;
			}
			
    }
	</style>

	</head>
<body>
<section id="breadcrumb-section" class="breadcrumb-section w100dt mb-30">
			<div class="container">

				<nav class="breadcrumb-nav w100dt">
					<div class="page-name hide-on-small-only left">
						<h4>축구동아리 소개</h4>
					</div>
					<div class="nav-wrapper right">
						<a href="index.html" class="breadcrumb">Home</a>
						<a href="epl?command=eplIntroListFormAction" class="breadcrumb active">축구동아리 소개</a>
					</div>
					<!-- /.nav-wrapper -->
				</nav>
				<!-- /.breadcrumb-nav -->

			</div>
			<!-- container -->
		</section>
		<!-- /.breadcrumb-section -->
		<!-- ==================== header-section End ==================== -->
		<div id="container">
		
		
		<section id="intro">
			<div class="page-title">
				<h1>축구동아리 소개</h1>
			</div>
			<div class="content">
				<table class="bordered">
					<thead>
						<tr>
							<th> 동아리명 : <br></th>
							<th> 동아리 소개 : </th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach var="eplVo" items="${list}" >
							<td>${eplVo.intClubname }</td>
							<td>${eplVo.intContents }</td>
						</c:forEach>
						</tr>
					</tbody>
				</table>	
				</div>
				<br><br><br><br>
				<hr>
				
				
				</section>
			</div>
		
		
		<div id="container">
		
        <section id="intro">
        <div class="page-title">
				<h1>축구동아리 연혁</h1>
			</div>
           <div class="content">
				<table class="bordered">				
					<thead>
						<tr>
							<th> - 동아리 연혁 -  <br></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach var="eplVo" items="${list}" >
							<td>${eplVo.intHistory }</td>
						</c:forEach>
						</tr>
					</tbody>
				</table>	
				</div>
				<br><br><br><br>
				<hr>
				
				
        </section>
        
        </div>
        

      <div id="container">
		
        <section id="intro">
        <form method="post" action="epl?command=eplIntroUpdateFormAction">
        <div class="page-title">
				<h1>축구동아리 구성원</h1>
			</div>
           <div class="content">
				<table class="bordered">				
					<thead>
						<tr>
							<th> - 동아리 회장 -  <br></th>
							<th> - 동아리 구성원 -  <br></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach var="eplVo" items="${list}" >
						<input type="hidden" name="adminId" value="${eplVo.adminId}">	
							<td>${eplVo.intName }</td>
							<td>${eplVo.intId }</td>
						</c:forEach>
						</tr>
					</tbody>
				</table>	
				</div>
				<br><br><br><br>
				<hr>
				
				<div>
				 <input type="submit" class="btn" value="수정">
				</div>
			</form>
        </section>

	</div>
	<br><br>
		
<%@include file="../include/footer.jsp" %>
</body>
</html>