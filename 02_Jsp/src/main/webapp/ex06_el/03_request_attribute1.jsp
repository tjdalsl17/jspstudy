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
		// request에 속성 a 저장하기
		request.setAttribute("a", 1);
	
		// request에 속성 x, y 저장하기(연산 확인용)
		request.setAttribute("x", 10);
		request.setAttribute("y", 5);
	
		// request를 전달하는 forward
		request.getRequestDispatcher("03_request_attribute2.jsp").forward(request, response);
	%>
	
	<%--
		참고. forward를 수행하는 Jsp 액션 태그
		<jsp:forward page="03_request_attribute2.jsp"></jsp:forward>
	--%>

</body>
</html>