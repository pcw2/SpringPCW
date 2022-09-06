<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1 align="center">핸들러 메소드의 파라미터와 어노테이션</h1>

	<h3>1. HttpServletRequest로 요청 파라미터 전달 받기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/first/regist'">파라미터 전달 받기</button>
	
	<h3>2. @RequestParam 이용하여 파라미터 전달 받기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/first/modifiy'">@RequestParam 이용하기</button>

</body>
</html>