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
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	UserDTO user = new UserDTO(id, password);
	
	String url = "";
	if(!dao.loginUser(id, password)){
		System.out.println("로그인 실패");
		url = "_00.index.jsp";
	}
	else{
		System.out.println("로그인 성공");
		url = "_04.main.jsp";
	}
	
	// 단순 리다이렉트
	// 단순 페이지 이동
	response.sendRedirect(url);
	
	session.setAttribute("log",user.getId());
	
	// 2. 이전 페이지에서 갖고 온 request & response 객체를 그대로 다음페이지에 전달
		/* request.setAttribute("log", user.getId());
			request.getRequestDispatcher(url).forward(request,response); */
	// 3. 톰캣 세션을 활용한 session에 로그 정보 넣기
		// session.setAttribute("log",user.getId());
	%>

</body>
</html>