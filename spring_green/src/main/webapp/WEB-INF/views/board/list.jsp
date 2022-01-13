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
 <h2>게시판</h2>          
	 <table class="table table-hover table-inf">
	   <thead>
	     <tr>
	       <th>번호</th>
	       <th>제목</th>
	       <th>작성자</th>
	       <th>작성일</th>
	     </tr>
	   </thead>
	   <tbody>
	     <c:forEach var="board" items="${list}"><!-- c:를 이용해 반복문 작성 -->
		     <tr>
		       <td>${board.bd_num}</td>
		       <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
		       <td>${board.bd_me_id}</td>
		       <td>${board.bd_reg_date_str}</td> <!-- SimpleDateFormat 이용해 Date 표기형식 변경된 것을 _str 붙여서 반영 -->
		     </tr>
	     </c:forEach>
	   </tbody>
  	</table>
  	<c:if test="${user != null}">
	     <a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-outline-success">글쓰기</button></a>
	</c:if>
</body>
</html>