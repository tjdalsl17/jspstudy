<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		// session에 저장된 cart 속성 지우기
		session.removeAttribute("cart");
	
		// 장바구니 목록 확인하러 가기
		response.sendRedirect("03_cart_list.jsp");
	%>

</body>
</html>