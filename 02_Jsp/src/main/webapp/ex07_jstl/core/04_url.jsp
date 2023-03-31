<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%-- c:url 태그를 쓰면 contextPath를 작성하지 않는다. --%>
<script src="<c:url value="/resources/js/lib/jquery-3.6.4.min.js" />"></script>
<% pageContext.setAttribute("now", System.currentTimeMillis()); %>
<%-- 파라미터 dt를 현재 시간(타임스탬프)으로 전달하면 실행할 때마다 경로가 변하기 때문에 매번 js 파일을 읽는다.--%>
<script src="
	<c:url value="04_url.js">
		<c:param name="dt" value="${now}"/>
	</c:url>">
</script>
</head>
<body>

	<%--
		<c:url>
		1. 경로를 작성하는 태그이다.
		2. 컨텍스트 패스가 자동으로 포함된다.
		3. 파라미터를 추가할 수 있다.
		4. 형식
			1) <c:url value="경로"></c:url>
			2) <c:url value="경로" />
			3) <c:url value="경로"><c:param name="파라미터" value="값"></c:param></c:url>
			3) <c:url value="경로"><c:param name="파라미터" value="값" /></c:url>
	--%>
	

</body>
</html>