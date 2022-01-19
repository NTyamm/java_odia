<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
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
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 400
      });
    </script>
</body>
</html>