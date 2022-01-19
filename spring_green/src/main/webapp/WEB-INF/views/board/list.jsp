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
	<c:if test="${pm.criteria.type != null && pm.criteria.type == '일반'}">
		<h1>게시글</h1>
	</c:if>
	<c:if test="${pm.criteria.type != null && pm.criteria.type == '공지'}">
		<h1>공지사항</h1>
	</c:if>
	 <div class="body container">
		<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list">
		  <input type="text" class="form-control" name="search" placeholder="검색어를 입력하세요." value="${pm.criteria.search }">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		  <input type="hidden" name="type" value="${pm.criteria.type }">
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
	   <!-- 
	   	varStatus="vs"일 때
	   	vs.index : 0부터 시작해서 현재 반복된 횟수
	   	vs.count : 1부터 시작해서 현재 반복된 횟수
	    -->
	     <c:forEach var="board" items="${list}" varStatus="vs"><!-- c:를 이용해 반복문 작성 -->
		     <tr><!-- 게시글번호를 끊기지 않고 연속되게 보이기 위해 bd_num이 아니라 아래처럼 수정해야 함 -->
		       <td>${pm.totalCount - pm.criteria.pageStart - vs.index}</td>
		       <c:if test="${board.bd_num == board.bd_ori_num}">
			       <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
		       </c:if>
		       <c:if test="${board.bd_num != board.bd_ori_num}">
			       <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">└re ${board.bd_title}</a></td>
		       </c:if>
		       <td>${board.bd_me_id}</td>
		       <td>${board.bd_reg_date_str}</td> <!-- SimpleDateFormat 이용해 Date 표기형식 변경된 것을 _str 붙여서 반영 -->
		       <td>${board.bd_views}</td> <!-- 조회수 추가함 -->
		     </tr>
	     </c:forEach>
	   </tbody>
  	</table>
  	<ul class="pagination justify-content-center">
  		<c:if test = "${pm.prev}">
		    <li class="page-item">
		    	<a class="page-link" 
		    	href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">이전</a>
		    </li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
		    <c:if test="${i != pm.criteria.page }">
			    <li class="page-item">
			    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a>
			    </li>	
		    </c:if>
		    <c:if test ="${i == pm.criteria.page }">
			    <li class="page-item active">
			    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a>
			    </li>
		    </c:if>
	    </c:forEach>
	    <c:if test = "${pm.next}">
		    <li class="page-item">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">다음</a>
		    </li>
	    </c:if>
 	</ul>
  	<c:if test="${user != null}">
	     <a href="<%=request.getContextPath()%>/board/register?bd_type=${pm.criteria.type}">
	     <button class="btn btn-outline-success">글쓰기</button></a>
	</c:if>

</body>
</html>