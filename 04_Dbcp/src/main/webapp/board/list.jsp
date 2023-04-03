<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" scope="page"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	$(function(){
		// 작성 화면으로 이동
		$('#btn_write').on('click', function(){
			location.href = '${contextPath}/writeBoard.do';
		})
	})
</script>
</head>
<body>
	<div>
		<h1>게시글 목록</h1>
		<div>
			<input type="button" value="작성하기" id="btn_write">
		</div>
		<div>
			<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성일자</td>
					<td>삭제</td>
				</tr>
			</thead>
				<tbody>
					<c:forEach items = "${boardList}" var="board">
					<tr>
						<td>${board.board_no}</td>
						<td>${board.title}</td>
						<td>${board.created_date}</td>
						<td><a href="#"><i class="fa-solid fa-x"></i></a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>