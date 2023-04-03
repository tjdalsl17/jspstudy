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
<script>
	$(function(){
		// 서브밋
		$('#frm_write').on('submit', function(event){
			if($('#title').val() === ''){
				alert('제목은 필수입니다.');
				event.preventDefault(); // 서브밋 방지
				return;
			}
		})
		
		// 목록
		$('#btn_list').on('click', function(){
			location.href = '${contextPath}/getAllBoardList.do';
		})
	})
	
</script>
</head>
<body>
	<div>
		<h1>게시글 작성</h1>
		<form id="frm_write" method="post" action="${contextPath}/addBoard.do">
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title">
			</div>
			<div>
				<textarea name="content" rows="5" cols="30" placeholder="내용"></textarea>
			</div>
			<div>
				<button>작성완료</button>
				<input type="reset" value="다시작성">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
		
	</div>
</body>
</html>