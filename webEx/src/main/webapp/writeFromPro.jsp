<%@page import="java.util.Random"%>
<%@page import="exWeb.BoardDAO" %>
<%@page import="exWeb.BoardDTO" %>
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
	Random ran = new Random();
	BoardDAO dao = BoardDAO.getInstance();
	
	// int code = dao.getCode(ran.nextInt(8999)+1000);
	
	
%>
</body>
</html>