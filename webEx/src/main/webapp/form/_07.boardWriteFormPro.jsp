<%@page import="exWeb.BoardDAO"%>
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
	BoardDAO dao = BoardDAO.getInstance();
	BoardDTO board = null;
	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	
	int no = dao.getSize();
	int code = dao.getCode();
	System.out.println(no);
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	
	
	// board = new BoardDTO(no, code, title, contents, viewCnt, likeCnt, createAt, modifiedAt);
	
	if(dao.addBoard(board) != 0){
		
	}
	else{
		
	}
	
	
	%>
</body>
</html>