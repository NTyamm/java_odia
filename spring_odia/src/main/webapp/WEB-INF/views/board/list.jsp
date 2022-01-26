<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
 <h2>${pm.criteria.typeTitle}</h2><!-- criteria에 메소드를 만들어서 c:if 없이 처리 -->    
 	 <form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list"> <!--form작동시 링크될 주소 -->
	  <input type="text" class="form-control" name="search" placeholder="검색어를 입력하세요" value="${pm.criteria.search}"><!-- value를 줘야 검색어가 유지됨 -->
	  <div class="input-group-append">
	    <button class="btn btn-success" type="submit">검색</button>
	  </div>
	  <input type="hidden" value="${pm.criteria.type}" name="type">
	 </form>  	
	 <table class="table table-hover table-inf">
	   <thead>
	     <tr>
	       <th>번호</th>
	       <th>제목</th>
	       <th>작성자</th>
	       <th>작성일</th>
	       <th>조회수</th>
	     </tr>
	   </thead>
	   <tbody>
	     <c:forEach var="board" items="${list}"><!-- c:를 이용해 반복문 작성 -->
		     <tr>
		       <td>${board.bd_num}</td>
		       <c:if test="${board.bd_num == board.bd_ori_num}">
		       	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
		       </c:if>
		       <c:if test="${board.bd_num != board.bd_ori_num}">
		       	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">└Re: ${board.bd_title}</a></td>
		       </c:if>
		       <td>${board.bd_me_id}</td>
		       <td>${board.bd_reg_date_str}</td> <!-- SimpleDateFormat 이용해 Date 표기형식 변경된 것을 _str 붙여서 반영 -->
		       <td>${board.bd_views}</td>
		     </tr>
	     </c:forEach>
	   </tbody>
  	</table>
  	<c:if test="${pm.criteria.type != '공지'||((user.me_authority)=='슈퍼관리자'||((user.me_authority)=='관리자'))}">
	     <a href="<%=request.getContextPath()%>/board/register?bd_type=${pm.criteria.type}"><button class="btn btn-outline-success">글쓰기</button></a>
	</c:if>
	
	<c:if test="${pm.criteria.page == i}">active</c:if>
  <ul class="pagination justify-content-center">
    <li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">이전</a>
   	</li>
   	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
	    <li class="page-item <c:if test="${pm.criteria.page == i}">active</c:if>">
	    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a>
	   	</li>
   	</c:forEach>
    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">다음</a>
   	</li>
  </ul>
</body>
</html>