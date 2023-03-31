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
	// session의 모든 속성 지우기
	session.invalidate();

	// session_id 쿠키를 삭제한다.
	Cookie cookie1 = new Cookie("session_id", "");
	cookie1.setMaxAge(0);
	cookie1.setPath(request.getContextPath());
	response.addCookie(cookie1);

	// login_id 쿠키를 삭제한다.
	Cookie cookie2 = new Cookie("login_id", "");
	cookie2.setMaxAge(0);
	cookie2.setPath(request.getContextPath());
	response.addCookie(cookie2);

	// 다시 로그인 화면으로 이동하기
	response.sendRedirect("01_form.jsp");
%>

</body>
</html>