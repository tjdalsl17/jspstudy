<%--
	지시어(directive)
	1. page 지시어		: page 설정, import 등
	2. include 지시어	: 다른 Jsp를 포함
	3. taglib 지시어	: JSTL/EL 포함
 --%>

<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- JSP 주석 : HTML 주석과 달리 "페이지 소스 보기"에서 보이지 않는다. --%>
	
	<%-- 스크립트릿(scriptlet) : 일반 자바 코드 --%>
	<%
		int a = 1;
	%>
	
	<%-- 표현식(expression) : 변수 값, 메소드 호출 결과 --%>
	<h1>a = <%=a%></h1>
	
	<%-- 선언부(declaration) : 메소드 정의 --%>
	
	
	<%!
		public int getNumber(){
		return (int)(Math.random() * 10);	// 0 ~ 9 중 하나
		}
	%>
	<h1>발생한 난수 : <%=getNumber() %></h1>
	
	<%-- page 지시어(directive)의 import 속성 확인을 위한 LocalDate 클래스 사용 --%>
	<%
		LocalDate today = LocalDate.now();
	%>
	<h1>현재 날짜 : <%=today%></h1>
	
	
	<hr>
	
	<%--
		Java와 Javascript의 사용
		1. Java 변수를 Javascript에서 사용할 수 있!다! 있다고
		2. JavaScript 변수를 Java에서 사용할 수 없다.	
	 --%>
	 
	 <%-- Java 변수를 JavaScript에서 가져다 사용하기 --%>
	 <% String str = "Hello World"; %>
	 <script>
	 	alert('<%=str%>');
	 </script>
	 
	 <hr>
	 
	 
	 <%-- 연습1. getNumber() 메소드의 반환 결과가 5 이상이면 "큰 수", 아니면 "작은 수"를 출력하시오. --%>
	 <% if(getNumber() >= 5) { %>
	 	<h1>큰 수</h1>
	 <% } else { %>
	 	<h1>작은 수</h1>
	 <% } %>
	 
	 
	 
	 <%-- 연습2. 1월~12월이 표시되는 <select> 태그를 작성하시오. --%>
	 
	<select name="month">
        <%for(int m = 1; m <= 12; m++) { %>
        	<option value="<%=m%>"><%=m %>월</option>
     <% } %>
     </select>
	
	
</body>
</html>