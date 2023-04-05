<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	$(function() {
	$('#btn_remove').click(function(){
		if(confirm('삭제할까요?')){
			location.href = '${contextPath}/delete.post?post_no=${post.post_no}';
			
			}
		})
		
	})
</script>
</head>
<body>

	<a href="${contextPath}/write.post">새 포스트 작성</a>
	
	<hr>

	<div class="container">
			<ul>
				<li>포스트 번호 ${post.post_no}</li>
				<li>작성자 ${post.writer}</li>
				<li>제목 ${post.title}</li>
				<li>IP ${post.ip}</li>
				<li>작성일 ${post.created_date}</li>
				<li>수정일 ${post.modified_date}</li>
				<li>${post.content}</li>
			</ul>
	</div>
	
	<div>
		<button id="btn_remove">삭제</button>
	</div>
</body>
</html>