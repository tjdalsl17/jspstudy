<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

	<c:choose>
		<c:when test="${sessionScope.loginId == null}">
			<div>
				<form method="post" action="${contextPath}/ex07_jstl/practice01_login/02_login.jsp">
					<div><input type="text" name="id" placeholder="아이디"></div>
					<div><input type="password" name="pw" placeholder="비밀번호"></div>
					<div><button>로그인</button></div>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				${sessionScope.loginId}님 반갑습니다.
				<input type="button" value="로그아웃" id="btn_logout">
			</div>
		</c:otherwise>
	</c:choose>
	
	<script>
		$('#btn_logout').on('click', function(){
			location.href = '${contextPath}/ex07_jstl/practice01_login/03_logout.jsp';
		})
	</script>

</body>
</html>