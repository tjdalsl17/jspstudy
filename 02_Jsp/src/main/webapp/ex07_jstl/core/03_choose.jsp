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

	<%--
		<c:choose></c:choose>
		1. if문을 대체하는 태그이다.
		2. 여러 조건을 처리하기에 적합하다.
		3. else if, else의 개념이 존재한다.
		4. 형식
			<c:choose>
				<c:when test="조건식1">
					실행문
				</c:when tes="조건식2">
					실행문
				</c:when>
				<c:otherwise>
					실행문
				</c:otherwise>
			</c:choose>
	 --%>
	 
	 <c:set var="age" value="24" scope="page"></c:set>
	 <c:choose>
	 	<c:when test="${age <= 7}">
	 		<c:set var="result" value="미취학아동" scope="page"></c:set>
	 	</c:when>
	 	<c:when test="${age <= 13}">
	 		<c:set var="result" value="초등학생" scope="page"></c:set>
	 	</c:when>
	 	<c:when test="${age <= 16}">
	 		<c:set var="result" value="중학생" scope="page"></c:set>
	 	</c:when>
	 	<c:when test="${age <= 19}">
	 		<c:set var="result" value="고등학생" scope="page"></c:set>
	 	</c:when>
	 	<c:otherwise>
	 		<c:set var="result" value="성인" scope="page"></c:set>
	 	</c:otherwise>
	 </c:choose>
	 
	 <h1>${age}살은 ${result}입니다.</h1>

</body>
</html>