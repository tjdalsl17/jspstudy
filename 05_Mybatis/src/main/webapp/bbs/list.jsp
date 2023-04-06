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
	$(function(){
		$('.bbs').on('click', function(){ // 클릭한 하나의 div 클래스 -> this
			location.href = '${contextPath}/detail.do?bbsNo=' + $(this).data('bbs_no'); // 데이터 속성의 변수이름(bbs_no)
		})
	})
</script>
</head>
<body>

<div><h1>BBS 목록</h1></div>
	<div>
		<c:forEach var="bbs" items="${bbsList}">
			<div class="bbs" data-bbs_no="${bbs.bbsNo}">
				<span>${bbs.title}</span>
				<span>...</span>
				<span>${bbs.createdDate}</span>
			</div>		
		</c:forEach>
	</div>
	<div>
		<a href="${contextPath}/write.do">작성하러 가기</a>
	</div>

</body>
</html>