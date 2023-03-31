<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		Jsp의 binding (속성을 저장할 수 있는 영역)
		1. pageContext : this 	현재 Jsp 페이지에서 접근할 수 있다.
		2. request 	   : HttpServletRequest, 하나의 요청에서 접근할 수 있다.
		3. session 	   : HttpSession, 		 브라우저 종료까지 접근할 수 있다.
		4. applictaion : ServletContext, 	 애플리케이션 종료까지 접근할 수 있다.
	--%>
	<%--
		Jsp binding 우선 순위
		1. 같은 이름의 속성이 서로 다른 영역에 저장될 수 있다.
		2. 접근 범위(Scope)가 좁을수록 높은 우선 순위를 가진다.
			높음									낮음
			pageContext > request > session > application
		3. 각 영역을 지정하는 표현언어(EL) 내장 객체가 있다.
			1) pageContext : pageScope
			2) request 	   : requestScope
			3) session	   : sessionScope
			4) application : applicationScope		
	 --%>
	 
	 <%
	 	pageContext.setAttribute("a", 1);
	 	request.setAttribute("a", 10);
	 	session.setAttribute("a", 100);
	 	application.setAttribute("a", 1000);
	 %>
	 
	 <h1><%=pageContext.getAttribute("a")%></h1>
	 <h1><%=request.getAttribute("a")%></h1>
	 <h1><%=session.getAttribute("a")%></h1>
	 <h1><%=application.getAttribute("a")%></h1>

</body>
</html>