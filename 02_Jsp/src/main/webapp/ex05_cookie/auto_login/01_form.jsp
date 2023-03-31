<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

<%
	// 자동 로그인 확인
	// 쿠키에 session_id, login_id가 있으면 자동 로그인을 해야 한다.
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		outer: 
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("session_id")){
				for(int j = 0; j < cookies.length; j++){
					if(cookies[j].getName().equals("login_id")){
						session.setAttribute("loginId", cookies[j].getValue());	// 쿠키에 저장된 사용자 아이디로 로그인 처리하기
						break outer;
					}
				}
			}
		}
	}
%>
	
	<% if(session.getAttribute("loginId") == null) { %>
	<div>
		<form method="post" action="02_login.jsp">
			<div><input type="text" name="id" placeholder="아이디"></div>
			<div><input type="password" name="pw" placeholder="비밀번호"></div>
			<div>
				<input type="checkbox" name="chk_auto_login" id="chk_auto_login">
				<label for="chk_auto_login">자동 로그인</label>
			</div>
			<div><button>로그인</button></div>
		</form>		
	</div>
	
<% } else { %>
	<div>
		<%=session.getAttribute("loginId")%>님 반갑습니다
		<input type="button" value="로그아웃" onclick="fnLogout()">
	</div>
<% } %>

<script>
	function fnLogout(){
	location.href = '03_logout.jsp';
}
</script>
</body>
</html>