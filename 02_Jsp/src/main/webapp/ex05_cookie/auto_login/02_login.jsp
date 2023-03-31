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
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String chkAutoLogin = request.getParameter("chk_auto_login");
		
		// id="admin", pw="1234"이면 로그인 성공
		if(id.equals("admin") && pw.equals("1234")){
			
			// 자동 로그인을 체크했다면 chkAutoLogin이 null이 아니다.
			if(chkAutoLogin != null){
				
			// 자동 로그인 처리를 위한 쿠키 생성
			// session의 id를(사용자의 id가 아님) 쿠키에 저장한다.
			Cookie cookie1 = new Cookie("session_id", "");
			cookie1.setMaxAge(60 * 60 * 24 * 30);
			cookie1.setPath(request.getContextPath());
			response.addCookie(cookie1);
			
			// 사용자 id를 쿠키에 저장한다.
			Cookie cookie2 = new Cookie("login_id",id);
			cookie2.setMaxAge(60 * 60 * 24 * 30);
			cookie2.setPath(request.getContextPath());
			response.addCookie(cookie2);
			
			
				
			} else {
				
			// 자동 로그인 처리를 위한 쿠키 삭제
				
			// session_id 쿠키를 삭제한다.
			Cookie cookie1 = new Cookie("session_id", session.getId());
			cookie1.setMaxAge(60 * 60 * 24 * 30);
			cookie1.setPath(request.getContextPath());
			response.addCookie(cookie1);
			
			// login_id 쿠키를 삭제한다.
			Cookie cookie2 = new Cookie("login_id", session.getId());
			cookie1.setMaxAge(60 * 60 * 24 * 30);
			cookie1.setPath(request.getContextPath());
			response.addCookie(cookie1);
				
				// 일반 로그인 처리
				session.setAttribute("loginId", id);
			}
			
		}
		
		// 다시 로그인 화면으로 돌아가기
		response.sendRedirect("01_form.jsp");
	%>

</body>
</html>