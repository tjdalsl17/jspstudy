<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${today != null}">
	<h1>오늘은 ${today}입니다.</h1>
	</c:if>
	<c:if test="${age != null}">
		<h1>나이는 ${age}살입니다.</h1>
	</c:if>
</body>
</html>