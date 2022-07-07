<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP 주석 --%>
	<%
		// JSP : Java Server Page
		// ㄴ html 문서 안에 Java 문법을 작성 할 수 O
		System.out.println("여기에 자바 문법을 작성할 수 있다.");
		out.print("<h1>안녕 지구</h1>");
		
		String name = "김나연";
	%>
	
	<!-- html 태그 안에서 jsp 태그로 java 변수 가져오기 -->
	<h1><%= name%> 님 환영합니다.</h1>
	
	<%
	if(name.equals("김나연")) %>
	<h1><%= name %>님 환영합니다.</h1>

	
</body>
</html>