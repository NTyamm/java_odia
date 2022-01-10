<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<div class="body container">
		<h1>게시글 수정</h1>
		<form action="<%=request.getContextPath()%>/board/modify" method="post">
		  <div class="form-group">
			<input type="text" class="form-control" name="bd_title" value="${board.bd_title}" >
	      </div>
	      <div class="form-group">
			<textarea class="form-control" name="bd_contents" rows="10">${board.bd_contents}</textarea>
	      </div>
	      <input type="hidden" name="bd_num" value="${board.bd_num}">
		  <button class="form-control col-12">수정</button>
		</form>
	</div>
</body>
</html>