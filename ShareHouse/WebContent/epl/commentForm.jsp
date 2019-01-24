<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 답글</title>
</head>
<body>
<form name="replyform" id="rp_form" method="post" action="BoardReply_ok.jsp" onsubmit="return replyCheck()">
<table border="1" summary="게시판 답글 폼">
<caption><b>게시판 답글 폼</b></caption>
 <colgroup>
  <col width="100px"/>
  <col width="500px"/>
 </colgroup>
 
 <tbody>
  <tr>
   <th align="center">제목</th>
   <td>
    <input type="text" id="subject" name="subject" maxlength="50" value=""/>
   </td>
  </tr>
  <tr>
   <th align="center">작성자</th>
   <td>
    <input type="text" id="writer" name="writer" maxlength="50" value=""/>
   </td>
  </tr>
  <tr>
   <td colspan="2">
    <textarea id="contents"  name="contents" rows="15" cols="75"></textarea>
   </td>
  </tr>
 </tbody>
</table>
<p>
 <input type="submit" value="등록"/>
 <input type="button" value="취소" onclick="history.back(-1)"/>
</p>
</form>
</body>
</html>