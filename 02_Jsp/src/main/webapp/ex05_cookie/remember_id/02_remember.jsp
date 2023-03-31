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
		request.setCharacterEncoding("UTF-8");
	
		// 입력란 입력이 없는 상태로 서브밋하면 빈 문자열("")로 인식한다.
		String id = request.getParameter("id");
		
		// 체크박스를 해제한 상태로 서브밋하면 null값으로 인식한다.
		String chkRememberId = request.getParameter("chk_remember_id");
		
		// 아이디 기억하기를 체크했다면 chkRememberId가 null이 아니다.
		if(chkRememberId != null){
			Cookie cookie = new Cookie("remember_id", id);
			cookie.setMaxAge(60 * 60 * 24 * 30);  // 30일 유지
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember_id", id);
			cookie.setMaxAge(0);  // 0초 유지, 즉 삭제
			response.addCookie(cookie);
		}
		
		// 다시 로그인 화면으로 이동하기
		response.sendRedirect("01_form.jsp");
		
	%>
</body>
</html>