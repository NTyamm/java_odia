<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>게시글 등록</title>
</head>
<body>
<h1>글쓰기${bd_ori_num}</h1>
	<form action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data" method="post">
		<div class="form group">
			<label>제목</label>
		 	<input type="text" class="form-control" name="bd_title">
		 </div>
		 <div class="form group">
		 	<label>내용</label>
		 	<textarea class="form-control" name="bd_contents" rows="10"></textarea>
		 </div>
		 <!-- form 태그 수정 -->
		  <!-- 파일 업로드창 추가 -->
		  <div class="form-group">
		      <label>파일</label>
		      <input type="file" class="form-control" name="files2"/>
		      <input type="file" class="form-control" name="files2"/>
		      <input type="file" class="form-control" name="files2"/>
		  </div>
		  <c:if test="${bd_ori_num != null}">
			  <input type="hidden" name="bd_ori_num" value="${bd_ori_num}">
		  </c:if>
		  <c:if test="${bd_type == null}">
		  	<input type = "hidden" name="bd_type" value="일반">
		  </c:if>
		  <c:if test="${bd_type != null}">
		  	<input type = "hidden" name="bd_type" value="${bd_type}">
		  </c:if>
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