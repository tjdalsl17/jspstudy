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

	<c:set var="n" value="12345.678" scope="page" />
	
	<%-- 천 단위 구분기호 사용하기 --%>
	<h1><fmt:formatNumber value="${n}" pattern="#,##0" /></h1>
	<h1><fmt:formatNumber value="${n}" pattern="#,##0.00" /></h1>
	
	<%-- 백분율 : 숫자에 100을 곱한 뒤 %를 붙인다. --%>
	<h1><fmt:formatNumber value="${n}" type="percent" /></h1>
	
	<%-- 통화 : 통화 기호와 천 단위 구분기호를 모두 사용한다. --%>
	<h1><fmt:formatNumber value="${n}" type="currency" currencySymbol="￦" /></h1>
	<h1><fmt:formatNumber value="${n}" type="currency" currencySymbol="$" /></h1>
</body>
</html>