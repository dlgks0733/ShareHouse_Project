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
						<a href="epl?command=introductionFormAction" class="breadcrumb active">축구동아리 소개</a>
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
				<div class="photo">
					<img src="img\fashion2.jpg" alt="동아리 사진">
				</div>
				<div class="text">
					<p> 동아리명 : FC MIS </p>
					<p> 동아리 회장 : 염정인 </p>(<i><small>글로벌 IT 경영 최고의 축구동아리입니다.</small></i>)
				</div>
			</div>
		</section>
		
        <section id="map">
            <div class="page-title">
		        <h1>동아리 연혁</h1>
            </div>
            <div class="content">
                <div class="photo">
		            <img src="img\fashion2.jpg" alt="사계 포구에서 서쪽 방향으로 000미터 진행">
                </div>
                <div class="text">
		           <p><i><small> 2013년 3월 : 경영정보학과 FC MIS 축구동아리 창설</p>
                    <p>2013년 5월 : 경상대학 축구리그 4위</p>	
                    <p>2013년 9월 : 경상대학 체육대회 축구 3위</p>
                    <p>2014년 9월 : 경상대학 체육대회 축구 4위</p>
                    <p>2016년 4월 : 경상대학 축구리그 준우승</p>
                    <p>2017년 9월 : LSGB 체육대회 우승</p>
                    <p>2018년 5월 : 경상대학 체육대회 축구 4위</p>
                    <p>2018년 9월 : LSGB 체육대회 우승</p></small></i>
                    		
                </div>
		    </div>
        </section>

        <section id="choice">
            <div class="page-title">
		        <h1> 구성원 </h1>
            </div>
            <div class="content">
                <div class="text">
		            <ol>
			            <li>1인분 기준으로 서버에 각얼음 5조각(한조각의 20cc) 넣고 추출을 시작한다.</li>
			            <li>평상시 보다 원두의 양은 2배 정도 (20g)와 추출액은 얼음 포함해서 200cc까지 내린다.</li>
			            <li>아이스 잔에 얼음 6~7개 섞어서 시원하게 마신다</li>
		            </ol>
                </div>
			</div>
		</section>

	</div>
	<br><br>
		
<%@include file="../include/footer.jsp" %>
</body>
</html>