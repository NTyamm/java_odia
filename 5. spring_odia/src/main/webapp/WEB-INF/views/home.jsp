<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<!-- DOCTYPE html은 이 파일이 html5 파일이라고 적어주는 것 -->
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- ${kk}는 서버에서 화면으로 보낸 데이터, 컨트롤러에서 화면으로 보낸 데이터.. 
중괄호 안을 비워두면 주석이 아니라 빈 걸로 인식해서 에러나니까 임의로 영문 채워둔 상태
홈 컨트롤러에서 지정한 이름이 {}안의 이름과 일치하는지 봐야 함-->

<P>  The time on the server is ${serverTime}. </P>
<a href="/spring/test?num=1&name=홍길동">데이터 전송</a>
<form action="/spring/test/form" method="get">
	<h1>Get 방식으로 전송</h1>
	<input type="text" name="num" placeholder="번호"><br>
	<input type="text" name="name" placeholder="이름"><br>
	<button type="submit">전송</button>
</form>
<form action="/spring/test/form" method="post">
	<h1>Post 방식으로 전송</h1>
	<input type="text" name="num" placeholder="번호"><br>
	<input type="text" name="name" placeholder="이름"><br>
	<button type="submit">전송</button>
</form>
</body>
</html>
<!-- 이 파일 저장할 때 에러창 뜨면 utf-8로 저장하면 됨 -->