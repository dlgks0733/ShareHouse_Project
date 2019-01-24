<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="../include/header.jsp" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 
<%
    // 줄바꿈 
    pageContext.setAttribute("br", "<br/>");
    pageContext.setAttribute("cn", "\n");
%> 
   
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
		<section id="single-blog-section" class="single-blog-section w100dt mb-50">
	      <form method="post" action="epl?command=eplIntroUpdateFormAction">
	      <c:forEach var="eplVo" items="${list}" >
	      <input type="hidden" name="adminId" value="${eplVo.adminId}">	
	      <div class="container">
	         <div class="row">
	            <div class="col m12 s12">
	               <div class="blogs mb-30">
	                  <div class="card">
	                     <div class="card-image">
	                        <img src="img\eplMain.jpg" alt="축구동아리" width="500" height="200">
	                     </div>
	                     
	                     <!-- /.card-image -->
	                     <div class="card-content w100dt">
	                     <p>
	                           <a href="#" class="tag left w100dt l-blue mb-30">축구동아리 소개</a>
	                        </p>
	                        <ul class="post-mate right mb-30">
	                           <li class="like"><a href="#"> <i
	                                 class="icofont icofont-heart-alt"></i> 55
	                           </a></li>
	                           <li class="comment"><a href="#"> <i
	                                 class="icofont icofont-comment"></i> 32
	                           </a></li>
	                        </ul>
	                        
	                        <a href="#" class="card-title mb-30"> - 동아리명 : ${eplVo.intClubname} - </a>
	                        <p></p>
	
	                        
	
	                        <p class="w100dt mb-50">${fn:replace(eplVo.intContents, cn, br)}</p>
	                        
	                         <ul class="post-mate-time left mb-30">
	                           <li>
	                              <p class="hero left">
	                              <a href="#" class="card-title mb-30"> - 동아리 연혁 - </a>
	                              </p>
	                        </ul>
	                        
	                        <p></p>
	
	                       <!--  <ul class="post-mate right mb-30">
	                           <li class="like"><a href="#"> <i
	                                 class="icofont icofont-heart-alt"></i> 55
	                           </a></li>
	                           <li class="comment"><a href="#"> <i
	                                 class="icofont icofont-comment"></i> 32
	                           </a></li>
	                        </ul> -->
	
	                        <p class="w100dt mb-50">${fn:replace(eplVo.intHistory, cn, br)}</p>
	                        
	                        <p></p>
	                        <p></p>
	                        
	                        <ul class="post-mate-time left mb-30">
	                           <li>
	                              <p class="hero left">
	                              <a href="#" class="card-title mb-30"> - 동아리 구성원 - </a>
	                              </p>
	                        </ul>
			
							 <p></p>
	
	
							<p class="w100dt mb-50">동아리 회장 : ${eplVo.intName}</p>
	                        <p class="w100dt mb-50">동아리 구성원 : ${eplVo.intId}</p>
	                        
	                        
	                        <ul class="tag-list left">
	                           <li><input type="submit" class="btn" style="float: right; " value="수정"></li>
	                        </ul>
	
	                        <ul class="share-links right">
	                           <li><a href="https://web.facebook.com/hannamMIS/" class="facebook" target="_blank"><i
	                                 class="icofont icofont-social-facebook"></i></a></li>
	                           <li><a href="http://gitb.hannam.ac.kr/main/" class="google-plus" target="_blank"><i
                                 class="icofont icofont-social-google-plus"></i></a></li>
	                        </ul>
	                     </div>
                     <!-- /.card-content -->
                  </div>
                  <!-- /.card -->
               </div>
               <!-- /.blogs -->
               <!-- nlb board table form -->
            </div>
         </div>
      </div>
      </c:forEach>
      </form>
   </section>
		
<%@include file="../include/footer.jsp" %>
</body>
</html>