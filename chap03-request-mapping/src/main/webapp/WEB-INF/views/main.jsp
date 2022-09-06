<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Mapping 테스트</title>
</head>
<body>
	<h1 align="center">Spring MVC Mapping 테스트</h1>
	
	<h2>1. 메소드에 요청 매핑하기</h2>
	<h3>GET : /menu/regist</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/regist'">GET 메뉴 등록 요청</button>	

	<h3>POST : /menu/regist</h3>
	<form action="${pageContext.servletContext.contextPath }/menu/regist" method="POST">
		<button type="submit">POST 메뉴 등록 요청</button>
	</form>








</body>
</html>