<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div>
	<h1>
		Hello world!  
	</h1>
</div>
<script>
	$(function)({
		/*
		acync: 비동기이면 true, 동기이면 false
		비동기: ajax가 끝나지 않아도 다음 코드가 실행
		동기: ajax가 완료되어야 다음 코드가 실행
		date: 서버로 보낼 데이터
		url: 데이터를 보낼 서버 url
		dataType: 서버에서 보내준 데이터의 타입
		contentType: 서버에 보낼 데이터 타입(위의 data타입)
		success: ajax를 이용하여 서버에 데이터 전송 후 서버에서 데이터를 처리한 후 성공햇을 때 호출되는 함수
		 -res:서버에서 화면으로 보낸 데이터
		*/
		$.ajax({
	        async:false,
	        type:'POST',
	        data:"sample",
	        url:"<%=request.getContextPath()%>/ajax/test2",
	        dataType:"json",
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
	            console.log(res);
	            console.log('주소: '+ res.address);
	            console.log('주소: '+ ress['address'])
	        }
	    });
		console.log(123)
		$.ajax({
	        async:false,
	        type:'POST',
	        data:JSON.stringify{id: "아이디", pw:"비번" },
	        url:"<%=request.getContextPath()%>/ajax/test3",
	        dataType:"json",
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
	            console.log(res);
	            console.log('주소: '+ res.address);
	            console.log('주소: '+ ress['address'])
	            console.log('id : '+res.data.id);
	            console.log('pw : '+res.data.pw);
	        }
	    });
		console.log(123)
	});
</script>
</body>
</html>
