<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// ../indexPro.jsp?id=***
	System.out.println(request.getParameter("id"));
	String id = (String) request.getParameter("id");	// 이전 페이지로부터 받은 요청 확인
	response.getWriter().println(id);					// 응답
	%>

</body>
</html>