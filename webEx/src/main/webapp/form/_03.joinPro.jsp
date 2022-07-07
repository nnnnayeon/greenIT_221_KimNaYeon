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
	//요청 받은 데이터에 대한 컨트롤 -> 자바를 통함
	
	// 자바빈 : 요청된 데이터에 대한 자료 처리 방식
	// ㄴ VO : read-only
	// ㄴ DTO : 요청 데이터를 -> 트랜잭션 처리하기 위한 임시 객체
	
	// ㄴ DAO : 연동된 데이터(중앙)에 대한 요청 내용 실제 처리 해주는 
	// ㄴ Singletone 패턴 적영 
	UserDAO dao = UserDAO.getInstance();
	UserDTO user = null;
	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String[] password = request.getParameterValues("password");
	String name = request.getParameter("name");
	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int day = Integer.parseInt(request.getParameter("day"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	String mobile = request.getParameter("mobile");
	
	user = new UserDTO(id, password[0], name, year, month, day, gender, email, country, mobile);
	
	String url = "";
	if(!dao.addUser(user)){
		// 중복으로 인한 회원가입 실패
		// join.jsp
		System.out.println("회원가입 실패");
		url = "_02.join.jsp";
	}
	else{
		// 회원가입 성공
		// login.jsp 로 페이지 이동
		System.out.println("회원가입 성공");
		url = "_00.index.jsp";
	}
	response.sendRedirect(url);
	%>
</body>
</html>