<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- request에 저장된 속성 a 확인 --%>
	<h1>${a}</h1>

	<%-- request에 저장된 속성 x, y의 크기 비교 연산 --%>
	<ul>
		<li>${x lt y}</li>
		<li>${x le y}</li>
		<li>${x gt y}</li>
		<li>${x ge y}</li>
	</ul>
</body>
</html>