<%@page import="exWeb.UserDTO" %>
<%@page import="exWeb.UserDAO" %>
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
	UserDAO dao = UserDAO.getInstance();
	UserDTO user=null;
		
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	user =new UserDTO(id,pw);
	String url="";
	/*
	if(dao.loginCheck(user)){ 
		url="_04.main.jsp";
		session.setAttribute("log",user.getId());
		System.out.println("로그인");
	}else{
		url="_00.index.jsp";
		System.out.println("ㅠㅠ");
	}
	*/
	
	// 1. 단순 리다이렉트
	 response.sendRedirect(url);
	
	// 2. 이전 페이지에서 갖고 온 request & response 객체를 그대로 다음페이지에 전달
		/* request.setAttribute("log", user.getId());
		request.getRequestDispatcher(url).forward(request,response); */
	// 3. 톰캣 세션을 활용한 session에 로그 정보 넣기
		// session.setAttribute("log",user.getId());
	%>
</body>
</html>