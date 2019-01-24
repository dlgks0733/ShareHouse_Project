<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">

		<title>Share House :: 축구동아리 게시판</title>

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
						<h4>축구동아리 게시판</h4>
					</div>
					<div class="nav-wrapper right">
						<a href="index.html" class="breadcrumb">Home</a>
						<a href="epl?command=eplBoardListFormAciton" class="breadcrumb active">축구동아리 게시판</a>
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
                
               
				
			<table class="bordered">
					<tr>
						<th>제목</th>
						<td>${eplVo.bodTitle}</td>
						<th>작성자</th>
						<td>김정민</td>
						<th>작성일</th>
						<td>${eplVo.bodDate}</td>
						
					</tr>
				
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea name="contents"
						rows="28" cols="93" style="margin: 0px; width: 1051px; height: 246px;" disabled="disabled" >${eplVo.bodContents}</textarea></td>
					</tr>
			
							
			</table>
			<form name="frm" method="post" action="epl?command=eplCommentInsertAction" onsubmit="return validateBoard()">
			<input type="hidden" name="bodNum" value="${eplVo.bodNum}"> 
			<table>
			 <thead>
			
				<tr>
					<th>댓글 번호</th>
					<th>댓글 내용</th>
					<th>작성 일자</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="eplVo" items="${list}" varStatus="status">
						<tr>
						<td>${status.index+1 }</td>
						<td>${eplVo.commContents}</td>
						<td>${eplVo.commDate}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
				
				<table class="responsive-table ">
					<tr>
						<th>댓글</th>
						<td colspan="5"><textarea name="commContents"
						rows="28" cols="93" style="margin: 0px; width: 900px; height: 100px;" ></textarea></td>
						<td><input type="submit" class="btn" style="float: right;" value="답글"></td>
					</tr>
				</table>
				</form>
				
			
			<div>
				
				<input type="button" class="btn" style="float: right;"
				onclick="location.href='epl?command=eplBoardDeleteAction&bodNum=${eplVo.bodNum}'" value="삭제">
				<input type="button" class="btn" style="float: right;"
				onclick="location.href='epl?command=eplBoardUpdateFormAction&bodNum=${eplVo.bodNum}'" value="수정">
				<input type="button" class="btn" style="float: right;"
				onclick="location.href='epl?command=eplBoardListFormAciton'" value="목록">
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