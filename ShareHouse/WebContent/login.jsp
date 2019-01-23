<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>    

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/member.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/custom.css" />
<title>로그인</title>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form action="login.do" method="post" name = frm>
					<h2 style="text-align: center;">Share House</h2><br>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userid" maxlength="20"value="${userid}"/>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="pwd" maxlength="20"/>
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인" onclick="return loginCheck()"/> <br><br>
					<input type="button" class="btn btn-primary form-control" value="회원가입" onclick="location.href='member'"/> 
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
		
	
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<%@include file="include/footer.jsp" %>

</body>
</html>