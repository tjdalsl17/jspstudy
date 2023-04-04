<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="${contextPath}/login.user">
		<div><input type="text" name="id" placeholder="아이디"></div>
		<div><input type="password" name="pw" placeholder="비밀번호"></div>
		<div><button>로그인</button></div>
	</form>
</body>
</html>