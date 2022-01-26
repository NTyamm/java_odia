<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
</head>
<body>
 	<div class="body container">
 		<c:if test="${board != null}">
	 		<div class="form group">
	 			<label>제목:</label>
	 			<input type="text" class="form-control" name="db_title" readonly value="${board.bd_title}">
	 		</div>
	 		<div class="form group">
	 			<label>작성자:</label>
	 			<input type="text" class="form-control" name="db_me_id" readonly value="${board.bd_me_id}">
	 		</div>
	 		<div class="form group">
	 			<label>작성일:</label>
	 			<input type="text" class="form-control" name="db_reg_date" readonly value="${board.bd_reg_date_str}">
	 		</div>
	 		<div class="form group">
	 			<label>내용:</label>
	 			<div class="form-control" style="min-height:300px; height:auto;">${board.bd_contents}</div>
	 		</div>
	 		<div class="form group">
	 			<label>첨부파일</label>
		 			<c:forEach items="${fileList}" var="file">
		 			  <a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}">${file.fi_ori_name}</a>
		 			</c:forEach>
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
	  	<c:if test="${board.bd_type != '공지' && board.bd_num == board.bd_ori_num}">
		  	<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}"> 
			  	 <button class="btn btn-outline-success">답글</button>
			</a>
		</c:if>
 		<c:if test="${board == null}">
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
		<hr class="mt-3">
		
		<div class="comment-pagination">
			<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">이전</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">다음</a></li>
		  </ul>
		</div>
		<div class="comment-input mt-3">
			<textarea type="text" class="form-control co_contents" row="3" placeholder="댓글 내용을 입력하세요"></textarea>
			<div class="input-group-append">
				<button class="btn btn-info btn-comment-insert">등록</button><!-- type은 필요 없음 스크립트와 ajax 처리 -->
			</div>
		</div>
 	</div>
 	
 	<script type="text/javascript">
	var contextPath = '<%=request.getContextPath()%>';
	console.log(commentService.contextPath)
	$(function(){
		$('.btn-comment-insert').click(function(){
			var co_me_id = '${user.me_id}';
			if(co_me_id == ''){
				alert('댓글은 로그인한 회원만 작성 가능합니다.');
				return;
			}
			var co_contents = $('.co_contents').val();
			var co_bd_num = '${board.bd_num}';
			var comment = {
					co_me_id    : co_me_id,
					co_contents : co_contents,
					co_bd_num   : co_bd_num
			};
			commentService.insert(comment, '/comment/insert', function(res){
				if(res){
		      alert('댓글 등록이 완료 되었습니다.');
		     	$('.co_contents').val('');
		      }else{
		     	alert('댓글 등록에 실패 했습니다.');
		    }
			})
		});
		$.ajax({
			async: false,
			type:'get',
			url:contextPath+"/comment/list?page=1&bd_num="+'${board.bd_num}',
			dataType:"json",
			success: function(res){
				console.log(res);
			}
		})
	});
	//댓글리스트
	function createComment(comment, me_id){
		var str='';
		str+='<div class="comment-list clearfix">'
		if(comment.co_ori_num != comment.co_num){
		str+=	'<div class="float-left" style="width:24px">└</div>'		
		str+=	'<div class="float-left" style="width:calc(100% - 24px)">'
		}else{
		str+=	'<div class="float-left" style="width:100%">'
		}
		str+=		'<div class="co_me_id">'+comment.co_me_id+'</div>'
		str+=		'<div class="co_contents">'+comment_co_contents+'</div>'
		str+=		'<div class="co_reg_date">'+comment_co_reg_date+'</div>'
		if(comment.co_ori_num == comment.co_num)
		str+=		'<button class="btn btn-outline-info btn-reply-comment">답글</button>'
		if(comment.co_me_id == me_id){
		str+=		'<button class="btn btn-outline-dark btn-mod-comment">수정</button>'
		str+=		'<button class="btn btn-outline-danger btn-del-comment">삭제</button>'
		}
		str+=	'</div>'
		str+=	'<hr class="float-left" style="width:100%">'
		str+='</div>'
	}
	</script>
</body>
</html>