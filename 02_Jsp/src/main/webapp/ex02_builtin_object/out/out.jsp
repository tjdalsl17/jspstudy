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
		String[] seasons = {"spring", "summer", "autumn", "winter"};
	%>
	
	<ul>
		<% for(int i = 0; i < seasons.length; i++){%>
			<li><%=seasons[i] %></li>
		<% } %>
	</ul>
	
	<hr>
	
	<%-- out 객체 활용하기 --%>
	<ul>
		<%
			for(int i = 0; i < seasons.length; i++){
				out.println("<li>" + seasons[i] + "</li>");
			}
		
		%>
	</ul>

</body>
</html>