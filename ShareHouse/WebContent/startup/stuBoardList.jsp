<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>Share House :: 창업동아리 공지사항</title>

<!-- css include -->
<link rel="stylesheet" type="text/css" href="css/materialize.css">
<link rel="stylesheet" type="text/css" href="css/icofont.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/site.css">

<!-- my css include -->
<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">

<!-- board.js include -->
<script type="text/javascript" src="js/stuBoard.js"></script>

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
		<div class="container">
			<div class="row">
				<div class="col m12 s12">
					<div class="blogs mb-30">
					<div class="card">
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


								<c:forEach var="StuBoardVO" items="${noticeList}"
									varStatus="status">
									<tr>
										<td width="10%">${(paging.numOfRow - status.index) - (paging.pageNum-1) * 10}</td>

										<td width="20%"><a
											href="stu?command=stuBoardView&bodNum=${StuBoardVO.bodNum}">${StuBoardVO.bodTitle}</a></td>
										<td width="10%">${StuBoardVO.memberName}</td>
										<td width="10%">${StuBoardVO.bodDate}</td>
										<td width="10%">${StuBoardVO.bodHits}</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>

					</div>
				</div>
				<div>
				<input type="hidden" name="memId" value="${loginUser.memberId}">
				<button type="button" class="btn btn-primary right"
				 onclick="location.href='stu?command=insertStuBoardList'; return insertFormCheck();">등록</button>
				</div>
			</div>
		</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
				<div class="text-center">
					<ul class="pagination w100dt">
						<c:if test="${paging.pageNum > 1}">
							<li class="waves-effect"><a
								href="/ShareHouse/stu?command=stuBoardList&pageNum=${paging.pageNum - 1}"
								aria-label="Previous"><i class="icofont icofont-simple-left"></i></a></li>
						</c:if>

						<c:forEach begin="${paging.firstPage}" end="${paging.lastPage}"
							var="idx">
							<c:choose>
								<c:when test="${idx == paging.pageNum}">
									<li><span style="font-weight: bold;">${idx}</span></li>
								</c:when>
								<c:otherwise>
									<li class="waves-effect"><a
										href="/ShareHouse/stu?command=stuBoardList&pageNum=${idx}">
											${idx} </a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.numOfPage != paging.pageNum}">
							<li class="waves-effect"><a href=href=
								"/ShareHouse/stu?command=stuBoardList&pageNum=${paging.pageNum
								+ 1}"
		aria-label="Previous">»</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------- 페이징 부분------------------------------------------------------------------------------- -->

	<%-- 		  <div class="row">
                        <div class="col-sm-12">
                           
                               <div class="text-center"> 
                                <ul class="pagination theme-colored xs-pull-center mb-xs-40">
                                    <c:if test="${paging.pageNum > 1}">
                                       <li><a
                                          href="/ShareHouse/stu?command=stuBoardList&pageNum=${paging.pageNum - 1}"
                                          aria-label="Previous"> <span aria-hidden="true">«</span>
                                       </a></li>
                                    </c:if>

                                    <c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li><span style="font-weight: bold;">${idx}</span></li>
                                          </c:when>
                                          <c:otherwise>
                                             <li><a  href="/ShareHouse/stu?command=stuBoardList&pageNum=${idx}">
                                                   ${idx} </a></li>
                                          </c:otherwise>
                                       </c:choose>
                                    </c:forEach>

                                    <c:if test="${paging.numOfPage != paging.pageNum}">
                                       <li><a
                                          href="/ShareHouse/stu?command=stuBoardList&pageNum=${paging.pageNum + 1}"
                                          aria-label="Previous"> <span aria-hidden="true">»</span>
                                       </a></li>
                                    </c:if>
                                 </ul>
                              </div> 
                           
                        </div>
                     </div>  --%>


	<!-- container -->


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