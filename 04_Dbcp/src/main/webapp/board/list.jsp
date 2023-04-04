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
		// 삭제 링크 클릭
		$('.link_remove').on('click', function(event){
			if(confirm('삭제할까요?') == false){
				event.preventDefault();		// <button> 태그의 기본 동작인 submit 속성의 동작을 막는다.
				return;
			}
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
					<c:forEach items = "${boardList}" var="board" varStatus="vs">
					<tr>
						<td><fmt:formatNumber value="${boardListCount - vs.index}" pattern="#,##0" /></td>
						<td><a href="${contextPath}/getBoardByNo.do?board_no=${board.board_no}">${board.title}</td>
						<td><fmt:formatDate value="${board.created_date}" pattern="yy.MM.dd"/></td>
						<td>
							<form method="post" action="${contextPath}/removeBoard.do">
								<input type="hidden" name="board_no" value="${board.board_no}">
								<button class="link_remove"><i class="fa-solid fa-x"></i></button>
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>