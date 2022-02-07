<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
</head>
<body>
<h1>${board.typeTitle}</h1>
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
	 			<div class="form-control" style="min-height: 300px; hegith: auto" name="bd_contents" readonly>${board.bd_contents}</div>
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
	 		<div class="justify-content-center likes-btn-box" style="display:flex; padding:8px">
	 			<button class="btn btn-outline-primary btn-up" data-state="1">추천</button>
	 			<button class="btn btn-outline-danger btn-down ml-2" data-state="-1">비추천</button>
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
	  	<!-- 현재 보고 있는 게시글이 원본 게시글 -->
	  	<c:if test="${board.bd_num == board.bd_ori_num && (board.bd_type=='일반')}">
		  	<a href="<%=request.getContextPath() %>/board/register?bd_ori_num=${board.bd_num}"> 
			  <button class="btn btn-outline-success">답글</button>
			</a>
		</c:if>
		<!-- 현재 보고 있는 게시글이 답변 게시글일 때 답변을 하면 원본게시글의 답변으로 달리게 함 -->
		<c:if test="${board.bd_num != board.bd_ori_num && (board.bd_type=='일반') == null}">
		  	<a href="<%=request.getContextPath() %>/board/register?bd_ori_num=${board.bd_ori_num}"> 
			  <button class="btn btn-outline-success">답글</button>
			</a>
		</c:if>
 		<c:if test="${board == null}">
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
		<hr class="mt-3">
		<div class = "comment-list mt-3">
		</div>
		<div class = "comment-pagination mt-3"></div>
		<div class = "comment-box mt-3">
			<div class="input-group mb-3">
			  <textarea type="text" class="form-control text-comment" placeholder="댓글 내용을 입력하세요"></textarea>
			  <div class="input-group-append">
			    <button class="btn btn-danger btn-comment">등록</button>
			  </div>
			</div>
		</div>
 	</div>
  <script>
	commentService.setContextPath('<%=request.getContextPath()%>');
	$(function(){
	  //등록(댓글등록)을 클릭
		$('.btn-comment').click(function(){
		//로그인한 회원만 댓글 등록이 가능하게 하기 위해  회원 아이디를 가져옴
		var user = '${user.me_id}'; //사실 이렇게 하면 로그인 사용자 정보가 개발자도구에서 유출될 수 있으므로 ajax이용해서 로그인 세션 체크가 더 좋음
		//아이디가 없으면 로그인하지 않은 상태이기 때문에 로그인하라고 알려줌
		if(user == ''){
			alert('로그인 후 댓글을 달 수 있습니다.')
			return;
		}
		//댓글 내용 가져오기
		var co_contents = $('.text-comment').val();
		//게시글 번호 가져오기
		var co_bd_num = '${board.bd_num}';
		//댓글 원본 번호(댓글과 대댓정보. 리스트 작업하면서 진행)
		
		//댓글 내용이 없는 경우 알림창 띄우고 등록하지 않음
		if(co_contents == ''){
			alert('댓글 내용을 입력하세요.');
			return;
		}
		
		//ajax로 댓글 정보를 보내기 위해 객체를 만듬. 이 때 만들어지는 객체의 속성명을 CommentVO의 멤버변수 이름과 일치시킴
		var comment = {
			co_contents : co_contents,
			co_bd_num: co_bd_num
		}
		//댓글을 등록하기 위해 ajax로 서버에 데이터를 전송...을 js에 넘기고 js를 불러온다
		commentService.insert('/comment/insert', comment, function(res){
			if(res == true){
				//입력한 댓글을 지워줌
				$('.text-comment').val('');
				alert('댓글 등록이 완료되었습니다.');
				//새로고침(전체가 아닌 댓글부분만)을 해서 1페이지에 맞는 댓글을 가져옴
				readComment(co_bd_num, 1);
			}else{ 
				alert('댓글 등록에 실패했습니다.');
      }
			console.log(likes);
		});
	 });
		$('.btn-up, .btn-down').click(function(){
			var li_state=$(this).data('state');
			var li_bd_num='${board.bd_num}';
			var li_me_id='${user.me_id}';
			var likes={
					li_state : li_state,
					li_bd_num: li_bd_num,
					li_me_id : li_me_id
			}
			console.log(likes)
			if(li_me_id == ''){
				alert('로그인한 회원만 가능합니다');
				return;
			}
			$.ajax({
				async:false,
				type:'POST',
				data: JSON.stringify(likes),
				url: '<%=request.getContextPath()%>/board/likes',
				dataType:"json",
				contentType:"application/json; charset=UTF-8",
				success : function(res){
					if(res == 1){
						alert('추천했습니다.');
					}else if(res == -1){
						alert('비추천했습니다.')
					}else if(res != "fail"){
						var str = li_state == 1 ? '추천':'비추천';
						alert(str + '을 취소했습니다.')
					}
					viewLikes(likes);
				}
			});
		});
	});
	//요소에 이벤트를 등록하는 게 아니라 document에 등록해서 요소가 나중에 추가돼도 해당 선택자만 맞으면 이벤트가 실행됨
	$(document).on('click','.comment-pagination .page-link', function(){
		var co_bd_num = '${board.bd_num}';
		var page = $(this).data('page');
		readComment(co_bd_num, page);
	});	
	//댓글삭제
	$(document).on('click','.comment-list .btn-del-comment', function(){
		//삭제할 댓글 번호는 삭제  버튼에 data-num속성값으로 입력되ㅏ어 있음
		//삭제할 댓글 번호를 가져옴 data()메소드를 이용
		//data()메소드는 data-xxx인 속송들의 값을 가져올 때 사용
		//data(xxx)로 하면 data-xxx와 일치하는 속성의 값을 가져옴
		var co_num = $(this).data('num');
		//삭제할 댓글 번호가 있는 경우만 삭제
		if(co_num != ''){
			commentService.delete('/comment/delete?co_num='+co_num, function(res){
				//삭제가 완료되면 댓글을 새로고침(1페이지)
				var co_bd_num = '${board.bd_num}';
				readComment(co_bd_num, 1);
			})
		}
	});
	//댓글수정
	$(document).on('click','.comment-list .btn-mod-comment', function(){
		//이전에 생긴(댓글 수정 버튼을 클릭해서 생긴) textarea 태그와 등록버튼을 제거하고, 감춘 답글, 수정, 삭제 버튼을 추가함
		//.each(function) 기능을 쓰지 않고 이 라인 삭제 후 this 대신 '.co_contents2'를 전부 넣어도 됨
		$('.co_contents2').each(function(){ 
			//수정 전 댓글을 다시 보여줌
			$(this).siblings('.co_contents').show();
			//답변, (수정, 삭제) 버튼을 보여줌
			$(this).parent().children('button').show();
			//등록 버튼을 없앰(댓글 수정을 위한 등록 버튼)
			$(this).siblings('.btn-mod-comment2').remove();
			//답글등록버튼을 없앰
			$(this).siblings('.btn-reply-comment2').remove();
			//textarea 태그를 제거(수정하기 위한 입력창)
			$(this).remove();
		});
		//등록된 댓글 내용을 가져옴(수정 전). textarea 태그 안에 넣어주기 위해
		var contents =$(this).siblings('.co_contents').text(); //수정창 열렸을 때 들어갈 내용 정의
		//textarea 태그를 꾸며주기 위한 html(여기서는 부트스트랩을 가져와 이용했음)
		var str=
			'<div class="form-group co_contents2 mt-2">' +
				'<textarea class = "form-cotrol">'+contents+'</textarea>' + //수정창 열렸을 때 정의된 내용 불러오기
			'</div>'
		//수정 완료 후 등록 버튼을 위한 html
		var btnStr=
			'<button class="btn-mod-comment2 btn btn-outline-warning ml-2">'+'수정등록'+'</button>'
		//기존 댓글을 감춤
		$(this).siblings('.co_contents').hide(); //수정창 밖에서 수정해야할 기존 콘텐츠 내용 안보이게
		//답글, 수정, 삭제 버튼을 감춤
		$(this).parent().children('button').hide();
		//textarea 태그를 아이디 밑에 배치
		$(this).siblings('.co_me_id').after(str);
		//등록 버튼을 날짜 밑에 배치
		$(this).siblings('.co_reg_date').after(btnStr);
		});
	//수정 버튼 눌렀을 때 생기는 등록 버튼 클릭 이벤트
	$(document).on('click','.comment-list .btn-mod-comment2', function(){
		//수정된 댓글 내용
		var co_contents = $(this).siblings('.co_contents2').children().val();
		//수정할 댓글 번호
		var co_num=$(this).siblings('[name=co_num]').val();
		//수정된 댓글 내용과 번호를 이용하여 객체를 만듬. 서버로 전송하기 위해
		var comment={
			co_num : co_num,
			co_contents : co_contents
		}
		commentService.modify('/comment/modify',comment,function(res){
			if(res){
	            var page = $('.comment-pagination .active').text();
	            var co_bd_num = '${board.bd_num}';
	            //현재 페이지와 게시글 번호에 맞게 댓글을 새로고침
	            readComment(co_bd_num, page);
	          }else{
	        	  alert('댓글을 수정할 수 없습니다.');
	          }
		})		
	});
	
	//답글 버튼 클릭
	$(document).on('click','.btn-reply-comment', function(){
		var co_num=$(this).data('num');
		//로그인 아이디를 확인함
		var id = '${user.me_id}';
		//로그인 안하면 답들을 달지 못하게 함
		if(id==''){
			alert('로그인 후 답글을 작성할 수 있습니다.')
			return;
		}
		//이전 답글창 제거
		$('.co_contents2').each(function(){
			//수정하기 전 댓글을 다시 보여줌
			$(this).siblings('.btn-reply-comment2').remove();
			//답변,(수정,삭제)버튼을 보여줌
			$(this).parent().children('button').show();
			//댓글 수정을 위한 등록 버튼을 없앰
			$(this).siblings('.co_contents').show();
			//답글 등록 버튼을 없앰
			$(this).siblings('.btn-mod-comment2').remove();
			//textarea 태그를 제거(수정하기 위한 입력창)
			$(this).remove();
		});
		
		//답글창 추가
		//textarea태그를 꾸며주기 위한 html
		var str=
			'<div class="form-group co_contents2 mt-2">' +
				'<textarea class = "form-cotrol"></textarea>' + //수정창 열렸을 때 정의된 내용 불러오기
			'</div>'
		//답글 등록 버튼을 위한 html
		var btnStr=
			'<button class="btn-reply-comment2 btn btn-outline-warning ml-2">'+'답글등록'+'</button>'
			//textarea태그를 아이디 밑에 배치
		$(this).siblings('.co_reg_date').after(str);
		//등록버튼을 날짜 밑에 배치
		$(this).siblings('hr').before(btnStr);
		//답글 (수정, 삭제) 버튼을 감춤
		$('.btn-reply-comment2').siblings('button').hide();
	});
	
	//답글등록 버튼 클릭
	$(document).on('click','.btn-reply-comment2',function(){
		//원래 댓글 번호, 내용, 게시글 번호
		var co_contents = $('.co_contents2 textarea').val();
		var co_ori_num=$(this).siblings('.btn-reply-comment').data('num');
		var co_bd_num='${board.bd_num}';
		
		var comment={
			co_contents : co_contents,
			co_ori_num : co_ori_num,
			co_bd_num : co_bd_num
		};
		commentService.insert('/comment/insert', comment, function(res){
			if(res){
	            var page = $('.comment-pagination .active').text();
	            var co_bd_num = '${board.bd_num}';
	            //현재 페이지와 게시글 번호에 맞게 댓글을 새로고침
	            readComment(co_bd_num, page);
	          }else{
	        	  alert('답글을 달 수 없습니다.');
	          }
		});
	});
	
	//화면 로딩 후 댓글과 댓글 페이지네이션 배치
	var co_bd_num = '${board.bd_num}';
	readComment(co_bd_num, 1);
	viewLikes({
		li_bd_num : '${board.bd_num}',
		li_me_id : '${user.me_id}'
	});
	
	//함수 모음
	function viewLikes(likes){
		$.ajax({
			async:false,
			type:'POST',
			data: JSON.stringify(likes),
			url: '<%=request.getContextPath()%>/board/view/likes',
			dataType:"json",
			contentType:"application/json; charset=UTF-8",
			success : function(res){
				console.log(res)
				$('.likes-btn-box .btn')
				.removeClass('btn-primary')
				.addClass('btn-outline-primary');
				$('.likes-btn-box .btn').each(function(){
					if($(this).data('state') == res){
						$(this)
							.removeClass('btn-outline-primary')
							.addClass('btn-primary');		
						}
				});
			}
		});
	}
	//Date 객체를 yyyy-MM-dd hh:mm 형태의 문자열로 변환하는 함수
	
	function getDateStr(date){
		var year = date.getFullYear();
		var month = date.getMonth()+1 // 월에는 +1 해줘야 함
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		return year + "-" + month + "-" + day + "-"+hour+":"+minute;
	}
	function createCommentStr(comment, co_reg_date){
		var str =  
		'<div class="comment-box">' +
			'<input type="hidden" name="co_num" value="'+comment.co_num+'">' +
			'<div class="co_me_id">'+comment.co_me_id+'</div>';
			
			if(comment.co_num == comment.co_ori_num)
				str+= '<div class="co_contents mt-2">'+comment.co_contents+'</div>'; 
			else
				str+= '<span class="ml-3">└re: </span><span class="co_contents mt-2">'+comment.co_contents+'</span>';
			 
			str+= '<div class="co_reg_date mt-2">'+co_reg_date+'</div>';
			
			if(comment.co_num == comment.co_ori_num)
				str+='<button class="btn-reply-comment btn btn-outline-danger" data-num="'+comment.co_num+'">답글</button>';
			
			if('${user.me_id}' == comment.co_me_id){
				str +=
					'<button class="btn-mod-comment btn btn-outline-warning ml-2" data-num="'+comment.co_num+'">수정</button>'+
					'<button class="btn-del-comment btn btn-outline-info ml-2" data-num="'+comment.co_num+'">삭제</button>';
			}
			
			str+=
			'<hr>'+
		'</div>';
		return str;
	}
	//게시글 댓글 중 page 번호에 맞는 댓글을 가져와서 화면에 배치하는 함수
	function readComment(co_bd_num, page){
		//게시글 번호가 없으면 가져올 게시글이 없어서 작업하지 않음
		if(co_bd_num != ''){
			var url = '/comment/list?co_bd_num='+co_bd_num + '&page='+page;
			commentService.list(url, function(res){
				var str = ''
			       	//댓글을 하나씩 가져와서 html로 이루어진 문자열을 만든 후 이어붙임
		        for(tmp of res.list){
			    //정수로 넘어온 댓글 날짜를 날짜타입으로 변환
			    var date = new Date(tmp.co_reg_date);
			    //댓글정보를 html로 만들어진 문자열로 만든 후 이어붙임
			    str += createCommentStr(tmp, getDateStr(date));
			    }
			    //html로 된 댓글들을 지정된 위치에 배치
				$('.comment-list').html(str);
			    //서버에서 보낸 페이지메이커를 이용하여 html로 이루어진 페이지네이션을 만듬
				var paginationStr= createCommentPagination(res.pm);
				//만들어진 html 페이지네이션을 배치
				$('.comment-pagination').html(paginationStr);
			});
		}
	}
	function createCommentPagination(pm){
		var str= ''
		str +='<ul class="pagination justify-content-center">';
		var startDisabled = pm.prev? '' : 'disabled';
		var endDisabled = pm.next? '' : 'disabled';
		
		str += '<li class="page-item '+startDisabled+'"><a class="page-link" href="javascript:void(0);" data-page="'+(pm.criteria.page-1)+'" >이전</li>'
		for (i=pm.startPage; i<=pm.endPage; i++){
			var currentActive=pm.criteria.page == i ? 'active' : '';
			 str+='<li class="page-item '+currentActive+'"><a class="page-link" href="javascript:void(0);" data-page="'+i+'" >'+i+'</li>'
		}

	  	str += '<li class="page-item '+ endDisabled +'"><a class="page-link" href="javascript:void(0);" data-page="'+(pm.criteria.page+1)+'" >다음</li>'
		str+= '</ul>';
		return str;
	}
	
	console.log(commentService.name);
  </script>
</body>

</html>