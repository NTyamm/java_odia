<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>${board.typeTitle}</h2><!-- c:if 대신 boardVO 메소드 활용 -->
	<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
		<c:if test ="${board.bd_ori_num != null}">
	    	<input type="hidden" value="${board.bd_ori_num}" name="bd_ori_num">
	    </c:if>
	    <input type="hidden" name="bd_type" value="${board.bd_type }"><!-- c:if 대신 boardVO 메소드 활용 -->
		<div class="form group">
			<label>제목</label>
		 	<input type="text" class="form-control" name="bd_title">
		 </div>
		 <div class="form group">
		 	<label>내용</label>
		 	<textarea class="form-control" name="bd_contents" rows="10"></textarea>
		 </div>
		 <!-- 파일 업로드창 추가 -->
	    <div class="form-group">
	        <label>첨부파일</label>
	        <input type="file" class="form-control" name="files2"/>
	        <input type="file" class="form-control" name="files2"/>
	        <input type="file" class="form-control" name="files2"/>
	    </div>	  
	  <!-- 포스트 기능...등록버튼으로 -->
	   <button class="btn btn-outline-success col-12">등록</button>
</form>
	 <script>
      $('[name=bd_contents]').summernote({
        placeholder: '내용을 입력하세요',
        tabsize: 2,
        height: 400
      });
    </script>
</body>
</html>