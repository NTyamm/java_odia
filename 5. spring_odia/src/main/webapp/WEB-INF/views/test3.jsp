<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<!-- DOCTYPE html은 이 파일이 html5 파일이라고 적어주는 것 -->
<html>
<head>
	<title>Test3</title>
</head>
<body>
<h1>test3입니다</h1>
<form action="/spring/test3"> <!-- form태그에서 get방식은 method 생략 가능 -->
	<input type="text" name="id" placeholder="id"><br>
	<input type="password" name="pw" placeholder="pw"><br>
	<button type="submit">확인</button>
</form>
</body>
</html>
<!-- 이 파일 저장할 때 에러창 뜨면 utf-8로 저장하면 됨 -->