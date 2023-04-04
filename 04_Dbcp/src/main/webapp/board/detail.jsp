<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" scope="page"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

	<div>
		<h1>게시글 상세보기</h1>
		<form method="post" action="${contextPath}/modifyBoard.do">
		<div>수정일 <fmt:formatDate value="${board.modified_date}" pattern="yy.MM.dd HH:mm:ss"/></div>
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" value="${board.title}">
			</div>
			<div>
				<textarea name="content" rows="5" cols="30" placeholder="내용">${board.content}</textarea>
			</div>
			<div>
				<input type="hidden" name="board_no" value="${board.board_no}">
				<button>수정하기</button>
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
</body>
</html>