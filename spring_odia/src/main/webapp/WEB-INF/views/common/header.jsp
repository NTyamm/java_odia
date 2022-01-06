<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="/spring">HOME</a>
	  
	  <ul class="navbar-nav">
	  	<!-- 로그인 되어 있지 않으면 -> 세션에 user가 없으면 -->
	  	<c:if test="${user == null}"> <!-- c:if에서는 ""사이에 공백이 있으면 절대 안된다. JAVA와 다름 -->
		    <li class="nav-item">
		      <a class="nav-link" href="/spring/login">로그인</a>
		    </li>
		    <li class="nav-item">
	    	  <a class="nav-link" href="<%= request.getContextPath()%>/signup">회원가입</a>
	    	</li>
    	</c:if>
    	<c:if test="${user != null}">
    		<li class="nav-item">
    			<a class="nav-link" href="<%=request.getContextPath() %>/logout">로그아웃</a>
    		</li>	
    	</c:if>	
	    	<li class="nav-item">
    			<a class="nav-link" href="<%=request.getContextPath() %>/notice/list">공지사항</a>
    		</li>
    		<li class="nav-item">
    			<a class="nav-link" href="<%=request.getContextPath() %>/board/list">게시판</a>
    		</li>
	  </ul>
	  
	</nav>
</body>
</html>