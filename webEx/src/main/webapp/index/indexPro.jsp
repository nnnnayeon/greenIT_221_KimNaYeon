<%@page import="user.UserDTO" %>
<%@page import="user.UserDAO" %>
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
	request.setCharacterEncoding("utf-8");
	// response.setCharacterEncoding("utf-8");
	
	// 전달된 파라미터 값 가져오기
	String name = request.getParameter("name");
	System.out.println(name);
	
	// UserDAO를 통해 addUser(UserDTO userDto)
	UserDAO dao = UserDAO.getInstance();
	UserDTO user = new UserDTO(name);
	dao.addUser(user);
	
	// UserDAO를 통해 getUser
	UserDTO result = dao.getUser(name);
	System.out.println("result :" + result.getName());
	
	// 파라미터 값을 식별하고,
	// ㄴ 다음 로직에 대한 처리를 분리할 수 있음
	String url = "";
	if(name.equals("김지연")){
		url = "test1.jsp";
	}
	else{
		url = "test2.jsp";
	}
	
	// 1. 단순 페이지 이동
	// https://localhost:8081/webProject/test1.jsp
	// response.sendRedirect(url);
	
	// 2. 디스패처를 활용한 포워딩
	// https://localhost:8081/webProject/indexPro.jsp
	request.getRequestDispatcher(url).forward(request, response);
	%>

</body>
</html>