<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSP 주석 --%>

<%-- JSP : Java Server Page --%>
<%-- ㄴ html 문서 안에 Java 언어를 사용함 --%>

<h1>hello jsp world</h1>

<%
// 태그명 : 스크립틀릿
// ㄴ 이 태그 안에 Java Language를 작성할 수 있음

System.out.println("server page run success!");
%>

<form method="get" actoin="indexPro.jsp">
	<input type="text" name="name" placeholder="name">
	<input type="submit">
</form>

</body>
</html>