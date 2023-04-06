<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	function goList(){
		location.href = '${contextPath}/list.do';
	}
</script>
</head>
<body>

	<div>
		<h1>BBS 작성</h1>
	</div>
	<div>
		<form method="post" action="${contextPath}/add.do">
		<div>
			<input type="text" name="title" placeholder="제목">
		</div>
		<div>
			<textarea rows="5" cols="30" name="content" placeholder="내용"></textarea>
		</div>
		<div>
			<button>작성완료</button>
			<input type="button" value="목록" onclick="goList()">
		</div>
		</form>
	</div>
	
</body>
</html>