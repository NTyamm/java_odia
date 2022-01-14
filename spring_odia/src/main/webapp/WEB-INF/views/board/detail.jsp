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
	 			<label>제목:</label>
	 			<input type="text" class="form-control" name="bd_title" readonly value="${board.bd_title}">
	 		</div>
	 		<div class="form group">
	 			<label>작성자:</label>
	 			<input type="text" class="form-control" name="bd_me_id" readonly value="${board.bd_me_id}">
	 		</div>
	 		<div class="form group">
	 			<label>작성일:</label>
	 			<input type="text" class="form-control" name="bd_reg_date" readonly value="${board.bd_reg_date_str}">
	 		</div>
	 		<div class="form group">
	 			<label>내용:</label>
	 			<textarea class="form-control" name="bd_contents" readonly>${board.bd_contents}</textarea>
	 		</div>
	 		<div class="form group">
	 			<c:if test="${files != null && files.size() != 0}">
	 				<label>첨부파일</label>
	 				<c:forEach items="${files}" var="file">
	 					<a href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
	 				</c:forEach>
	 			</c:if>
	 			<c:if test="${files == null || files.size() == 0}">
	 				<label>첨부파일 없음</label>
	 			</c:if>
	 		</div>
 		</c:if>
 		<c:if test="${user.me_id == board.bd_me_id }">
		  	<a href="<%=request.getContextPath() %>/board/modify?bd_num=${board.bd_num}"> 
		  	  <button class="btn btn-outline-success">수정</button>
		  	</a>
		  	<a href="<%=request.getContextPath() %>/board/delete?bd_num=${board.bd_num}"> 
		  	  <button class="btn btn-outline-success">삭제</button>
		  	</a>
	  	</c:if>
 		<c:if test="${board == null}">
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
 	</div>

</body>
</html>