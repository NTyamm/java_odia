<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>게시판</title>
</head>
<body>
<h1>게시글 수정</h1>

<form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
		<div class="form group">
	 			<label>제목:</label>
	 			<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
	 		</div>
	 		<div class="form group">
	 			<label>내용:</label>
	 			<textarea class="form-control" name="bd_contents" rows="10">${board.bd_contents}</textarea>
	 		</div>
	 		<!-- 파일 업로드창 추가 -->
	 		<input type="hidden" name="bd_num" value="${board.bd_num }">
	    	<div class="form-group attachment">
	    	  <label>첨부파일</label>
		        <c:forEach items="${fileList}" var="file">
			        <div class="form-control">
			        	<span>${file.fi_ori_name}</span>
			        	<a class="btn-close" href="#">X</a>
			        	<input type="hidden" name="fileNums" value="${file.fi_num}">
			        </div>
			    </c:forEach>
			    <c:forEach begin="1" end="${3-fileList.size()}">
	 	 	 		<input type="file" class="form-control" name="files2">
	 	 	 	</c:forEach>
		    </div>
	  <!-- 포스트 기능...등록버튼으로 -->
	 	
	  	 <button class="btn btn-outline-success col-12">수정</button>
	 </form>
	 <script>
	 //x버튼누르면 기존 파일 없애기
	 $(function(){
	 		$('.attachment .btn-close').click(function(e){
	 			e.preventDefault();
	 			var str = '<input type="file" class="form-control" name="files2">';
	 			$('.attachment').append(str);
	 			$(this).parent().remove(); //x버튼이 있는 부모를 지움
	 		});
	 	});
      $('[name=bd_contents]').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 400
      });
    </script>
</body>
</html>