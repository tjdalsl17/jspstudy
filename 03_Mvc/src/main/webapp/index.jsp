<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> <!-- contextPath를 사용하는 이유는 ${contextPath} EL태그로 사용하려고 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><a href="${contextPath}/TodayServlet">오늘은 며칠입니까?</a></h3> <!-- a태그로 전달되니까 doget에서 받는다 -->
	
	<form action="${contextPath}/AgeServlet">
		<select name="birthyear">
			<c:forEach var="y" begin="1923" end="2023" step="1">
				<option value="${y}"> ${y}년 </option>
			</c:forEach>
		</select>
		<button>몇 살입니까?</button>
	</form>
	

</body>
</html>