<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	

	<c:set var="now" value="<%=new Date()%>" scope="page" />
	
	<h1><fmt:formatDate value="${now}" pattern="yyyy-MM-dd E요일" /></h1>
	<h1><fmt:formatDate value="${now}" pattern="a h:mm:ss" /></h1>
	<h1><fmt:formatDate value="${now}" pattern="H:mm:ss"/></h1>
	

</body>
</html>