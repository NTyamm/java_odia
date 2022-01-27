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
		<div class="comment-list clearfix"></div>
		<div class="comment-pagination">
		</div>
		<div class="comment-input mt-3">
			<textarea class="form-control co_contents" rows="3" placeholder="댓글 내용을 입력하세요"></textarea>
			<div class="input-group-append">
				<button class="btn btn-info btn-comment-insert">등록</button><!-- type은 필요 없음 스크립트와 ajax 처리 -->
			</div>
		</div>
 	</div>
 	
 	<script type="text/javascript">
	var contextPath = '<%=request.getContextPath()%>';
	commentService.setContextPath(contextPath);
	$(function(){
		$('.btn-comment-insert').click(function(){
			var co_me_id = '${user.me_id}';
			if(co_me_id == ''){
				alert('댓글은 로그인한 회원만 작성 가능합니다.');
				return;
			}
			var co_contents = $('textarea.co_contents').val();
			var co_bd_num = '${board.bd_num}';
			var comment = {
					co_me_id    : co_me_id,
					co_contents : co_contents,
					co_bd_num   : co_bd_num
			};
			commentService.insert(comment, '/comment/insert',insertSuccess);
		});
		
		$(document).on('click','.comment-pagination .page-item',function(){
			if($(this).hasClasS('disabled')){
				return;
			}
			var page = $(this).data('page');
			var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}';
			commentService.list(listUrl,listSuccess);
		})
		var listUrl="/comment/list?page=1&bd_num="+'${board.bd_num}';
		commentService.list(listUrl,listSuccess);
	});
	//페이지네이션.......너무어렵다.....
	//댓글삭제 이벤트
	$(document).on('click','.btn-del-comment',function(){
		var co_num = $(this).data('num'); //콘솔 출력 테스트때는 됐는데 
		var deleteUrl = '/comment/delete?co_num='+co_num;
		commentService.delete(deleteUrl, deleteSuccess);
	});
	//댓글수정 이벤트
	$(document).on('click','.btn-mod-comment',function(){
		//댓글 초기화
		commentInit();
		$(this).parent().children('button').hide();
	 	$(this).siblings('.co_contents').hide();
	 	var text = $(this).siblings('.co_contents').text();
		var textarea
			='<textarea class="form-control co_contents2">'+text+'</textarea>'
		$(this).siblings('.co_contents').after(textarea);
		var button
			='<button class="btn btn-outline-info btn-mod-insert">댓글수정</button>'
		$(this).siblings('.co_reg_date').after(button);
	});
	
	function listSuccess(res){
		var str = '';
		var me_id = '${user.me_id}';
		if(res.list.length == 0){
			$('.comment-list').html('');
			$('.comment-pagination').html('');
			return;
		}
		
		for(tmp of res.list){
			str += createComment(tmp, me_id);
		}
		$('.comment-list').html(str);
		
		var paginationStr = createPagination(res.pm);
		$('.comment-pagination').html(paginationStr);
	};
	function insertSuccess(res){
		if(res){
			alert('댓글 등록이 완료 되었습니다.');
		  $('.co_contents').val('');
			var listUrl="/comment/list?page=1&bd_num="+'${board.bd_num}';
			commentService.list(listUrl,listSuccess)
		}else{
		  alert('댓글 등록에 실패 했습니다.');
		}
	}
	
	//아래로 함수들 만들기
	//댓글리스트
	function createComment(comment, me_id){
		var co_reg_date=getDateToString(new Date(comment.co_reg_date));
		var str='';
		str+='<div class="comment-box">'
		if(comment.co_ori_num != comment.co_num){
		str+=	'<div class="float-left" style="width:24px">└</div>'		
		str+=	'<div class="float-left" style="width:calc(100% - 24px)">'
		}else{
		str+=	'<div class="float-left" style="width:100%">'
		}
		str+=		'<div class="co_me_id">'+comment.co_me_id+'</div>'
		str+=		'<div class="co_contents">'+comment.co_contents+'</div>'
		str+=		'<div class="co_reg_date">'+co_reg_date+'</div>'
		if(comment.co_ori_num == comment.co_num)
		str+=		'<button class="btn btn-outline-info btn-reply-comment mr-1">답글</button>'
		if(comment.co_me_id == me_id){
		str+=		'<button class="btn btn-outline-dark btn-mod-comment mr-1" data-num="'+comment.co_num+'">수정</button>'
		str+=		'<button class="btn btn-outline-danger btn-del-comment" data-num="'+comment.co_num+'">삭제</button>'
		}
		str+=	'</div>'
		str+=	'<hr class="float-left" style="width:100%">'
		str+='</div>'
		return str;
	}
	//페이지네이션 함수
	function createPagination(pm){
		var str='';
		var prevDisabled = pm.prev ? '' : 'disabled';
		var nextDisabled = pm.enxt ? '' : 'disabled';
		var page=pm.criteria.page;
		
		str+=	'<ul class="pagination justify-content-center">'
		str+=	  '<li class="page-item '+prevDisabled+'" data-page="'+(pm.startPage-1)+'"><a class="page-link" href="javascript:void(0);">이전</a></li>'
		for(i=pm.startPage; i<=pm.endPage; i++){
			var active = page == i ? 'active':'';
			str+=	'<li class="page-item '+active+'" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>'
		}
		str+=	  '<li class="page-item '+nextDisabled+'" data-page="'+(pm.endPage+1)+'"><a class="page-link" href="javascript:void(0);">다음</a></li>'
		str+=	'</ul>'
		return str;
	}
	//댓글 삭제 함수
	function deleteSuccess(res){
		if(res){
			alert('댓글을 삭제했습니다.')
			var listUrl='/comment/list?page=1&bd_num='+'${board.bd_num}';
			commentService.list(listUrl,listSuccess);
		}else{
			alert('댓글 삭제에 실패했습니다.')
		}
	}
	//댓글 초기화
	function commentInit(){
		$('.comment-box').each(function(){
			$(this).find('.co_contents2').remove();
			$(this).find('btn-mod-insert').remove();
			$(this).find('button').show();
			$(this).find('.co_contents').show;
		})	
	}
	//날짜출력 정상화
	function getDateToString(date){
		return "" + 
			date.getFullYear()  + "-" + 
			(date.getMonth()+1) + "-" +
			date.getDate()      + " " +
			date.getHours()     + ":" +
			date.getMinutes();
		}
	
	
	</script>
</body>
</html>