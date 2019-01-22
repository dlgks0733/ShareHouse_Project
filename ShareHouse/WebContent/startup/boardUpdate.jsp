<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>게시글 수정</h1>
		<form name="frm" method="post" action="stu?command=stuBoardUpdate">
		
		<input type="hidden" name="bodNum" value="${bodNum}">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="bodTitle" value = "${bodTitle}"> * 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="bodContents"></textarea></td>
				</tr>
			</table>
			<br>
			<br> 	
			<div class="box-footer">
		<a type = "button" href ="stu?command=stuBoardList" class="btn btn-danger">취소</a>
		<button type="submit" class="btn btn-primary">등록</button>	
		
	</div>
	
		</form>
	</div>
</body>
</html>