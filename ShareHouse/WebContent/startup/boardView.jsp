<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<form name="frm" method="post" action="stu?command=insertStuBoardAction">
		<table>
			<tr>
				<th>작성자</th>
				<td>${StuBoardVO.adminID}</td>
				<tr>
				<th>이메일</th>
				<td>${board.email}</td>
				</tr>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${StuBoardVO.bodDate}" /></td>
				<tr>
				<th>조회수</th>
				<td>${StuBoardVO.bodHits}</td>
				</tr>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${StuBoardVO.bodTitle}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${StuBoardVO.bodContents}</pre></td>
			</tr>
		</table>
		<br> <br> 
		<a type = "button" href ="stu?command=stuBoardList" class="btn btn-danger">취소</a>
		<button type="submit" class="btn btn-primary">등록</button>	
		</form>
	</div>
</body>
</html>