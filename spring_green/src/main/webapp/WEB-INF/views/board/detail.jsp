<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<div class="body container">
 		<c:if test="${board != null}">
	 		<div class="form group">
	 			제목: <input type="text" class="form-control" name="db_title" readonly value="${board.db_title}">
	 		</div>
	 		<div class="form group">
	 			작성자: <input type="text" class="form-control" name="db_me_id" readonly value="${board.db_me_id}">
	 		</div>
	 		<div class="form group">
	 			작성일: <input type="text" class="form-control" name="db_reg_date" readonly value="${board.db_reg_date}">
	 		</div>
 		</c:if>
 		<c:if test="${board == null}">
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
 	</div>

</body>
</html>