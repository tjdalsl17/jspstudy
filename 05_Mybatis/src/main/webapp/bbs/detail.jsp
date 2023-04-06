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
</head>
<body>
<script>
		function goEdit(){
			location.href = '${contextPath}/edit.do?bbsNo=${bbs.bbsNo}';
		}
		function goRemove(){
			if(confirm('삭제 하시겠습니까?')){
				$('#frm_remove').submit();
			}
		}
		function goList(){
			location.href = '${contextPath}/list.do';
		}

</script>
	<div>
		<h1>BBS 상세</h1>
	</div>
	<div>
		<div>BBS_NO : ${bbs.bbsNo}</div>
		<div>TITLE : ${bbs.title}</div>
		<div>CREATED_DATE : ${bbs.createdDate}</div>
		<div>MODIFIED_DATE : ${bbs.modifiedDate == null ? '없음' : bbs.modifiedDate}</div>
		<pre>${bbs.content}</pre>
	</div>
	<div>
		<input type="button" value="편집" onclick="goEdit()">
		<input type="button" value="삭제" onclick="goRemove()">
		<input type="button" value="목록" onclick="goList()">
		<form id="frm_remove" method="post" action="${contextPath}/remove.do">
			<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
		</form>
	</div>

</body>
</html>