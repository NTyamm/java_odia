<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		      <input type="file" class="form-control" name="files"/>
		      <input type="file" class="form-control" name="files"/>
		      <input type="file" class="form-control" name="files"/>
		  </div>
	  <!-- 포스트 기능...등록버튼으로 -->
	  	 <button class="btn btn-outline-success col-12">등록</button>
	 </form>
	
</body>
</html>